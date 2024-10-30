package org.example.przychodnia_weterynaryjna.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.przychodnia_weterynaryjna.repositories.VetRepository;
import org.example.przychodnia_weterynaryjna.models.User;
import org.example.przychodnia_weterynaryjna.models.Vet;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VetService {

    private final VetRepository vetRepository;

    public Optional<Vet> getVetById(int id) {
        return vetRepository.findById(id);
    }

    public Optional <Vet> doesVetExists(String email, String password) {
        return vetRepository.findByUserEmailAndUserPassword(email, password);
    }
    public List<Vet> getAllVets() {
        return (List<Vet>) vetRepository.findAll();
    }

    @Transactional
    public void registerVet(User user) {
        Vet vet = new Vet(user);
        vetRepository.save(vet);


    }


}
