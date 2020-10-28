package edu.FPT.AI1501.DAO;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import edu.FPT.AI1501.DTO.Category;
import edu.FPT.AI1501.Utils.EssentialUtils;
import edu.FPT.AI1501.Utils.Menu;
import edu.FPT.AI1501.View.InputUtils;
import edu.FPT.AI1501.View.PrintUtils;


public class CategoryList extends ArrayList<Category> {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public Integer searchId(String id) {
        return this.indexOf(new Category(id));
    }

    public Integer searchName(String name) {
        return this.indexOf(new Category(name));
    }

    public void add() {
        while (true) {
            String id = InputUtils.inputId(false);
            String name = InputUtils.inputName(false);

            Integer isIdExisted = searchId(id);
            Integer isNameExisted = searchName(id);

            if (isIdExisted != -1 || isNameExisted != -1) {
                System.out.println("Name or Id Existed!");
            } else {
                Category newCat = new Category(id, name);
                PrintUtils.printCategoryInfo(newCat);
                if (!EssentialUtils.chooseYN("Do you want to add this Category ?", "Added Successfully!",
                        "Operation Aborted!")) {
                    this.add(newCat);
                }

            }

            if (!EssentialUtils.chooseYN("Continue Adding More Category?", "", "Returning to menu")) {
                return;
            }

        }

    }

    public void updateDeleteMenu(){
        Integer searchIndex;
        if(this.isEmpty()){
            System.out.println("The List is empty!");
            return;
        }

        String updateId = InputUtils.inputId(false);
        if((searchIndex = searchId(updateId)) == -1){
            System.out.println("ID Does Not Exist! Exiting...");
            return;
        }

        Menu UDMenu = new Menu("Category Update And Delete Menu");

        UDMenu.addItems("Update");
        UDMenu.addItems("Delete");

        while(true){
            UDMenu.printMenu("Return to menu");
            Integer choice = UDMenu.getChoice();
            switch(choice){
                case 1:
                    update(searchIndex);
                    break;
                case 2:
                    if(delete(searchIndex)){
                        return;
                    }
                    break;
                default:
                    System.out.println("Exiting...");
            }
        }
        

    }

    private void update(int searchIndex) {
        String name = InputUtils.inputName(true);
        if(EssentialUtils.isEmptyString(name)){
            System.out.println("Update Aborted!");
        } else{
            this.get(searchIndex).setName(name);
            System.out.println("Update Completed!");
        }
    }

    private boolean delete(int searchIndex){   
        if(EssentialUtils.chooseYN("Do you really want to delete this Category?", "Category Deleted!", "Delete Aborted")){
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
}
