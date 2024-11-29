package com.example.API.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.converter.SimpleMessageConverter;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.example.API.Model.ChatMessage;


@Controller

public class ChatController {

	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;
	
	
	@MessageMapping("/message")
    @SendTo("/chats/public")
	public ChatMessage receivePublicChatMessage(@Payload ChatMessage message) {
		System.out.println(message);
        return message;
    }
	
	@MessageMapping("/private-message")
    @SendTo("/chats/public")
	public ChatMessage receivePrivateChatMessage(@Payload ChatMessage message) {
		
		simpMessagingTemplate.convertAndSendToUser(message.getReceiverName(), "/private",message);
        return message;
    }
}
