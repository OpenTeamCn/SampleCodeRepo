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
import java.util.Map;
import java.util.Collection;
import java.io.PrintWriter;
public class VerifyVCode extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Logger logger = Logger. getLogger("qrcode");
        try {
			//获取服务类对象
			BaeImageService service = BaeFactory.getBaeImageService();
			VCode vc = new VCode();
          	Map<String,String[]> params = req.getParameterMap();
			String input = params.get("input")[0];//验证码输入
			String secret = params.get("secret")[0]; //验证码密文
			vc.setSecret(secret);
			vc.setInput(input);
			Map<String,String> data = service.verifyVCode(vc);
			resp.getWriter().println("status:" + data.get("status"));
			resp.getWriter().println("reason:" + data.get("reason"));
		} catch (Exception e) {
			logger.log(Level.WARNING, e.toString());
		}
	}
}
