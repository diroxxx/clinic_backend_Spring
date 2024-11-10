package org.example.przychodnia_weterynaryjna.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/vet")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class VetController {


}
