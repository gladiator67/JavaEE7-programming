package com.aaa.soap;

import javax.ejb.EJB;   // �߰��� �ڵ�
import javax.jws.WebService;

import com.aaa.ejb3.IManageShopPort;   // �߰��� �ڵ�

@WebService( targetNamespace="http://www.aaa.com" )
public class SearchBean implements ISearchPort {
	
   @EJB
   IManageShopPort port;

   @Override
   public void setShopItems(String shopId) {
      // TODO Auto-generated method stub
      port.setItems(shopId);   // �߰��� �ڵ�
   }

   @Override
   public Products getProductsInfo(String shopId) {
      // TODO Auto-generated method stub
      // �߰��� �ڵ�
      Products p = new Products();
      p.setShopInfo(port.getShopInfo(shopId));
      p.setItems(port.getItems(shopId));

      return p;
   }
}
