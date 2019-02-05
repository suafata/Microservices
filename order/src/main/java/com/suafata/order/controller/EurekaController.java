package com.suafata.order.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.suafata.order.RestMapping.EUREKA;

@RestController
@RequestMapping(value = EUREKA)
public class EurekaController {

    private static Logger LOGGER = LoggerFactory.getLogger(EurekaController.class);
    private DiscoveryClient discoveryClient;

    @Autowired
    public EurekaController(DiscoveryClient discoveryClient){
        this.discoveryClient = discoveryClient;
        LOGGER.info("Initializing controller");
    }

    @RequestMapping("/instances/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(
            @PathVariable String applicationName) {
        return this.discoveryClient.getInstances(applicationName);
    }

    @RequestMapping("/services")
    public List<String> getServices() {
        return this.discoveryClient.getServices();
    }

}
