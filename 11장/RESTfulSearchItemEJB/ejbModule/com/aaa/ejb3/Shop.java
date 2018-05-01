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
@Table(name = "shops")
public class Shop implements Serializable {

   @Id
   @Column(name = "EMP_SHOP_ID")
   private String shopId;
	
   @Column(name = "EMP_Shop_Name")
   private String name;
	
   @Column(name = "EMP_PHONE_NO")
   private int phoneNo;
	
   @Column(name = "EMP_Address")
   private String shopAddr;
	
   @Column(name="EMP_Items")
   @OneToMany(fetch=FetchType.EAGER, mappedBy="shop", cascade=CascadeType.ALL)
   private List<Item> items = new ArrayList();

   public String getShopId() {
	   return shopId;
   }

   public void setShopId(String shopId) {
	   this.shopId = shopId;
   }

   public String getName() {
	   return name;
   }

   public void setName(String name) {
	   this.name = name;
   }

   public int getPhoneNo() {
	   return phoneNo;
   }

   public void setPhoneNo(int phoneNo) {
	   this.phoneNo = phoneNo;
   }

   public String getShopAddr() {
	   return shopAddr;
   }

   public void setShopAddr(String shopAddr) {
	   this.shopAddr = shopAddr;
   }

   public List<Item> getItems() {
	   return items;
   }

   public void setItems(List<Item> items) {
	   this.items = items;
   }
   
}