package com.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by summer on 17-3-31.
 */
@RestController
public class ZuulController {

    @RequestMapping("/index")
    public Object index() {
        return "index";
    }

    @RequestMapping("/home")
    public Object home() {
        return "home";
    }

}
