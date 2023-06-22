package com.ust.rabbitmq.config;

import org.springframework.context.annotation.Configuration;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MessagingConfig {
	public static final String QUEUE="ust_queue";
	public static final String EXCHANGE="ust_exchange";
	public static final String ROUTING_KEY="ust_routingKey";
	//ROUTINGKEY binds message and queue


@Bean
public Queue queue() {
	return new Queue(QUEUE);
}


@Bean
public TopicExchange exchange() {
	return new TopicExchange(EXCHANGE);
}

@Bean
public Binding binding(Queue queue, TopicExchange exchange) {
	return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
}


@Bean
public MessageConverter converter() {
	return new Jackson2JsonMessageConverter();
}

@Bean
public AmqpTemplate template(ConnectionFactory connectionFactory)//factory design pattern --autoinjected
//manage connection between producer to consumer ,producer to queue 
{
	final RabbitTemplate template= new RabbitTemplate(connectionFactory);
	template.setMessageConverter(converter());
	return template;
}
//spring ioc container will call the function annotated with @Bean
}
//rabbitmq-plugins enable rabbitmq_management
//https://www.onlinetutorialspoint.com/windows/how-to-install-rabbitmq-on-windows-10.html
//rabbitmq-service.bat stop 
//rabbitmq-service.bat install 
//rabbitmq-service.bat start 
