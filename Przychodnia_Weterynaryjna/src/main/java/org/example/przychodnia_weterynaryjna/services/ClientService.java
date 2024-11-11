package org.example.przychodnia_weterynaryjna.services;

import lombok.RequiredArgsConstructor;
import org.example.przychodnia_weterynaryjna.repositories.ClientRepository;
import org.example.przychodnia_weterynaryjna.models.Client;
import org.example.przychodnia_weterynaryjna.models.User;
import org.example.przychodnia_weterynaryjna.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;


    public Optional<Client> getClientById(int id) {
        return clientRepository.findById(id);
    }

    public Optional <Client> doesClientExists(String email, String password) {
        return clientRepository.findByUserEmailAndUserPassword(email, password);
    }

    public void registerClient(User user) {
        Client client = new Client(user);
        clientRepository.save(client);
    }

}
