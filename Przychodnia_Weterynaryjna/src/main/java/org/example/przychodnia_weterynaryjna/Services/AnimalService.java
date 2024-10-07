package org.example.przychodnia_weterynaryjna.Services;

import org.example.przychodnia_weterynaryjna.Repositories.AnimalRepository;
import org.example.przychodnia_weterynaryjna.models.Animal;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {

    private AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }



}
