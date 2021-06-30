/**
 * 
 */
package com.accolite.kaisehai.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.kaisehai.common.MessageRequest;
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
	public ResponseEntity<Inbox> sendMessage(@Valid @RequestBody MessageRequest messageRequest) {
		
		Inbox inbox = messageService.sendMessage(messageRequest);
		return new ResponseEntity<Inbox>(inbox, HttpStatus.OK);
	}
	
	@GetMapping("/getAllMessagesByUser/{userId}")
	public List<Message> getAllMessagesByUser(@PathVariable("userId") Integer userId, @RequestParam("pageNum") Integer pageNum, @RequestParam("perPage") Integer perPage) {
		
		Pageable pageable = PageRequest.of(pageNum, perPage);
		
		List<Message> messages = messageService.getAllMessagesByUser(userId, pageable);
		return messages;
	}
}
