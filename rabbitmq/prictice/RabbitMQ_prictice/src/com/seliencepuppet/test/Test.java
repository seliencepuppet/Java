package com.seliencepuppet.test;


import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class Test {
	private static final String TASK_QUEUE_NAME = "Queue111111";
	
	public static void main(String[] args) {
		ConnectionFactory factory = new ConnectionFactory();
		System.out.println("factory successful!!!");
		factory.setHost("10.203.206.234");
		factory.setPort(5672);
		factory.setUsername("hitrader");
		factory.setPassword("hitrader123");
		factory.setVirtualHost("/");
		
		try {
			System.out.println("connected successful!!!");
			Connection connection = factory.newConnection();
			Channel channel = connection.createChannel();
			
			//channel.exchangeDeclare("zhenshiceshi", BuiltinExchangeType.DIRECT);
			//channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);
			
			channel.queueBind(TASK_QUEUE_NAME, "zhenshiceshi", "111111");
			channel.basicQos(1);
			
			final Consumer consumer = new DefaultConsumer(channel){
				public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
					String message = new String(body, "UTF-8");
					System.out.println(message);
					channel.basicAck(envelope.getDeliveryTag(), false);
				}
			};
			
			channel.basicConsume(TASK_QUEUE_NAME, false, consumer);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}
}
