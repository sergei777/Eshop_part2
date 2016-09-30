package org.tylubz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.tylubz.dao.interfaces.UserDao;
import org.tylubz.entity.UserEntity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Sergei on 28.09.2016.
 */
//@Service
public class UserDetailsServiceImpl  {
    //@Autowired
    //private UserDao userDao;
    //@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = null;// =  userDao.getEntityByUsername(username);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
//            grantedAuthorities.add(new SimpleGrantedAuthority(user.getUserType()));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}