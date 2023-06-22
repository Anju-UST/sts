package com.ust.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.ust.rabbitmq.model.OrderStatus;
import com.ust.rabbitmq.config.MessagingConfig;

@Component
public class PurchaseOrderConsumer {
	
	@RabbitListener(queues="ust_queue")
	public void consumerMessageFromQueue(OrderStatus orderStatus)
	{
		System.out.println("message received from queue:"+ orderStatus);
	}
}
