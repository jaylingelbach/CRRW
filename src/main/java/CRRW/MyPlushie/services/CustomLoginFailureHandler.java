package CRRW.MyPlushie.services;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomLoginFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        // Handle authentication failure here
        System.out.println("Login failed bro: " + exception.getMessage());

        // Redirect or respond accordingly
//        response.sendRedirect("/login?error=true"); // Redirect to login page with an error parameter
        response.sendRedirect("/");

    }
}
