package com.example.shoppingcart.model.checkout;

import lombok.Data;

@Data
public class BillItem {
    private String productName;
    private String description;
    private double price;
    private double discountedPrice;
    private int quantity;
}
