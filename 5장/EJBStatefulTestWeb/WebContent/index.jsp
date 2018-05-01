<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.List"%>
<%@ page import="javax.naming.Context"%>
<%@ page import="javax.naming.InitialContext"%>
<%@ page import="com.aaa.ejb3.ICartPort"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>상태유지 세션 빈 테스트</title>
</head>
<body>
<% 
try {
   Context ctx = new InitialContext();
   ICartPort port = (ICartPort)ctx.lookup("java:app/EJBStatefulTest/CartBean");
   port.initialize("변강쇠");
	
   port.addBook("Eclipse와 JBoss7을 이용한 Java 웹서비스 구축");
   port.addBook("빅데이터 프로그래밍");
   port.addBook("Java EE 7을 위한 WildFly 10 프로그래밍"); //책 이름으로 수정
   port.addBook("생선 요리책");
	
   out.println("=====수정 전======");%> <p> <%
	
   List<String> books = port.getContents();
	
   for(String book : books ) {
      out.println(book);%> <p> <% 
   }
	
   port.removeBook("생선 요리책");
	
   out.println("=====수정 후======");%> <p> <%
	
   books = port.getContents();
	
   for(String book : books ) {
      out.println(book);%> <p> <%
   }
	
   port.remove();
}
catch(Exception e) {
   out.println( e.getMessage() );
}	
%>
</body>
</html>