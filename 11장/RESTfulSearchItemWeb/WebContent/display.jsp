<%@ page language="java" contentType="text/html; charset=EUC-KR"
                              pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="com.aaa.ejb3.Item"%>
<%@ page import="com.aaa.rest.*"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>
<%@ page import="javax.ws.rs.client.Entity"%>
<%@ page import="javax.ws.rs.core.Response"%>

<%@ page import="org.jboss.resteasy.client.jaxrs.ResteasyClient"%>
<%@ page import="org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder"%>
<%@ page import="org.jboss.resteasy.client.jaxrs.ResteasyWebTarget"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>결과 보기</title>
</head>
<body>
<table border=“1”>
<tr>
<td>상품이름</td>
<td>색상</td>
<td>가격</td>
<td>공급 회사</td>
</tr>
<%
String shop = request.getParameter("shop");
String urlSetItems = "http://localhost:8080/RESTfulSearchItemWeb/rest/services/setItems/" + shop;
String urlGetInfo = "http://localhost:8080/RESTfulSearchItemWeb/rest/services/getInfo/" + shop;

ResteasyClient client = new ResteasyClientBuilder().build();

ResteasyWebTarget target4SetItems = client.target(urlSetItems);
target4SetItems.request().get();

ResteasyWebTarget target4GetInfo = client.target(urlGetInfo);
Response respProd = target4GetInfo.request().get();
Products p = respProd.readEntity(Products.class);

out.println(p.getShopInfo());
for (Iterator<Item> iter = p.getItems().iterator() ; iter.hasNext() ; ) {
Item i = (Item)iter.next();
%>
<tr>
<td><%= i.getName() %></td>
<td><%= i.getColor() %></td>
<td><%= i.getPrice() %></td>
<td><%= i.getProvider() %></td>
</tr>
<%
respProd.close();
}
%>
</table>
</body>
</html>