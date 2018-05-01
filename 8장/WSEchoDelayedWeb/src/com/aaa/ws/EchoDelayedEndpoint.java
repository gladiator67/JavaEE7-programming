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
      session.getUserProperties().put("previousMsg", ""); // --- ич
   }
	
   @OnMessage
   public void message(Session session, String msg) {
      String prevMsg = (String) session.getUserProperties().get("previousMsg"); // --- иш
      session.getUserProperties().put("previousMsg", msg); // --- ищ

      try {
         session.getBasicRemote().sendText(prevMsg); // --- иъ
      } catch (IOException e) {
	 e.printStackTrace();
      }
   }
}
