package org.tylubz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tylubz.dao.interfaces.GenericDao;
import org.tylubz.service.interfaces.GenericService;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Sergei on 02.10.2016.
 */
//@Service
public abstract class GenericServiceImpl<T,ID extends Serializable> implements GenericService<T,ID> {
    @Autowired
    private GenericDao<T,ID> genericDao;

    public GenericServiceImpl(GenericDao<T,ID> genericDao) {
        this.genericDao = genericDao;
    }
    @Override
    public T create(T entity) {
        return genericDao.create(entity);
    }

    @Override
    public T read(ID id) {
        return genericDao.read(id);
    }

    @Override
    public void update(T entity) {
        genericDao.update(entity);
    }

    @Override
    public void delete(T entity) {
        genericDao.delete(entity);
    }
    @Override
    public List<T> readAll(){
        return genericDao.readAll();
    }
}
