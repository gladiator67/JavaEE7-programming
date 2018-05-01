package com.aaa.ejb3;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.Table;

// Oracle 12c가 설치된 CentOS 7에서는 procedureName 속성의 값이 "sp_select_ora"가 된다.
@NamedStoredProcedureQuery(name = "callSelectSP", procedureName = "sp_select_mysql")
@NamedNativeQuery(name = "callSelectSql", query = "select * from family where EMP_ID=(?)", resultClass = Members.class)
@Entity
@Table(name="family")
public class Members implements Serializable {

	@Id
	@Column(name = "EMP_ID")
	private String ID;
	
	@Column(name = "EMP_Passwd")
	private String Passwd;
	
	@Column(name = "EMP_Age")
	private int age;
	
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
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	
	@Override 
	public String toString(){
	  return "아이디 : " + ID + ", 암호 : " + Passwd + ", 나이 : " + age + ", 이름 : " + Name + " 입니다.^^";
	}
}