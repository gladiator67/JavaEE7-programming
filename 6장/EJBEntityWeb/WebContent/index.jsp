<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.List"%>
<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="com.aaa.ejb3.Members"%>
<%@ page import="com.aaa.ejb3.Records"%>
<%@ page import="com.aaa.ejb3.IEntityMappingPort"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>EJB Entity Mapping Test</title>
</head>
<body>
<table border=��1��>
<tr>
<td>����</td>
<td>���</td>
<td>��ȭ��ȣ</td>
</tr>
<%
try {
	Context ctx = new InitialContext();
	IEntityMappingPort port = (IEntityMappingPort)ctx.lookup("java:app/EJBEntityModule/EntityMappingBean");
	
	Members m = new Members();
	m.setId("aupres");
	m.setPasswd("aaa");
	m.setName("������");
	
	Records r1 = new Records();
	r1.setAccount(999888777);
	r1.setHobby("����");
	r1.setPhone(1112222);
	r1.setMember(m);
	
	Records r2 = new Records();
	r2.setAccount(666555444);
	r2.setHobby("���ڱ�");
	r2.setPhone(3334444);
	r2.setMember(m);
	
	Records r3 = new Records();
	r3.setAccount(333222111);
	r3.setHobby("���");
	r3.setPhone(5556666);
	r3.setMember(m);
	
	m.getRecord().add(r1);
	m.getRecord().add(r2);
	m.getRecord().add(r3);
	
	// �����͸� �����Ѵ�.
	port.setClientMember(m);
	
	// �����͸� �ҷ��´�.
	List<Records> records = port.getClientRecords("aupres");
	
	out.println("ID : " + m.getId() + " ,Name : " + m.getName() + "�� ����");
	
	for(int i=0; i < records.size(); i++) {
	Records r = (Records)records.get(i);
	%>
	<tr>
	<td><%= r.getAccount() %></td>
	<td><%= r.getHobby() %></td>
	<td><%= r.getPhone() %></td>
	</tr>
	<%
	}
}
catch(Exception e) {
	out.println( e.getMessage() );
}
%>
</table>
</body>
</html>