package com.aaa.ejb3;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class GetMemberBean implements IGetMemberPort {
	
   @PersistenceContext(unitName="MyFamily")
   EntityManager em;

   @Override
   public Object getMember(Class<Member> clazz, Object primaryKey) {
      // TODO Auto-generated method stub
      return em.find(clazz, primaryKey);
   }
}
