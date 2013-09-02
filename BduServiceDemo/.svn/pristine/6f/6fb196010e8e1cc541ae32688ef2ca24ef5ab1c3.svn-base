package com.baidu.cloudservice.counter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.baidu.bae.api.factory.BaeFactory;
import com.baidu.bae.api.counter.BaeCounter;
import com.baidu.bae.api.counter.CounterInfo;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.List;
import java.util.Iterator;
import java.io.PrintWriter;
/**
 * BaeCounter示例，通过该示例可快速熟悉BaeCounter接口的使用
 */
public class BaeCounterBasic extends HttpServlet { 
 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Logger logger = Logger. getLogger("counter");
        try {
				/*****1. 从工厂中获取counter对象*****/
          		BaeCounter cr = BaeFactory.getBaeCounter();
				
          		/*****2. 开始创建，当返回错误打印出错原因*****/
				cr.register("foo1");
				cr.register("foo2");
				
          		/*****3. 对其中一个counter执行加、减、赋值操作*****/
				cr.increase("foo1",1);
				cr.decrease("foo2", 100);
				cr.set("foo1", 10000);
	
				/*****4. 查询指定counter*****/
				long ret = cr.get("foo1");
				resp.getWriter().println("The value of counter foo1 is: " + ret);
	
				/*****5. 查询开发者所有counter*****/
				List<CounterInfo> counts = cr.getList(0,10);
          		Iterator<CounterInfo> it = counts.iterator();
          		CounterInfo ci = null;
          		while(it.hasNext()){
                  	ci = it.next();
          			resp.getWriter().print("counter name: " + ci.getName() + " | ");
                  	resp.getWriter().println("counter value: " + ci.getValue());
                }

				/*****6. 删除counter*****/
				cr.remove("foo1");
				cr.remove("foo2");
		} catch (Exception e) {
			logger.log(Level.WARNING, e.toString());
		}
	}

}