package com.aaa.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/services")
public interface ILoginPort {

   @GET
   @Path("login/{id}/{passwd}")
   public String loginFunc(@PathParam("id") String id,
                           @PathParam("passwd") String passwd);
}
