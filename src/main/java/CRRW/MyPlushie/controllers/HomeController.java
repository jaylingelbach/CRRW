package CRRW.MyPlushie.controllers;

import CRRW.MyPlushie.models.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import CRRW.MyPlushie.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class HomeController {

    @Autowired
    private UserService userService; // we'll need the information of the current user

    @GetMapping("/") // homepage! this uses index.html
    public String home(Model model, Authentication authentication) {
        System.out.println("Homecontroller activated!");

        if (authentication != null && authentication.isAuthenticated()) {

//           String username = authentication.getName();
           User user = (User) authentication.getPrincipal();
//           add in here number of pals user has already
            model.addAttribute("username", user.getUsername());
            model.addAttribute("description", user.getDescription());
            return "index";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/start-logout")
    public String startLogout(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/login?logout";
    }

    @GetMapping("/editaccount")
    public String showEditAccountForm(Model model) {

        // takes user to the accountManagement.html view
        return "accountManagement";
    }
    @PostMapping("/delete-account")
    public String deleteAccount(Authentication authentication, RedirectAttributes redirectAttributes, HttpServletRequest request) {

        // Get the authenticated user
        User authenticatedUser = (User) authentication.getPrincipal();

        // Call the deleteUser method in UserService, which sends back a boolean
        boolean deletionResult = userService.deleteUser(getCurrentUserId());

        if (deletionResult) {
            System.out.println("ACCOUNT DELETION SUCCESSFUL");
            return "redirect:/start-logout";
        } else {
            // Deletion failed, handle accordingly
            redirectAttributes.addFlashAttribute("errorMessage", "Failed to delete user");
            return "redirect:/";
        }
    }

//   accepts the new information, saves it, then redirects user to the start-logout
    @PostMapping("/update-profile")
    public String updateProfile(@RequestParam("new-username") String newUsername,
                                @RequestParam("new-password") String newPassword,
                                @RequestParam("description") String newDescription,
                                RedirectAttributes redirectAttributes) {

        // Get the user ID from your authentication context or wherever it's stored
        Long userId = getCurrentUserId();

        // Call the updateUser method in the UserService and give it the new username and passwords from the form
        boolean updateSuccessful = userService.updateUser(newUsername, newPassword, newDescription);

        if (updateSuccessful) {
            // Profile updated successfully
            redirectAttributes.addFlashAttribute("successMessage", "Profile updated successfully!");
        } else {
            // User with the specified ID not found
            redirectAttributes.addFlashAttribute("errorMessage", "Failed to update profile. User not found.");
        }

        return "redirect:/start-logout";
    }


    // This method should return the current user's ID from your authentication context
    private Long getCurrentUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Check if the user is authenticated
        if (authentication != null && authentication.isAuthenticated()) {
            // The principal should be an instance of your UserDetails implementation

            // Assuming your UserDetails class has a method getId()
            User currentUser = (User) authentication.getPrincipal();

            return currentUser.getId();
        }

        // Return null or throw an exception if unable to determine the user ID
        return null;
    }

//    @GetMapping("/addPal") //uses addPal.html
//    public String addPal() {
//        return "redirect:/";
//    }


}
