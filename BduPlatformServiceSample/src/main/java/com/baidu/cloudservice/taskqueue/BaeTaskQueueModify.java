package com.baidu.cloudservice.taskqueue;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.baidu.bae.api.factory.BaeFactory;
import com.baidu.bae.api.taskqueue.BaeTaskQueue;
import com.baidu.bae.api.taskqueue.BaeTaskQueueManager;
import com.baidu.bae.api.taskqueue.QueueInfo;
import com.baidu.bae.api.taskqueue.Task;
import com.baidu.bae.api.taskqueue.FetchUrlTask;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.Map;
import java.util.HashMap;
import java.io.PrintWriter;
/**
 * BaeTaskQueue示例，该示例实现修改队列属性，访问一个已存在的TaskQueue队列等操作
 */ 
public class BaeTaskQueueModify extends HttpServlet { 
 
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
				/*3. 修改已有队列属性 */
          		Map<String, String> param = new HashMap<String, String>();
          		param.put(BaeTaskQueue.QUEUE_CONCURRENCY, "5");
          		param.put(BaeTaskQueue.QUEUE_MAX_LENGTH, "20");
				tqMgr.modify(qName, param);

				/*4. 通过队列名来访问已存在队列*/
				QueueInfo qInfo = tq.query();
          		resp.getWriter().println("Queue Name: | " + qInfo.getQueueName());
				resp.getWriter().println("Queue Type: | " + qInfo.getQueueType());
          		resp.getWriter().println("Max Length: | " + qInfo.getMaxLength() );
          		resp.getWriter().println("Max Concurrency: | " + qInfo.getConcurrency());
          		resp.getWriter().println("Task number: | " + qInfo.getTaskNum());
          		resp.getWriter().println("Time Out: | " + qInfo.getTimeOut());
				//删除队列
				tqMgr.remove(qName);
		} catch (Exception e) {
			logger.log(Level.WARNING, e.toString());
		}
	}

}