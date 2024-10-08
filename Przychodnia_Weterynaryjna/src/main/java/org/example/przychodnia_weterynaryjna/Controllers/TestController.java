package org.example.przychodnia_weterynaryjna.Controllers;

import org.example.przychodnia_weterynaryjna.Repositories.AnimalTypeRepository;
import org.example.przychodnia_weterynaryjna.Repositories.ClientRepository;
import org.example.przychodnia_weterynaryjna.Services.AnimalService;
import org.example.przychodnia_weterynaryjna.Services.AnimalTypeService;
import org.example.przychodnia_weterynaryjna.Services.ClientService;
import org.example.przychodnia_weterynaryjna.Services.ServiceTypeService;
import org.example.przychodnia_weterynaryjna.models.Client;
import org.example.przychodnia_weterynaryjna.models.Service;
import org.springframework.data.repository.support.Repositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/home")
public class TestController {

    private final ClientService clientService;
    private final AnimalService animalService;
    private final AnimalTypeService animalTypeService;
    private final ServiceTypeService serviceTypeService;

    public TestController (ClientService clientService, AnimalService animalService,
                           AnimalTypeService animalTypeService,
                           ServiceTypeService serviceTypeService) {
        this.clientService = clientService;
        this.animalService = animalService;
        this.animalTypeService = animalTypeService;
        this.serviceTypeService = serviceTypeService;
    }



    @GetMapping
    public String home(Model model) {
        List<String> animalsTypeList = animalTypeService.getAllAnimalTypes();
        model.addAttribute("animalsType",animalsTypeList);

        List<Service> servicesTypeList = serviceTypeService.printAllServices();
        model.addAttribute("servicesType",servicesTypeList);
        return "index";
    }

    @GetMapping("/login")
    public String loginView() {
        return "login";
    }


    @RequestMapping("/example")
    @ResponseBody
    String ex() {
      return  clientService.printFirst();
    }
}
