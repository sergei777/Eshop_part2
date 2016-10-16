package org.tylubz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tylubz.dao.interfaces.GenericDao;
import org.tylubz.dao.interfaces.ProductDao;
import org.tylubz.model.data.ResultListWrapper;
import org.tylubz.model.entity.ProductEntity;
import org.tylubz.service.interfaces.ProductService;

import java.util.List;

/**
 * Created by Sergei on 02.10.2016.
 */
@Service
public class ProductServiceImpl extends GenericServiceImpl<ProductEntity,Integer> implements ProductService {
    private ProductDao productDao;
    @Autowired
    public ProductServiceImpl(
            @Qualifier("productDaoImpl") GenericDao<ProductEntity, Integer> genericDao) {
        super(genericDao);
        this.productDao = (ProductDao) genericDao;
    }


    @Override
    @Transactional
    public ResultListWrapper<ProductEntity> getProductsByPriceRange(Float minPrice, Float maxPrice, int pageSize, int pageNumber) {
       return productDao.getProductsByPriceRange(minPrice,maxPrice,pageSize,pageNumber);
    }
}
