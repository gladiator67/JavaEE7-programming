package com.aaa.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService( targetNamespace="http://www.aaa.com" )
public interface ISearchPort {

   @WebMethod
   public void setShopItems(@WebParam String shopId);
	
   @WebMethod
   @WebResult
   public Products getProductsInfo(@WebParam String shopId);
}
