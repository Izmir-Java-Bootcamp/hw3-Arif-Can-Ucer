package com.example.shoppingcart.shopping.cart;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cart {
    private final List<CartItem> cartItems;

    public Cart(){
        this.cartItems = new ArrayList<>();
    }

    public void addItem(CartItem cartItem){
        cartItems.add(cartItem);
    }
}
