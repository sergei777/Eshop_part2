package org.tylubz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.tylubz.cart.ShoppingCart;
import org.tylubz.cart.ShoppingUnit;
import org.tylubz.dao.exceptions.DaoStoreException;
import org.tylubz.dao.impl.GenericDaoJpaImpl;
import org.tylubz.dao.interfaces.GenericDao;
import org.tylubz.model.entity.OrderEntity;
import org.tylubz.model.entity.ProductEntity;
import org.tylubz.model.entity.UserEntity;
import org.tylubz.service.exceptions.EmailExistsException;
import org.tylubz.service.exceptions.UserNameExistsException;
import org.tylubz.service.interfaces.OrderService;
import org.tylubz.service.interfaces.ProductService;
import org.tylubz.service.interfaces.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergei on 28.09.2016.
 */
@RestController
@RequestMapping(value = "/user")
public class UserPagesController {
    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

//    @RequestMapping(value = "/user",method = RequestMethod.GET)
//    public ModelMap redirect()  {
//        ModelMap mm = new ModelMap();
//        mm.put("Value","Value");
//        new ModelAndView().ad
//        return mm;
//    }

//    @RequestMapping(value = "/user")
//    public ModelAndView main() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("name", "Funny String!");
//        modelAndView.setViewName("index");
//        return modelAndView;
//    }
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
    @RequestMapping(value = { "/order"},method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public String createOrder(@RequestBody OrderEntity entity, HttpSession session){
        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
        entity.setOrderStatus("Не оплачен");
        entity.setPaymentStatus("Не оплачен");
        entity.setUser(userService.getEntityByUsername(getPrincipal()));
        try {
            entity.setProducts(getProductList(shoppingCart.getShoppingList()));
        } catch (DaoStoreException e) {
            e.printStackTrace();
        }
        orderService.create(entity);
        return "{\"redirectUrl\":\"/home\"}";
    }
    @RequestMapping(value = { "/settings"},method = RequestMethod.GET)
    public ModelAndView getSettingsPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user",userService.getEntityByUsername(getPrincipal()));
        modelAndView.setViewName("user/settings");
        return modelAndView;
    }

    @RequestMapping(value = { "/settings"},method = RequestMethod.POST)
    public String updateSettings(@RequestBody UserEntity newEntity) {
        UserEntity oldEntity = userService.getEntityByUsername(getPrincipal());
        newEntity.setUserType(oldEntity.getUserType());
        newEntity.setPassword(oldEntity.getPassword());
        newEntity.setId(oldEntity.getId());
        userService.update(newEntity);
        return "{\"redirectUrl\":\"/home\"}";
    }
//    @RequestMapping(value = { "/settings"},method = RequestMethod.GET)
//    public ModelAndView getErrorPage(){
//        return new ModelAndView("/error");
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

    private List<ProductEntity> getProductList(List<ShoppingUnit> shoppingList) throws DaoStoreException {
        List<ProductEntity> productList = new ArrayList<>();
        for (ShoppingUnit unit : shoppingList) {
            productList.add(productService.read(unit.getId()));
        }
        return productList;
    }

}
