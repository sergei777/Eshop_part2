package org.tylubz.dao.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.tylubz.dao.impl.GenericDaoJpaImpl;
import org.tylubz.dao.impl.ProductDaoImpl;
import org.tylubz.model.entity.ProductEntity;

import javax.persistence.EntityManager;

import static org.mockito.Matchers.any;

/**
 * Created by Sergei on 17.10.2016.
 */
public class GenericDaoJpaImplTest {

    private GenericDaoJpaImpl<ProductEntity,Integer> implementation;
    private ProductEntity entity;
    private EntityManager em;

    @Before
    public void setUp() throws Exception {
        implementation = new ProductDaoImpl();
        em = Mockito.mock(EntityManager.class);
        entity = Mockito.mock(ProductEntity.class);
    }

    @Test
    public void testCreate() throws Exception {
        implementation = Mockito.mock(ProductDaoImpl.class);
        Mockito.when(implementation.create(any(ProductEntity.class))).thenReturn(entity);
        ProductEntity productEntity = Mockito.mock(ProductEntity.class);
        Assert.assertEquals(entity,implementation.create(productEntity));
    }

    @Test
    public void testRead() throws Exception {
        Mockito.when(em.find(ProductEntity.class,23)).thenReturn(entity);
        implementation.setEntityManager(em);
        Assert.assertEquals(entity,implementation.read(23));
    }

    @Test
    public void testUpdate() throws Exception {
        implementation.setEntityManager(em);
        implementation.update(entity);
        Mockito.verify(em).merge(entity);

    }

    @Test
    public void testDelete() throws Exception {
        implementation.setEntityManager(em);
        implementation.delete(entity);
        Mockito.verify(em).remove(entity);

    }

    @Test
    public void testDeletePrimaryKey() throws Exception {
        implementation.setEntityManager(em);
        Mockito.when(em.find(ProductEntity.class,23)).thenReturn(entity);
        implementation.delete(23);
        Mockito.verify(em).remove(entity);
    }

}