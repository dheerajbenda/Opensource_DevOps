package com.HealthcheckApp.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "healthcheck")
public class HealthCheckConfig {

    public static final Logger logger = LoggerFactory.getLogger(HealthCheckConfig.class);

    private Map<String, String> urls = Collections.emptyMap();

    public Map<String, String> getUrls() {
        logger.info("Returning service URLs: {}", urls);
        return urls;
    }

    public void setUrls(Map<String, String> urls) {
        this.urls = urls;
        if (urls.isEmpty()) {
            logger.warn("No service URLs have been configured. Please check healthcheck-urls.properties.");
        } else {
            logger.info("Service URLs successfully loaded: {}", urls);
        }
    }
}
