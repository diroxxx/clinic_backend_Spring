package org.example.przychodnia_weterynaryjna.services;

import lombok.RequiredArgsConstructor;
import org.example.przychodnia_weterynaryjna.repositories.AnimalTypeRepository;
import org.example.przychodnia_weterynaryjna.models.AnimalType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnimalTypeService {

    private final AnimalTypeRepository animalTypeRepository;

//    @Cacheable
    public List<String> getAllAnimalTypes() {

        List<AnimalType> animalTypes = animalTypeRepository.findAll();
        return animalTypes.stream().map(AnimalType::getType)
                .toList();
    }

    public List<AnimalType> getAnimalTypes() {
        return animalTypeRepository.findAll();
    }

    public Optional <AnimalType> getAnimalTypeById(int id) {
        return animalTypeRepository.findById(id);
    }



}
