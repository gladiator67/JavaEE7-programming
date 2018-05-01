package com.aaa.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.jboss.ws.api.annotation.PolicySets;

@WebService
@PolicySets({"WS-SP-EX224_WSS11_Mutual_Auth_X509_Sign_Encrypt"})
public interface IHelloWorld {

	@WebMethod
	@WebResult
	public String sayHello(@WebParam String name);
}
