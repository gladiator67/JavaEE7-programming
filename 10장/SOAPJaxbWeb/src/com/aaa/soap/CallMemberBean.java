package com.aaa.soap;

import javax.jws.WebService;

@WebService(targetNamespace="http://www.aaa.com")
public class CallMemberBean implements ICallMemberPort {

	@Override
	public Member getMember(String id) {
		// TODO Auto-generated method stub
		Member m = new Member();
		
		m.setId(id);
		m.setPasswd("ccc");
		m.setAge(15);
		m.setName("°­¼è ¾Æµé");
		
		return m;	
	}
}
