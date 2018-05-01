package com.aaa.rest;

import javax.ejb.Stateless;

@Stateless
public class CallMemberBean implements ICallMemberPort {

   @Override
   public Member getMemberJson(String id) {
      // TODO Auto-generated method stub
      Member m = new Member();
      m.setId(id);
      m.setPasswd("bbb");
      m.setAge(45);
      m.setName("¿Ë³à");
		
      return m;
   }
}
