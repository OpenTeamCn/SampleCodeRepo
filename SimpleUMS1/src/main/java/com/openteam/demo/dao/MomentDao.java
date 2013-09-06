package com.openteam.demo.dao;

import com.openteam.demo.bean.MomentBean;

public interface MomentDao {
	public MomentBean findMomentByUid(Long paramLong);
}