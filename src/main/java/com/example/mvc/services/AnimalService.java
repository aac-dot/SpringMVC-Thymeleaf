package com.example.mvc.services;

import com.example.mvc.models.AnimalForm;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AnimalService {

    private List<AnimalForm> animals;

    @PostConstruct
    public void postConstruct() {
        animals = new ArrayList<AnimalForm>();
    }

    public void addAnimal(AnimalForm animal) {

        animals.add(new AnimalForm(animal.getName(), animal.getAdjective()));
    }

    public List<AnimalForm> getAnimals() {
        return animals;
    }
}
