package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by summer on 17-3-23.
 */
@RestController
@RibbonClient(name = "producer", configuration = RibbonConfiguration.class)
public class ConsumerController {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String add() {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("producer");
        System.out.println("===" + ":" + serviceInstance.getServiceId() + ":" + serviceInstance.getHost() + ":"
                + serviceInstance.getPort());// 打印当前调用服务的信息
        return restTemplate().getForEntity("http://producer/hello?name2=lsm", String.class).getBody();
    }
}
