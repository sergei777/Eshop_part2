package org.tylubz.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.tylubz.dao.impl.GenericDaoJpaImpl;
import org.tylubz.dao.impl.ProductDaoImpl;
import org.tylubz.dao.interfaces.GenericDao;
import org.tylubz.model.entity.ProductEntity;
import org.tylubz.service.impl.GenericServiceImpl;
import org.tylubz.service.impl.ProductServiceImpl;

import static org.junit.Assert.*;

/**
 * Created by Sergei on 18.10.2016.
 */
public class GenericServiceImplTest {

    private GenericServiceImpl<ProductEntity,Integer> service;
    private GenericDao<ProductEntity,Integer> genericDao;

    @Before
    public void setUp() throws Exception {
        genericDao = Mockito.mock(ProductDaoImpl.class);
        service = new ProductServiceImpl(genericDao);
    }

    @Test
    public void testCreate() throws Exception {
        ProductEntity entity = Mockito.mock(ProductEntity.class);
        service.create(entity);
        Mockito.verify(genericDao).create(entity);

    }

    @Test
    public void testRead() throws Exception {
        Integer id = 23;
        service.read(id);
        Mockito.verify(genericDao).read(id);

    }

    @Test
    public void testUpdate() throws Exception {
        ProductEntity entity = Mockito.mock(ProductEntity.class);
        service.update(entity);
        Mockito.verify(genericDao).update(entity);
    }

    @Test
    public void testDelete() throws Exception {
        ProductEntity entity = Mockito.mock(ProductEntity.class);
        service.delete(entity);
        Mockito.verify(genericDao).delete(entity);
    }

    @Test
    public void testDeleteById() throws Exception {
        Integer id = 23;
        service.delete(id);
        Mockito.verify(genericDao).delete(id);
    }

    @Test
    public void testReadAll() throws Exception {
        service.readAll();
        Mockito.verify(genericDao).readAll();
    }

    @Test
    public void testReadByPageNumberAndPageSize() throws Exception {
        Integer pageNumber = 1;
        Integer pageSize = 5;
        service.read(pageNumber,pageSize);
        Mockito.verify(genericDao).read(pageNumber,pageSize);
    }
}