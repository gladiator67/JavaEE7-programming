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
	
	@Lock(READ) // --- ①
	public String getGreetings() {
		return greetings;
	}
	
	@Lock(WRITE) // --- ②
	public void setGreetings(String greetings) {
		this.greetings = greetings;
	}
	
	@Lock(READ) // --- ①
	public int getCount() {
		count++;
		return count;
	}
	
	@Lock(WRITE) // --- ②
	public void setCount(int count) {
		this.count = count;
	}
	
	@PostConstruct
	public void postConstructMethod() {
		count = 0;
		greetings = "Hello World ^^" ;
		System.out.println("Post Construct 호출");
	}
	
	@PreDestroy
	public void preDestroyMethod() {
		System.out.println("Pre Destroy 호출");
	}
}
