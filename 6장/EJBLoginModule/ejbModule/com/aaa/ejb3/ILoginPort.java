package com.aaa.ejb3;

import java.io.Serializable;
import javax.ejb.Local;

@Local
public interface ILoginPort {
	
   public Object loginFunc(Class<Members> clazz,Object primaryKey); // SQL SELECT�� �ش�
   public Object persistFunc(Serializable entity); // SQL INSERT�� �ش�
   public Object mergeFunc(Serializable entity); // SQL UPDATE�� �ش�
   public void removeFunc(Serializable entity); // SQL REMOVE�� �ش�
   
}
