package org.tylubz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.tylubz.model.entity.AddressEntity;
import org.tylubz.service.interfaces.OrderService;
import org.tylubz.service.interfaces.UserService;

/**
 * Created by Sergei on 02.10.2016.
 */
@RestController
@RequestMapping(value = {"order","/order"})
public class OrderController {
    @Autowired
    private OrderService service;
    @Autowired
    private UserService userService;

        @RequestMapping(value = { "/createOrder"})
    public ModelAndView getOrderPage(){
            AddressEntity address = userService.getEntityByUsername(getPrincipal()).getAddressEntity();
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("address",address);
            modelAndView.setViewName("user/createOrder");
            return modelAndView;
        }
//    @RequestMapping(value = { "/getOrders"})
//    public ModelAndView getOrders() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("orderList",service.readAll());
//        return new ModelAndView("/user/orders");
//    }
//    @RequestMapping(value = { "/remove-order"})
//    @ResponseStatus(value = HttpStatus.OK)
//    public void removeOrder(@RequestParam Integer id) {
//       service.delete(id);
//    }

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
