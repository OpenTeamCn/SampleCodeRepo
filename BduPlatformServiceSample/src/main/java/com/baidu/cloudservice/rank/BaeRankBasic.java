package com.baidu.cloudservice.rank;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.baidu.bae.api.factory.BaeFactory;
import com.baidu.bae.api.rank.BaeRank;
import com.baidu.bae.api.rank.BaeRankManager;
import com.baidu.bae.api.rank.BaeRankInfo;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Iterator;
import java.io.PrintWriter;
/**
 * BaeRank示例，通过该示例可熟悉Rank服务的基本使用，例如查询，设置，拉取榜单等操作
 */
public class BaeRankBasic extends HttpServlet { 
 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Logger logger = Logger. getLogger("rank");
        try {
				/*****1. 从工厂中获取RankManager对象*****/
          		BaeRankManager brm = BaeFactory.getBaeRankManager();
				
          		/*****2. 开始创建，当返回错误打印出错原因*****/
    			BaeRank br1 = brm.create("rank1",100);
          		Map<String, Object> options = new HashMap<String, Object>();
          		options.put(BaeRank.EXPIRE_TIME, 60);
          		options.put(BaeRank.ORDER, 1);
    			BaeRank br2 = brm.create("rank2",100,options);
    
    			/*****3. 判断一个rank 是否存在*****/
    			boolean ret = brm.isExist("rank2");
          		if(ret == true){
          			resp.getWriter().println("rank2 is exist!");
                }else{
                	resp.getWriter().println("rank2 is not exist!");
                }
          	
    			/*****4. 查询所有rank*****/
    			List<BaeRankInfo> ranks = brm.getList();
          		Iterator<BaeRankInfo> it = ranks.iterator();
          		BaeRankInfo bri = null;
          		String orderStr = null;
          		while(it.hasNext()){
                  	bri = it.next(); 
                  	if(bri.getOrder() == 0){
                  		orderStr = "ascend";
                  	}else{
                    	orderStr = "descend";
                    }
          			resp.getWriter().println("rank name: " + bri.getName() + " | create at " + bri.getCreateTime() + " | expire at " + bri.getExpireTime()
                                          + " | has " + bri.getKeyNum() + " keys" + " | order by " + orderStr);
                }

    			/*****5. 向rank中添加数据*****/
    			br1.set("San Antonio Spurs", 10);
    			br1.set("Dallas Mavericks", 20);
    			Map<String, Integer> data = new HashMap<String, Integer>();
          		data.put("Houston Rockets", 30);
          		data.put("Memphis Grizzlies", 40);
          		data.put("Miami Heat", 50);
          		data.put("Boston Celtics", 82);
          		br1.set(data);
 
    			/*****6. 查询sdktest1排行榜信息*****/
    			data = br1.getList();
          		resp.getWriter().println("--------NBA Rank------");	
          		for(Map.Entry me: data.entrySet()){
                  	resp.getWriter().println(me.getKey() + "   |  " + me.getValue());
         		}
    			/*****7. 操作排行榜数据*****/
    			br1.increase("Memphis Grizzlies",40);
    			br1.decrease("Miami Heat",20);
          		resp.getWriter().println("--------NBA Rank(NEW)------");
          		data = br1.getList();
          		for(Map.Entry me: data.entrySet()){
                  	resp.getWriter().println(me.getKey() + "   |  " + me.getValue());
         		}
 
    			/*****8. 清空排行榜*****/
    			br1.clear();
    			br2.clear();
    
    			/*****9. 删除排行榜*****/
   				brm.remove("rank1");
				brm.remove("rank2");
		} catch (Exception e) {
			logger.log(Level.WARNING, e.toString());
		}
	}
}