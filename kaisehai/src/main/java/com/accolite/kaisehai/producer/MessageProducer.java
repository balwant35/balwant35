/**
 * 
 */
package com.accolite.kaisehai.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.accolite.kaisehai.config.RabbitMQConfig;
import com.accolite.kaisehai.entity.Inbox;

/**
 * @author balwant.singh
 *
 */
@Component
public class MessageProducer {

	@Autowired
    private RabbitTemplate template;

	public void postDataToRabbitMQ(Inbox inbox) {
		
		template.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, inbox);
	}
}
