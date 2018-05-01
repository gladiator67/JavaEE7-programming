package com.aaa.soap;

import javax.jws.WebService;
import org.jboss.ws.api.annotation.EndpointConfig;

@WebService
@EndpointConfig(configFile = "WEB-INF/jaxws-endpoint-config.xml", configName = "Custom WS-Security Endpoint")
public class HelloWorld implements IHelloWorld {
	@Override
	public String sayHello(String name) {
		// TODO Auto-generated method stub
		return name + " ´Ô ¹æ°¡¹æ°¡ ^_^";
	}
}
