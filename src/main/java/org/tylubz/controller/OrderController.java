package org.tylubz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.tylubz.service.interfaces.OrderService;

/**
 * Created by Sergei on 02.10.2016.
 */
@RestController
@RequestMapping(value = "/order")
public class OrderController {
//    @Autowired
//    private OrderService service;
//    @RequestMapping(value = { "/getOrders"})
//    public ModelAndView getOrders() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("orderList",service.readAll());
//        return new ModelAndView("/user/orders");
//    }
}
