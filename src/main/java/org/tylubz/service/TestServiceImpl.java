package org.tylubz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tylubz.dao.interfaces.CustomerRepository;
import org.tylubz.entity.AddressEntity;

/**
 * Created by Sergei on 25.09.2016.
 */
@Service
public class TestServiceImpl implements TestService {
    @Autowired
    CustomerRepository repository;
    @Override
    public AddressEntity findOne(Integer id) {
        return repository.findOne(id);
    }
}
