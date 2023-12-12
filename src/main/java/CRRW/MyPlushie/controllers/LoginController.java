package CRRW.MyPlushie.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login() {
        return "login"; // takes the user to login.html
    }

    @GetMapping("/createAccount")
    public String createAccount() {
        return "createAccount"; // takes the user to createAccount.html
    }


}