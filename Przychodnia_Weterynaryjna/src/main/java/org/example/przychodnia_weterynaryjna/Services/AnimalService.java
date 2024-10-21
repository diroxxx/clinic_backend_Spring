package org.example.przychodnia_weterynaryjna.Services;

import org.example.przychodnia_weterynaryjna.Repositories.AnimalRepository;
import org.example.przychodnia_weterynaryjna.models.Animal;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

    private AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public Optional<Animal> getAnimalById(int id) {
        return animalRepository.findById(id);
    }

    public List<Animal> getAllAnimalsByUserId(int userId) {
        return animalRepository.findAnimalsByClient_Id(userId);
    }




}
