package com.example.shoppingcart.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "delivery")
@Component
@Data
public class DeliveryProperties {
    private double deliveryFee;
    private double deliveryFeeLimit;
}
