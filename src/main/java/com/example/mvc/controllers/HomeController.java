package com.example.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Instant;

@Controller
public class HomeController {

    // Model is used to send information to the html page
    @RequestMapping("/home")
    public String getHomePage(Model model) {

        // The attribute name should have the same name that is in home.html
        model.addAttribute("welcomeMessage", Instant.now().toString());
        model.addAttribute("greetings", new String[]{"Hi", "Hello", "Goodbye"});

        return "home";
    }
}
