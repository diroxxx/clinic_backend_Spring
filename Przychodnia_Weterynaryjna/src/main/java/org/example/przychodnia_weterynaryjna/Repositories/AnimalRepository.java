package org.example.przychodnia_weterynaryjna.Repositories;


import org.example.przychodnia_weterynaryjna.models.Animal;
import org.springframework.data.repository.CrudRepository;

public interface AnimalRepository extends CrudRepository<Animal, Integer> {
}
