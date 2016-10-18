package org.tylubz.service.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.tylubz.dao.impl.UserDaoImpl;
import org.tylubz.dao.interfaces.UserDao;
import org.tylubz.model.entity.OrderEntity;
import org.tylubz.model.entity.UserEntity;
import org.tylubz.service.exceptions.EmailExistsException;
import org.tylubz.service.exceptions.UserNameExistsException;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;

/**
 * Created by Sergei on 17.10.2016.
 */
public class UserServiceImplTest {

    private UserServiceImpl implementation;
    private UserDao userDao;

    @Before
    public void setUp() throws Exception{
        implementation = new UserServiceImpl();
        userDao = Mockito.mock(UserDao.class);
        implementation.setUserDao(userDao);
    }

    @Test
    public void testGetEntityByUsername() throws Exception {
        String username = "username";
        UserEntity userEntity = Mockito.mock(UserEntity.class);
        Mockito.when(userDao.getEntityByUsername(username)).thenReturn(userEntity);
        Assert.assertEquals(userEntity,implementation.getEntityByUsername(username));
    }

    @Test
    public void testGetUserOrders() throws Exception {
        String username = "username";
        UserEntity userEntity = Mockito.mock(UserEntity.class);
        Mockito.when(userDao.getEntityByUsername(username)).thenReturn(userEntity);
        Assert.assertEquals(userEntity.getOrders(),implementation.getUserOrders(username));

    }

    @Test
    public void testCreateNewUser() throws Exception {
        UserEntity entity = new UserEntity();
        entity.setEmail("email@mail.ru");
        entity.setUsername("username");
        entity.setPassword("strongPassword");
        Mockito.when(userDao.getEntityByEmail(any(String.class))).thenReturn(null);
        Mockito.when(userDao.getEntityByUsername(any(String.class))).thenReturn(null);
        Assert.assertEquals(entity,implementation.createNewUser(entity));
    }

    @Test(expected= EmailExistsException.class)
    public void testCreateNewUserThrowsEmailExistsException() throws Exception {
        UserEntity entity = new UserEntity();
        entity.setEmail("email@mail.ru");
        entity.setUsername("username");
        entity.setPassword("strongPassword");
        Mockito.when(userDao.getEntityByEmail(any(String.class))).thenReturn(Mockito.mock(UserEntity.class));
        implementation.createNewUser(entity);
    }

    @Test(expected= UserNameExistsException.class)
    public void testCreateNewUserThrowsUserNameExistsException() throws Exception {
        UserEntity entity = new UserEntity();
        entity.setEmail("email@mail.ru");
        entity.setUsername("username");
        entity.setPassword("strongPassword");
        Mockito.when(userDao.getEntityByUsername(any(String.class))).thenReturn(Mockito.mock(UserEntity.class));
        implementation.createNewUser(entity);
    }
}