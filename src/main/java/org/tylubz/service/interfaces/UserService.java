package org.tylubz.service.interfaces;

import org.tylubz.entity.OrderEntity;
import org.tylubz.entity.UserEntity;

import java.util.List;

/**
 * Created by Sergei on 26.09.2016.
 */
public interface UserService extends GenericService<UserEntity,Integer> {
    UserEntity getEntityByUsername(String username);
    List<OrderEntity> getUserOrders(String username);
}
