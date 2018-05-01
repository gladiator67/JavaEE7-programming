<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="javax.naming.Context"%>
<%@ page import="javax.naming.InitialContext"%>
<%@ page import="com.aaa.ejb3.HelloWorldBean"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>EJB HelloWorld 테스트</title>
</head>
<body>
<%
try {
   Context ctx = new InitialContext();
   HelloWorldBean hello = (HelloWorldBean)ctx.lookup("java:app/EJBHelloWorld/HelloWorldBean");
   out.println(hello.sayHello("변강쇠"));
}
catch(Exception e) {
   out.println( e.getMessage() );
}
%>
</body>
</html>