/**
 * 
 */
package com.openteam.sums.bean;

import java.util.Date;

/**
 * @author tgu011
 *
 */
public class UInfo {

	private int id;
	private int uid;
	private String name;
	private Date birthday;
	private String photo;
	
	public UInfo() {
		super();
	}
	public UInfo(int id, int uid, String name, Date birthday, String photo) {
		super();
		this.id = id;
		this.uid = uid;
		this.name = name;
		this.birthday = birthday;
		this.photo = photo;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
}
