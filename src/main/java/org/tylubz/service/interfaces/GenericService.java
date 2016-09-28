package org.tylubz.service.interfaces;

import org.springframework.transaction.annotation.Transactional;
import org.tylubz.dao.exceptions.DaoStoreException;

import java.io.Serializable;

/**
 * Created by Sergei on 26.09.2016.
 */
public interface GenericService<T,ID extends Serializable>{
    @Transactional
    T create(T entity) throws DaoStoreException;
    @Transactional
    T read(ID id) throws DaoStoreException;
    @Transactional
    void update(T entity) throws DaoStoreException;
    @Transactional
    void delete(T entity) throws DaoStoreException;
}
