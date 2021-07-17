/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import Util.MyToys;

/**
 *
 * @author Ho Hai Nam
 */
public class Order implements Comparable<Order>{
    private int id;
    private String orderDate;
    private String shipDate;
    private int TotalOfQuantity;
    private Customer customer;

    public Order() {
        this.id = 0;
        this.orderDate = null;
        this.shipDate = null;
        this.TotalOfQuantity = 0;
        this.customer = null;
    }

    public Order(int id, String orderDate, String shipDate, int TotalOfQuantity, Customer customer) {
        this.id = id;
        this.orderDate = orderDate;
        this.shipDate = shipDate;
        this.TotalOfQuantity = TotalOfQuantity;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getShipDate() {
        return shipDate;
    }

    public int getTotalOfQuantity() {
        return TotalOfQuantity;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public void setShipDate(String shipDate) {
        this.shipDate = shipDate;
    }

    public void setTotalOfQuantity(int TotalOfQuantity) {
        this.TotalOfQuantity = TotalOfQuantity;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void inputOrder() {
        id = MyToys.getInt("Input order ID: ", "WRONG FORMAT", "MIN IS 0", 0);
        orderDate = MyToys.getDay("Input order date: ");
        shipDate = MyToys.getDay("Input ship date: ");
    }
    
    public void outputOrder() {
        System.out.print("|| Order ID: "+getId());
        System.out.print(" || Order date: "+getOrderDate());
        System.out.print(" || Order ship date: "+getShipDate());
        System.out.println(" || Total of Quantity: "+getTotalOfQuantity());
        if(customer!=null) {
            System.out.println("-------- CUSTOMER OF ORDER --------");
            customer.outputCustomer();
        }

    }

    @Override
    public int compareTo(Order o) {
        if(id > o.id) return 1;
        else if (id < o.getId()) return -1;
        return 0;
    }
    
    
}
