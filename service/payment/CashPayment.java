package com.example.shoppingcart.service.payment;

import com.example.shoppingcart.model.checkout.Bill;

public class CashPayment implements Payments{
    @Override
    public PaymentType getType() {
        return PaymentType.CASH;
    }

    @Override
    public void pay(Bill bill) {

    }
}
