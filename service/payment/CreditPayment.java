package com.example.shoppingcart.service.payment;

import com.example.shoppingcart.model.checkout.Bill;

public class CreditPayment implements Payments{
    @Override
    public PaymentType getType() {
        return PaymentType.CREDIT;
    }

    @Override
    public void pay(Bill bill) {

    }
}
