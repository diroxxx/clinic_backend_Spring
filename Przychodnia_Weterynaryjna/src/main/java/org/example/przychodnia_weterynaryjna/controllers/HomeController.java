package org.example.przychodnia_weterynaryjna.controllers;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.przychodnia_weterynaryjna.controllers.DTOs.LogInDto;
import org.example.przychodnia_weterynaryjna.controllers.DTOs.RegisterDto;
import org.example.przychodnia_weterynaryjna.controllers.DTOs.VetArticleDto;
import org.example.przychodnia_weterynaryjna.services.*;
import org.example.przychodnia_weterynaryjna.models.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
@RequestMapping("/home")
@RequiredArgsConstructor
public class HomeController {

    private final ClientService clientService;
    private final AnimalService animalService;
    private final AnimalTypeService animalTypeService;
    private final ServiceTypeService serviceTypeService;
    private final ArticleService articleService;
    private final VetService vetService;
    private final UserService userService;


    @GetMapping
    public String home(Model model, HttpSession session) {
        System.out.println("Current role in session: " + session.getAttribute("role"));


        List<String> animalsTypeList = animalTypeService.getAllAnimalTypes();
        model.addAttribute("animalsType",animalsTypeList);

        List<Service> servicesTypeList = serviceTypeService.printAllServices();
        model.addAttribute("servicesType",servicesTypeList);

        List<VetArticleDto> articleDtos = articleService.getAllArticle();
        model.addAttribute("articles",articleDtos);
        return "index";
    }

    @GetMapping("/login-page")
    public String loginView(Model model) {
        model.addAttribute("logInDto", new LogInDto());

        return "login";
    }

    @GetMapping("/register-page")
    public String registerView(Model model) {
        model.addAttribute("registerDto", new RegisterDto());

        return "registerPage";
    }

    @PostMapping("/login")
    public String login(Model model, @Valid LogInDto loginDto, BindingResult bindingResult, HttpSession session) {

        loginDto.setRole(loginDto.getRole().replaceAll(",", ""));
//        System.out.println(loginDto);

        if (bindingResult.hasErrors()) {
            return "login";
        }
        //wywolanie service1
        //wywolanie service2

        //wywolanie service3



        if (Objects.equals(loginDto.getRole(), "vet")) {
//            System.out.println("vet");
            Optional<Vet> vet = vetService.doesVetExists(loginDto.getEmail(), loginDto.getPassword());

            if (vet.isPresent()) {
                session.setAttribute("vet", vet.get());
                return "redirect:/home";
            } else {
                return "login";
            }

        } else {
            Optional<Client> client = clientService.doesClientExists(loginDto.getEmail(), loginDto.getPassword());
            System.out.println("client");

            if (client.isPresent()) {
                session.setAttribute("client", client.get());
                return "redirect:/client/Site";

            } else {

                return "login";
            }
        }
    }

    @PostMapping("/register")
    public String register( @Valid RegisterDto registerDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "registerPage";
        }
        registerDto.setRole(registerDto.getRole().replaceAll(",", ""));

        User user = userService.registerUser(new User(
                registerDto.getFirstName(),
                registerDto.getLastName(),
                registerDto.getEmail(),
                registerDto.getPhoneNumber(),
                registerDto.getPassword()));
//        System.out.println(user);
        if (Objects.equals(registerDto.getRole(), "vet")) {
//            System.out.println("vet " + registerDto.getRole() );
            vetService.registerVet(user);
        } else {
           clientService.registerClient(user);
        }
        return "redirect:login";
    }


}

