package org.tylubz.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.tylubz.dao.interfaces.UserDao;
import org.tylubz.model.entity.UserEntity;

import java.util.HashSet;
import java.util.Set;

/**
 * Custom implementation of
 * user details service
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = null;
        try {
            UserEntity user = userDao.getEntityByUsername(username);
            Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
            grantedAuthorities.add(new SimpleGrantedAuthority(user.getUserType()));
            userDetails = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
        } catch (Exception e) {
            //e.printStackTrace();
            throw new UsernameNotFoundException("Error in retrieving user");
        }
        return userDetails;
    }
}
