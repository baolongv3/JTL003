package edu.FPT.AI1501.View;

import edu.FPT.AI1501.DTO.Category;
import edu.FPT.AI1501.DTO.Product;

public class PrintUtils {
    public static void printCategoryInfo(Category cat){
        System.out.println("=================================================");
        System.out.println("Category Info: ");
        System.out.println("ID  : " + cat.getId());
        System.out.println("Name: " + cat.getName());       
        System.out.println("=================================================");
    }

    public static void printProductInfo(Product prod){
        System.out.println("=================================================");
        System.out.println("Product Info: ");
        System.out.println("ID   : " + prod.getId());
        System.out.println("Name : " + prod.getName()); 
        System.out.println("Price: " + prod.getPrice());
        System.out.println("Category Id: " + prod.getCategoryID());
        System.out.println("=================================================");
    }
}
