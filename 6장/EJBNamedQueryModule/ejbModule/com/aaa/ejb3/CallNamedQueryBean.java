package com.aaa.ejb3;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

@Stateless
public class CallNamedQueryBean implements ICallNamedQueryPort {
	
   @PersistenceContext(unitName="MyFamily")
   EntityManager em;

   @Override
   public String callNamedQuery(String type, String ID) {
      // TODO Auto-generated method stub
      if(ID != null) {
         if(type.equals("procedure")) {
            StoredProcedureQuery spq  = em.createNamedStoredProcedureQuery("callSelectSP");
            spq.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter(2, String.class, ParameterMode.OUT);
            spq.registerStoredProcedureParameter(3, String.class, ParameterMode.OUT);
            spq.registerStoredProcedureParameter(4, Integer.class, ParameterMode.OUT);
            spq.registerStoredProcedureParameter(5, String.class, ParameterMode.OUT);
            spq.setParameter(1, ID);
            spq.execute();
            String name = (String)spq.getOutputParameterValue(2);
            String passwd = (String)spq.getOutputParameterValue(3);
            int age = (Integer)spq.getOutputParameterValue(4);	
            String id_out = (String)spq.getOutputParameterValue(5);
				
            return "아이디 : " + id_out + ", 암호 : " + passwd + ", 나이 : " + age + ", 이름 : " + name + "입니다.^^" ;
         } else if(type.equals("sql")) {
        	Query query = em.createNamedQuery("callSelectSql");
        	query.setParameter(1, ID);
        	Members member = (Members)query.getSingleResult();
				
        	return member.toString();
         } else {
        	return "입력이 틀렸습니다.!!";
         }
      } else {
    	  return "id를 입력하십시요!";			
      }
   }
}
