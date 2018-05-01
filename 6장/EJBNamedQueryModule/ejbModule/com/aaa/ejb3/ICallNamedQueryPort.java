package com.aaa.ejb3;

import javax.ejb.Local;

@Local
public interface ICallNamedQueryPort {
	public String callNamedQuery(String type, String ID);
}
