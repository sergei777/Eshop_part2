package org.tylubz.dao.interfaces;

import org.tylubz.model.data.ResultListWrapper;
import org.tylubz.model.entity.ProductEntity;

import java.util.List;

/**
 * Created by Sergei on 02.10.2016.
 */
public interface ProductDao extends GenericDao<ProductEntity,Integer> {
    ResultListWrapper<ProductEntity> getProductsByPriceRange(Float minPrice, Float maxPrice, int pageSize, int pageNumber);
}
