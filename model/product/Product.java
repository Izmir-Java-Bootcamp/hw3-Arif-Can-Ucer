package com.example.shoppingcart.model.product;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private String name;
    private String description;
    private double price;

    @Override
    public String toString() {
        return "- Product name : " + name
                +"\n- Product description : " + description
                +"\n- Product price : " + price
                ;
    }
}
