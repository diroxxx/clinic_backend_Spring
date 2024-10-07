package org.example.przychodnia_weterynaryjna.Controllers;

import org.example.przychodnia_weterynaryjna.Repositories.ClientRepository;
import org.example.przychodnia_weterynaryjna.Services.ClientService;
import org.example.przychodnia_weterynaryjna.models.Client;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/home")
public class TestController {

    private final ClientService clientService;

    public TestController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public String home() {
        return "index";
    }
    @GetMapping("/ex2")
    public String homnme2() {
        return "login";
    }


    @RequestMapping("/example")
    @ResponseBody
    String ex() {
      return  clientService.printFirst();
    }
}
