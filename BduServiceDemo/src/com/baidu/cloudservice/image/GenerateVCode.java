package com.baidu.cloudservice.image;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.baidu.bae.api.factory.BaeFactory;
import com.baidu.bae.api.memcache.BaeMemcachedClient;
import com.baidu.bae.api.image.*;
import java.io.IOException;
import java.io.BufferedOutputStream;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.Map;
import java.util.Collection;
import java.io.PrintWriter;
public class GenerateVCode extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Logger logger = Logger. getLogger("qrcode");
        try {
			//获取服务类对象
			BaeImageService service = BaeFactory.getBaeImageService();
			VCode vc = new VCode();
			vc.setLen(5);
			Map<String,String> data = service.generateVCode(vc);
          	BaeMemcachedClient memcache = BaeFactory.getBaeMemcachedClient();
          	memcache.delete("imgurl");
          	memcache.delete("secret");
          	memcache.add("imgurl", data.get("imgurl"));
          	memcache.add("secret", data.get("secret"));
			resp.getWriter().println("imgurl:" + data.get("imgurl"));
			resp.getWriter().println("secret:" + data.get("secret"));
          	resp.sendRedirect("/static/verify.jsp");
		} catch (Exception e) {
			logger.log(Level.WARNING, e.toString());
		}
	}
}

