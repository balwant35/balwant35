/**
 * 
 */
package com.accolite.kaisehai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.kaisehai.common.MessageRequest;
import com.accolite.kaisehai.common.MessageResponse;
import com.accolite.kaisehai.entity.Inbox;
import com.accolite.kaisehai.entity.Message;
import com.accolite.kaisehai.service.MessageService;

/**
 * @author balwant.singh
 *
 */

@RestController
@RequestMapping("/message")
public class MessageController {

	@Autowired
	MessageService messageService;
	
	@PostMapping("/sendMessage")
	public MessageResponse sendMessage(@RequestBody MessageRequest messageRequest) {
		
		MessageResponse response = new MessageResponse();
		Inbox inbox = messageService.sendMessage(messageRequest);
		if (inbox != null) {
			response.setStatusCode(HttpStatus.OK);
			response.setStatusMessage("Message sent to "+inbox.getReceiver().getName());
		} 
		else {
			response.setStatusCode(HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	
	@GetMapping("/getAllMessagesByUser/{userId}")
	public List<Message> getAllMessagesByUser(@PathVariable("userId") Integer userId) {
		
		List<Message> messages = messageService.getAllMessagesByUser(userId);
		return messages;
	}
}
