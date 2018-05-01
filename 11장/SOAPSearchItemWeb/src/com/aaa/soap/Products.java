package com.aaa.soap;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.aaa.ejb3.Item;  // 뒤에서 추가 코딩

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@XmlType(name="", propOrder={"shopInfo", "items"}, namespace="data.aaa.com")
public class Products {

   @XmlElement
   private String shopInfo;
	
   @XmlElement
   private List<Item> items;

   public String getShopInfo() {
	   return shopInfo;
   }
   
   public void setShopInfo(String shopInfo) {
	   this.shopInfo = shopInfo;
   }

   public List<Item> getItems() {
	   return items;
   }

   public void setItems(List<Item> items) {
	   this.items = items;
   }
}
