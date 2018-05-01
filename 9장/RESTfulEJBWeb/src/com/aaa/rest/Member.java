package com.aaa.rest;

public class Member {

	private String id;
	private String passwd;
	private int age;
	private String name;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPasswd() {
		return passwd;
	}
	
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
	   return "아이디 : " + id + ", 암호 : " + passwd + ", 나이 : " + age + ",이름 : " + name + " 입니다. ^_^";
	}
}
