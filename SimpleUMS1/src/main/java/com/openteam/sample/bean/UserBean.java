package com.openteam.sample.bean;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserBean implements Serializable {
	private static final long serialVersionUID = 7443507269413710628L;
	private Long id;
	private Long uid;
	private String name;
	private String birthday;
	private String photo;

	public UserBean() {
	}

	public UserBean(Long id, Long uid, String name, String birthday, String photo) {
		this.id = id;
		this.uid = uid;
		this.name = name;
		this.birthday = birthday;
		this.photo = photo;
	}

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

	
	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
}