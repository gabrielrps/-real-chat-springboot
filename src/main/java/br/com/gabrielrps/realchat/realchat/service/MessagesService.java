package br.com.gabrielrps.realchat.realchat.service;

import br.com.gabrielrps.realchat.realchat.model.MessageChat;
import br.com.gabrielrps.realchat.realchat.payload.Message;
import br.com.gabrielrps.realchat.realchat.payload.MessageChatRequest;
import br.com.gabrielrps.realchat.realchat.repo.MessagesRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class MessagesService {

    private final MessagesRepository messagesRepository;

    public MessagesService(MessagesRepository messagesRepository) {
        this.messagesRepository = messagesRepository;
    }

    public void saveMessage(MessageChatRequest messageChatRequest) {
        MessageChat messageChat = new MessageChat();
        messageChat.setFrom(messageChatRequest.getFrom());
        messageChat.setTo(messageChatRequest.getTo());
        messageChat.setContent(messageChatRequest.getContent());

        messagesRepository.save(messageChat);

    }

    public List<Message> getMessagesGroup() {
        List<MessageChat> lista = messagesRepository.findAllByTo("global");

        List<Message> listaRet= new ArrayList<>();

        for (MessageChat m : lista){
            listaRet.add(new Message(m.getFrom(), m.getContent()));
        }

        return listaRet;
    }

    public List<Message> getMessagesGroupPrivado(MessageChatRequest messageChatRequest) {
        Collection<MessageChat> lista = messagesRepository.findAllByFromAndToOrToAndFrom(messageChatRequest.getFrom(), messageChatRequest.getTo());

        List<Message> listaRet= new ArrayList<>();

        for (MessageChat m : lista){
            listaRet.add(new Message(m.getFrom(), m.getContent()));
        }

        return listaRet;
    }
}
