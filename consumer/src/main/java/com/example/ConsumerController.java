package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by summer on 17-3-23.
 */
@RestController
public class ConsumerController {
    /*@Autowired
    RestTemplate restTemplate;
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String add() {
        return restTemplate.getForEntity("http://producer/hello", String.class).getBody();
    }*/
    
    @Autowired
    private ConsumerServer cs;
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return cs.addService();
    }
}
