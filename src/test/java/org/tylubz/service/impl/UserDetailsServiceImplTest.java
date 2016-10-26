package org.tylubz.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.tylubz.dao.impl.UserDaoImpl;
import org.tylubz.dao.interfaces.UserDao;
import org.tylubz.model.entity.UserEntity;
import org.tylubz.security.UserDetailsServiceImpl;

import javax.persistence.NoResultException;

/**
 * Created by Sergei on 18.10.2016.
 */
public class UserDetailsServiceImplTest {

    private UserDao userDao;
    private UserDetailsServiceImpl userDetailsService;
    @Before
    public void setUp() throws Exception {
        userDao = Mockito.mock(UserDaoImpl.class);
        userDetailsService = new UserDetailsServiceImpl();
        userDetailsService.setUserDao(userDao);
    }

    @Test
    public void testLoadUserByUsername() {
        String username = "username";
        String password = "password";
        String userType = "ROLE_USER";
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(username);
        userEntity.setPassword(password);
        userEntity.setUserType(userType);
        Mockito.when(userDao.getEntityByUsername(username)).thenReturn(userEntity);
        userDetailsService.loadUserByUsername(username);
        Mockito.verify(userDao).getEntityByUsername(username);
    }

    @Test(expected = UsernameNotFoundException.class)
    public void testLoadUserByUsernameThrowsUsernameNotFoundException(){
        String username = "username";
        Mockito.when(userDao.getEntityByUsername(username)).thenThrow(new NoResultException("no such result"));
        userDetailsService.loadUserByUsername(username);

    }
}