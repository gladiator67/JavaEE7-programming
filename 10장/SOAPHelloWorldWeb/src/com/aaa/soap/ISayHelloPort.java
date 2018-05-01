package com.aaa.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public interface ISayHelloPort {

	@WebMethod
	@WebResult
	public String sayHello(@WebParam String name);
}
