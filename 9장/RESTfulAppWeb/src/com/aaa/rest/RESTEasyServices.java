package com.aaa.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/services")
public class RESTEasyServices {
   private Member m_husband = null;
   private Member m_wife = null;
	
   public RESTEasyServices() {
      m_husband = new Member();
      m_husband.setId("aupres");
      m_husband.setPasswd("aaa");
      m_husband.setAge(45);
      m_husband.setName("º¯°­¼è");
		
      m_wife = new Member();
      m_wife.setId("hwa5383");
      m_wife.setPasswd("bbb");
      m_wife.setAge(40);
      m_wife.setName("¿Ë³à");
   }

   @GET
   @Path("getMemberJson")
   @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
   public List<Member> sayMemberJson(){
      List<Member> members = new ArrayList<Member>();
      members.add(m_husband);
      members.add(m_wife);
		
      return members;
   }
	
   @POST
   @Path("/send") 
   @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8") 
   public Response consumeJSON(Member m) { 
      String output = m.toString();
      System.out.println(output);
        
      return Response.status(200).entity(output).build();  
   } 
}
