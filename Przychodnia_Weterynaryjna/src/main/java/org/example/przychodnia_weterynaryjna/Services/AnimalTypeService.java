package org.example.przychodnia_weterynaryjna.Services;

import org.example.przychodnia_weterynaryjna.Repositories.AnimalTypeRepository;
import org.example.przychodnia_weterynaryjna.models.AnimalType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnimalTypeService {

    private final AnimalTypeRepository animalTypeRepository;

    public AnimalTypeService(AnimalTypeRepository animalTypeRepository) {
        this.animalTypeRepository = animalTypeRepository;
    }

    public List<String> getAllAnimalTypes() {

        List<AnimalType> animalTypes = (List<AnimalType>) animalTypeRepository.findAll();
        List<String> animalTypesList = new ArrayList<>();
        animalTypes.forEach(x -> animalTypesList.add(x.getType()));
        return animalTypesList;
    }

}
