package com.aaa.ws;

import java.io.IOException;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/echoDelayed")
public class EchoDelayedEndpoint {
	
   @OnOpen
   public void open(Session session) {
      session.getUserProperties().put("previousMsg", ""); // --- ��
   }
	
   @OnMessage
   public void message(Session session, String msg) {
      String prevMsg = (String) session.getUserProperties().get("previousMsg"); // --- ��
      session.getUserProperties().put("previousMsg", msg); // --- ��

      try {
         session.getBasicRemote().sendText(prevMsg); // --- ��
      } catch (IOException e) {
	 e.printStackTrace();
      }
   }
}
