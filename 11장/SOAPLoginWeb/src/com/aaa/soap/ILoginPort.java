package com.aaa.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public interface ILoginPort {

   @WebMethod
   @WebResult
   public String loginFunc(@WebParam String id, @WebParam String passwd);
}
