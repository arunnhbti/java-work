package com.arun.project.microservice.product.catalog.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("custom-config")
public class Configuration {
    private int config1 = 12345;
}
