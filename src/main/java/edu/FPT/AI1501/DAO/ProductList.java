package edu.FPT.AI1501.DAO;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import edu.FPT.AI1501.DTO.Product;
import edu.FPT.AI1501.Utils.EssentialUtils;
import edu.FPT.AI1501.Utils.Menu;
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

    public void UDMenu(){
        Integer searchIndex;

        if(this.isEmpty()){
            System.out.println("This List is Empty!");
            return;
        }

        
        String productId = InputUtils.inputId(false);
        if((searchIndex = search(productId)) == -1){
            System.out.println("ID Doesnt Exist!");
            return;
        }

        Menu UDMenu = new Menu("Update And Delete Product ID");
        
        UDMenu.addItems("Update");
        UDMenu.addItems("Remove");

        while(true){
            UDMenu.printMenu("Back to main menu");
            Integer choice = UDMenu.getChoice();
            switch(choice){
                case 1:
                    update(searchIndex);
                case 2:
                    if(delete(searchIndex)){
                        return;
                    }
                default:
                    System.out.println("Exiting Menu...");
                    return;
                    

            }
        }


    }

    private void update(Integer searchIndex){
        Menu updateMenu = new Menu("Update Menu");

        updateMenu.addItems("Update Name");
        updateMenu.addItems("Update Price");
        updateMenu.addItems("Update Category ID");

        while(true){
            updateMenu.printMenu("Return");
            Integer choice = updateMenu.getChoice();
            switch(choice){
                case 1:
                    String name = InputUtils.inputName(true);
                    if(EssentialUtils.isEmptyString(name)){
                        System.out.println("Name remain unchanged!");
                    } else{
                        this.get(searchIndex).setName(name);
                        System.out.println("Name Changed Completed!");
                    }
                    break;
                case 2:
                    Double price = InputUtils.inputPrice(true);
                    if(price <= 0){
                        System.out.println("Price Remain Unchaged!");
                    } else{
                        this.get(searchIndex).setPrice(price);
                        System.out.println("Price Changed!");
                    }
                    break;
                case 3:
                    String categoryId = InputUtils.inputId(true);
                    if(EssentialUtils.isEmptyString(categoryId)){
                        System.out.println("Name remain unchanged!");
                    } else{
                        if(catList.searchId(categoryId) == -1){
                            System.out.println("Category ID does not Exist! No change were made");
                        } else{
                            this.get(searchIndex).setCategoryID(categoryId);
                            System.out.println("Category Changed!");
                        }
                    }
                    break;
                default:
                    System.out.println("Exiting update menu...");
            }
        }
    }

    private boolean delete(int searchIndex){
        if(EssentialUtils.chooseYN("Are you you want to delete this Product?","Product Deleted Successfully!","Operation Aborted!")){
            this.remove(searchIndex);
            return true;         
        } else{
            return false;
        }
    }

    public String toString() {
        Gson gs = new GsonBuilder().setPrettyPrinting().create();
        return gs.toJson(this);
    }
    
    public void print(){
        PrintUtils.printProductList(this);
    }
}
