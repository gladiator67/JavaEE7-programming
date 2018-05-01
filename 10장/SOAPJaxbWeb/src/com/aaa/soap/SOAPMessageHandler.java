package com.aaa.soap;

import java.io.ByteArrayOutputStream;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class SOAPMessageHandler implements SOAPHandler<SOAPMessageContext> {

   @Override
   public void close(MessageContext context) {
      // TODO Auto-generated method stub

   }

   @Override
   public boolean handleFault(SOAPMessageContext context) {
      // TODO Auto-generated method stub
      return false;
   }

   @Override
   public boolean handleMessage(SOAPMessageContext context) {
      // TODO Auto-generated method stub
      // 출력값에 한하여 SOAP 메시지를 출력한다.
      Boolean isResponse = (Boolean)context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

      if(isResponse){
    	  try{
    		  SOAPMessage soapMsg = context.getMessage();
    		  ByteArrayOutputStream out = new ByteArrayOutputStream();
    		  soapMsg.writeTo(out);
    		  System.out.println(new String(out.toByteArray(), "UTF-8"));
    	  }
    	  catch(Exception e) {
    		  e.printStackTrace();
    	  }
      }

      return true;
   }

   @Override
   public Set<QName> getHeaders() {
      // TODO Auto-generated method stub
      return null;
   }
}
