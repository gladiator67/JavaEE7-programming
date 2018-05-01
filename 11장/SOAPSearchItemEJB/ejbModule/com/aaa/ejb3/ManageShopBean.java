package com.aaa.ejb3;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ManageShopBean implements IManageShopPort {

   @PersistenceContext(unitName="MyShop")
   EntityManager em;
	
   @Override
   public void setItems(String shopID) {
      // TODO Auto-generated method stub
      if (em.find(Shop.class, "AB_001") == null) {
         Shop shop = new Shop();
	 shop.setShopId("AB_001");
	 shop.setName("콕션");
	 shop.setPhoneNo(5556666);
	 shop.setShopAddr("서울시 강남구 1-2번지");
			
	 Item item1 = new Item();
	 item1.setName("디카");
	 item1.setColor("white");
	 item1.setPrice(70000);
	 item1.setProvider("CamSung");
	 item1.setShop(shop);
			
	 Item item2 = new Item();
	 item2.setName("TV");
	 item2.setColor("black");
	 item2.setPrice(100000);
	 item2.setProvider("RG");
	 item2.setShop(shop);
			
	 Item item3= new Item();
	 item3.setName("캠코더");
	 item3.setColor("gray");
	 item3.setPrice(90000);
	 item3.setProvider("Sany");
	 item3.setShop(shop);
			
	 shop.getItems().add(item1);
	 shop.getItems().add(item2);
	 shop.getItems().add(item3);
			
	 em.persist(shop);
      } else if (em.find(Shop.class, "CD_002") == null){
         Shop shop = new Shop();
	 shop.setShopId("CD_002");
	 shop.setName("22번가");
	 shop.setPhoneNo(3334444);
	 shop.setShopAddr("서울시 서대문구 5-6번지");
			
	 Item item1 = new Item();
	 item1.setName("프린터");
	 item1.setColor("black");
	 item1.setPrice(120000);
	 item1.setProvider("HPP");
	 item1.setShop(shop);
			
	 Item item2 = new Item();
	 item2.setName("Phone");
	 item2.setColor("red");
	 item2.setPrice(50000);
	 item2.setProvider("Cook");
	 item2.setShop(shop);
			
	 Item item3= new Item();
	 item3.setName("모니터");
	 item3.setColor("white");
	 item3.setPrice(70000);
	 item3.setProvider("Samcung");
	 item3.setShop(shop);
			
	 shop.getItems().add(item1);
	 shop.getItems().add(item2);
	 shop.getItems().add(item3);
	 em.persist(shop);
      }else
	 System.out.println("입력 완료!!");
      }

   @Override
   public String getShopInfo(String shopID) {
      // TODO Auto-generated method stub
      Shop shop = em.find(Shop.class, shopID);
		
      if(shop != null) {
         String shop_info = "가게 이름 : " + shop.getName() + ",전화번호 : " + 
                    shop.getPhoneNo() + ", 주소 : " + shop.getShopAddr();
	 return shop_info;
      } else
	 return null;
      }

   @Override
   public List<Item> getItems(String shopID) {
      // TODO Auto-generated method stub
      Shop shop = em.find(Shop.class, shopID);
      if(shop != null)
         return shop.getItems();
      else
	 return null;
   }
}
