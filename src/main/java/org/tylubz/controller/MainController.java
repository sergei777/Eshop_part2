package org.tylubz.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    UserService service;

//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public ModelAndView main() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("name", "Funny String!");
//        modelAndView.setViewName("index");
//        return modelAndView;
//
//    }

    @RequestMapping(value = "/d")
    public ModelAndView getHome() {
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/controller")
    public ModelAndView controller() {
        UserEntity userEntity = service.read(1);
        System.out.println(userEntity.getFirstName());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("address", userEntity);
        modelAndView.setViewName("index");
        return modelAndView;
    }
    @RequestMapping(value = "/loginform")
    public ModelAndView login() {
        return new ModelAndView("loginform");
    }

//    @RequestMapping(value = "/admin")
//    public ModelAndView adminpage() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("/admin/admin");
//        return modelAndView;
//    }
//    @RequestMapping(value = "/user")
//    public ModelAndView userpage() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("/user/bucket");
//        return modelAndView;
//    }
}
