package com.baidu.cloudservice.fetchurl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.baidu.bae.api.factory.BaeFactory;
import com.baidu.bae.api.fetchurl.NameValuePair;
import com.baidu.bae.api.fetchurl.BasicNameValuePair;
import com.baidu.bae.api.fetchurl.BaeFetchurl;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Iterator;
import java.io.PrintWriter;
/**
 * BaeFetchUrl示例， 利用fetchurl sdk 抓取目标网页内容、向目标地址post数据
 */
public class BaeFetchurlBasic extends HttpServlet { 
 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Logger logger = Logger. getLogger("fetchurl");
        try {
				/*****1. 从工厂中获取fetchurl对象*****/
          		BaeFetchurl fetch = BaeFactory.getBaeFetchurl();
	
				/***************2.设置请求参数****************/
				//设置请求头参数
				fetch.setHeader("Expect", "");
				//设置最大重定向次数
				fetch.setRedirectNum(2);
				fetch.setAllowRedirect(true);
				//设置cookie
				fetch.setCookie("timestamp", System.currentTimeMillis()+ "");
	
				/***************3.发起请求****************/
	
				/****************发起一次get请求**********/
				fetch.get("http://www.baidu.com");
				resp.getWriter().println("----------Http Request(GET)----------");
				//获取http code
				int code= fetch.getHttpCode();
				resp.getWriter().println("--------------Http Code--------------");
				resp.getWriter().println(code);
				//获取返回的头部信息
				Map<String, String> header = fetch.getResponseHeader();
          		resp.getWriter().println("--------------Http Header------------");
          		for(Map.Entry me : header.entrySet()){
          			resp.getWriter().println(me.getKey() + " : " + me.getValue());
         		}
	
				//获取返回的包体长度
				int len = fetch.getResponseBodyLen();
				resp.getWriter().println("--------------Http Length------------");
          		resp.getWriter().println(len);
	
				//获取返回的包体数据
          		resp.getWriter().println("--------------Http Body------------");
				String content = fetch.getResponseBody();
				resp.getWriter().println(content);
	
				//重置url
				fetch.reset();
	
				/****************发起一次post请求**********/
				//构造post请求
				NameValuePair nvp1 = new BasicNameValuePair("user", "root");
          		NameValuePair nvp2 = new BasicNameValuePair("group", "bae");
          		NameValuePair nvp3 = new BasicNameValuePair("os", "linux");
				List<NameValuePair> postData = new ArrayList<NameValuePair>();
          		postData.add(nvp1);
          		postData.add(nvp2);
          		postData.add(nvp3);
				//设置post参数，实际post的内容
				fetch.setPostData(postData);
				//发起一次post请求
				fetch.post("http://news.baidu.com");
          		resp.getWriter().println("----------Http Request(POST)----------");
				//获取头部信息
				content= fetch.getResponseHeaderString();
				//获取返回的头部信息
				header = fetch.getResponseHeader();
          		resp.getWriter().println("--------------Http Header------------");
          		for(Map.Entry me : header.entrySet()){
          			resp.getWriter().println(me.getKey() + " : " + me.getValue());
         		}
		} catch (Exception e) {
			logger.log(Level.WARNING, e.toString());
		}
	}

}