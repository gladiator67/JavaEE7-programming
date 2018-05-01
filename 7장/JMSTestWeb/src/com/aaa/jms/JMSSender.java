package com.aaa.jms;

import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.naming.Context;
import javax.naming.InitialContext;

public class JMSSender {

   private Queue queue;
   private JMSContext context;

   public JMSSender() {
      try {
         Context ctx = new InitialContext();
         ConnectionFactory cf = (ConnectionFactory)ctx.lookup("java:/ConnectionFactory");
         context = cf.createContext();
			
         queue = (Queue) ctx.lookup("java:/jboss/exported/jms/queue/TestQueue");
      } catch (Exception e) {
    	 System.out.println(e.getMessage());
      }
   }
   
   public void sendMessage(String txt) {
      try {    
         context.createProducer().send(queue, txt);
	 context.close();
      }
      catch (Exception e) {
	 e.printStackTrace();
      }
   } 
}
