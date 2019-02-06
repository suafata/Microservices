package com.suafata.zuul.config;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.PingUrl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LbConfig {

    @Bean
    public IPing ribbonPing() {
        return new PingUrl();
    }

}
