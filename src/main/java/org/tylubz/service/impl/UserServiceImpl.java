package org.tylubz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tylubz.dao.interfaces.UserDao;
import org.tylubz.model.data.ResultListWrapper;
import org.tylubz.model.entity.OrderEntity;
import org.tylubz.model.entity.UserEntity;
import org.tylubz.service.exceptions.EmailExistsException;
import org.tylubz.service.exceptions.UserNameExistsException;
import org.tylubz.service.interfaces.UserService;

import java.util.List;

/**
 * Created by Sergei on 26.09.2016.
 */
@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public UserEntity create(UserEntity entity) {
        return userDao.create(entity);
    }

    @Override
    @Transactional
    public UserEntity read(Integer id) {
        return userDao.read(id);
    }

    @Override
    @Transactional
    public void update(UserEntity entity) {
        userDao.update(entity);
    }

    @Override
    @Transactional
    public void delete(UserEntity entity) {
        userDao.delete(entity);
    }

    @Override
    @Transactional
    public void delete(Integer integer) {
    }

    @Override
    @Transactional
    public List<UserEntity> readAll() {
        return userDao.readAll();
    }

    @Override
    public ResultListWrapper<UserEntity> read(int pageNumber, int pageSize) {
        return null;
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

    @Override
    @Transactional
    public UserEntity createNewUser(UserEntity entity) throws EmailExistsException, UserNameExistsException {
        String email = entity.getEmail();
        String username = entity.getUsername();
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashPassword = passwordEncoder.encode(entity.getPassword());
        entity.setPassword(hashPassword);
        if(userDao.getEntityByEmail(email)!=null){ throw new EmailExistsException("There is an account with that email address: " + email);
        }
        if(userDao.getEntityByUsername(username)!=null) throw new UserNameExistsException("There is an account with that username: " + username);
        userDao.create(entity);
        return entity;
    }
}
