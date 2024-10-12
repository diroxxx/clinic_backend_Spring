package org.example.przychodnia_weterynaryjna.Controllers;

import org.example.przychodnia_weterynaryjna.DTOs.VetArticleDto;
import org.example.przychodnia_weterynaryjna.Repositories.AnimalTypeRepository;
import org.example.przychodnia_weterynaryjna.Repositories.ClientRepository;
import org.example.przychodnia_weterynaryjna.Services.*;
import org.example.przychodnia_weterynaryjna.models.Article;
import org.example.przychodnia_weterynaryjna.models.Client;
import org.example.przychodnia_weterynaryjna.models.Service;
import org.springframework.data.repository.support.Repositories;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/home")
public class TestController {

    private final ClientService clientService;
    private final AnimalService animalService;
    private final AnimalTypeService animalTypeService;
    private final ServiceTypeService serviceTypeService;
    private final ArticleService articleService;

    public TestController (ClientService clientService, AnimalService animalService,
                           AnimalTypeService animalTypeService,
                           ServiceTypeService serviceTypeService, ArticleService articleService) {
        this.clientService = clientService;
        this.animalService = animalService;
        this.animalTypeService = animalTypeService;
        this.serviceTypeService = serviceTypeService;
        this.articleService = articleService;
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
    public String loginView() {
        return "login";
    }


}
