/**
 * 
 */
package com.accolite.kaisehai;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

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

}
