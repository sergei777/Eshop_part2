package org.tylubz.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.tylubz.dao.interfaces.ProductDao;
import org.tylubz.model.data.ProductInfoWrapper;
import org.tylubz.model.data.ResultListWrapper;
import org.tylubz.model.entity.ProductEntity;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by Sergei on 02.10.2016.
 */
@Repository
public class ProductDaoImpl extends GenericDaoJpaImpl<ProductEntity,Integer> implements ProductDao {
    @Override
    public ResultListWrapper<ProductEntity> getProductsByPriceRange(Float minPrice, Float maxPrice, int pageSize, int pageNumber) {
        String queryString = "SELECT a FROM ProductEntity AS a WHERE a.price between :minPrice and :maxPrice";
        Query query = getEntityManager().createQuery(queryString);
        query.setParameter("minPrice", minPrice);
        query.setParameter("maxPrice", maxPrice);
        long count = query.getResultList().size();
        query.setFirstResult((pageNumber - 1) * pageSize);
        query.setMaxResults(pageSize);
        List<ProductEntity> list = (List<ProductEntity>) query.getResultList();
        return new ResultListWrapper<>(count, list);
    }
}
