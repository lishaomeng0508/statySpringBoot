package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ConsumerServer {

    @Autowired
    RestTemplate restTemplate;
    
    @HystrixCommand(fallbackMethod = "addServiceFallback")
    public String addService() {
        return restTemplate.getForEntity("http://producer/hello", String.class).getBody();
    }
    public String addServiceFallback() {
        return "error";
    }
    
}
