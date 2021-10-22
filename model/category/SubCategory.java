package com.example.shoppingcart.model.category;


import com.example.shoppingcart.model.product.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubCategory extends MainCategory{
    private String subCategoryName;
    private final List<Product> productList = new ArrayList<>();

    public SubCategory(String mainCategoryName,String subCategoryName) {
        super(mainCategoryName);
        this.subCategoryName = subCategoryName;
    }

    public void addProduct(Product product){
        productList.add(product);
    }
}
