package com.example.shoppingcart.service.discount;

import com.example.shoppingcart.shopping.cart.CartItem;

public interface Discount {
    double applyDiscount(CartItem cartItem);
}
