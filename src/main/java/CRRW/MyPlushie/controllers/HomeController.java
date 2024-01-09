package CRRW.MyPlushie.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import CRRW.MyPlushie.services.UserService;

@Controller
public class HomeController {

    @Autowired
    private UserService userService; // we'll need the information of the current user

    @GetMapping("/") // homepage! this uses index.html
    public String home(Model model, Authentication authentication) {
        System.out.println("Homecontroller activated!");

        if (authentication != null && authentication.isAuthenticated()) {

           String username = authentication.getName();

            model.addAttribute("username", username);
            return "index";
        } else {
            return "redirect:/login";
        }
    }

//    @GetMapping("/addPal") //uses addPal.html
//    public String addPal() {
//        return "redirect:/";
//    }
}
