package com.eureka.fraud;

import com.eureka.clients.fraud.FraudResponse;
import org.springframework.stereotype.Service;

@Service
public class FraudService {

    public FraudResponse checkForFraud(String customerName) {
        return FraudResponse.builder()
                .isFraud(customerName.startsWith("fraud"))
                .build();
    }
}
