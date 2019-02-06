package com.suafata.zuul.config;

import com.suafata.zuul.filter.PreFilter;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfig {
    @Bean
    public PreFilter getPreFilter() {
        return new PreFilter();
    }

    @LoadBalanced
    @Bean("LoadBalancedRestTemplate")
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
