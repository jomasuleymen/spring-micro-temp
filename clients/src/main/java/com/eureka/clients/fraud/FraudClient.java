package com.eureka.clients.fraud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "FRAUD-APP", path = "/api/v1/")
public interface FraudClient {
    @GetMapping("fraud-checker/{customerName}")
    FraudResponse checkForFraud(@PathVariable("customerName") String customerName);
}
