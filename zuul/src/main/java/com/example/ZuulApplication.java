package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
//@EnableZuulServer
@SpringBootApplication
public class ZuulApplication {
	/*@Bean
	public MyZuulFilter preRequestLogFilter() {
		return new MyZuulFilter();
	}*/
	public static void main(String[] args) {
		SpringApplication.run(ZuulApplication.class, args);
	}
}
