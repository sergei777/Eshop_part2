package org.tylubz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Sergei on 09.10.2016.
 */
@RestController
@RequestMapping(value = "/rest/")
public class RemoteController {
    @RequestMapping(value = "info")
    public Integer getInfo() {
        return 553;
    }
}
