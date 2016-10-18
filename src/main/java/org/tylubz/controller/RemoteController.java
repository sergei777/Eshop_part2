package org.tylubz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tylubz.service.impl.RemoteRestService;

/**
 * Created by Sergei on 09.10.2016.
 */
@RestController
@RequestMapping(value = "/rest/")
public class RemoteController {
    @Autowired
    RemoteRestService service;
    @RequestMapping(value = "info",produces={"application/json; charset=UTF-8"})
    public String getInfo() {
        return service.countResult();
    }
}
