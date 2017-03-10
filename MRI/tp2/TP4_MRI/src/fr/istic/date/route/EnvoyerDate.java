package fr.istic.date.route;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;

import java.util.Date;

import org.omg.PortableServer.THREAD_POLICY_ID;

import com.rabbitmq.client.Channel;

public class EnvoyerDate {

  private static final String EXCHANGE_NAME = "date_route";

  public static void main(String[] argv) throws Exception {
	  
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("localhost");
    Connection connection = factory.newConnection();
    Channel channel = connection.createChannel();

    channel.exchangeDeclare(EXCHANGE_NAME, "direct");
   
    
    while(true){

        String date = getDate();
        String dateGMT = getDateGMT();

        channel.basicPublish(EXCHANGE_NAME, "locale", null, date.getBytes("UTF-8"));
        System.out.println(" Date '" + date + "'");
        
        /**channel.basicPublish(EXCHANGE_NAME, "GMT", null, );
        System.out.println(" Date '" + date + "'");
        */
        
        Thread.sleep(1000);

    }    
    
    //channel.close();
    //connection.close();
  }
  

  private static String getDate(){
    return (new Date()).toString();
  }
  
  @SuppressWarnings("deprecation")
private static String getDateGMT(){
	  return (new Date()).toGMTString();
  }
/**
  private static String joinStrings(String[] strings, String delimiter) {
    int length = strings.length;
    if (length == 0) return "";
    StringBuilder words = new StringBuilder(strings[0]);
    for (int i = 1; i < length; i++) {
        words.append(delimiter).append(strings[i]);
    }
    return words.toString();
  }*/
}
