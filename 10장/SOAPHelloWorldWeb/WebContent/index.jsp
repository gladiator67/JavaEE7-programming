<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="com.aaa.soap.*"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>SOAP 웹 서비스 테스트 1</title>
</head>
<body>
<%
	SayHelloBeanService service = new SayHelloBeanService();
	ISayHelloPort port = service.getSayHelloBeanPort();
	out.println(port.sayHello("변강쇠"));
%>
</body>
</html>