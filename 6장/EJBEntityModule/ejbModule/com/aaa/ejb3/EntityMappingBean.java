package com.aaa.ejb3;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EntityMappingBean implements IEntityMappingPort {
	
	@PersistenceContext(unitName="MyFamily")
	EntityManager em;

	@Override
	public List<Records> getClientRecords(String name) {
		// TODO Auto-generated method stub
		Members m = (Members)em.find(Members.class, name);
		List<Records> records = m.getRecord();
		
		return records;
	}

	@Override
	public void setClientMember(Members m) {
		// TODO Auto-generated method stub
		em.persist(m);
	}

}