package com.example.shoppingcart.model.page;

import com.example.shoppingcart.model.category.Categories;
import com.example.shoppingcart.model.category.MainCategory;
import com.example.shoppingcart.model.category.SubCategory;
import com.example.shoppingcart.model.product.Product;
import com.example.shoppingcart.shopping.cart.Cart;
import com.example.shoppingcart.shopping.cart.CartItem;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class SearchPage {
    private final Scanner scanner = new Scanner(System.in);
    private final Cart cart = new Cart();
    String searchedWord;
    int count = 1;
    int productQuantity;
    String productSelection;
    private Product finalProduct;
    boolean isWordFound = true;
    boolean isRightInputFormat = false;


    public void searchCycle(Categories categories){
        List<MainCategory> mainCategoryList = categories.getMainCategoryList();

        System.out.println("* Enter the word you want to search, it must be at least 3 characters..." +
                "\n Word : ");
        searchedWord = scanner.nextLine().toLowerCase(Locale.ROOT);

        for (MainCategory category : mainCategoryList){
            for (SubCategory subCategory : category.getSubCategoryList()){
                for (Product product : subCategory.getProductList()){
                    if (product.getName().toLowerCase(Locale.ROOT).contains(searchedWord)){
                        System.out.println((count++) + "- " + product.getName());
                        isWordFound = true;
                    }
                }
            }
        }

        while(true){
            if (isWordFound){
                System.out.println("____________________________");
                System.out.println("* Enter the name of the product that you select to see its details...\n" +
                        "Name of the product : ");
                productSelection = scanner.nextLine();

                for (MainCategory category : mainCategoryList){
                    for (SubCategory subCategory : category.getSubCategoryList()){
                        for (Product product : subCategory.getProductList()){
                            if (product.getName().equalsIgnoreCase(productSelection)){
                                isRightInputFormat = true;
                            }
                        }
                    }
                }

                if (!isRightInputFormat){
                    System.out.println("*** \n *** Wrong input type try again !\n***");
                }else if (isRightInputFormat){
                    isRightInputFormat = false;
                    break;
                }
            }
            else{
                System.out.println("There is no word that contains '" + searchedWord + "' ...");
                isWordFound = false;
                break;
            }
        }

        while (isWordFound){
            System.out.println("\nDETAILS OF " + productSelection.toUpperCase(Locale.ROOT) +"\n" +
                    "____________________________");

            for (MainCategory category : mainCategoryList){
                for (SubCategory subCategory : category.getSubCategoryList()){
                    for (Product product : subCategory.getProductList()){
                        if (product.getName().equalsIgnoreCase(productSelection)){
                            finalProduct = product;
                            System.out.println(product.toString());
                        }
                    }
                }
            }

            System.out.println("____________________________\n" +
                    "* Enter how much you want to buy : ");
            productQuantity = scanner.nextInt();

            CartItem cartItem = CartItem.builder()
                    .product(finalProduct)
                    .quantity(productQuantity)
                    .build();
            cart.addItem(cartItem);

            System.out.println("Product '"+ productSelection.toUpperCase(Locale.ROOT) + "' added to cart..." );

            break;
        }







    }

}
