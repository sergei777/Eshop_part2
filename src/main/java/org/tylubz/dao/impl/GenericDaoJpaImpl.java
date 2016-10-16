package org.tylubz.dao.impl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.tylubz.dao.exceptions.DaoStoreException;
import org.tylubz.dao.interfaces.GenericDao;
import org.tylubz.model.data.ResultListWrapper;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
    @Override
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
    @Override
    public E read(PK id) {
        return getEntityManager().find(entityClass, id);
    }

    /**
     * update entity in db
     *
     * @param entity for updating
     * @throws DaoStoreException
     */
    @Override
    public void update(E entity) {
            getEntityManager().merge(entity);
    }

    /**
     * removes entity from db
     *
     * @param entity for deleting
     * @throws DaoStoreException
     */
    @Override
    public void delete(E entity) {
            getEntityManager().remove(entity);
    }

    @Override
    public void delete(PK id) {
        try {
            E entity = getEntityManager().find(entityClass, id);
            getEntityManager().remove(entity);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
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

    /**
     * returns elements from database
     *
     * @param pageNumber - number of page
     * @param pageSize - number of returned elements
     * @return list wrapper which includes total number of
     * elements and list of elements
     */
    @Override
    public ResultListWrapper<E> read(int pageNumber, int pageSize) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
        countQuery.select(builder.count(countQuery.from(entityClass)));
        Long count = entityManager.createQuery(countQuery).getSingleResult();
        CriteriaQuery<E> criteriaQuery = builder.createQuery(entityClass);
        Root<E> from = criteriaQuery.from(entityClass);
        CriteriaQuery<E> select = criteriaQuery.select(from);
        TypedQuery<E> typedQuery = entityManager.createQuery(select);
        typedQuery.setFirstResult((pageNumber-1) * pageSize);
        typedQuery.setMaxResults(pageSize);
        List<E> elementList = typedQuery.getResultList();
        return new ResultListWrapper<>(count,elementList);
    }

}
