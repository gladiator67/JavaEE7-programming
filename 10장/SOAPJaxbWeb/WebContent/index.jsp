<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>

<%@ page import="com.aaa.*" %>
<%@ page import="com.aaa.Member" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>SOAP 웹 서비스 테스트 2</title>
</head>
<body>
<% 
CallMemberBeanService service = new CallMemberBeanService();
ICallMemberPort port = service.getCallMemberBeanPort();
out.println("이름 : " + port.getMember("julian").getName());
%>
</body>
</html>