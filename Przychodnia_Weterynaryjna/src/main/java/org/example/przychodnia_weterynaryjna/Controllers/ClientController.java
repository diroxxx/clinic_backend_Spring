package org.example.przychodnia_weterynaryjna.Controllers;

import jakarta.servlet.http.HttpSession;
import org.example.przychodnia_weterynaryjna.DTOs.AnimalRegisterDto;
import org.example.przychodnia_weterynaryjna.DTOs.AppointmentDto;
import org.example.przychodnia_weterynaryjna.Services.*;
import org.example.przychodnia_weterynaryjna.models.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController {
    private final ClientService clientService;
    private final AnimalService animalService;
    private final AnimalTypeService animalTypeService;
    private final ServiceTypeService serviceTypeService;
    private final ArticleService articleService;
    private final VetService vetService;
    private final UserService userService;
    private final AppointmentService appointmentService;

    public ClientController(ClientService clientService,
                          AnimalService animalService,
                          AnimalTypeService animalTypeService,
                          ServiceTypeService serviceTypeService,
                          ArticleService articleService,
                          VetService vetService,
                          UserService userService,
                            AppointmentService appointmentService) {
        this.clientService = clientService;
        this.animalService = animalService;
        this.animalTypeService = animalTypeService;
        this.serviceTypeService = serviceTypeService;
        this.articleService = articleService;
        this.vetService = vetService;
        this.userService = userService;
        this.appointmentService = appointmentService;
    }

    public @GetMapping("/Site")
    String clientPage(Model model, HttpSession session) {
        Client client = (Client) session.getAttribute("client");

        if (client == null) {
            return "redirect:/home/login-Site";
        }
        System.out.println(client);
        model.addAttribute("client", client);
        model.addAttribute("appointmentBook", new AppointmentDto());
        model.addAttribute("animalRegister", new AnimalRegisterDto());

        List<AppointmentStatus> appointmentStatuses = List.of(AppointmentStatus.canceled, AppointmentStatus.completed);
        List<Appointment> appointmentsByUserId = appointmentService.getAppointmentsByClientId(appointmentStatuses, client.getId());
        model.addAttribute("appointments",appointmentsByUserId);


        List<AnimalType> animalsTypeList = animalTypeService.getAnimalTypes();
        model.addAttribute("animalsType",animalsTypeList);

        List<Animal> userAnimal = animalService.getAllAnimalsByUserId(client.getId());
        model.addAttribute("userAnimals",userAnimal);

        List<Vet> vets = vetService.getAllVets();
        model.addAttribute("vets",vets);

        List<Service> servicesTypeList = serviceTypeService.printAllServices();
        model.addAttribute("servicesType",servicesTypeList);

        return "clientPage";
    }




    @PostMapping("/reservation")
    public String SendReservation(AppointmentDto appointmentDto) {
        System.out.println(appointmentDto.getClientId());

        Appointment appointment = new Appointment();

        appointment.setClient(clientService.getClientById(appointmentDto.getClientId()).orElseThrow());
        appointment.setAnimal(animalService.getAnimalById(appointmentDto.getAnimalId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid animal ID!")));
        appointment.setService(serviceTypeService.getServiceById(appointmentDto.getServiceId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid service ID!")));
        appointment.setVet(vetService.getVetById(appointmentDto.getVetId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid vet ID!")));
        appointment.setAppointmentDate(appointmentDto.getAppointmentDate());
        appointment.setStatus(appointmentDto.getStatus());
        appointment.setDescription(appointmentDto.getDescription());

        appointmentService.makeAppointment(appointment);

        return "redirect:/client/Site";
    }
    @PostMapping("/registerAnimal")
    public String registerAnimal(AnimalRegisterDto animalRegisterDto) {

        System.out.println(animalRegisterDto.toString());

        Animal animal = new Animal();
        Client client = clientService.getClientById(animalRegisterDto.getClientId()).orElseThrow();
        animal.setClient(client);
        animal.setAnimalType(animalTypeService.getAnimalTypeById(animalRegisterDto.getTypeId()).orElseThrow(() -> new IllegalArgumentException("Invalid animal type!")));
        animal.setName(animalRegisterDto.getName());
        animalService.add(animal);

        return "redirect:/client/Site";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // Usunięcie klienta z sesji
        session.removeAttribute("client");

        // Można również zainwalidować całą sesję, jeśli chcesz usunąć wszystkie dane sesyjne
        // session.invalidate();

        return "redirect:/login"; // Przekierowanie do strony logowania po wylogowaniu
    }
}
