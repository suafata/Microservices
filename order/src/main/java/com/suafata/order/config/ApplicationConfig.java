package com.suafata.order.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Configuration
@ConfigurationProperties(prefix = "app")
@PropertySource("classpath:application.properties")
@Validated
@Getter
@Setter
public class ApplicationConfig {
    @NotNull
    private String name;
    private String description;

}
