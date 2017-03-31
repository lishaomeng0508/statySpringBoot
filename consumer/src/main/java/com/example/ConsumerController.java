package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by summer on 17-3-23.
 */

//@Configuration
//@RibbonClient(name = "producer", configuration = RibbonConfiguration.class)
@RestController
public class ConsumerController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

   /* @Autowired
    RestTemplate restTemplate;

   @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("producer");
        System.out.println("===" + ":" + serviceInstance.getServiceId() + ":" + serviceInstance.getHost() + ":"
                + serviceInstance.getPort());// 打印当前调用服务的信息
        return restTemplate.getForEntity("http://producer/hello?name2=lsm", String.class).getBody();
    }*/

    @Autowired
    private ComputeService computeService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String add() {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("producer");
        System.out.println("===" + ":" + serviceInstance.getServiceId() + ":" + serviceInstance.getHost() + ":"
                + serviceInstance.getPort());// 打印当前调用服务的信息*//*
        return computeService.addService();
    }

}
