/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validation;

import java.util.Scanner;

/**
 *
 * @author 84898
 */
public class Validation {
    public String getString (String string)
   {
       Scanner sc = new Scanner(System.in);
       
       System.out.println("Enter " + string  + ": ");
       
       while (true)
       {
            String result = sc. nextLine();
           
           if (result.isEmpty())
           {
               System.out.println(string + " can't empty!!!");
               System.out.println("Enter " + string + " again: ");
           }else 
               return result;
       }
   }
    
    public double getDouble (String string)
   {
       while (true)
       {
           try 
           {
                double number  = Double.parseDouble(getString(string));
                if (number > 0)
                    return number;
                else
                    System.out.println(string +  "can't below zero");
           }catch (NumberFormatException e)
           {
               System.out.println("Number invalid!!!");
           }
       }
   }
    
    public int getAnyInteger (String string)
   {
       while (true)
       {
           try 
           {
                int number  = Integer.parseInt(getString(string)); 
                return number;
                
           }catch (NumberFormatException e)
           {
               System.out.println("Number invalid!!!");
           }
       }
   } 
}
