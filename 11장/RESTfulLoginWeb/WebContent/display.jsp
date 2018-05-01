<%@ page language="java" contentType="text/html; charset=EUC-KR"
            pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="com.aaa.rest.*"%>
<%@ page import="javax.ws.rs.client.Entity"%>
<%@ page import="javax.ws.rs.core.Response"%>

<%@ page import="org.jboss.resteasy.client.jaxrs.ResteasyClient"%>
<%@ page import="org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder"%>
<%@ page import="org.jboss.resteasy.client.jaxrs.ResteasyWebTarget"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>로그인 인증</title>
</head>
<body>
<% 
String id = request.getParameter("id");
String passwd = request.getParameter("passwd");
String url = "http://localhost:8080/RESTfulLoginWeb/rest/services/login/" + id + "/" + passwd; 

ResteasyClient client = new ResteasyClientBuilder().build();
ResteasyWebTarget target = client.target(url);
Response resp = target.request().get();
//Read the entity
String str = resp.readEntity(String.class);
out.println(str);
%>
</body>
</html>