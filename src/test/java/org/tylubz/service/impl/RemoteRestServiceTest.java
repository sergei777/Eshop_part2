package org.tylubz.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.tylubz.service.interfaces.OrderService;

import static org.junit.Assert.*;

/**
 * Created by Sergei on 18.10.2016.
 */
public class RemoteRestServiceTest {

    OrderService orderService;
    RemoteRestService remoteRestService;

    @Before
    public void setUp() throws Exception {
        orderService = Mockito.mock(OrderServiceImpl.class);
        remoteRestService = new RemoteRestService();
        remoteRestService.setOrderService(orderService);

    }

    @Test
    public void testCountResult() throws Exception {
        remoteRestService.countResult();
        Mockito.verify(orderService).readAll();
    }
}