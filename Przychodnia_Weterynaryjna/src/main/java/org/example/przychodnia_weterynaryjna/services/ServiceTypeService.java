package org.example.przychodnia_weterynaryjna.services;

import lombok.RequiredArgsConstructor;
import org.example.przychodnia_weterynaryjna.repositories.ServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServiceTypeService {

    private final ServiceRepository serviceRepository;


    public Optional<org.example.przychodnia_weterynaryjna.models.Service> getServiceById(int id) {
        return serviceRepository.findById(id);
    }

    public List<org.example.przychodnia_weterynaryjna.models.Service> printAllServices() {
        return serviceRepository.findAll();
    }
}
