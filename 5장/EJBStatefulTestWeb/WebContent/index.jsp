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
<title>�������� ���� �� �׽�Ʈ</title>
</head>
<body>
<% 
try {
   Context ctx = new InitialContext();
   ICartPort port = (ICartPort)ctx.lookup("java:app/EJBStatefulTest/CartBean");
   port.initialize("������");
	
   port.addBook("Eclipse�� JBoss7�� �̿��� Java ������ ����");
   port.addBook("������ ���α׷���");
   port.addBook("Java EE 7�� ���� WildFly 10 ���α׷���"); //å �̸����� ����
   port.addBook("���� �丮å");
	
   out.println("=====���� ��======");%> <p> <%
	
   List<String> books = port.getContents();
	
   for(String book : books ) {
      out.println(book);%> <p> <% 
   }
	
   port.removeBook("���� �丮å");
	
   out.println("=====���� ��======");%> <p> <%
	
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