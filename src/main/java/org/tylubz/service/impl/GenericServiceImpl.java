package org.tylubz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tylubz.dao.interfaces.GenericDao;
import org.tylubz.model.data.ResultListWrapper;
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
    @Transactional
    public T create(T entity) {
        return genericDao.create(entity);
    }

    @Override
    @Transactional
    public T read(ID id) {
        return genericDao.read(id);
    }

    @Override
    @Transactional
    public void update(T entity) {
        genericDao.update(entity);
    }

    @Override
    @Transactional
    public void delete(T entity) {
        genericDao.delete(entity);
    }

    @Override
    @Transactional
    public void delete(ID id) {
        genericDao.delete(id);
        int a=3;
    }

    @Override
    @Transactional
    public List<T> readAll(){
        return genericDao.readAll();
    }

    @Override
    public ResultListWrapper<T> read(int pageNumber, int pageSize) {
        return genericDao.read(pageNumber,pageSize);
    }
}
