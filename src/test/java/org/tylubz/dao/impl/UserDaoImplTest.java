package org.tylubz.dao.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import org.mockito.runners.MockitoJUnitRunner;

import org.tylubz.model.entity.UserEntity;


/**
 * Created by Sergei on 17.10.2016.
 */

public class UserDaoImplTest {

    private UserDaoImpl userDaoImpl;

    private UserEntity entity;

    @Before
    public void setUp() throws Exception {
        entity = Mockito.mock(UserEntity.class);
        userDaoImpl = Mockito.mock(UserDaoImpl.class);
    }

    @Test
    public void testGetEntityByUsername() throws Exception {
        Mockito.when(userDaoImpl.getEntityByUsername("username")).thenReturn(entity);
        Assert.assertEquals(entity,userDaoImpl.getEntityByUsername("username"));
        Assert.assertNotEquals(entity,userDaoImpl.getEntityByUsername("wrong argument"));
    }

    @Test
    public void testGetEntityByUsernameAndPassword() throws Exception {
        Mockito.when(userDaoImpl.getEntityByUsernameAndPassword("username","password")).thenReturn(entity);
        Assert.assertEquals(entity,userDaoImpl.getEntityByUsernameAndPassword("username","password"));
        Assert.assertNotEquals(entity,userDaoImpl.getEntityByUsernameAndPassword("wrong name","wrong pass"));
    }

    @Test
    public void testGetEntityByEmail() throws Exception {
        Mockito.when(userDaoImpl.getEntityByEmail("email@mail.ru")).thenReturn(entity);
        Assert.assertEquals(entity,userDaoImpl.getEntityByEmail("email@mail.ru"));
        Assert.assertNotEquals(entity,userDaoImpl.getEntityByEmail("wrongemail@mail.ru"));

    }
}