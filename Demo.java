package com.example.shoppingcart;

import com.example.shoppingcart.model.page.SearchPage;
import com.example.shoppingcart.model.product.Product;
import com.example.shoppingcart.model.category.Categories;
import com.example.shoppingcart.model.category.MainCategory;
import com.example.shoppingcart.model.category.SubCategory;
import com.example.shoppingcart.model.page.MainMenuPage;
import com.example.shoppingcart.properties.DeliveryProperties;
import com.example.shoppingcart.properties.PaymentProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class Demo implements CommandLineRunner {

    private final Scanner scanner = new Scanner(System.in);
    private final MainMenuPage mainMenu = new MainMenuPage();
    private final SearchPage searchPage = new SearchPage();
    private Categories categories = createProducts();


    @Override
    public void run(String... args) throws Exception {




        System.out.println("____________________________\n" +
                "WELCOME TO KODLUYORUZ SHOP");


        System.out.println("Choose 1 for main menu or 2 for search menu");
        int select = scanner.nextInt();

        if (select == 1){
            mainMenu.mainMenuCycle(categories);
        }else if(select == 2){
            searchPage.searchCycle(categories);
        }


    }

    //
    //Creates products
    //
    public Categories createProducts(){
        Product apple = Product.builder().name("Apple").description("Fresh apples").price(6.5).build();
        Product grape = Product.builder().name("Grape").description("Fresh grapes").price(7.5).build();
        Product tomato = Product.builder().name("Tomato").description("Natural tomatoes").price(8).build();
        Product pepper = Product.builder().name("Pepper").description("Sweet pepper").price(3.75).build();
        Product lays = Product.builder().name("Lays").description("Tasty lays").price(8.5).build();
        Product doritos = Product.builder().name("Doritos").description("New doritos").price(8.5).build();
        Product albeni = Product.builder().name("Albeni").description("Classic albeni").price(2.5).build();
        Product metro = Product.builder().name("Metro").description("Metro extra large").price(2.75).build();

        //Main category snack and its subcategories and products
        MainCategory snack = new MainCategory("Snack");
        SubCategory chips = new SubCategory("Chips");
        SubCategory chocolate = new SubCategory("Chocolate");
        snack.addSubCategory(chips);
        chips.addProduct(lays);
        chips.addProduct(doritos);
        snack.addSubCategory(chocolate);
        chocolate.addProduct(albeni);
        chocolate.addProduct(metro);

        //Main category fruits & vegetables and its subcategories and products
        MainCategory fruitsAndVegetables = new MainCategory("Fruits & Vegetables");
        SubCategory fruit = new SubCategory("Fruit");
        SubCategory vegetable = new SubCategory("Vegetable");
        fruitsAndVegetables.addSubCategory(fruit);
        fruit.addProduct(apple);
        fruit.addProduct(grape);
        fruitsAndVegetables.addSubCategory(vegetable);
        vegetable.addProduct(tomato);
        vegetable.addProduct(pepper);

        Categories categories = new Categories();
        categories.addCategory(snack);
        categories.addCategory(fruitsAndVegetables);

        return categories;
    }
}



