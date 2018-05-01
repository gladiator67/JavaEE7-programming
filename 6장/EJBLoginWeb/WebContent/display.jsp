<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="javax.naming.*"%>
<%@ page import="com.aaa.ejb3.ILoginPort"%>
<%@ page import="com.aaa.ejb3.Members"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>EJB3.2���� Database ���� �׽�Ʈ1</title>
</head>
<body>
<%
try {
	Context ctx = new InitialContext();
	ILoginPort login = (ILoginPort)ctx.lookup("java:app/EJBLoginModule/LoginBean");
	String id = request.getParameter("id");
	Members member = (Members)login.loginFunc(Members.class, id);
	if( member == null )
		out.println("�׷� ����ڰ� �����ϴ�.");
	else {
		out.println(member.toString());
		
		// SQL Insert
		member.setID("kim");
		member.setPasswd("ddd");
		member.setName("ȫ�浿");
		member = (Members)login.persistFunc(member);
		out.println("ȫ�浿�� �ԷµǾ����ϴ�....");
	
		// SQL Update
		member.setName("�Ӳ���");
		member = (Members)login.mergeFunc(member);
		out.println("�Ӳ������� ����Ǿ����ϴ�....");
	
		// SQL Delete
		login.removeFunc(member);
		out.println("�����Ͽ����ϴ�.");
	}
}
catch(Exception e) {
	out.println( e.getMessage() );
}
%>
</body>
</html>