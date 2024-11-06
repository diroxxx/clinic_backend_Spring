package org.example.przychodnia_weterynaryjna.repositories;


import org.example.przychodnia_weterynaryjna.models.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {
    List<Animal> findAnimalsByClient_Id(int id);
}
