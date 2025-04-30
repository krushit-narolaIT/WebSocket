package com.krushit.controller;

import com.krushit.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class ChatController {

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public Message send(Message message) throws Exception {
        System.out.println("Received message from " + message.getUsername() + ": " + message.getContent());
        return new Message(message.getUsername(), HtmlUtils.htmlEscape(message.getContent()));
    }
}