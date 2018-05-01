<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.aaa.jms.JMSSender" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>메시지를 송신합니다.</title>
</head>
<body>
<% 
JMSSender sender = new JMSSender();
sender.sendMessage("안녕하세요! Java Message Service ^^");

out.println("송신 완료");
%>
</body>
</html>