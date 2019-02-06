package com.suafata.zuul.controller;

import com.suafata.zuul.config.LbConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/lb")
@RibbonClient(name = "lb", configuration = LbConfig.class)
public class LoadBalancedRestService {

    private static Logger LOGGER = LoggerFactory.getLogger(LoadBalancedRestService.class);

   private RestTemplate restTemplate;

   public LoadBalancedRestService(@Qualifier("LoadBalancedRestTemplate")  RestTemplate restTemplate){
       this.restTemplate = restTemplate;
       LOGGER.info("Initializing LoadBalancedRestService");
   }

   @RequestMapping(value ="/test")
   public String getOrderInstances() {
        String response = this.restTemplate.getForObject("http://lb/test/microservice/v1/eureka/instances/order", String.class);
        return String.format("%s, %s!", response);
    }
}
