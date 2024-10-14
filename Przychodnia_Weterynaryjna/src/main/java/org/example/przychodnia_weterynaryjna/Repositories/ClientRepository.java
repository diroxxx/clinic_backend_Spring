package org.example.przychodnia_weterynaryjna.Repositories;

import org.example.przychodnia_weterynaryjna.models.Client;
import org.example.przychodnia_weterynaryjna.models.Vet;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClientRepository extends CrudRepository<Client, Integer> {

    Optional<Client> findByUserEmailAndUserPassword(String useremail, String password);

}
