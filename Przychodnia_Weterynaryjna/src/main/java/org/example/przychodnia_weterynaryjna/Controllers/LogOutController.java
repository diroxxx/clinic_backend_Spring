package org.example.przychodnia_weterynaryjna.Controllers;


import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LogOutController {


    public LogOutController() {

    }


    @GetMapping("/logout")
    public String logout(RedirectAttributes redirectAttributes, HttpSession session) {
        session.removeAttribute("client");

        redirectAttributes.addFlashAttribute("message", "Log Out Successful");

        return "redirect:/home"; // Przekierowanie do strony logowania po wylogowaniu

    }
}