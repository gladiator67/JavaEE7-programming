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
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "info")
public class Item implements Serializable {

   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   @Column(name = "EMP_ID")
   private int id;
	
   @Column(name = "EMP_Item_Name")
   private String name;
	
   @Column(name = "EMP_Price")
   private int price;
	
   @Column(name = "EMP_Color")
   private String color;
	
   @Column(name = "EMP_Provide")
   private String provider;
	
   @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
   @JoinColumn(name="EMP_Items")
   private Shop shop ;

   public int getId() {
	   return id;
   }
	
   public void setId(int id) {
	   this.id = id;
   }
	
   public String getName() {
	   return name;
   }
	
   public void setName(String name) {
	   this.name = name;
   }
	
   public int getPrice() {
	   return price;
   }
	
   public void setPrice(int price) {
	   this.price = price;
   }
	
   public String getColor() {
	   return color;
   }
	
   public void setColor(String color) {
	   this.color = color;
   }
	
   public String getProvider() {
	   return provider;
   }
	
   public void setProvider(String provider) {
	   this.provider = provider;
   }

   @XmlTransient   // --- ич
   public Shop getShop() {
	   return shop;
   }
	
   public void setShop(Shop shop) {
	   this.shop = shop;
   }
}