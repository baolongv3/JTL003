/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.FPT.AI1501.Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;






/**
 *
 * @author ACER
 */
public class EssentialUtils {
    private static final Pattern NAME_PATTERN = Pattern.compile("^[A-Z]&",Pattern.CASE_INSENSITIVE);

    private static Scanner sc = new Scanner(System.in);


    // Check null and empty String
    public static boolean isEmptyString(String string) {
        if(string == null){
            return true;
        }
        if(string.isEmpty()){
            return true;
        }
        
        return StringUtils.isBlank(string);

    }
    
    // Utility for checking returning yes or no with Question dialog
    public static boolean chooseYN(String questionDialog,String ifYes, String ifNo) {
        String userChoice = null;
        boolean choice = false;
        do {
            System.out.print(questionDialog + " (Y/N): ");
            userChoice = sc.nextLine().toUpperCase();
            if (userChoice.equals("N")) {
                System.out.println(ifNo);
                choice = false;
            } else if (userChoice.equals("Y")) {
                System.out.println(ifYes);
                choice = true;
            } else {
                System.out.println("Must be Y or N");
            }
        } while (!"N".equals(userChoice) && !"Y".equals(userChoice));

        return choice;
    }

    //Name Capitalizing
    public static String capitalizeName(String name){
        name = name.toLowerCase().trim();
        String[] nameArray = name.split("\\s");
        StringBuilder newName = new StringBuilder();
        for(String word : nameArray){
            newName.append(StringUtils.capitalize(word));
            newName.append(" ");
        }
        return newName.toString().trim();
    }
    
    public static boolean isNameValid(String name){
        Matcher matcher = NAME_PATTERN.matcher(name);
        return matcher.matches();
    }

    public static boolean isNumberNatural(Integer number){
        return (number > 0) ? true : false;
    }

    public static boolean isPriceValid(Double price){
        return (price > 0) ? true : false;
    }


    

    //Read JSON  from file then parse it

    
    public static boolean saveToFile(String fileName, String infoOut){
        Path path = Paths.get(fileName); 

        try{
            Files.writeString(path, infoOut, StandardOpenOption.CREATE,StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("Save Completed!");
            return true;
        }catch(IOException e){
            System.out.println("Save Failed!");
            return false;
        }
    }
    



}
