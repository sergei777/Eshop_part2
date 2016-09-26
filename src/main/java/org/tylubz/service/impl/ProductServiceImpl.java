package org.tylubz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tylubz.dao.interfaces.ProductRepository;
import org.tylubz.entity.ProductEntity;
import org.tylubz.service.interfaces.ProductService;

/**
 * Created by Sergei on 26.09.2016.
 */
@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository repository;

    @Autowired
    public void setRepository(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProductEntity create(ProductEntity entity) {
        return repository.save(entity);
    }

    @Override
    public ProductEntity read(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public void update(ProductEntity entity) {
        repository.save(entity);
    }

    @Override
    public void delete(ProductEntity entity) {
        repository.delete(entity);
    }
}