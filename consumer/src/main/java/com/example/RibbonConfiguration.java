package com.example;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

/**
 * Created by summer on 17-3-29.
 */
public class RibbonConfiguration {

    @Autowired
    private IClientConfig ribbonClientConfig;

    @Bean
    public IPing ribbonPing(IClientConfig config) {
        // ping url will try to access http://microservice-provider/provider/ to
        // see if reponse code is 200 . check PingUrl.isAlive()
        // param /provider/ is the context-path of provider service
        return new PingUrl(false, "/producer/");
    }

    @Bean
    public IRule ribbonRule(IClientConfig config) {
        // return new AvailabilityFilteringRule();
        // return new RandomRule();
        // return new BestAvailableRule();
        return new RoundRobinRule();//轮询
        // return new WeightedResponseTimeRule();
        // return new RetryRule();
        // return new ZoneAvoidanceRule();
    }
}
