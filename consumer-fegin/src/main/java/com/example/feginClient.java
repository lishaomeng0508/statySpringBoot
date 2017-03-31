package com.example;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by summer on 17-3-24.
 */
@FeignClient(name="producer222",configuration = FooConfiguration.class)
public interface feginClient {
    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    String hello(@RequestParam(value = "name2") String name2);

}
