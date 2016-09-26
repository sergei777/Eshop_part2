package org.tylubz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tylubz.dao.interfaces.OrderRepository;
import org.tylubz.entity.OrderEntity;
import org.tylubz.service.interfaces.OrderService;

/**
 * Created by Sergei on 26.09.2016.
 */
@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository repository;

    @Autowired
    public void setRepository(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public OrderEntity create(OrderEntity entity) {
        return repository.save(entity);
    }

    @Override
    public OrderEntity read(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public void update(OrderEntity entity) {
        repository.save(entity);
    }

    @Override
    public void delete(OrderEntity entity) {
        repository.delete(entity);
    }
}