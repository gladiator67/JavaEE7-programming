package com.aaa.ejb3;

import java.util.List;

import javax.ejb.Local;

@Local
public interface IManageShopPort {

	void setItems(String shopID);
	String getShopInfo(String shopID);
	List<Item> getItems(String shopID);
}
