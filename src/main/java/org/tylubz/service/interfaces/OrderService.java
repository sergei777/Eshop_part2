package org.tylubz.service.interfaces;

import org.tylubz.model.entity.OrderEntity;

/**
 * Created by Sergei on 26.09.2016.
 */
public interface OrderService extends GenericService<OrderEntity,Integer> {
    OrderEntity createOrder(OrderEntity entity);
}
