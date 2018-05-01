package com.aaa.ejb3;

import javax.ejb.Local;

@Local
public interface IGetMemberPort {
   public Object getMember(Class<Member> clazz, Object primaryKey);
}