package com.example.shoppingcart.model.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.ArrayList;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class Categories {
    private List<MainCategory> mainCategoryList = new ArrayList<>();

    public void addCategory(MainCategory mainCategory){
        mainCategoryList.add(mainCategory);
    }
}
