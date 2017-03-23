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
    public String add(@RequestParam Integer a, @RequestParam Integer b) {
        ServiceInstance instance = mydclient.getLocalServiceInstance();
        String say = "我爱你";
        logger.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + say);
        return say;
    }
}
