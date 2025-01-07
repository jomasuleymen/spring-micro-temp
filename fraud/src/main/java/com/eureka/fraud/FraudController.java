package com.eureka.fraud;

import com.eureka.clients.fraud.FraudClient;
import com.eureka.clients.fraud.FraudResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/fraud-checker")
@RequiredArgsConstructor
public class FraudController implements FraudClient {
    private final FraudService fraudService;

    @GetMapping("{customerName}")
    public FraudResponse checkForFraud(@PathVariable("customerName") String customerName) {
        return fraudService.checkForFraud(customerName);
    }
}
