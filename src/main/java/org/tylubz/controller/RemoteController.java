package org.tylubz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tylubz.service.impl.RemoteRestService;

/**
 * Class for returning information
 * about orders and users in JSON
 */
@RestController
@RequestMapping(value = "/rest/")
public class RemoteController {
    @Autowired
    RemoteRestService service;

    /**
     * getting info about users
     * and orders
     * @return
     */
    @RequestMapping(value = "info",produces={"application/json; charset=UTF-8"})
    public String getInfo() {
        return service.countResult();
    }
}
