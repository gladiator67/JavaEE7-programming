package com.aaa.rest;

import javax.ejb.Local;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Local
@Path("/interface")
public interface ICallMemberPort {

	@GET
	@Path("json/{id}")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	Member getMemberJson(@PathParam("id") String id);
}
