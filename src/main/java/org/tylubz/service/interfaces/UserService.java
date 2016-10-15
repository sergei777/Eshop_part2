package org.tylubz.service.interfaces;

import org.tylubz.model.entity.OrderEntity;
import org.tylubz.model.entity.UserEntity;
import org.tylubz.service.exceptions.EmailExistsException;
import org.tylubz.service.exceptions.UserNameExistsException;

import java.util.List;

/**
 * Created by Sergei on 26.09.2016.
 */
public interface UserService extends GenericService<UserEntity,Integer> {
    UserEntity getEntityByUsername(String username);
    List<OrderEntity> getUserOrders(String username);
    UserEntity createNewUser(UserEntity entity) throws EmailExistsException, UserNameExistsException;
}
