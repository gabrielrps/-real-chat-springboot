package br.com.gabrielrps.realchat.realchat.controllers;

import br.com.gabrielrps.realchat.realchat.payload.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class ChatController {

    private final SimpMessagingTemplate template;

    public ChatController(SimpMessagingTemplate template) {
        this.template = template;
    }

    @MessageMapping("/send")
    public void sendMessage(@Payload Message message){
        message.setTimestamp(LocalDateTime.now().toString());

        template.convertAndSend("/topic/"+message.getTopic(), message);
    }

}
