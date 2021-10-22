package com.example.shoppingcart.service.payment;

import com.example.shoppingcart.model.checkout.Bill;

public interface Payments {
    PaymentType getType();
    void pay(Bill bill);
}
