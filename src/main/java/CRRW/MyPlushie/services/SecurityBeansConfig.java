package CRRW.MyPlushie.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityBeansConfig {

//    needed a custom name for this bean to avoid any conflicts
    @Bean(name = "customPasswordEncoder")
    public BCryptPasswordEncoder customPasswordEncoder() {
        System.out.println("Security beans config file activated!");
        return new BCryptPasswordEncoder();
    }
}

