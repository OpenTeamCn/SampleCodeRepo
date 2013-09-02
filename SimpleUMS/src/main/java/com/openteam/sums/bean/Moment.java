/**
 * 
 */
package com.openteam.sums.bean;


/**
 * @author tgu011
 *
 */
public class Moment {

	private int id;
	private int uid;
	private String moment;
	private String create_tm;
	
	public Moment() {
		super();
	}
	
	public Moment(int id, int uid, String moment, String create_tm) {
		super();
		this.id = id;
		this.uid = uid;
		this.moment = moment;
		this.create_tm = create_tm;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getMoment() {
		return moment;
	}
	public void setMoment(String moment) {
		this.moment = moment;
	}

	public String getCreate_tm() {
		return create_tm;
	}

	public void setCreate_tm(String create_tm) {
		this.create_tm = create_tm;
	}
	
}
