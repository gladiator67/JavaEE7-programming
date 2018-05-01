<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.aaa.rest.Member" %>

<%@page import="java.util.List" %>

<%@page import="javax.ws.rs.client.Entity" %>
<%@page import="javax.ws.rs.core.Response" %>

<%@page import="org.jboss.resteasy.client.jaxrs.ResteasyClient" %>
<%@page import="org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder" %>
<%@page import="org.jboss.resteasy.client.jaxrs.ResteasyWebTarget" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>RESTEasy 어플리케이션 테스트</title>
</head>
<body>
<% 
Member m_son = new Member();
m_son.setId("julian");
m_son.setPasswd("ccc");
m_son.setAge(15);
m_son.setName("강쇠 아들");
	
ResteasyClient client = new ResteasyClientBuilder().build();
ResteasyWebTarget target = client.target("http://localhost:8080/RESTfulAppWeb/rest/services/getMemberJson");
Response resp = target.request().get();

//Read the entity
List<Member> membersJson = resp.readEntity(List.class);
  
for(int i = 0 ; i < membersJson.size() ; i++){
   out.println(membersJson.get(i)); %><P><% 
}
resp.close();  
  
target = client.target("http://localhost:8080/RESTfulAppWeb/rest/services/send");
resp = target.request().post(Entity.entity(m_son, "application/json"));

if (response.getStatus() == 200) { 
   out.println("Server response : " + resp.readEntity(String.class)); 
} 
resp.close();
%>
</body>
</html>