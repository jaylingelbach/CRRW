package CRRW.MyPlushie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserService userService;
    private final BCryptPasswordEncoder passwordEncoder;

    public SecurityConfig(UserService userService, BCryptPasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    private CustomLoginSuccessHandler customLoginSuccessHandler;

    @Autowired
    private CustomLoginFailureHandler customLoginFailureHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()

//                pages the user can access without needing to be logged in
                .antMatchers("/login", "/images/**", "/createAccount", "/register", "/logout").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .successHandler(customLoginSuccessHandler)
                .failureHandler(customLoginFailureHandler)
                .permitAll()
                .and()
            .logout()
                .logoutUrl("/logout")  // The URL to trigger logout
                .logoutSuccessUrl("/login?logout")
                .invalidateHttpSession(true)  // Invalidate the HTTP session
                .deleteCookies("JSESSIONID")  // Delete cookies, if any
//                .permitAll() // Permit all for logout
                .and()
            .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
//                .csrf().disable();

    }



//THE FOLLOWING CODE CAN BE USED INSTEAD TO TEST OUT THE LOGIN FEATURE IF MYSQL ISN'T WORKING:

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//
////                this allows us to test the website by using these credentials. these are also found in application.properties
//
//                .inMemoryAuthentication()
////                type the green text (excluding quotations) into "username"
//                .withUser("user")
//
////                type  into "password"
//                .password(passwordEncoder().encode("password"))
//                .roles("USER");
//    }

//    Uses the login/passwords from MySQL database, using a custom details service thats in CustomUserDetailsService
//    under services

    @Autowired
    private CustomUserDetailsService userDetailsService;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

}
