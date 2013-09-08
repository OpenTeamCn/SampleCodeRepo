/**
 * 
 */
package com.openteam.sample.rest;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * @author TonyGuu
 *
 */
@Path("filehandler")
public class FileHandlerResource {

    private static final String FILE_UPLOAD_PATH = "";
    private static final String SUCCESS_RESPONSE = "Successful";
    private static final String FAILED_RESPONSE = "Failed";

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces("text/plain")
    @Path("/uploadfile")
    public String uploadFile(@Context HttpServletRequest request) {

        String responseStatus = SUCCESS_RESPONSE; 
        
        //checks whether there is a file upload request or not
        if (ServletFileUpload.isMultipartContent(request)) {
            final FileItemFactory factory = new DiskFileItemFactory();
            final ServletFileUpload fileUpload = new ServletFileUpload(factory);
            try {
                
                final List<FileItem> items = fileUpload.parseRequest(request);

                if (items != null) {
                    final Iterator<FileItem> iter = items.iterator();
                    while (iter.hasNext()) {
                        final FileItem item = iter.next();
                        final String itemName = item.getName();
                        final String fieldName = item.getFieldName();
                        final String fieldValue = item.getString();

                        if (item.isFormField()) {
                            
                        } else {
                            final File savedFile = new File(FILE_UPLOAD_PATH + File.separator + itemName);
                            System.out.println("Saving the file: " + savedFile.getName());
                            item.write(savedFile);
                        }
                    }
                }
            } catch (FileUploadException fue) {
                responseStatus = FAILED_RESPONSE;
                fue.printStackTrace();
            } catch (Exception e) {
                responseStatus = FAILED_RESPONSE;
                e.printStackTrace();
            }
        }
        return responseStatus;

    }

}
