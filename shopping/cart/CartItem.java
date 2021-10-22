package com.example.shoppingcart.shopping.cart;

import com.example.shoppingcart.model.product.Product;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CartItem {
    private Product product;
    private int quantity;
    //private Discount discount;

    public double getPrice(){
        return product.getPrice() * quantity;
    }

   /* public double getDiscountedPrice() {
        if (discount != null) {
            return discount.applyDiscount(this);
        }
        return getPrice();
    }*/
}
