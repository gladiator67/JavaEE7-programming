package com.aaa.ejb3;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@EntityListeners(Alarm.class)
@Table(name="family",
     indexes={@Index(name="MY_INDEX",columnList="EMP_ID") })  //  ---  ①
public class Members implements Serializable {

	@Id
	@Column(name = "EMP_ID")
	private String ID;
	
	@Column(name = "EMP_Passwd")
	private String Passwd;
	
	@Column(name = "EMP_Age")
	private int Age;
	
	@Column(name = "EMP_Name")
	private String Name;

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getPasswd() {
		return Passwd;
	}

	public void setPasswd(String passwd) {
		Passwd = passwd;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	
	@Override 
	public String toString(){
	  return "아이디 : " + ID + ", 암호 : " + Passwd + ", 나이 : " + Age + ", 이름 : " + Name + "입니다.^^";
	}
}
