<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.aaa.jms.JMSSender" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�޽����� �۽��մϴ�.</title>
</head>
<body>
<% 
JMSSender sender = new JMSSender();
sender.sendMessage("�ȳ��ϼ���! Java Message Service ^^");

out.println("�۽� �Ϸ�");
%>
</body>
</html>