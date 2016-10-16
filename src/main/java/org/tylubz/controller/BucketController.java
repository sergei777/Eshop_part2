package org.tylubz.controller;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.tylubz.cart.ShoppingCart;
import org.tylubz.cart.ShoppingUnit;

import javax.servlet.http.HttpSession;

/**
 * Created by Sergei on 06.10.2016.
 */
@RestController
@RequestMapping(value = "/bucket")
public class BucketController {

    private ShoppingCart shoppingCart;

    @RequestMapping(value = "/addItem",consumes = "application/json",method = RequestMethod.POST)
    //@ResponseStatus(value = HttpStatus.OK)
    public String addItem(HttpSession session,@RequestBody ShoppingUnit unit){
        shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
        if(shoppingCart==null){
            shoppingCart = new ShoppingCart();
        }
        shoppingCart.addUnit(unit);
        session.setAttribute("shoppingCart", shoppingCart);
        return "{\"redirectUrl\":\"getProducts/1/6\"}";
    }
    @RequestMapping(value = "/removeItemById")
    @ResponseStatus(value = HttpStatus.OK)
    public void removeItem(HttpSession session, @RequestParam Integer id){
        shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
        shoppingCart.removeUnitById(id);
        session.setAttribute("shoppingCart", shoppingCart);
    }
    @RequestMapping(value = "/bucketPage",method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public ModelAndView getBucketPage(){
        return new ModelAndView("/user/bucket");
    }

}
