package com.openteam.demo.service.impl;

import com.openteam.demo.bean.MomentBean;
import com.openteam.demo.dao.MomentDao;
import com.openteam.demo.service.MomentService;

public class MomentServiceImpl implements MomentService {
	private MomentDao momentDao;

	public void setMomentDao(MomentDao momentDao) {
		this.momentDao = momentDao;
	}

	public MomentBean findMomentByUid(Long uid) {
		return this.momentDao.findMomentByUid(uid);
	}
}