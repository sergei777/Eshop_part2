package org.tylubz.dao.impl;

import org.springframework.stereotype.Repository;
import org.tylubz.dao.interfaces.OrderDao;
import org.tylubz.model.entity.OrderEntity;

/**
 * Created by Sergei on 02.10.2016.
 */
@Repository
public class OrderDaoImpl extends GenericDaoJpaImpl<OrderEntity,Integer> implements OrderDao {
}
