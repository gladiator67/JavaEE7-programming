<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Cloud Foundry 테스트</title>
</head>
<body>
<table border="1">
<tr>
<td>아이디</td>
<td>비밀번호</td>
<td>나이</td>
<td>이름</td>
</tr>
<%
String driver="com.mysql.jdbc.Driver";
String url="jdbc:mysql://us-cdbr-iron-east-02.cleardb.net:3306/ad_2566d713c74b63c?useUnicode=yes&characterEncoding=UTF-8";  // 공백으로 남겨둔다.
String user="bf7216de734bd9";   // 공백으로 남겨둔다.
String password="1111111";   // 공백으로 남겨둔다.

Connection con = null;
Statement stmt = null;
ResultSet rs = null;

String sql = "select EMP_ID, EMP_Passwd, EMP_Age, EMP_Name from family";
try {
Class.forName(driver);
con = DriverManager.getConnection(url,user,password);
stmt = con.createStatement();
rs = stmt.executeQuery(sql);
while(rs.next()) {
%>
<tr>
<td><%= rs.getString("EMP_ID") %></td>
<td><%= rs.getString("EMP_Passwd") %></td>
<td><%= rs.getInt("EMP_Age") %></td>
<td><%= rs.getString("EMP_Name") %></td>
</tr>
<%
}
} catch(Exception e) {
e.printStackTrace();
%>
<tr>
<td colspan="4">Error : <%= e.getMessage() %></td>
</tr>
<%
} finally {
if(rs != null) try { rs.close(); } catch(Exception ignore) {}
if(stmt != null) try { stmt.close(); } catch(Exception ignore) {}
if(con != null) try { con.close(); } catch(Exception ignore) {}
}
%>
</table>
</body>
</html>