package com.HealthcheckApp.controller;

import com.HealthcheckApp.service.HealthCheckService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Set;

import static com.HealthcheckApp.config.HealthCheckConfig.logger;

@RestController
public class CustomHealthCheckController {

    private final HealthCheckService healthCheckService;

    public CustomHealthCheckController(HealthCheckService healthCheckService) {
        this.healthCheckService = healthCheckService;
    }

    @GetMapping("/websites/status")
    public Map<String, String> getWebsiteStatuses() {
        return healthCheckService.getWebsiteStatuses();
    }
    @GetMapping("/websites/names")
    public Set<String> getServiceNames() {
        Set<String> serviceNames = healthCheckService.getServiceNames();
        logger.info("Service names retrieved: {}", serviceNames);
        return serviceNames;
    }

    @GetMapping("/websites/status/individual")
    public String getServiceStatus(@RequestParam String serviceName) {
        return healthCheckService.getServiceStatus(serviceName);
    }
}
