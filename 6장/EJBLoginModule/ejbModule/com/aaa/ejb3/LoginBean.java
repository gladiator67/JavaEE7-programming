package com.aaa.ejb3;

import java.io.Serializable;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class LoginBean implements ILoginPort {
	
	@PersistenceContext(unitName="MyFamily")
	EntityManager em;

	@Override
	public Object loginFunc(Class<Members> clazz, Object primaryKey) {
		// TODO Auto-generated method stub
		return em.find(clazz, primaryKey);
	}

	@Override
	public Object persistFunc(Serializable entity) {
		// TODO Auto-generated method stub
		em.persist(entity);
		return entity;
	}

	@Override
	public Object mergeFunc(Serializable entity) {
		// TODO Auto-generated method stub
		em.merge(entity);
		return entity;
	}

	@Override
	public void removeFunc(Serializable entity) {
		// TODO Auto-generated method stub
		em.remove(em.merge(entity));
	}
}
