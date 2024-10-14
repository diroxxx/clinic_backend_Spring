package org.example.przychodnia_weterynaryjna.Services;

import org.example.przychodnia_weterynaryjna.DTOs.RegisterDto;
import org.example.przychodnia_weterynaryjna.Repositories.VetRepository;
import org.example.przychodnia_weterynaryjna.models.User;
import org.example.przychodnia_weterynaryjna.models.Vet;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VetService {

    private VetRepository vetRepository;

    public VetService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    public Optional <Vet> doesVetExists(String email, String password) {
        return vetRepository.findByUserEmailAndUserPassword(email, password);
    }

    public void registerVet(RegisterDto registerDto) {
        Vet vet = new Vet();
        vet.setUser(new User(registerDto.getFirstName(),
                registerDto.getLastName(),
                registerDto.getEmail(),
                registerDto.getPhoneNumber(),
                registerDto.getPassword()));

    }


}
