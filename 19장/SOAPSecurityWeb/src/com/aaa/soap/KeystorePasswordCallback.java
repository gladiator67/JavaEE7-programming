package com.aaa.soap;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.wss4j.common.ext.WSPasswordCallback;

public class KeystorePasswordCallback implements CallbackHandler {

	private Map<String, String> passwords = new HashMap<String, String>();    
	
	public KeystorePasswordCallback() {      
		passwords.put("servicekey", "password123");
		passwords.put("clientkey", "password123");
	}

	@Override
	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		// TODO Auto-generated method stub
		for (int i = 0; i < callbacks.length; i++) { 
			WSPasswordCallback pc = (WSPasswordCallback)callbacks[i];
			String pass = passwords.get(pc.getIdentifier());         
			if (pass != null) {            
				pc.setPassword(pass);            
				return;         
			}      
		}
	}
	
	public void setAliasPassword(String alias, String password) {      
		passwords.put(alias, password);   
	}
}
