<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="javax.naming.*"%>
<%@ page import="com.aaa.ejb3.ILoginPort"%>
<%@ page import="com.aaa.ejb3.Members"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>EJB3.2에서 Database 연동 테스트1</title>
</head>
<body>
<%
try {
	Context ctx = new InitialContext();
	ILoginPort login = (ILoginPort)ctx.lookup("java:app/EJBLoginModule/LoginBean");
	String id = request.getParameter("id");
	Members member = (Members)login.loginFunc(Members.class, id);
	if( member == null )
		out.println("그런 사용자가 없습니다.");
	else {
		out.println(member.toString());
		
		// SQL Insert
		member.setID("kim");
		member.setPasswd("ddd");
		member.setName("홍길동");
		member = (Members)login.persistFunc(member);
		out.println("홍길동이 입력되었습니다....");
	
		// SQL Update
		member.setName("임꺽정");
		member = (Members)login.mergeFunc(member);
		out.println("임꺽정으로 변경되었습니다....");
	
		// SQL Delete
		login.removeFunc(member);
		out.println("삭제하였습니다.");
	}
}
catch(Exception e) {
	out.println( e.getMessage() );
}
%>
</body>
</html>