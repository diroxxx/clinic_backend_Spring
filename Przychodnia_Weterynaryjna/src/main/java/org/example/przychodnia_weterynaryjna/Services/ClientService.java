package org.example.przychodnia_weterynaryjna.Services;

import org.example.przychodnia_weterynaryjna.Repositories.ClientRepository;
import org.example.przychodnia_weterynaryjna.models.Client;
import org.example.przychodnia_weterynaryjna.models.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

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
