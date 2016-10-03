package org.tylubz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.tylubz.entity.UserEntity;
import org.tylubz.service.interfaces.UserService;


/**
 * Created by Sergei on 25.09.2016.
 */
@RestController
public class MainController {
//    @Autowired
//    UserService service;

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
        return new ModelAndView("/contacts");
    }

    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
}
