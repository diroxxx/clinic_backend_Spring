package org.example.przychodnia_weterynaryjna.controllers;


import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class LogOutController {




    @GetMapping("/logout")
    public String logout(RedirectAttributes redirectAttributes, HttpSession session) {

        session.invalidate();

        redirectAttributes.addFlashAttribute("message", "Log Out Successful");

        return "redirect:/home";

    }
}