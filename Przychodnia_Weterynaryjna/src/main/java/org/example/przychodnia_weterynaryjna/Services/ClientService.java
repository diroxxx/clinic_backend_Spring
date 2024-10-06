package org.example.przychodnia_weterynaryjna.Services;

import org.example.przychodnia_weterynaryjna.Repositories.ClientRepository;
import org.example.przychodnia_weterynaryjna.models.Client;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

   public String printFirst() {
        Optional<Client> client = clientRepository.findById(1);
        return client.map(value -> value.getId() + value.getUser().getFirstName()).orElse("nie ma");
    }
}
