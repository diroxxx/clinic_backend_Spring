package org.example.przychodnia_weterynaryjna.Services;

import org.example.przychodnia_weterynaryjna.DTOs.RegisterDto;
import org.example.przychodnia_weterynaryjna.Repositories.UserRepository;
import org.example.przychodnia_weterynaryjna.Repositories.VetRepository;
import org.example.przychodnia_weterynaryjna.models.User;
import org.example.przychodnia_weterynaryjna.models.Vet;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VetService {

    private final VetRepository vetRepository;

    public VetService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    public Optional <Vet> doesVetExists(String email, String password) {
        return vetRepository.findByUserEmailAndUserPassword(email, password);
    }

    public void registerVet(User user) {
        Vet vet = new Vet(user);
        vetRepository.save(vet);
    }


}
