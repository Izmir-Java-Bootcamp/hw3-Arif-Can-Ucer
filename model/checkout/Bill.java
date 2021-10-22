package com.example.shoppingcart.model.checkout;

import lombok.Data;
import java.util.List;

@Data
public class Bill {
    private List<BillItem> billItemList;
    private double totalPrice;
}
