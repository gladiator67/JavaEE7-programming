package com.aaa.rest;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.aaa.ejb3.IManageShopPort;

public class SearchBean implements ISearchPort {
	
   private IManageShopPort port;

   public SearchBean() {
      try {
         Context ctx = new InitialContext();
         port = (IManageShopPort)ctx.lookup("java:app/RESTfulSearchItemEJB/ManageShopBean");
      }
      catch(Exception e) {
         e.printStackTrace();
      }
   }
	
   @Override
   public void setShopItems(String shopId) {
      // TODO Auto-generated method stub
         port.setItems(shopId);
   }

   @Override
   public Products getProductsInfo(String shopId) {
      // TODO Auto-generated method stub
      Products p = new Products();
      p.setShopInfo(port.getShopInfo(shopId));
      p.setItems(port.getItems(shopId));

      return p;
   }
}