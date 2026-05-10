package com.mvp.easyTravel.service;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CustomSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication)
            throws IOException, ServletException {

        boolean isAgent = authentication.getAuthorities().stream()
                .anyMatch(a->a.getAuthority().equals("ROLE_AGENT"));

        if (isAgent){
            response.sendRedirect("/dashboard");
        } else {
            response.sendRedirect("/connexion?error");
        }

    }
}
