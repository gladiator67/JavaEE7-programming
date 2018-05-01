<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="com.aaa.soap.IHelloWorld" %>
<%@ page import="com.aaa.soap.KeystorePasswordCallback" %>

<%@ page import="javax.xml.ws.BindingProvider"%>

<%@ page import="javax.xml.namespace.QName"%>
<%@ page import="java.net.URL"%>
<%@ page import="javax.xml.ws.Service"%>

<%@ page import="org.apache.cxf.rt.security.SecurityConstants"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>WildFly SOAP Security 테스트</title>
</head>
<body>
<% 
String SERVICE_URL = "http://localhost:8080/SOAPSecurityWeb/HelloWorld";

try {
	QName serviceName = new QName("http://soap.aaa.com/", "HelloWorldService");

	URL wsdlURL;
	wsdlURL = new URL(SERVICE_URL + "?wsdl");
	Service service = Service.create(wsdlURL, serviceName);
	
	IHelloWorld port = (IHelloWorld) service.getPort(IHelloWorld.class); 

	((BindingProvider) port).getRequestContext().put(SecurityConstants.CALLBACK_HANDLER, new KeystorePasswordCallback());
	((BindingProvider) port).getRequestContext().put(SecurityConstants.SIGNATURE_PROPERTIES, 
			Thread.currentThread().getContextClassLoader().getResource("META-INF/client.properties"));
	((BindingProvider) port).getRequestContext().put(SecurityConstants.ENCRYPT_PROPERTIES, 
			Thread.currentThread().getContextClassLoader().getResource("META-INF/client.properties"));
	((BindingProvider) port).getRequestContext().put(SecurityConstants.SIGNATURE_USERNAME, "clientkey");
	((BindingProvider) port).getRequestContext().put(SecurityConstants.ENCRYPT_USERNAME, "servicekey");

	out.println(port.sayHello("jina"));
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
%>
</body>
</html>