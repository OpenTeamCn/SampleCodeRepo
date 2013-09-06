package com.openteam.sample.rest;

import com.openteam.sample.bean.UserBean;
import com.openteam.sample.service.UserService;
import com.sun.jersey.spi.resource.Singleton;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.log4j.Logger;

@Singleton
@Path("/user")
public class UserResource {
	private static Logger logger = Logger.getLogger(UserResource.class);
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@GET
	@Path("{uid}")
	@Produces({ "application/xml", "application/json" })
	public UserBean getUser(@PathParam("uid") Long uid) {
		logger.info("get user by id :" + uid);
		return this.userService.findUserByUid(uid);
	}

	@GET
	@Path("list")
	@Produces({ "application/xml", "application/json" })
	public List<UserBean> getAllUser() {
		return this.userService.getAllUser();
	}

	@POST
	@Path("add")
	@Consumes("application/x-www-form-urlencoded")
	public Long addUserBean(@FormParam("name") String name,
			@FormParam("dept") String birthday) {
		UserBean user = new UserBean();
		user.setName(name);
		user.setBirthday(birthday);
		return this.userService.saveUser(user);
	}

	@DELETE
	@Path("delete/{uid}")
	@Produces({ "text/plain" })
	public Long removeUserBean(@PathParam("uid") Long uid) {
		logger.info("remove user :" + uid);
		return this.userService.removeUser(uid);
	}

	@PUT
	@Path("put")
	@Produces({ "text/plain" })
	public Long putUserBean(@QueryParam("uid") int uid,
			@QueryParam("name") String name, @QueryParam("photo") String photo) {
		logger.info("modify user:" + uid);
		UserBean bean = new UserBean();
		return this.userService.modifyUser(bean);
	}
}