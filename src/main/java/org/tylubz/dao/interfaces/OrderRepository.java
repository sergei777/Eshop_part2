package org.tylubz.dao.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.tylubz.entity.OrderEntity;

/**
 * Created by Sergei on 26.09.2016.
 */
public interface OrderRepository extends CrudRepository<OrderEntity,Integer> {
}
