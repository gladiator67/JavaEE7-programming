package com.aaa.soap;

import javax.jws.WebService;

@WebService
public class SayHelloBean implements ISayHelloPort {

	@Override
	public String sayHello(String name) {
		// TODO Auto-generated method stub
		return name + "�� �氡�氡 ^^";
	}
}
