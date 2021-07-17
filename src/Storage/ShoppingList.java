/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Storage;

import DTO.Invoice;
import DTO.Shopping;
import DTO.Order;
import Util.MyToys;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Ho Hai Nam
 */
public class ShoppingList {
    ArrayList<Shopping> list;

    public ShoppingList() {
        list = new ArrayList<>();
    }     
    
    public int getSizeList() {
        if(list.size()<=0) System.err.println("THE LIST IS EMPTY");
        return list.size();
    }
        
    public boolean addShoppingList(Shopping s) {
        return list.add(s);
    }
    
    public int findShoppingList(int id) {
        for(int i=0; i<list.size(); i++ ) {
            if (list.get(i).getId() == id) return i;
        }
        return -1;
    }
    
    public Shopping searchShoppingListID(int id) {
        for(int i=0; i<list.size(); i++ ) {
            if (list.get(i).getId() == id) return list.get(i);
        }
        return null;
    }
    
    public int checkValidShoppingList() {
        int id=MyToys.getInt("Input shopping ID: ", "WRONG FORMAT", "MIN IS 0", 0);
        if(searchShoppingListID(id)== null ) {
            System.err.println("THE ID IS INVALID");
            return -1;
        }
        return id;
    }
    
    public boolean removeShoppingList() {
        int id=checkValidShoppingList();
        Shopping sp = searchShoppingListID(id);
        if(sp == null ) return false;
        return list.remove(sp);
    }
    
    public void sortById() {
        Collections.sort(list);
    }
    
        
    public void outputShoppingList (int ido) {    
        
            for(int i = 0; i< list.size(); i++) {
                if(list.get(i).getOrder().getId() == ido){     
                    System.out.println("--------------------------------------------------------------------------");
                    list.get(i).getItem().outputItem();
                }               
            }
            System.out.println("\n");
    }
    
    public void displayAll() {  
        System.out.println("--------------------------------- SHOPPING LIST ---------------------------------\n\n");
        for(Shopping shopping: list) { 
            System.out.println("---------- SHOPPING "+(shopping.getId())+" INFORMATION -----------");
            shopping.ouputShopping();
            System.out.println("\n");
        }
    }
    
}
