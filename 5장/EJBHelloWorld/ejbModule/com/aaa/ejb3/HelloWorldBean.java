package com.aaa.ejb3;

import javax.ejb.Stateless;

@Stateless
public class HelloWorldBean {
   public String sayHello(String name) {
      return name + "�� �ݰ����ϴ� ^^" ;
   }
}
