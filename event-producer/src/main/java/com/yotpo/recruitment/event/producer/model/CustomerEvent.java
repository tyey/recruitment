package com.yotpo.recruitment.event.producer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CustomerEvent(
    int customerId,
    String eventType,
    Double amount,
    String page,
    String item,
    String timestamp
) {
}
