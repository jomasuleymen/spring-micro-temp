package com.eureka.clients.fraud;

import lombok.Builder;

@Builder
public record FraudResponse(
        Boolean isFraud
) {
}
