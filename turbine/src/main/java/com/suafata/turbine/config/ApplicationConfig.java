package com.suafata.turbine.config;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Value("${app.rabbitmq.host:localhost}")
    private String rabbitMqHost;

    @Bean
    public ConnectionFactory connectionFactory(){
        CachingConnectionFactory cachingConnectionFactory =  new CachingConnectionFactory(rabbitMqHost);
        return  cachingConnectionFactory;
    }

}
