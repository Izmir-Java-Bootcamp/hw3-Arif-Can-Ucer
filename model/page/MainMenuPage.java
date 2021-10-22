package com.example.shoppingcart.model.page;

import com.example.shoppingcart.model.product.Product;
import com.example.shoppingcart.model.category.Categories;
import com.example.shoppingcart.model.category.MainCategory;
import com.example.shoppingcart.model.category.SubCategory;
import com.example.shoppingcart.shopping.cart.Cart;

import com.example.shoppingcart.shopping.cart.CartItem;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

@Component
@RequiredArgsConstructor
@Data
public class MainMenuPage {

    private final Scanner scanner = new Scanner(System.in);
    private final Cart cart = new Cart();

    int orderNumber = 1;

    private int productQuantity;

    private Product finalProduct;

    String mainCategorySelection;
    String subCategorySelection;
    String productSelection;

    boolean isRightInputFormat = false;

    public void mainMenuCycle(Categories categories){
        List<MainCategory> mainCategoryList = categories.getMainCategoryList();

        //
        //Printing main categories
        //
        while(true){
            System.out.println("\nMAIN CATEGORIES\n" +
                    "____________________________");
            for (MainCategory category : mainCategoryList){
                System.out.println((orderNumber++) + ("- ") + (category.getMainCategoryName()));
            }

            orderNumber = 1;

            System.out.println("____________________________");
            System.out.println("* Enter the name of the main category that you select to see its subcategories...\n" +
                    "Name of the main category : ");
            mainCategorySelection = scanner.nextLine();

            //Controlling the input of mainCategorySelection
            for (MainCategory category : mainCategoryList){
                if (mainCategorySelection.equalsIgnoreCase(category.getMainCategoryName())){
                    isRightInputFormat = true;
                }
            }

            if (!isRightInputFormat){
                System.out.println("*** \n *** Wrong input type try again !\n***");
            }else if (isRightInputFormat){
                isRightInputFormat = false;
                break;
            }
        }

        //
        //Printing subcategories of the main category that selected by user
        //
        while(true){
            System.out.println("\nSUBCATEGORIES OF " + mainCategorySelection.toUpperCase(Locale.ROOT) + "\n" +
                    "____________________________");
            for (MainCategory category : mainCategoryList){
                if (category.getMainCategoryName().equalsIgnoreCase(mainCategorySelection)){
                    for (SubCategory subCategory : category.getSubCategoryList()){
                        System.out.println((orderNumber++) + ("- ") + (subCategory.getSubCategoryName()));
                    }
                }
            }

            orderNumber = 1;

            System.out.println("____________________________");
            System.out.println("* Enter the name of the subcategory that you select to see its products...\n" +
                    "Name of the subcategory : ");
            subCategorySelection = scanner.nextLine();

            //Controlling the input of subCategorySelection
            for (MainCategory category : mainCategoryList){
                if (mainCategorySelection.equalsIgnoreCase(category.getMainCategoryName())){
                    for (SubCategory subCategory : category.getSubCategoryList()){
                        if (subCategorySelection.equalsIgnoreCase(subCategory.getSubCategoryName())){
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

        //
        //Printing products of the subcategory that selected buy user
        //
        while(true){
            System.out.println("\nPRODUCTS OF " + subCategorySelection.toUpperCase(Locale.ROOT) +"\n" +
                    "____________________________");
            for (MainCategory category : mainCategoryList){
                if (category.getMainCategoryName().equalsIgnoreCase(mainCategorySelection)){
                    for (SubCategory subCategory : category.getSubCategoryList()){
                        if (subCategory.getSubCategoryName().equalsIgnoreCase(subCategorySelection)){
                            for (Product product : subCategory.getProductList()){
                                System.out.println((orderNumber++) + "- " + (product.getName()));
                            }
                        }
                    }
                }
            }

            orderNumber = 1;

            System.out.println("____________________________");
            System.out.println("* Enter the name of the product that you select to see its details...\n" +
                    "Name of the product : ");
            productSelection = scanner.nextLine();

            //Controlling the input of productSelection
            for (MainCategory category : mainCategoryList){
                if (category.getMainCategoryName().equalsIgnoreCase(mainCategorySelection)){
                    for (SubCategory subCategory : category.getSubCategoryList()){
                        if (subCategory.getSubCategoryName().equalsIgnoreCase(subCategorySelection)){
                            for (Product product : subCategory.getProductList()){
                                if (productSelection.equalsIgnoreCase(product.getName())){
                                    isRightInputFormat = true;
                                }
                            }
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

        //
        //Printing details of the product that selected by user
        //Reading quantity and adding product to cart as a cartItem
        //
        while(true){
            System.out.println("\nDETAILS OF " + productSelection.toUpperCase(Locale.ROOT) +"\n" +
                    "____________________________");

            for (MainCategory category : mainCategoryList){
                if (category.getMainCategoryName().equalsIgnoreCase(mainCategorySelection)){
                    for (SubCategory subCategory : category.getSubCategoryList()){
                        if (subCategory.getSubCategoryName().equalsIgnoreCase(subCategorySelection)){
                            for (Product product : subCategory.getProductList()){
                                if (product.getName().equalsIgnoreCase(productSelection)){
                                    finalProduct = product;
                                    System.out.println(product.toString());
                                }
                            }
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
