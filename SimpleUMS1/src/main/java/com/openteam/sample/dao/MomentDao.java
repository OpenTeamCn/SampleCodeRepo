package com.openteam.sample.dao;

import com.openteam.sample.bean.MomentBean;

public interface MomentDao {
	public MomentBean getLatestMoment(Long uid);
}