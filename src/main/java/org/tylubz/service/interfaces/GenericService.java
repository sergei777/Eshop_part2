package org.tylubz.service.interfaces;

import org.springframework.transaction.annotation.Transactional;
import org.tylubz.dao.exceptions.DaoStoreException;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Sergei on 26.09.2016.
 */
public interface GenericService<T,ID extends Serializable>{
    T create(T entity);
    T read(ID id);
    void update(T entity);
    void delete(T entity);
    List<T> readAll();
}
