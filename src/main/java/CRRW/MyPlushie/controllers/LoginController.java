package CRRW.MyPlushie.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import CRRW.MyPlushie.services.UserService;
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login"; // takes the user to login.html
    }


    @GetMapping("/createAccount")
    public String createAccount() {
        return "createAccount"; // takes the user to createAccount.html
    }

    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password) {
        System.out.println("Made it to /register! attempting to register " + username + " with the password: " + password);

        // Attempt user registration, this method will return true or false if registration was successful
        boolean registrationSuccessful = userService.registerUser(username, password);

        if (!registrationSuccessful) {
            // Registration failed, don't redirect

            // can add extra logic to tell user why the registration didn't work

            return "/createAccount";
        }
        // Handle user registration logic
        return "redirect:/"; // Redirect to login page after registration
    }



}