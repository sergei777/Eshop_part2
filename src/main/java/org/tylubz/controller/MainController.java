package org.tylubz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.tylubz.entity.AddressEntity;
import org.tylubz.service.interfaces.AddressService;


/**
 * Created by Sergei on 25.09.2016.
 */
@RestController
public class MainController {
    @Autowired
    AddressService service;

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
        AddressEntity addressEntity = service.read(22);
        System.out.println(addressEntity.getCity());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("address", addressEntity);
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
