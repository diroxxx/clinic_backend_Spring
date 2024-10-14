package org.example.przychodnia_weterynaryjna.Repositories;

import org.example.przychodnia_weterynaryjna.models.Article;
import org.example.przychodnia_weterynaryjna.models.Vet;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface VetRepository extends CrudRepository<Vet, Integer> {

    Optional<Vet> findByUserEmailAndUserPassword(String useremail, String password);


}
