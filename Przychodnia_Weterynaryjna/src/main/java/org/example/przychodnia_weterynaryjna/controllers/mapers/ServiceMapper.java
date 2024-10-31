package org.example.przychodnia_weterynaryjna.controllers.mapers;

import org.example.przychodnia_weterynaryjna.controllers.DTOs.ServiceDto;
import org.example.przychodnia_weterynaryjna.models.Service;

@org.springframework.stereotype.Service
public class ServiceMapper {


    public ServiceDto ServiceToServiceDto(Service service) {
        ServiceDto serviceDto = new ServiceDto();
        serviceDto.setName(service.getName());
        serviceDto.setPrice(service.getPrice());
        return serviceDto;
    }
}
