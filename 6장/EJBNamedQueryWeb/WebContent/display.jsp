<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="javax.naming.*"%>
<%@ page import="com.aaa.ejb3.ICallNamedQueryPort"%>
<%@ page import="com.aaa.ejb3.Members"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>EJB3.2에서 Database 연동 테스트2</title>
</head>
<body>
<%
try {
    Context ctx = new InitialContext();
    ICallNamedQueryPort port = (ICallNamedQueryPort)ctx.lookup("java:app/EJBNamedQueryModule/CallNamedQueryBean");
    String id = request.getParameter("id");
    String type = request.getParameter("query");
    
    String result = port.callNamedQuery(type, id);
    out.println(result);
}
catch(Exception e) {
    out.println( e.getMessage() );
}
%>
</body>
</html>