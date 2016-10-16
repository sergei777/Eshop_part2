package org.tylubz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.tylubz.model.entity.UserEntity;
import org.tylubz.service.exceptions.EmailExistsException;
import org.tylubz.service.exceptions.UserNameExistsException;
import org.tylubz.service.impl.CustomServiceSecond;
import org.tylubz.service.interfaces.UserService;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by Sergei on 25.09.2016.
 */
@RestController
public class MainController {

    @Autowired
    CustomServiceSecond serviceSecond;

    @Autowired
    private UserService userService;

    @RequestMapping(value = { "/", "/home" })
    public ModelAndView homePage() {
        return new ModelAndView("index");
    }

//    @RequestMapping(value = "/controller")
//    public ModelAndView controller() {
//        UserEntity userEntity = service.read(1);
//        System.out.println(userEntity.getFirstName());
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("address", userEntity);
//        modelAndView.setViewName("index");
//        return modelAndView;
//    }
    @RequestMapping(value = "/loginform")
    public ModelAndView login() {
        return new ModelAndView("loginform");
    }

    @RequestMapping(value = "/admin")
    public String adminPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "/admin/admin";
    }

    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "accessDenied";
    }

    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
    public ModelAndView contactsPage() {
        serviceSecond.countResult();
        return new ModelAndView("/contacts");
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public ModelAndView errorPage() {
        return new ModelAndView("/error");
    }
    @RequestMapping(value = "/registrationform", method = RequestMethod.GET)
    public ModelAndView registrationFormPage(){
        return new ModelAndView("registrationForm");
    }

    @RequestMapping(value = { "/registrationform"},method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public String createNewUser(@RequestBody UserEntity entity){
        try {
            entity.setUserType("ROLE_USER");
            userService.createNewUser(entity);
        } catch (EmailExistsException e) {
            e.printStackTrace();
//            request.setAttribute("error","такой email существует!");
            return "{\"error\":\"email\"}";
            //return new ModelAndView();
        } catch (UserNameExistsException e) {
            e.printStackTrace();
//            request.setAttribute("error","Такое имя пользователя существует!");
            return "{\"error\":\"username\"}";
            //return new ModelAndView();
        }
        return "{\"redirectUrl\":\"home\"}";
    }

    private String getPrincipal(){
        String userName;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
}
