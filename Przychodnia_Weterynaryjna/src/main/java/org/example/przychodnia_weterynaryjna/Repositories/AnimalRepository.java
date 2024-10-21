package org.example.przychodnia_weterynaryjna.Repositories;


import org.example.przychodnia_weterynaryjna.models.Animal;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnimalRepository extends CrudRepository<Animal, Integer> {
    List<Animal> findAnimalsByClient_Id(int id);
}
