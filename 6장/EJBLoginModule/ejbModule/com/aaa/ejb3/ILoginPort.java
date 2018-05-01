package com.aaa.ejb3;

import java.io.Serializable;
import javax.ejb.Local;

@Local
public interface ILoginPort {
	
   public Object loginFunc(Class<Members> clazz,Object primaryKey); // SQL SELECT에 해당
   public Object persistFunc(Serializable entity); // SQL INSERT에 해당
   public Object mergeFunc(Serializable entity); // SQL UPDATE에 해당
   public void removeFunc(Serializable entity); // SQL REMOVE에 해당
   
}
