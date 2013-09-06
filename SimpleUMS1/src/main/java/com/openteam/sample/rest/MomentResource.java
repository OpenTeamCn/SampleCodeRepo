package com.openteam.sample.rest;

import com.openteam.sample.bean.MomentBean;
import com.openteam.sample.service.MomentService;
import com.sun.jersey.spi.resource.Singleton;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;

@Singleton
@Path("/moment")
public class MomentResource {
    private static Logger logger = Logger.getLogger(MomentResource.class);
	private MomentService momentService;

	public void setMomentService(MomentService momentService) {
		this.momentService = momentService;
	}

	@GET
	@Path("{uid}")
	@Produces({ "application/xml", "application/json" })
	public MomentBean getMoment(@PathParam("uid") Long uid) {
		return this.momentService.findMomentByUid(uid);
	}
}