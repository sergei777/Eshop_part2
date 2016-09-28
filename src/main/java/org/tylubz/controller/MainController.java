package org.tylubz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.tylubz.dao.exceptions.DaoStoreException;
import org.tylubz.entity.UserEntity;
import org.tylubz.service.interfaces.UserService;


/**
 * Created by Sergei on 25.09.2016.
 */
@RestController
public class MainController {
    @Autowired
    UserService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", "Funny String!");
        modelAndView.setViewName("index");
        return modelAndView;

    }

    @RequestMapping(value = "/d")
    public String getHome() {
        return "index";
    }

    @RequestMapping(value = "/controller")
    public ModelAndView controller() {
        UserEntity userEntity = null;
        try {
            userEntity = service.read(1);
        } catch (DaoStoreException e) {
            e.printStackTrace();
        }
        System.out.println(userEntity.getFirstName());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("address", userEntity);
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
