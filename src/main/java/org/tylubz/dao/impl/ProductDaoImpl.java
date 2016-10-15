package org.tylubz.dao.impl;

import org.springframework.stereotype.Repository;
import org.tylubz.dao.interfaces.ProductDao;
import org.tylubz.model.entity.ProductEntity;

/**
 * Created by Sergei on 02.10.2016.
 */
@Repository
public class ProductDaoImpl extends GenericDaoJpaImpl<ProductEntity,Integer> implements ProductDao {
}
