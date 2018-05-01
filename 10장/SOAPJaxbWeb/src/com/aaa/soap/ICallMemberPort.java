package com.aaa.soap;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(targetNamespace="http://www.aaa.com") // ---��
@HandlerChain(file="handler_chain.xml") // --- ��
public interface ICallMemberPort {

	@WebMethod
	@WebResult
	Member getMember(@WebParam String id);
}
