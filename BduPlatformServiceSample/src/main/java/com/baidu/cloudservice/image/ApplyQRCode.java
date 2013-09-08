package com.baidu.cloudservice.image;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.baidu.bae.api.factory.BaeFactory;
import com.baidu.bae.api.image.*;
import java.io.IOException;
import java.io.BufferedOutputStream;
import java.util.logging.Logger;
import java.util.logging.Level;

public class ApplyQRCode extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Logger logger = Logger. getLogger("qrcode");
        try {
          	
			//获取服务类对象
			BaeImageService service = BaeFactory.getBaeImageService();
			//创建二维码功能对象
          	String text ="Hello World!";
			QRCode qrcode = new QRCode(text);
			qrcode.setSize(90);
			qrcode.setBackground("AABBCC");
    		//调用二维码服务
			byte[] bs = service.applyQRCode(qrcode);
			BufferedOutputStream bos = new BufferedOutputStream(
			resp.getOutputStream());
			bos.write(bs, 0, bs.length);
			if (bos != null)
				bos.close();
			bos.flush();
		} catch (Exception e) {
			logger.log(Level.WARNING, e.toString());
		}
	}
}
