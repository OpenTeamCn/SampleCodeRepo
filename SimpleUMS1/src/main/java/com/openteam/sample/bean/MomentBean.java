package com.openteam.sample.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MomentBean {
	private Long id;
	private Long uid;
	private String moment;
	private String create_tm;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUid() {
		return this.uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getMoment() {
		return this.moment;
	}

	public void setMoment(String moment) {
		this.moment = moment;
	}

	public String getCreate_tm() {
		return this.create_tm;
	}

	public void setCreate_tm(String create_tm) {
		this.create_tm = create_tm;
	}
}