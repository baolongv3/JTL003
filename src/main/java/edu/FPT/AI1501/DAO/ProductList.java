package edu.FPT.AI1501.DAO;

import java.util.ArrayList;

import edu.FPT.AI1501.DTO.Product;
import edu.FPT.AI1501.Utils.EssentialUtils;
import edu.FPT.AI1501.View.InputUtils;
import edu.FPT.AI1501.View.PrintUtils;

public class ProductList extends ArrayList<Product> {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    CategoryList catList = new CategoryList();
    
    public ProductList(CategoryList catList){
        this.catList = catList;
    }

    public Integer search(String id){
        return this.indexOf(new Product(id));
    }

    public void add(){
       

        while(true){
            String id;
            String name;
            Double price;
            String catId;

            while(true){
                id = InputUtils.inputId(false);
                if(search(id) != -1){
                    System.out.println("ID Existed! Try again");
                } else{
                    break;
                }
            }

            name = InputUtils.inputName(false);
            price = InputUtils.inputPrice(false);

            while(true){
                catId = InputUtils.inputId(false);
                if(catList.searchId(catId) == -1){
                    System.out.println("Category ID does not exist!");
                } else{
                    break;
                }
            }

            Product newProduct  = new Product(id,name,price,catId);
            PrintUtils.printProductInfo(newProduct);
            if(EssentialUtils.chooseYN("Do you want to add this product?","Added Successful!","Operation Aborted!")){
                this.add(newProduct);
            }

            if(!EssentialUtils.chooseYN("Do you want to Continue Adding?","","Returning to main menu")){
                return;
            }
            
        }
    }

   
}
