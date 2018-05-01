package com.aaa.ejb3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "family")
public class Members implements Serializable {

   @Id
   @Column(name = "EMP_ID")
   private String id ;
	
   @Column(name = "EMP_Passwd")
   private String passwd ;
	
   @Column(name = "EMP_Age")
   private int age ;
	
   @Column(name = "EMP_Name")
   private String name ;
	
   @Column(name="EMP_Record")
   @OneToMany(fetch=FetchType.EAGER, mappedBy="member", cascade=CascadeType.ALL)
   private List<Records> record = new ArrayList();

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
	
	public List<Records> getRecord() {
		return record;
	}
	
	public void setRecord(List<Records> record) {
		this.record = record;
	}
}