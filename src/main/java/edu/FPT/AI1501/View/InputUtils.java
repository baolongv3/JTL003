package edu.FPT.AI1501.View;

import java.util.InputMismatchException;
import java.util.Scanner;

import edu.FPT.AI1501.Utils.EssentialUtils;


public class InputUtils{
    private static Scanner sc = new Scanner(System.in);
    public static String inputId(boolean IsReturnEmptyAllowed){
        while(true){
            System.out.print("Input ID: ");
            String id = sc.nextLine();
            boolean isEmpty = EssentialUtils.isEmptyString(id);
            if(IsReturnEmptyAllowed && isEmpty){
                return null;
            } else{
                return id;
            }
        }
        
    }

    public static String inputName(boolean isReturnEmptyAllowed){
        while(true){
            System.out.print("Input name: ");
            String name = sc.nextLine();
            boolean isEmpty = EssentialUtils.isEmptyString(name);
            if(isReturnEmptyAllowed && isEmpty){
                return null;
            } else{
                return EssentialUtils.capitalizeName(name);
            }
        }
    }

    public static Integer inputQuantity(boolean isReturnEmptyAllowed){
        while(true){
            Integer number;
            try{
                System.out.println("Input Quantity(Abort enter 0): ");
                number = sc.nextInt();
                if(isReturnEmptyAllowed && number == 0){
                    return 0;
                }
                boolean isNatural = EssentialUtils.isNumberNatural(number);
                
                if(!isNatural){
                    System.out.println("Number must be natural");
                } else{
                    return number;
                }
            }catch(InputMismatchException e){
                System.out.println("Input does not fit! ");
            }
        }
    }

    public static Double inputPrice(boolean isReturnEmptyAllowed){
        while(true){
            try{
                System.out.println("Input Price(Abort enter 0): ");
                Double price = sc.nextDouble();
                if(isReturnEmptyAllowed && price == 0.0){
                    return 0.0;
                }
                boolean isPriceValid = EssentialUtils.isPriceValid(price);
                if(isPriceValid){
                    return price;
                } else{
                    System.out.println("Price Does Not Valid!");
                }
                
                
            }catch(InputMismatchException e){
                System.out.println("Input does not fit! ");
            }
        }
    }



}
