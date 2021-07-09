/**
 * 
 */
package com.accolite.kaisehai.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.accolite.kaisehai.common.MessageRequest;
import com.accolite.kaisehai.config.RabbitMQConfig;

/**
 * @author balwant.singh
 *
 */
@Component
public class MessageProducer {

	@Autowired
    private RabbitTemplate template;

	public void postDataToRabbitMQ(MessageRequest messageRequest) {
		
		template.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, messageRequest);
	}
}
