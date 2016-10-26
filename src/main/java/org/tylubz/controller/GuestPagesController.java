package org.tylubz.controller;

import org.apache.log4j.Logger;
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
import org.tylubz.service.impl.RemoteRestService;
import org.tylubz.service.interfaces.UserService;

import javax.servlet.http.HttpServletResponse;


/**
 * Class for getting
 * guest pages
 *
 */
@RestController
public class GuestPagesController {

    final static Logger logger = Logger.getLogger(GuestPagesController.class);

    @Autowired
    private UserService userService;

    /**
     * getting home page
     * @return home page
     */
    @RequestMapping(value = { "/", "/home" })
    public ModelAndView homePage() {
        logger.info("main page is choosing");
        return new ModelAndView("index");
    }

    /**
     * getting login form
     * @return login form
     */
    @RequestMapping(value = "/loginform")
    public ModelAndView login() {
        return new ModelAndView("loginform");
    }

    /**
     * redirects to admin page
     * @param model
     * @return
     */
    @RequestMapping(value = "/admin")
    public String adminPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "/admin/admin";
    }

    /**
     * getting contacts page
     * @return contacts page
     */
    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
    public ModelAndView contactsPage() {
        return new ModelAndView("/contacts");
    }

    /**
     * getting error page
     * @param response
     * @return error page
     */
    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public ModelAndView errorPage(HttpServletResponse response) {
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        return new ModelAndView("/error");
    }

    /**
     * getting registration form
     * @return registratin form
     */
    @RequestMapping(value = "/registrationform", method = RequestMethod.GET)
    public ModelAndView registrationFormPage(){
        return new ModelAndView("registrationForm");
    }

    /**
     * creates new user in database
     * @param entity user
     * @return value of operation
     */
    @RequestMapping(value = { "/registrationform"},method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public String createNewUser(@RequestBody UserEntity entity){
        try {
            entity.setUserType("ROLE_USER");
            userService.createNewUser(entity);
        } catch (EmailExistsException e) {
            logger.warn("Curent email exist!");
            return "{\"error\":\"email\"}";
        } catch (UserNameExistsException e) {
            logger.warn("Curent username exist" );
            return "{\"error\":\"username\"}";
        }
        return "{\"redirectUrl\":\"home\"}";
    }

    /**
     * getting name of the user
     * @return name of the user
     */
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
