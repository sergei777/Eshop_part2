package org.tylubz.service.interfaces;

import org.tylubz.model.data.ResultListWrapper;
import org.tylubz.model.entity.ProductEntity;

import java.util.List;

/**
 * Created by Sergei on 26.09.2016.
 */
public interface ProductService extends GenericService<ProductEntity,Integer> {
    ResultListWrapper<ProductEntity> getProductsByPriceRange(Float minPrice, Float maxPrice, int pageSize, int pageNumber);
}
