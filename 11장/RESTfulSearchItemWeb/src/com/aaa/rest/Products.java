package com.aaa.rest;

import java.util.List;
import com.aaa.ejb3.Item; // 뒤에서 추가 코딩

public class Products {
	
	private String shopInfo;
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