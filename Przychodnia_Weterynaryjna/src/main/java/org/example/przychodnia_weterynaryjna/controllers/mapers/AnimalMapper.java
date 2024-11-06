package org.example.przychodnia_weterynaryjna.controllers.mapers;

import org.example.przychodnia_weterynaryjna.controllers.DTOs.AnimalNameDto;
import org.example.przychodnia_weterynaryjna.models.Animal;
import org.springframework.stereotype.Service;

@Service
public class AnimalMapper {

    public AnimalNameDto AnimalMapToAnimalNameDto(Animal animal) {
        AnimalNameDto animalNameDto = new AnimalNameDto();
        animalNameDto.setId(animal.getId());
        animalNameDto.setName(animal.getName());
        return animalNameDto;
    }
}
