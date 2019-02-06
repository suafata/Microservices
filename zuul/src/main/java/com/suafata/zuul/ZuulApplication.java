package com.suafata.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages={"com.netflix.client.config.IClientConfig"})
@EnableZuulProxy
@EnableDiscoveryClient
//@ComponentScan(basePackages = {"com.netflix.client.config.IClientConfig", "com.suafata.zuul"})
public class ZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulApplication.class, args);
	}


}

