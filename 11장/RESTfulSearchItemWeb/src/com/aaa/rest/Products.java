package com.aaa.rest;

import java.util.List;
import com.aaa.ejb3.Item; // �ڿ��� �߰� �ڵ�

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