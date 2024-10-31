package org.example.przychodnia_weterynaryjna.controllers.mapers;

import org.example.przychodnia_weterynaryjna.controllers.DTOs.AnimalTypeDto;
import org.example.przychodnia_weterynaryjna.models.AnimalType;
import org.springframework.stereotype.Service;


@Service
public class AnimalTypeMapper {

    public AnimalTypeDto AnimalToAnimalTypeDto(AnimalType animalType) {
        AnimalTypeDto animalTypeDto = new AnimalTypeDto();
        animalTypeDto.setType(animalType.getType());
        return animalTypeDto;
    }
}
