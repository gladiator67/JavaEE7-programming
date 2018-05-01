package com.aaa.ejb3;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="family")
public class Member implements Serializable {

	@Id
	@Column(name = "EMP_ID")
	private String id;
	
	@Column(name = "EMP_Passwd")
	private String passwd;
	
	@Column(name = "EMP_Age")
	private int age;
	
	@Column(name = "EMP_Name")
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
	public String toString(){
	   return "아이디 : " + id + ", 암호 : " + passwd  + ", 나이 : " + age + ", 이름 : " + name + "입니다.^^";
	}
}
