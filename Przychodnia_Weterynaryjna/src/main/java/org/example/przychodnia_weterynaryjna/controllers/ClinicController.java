package org.example.przychodnia_weterynaryjna.controllers;

import lombok.RequiredArgsConstructor;
import org.example.przychodnia_weterynaryjna.controllers.DTOs.*;
import org.example.przychodnia_weterynaryjna.controllers.mapers.*;
import org.example.przychodnia_weterynaryjna.models.*;
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
    private final AppointmentMapper appointmentMapper;
    private final AnimalMapper animalMapper;

    private  final AnimalTypeMapper animalTypeMapper;
    private final ServiceMapper serviceMapper;
    public final UserMapper userMapper;

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

    @PostMapping("/reservation")
    public ResponseEntity<String> registerAppointment(@RequestBody AppointmentDto appointmentDto) {
//        System.out.println(appointmentDto);
        Appointment appointment = appointmentMapper.appointmentDtoToAppointment(
                appointmentDto
        );
        appointmentService.makeAppointment(appointment);

        return ResponseEntity.ok("Appointment registered successfully");
    }

    @GetMapping("/typeOfServices")
    public ResponseEntity<List<ServiceTypeDto>> getTypesOfServices() {

        List<Service> services = serviceTypeService.printAllServices();
        return ResponseEntity.ok(services.stream()
                .map(serviceMapper::ServiceMapperToServiceTypeDto)
                .toList());
    }

    @GetMapping("/animalsNames")
    public ResponseEntity<List<AnimalNameDto>> getAnimalNames(@RequestParam int userId)  {

        List<Animal> animals = animalService.getAllAnimalsByClientId(userId);

        return ResponseEntity.ok(animals.stream()
                .map(animalMapper::AnimalMapToAnimalNameDto)
                .toList());
    }

    @GetMapping("/appointments")
    public ResponseEntity<List<AppointmentClientDto>> getAllAppointments(@RequestParam int clientId)  {
        List<AppointmentStatus> appointmentStatuses = List.of(AppointmentStatus.canceled, AppointmentStatus.completed, AppointmentStatus.scheduled);
        List<Appointment> appointments = appointmentService.getAppointmentsByClientId(appointmentStatuses, clientId);
        System.out.println(appointments.size());
        return ResponseEntity.ok(appointments.stream()
                .map(appointmentMapper::AppointmentToAppointmentClientDto)
                .toList());
    }
    @PostMapping("/animalRegister")
    public ResponseEntity<String> registerAnimal(@RequestBody AnimalRegisterDto animalRegisterDto ) {
        Animal animal = animalMapper.animalRegisterDtoToAnimal(animalRegisterDto);
        animalService.add(animal);
        return ResponseEntity.ok("Animal registered successfully");
    }

    @GetMapping("/animals")
    public ResponseEntity<List<AnimalDto>> getAnimalsByClientId(@RequestParam int clientId)  {
        List<Animal> animals = animalService.getAllAnimalsByClientId(clientId);
        return ResponseEntity.ok(animals.stream()
                .map(animalMapper::AnimalMapToAnimalDto)
                .toList());
    }

    @GetMapping("/vets/articles")
    public ResponseEntity<List<VetArticleDto>> getVetsArticles() {
        List<VetArticleDto> articleDtos = articleService.getAllArticle();
        return ResponseEntity.ok(articleDtos);

    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody RegisterDto registerDto ) {
        User user = userMapper.RegisterDtoMapToUser(registerDto);
        User savedUser = userService.registerUser(user);


        if (registerDto.getRole().equals("vet")) {
            vetService.registerVet(savedUser);
        } else if (registerDto.getRole().equals("client")) {
            clientService.registerClient(savedUser);
        } else {
            return ResponseEntity.badRequest().body("Invalid role");
        }
        return ResponseEntity.ok("User registered successfully as " + user.getFirstName() + " " + registerDto.getRole());
    }

}
