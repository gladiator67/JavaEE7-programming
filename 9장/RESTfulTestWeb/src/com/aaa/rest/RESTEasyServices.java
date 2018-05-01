package com.aaa.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/services")
public class RESTEasyServices {

   @GET
   @Path("hello")
   public String helloworld(){
      return "Hello World !";
   }

   @GET
   @Path("getXml/{id}")
   //@Produces("application/xml" + ";charset=utf-8")
   @Produces(MediaType.APPLICATION_XML+ ";charset=utf-8")
   public Member sayXmlHello(@PathParam("id") String id){
      Member m = new Member();
      m.setId(id);
      m.setPasswd("bbb");
      m.setAge(45);
      m.setName("¿Ë³à");
		
      return m;
   }
	
   @GET
   @Path("getJson/{id}")
   @Produces(MediaType.APPLICATION_JSON+ ";charset=utf-8")
   public Member sayJsonHello(@PathParam("id") String id){
      Member m = new Member();
      m.setId(id);
      m.setPasswd("aaa");
      m.setAge(45);
      m.setName("º¯°­¼è");
		
      return m;
   }
}
