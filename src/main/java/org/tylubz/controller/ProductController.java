package org.tylubz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.tylubz.entity.ProductEntity;
import org.tylubz.service.interfaces.ProductService;

import java.util.List;

/**
 * Created by Sergei on 02.10.2016.
 */
@RestController
@RequestMapping(value = "/product")
public class ProductController  {
    @Autowired
    ProductService productService;

    @RequestMapping(value = "/getProducts")
    public ModelAndView controller() {
        List<ProductEntity> productList = productService.readAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("products",productList);
        modelAndView.setViewName("products");
        return modelAndView;
    }
}
