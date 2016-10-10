package org.tylubz.dao.impl;

import org.springframework.stereotype.Repository;
import org.tylubz.dao.interfaces.CategoryDao;
import org.tylubz.entity.CategoryEntity;

/**
 * Created by Sergei on 10.10.2016.
 */
@Repository
public class CategoryDaoImpl extends GenericDaoJpaImpl<CategoryEntity,Integer> implements CategoryDao {
}
