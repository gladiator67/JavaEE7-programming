package com.aaa.ejb3;

import javax.ejb.ConcurrencyManagement;
import javax.ejb.Lock;
import javax.ejb.Singleton;

import static javax.ejb.ConcurrencyManagementType.CONTAINER;
import static javax.ejb.LockType.READ ;
import static javax.ejb.LockType.WRITE ;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Singleton
@ConcurrencyManagement(CONTAINER)
public class SingletonBean {
	
	private String greetings;
	private int count;
	
	@Lock(READ) // --- ��
	public String getGreetings() {
		return greetings;
	}
	
	@Lock(WRITE) // --- ��
	public void setGreetings(String greetings) {
		this.greetings = greetings;
	}
	
	@Lock(READ) // --- ��
	public int getCount() {
		count++;
		return count;
	}
	
	@Lock(WRITE) // --- ��
	public void setCount(int count) {
		this.count = count;
	}
	
	@PostConstruct
	public void postConstructMethod() {
		count = 0;
		greetings = "Hello World ^^" ;
		System.out.println("Post Construct ȣ��");
	}
	
	@PreDestroy
	public void preDestroyMethod() {
		System.out.println("Pre Destroy ȣ��");
	}
}
