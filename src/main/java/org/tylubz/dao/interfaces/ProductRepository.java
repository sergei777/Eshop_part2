package org.tylubz.dao.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.tylubz.entity.ProductEntity;

/**
 * Created by Sergei on 26.09.2016.
 */
public interface ProductRepository extends CrudRepository<ProductEntity,Integer> {
}
