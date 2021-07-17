/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.util.InputMismatchException;
import java.util.Scanner;
import Util.MyToys;

/**
 *
 * @author Ho Hai Nam
 */
public class GetChoice {
        public static int getChoiceMenu() {
        int choice = MyToys.getChoice("Input choice: ", "WRONG FORMAT", 1, 7);
        return choice;
    }
    
    public static int getChoiceCustomer() {
        int choice1 = MyToys.getChoice("Input choice1: ", "WRONG FORMAT",1, 6);
        return choice1;
    }  
    
    public static int getChoiceOrder() {
        int choice2 = MyToys.getChoice("Input choice2: ", "WRONG FORMAT",1, 6);
        return choice2;
    }  
    
    public static int getChoiceItem() {
        int choice3 = MyToys.getChoice("Input choice3: ", "WRONG FORMAT",1, 6);
        return choice3;
    }
    
    public static int getChoiceRS() {
        int choice4 = MyToys.getChoice("Input choice4: ", "WRONG FORMAT",1, 4);
        return choice4;
    }
         
    public static int getChoiceShopping() {
        int choice5 = MyToys.getChoice("Input choice5: ", "WRONG FORMAT",1, 6);
        return choice5;
    }
    public static int getChoiceInvoice() {
        int choice6 = MyToys.getChoice("Input choice5: ", "WRONG FORMAT",1, 6);
        return choice6;
    }
}
