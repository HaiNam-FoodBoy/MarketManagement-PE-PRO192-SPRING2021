/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Storage;

import Util.MyToys;
import DTO.Customer;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Ho Hai Nam
 */
public class CustomerList {
    ArrayList<Customer> list;
    
    public CustomerList(){
        list=new ArrayList<>();
    }
    
    public int getSizeList() {
        if(list.size()<=0) System.err.println("THE LIST IS EMPTY");
        return list.size();
    }
    
    public boolean addCustomer(Customer c) {
        return list.add(c);
    }
    
    public int findCustomer(int id) {
        for(int i=0; i<list.size(); i++ ) {
            if (list.get(i).getId() == id) return i;
        }
        return -1;
    }
    
    public Customer searchCustomer(int id) {
        for(int i=0; i<list.size(); i++ ) {
            if (list.get(i).getId() == id) return list.get(i);
        }
        return null;
    }
    
    public int checkValidCustomer() {
        int id = MyToys.getInt("Input customer ID: ", "WRONG FORMAT", "MIN IS 0", 0);
        if(searchCustomer(id) == null ) {
            System.err.println("THE ID IS INVALID");
            return -1;
        }
        return id;
    }
    
    public boolean updateCustomer() {
        int id = checkValidCustomer();
        
        if(id >= 0) {
            Customer c=new Customer();
            c = searchCustomer(id);
            
            String name = MyToys.getString("Input new name of customer: ", "PLEASE INPUT NEW NAME OF CUSTOMER");
            c.setName(name);
            
            String address = MyToys.getString("Input new address of customer: ", "PLEASE INPUT NEW ADDRESS OF CUSTOMER");
            c.setAddress(address);
                      
            return true;
        }
        return false;
    }
    
    public boolean removeCustomer(Customer c) {
        return list.remove(c);
    }
    
    public void sortById() {
        Collections.sort(list);
    }
    
    public void displayAll() {  
        System.out.println("-------------------------------- CUSTOMER LIST -------------------------------\n\n");
        for(Customer customer : list) { 
            System.out.println("-------- CUSTOMER "+(customer.getId())+" INFORMATION ---------");
            customer.outputCustomer();
            System.out.println("\n");
        }
    }
}
