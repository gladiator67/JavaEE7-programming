package com.aaa.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Message-Driven Bean implementation class for: MDBReceiver
 */
@MessageDriven(
   activationConfig = { @ActivationConfigProperty(
       propertyName = "destination", 
              propertyValue = "java:/jboss/exported/jms/queue/TestQueue"), 
			@ActivationConfigProperty(
	propertyName = "destinationType", propertyValue = "javax.jms.Queue")
   }, mappedName = "java:/queue/testQueue")
public class MDBReceiver implements MessageListener {

    /**
     * Default constructor. 
     */
    public MDBReceiver() {
        // TODO Auto-generated constructor stub
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
        // TODO Auto-generated method stub
    	TextMessage m = (TextMessage)message;
        try {
           System.out.println("From Message-Driven Bean : " + m.getText());
        }
        catch (JMSException e) {
           e.getMessage();
        }
    }
}
