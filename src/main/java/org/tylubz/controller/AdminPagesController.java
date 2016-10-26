package org.tylubz.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.tylubz.model.entity.CategoryEntity;
import org.tylubz.model.entity.OrderEntity;
import org.tylubz.model.entity.ProductEntity;
import org.tylubz.model.entity.UserEntity;
import org.tylubz.service.interfaces.CategoryService;
import org.tylubz.service.interfaces.OrderService;
import org.tylubz.service.interfaces.ProductService;
import org.tylubz.service.interfaces.UserService;

import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * Class for main admin operations
 */
@RequestMapping(value = "/admin")
@RestController
public class AdminPagesController {

    final static Logger logger = Logger.getLogger(AdminPagesController.class);

    @Autowired
    private ProductService productService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;
    @Autowired
    private CategoryService categoryService;

    /**
     * getting home admin page
     * @return home page
     */
    @RequestMapping(value = {"/","home"})
    public ModelAndView getAdminPage(){
        return new ModelAndView("redirect:/admin/orderList");
    }

    /**
     * getting page of users list
     * @return page of users list
     */
    @RequestMapping(value = {"/userList"})
    public ModelAndView getUserListPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userList",userService.readAll());
        modelAndView.setViewName("admin/userList");
        return modelAndView;
    }

    /**
     * getting productList page
     * @return product list page
     */
    @RequestMapping(value = {"/productList"})
    public ModelAndView getProductListPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("productList",productService.readAll());
        modelAndView.setViewName("admin/productList");
        return modelAndView;
    }

    /**
     * get page of item
     * @param id id of item
     * @return page with current item
     */
    @RequestMapping(value = {"/productItem/{id}"},method = RequestMethod.GET)
    public ModelAndView getProductItemPage(@PathVariable Integer id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("categoryList",categoryService.readAll());
        modelAndView.addObject("productItem",productService.read(id));
        modelAndView.setViewName("admin/productItem");
        return modelAndView;
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = {"/newProductItem"},method = RequestMethod.GET)
    public ModelAndView getNewProductItemPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("categoryList",categoryService.readAll());
        modelAndView.setViewName("admin/newProductItem");
        return modelAndView;
    }

    /**
     * Creating new category
     * @param category name of category
     * @return result
     * @throws UnsupportedEncodingException
     */
    @RequestMapping(value = {"/newCategory"},method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public String addNewCategory(@RequestBody String category) throws UnsupportedEncodingException {
        CategoryEntity entity = new CategoryEntity();
        entity.setCategory(category);
        categoryService.create(entity);
        logger.info("new category added:"+ category);
        return "{\"status\":\"OK\"}";
    }

    /**
     * Creating new entity
     * @param entity
     * @return url of productList page
     */
    @RequestMapping(value = {"/productItem"},method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public String addProductItem(@RequestBody ProductEntity entity){
        productService.create(entity);
        logger.info("new user added");
        return "{\"redirectUrl\":\"productList\"}";
    }

    /**
     * updating product info
     * @param entity
     * @return
     */
    @RequestMapping(value = {"/productItem"},method = RequestMethod.PUT)
    public ModelAndView updateProductItem(@RequestBody ProductEntity entity){
        productService.update(entity);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/productList");
        return modelAndView;
    }

    /**
     * getting orderList page
     * @return
     */
    @RequestMapping(value = {"/orderList"})
    public ModelAndView getOrderListPage(){
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("orderList",orderService.readAll());
        modelAndView.setViewName("admin/orderList");
        return modelAndView;
    }

    /**
     * getting update page
     * @param id
     * @return
     */
    @RequestMapping(value = {"/updateUserPage"},method = RequestMethod.GET)
    public ModelAndView getUpdateUserPage(@RequestParam Integer id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user",userService.read(id));
        modelAndView.setViewName("admin/updateUser");
        return modelAndView;
    }

    /**
     * updating information about
     * user
     * @param username
     * @param firstName
     * @param secondName
     * @return
     */
    @RequestMapping(value = {"/updateUserInfo"},method = RequestMethod.POST)
    public ModelAndView updateUserInfo(@RequestParam String username,
                                       @RequestParam String firstName,
                                       @RequestParam String secondName){
        UserEntity entity = userService.getEntityByUsername(username);
        entity.setFirstName(firstName);
        entity.setSecondName(secondName);
        userService.update(entity);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/userList");
        logger.info("user data updated. User:"+ username);
        return modelAndView;
    }

    /**
     * updating information about order
     * @param id
     * @param orderStatus
     * @return
     */
    @RequestMapping(value = {"/updateOrderInfo"},method = RequestMethod.POST)
    public ModelAndView updateOrderInfo(@RequestParam Integer id,
                                          @RequestParam String orderStatus){
        OrderEntity entity = orderService.read(id);
        entity.setOrderStatus(orderStatus);
        entity.setPaymentStatus("Оплачен");
        orderService.update(entity);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/admin/orderList");
        logger.info("Order info updated. Order id:"+ id);
        return modelAndView;
    }

    /**
     * updating information about
     * product
     * @param id
     * @param name
     * @param price
     * @param weight
     * @param volume
     * @param amount
     * @param imagePath
     */
    @RequestMapping(value = {"/updateProductInfo"},method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void updateProductInfo(@RequestParam Integer id,
                                          @RequestParam String name,
                                          @RequestParam Float price,
                                          @RequestParam Float weight,
                                          @RequestParam String volume,
                                          @RequestParam Integer amount,
                                          @RequestParam String imagePath){
        ProductEntity entity = productService.read(id);
        entity.setName(name);
        entity.setPrice(price);
        entity.setWeight(weight);
        entity.setAmount(amount);
        entity.setVolume(volume);
        entity.setImagePath(imagePath);
        productService.update(entity);
    }

}
