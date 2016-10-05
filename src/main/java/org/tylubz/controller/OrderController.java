package org.tylubz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.tylubz.entity.OrderEntity;
import org.tylubz.service.interfaces.OrderService;

/**
 * Created by Sergei on 02.10.2016.
 */
@RestController
@RequestMapping(value = {"order","/order"})
public class OrderController {
    @Autowired
    private OrderService service;
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
}
