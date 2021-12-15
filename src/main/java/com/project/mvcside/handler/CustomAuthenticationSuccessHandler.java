package com.project.mvcside.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        String username = authentication.getName();
        Object credentials = SecurityContextHolder.getContext().getAuthentication().getCredentials();
        HttpSession session = request.getSession();
        session.setAttribute("session_username", username);
        session.setAttribute("session_password", credentials.toString());

        response.sendRedirect(request.getContextPath() + "/");

    }
}
