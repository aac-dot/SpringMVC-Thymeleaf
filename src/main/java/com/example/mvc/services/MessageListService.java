package com.example.mvc.services;

import com.example.mvc.models.MessageForm;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Responsible for the messages things
 * Features:
 *  - Add a message to a list
 *  - Get the list of messages
 * */

@Service
public class MessageListService {

    private List<String> messages;

    public void addMessage(MessageForm message) {
        messages.add(message.getText());
    }

    public List<String> getMessages() {
        return messages;
    }

    @PostConstruct
    public void postConstruct() {
        this.messages = new ArrayList<>();
    }
}
