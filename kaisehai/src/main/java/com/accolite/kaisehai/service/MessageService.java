/**
 * 
 */
package com.accolite.kaisehai.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.kaisehai.common.MessageRequest;
import com.accolite.kaisehai.common.MessageResponse;
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

	public Inbox sendMessage(MessageRequest messageRequest) {
		
		Message message = new Message();
		message.setMessage(messageRequest.getMessage());
		message = messageRepository.save(message);
		
		Inbox inbox = new Inbox();
		
		if (message != null) {
			User sender = userRepository.getById(messageRequest.getSender());
			inbox.setSender(sender);
			User reciever = userRepository.getById(messageRequest.getReciever());
			inbox.setReceiver(reciever);
			inbox.setMessage(message);
			inbox.setSendTime(new Date());
		}
		
		return inboxRepository.save(inbox);
	}

	public List<Message> getAllMessagesByUser(Integer userId) {

		User user = userRepository.getById(userId);
		return user.getMessages();
	}

}
