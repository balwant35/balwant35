/**
 * 
 */
package com.accolite.kaisehai.service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.accolite.kaisehai.common.MessageRequest;
import com.accolite.kaisehai.consumer.MessageConsumer;
import com.accolite.kaisehai.entity.Inbox;
import com.accolite.kaisehai.entity.Message;
import com.accolite.kaisehai.entity.User;
import com.accolite.kaisehai.repository.InboxRepository;
import com.accolite.kaisehai.repository.MessageRepository;
import com.accolite.kaisehai.repository.UserRepository;

/**
 * @author balwant.singh
 *
 */

@Service
public class MessageService {

	@Autowired
	MessageRepository messageRepository;
	
	@Autowired
	InboxRepository inboxRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	MessageConsumer messageConsumer;
	
	@Autowired
	RedisTemplate<String, Object> redisTemplate;

	public Inbox sendMessage(MessageRequest messageRequest) {
		
		Message message = new Message();
		message.setMessage(messageRequest.getMessage());
		message = messageRepository.save(message);
		
		Inbox inbox = null;
		
		if (message != null) {
			inbox = new Inbox();
			User sender = userRepository.findById(messageRequest.getSender()).orElseThrow(NoSuchElementException::new);
			inbox.setSender(sender);
			User reciever = userRepository.findById(messageRequest.getReceiver()).orElseThrow(NoSuchElementException::new);
			inbox.setReceiver(reciever);
			inbox.setMessage(message);
			inbox.setSendTime(new Date());
			inbox = inboxRepository.save(inbox);
		}
		
		return inbox;
	}

	@SuppressWarnings("unchecked")
	public List<Message> getAllMessagesByUser(Integer userId, Pageable pageable) {

		List<Message> messages;
		final String key = Integer.toString(userId+pageable.getPageNumber());
		messages = (List<Message>) redisTemplate.opsForValue().get(key);
		
		if (messages == null || messages.size() == 0) {
			messages = messageRepository.findMessagesByUser(userId, pageable);
			redisTemplate.opsForValue().set(key, messages);
		}
		return messages;
	}

	public List<Message> getAllMessagesFromQueue(Integer userId) {
		Map<Integer, List<Message>> messages = messageConsumer.getMessages();
		return messages.get(userId);
	}

}
