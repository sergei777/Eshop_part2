package org.tylubz.dao.impl;

import org.springframework.stereotype.Repository;
import org.tylubz.dao.interfaces.ProductDao;
import org.tylubz.model.entity.ProductEntity;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by Sergei on 02.10.2016.
 */
@Repository
public class ProductDaoImpl extends GenericDaoJpaImpl<ProductEntity,Integer> implements ProductDao {

    @Override
    public long getTotalNumberOfElements() {
        String sqlQuery = "SELECT COUNT(d.id) FROM ProductEntity d";
        Query q = getEntityManager().createQuery(sqlQuery);
        return  (long) q.getSingleResult();
    }

    @Override
    public List<ProductEntity> getElements(int pageSize, int pageNumber) {
        Query query = getEntityManager().createQuery("SELECT FROM d ProductEntity");
        query.setFirstResult((pageNumber-1) * pageSize);
        query.setMaxResults(pageSize);
        List <ProductEntity> list = query.getResultList();
        return list;
    }
}
