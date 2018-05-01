package com.aaa.ejb3;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "record")
public class Records implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "EMP_ID")
   private int i;

   @Column(name = "EMP_Bank_Account")
   private int account;

   @Column(name = "EMP_Hobby")
   private String hobby;

   @Column(name = "EMP_Phone")
   private int phone;

   @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
   @JoinColumn(name="EMP_Record")
   private Members member;

	public int getI() {
		return i;
	}
	
	public void setI(int i) {
		this.i = i;
	}
	
	public int getAccount() {
		return account;
	}
	
	public void setAccount(int account) {
		this.account = account;
	}
	
	public String getHobby() {
		return hobby;
	}
	
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	public int getPhone() {
		return phone;
	}
	
	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	public Members getMember() {
		return member;
	}
	
	public void setMember(Members member) {
		this.member = member;
	}
}
