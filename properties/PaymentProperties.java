package com.example.shoppingcart.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "discount")
@Component
@Data
public class PaymentProperties {
    private double percentage;
}
