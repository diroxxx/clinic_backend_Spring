package org.example.przychodnia_weterynaryjna.repositories;

import org.example.przychodnia_weterynaryjna.models.Vet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VetRepository extends JpaRepository<Vet, Integer> {

    Optional<Vet> findByUserEmailAndUserPassword(String useremail, String password);


}
