package com.aaa.rest;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/services")
public class RESTEasyServices {

	@GET
	@Path("hey")
	@RolesAllowed("administrator")  // ---ич
	public String sayYo(){
		return "Hey Yo, What's up!";
	}
	
	@GET
	@Path("hello")
	@PermitAll // --- иш
	public String sayHello(){
		return "Hello World !";
	}
	
	@GET
	@Path("bye")
	@DenyAll // --- ищ
	public String sayGoodBye(){
		return "GoodBye World !";
	}
}
