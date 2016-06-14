package com.userm;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

import java.io.IOException;

public class Send {
    private final static String QUEUE_NAME = "hello";

    public static void message(String s) throws IOException{

        //Server connection
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        //Publish message
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        String message = s;
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println(" OPERATION '" + message + "'");

        //close channel and connection
        channel.close();
        connection.close();
    }

}