<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.*"%>
<%@ page import="com.aaa.*"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>결과 보기</title>
</head>
<body>
<table border=“1”>
<tr>
<td>상품이름</td>
<td>색상</td>
<td>가격</td>
<td>공급 회사</td>
</tr>
<%
SearchBeanService service = new SearchBeanService();
ISearchPort port = service.getSearchBeanPort();

String shop = request.getParameter("shop");
port.setShopItems(shop);

String shopInfo = port.getProductsInfo(shop).getShopInfo();
List<Item> items = port.getProductsInfo(shop).getItems();
out.println(shopInfo);
for (Iterator<Item> iter = items.iterator() ; iter.hasNext() ; ) {
Item i = (Item)iter.next();
%>
<tr>
<td><%= i.getName() %></td>
<td><%= i.getColor() %></td>
<td><%= i.getPrice() %></td>
<td><%= i.getProvider() %></td>
</tr>
<%
}
%>
</table>
</body>
</html>