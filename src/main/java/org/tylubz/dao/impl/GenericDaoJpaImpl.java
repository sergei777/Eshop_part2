package org.tylubz.dao.impl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.tylubz.dao.exceptions.DaoStoreException;
import org.tylubz.dao.interfaces.GenericDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Implementation of GenericDao
 *
 * @param <E>  Entity
 * @param <PK> Primary key
 * @author Sergei
 */
@Repository
public abstract class GenericDaoJpaImpl<E, PK extends Serializable>
        implements GenericDao<E, PK> {

    protected Class<E> entityClass;
    protected EntityManager entityManager;

    public GenericDaoJpaImpl() {
        Type type = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) type;
        entityClass = (Class) pt.getActualTypeArguments()[0];
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    /**
     * creates new entity
     *
     * @param newInstance
     * @return
     * @throws DaoStoreException
     */
    public E create(E newInstance) {
        getEntityManager().persist(newInstance);
        return newInstance;
    }

    /**
     * read entity from db
     *
     * @param id primary key
     * @return entity
     */
    public E read(PK id) {
        return getEntityManager().find(entityClass, id);
    }

    /**
     * update entity in db
     *
     * @param entity for updating
     * @throws DaoStoreException
     */
    public void update(E entity) {
            getEntityManager().merge(entity);
    }

    /**
     * removes entity from db
     *
     * @param entity for deleting
     * @throws DaoStoreException
     */
    public void delete(E entity) {
            getEntityManager().remove(entity);
    }

    /**
     * returns all entities from database
     *
     * @return list of entities
     */
    @Override
    public List<E> readAll() {
        return getEntityManager().createQuery("select a from " + entityClass.getSimpleName() + " a")
                .getResultList();
    }

}
