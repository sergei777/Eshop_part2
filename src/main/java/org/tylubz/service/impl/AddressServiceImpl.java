package org.tylubz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tylubz.dao.interfaces.AddressRepository;
import org.tylubz.entity.AddressEntity;
import org.tylubz.service.interfaces.AddressService;

/**
 * Created by Sergei on 26.09.2016.
 */
@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepository repository;

    @Autowired
    public void setRepository(AddressRepository repository) {
        this.repository = repository;
    }

    @Override
    public AddressEntity create(AddressEntity entity) {
        return repository.save(entity);
    }

    @Override
    public AddressEntity read(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public void update(AddressEntity entity) {
        repository.save(entity);
    }

    @Override
    public void delete(AddressEntity entity) {
        repository.delete(entity);
    }
}
