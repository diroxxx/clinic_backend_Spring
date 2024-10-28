package org.example.przychodnia_weterynaryjna.services;

import lombok.RequiredArgsConstructor;
import org.example.przychodnia_weterynaryjna.repositories.AnimalRepository;
import org.example.przychodnia_weterynaryjna.models.Animal;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnimalService {

    private AnimalRepository animalRepository;

    public Optional<Animal> getAnimalById(int id) {
        return animalRepository.findById(id);
    }

    public List<Animal> getAllAnimalsByUserId(int userId) {
        return animalRepository.findAnimalsByClient_Id(userId);
    }

    public void add(Animal animal) {
        animalRepository.save(animal);
    }




}
