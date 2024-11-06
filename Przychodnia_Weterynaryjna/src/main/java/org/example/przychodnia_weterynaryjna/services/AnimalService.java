package org.example.przychodnia_weterynaryjna.services;

import lombok.RequiredArgsConstructor;
import org.example.przychodnia_weterynaryjna.repositories.AnimalRepository;
import org.example.przychodnia_weterynaryjna.models.Animal;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public Optional<Animal> getAnimalById(int id) {
        return animalRepository.findById(id);
    }


    public List<Animal> getAllAnimalsByClientId(int userId) {
        List<Animal> animalsByClientId = animalRepository.findAnimalsByClient_Id(userId);
//        System.out.println(animalsByClientId.size());
        if (animalsByClientId.isEmpty()) {
            return Collections.emptyList();
        }
        return animalsByClientId ;
    }

    public void add(Animal animal) {
        animalRepository.save(animal);
    }




}
