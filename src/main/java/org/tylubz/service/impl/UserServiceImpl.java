package org.tylubz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tylubz.dao.interfaces.UserRepository;
import org.tylubz.entity.UserEntity;
import org.tylubz.service.interfaces.UserService;

/**
 * Created by Sergei on 26.09.2016.
 */
@Service
public class UserServiceImpl implements UserService {

    private UserRepository repository;

    @Autowired
    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserEntity create(UserEntity entity) {
        return repository.save(entity);
    }

    @Override
    public UserEntity read(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public void update(UserEntity entity) {
        repository.save(entity);
    }

    @Override
    public void delete(UserEntity entity) {
        repository.delete(entity);
    }
}
