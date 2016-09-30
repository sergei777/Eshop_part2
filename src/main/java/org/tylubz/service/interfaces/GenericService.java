package org.tylubz.service.interfaces;

import org.springframework.transaction.annotation.Transactional;
import org.tylubz.dao.exceptions.DaoStoreException;

import java.io.Serializable;

/**
 * Created by Sergei on 26.09.2016.
 */
public interface GenericService<T,ID extends Serializable>{
    @Transactional
    T create(T entity);
    @Transactional
    T read(ID id);
    @Transactional
    void update(T entity);
    @Transactional
    void delete(T entity);
}
