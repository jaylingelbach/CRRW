package CRRW.MyPlushie.services;

import CRRW.MyPlushie.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import CRRW.MyPlushie.models.User;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, @Qualifier("customPasswordEncoder") BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean  registerUser(String username, String password) {
        // Check if the username already exists
        if (userRepository.existsByUsernameIgnoreCase(username)) {

            // For now, let's just print a message and return, can change this line so the user knows that username is taken
            System.out.println("Username is already taken. Registration failed.");

//            return false to tell the post mapping /register method that the registration failed
            return false;
        }

        // Create a new User entity
        User user = new User();
        user.setUsername(username);

        // Encode the password
        String encodedPassword = passwordEncoder.encode(password);
        user.setPassword(encodedPassword);

        // Save the user to the database
        userRepository.save(user);

        // Registration successful!
        return true;
    }

    public boolean updateUser(String newUsername, String newPassword) {
        // Get the current user's username from the security context
        String currentUsername = getCurrentUsername();

        // Find the user by username
        Optional<User> optionalUser = userRepository.findByUsername(currentUsername);

        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            System.out.println("Found " + existingUser.getUsername() + " with ID of " + existingUser.getId());

            // Update the user information
            existingUser.setUsername(newUsername);

            // Encode the new password if provided
            if (newPassword != null && !newPassword.isEmpty()) {
                existingUser.setPassword(passwordEncoder.encode(newPassword));
            }

            // Save the updated user to the database
            userRepository.save(existingUser);
            return true; // Update successful
        }

        return false; // User not found or update failed
    }

    public boolean deleteUser(Long userId) {
        try {
            // Delete the user by ID
            userRepository.deleteById(userId);
            return true; // Deletion successful
        } catch (Exception e) {
            // add code to handle the exception

            return false; // Deletion failed
        }
    }
    private String getCurrentUsername() {
        // Get the current user's username from the security context
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        }

        return null;
    }

//    don't think this is working (below)
//    public User createUser(User user) {
//        // Hash the password before storing it
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        return userRepository.save(user);
//    }
//
//    public User getUserByUsername(String username) {
////        System.out.println("trying to get userByUsername in UserService");
//        return userRepository.findByUsername(username);
//
//    }
}
