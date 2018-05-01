package com.aaa.rest;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.aaa.ejb3.Member; // 이 부분은 뒤에서 코딩한다.
import com.aaa.ejb3.IGetMemberPort; // 이 부분은 뒤에서 코딩한다.

public class LoginBean implements ILoginPort {

   @Override
   public String loginFunc(String id, String passwd) {
      // TODO Auto-generated method stub
      try {
         Context ctx = new InitialContext();
         // 이 부분은 뒤에서 코딩한다.
         IGetMemberPort port = (IGetMemberPort)ctx.lookup("java:app/RESTfulLoginEJB/GetMemberBean");
						
         // 이 부분은 뒤에서 코딩한다.
         Member member = new Member();
         member = (Member)port.getMember(Member.class, id);
			
         if( member == null )
        	 return "그런 사용자가 없습니다.";
         else if(!passwd.equals(member.getPasswd().trim()))
        	 return "암호가 틀립니다.";
         else
        	 return member.toString();
      }
      catch(Exception e) {
         return e.getMessage();
      }
   }
}