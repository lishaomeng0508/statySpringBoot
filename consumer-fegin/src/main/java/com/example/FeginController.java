package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by summer on 17-3-24.
 */
@RestController
public class FeginController {

    @Autowired
    feginClient fc;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String say() {
        return fc.hello("lsm");
    }
}
