package org.example.przychodnia_weterynaryjna.Services;

import org.example.przychodnia_weterynaryjna.Repositories.ServiceRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceTypeService {

    private ServiceRepository serviceRepository;

    public ServiceTypeService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }


    public List<org.example.przychodnia_weterynaryjna.models.Service> printAllServices() {
        Iterable<org.example.przychodnia_weterynaryjna.models.Service> services = serviceRepository.findAll();
        List<org.example.przychodnia_weterynaryjna.models.Service> list = new ArrayList<>();
        services.forEach(list::add);
        return list;
    }
}
