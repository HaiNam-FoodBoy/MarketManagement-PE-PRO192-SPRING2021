/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Storage;

import Util.MyToys;
import DTO.Item;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Ho Hai Nam
 */
public class ItemList {
    ArrayList<Item> list;
    
    public ItemList() {
        list=new ArrayList<>();
    }
    
    public int getSizeList() {
        if(list.size()<=0) System.err.println("THE LIST IS EMPTY");
        return list.size();
    }
    
    public boolean addItem (Item c) {
        return list.add(c);
    }
    
    public int findItem(int id) {
        for(int i=0; i<list.size(); i++ ) {
            if (list.get(i).getId() == id) return i;
        }
        return -1;
    }
    
    public Item searchItem(int id) {
        for(int i=0; i<list.size(); i++ ) {
            if (list.get(i).getId() == id) return list.get(i);
        }
        return null;
    }
    
    public int checkValidItem() {
        int id = MyToys.getInt("Input item ID: ", "WRONG FORMAT", "MIN IS 0", 0);
        if(searchItem(id) == null ) {
            System.err.println("THE ID IS INVALID");
            return -1;
        }
        return id;
    }
    
    public boolean updateItem() {
        int id = checkValidItem();
        
        if(id >= 0) {
            Item i = new Item();
            
            i = searchItem(id);
            
            String name = MyToys.getString("Input new name of item: ", "PLEASE INPUT NEW NAME OF ITEM");
            i.setName(name);          
            
            int quatity = MyToys.getInt("Input new item quantity: ", "WRONG FORMAT", "MIN VALUE IS 0", 0);
            i.setQuantity(quatity);
            
            int price = MyToys.getInt("Input new item price: ", "WRONG FORMAT", "MIN VALUE IS 0", 0);
            i.setQuantity(price);
            
            boolean status = MyToys.getBoolean("Input new item status: ", "PLEASE INPUT NEW STATUS OF ITEM", "WRONG FORMAT");
            i.setStatus(status);
            
            return true;
        }
        return false;
    }
    
    public boolean removeItem() {
        int id = checkValidItem();
        Item c=searchItem(id);
        if(c == null ) return false;
        return list.remove(c);
    }
    
    public void sortById() {
        Collections.sort(list);
    }
    
    public void displayAll() {  
        System.out.println("-------------------------------- ITEMS LIST -------------------------------\n\n");
        for(Item course : list) { 
            System.out.println("-------- ITEM "+(course.getId())+" INFORMATION ----------");
            course.outputItem();
            System.out.println("\n");
        }
    }
}
