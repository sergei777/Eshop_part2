package org.tylubz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.tylubz.dao.interfaces.GenericDao;
import org.tylubz.dao.interfaces.OrderDao;
import org.tylubz.model.entity.OrderEntity;
import org.tylubz.service.interfaces.OrderService;

/**
 * Created by Sergei on 02.10.2016.
 */
@Service
public class OrderServiceImpl extends GenericServiceImpl<OrderEntity,Integer> implements OrderService {
    private OrderDao orderDao;
    @Autowired
    public OrderServiceImpl(
            @Qualifier("orderDaoImpl") GenericDao<OrderEntity, Integer> genericDao) {
        super(genericDao);
        this.orderDao = (OrderDao) genericDao;
    }
}
