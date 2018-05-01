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
	 shop.setName("�ۼ�");
	 shop.setPhoneNo(5556666);
	 shop.setShopAddr("����� ������ 1-2����");
			
	 Item item1 = new Item();
	 item1.setName("��ī");
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
	 item3.setName("ķ�ڴ�");
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
	 shop.setName("22����");
	 shop.setPhoneNo(3334444);
	 shop.setShopAddr("����� ���빮�� 5-6����");
			
	 Item item1 = new Item();
	 item1.setName("������");
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
	 item3.setName("�����");
	 item3.setColor("white");
	 item3.setPrice(70000);
	 item3.setProvider("Samcung");
	 item3.setShop(shop);
			
	 shop.getItems().add(item1);
	 shop.getItems().add(item2);
	 shop.getItems().add(item3);
	 em.persist(shop);
      }else
	 System.out.println("�Է� �Ϸ�!!");
      }

   @Override
   public String getShopInfo(String shopID) {
      // TODO Auto-generated method stub
      Shop shop = em.find(Shop.class, shopID);
		
      if(shop != null) {
         String shop_info = "���� �̸� : " + shop.getName() + ",��ȭ��ȣ : " + 
                    shop.getPhoneNo() + ", �ּ� : " + shop.getShopAddr();
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
