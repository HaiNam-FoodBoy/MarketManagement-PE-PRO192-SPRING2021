/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Storage;

import Util.MyToys;
import DTO.Order;
import DTO.Customer;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Ho Hai Nam
 */
public class OrderList {
     ArrayList<Order> list;
    
    public OrderList() {
        list=new ArrayList<>();
    }
    
    public int getSizeList() {
        if(list.size()<=0) System.err.println("THE LIST IS EMPTY");
        return list.size();
    }
    
    public boolean addOrder(Order s) {
        return list.add(s);
    }
    
    public int findOrder(int id) {
        for(int i=0; i<list.size(); i++ ) {
            if (list.get(i).getId() == id) return i;
        }
        return -1;
    }
    
    public Order searchOrder(int id) {
        for(int i=0; i<list.size(); i++ ) {
            if (list.get(i).getId() == id) return list.get(i);
        }
        return null;
    }
    
    public int checkValidOrder() {
        int id=MyToys.getInt("Input order ID: ", "WRONG FORMAT", "MIN IS 0", 0);
        if(searchOrder (id) == null ) {
            System.err.println("THE ID IS INVALID");
            return -1;
        }
        return id;
    }
    
    public boolean updateOrder() {
        int id=checkValidOrder();
        Order o=new Order();
        if(id>=0) {
            o = searchOrder(id);
            
            String orderDate = MyToys.getDay("Input order day: ");
            o.setOrderDate(orderDate);
            
            String shipDate = MyToys.getDay("Input ship date: ");
            o.setShipDate(shipDate);
            
            return true;
        }
        return false;
    }
    
    public boolean removeOrder() {
        int id=checkValidOrder();
        Order o=searchOrder(id);
        if(o == null ) return false;
        return list.remove(o);
    }
    
    public void removeCustomerOrder(Customer c) {
        for (int i=0; i<list.size(); i++){
            if( list.get(i).getCustomer()== c) list.get(i).setCustomer(null);
        }
    }
    
    public void sortById() {
        Collections.sort(list);
    }
    
    public void displayAll() {  
        System.out.println("-------------------------------- ORDERS LIST ------------------------------\n\n");
        for(Order order : list) { 
            System.out.println("-------- ORDER "+(order.getId())+" INFORMATION ---------");
            order.outputOrder();
            System.out.println("\n");
        }
    }
}
