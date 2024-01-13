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


//    this takes the user to the creatAccount.html view
    @GetMapping("/createAccount")
    public String createAccount() {
        return "createAccount"; // takes the user to createAccount.html
    }

//    this is whenthe user actually submits the form
    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password) {
        System.out.println("Made it to /register! attempting to register " + username + " with the password: " + password);

        // Attempt user registration, this method will return true or false if registration was successful
        boolean registrationSuccessful = userService.registerUser(username, password);

        if (!registrationSuccessful) {
            // Registration failed, don't redirect
            return "/createAccount";
        }
        // Handle user registration logic
        return "redirect:/"; // Redirect to login page after registration
    }

//    @GetMapping("/manage-account")
//    public String


}