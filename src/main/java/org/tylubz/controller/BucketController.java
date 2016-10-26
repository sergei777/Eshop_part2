package org.tylubz.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.tylubz.model.cart.ShoppingCart;
import org.tylubz.model.cart.ShoppingUnit;

import javax.servlet.http.HttpSession;

/**
 * Class for adding or deleting items
 * from shopping cart
 */
@RestController
@RequestMapping(value = "/bucket")
public class BucketController {

    private ShoppingCart shoppingCart;

    /**
     * add new item to shopping cart
     * @param session
     * @param unit
     * @return
     */
    @RequestMapping(value = "/addItem",consumes = "application/json",method = RequestMethod.POST)
    public String addItem(HttpSession session,@RequestBody ShoppingUnit unit){
        shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
        if(shoppingCart==null){
            shoppingCart = new ShoppingCart();
        }
        shoppingCart.addUnit(unit);
        session.setAttribute("shoppingCart", shoppingCart);
        return "{\"redirectUrl\":\"getProducts/1/6\"}";
    }

    /**
     * remove item from shopping cart
     * @param session
     * @param id
     */
    @RequestMapping(value = "/removeItemById")
    @ResponseStatus(value = HttpStatus.OK)
    public void removeItem(HttpSession session, @RequestParam Integer id){
        shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
        shoppingCart.removeUnitById(id);
        session.setAttribute("shoppingCart", shoppingCart);
    }

    /**
     * get bucket page
     * @return bucket page
     */
    @RequestMapping(value = "/bucketPage",method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public ModelAndView getBucketPage(){
        return new ModelAndView("/user/bucket");
    }

}
