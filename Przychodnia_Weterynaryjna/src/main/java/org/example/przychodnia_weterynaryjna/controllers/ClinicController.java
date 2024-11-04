package org.example.przychodnia_weterynaryjna.controllers;

import lombok.RequiredArgsConstructor;
import org.example.przychodnia_weterynaryjna.controllers.DTOs.*;
import org.example.przychodnia_weterynaryjna.controllers.mapers.AnimalTypeMapper;
import org.example.przychodnia_weterynaryjna.controllers.mapers.ServiceMapper;
import org.example.przychodnia_weterynaryjna.controllers.mapers.VetMapper;
import org.example.przychodnia_weterynaryjna.models.AnimalType;
import org.example.przychodnia_weterynaryjna.models.Client;
import org.example.przychodnia_weterynaryjna.models.Service;
import org.example.przychodnia_weterynaryjna.models.Vet;
import org.example.przychodnia_weterynaryjna.services.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    private final VetMapper vetMapper;

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


    @PostMapping("/login")
    public ResponseEntity<LoggedUser>  login(@RequestBody LogInDto loginDto){
        LoggedUser loggedUser = new LoggedUser();
        System.out.println(loginDto);

        if (loginDto.getRole().equals("vet") ){
           Optional <Vet> isVetExist = vetService.doesVetExists(loginDto.getEmail(), loginDto.getPassword());
           if (isVetExist.isPresent()){
                loggedUser.setId(isVetExist.get().getId());
                loggedUser.setUserVet(true);
           }
        } else {
            Optional<Client> clientExist = clientService.doesClientExists(loginDto.getEmail(), loginDto.getPassword());
            if (clientExist.isPresent()){
                loggedUser.setId(clientExist.get().getId());
                loggedUser.setUserVet(false);
            }
        }
        return ResponseEntity.ok(loggedUser);
    }

    @GetMapping("/vets")
    public ResponseEntity<List<VetDto>>  getVets() {
        List<Vet> vets = vetService.getAllVets();
        return ResponseEntity.ok( vets.stream()
                .map(vetMapper::VetMapToVetDto)
                .toList());
    }
}
