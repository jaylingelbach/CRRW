package CRRW.MyPlushie.services;

import CRRW.MyPlushie.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import CRRW.MyPlushie.models.User;

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
            // Username is already taken, handle accordingly!

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


//    don't think this is working (below)
    public User createUser(User user) {
        // Hash the password before storing it
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User getUserByUsername(String username) {
//        System.out.println("trying to get userByUsername in UserService");
        return userRepository.findByUsername(username);

    }

}
