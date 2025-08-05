package com.example.mvc.controllers;

import com.example.mvc.models.MessageForm;
import com.example.mvc.services.MessageListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Instant;

@Controller
public class HomeController {

    private final MessageListService messageListService;

    public HomeController(MessageListService messageListService) {
        this.messageListService = messageListService;
    }

    // Model is used to send information to the html page
    @GetMapping("/home")
    public String getHomePage(@ModelAttribute("newMessage") MessageForm newMessage, Model model) {

        // The attribute name should have the same name that is in home.html
        model.addAttribute("welcomeMessage", Instant.now().toString());
        model.addAttribute("greetings", this.messageListService.getMessages());

        return "home";
    }

    /**
     * Receive the message from a html form and add it to the list of messages.
     *
     * @PARAM - messageForm - The field values that come from the form
     * @PARAM - model - Use for give back information to the web page.
     *
     */

    @PostMapping("/home")
    public String addMessage(@ModelAttribute("newMessage") MessageForm messageForm, Model model) {
        messageListService.addMessage(messageForm);

        // The greetings should be the same in the html page, or would not show anything in the web page.
        model.addAttribute("greetings", messageListService.getMessages());
        messageForm.setText("");

        return "home";
    }
}
