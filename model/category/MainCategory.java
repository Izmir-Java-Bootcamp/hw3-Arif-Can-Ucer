package com.example.shoppingcart.model.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MainCategory{
    private String mainCategoryName;
    private List<SubCategory> subCategoryList = new ArrayList<>();

    public MainCategory(String mainCategoryName) {
        this.mainCategoryName = mainCategoryName;
    }

    public void addSubCategory(SubCategory subCategory){
        subCategoryList.add(subCategory);
    }
}
