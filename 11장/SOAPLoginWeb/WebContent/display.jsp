<%@ page language="java" contentType="text/html; charset=EUC-KR" 
                pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="com.aaa.soap.*"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>로그인 인증</title>
</head>
<body>
<%
try {
String id = request.getParameter("id");
String passwd = request.getParameter("passwd");

LoginBeanService service = new LoginBeanService();
ILoginPort port = service.getLoginBeanPort();

out.println(port.loginFunc(id,passwd));
}
catch(Exception e){
out.println(e.getMessage());
}
%>
</body>
</html>