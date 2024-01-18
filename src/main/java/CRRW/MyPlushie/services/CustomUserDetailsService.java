package CRRW.MyPlushie.services;

import CRRW.MyPlushie.models.User;
import CRRW.MyPlushie.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> optionalUser = userRepository.findByUsername(username);

        User user = optionalUser.orElseThrow(() ->
                new UsernameNotFoundException("User not found with username: " + username));

        System.out.println("Custom user details service activated! Loaded user: " + user.getUsername() + " with password: " + user.getPassword());

        // provides Spring Security with the necessary user details for authentication
        return user;
    }
}
