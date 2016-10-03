package org.tylubz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tylubz.dao.interfaces.UserDao;
import org.tylubz.entity.OrderEntity;
import org.tylubz.entity.UserEntity;
import org.tylubz.service.interfaces.UserService;

import java.util.List;

/**
 * Created by Sergei on 26.09.2016.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserEntity create(UserEntity entity) {
        return userDao.create(entity);
    }

    @Override
    public UserEntity read(Integer id) {
        return userDao.read(id);
    }

    @Override
    public void update(UserEntity entity) {
        userDao.update(entity);
    }

    @Override
    public void delete(UserEntity entity) {
        userDao.delete(entity);
    }
    @Override
    public List<UserEntity> readAll() {
        return userDao.readAll();
    }

    @Override
    @Transactional
    public UserEntity getEntityByUsername(String username) {
        return userDao.getEntityByUsername(username);
    }

    @Override
    @Transactional
    public List<OrderEntity> getUserOrders(String username) {
        UserEntity entity = userDao.getEntityByUsername(username);
        return entity.getOrders();
    }
}
