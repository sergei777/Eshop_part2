package org.tylubz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.tylubz.entity.CategoryEntity;
import org.tylubz.entity.ProductEntity;
import org.tylubz.service.interfaces.CategoryService;
import org.tylubz.service.interfaces.OrderService;
import org.tylubz.service.interfaces.ProductService;
import org.tylubz.service.interfaces.UserService;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Created by Sergei on 07.10.2016.
 */
@RequestMapping(value = "/admin")
@RestController
public class AdminPageController {
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = {"/","home"})
    public ModelAndView getAdminPage(){
        return new ModelAndView("admin/admin");
    }
    @RequestMapping(value = {"/userList"})
    public ModelAndView getUserListPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userList",userService.readAll());
        modelAndView.setViewName("admin/userList");
        return modelAndView;
    }
    @RequestMapping(value = {"/productList"})
    public ModelAndView getProductListPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("productList",productService.readAll());
        modelAndView.setViewName("admin/productList");
        return modelAndView;
    }
    @RequestMapping(value = {"/productItem/{id}"},method = RequestMethod.GET)
    public ModelAndView getProductItemPage(@PathVariable Integer id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("categoryList",categoryService.readAll());
        modelAndView.addObject("productItem",productService.read(id));
        modelAndView.setViewName("admin/productItem");
        return modelAndView;
    }
    @RequestMapping(value = {"/newProductItem"},method = RequestMethod.GET)
    public ModelAndView getNewProductItemPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("categoryList",categoryService.readAll());
        modelAndView.setViewName("admin/newProductItem");
        return modelAndView;
    }
    @RequestMapping(value = {"/newCategory"},method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public String addNewCategory(@RequestBody String category) throws UnsupportedEncodingException {
        CategoryEntity entity = new CategoryEntity();
        entity.setCategory(category);
        categoryService.create(entity);
//        return new ModelAndView("admin/productList");
        return "{\"status\":\"OK\"}";
    }
    @RequestMapping(value = {"/productItem"},method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public String addProductItem(@RequestBody ProductEntity entity){
        productService.create(entity);
        ModelAndView modelAndView = new ModelAndView();
        //modelAndView.setViewName("admin/productList");
        return "{\"redirectUrl\":\"productList\"}";
        //return modelAndView;
    }
    @RequestMapping(value = {"/productItem"},method = RequestMethod.PUT)
    public ModelAndView updateProductItem(@RequestBody ProductEntity entity){
        productService.update(entity);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/productList");
        return modelAndView;
    }
    @RequestMapping(value = {"/orderList"})
    public ModelAndView getOrderListPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("orderList",orderService.readAll());
        modelAndView.setViewName("admin/orderList");
        return modelAndView;
    }
    @RequestMapping(value = {"/updateUserPage"})
    public ModelAndView getUpdateUserPage(@RequestParam Integer id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user",userService.read(id));
        modelAndView.setViewName("admin/updateUser");
        return modelAndView;
    }
}
