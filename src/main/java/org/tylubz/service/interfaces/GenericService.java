package org.tylubz.service.interfaces;

import java.io.Serializable;

/**
 * Created by Sergei on 26.09.2016.
 */
public interface GenericService<T,ID extends Serializable>{
    T create(T entity);
    T read(ID id);
    void update(T entity);
    void delete(T entity);
}
