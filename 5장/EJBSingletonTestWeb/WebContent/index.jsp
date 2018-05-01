<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="javax.naming.Context"%>
<%@ page import="javax.naming.InitialContext"%>
<%@ page import="com.aaa.ejb3.SingletonBean"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Singleton Bean 테스트</title>
</head>
<body>
<%
try {
	Context ctx = new InitialContext();
	SingletonBean bean1 = (SingletonBean)ctx.lookup("java:app/EJBSingletonTest/SingletonBean");
	SingletonBean bean2 = (SingletonBean)ctx.lookup("java:app/EJBSingletonTest/SingletonBean");
	out.println("첫번째 빈 카운트 : " + bean1.getCount());%> <p> <% 
	out.println("첫번째 빈 문자열 : " + bean1.getGreetings()); %> <p> <% 
	out.println("두번째 빈 카운트 : " + bean2.getCount()); %> <p> <% 
	out.println("두번째 빈 문자열 : " + bean2.getGreetings()); %> <p> <% 
	bean1.setGreetings("안녕하세요!");
	out.println("두번째 빈 문자열 : " + bean2.getGreetings());%> <p> <% 
	out.println("두번째 빈 카운트 : " + bean2.getCount()); %> <p> <% 
}
catch(Exception e) {
	out.println( e.getMessage() );
}
%>
</body>
</html>