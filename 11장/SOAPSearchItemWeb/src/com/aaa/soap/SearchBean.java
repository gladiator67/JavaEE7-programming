package com.aaa.soap;

import javax.ejb.EJB;   // 추가된 코드
import javax.jws.WebService;

import com.aaa.ejb3.IManageShopPort;   // 추가된 코드

@WebService( targetNamespace="http://www.aaa.com" )
public class SearchBean implements ISearchPort {
	
   @EJB
   IManageShopPort port;

   @Override
   public void setShopItems(String shopId) {
      // TODO Auto-generated method stub
      port.setItems(shopId);   // 추가된 코드
   }

   @Override
   public Products getProductsInfo(String shopId) {
      // TODO Auto-generated method stub
      // 추가된 코드
      Products p = new Products();
      p.setShopInfo(port.getShopInfo(shopId));
      p.setItems(port.getItems(shopId));

      return p;
   }
}
