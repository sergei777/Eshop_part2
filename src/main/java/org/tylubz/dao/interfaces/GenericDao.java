package org.tylubz.dao.interfaces;

import org.tylubz.dao.exceptions.DaoStoreException;
import org.tylubz.model.data.ResultListWrapper;

import java.io.Serializable;
import java.util.List;

/**
 * Interface for manipulating operations with entities
 * CRUD operations
 *
 * @param <E>  Entity
 * @param <PK> Primary key
 * @author Sergei
 */
public interface GenericDao<E, PK extends Serializable> {
    /**
     * Method for creation new Instance in database
     *
     * @param newInstance
     * @return new entity
     * @throws DaoStoreException
     */
    E create(E newInstance);

    /**
     * returns entity by primary key
     *
     * @param id primary key
     * @return entity
     * @throws DaoStoreException
     */
    E read(PK id);

    /**
     * updates entity
     *
     * @param transientObject entity for updating
     * @throws DaoStoreException
     */
    void update(E transientObject);

    /**
     * removes entity from database
     *
     * @param persistentObject removing entity
     * @throws DaoStoreException
     */
    void delete(E persistentObject);


    void delete(PK id);

    /**
     * returns all entities from database
     * @return list of entities
     */
    List<E> readAll();

    ResultListWrapper<E> read(int pageNumber,int pageSize);
}
