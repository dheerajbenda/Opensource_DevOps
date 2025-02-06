package com.HealthcheckApp.controller;

import com.HealthcheckApp.service.HealthCheckService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Set;


@RestController
@RequestMapping("/websites")
public class CustomHealthCheckController {

    private final HealthCheckService healthCheckService;

    public CustomHealthCheckController(HealthCheckService healthCheckService) {
        this.healthCheckService = healthCheckService;
    }

    @GetMapping("/names")
    public Map<String, String> getServiceNames() {
        return healthCheckService.getServiceUrls();
    }

    @GetMapping("/status/individual")
    public String getServiceStatus(@RequestParam String serviceName) {
        return healthCheckService.getServiceStatus(serviceName);
    }
}
