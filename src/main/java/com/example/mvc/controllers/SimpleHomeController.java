package com.example.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SimpleHomeController {

    @RequestMapping("/simplehome")
    public String getSimpleHome(Model model) {
        model.addAttribute("firstVisit", true);

        return "simplehome";
    }
}
