package com.example;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by summer on 17-3-23.
 */
@RestController
public class ProducerController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient mydclient;

    @RequestMapping(value = "/hello" ,method = RequestMethod.GET)
    public String hello(@RequestParam String name2) {
        ServiceInstance instance = mydclient.getLocalServiceInstance();
        logger.info("/hello, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:love you " + name2);
        return "love you "+name2;
    }
}
