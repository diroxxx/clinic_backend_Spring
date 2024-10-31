package org.example.przychodnia_weterynaryjna.controllers;

import lombok.RequiredArgsConstructor;
import org.example.przychodnia_weterynaryjna.controllers.DTOs.AnimalTypeDto;
import org.example.przychodnia_weterynaryjna.controllers.DTOs.ServiceDto;
import org.example.przychodnia_weterynaryjna.controllers.mapers.AnimalTypeMapper;
import org.example.przychodnia_weterynaryjna.controllers.mapers.ServiceMapper;
import org.example.przychodnia_weterynaryjna.models.AnimalType;
import org.example.przychodnia_weterynaryjna.models.Service;
import org.example.przychodnia_weterynaryjna.services.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class ClinicController {
    private final ClientService clientService;
    private final AnimalService animalService;
    private final AnimalTypeService animalTypeService;
    private final ServiceTypeService serviceTypeService;
    private final ArticleService articleService;
    private final VetService vetService;
    private final UserService userService;
    private final AppointmentService appointmentService;

    private  final AnimalTypeMapper animalTypeMapper;
    private final ServiceMapper serviceMapper;

    @GetMapping("/animalTypes")
    public ResponseEntity<List<AnimalTypeDto>> getAnimalTypes(){

        List<AnimalType> animalTypeList = animalTypeService.getAnimalTypes();
        List<AnimalTypeDto> animalTypeDtoList = new ArrayList<>();

        for (AnimalType animalType : animalTypeList) {
            AnimalTypeDto animalTypeMapped = animalTypeMapper.AnimalToAnimalTypeDto(animalType);
            animalTypeDtoList.add(animalTypeMapped);
        }
        return ResponseEntity.ok(animalTypeDtoList);
    }
    @GetMapping("/infoAboutServices")
    public ResponseEntity<List<ServiceDto>> getServiceTypes(){

        List<Service> serviceList = serviceTypeService.printAllServices();
        List<ServiceDto> serviceDtoList = new ArrayList<>();
        serviceList.
                forEach(service -> serviceDtoList.add(serviceMapper.ServiceToServiceDto(service)));
        return ResponseEntity.ok(serviceDtoList);
    }

}
