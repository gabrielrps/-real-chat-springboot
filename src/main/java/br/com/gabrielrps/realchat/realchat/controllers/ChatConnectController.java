package br.com.gabrielrps.realchat.realchat.controllers;

import br.com.gabrielrps.realchat.realchat.model.User;
import br.com.gabrielrps.realchat.realchat.payload.Message;
import br.com.gabrielrps.realchat.realchat.payload.MessageChatRequest;
import br.com.gabrielrps.realchat.realchat.service.MessagesService;
import br.com.gabrielrps.realchat.realchat.service.UserOnlineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ChatConnectController {

    private final UserOnlineService userOnlineService;
    private final MessagesService messagesService;

    public ChatConnectController(UserOnlineService userOnlineService, MessagesService messagesService) {
        this.userOnlineService = userOnlineService;
        this.messagesService = messagesService;
    }

    @GetMapping("/getUsersConnect/{username}")
    public ResponseEntity<List<User>> getUsersConnect(@PathVariable("username") String username){
        return new ResponseEntity<List<User>>(userOnlineService.getUsersConnect(username), HttpStatus.OK);
    }

    @PostMapping("/saveMessage")
    public void saveMessage(@RequestBody MessageChatRequest messageChatRequest){
        messagesService.saveMessage(messageChatRequest);
    }

    @GetMapping("/getMessagesGroupGlobal")
    public ResponseEntity<List<Message>> getMessagesGroupGlobal(){
        return new ResponseEntity<List<Message>>(messagesService.getMessagesGroup(), HttpStatus.OK);
    }

    @PostMapping("/getMessagesGroup")
    public ResponseEntity<List<Message>> getMessagesGroup(@RequestBody MessageChatRequest messageChatRequest){
        return new ResponseEntity<List<Message>>(messagesService.getMessagesGroupPrivado(messageChatRequest), HttpStatus.OK);
    }


}
