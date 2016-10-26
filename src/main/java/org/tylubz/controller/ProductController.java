package org.tylubz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.tylubz.model.data.ResultListWrapper;
import org.tylubz.model.entity.ProductEntity;
import org.tylubz.service.interfaces.ProductService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Class for getting products
 */
@RestController
@RequestMapping(value = "/product")
public class ProductController  {
    @Autowired
    ProductService productService;

    /**
     * returns the page with products
     * @param pageNumber number of page
     * @param pageSize size of page
     * @return
     */
    @RequestMapping(value = "/getProducts/{pageNumber}/{pageSize}",method = RequestMethod.GET)
    public ModelAndView controller(@PathVariable Integer pageNumber,@PathVariable Integer pageSize) {
        ResultListWrapper<ProductEntity> listWrapper = productService.read(pageNumber,pageSize);
        List<ProductEntity> productList = listWrapper.getResults();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("products",productList);
        modelAndView.addObject("count",listWrapper.getCount());
        modelAndView.addObject("pageSize",pageSize);
        modelAndView.addObject("pageNumber",pageNumber);
        modelAndView.addObject("numberOfPages",getTotalNumberOfPages(listWrapper.getCount(),pageSize));
        modelAndView.setViewName("products");
        return modelAndView;
    }

    @RequestMapping(value = "/getProducts/{pageNumber}/{pageSize}/{minPrice}/{maxPrice}",method = RequestMethod.GET)
    public ModelAndView getProductsByPriceRange(@PathVariable Integer pageNumber,@PathVariable Integer pageSize,
                                                @PathVariable Float minPrice,@PathVariable Float maxPrice) {
        ResultListWrapper<ProductEntity> listWrapper = productService.getProductsByPriceRange(minPrice,maxPrice,pageSize,pageNumber);
        List<ProductEntity> productList = listWrapper.getResults();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("products",productList);
        modelAndView.addObject("count",listWrapper.getCount());
        modelAndView.addObject("pageSize",pageSize);
        modelAndView.addObject("pageNumber",pageNumber);
        modelAndView.addObject("minPrice",minPrice);
        modelAndView.addObject("maxPrice",maxPrice);
        modelAndView.addObject("numberOfPages",getTotalNumberOfPages(listWrapper.getCount(),pageSize));
        modelAndView.setViewName("products");
        return modelAndView;
    }

    /**
     * getting item page
     * @return
     */
    @RequestMapping(value = "/getProductItem")
    public ModelAndView getProductItem() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("productItem");
        return modelAndView;
    }

    /**
     * Count the result of division
     * by total size and page size
     * @param totalSize
     * @param pageSize
     * @return
     */
    private Integer getTotalNumberOfPages(Long totalSize,Integer pageSize){
        return (int) Math.ceil(totalSize/(double)pageSize);
    }

}
