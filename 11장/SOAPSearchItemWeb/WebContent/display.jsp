<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.*"%>
<%@ page import="com.aaa.*"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>��� ����</title>
</head>
<body>
<table border=��1��>
<tr>
<td>��ǰ�̸�</td>
<td>����</td>
<td>����</td>
<td>���� ȸ��</td>
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