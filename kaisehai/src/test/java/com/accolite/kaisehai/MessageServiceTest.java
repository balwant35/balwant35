/**
 * 
 */
package com.accolite.kaisehai;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import com.accolite.kaisehai.common.MessageRequest;
import com.accolite.kaisehai.entity.Inbox;
import com.accolite.kaisehai.entity.Message;
import com.accolite.kaisehai.repository.MessageRepository;
import com.accolite.kaisehai.service.MessageService;

/**
 * @author balwant.singh
 *
 */

@ExtendWith(MockitoExtension.class)
public class MessageServiceTest {

	@Autowired
	MessageService messageService;
	
	@Mock
	MessageRepository messageRepository;
	
	@Test
	public void sendMessage() {
		
		Message message = new Message();
		message.setId(-2051916669);
		message.setMessage("Hi Dear, How are you..");
		Mockito.when(messageRepository.save(message)).thenReturn(message);
		
		Inbox actualInbox = messageService.sendMessage(new MessageRequest("Hi Dear, How are you..", 226342312, 694514746));
		Assertions.assertThat(actualInbox.getMessage().getId()).isEqualByComparingTo(message.getId());
	}
	
	@Test
	public void getAllMessagesByUserTest() {
		
		List<Message> expectedMessages = Stream
				.of(new Message(-2051916669, "Hi", null),
						new Message(-2051916670, "Dear", null),
						new Message(-2051916671, "Welcome to kaisehai chat app", null))
					.collect(Collectors.toList());
		
		Mockito.when(messageRepository.findMessagesByUser(226342312, PageRequest.of(1, 10)))
		.thenReturn(expectedMessages);
		
		List<Message> actualMessages = messageService.getAllMessagesByUser(226342312, PageRequest.of(1, 3));
		Assertions.assertThat(actualMessages.size()).isEqualTo(expectedMessages.size());
	}
}
