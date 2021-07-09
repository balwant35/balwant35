/**
 * 
 */
package com.accolite.kaisehai.consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.accolite.kaisehai.common.MessageRequest;
import com.accolite.kaisehai.config.RabbitMQConfig;
import com.accolite.kaisehai.entity.Inbox;
import com.accolite.kaisehai.entity.Message;
import com.accolite.kaisehai.service.MessageService;

/**
 * @author balwant.singh
 *
 */
@Component
public class MessageConsumer {

	@Autowired
	MessageService messageService;
	
	ConcurrentHashMap<Integer, List<Message>> messageMap = new ConcurrentHashMap<>();
	
	@RabbitListener(queues = RabbitMQConfig.QUEUE)
	public void consumeMessagesFromQueue(MessageRequest messageRequest) {
		
		Inbox inbox = messageService.sendMessage(messageRequest);
		List<Message> messages = messageMap.get(inbox.getReceiver().getId());
		
		if (messages == null) {
			messages = new ArrayList<>();
			messages.add(inbox.getMessage());
		}
		else {
			messages.add(inbox.getMessage());
		}
		messageMap.put(inbox.getReceiver().getId(), messages);
	}

	public Map<Integer, List<Message>> getMessages() {
		return messageMap;
		
	}
	
}
