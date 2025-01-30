package com.HealthcheckApp.service;

import com.HealthcheckApp.config.HealthCheckConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class HealthCheckService {

    private static final Logger logger = LoggerFactory.getLogger(HealthCheckService.class);
    private final HealthCheckConfig healthCheckConfig;

    public HealthCheckService(HealthCheckConfig healthCheckConfig) {
        this.healthCheckConfig = healthCheckConfig;
    }

    public Map<String, String> getWebsiteStatuses() {
        Map<String, String> statuses = new HashMap<>();
        Map<String, String> serviceUrls = healthCheckConfig.getUrls();
        logger.info("Loaded service URLs: {}", serviceUrls);

        serviceUrls.forEach((name, urlString) -> {
            statuses.put(name, checkServiceStatus(urlString));
        });

        return statuses;
    }
    public Set<String> getServiceNames() {
        Map<String, String> serviceUrls = healthCheckConfig.getUrls();
        logger.info("Loaded service names: {}", serviceUrls.keySet());
        return serviceUrls.keySet();
    }


    public String getServiceStatus(String serviceName) {
        String url = healthCheckConfig.getUrls().get(serviceName);
        if (url == null) {
            return "Service URL not found";
        }
        return checkServiceStatus(url);
    }

    private String checkServiceStatus(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD");
            connection.setConnectTimeout(5000); // Timeout for connection
            connection.setReadTimeout(5000); // Timeout for reading data
            int responseCode = connection.getResponseCode();
            if (responseCode >= 200 && responseCode < 400) {
                return "Service is up ✅";
            } else {
                return "Service is down ❌ (Status code: " + responseCode + ")";
            }
        } catch (IOException e) {
            logger.error("Error checking status of URL {}: {}", urlString, e.getMessage());
            return "Service is down ❌ (Unreachable)";
        }
    }
}
