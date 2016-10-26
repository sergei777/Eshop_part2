package org.tylubz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.tylubz.dao.interfaces.CategoryDao;
import org.tylubz.dao.interfaces.GenericDao;
import org.tylubz.model.entity.CategoryEntity;
import org.tylubz.service.interfaces.CategoryService;

/**
 * Implementation of CategoryService interface
 */
@Service
public class CategoryServiceImpl extends GenericServiceImpl<CategoryEntity,Integer> implements CategoryService {
    private CategoryDao categoryDao;
    @Autowired
    public CategoryServiceImpl(
            @Qualifier("categoryDaoImpl") GenericDao<CategoryEntity, Integer> genericDao) {
        super(genericDao);
        this.categoryDao = (CategoryDao) genericDao;
    }
}
