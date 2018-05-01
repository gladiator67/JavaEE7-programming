package com.aaa.rest;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.aaa.ejb3.Member; // �� �κ��� �ڿ��� �ڵ��Ѵ�.
import com.aaa.ejb3.IGetMemberPort; // �� �κ��� �ڿ��� �ڵ��Ѵ�.

public class LoginBean implements ILoginPort {

   @Override
   public String loginFunc(String id, String passwd) {
      // TODO Auto-generated method stub
      try {
         Context ctx = new InitialContext();
         // �� �κ��� �ڿ��� �ڵ��Ѵ�.
         IGetMemberPort port = (IGetMemberPort)ctx.lookup("java:app/RESTfulLoginEJB/GetMemberBean");
						
         // �� �κ��� �ڿ��� �ڵ��Ѵ�.
         Member member = new Member();
         member = (Member)port.getMember(Member.class, id);
			
         if( member == null )
        	 return "�׷� ����ڰ� �����ϴ�.";
         else if(!passwd.equals(member.getPasswd().trim()))
        	 return "��ȣ�� Ʋ���ϴ�.";
         else
        	 return member.toString();
      }
      catch(Exception e) {
         return e.getMessage();
      }
   }
}