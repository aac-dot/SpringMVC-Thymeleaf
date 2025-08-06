package com.example.mvc.controllers;

import com.example.mvc.models.AnimalForm;
import com.example.mvc.services.AnimalService;
import org.apache.juli.logging.Log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/animal")
public class AnimalController {

   private static final Logger log = LoggerFactory.getLogger(AnimalController.class);

    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping
    public String getAnimals(@ModelAttribute("animalForm") AnimalForm animalForm, Model model) {
        model.addAttribute("animals", animalService.getAnimals());

        return "animal";
    }

    @PostMapping
    public String createAnimal(@ModelAttribute("animalForm") AnimalForm animalForm, Model model) {
        animalService.addAnimal(animalForm);
        log.info("Animal in service: {}", animalService.getAnimals().getFirst().getName());

        model.addAttribute("animals", animalService.getAnimals());
        log.info("Animal in model: {}", model.getAttribute("animals"));

        animalForm.setName("");
        animalForm.setAdjective("");

        return "animal";
    }
}
