package com.openteam.sample.service.impl;

import com.openteam.sample.bean.MomentBean;
import com.openteam.sample.dao.MomentDao;
import com.openteam.sample.service.MomentService;

public class MomentServiceImpl implements MomentService {
	private MomentDao momentDao;

	public void setMomentDao(MomentDao momentDao) {
		this.momentDao = momentDao;
	}

	public MomentBean findMomentByUid(Long uid) {
		return this.momentDao.findMomentByUid(uid);
	}
}