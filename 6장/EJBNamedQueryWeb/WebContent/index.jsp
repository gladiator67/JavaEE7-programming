<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>입력값 설정</title>
</head>
<body>
<form METHOD="post" action="display.jsp">
    아이디 : <INPUT TYPE="text" NAME="id"><p>
    쿼   리 : 저장 프로시져<INPUT TYPE="radio" NAME="query" 
                                             VALUE="procedure" checked>
         SQL    <INPUT TYPE="radio" NAME="query" VALUE="sql"> <br>
    <INPUT TYPE="submit" VALUE="로그인">  
</form>
</body>
</html>