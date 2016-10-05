package org.tylubz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.tylubz.entity.OrderEntity;
import org.tylubz.service.interfaces.OrderService;
import org.tylubz.service.interfaces.UserService;

import java.util.List;

/**
 * Created by Sergei on 28.09.2016.
 */
@RestController
@RequestMapping(value = "/user", method = RequestMethod.GET)
public class UserPagesController {
    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/user")
    public ModelAndView main() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", "Funny String!");
        modelAndView.setViewName("index");
        return modelAndView;
    }
    @RequestMapping(value = "/orders")
    public ModelAndView orders() {
        List<OrderEntity> orders = userService.getUserOrders(getPrincipal());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("orders",orders);
        modelAndView.setViewName("user/orders");
        return modelAndView;
    }

    @RequestMapping(value = { "/remove-order"})
    @ResponseStatus(value = HttpStatus.OK)
    public void removeOrder(@RequestParam Integer id){
        //OrderEntity entity = orderService.read(id);
        orderService.delete(id);
        //userService.getEntityByUsername(getPrincipal()).removeOrder(entity);
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
