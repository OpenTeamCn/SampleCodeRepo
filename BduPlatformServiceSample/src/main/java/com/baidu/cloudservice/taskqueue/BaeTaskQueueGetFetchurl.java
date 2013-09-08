package com.baidu.cloudservice.taskqueue;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.baidu.bae.api.factory.BaeFactory;
import com.baidu.bae.api.taskqueue.BaeTaskQueue;
import com.baidu.bae.api.taskqueue.BaeTaskQueueManager;
import com.baidu.bae.api.taskqueue.TaskInfo;
import com.baidu.bae.api.taskqueue.Task;
import com.baidu.bae.api.taskqueue.FetchUrlTask;
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
 * BaeTaskQueue示例，该示例实现了使用TaskQueue创建一个fetchurl任务(GET方式)，并返回结果
 */
public class BaeTaskQueueGetFetchurl extends HttpServlet { 
 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Logger logger = Logger. getLogger("urltask");
        try {
				/*****1. 从工厂中获取BaeTaskQueueManager对象*****/
          		BaeTaskQueueManager tqMgr = BaeFactory.getBaeTaskQueueManager();
	
				/*2. 创建一个FETCHURL任务类型的队列*/
				String qName = "testQueue"; 
				tqMgr.create(qName, BaeTaskQueue.TASK_FETCHURL);
	 			BaeTaskQueue tq = BaeFactory.getBaeTaskQueue(qName);
				/*3. 向队列中推送一个GET URL任务*/
				Task task = new FetchUrlTask("http://www.baidu.com");
				String id = tq.push(task);
	
				/*4. 获取结果*/
				
				//由于是异步任务，为了看到效果，这里进行了等待，但是实际情况，可以直接返回
	  			Thread.sleep(5000);
	  			TaskInfo tInfo = tq.getTaskInfo(id);
          		resp.getWriter().println("-------------Http Code---------------");
          		resp.getWriter().println(tInfo.getResult());
          		resp.getWriter().println("-------------Fetchurl Result---------------");
          		resp.getWriter().println(tInfo.getResultData());
          		resp.getWriter().println("-------------Task Description---------------");
          		resp.getWriter().println(tInfo.getTaskDesc());
				//删除队列
				tqMgr.remove(qName);
		} catch (Exception e) {
			logger.log(Level.WARNING, e.toString());
		}
	}

}