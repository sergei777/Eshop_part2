package org.tylubz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Sergei on 28.09.2016.
 */
@Controller
@RequestMapping(value = "/user", method = RequestMethod.GET)
public class UserPagesController {
    @RequestMapping(value = "/user")
    public ModelAndView main() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", "Funny String!");
        modelAndView.setViewName("index");
        return modelAndView;

    }
}
