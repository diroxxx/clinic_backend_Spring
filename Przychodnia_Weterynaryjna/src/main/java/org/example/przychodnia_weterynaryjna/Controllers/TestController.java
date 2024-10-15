package org.example.przychodnia_weterynaryjna.Controllers;

import jakarta.validation.Valid;
import org.example.przychodnia_weterynaryjna.DTOs.LogInDto;
import org.example.przychodnia_weterynaryjna.DTOs.RegisterDto;
import org.example.przychodnia_weterynaryjna.DTOs.VetArticleDto;
import org.example.przychodnia_weterynaryjna.Services.*;
import org.example.przychodnia_weterynaryjna.models.Client;
import org.example.przychodnia_weterynaryjna.models.Service;
import org.example.przychodnia_weterynaryjna.models.User;
import org.example.przychodnia_weterynaryjna.models.Vet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
@RequestMapping("/home")
public class TestController {

    private final ClientService clientService;
    private final AnimalService animalService;
    private final AnimalTypeService animalTypeService;
    private final ServiceTypeService serviceTypeService;
    private final ArticleService articleService;
    private final VetService vetService;
    private final UserService userService;

    public TestController (ClientService clientService,
                           AnimalService animalService,
                           AnimalTypeService animalTypeService,
                           ServiceTypeService serviceTypeService,
                           ArticleService articleService,
                           VetService vetService,
                           UserService userService) {
        this.clientService = clientService;
        this.animalService = animalService;
        this.animalTypeService = animalTypeService;
        this.serviceTypeService = serviceTypeService;
        this.articleService = articleService;
        this.vetService = vetService;
        this.userService = userService;
    }



    @GetMapping
    public String home(Model model) {
        List<String> animalsTypeList = animalTypeService.getAllAnimalTypes();
        model.addAttribute("animalsType",animalsTypeList);

        List<Service> servicesTypeList = serviceTypeService.printAllServices();
        model.addAttribute("servicesType",servicesTypeList);

        List<VetArticleDto> articleDtos = articleService.getAllArticle();
        model.addAttribute("articles",articleDtos);
        return "index";
    }

    @GetMapping("/login")
    public String loginView(Model model) {
        model.addAttribute("logInDto", new LogInDto());

        return "login";
    }

    @GetMapping("/register-Page")
    public String registerView(Model model) {
        model.addAttribute("registerDto", new RegisterDto());

        return "registerPage";
    }

    @PostMapping("/logIn")
    public String login(Model model, @Valid LogInDto loginDto, BindingResult bindingResult) {

        System.out.println(loginDto);

        if (bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            errors.forEach(err -> System.out.println(err.getDefaultMessage()));
        }

        loginDto.setRole(loginDto.getRole().replaceAll(",", ""));

        if (Objects.equals(loginDto.getRole(), "vet")) {
            System.out.println("vet");
            Optional<Vet> vet = vetService.doesVetExists(loginDto.getEmail(), loginDto.getPassword());


            if (vet.isPresent()) {
                model.addAttribute("vet", vet.get());
                return "vetPage";
            } else {
                model.addAttribute("error", "Invalid email or password.");
                return "login";
            }

        } else {
            Optional<Client> client = clientService.doesClientExists(loginDto.getEmail(), loginDto.getPassword());
            System.out.println("client");

            if (client.isPresent()) {
                model.addAttribute("client", client.get());
                return "clientPage";
            } else {
                model.addAttribute("error", "Invalid email or password.");
                return "login";
            }
        }
    }

    @PostMapping("/register")
    public String register(Model model, @Valid RegisterDto registerDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            errors.forEach(err -> System.out.println(err.getDefaultMessage()));
        }

        registerDto.setRole(registerDto.getRole().replaceAll(",", ""));

        User user = userService.registerUser(new User(registerDto.getFirstName(),
                registerDto.getLastName(),
                registerDto.getEmail(),
                registerDto.getPhoneNumber(),
                registerDto.getPassword()));
//        System.out.println(user);
        if (Objects.equals(registerDto.getRole(), "vet")) {
//            System.out.println("vet " + registerDto.getRole() );
            vetService.registerVet(user);
        } else {
//            System.out.println("client " + registerDto.getRole() );
            clientService.registerClient(user);
        }
        return "redirect:login";
    }




}

