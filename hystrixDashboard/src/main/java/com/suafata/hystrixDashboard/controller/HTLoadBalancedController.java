package com.suafata.hystrixDashboard.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HTLoadBalancedController {

   private static Logger LOGGER = LoggerFactory.getLogger(HTLoadBalancedController.class);
   private static String DUMMY_VALUE = "None";

   private RestTemplate restTemplate;

   public HTLoadBalancedController(@Qualifier("LoadBalancedRestTemplate")  RestTemplate restTemplate){
       this.restTemplate = restTemplate;
       LOGGER.info("Initializing HTLoadBalancedController");
   }

   @RequestMapping(value ="/htlb")
   @HystrixCommand(fallbackMethod = "defaultOrder")
   public String getOrderInstances() {
        String response = this.restTemplate.getForObject("http://order/microservice/v1/eureka/instances/order", String.class);
        return response;
    }

    public String defaultOrder() {
        return DUMMY_VALUE;
    }
}
