package com.baidu.cloudservice.socket;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
/**
 * Socket代理示例，该示例使用Socket实现了HTTP请求
 */
public class BaeSocketProxyBasic extends HttpServlet { 
 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Logger logger = Logger. getLogger("socket");
        try {
				/*****1. 创建一个SOCKET代理*****/
          		Socket s = new Socket("www.baidu.com",80);
				BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream(),"GBK"));
				OutputStream out = s.getOutputStream();
          		/*****2. 构造一个请求*****/
				StringBuffer sb = new StringBuffer("GET /index.html HTTP/1.1\r\n");        
				sb.append("User-Agent: Java/1.6.0_20\r\n");
				sb.append("Host: www.baidu.com\r\n");
				sb.append("Accept: text/html, image/gif, image/jpeg, *; q=.2, */*; q=.2\r\n");
				sb.append("Connection: Close\r\n");
				sb.append("\r\n");
 				out.write(sb.toString().getBytes());
				String tmp = "";
          		/*****3. 获取返回结果*****/
				while((tmp = br.readLine())!=null){
    				resp.getWriter().println(tmp);
				}
				out.close();
				br.close();
		} catch (Exception e) {
			logger.log(Level.WARNING, e.toString());
		}
	}

}