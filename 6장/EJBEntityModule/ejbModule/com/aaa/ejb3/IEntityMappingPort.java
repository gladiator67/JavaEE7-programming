package com.aaa.ejb3;

import java.util.List;
import javax.ejb.Local;

@Local
public interface IEntityMappingPort {
	List<Records> getClientRecords(String name);
	void setClientMember (Members m);
}
