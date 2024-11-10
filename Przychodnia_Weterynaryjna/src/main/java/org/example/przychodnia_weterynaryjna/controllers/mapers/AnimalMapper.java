package org.example.przychodnia_weterynaryjna.controllers.mapers;

import lombok.RequiredArgsConstructor;
import org.example.przychodnia_weterynaryjna.controllers.DTOs.AnimalDto;
import org.example.przychodnia_weterynaryjna.controllers.DTOs.AnimalNameDto;
import org.example.przychodnia_weterynaryjna.controllers.DTOs.AnimalRegisterDto;
import org.example.przychodnia_weterynaryjna.models.Animal;
import org.example.przychodnia_weterynaryjna.services.AnimalTypeService;
import org.example.przychodnia_weterynaryjna.services.ClientService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnimalMapper {
    private final ClientService clientService;
    private final AnimalTypeService animalTypeService;



    public AnimalNameDto AnimalMapToAnimalNameDto(Animal animal) {
        AnimalNameDto animalNameDto = new AnimalNameDto();
        animalNameDto.setId(animal.getId());
        animalNameDto.setName(animal.getName());
        return animalNameDto;
    }

    public Animal animalRegisterDtoToAnimal(AnimalRegisterDto animalRegisterDto) {
        Animal animal = new Animal();
        animal.setName(animalRegisterDto.getName());
        animal.setAnimalType(
                animalTypeService.getAnimalTypeById(animalRegisterDto.getTypeId()).orElse(null)
        );
        animal.setClient(
                clientService.getClientById(animalRegisterDto.getClientId()).orElse(null)
        );

        return animal;
    }

    public AnimalDto AnimalMapToAnimalDto(Animal animal) {
        AnimalDto animalDto = new AnimalDto();
        animalDto.setType(animal.getAnimalType().getType());
        animalDto.setId(animal.getId());
        animalDto.setName(animal.getName());
        return animalDto;
    }


}
