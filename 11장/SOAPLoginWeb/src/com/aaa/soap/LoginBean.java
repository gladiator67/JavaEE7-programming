package com.aaa.soap;

import javax.ejb.EJB;
import javax.jws.WebService;

import com.aaa.ejb3.IGetMemberPort; // �� �κ��� �ڿ��� �ڵ��Ѵ�.
import com.aaa.ejb3.Member; // �� �κ��� �ڿ��� �ڵ��Ѵ�.

@WebService
public class LoginBean implements ILoginPort {
	
   @EJB
   IGetMemberPort port; // �� �κ��� �ڿ��� �ڵ��Ѵ�.

   @Override
   public String loginFunc(String id, String passwd) {
      // TODO Auto-generated method stub
      try {
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
