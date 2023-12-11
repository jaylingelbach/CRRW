package CRRW.MyPlushie.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.Authentication;

@Controller
public class HomeController {
    // if user is NOT authenticated, takes the user to the login page, else goes to the home page (index.html)

    @GetMapping("/")
    public String home(Authentication authentication) {

        System.out.println("Homecontroller activated!");

//        just in case the user gets this far and is somehow not authenticated (logged in), takes the user back to
//        the login page, else lets them continue to the main page at "/", using index.html
        return authentication != null ? "index" : "redirect:/login";

    }
}