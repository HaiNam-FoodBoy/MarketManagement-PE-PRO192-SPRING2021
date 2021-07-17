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
public class Invoice implements Comparable<Invoice>{
    private int id;
    private String date;
    Order order;

    public Invoice() {
        this.id = 0;
        this.date = null;
        this.order = null;
    }

    public Invoice(int id, String date, Order order) {
        this.id = id;
        this.date = date;
        this.order = order;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public Order getOrder() {
        return order;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setOrder(Order orders) {
        this.order = orders;
    }

    
    public int inputId() {
        return id = MyToys.getInt("Input invoice ID: ", "WRONG FORMAT", "MIN IS 0", 0);
    }
    
    public String inputDate() {
        return date = MyToys.getDay("Input invoice date: ");
    }
    
    public void outputInvoice() {
        if(order!= null){
            System.out.print("|| ID of Invoice: "+getId());
            System.out.println(" || Date of Invoice: "+getDate());
            System.out.println("------- ORDER's INFORMATION -------");
            order.outputOrder();
        }
    }

    @Override
    public int compareTo(Invoice o) {
        if(id > o.id) return 1;
        else if(id < o.id) return -1;
        return 0;
    }
}
