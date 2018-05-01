package com.aaa.ejb3;

import javax.ejb.Local;

@Local
public interface ISchedulePort {
	public void getSignal();
}
