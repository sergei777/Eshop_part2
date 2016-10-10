package org.tylubz.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Sergei on 01.10.2016.
 */
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        //do some logic here if you want something to be done whenever
        //the user successfully logs in.

        HttpSession session = request.getSession();
        User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        session.setAttribute("username", authUser.getUsername());
        session.setAttribute("authorities", authentication.getAuthorities());

        //set our response to OK status
        response.setStatus(HttpServletResponse.SC_OK);

        //since we have created our custom success handler, its up to us to where
        //we will redirect the user after successfully login
        Collection<? extends GrantedAuthority> authorityList = authentication.getAuthorities();
        List<String> roles = new ArrayList<>();
        for(GrantedAuthority a : authorityList){
            roles.add(a.getAuthority());
        }
       if(roles.contains("ROLE_ADMIN")){
           request.getRequestDispatcher("/admin/home").forward(request,response);
       }
        if(roles.contains("ROLE_USER")){
            request.getRequestDispatcher("/").forward(request,response);
        }

    }
}
