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
public class Item implements Comparable<Item>{
    private int id;
    private String name;
    private int quantity;
    private int price;
    private boolean status;

    public Item() {
        this.id = 0;
        this.name = null;
        this.quantity = 0;
        this.price = 0;
        this.status = false;
    }

    public Item(int id, String name, int quantity, int price,  boolean status) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public boolean getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
        
    
    public void inputItem() {
        id = MyToys.getInt("Input item ID: ", "WRONG FORMAT", "MIN IS 0", 0);
        name = MyToys.getString("Input item name: ", "PLEASE INPUT ITEM NAME");
        quantity = MyToys.getInt("Input item quantity: ", "WRONG FORMAT", "MIN IS 0", 0);
        price = MyToys.getInt("Input item price: ", "WRONG FORMAT", "MIN IS 0", 0);
        status = MyToys.getBoolean("Input item status(1: sold, 0: not sold): ", "PLEASE INPUT ITEM STATUS", "WRONG FORMAT");
   
    }
    
    public void outputItem() {
        System.out.print("|| Item ID: "+getId());
        System.out.print(" || Item name: "+getName());
        System.out.print(" || Item quantity: "+getQuantity());
        System.out.print(" || Item price: "+getPrice());
        if(getStatus() == true) System.out.println(" || Item status: SOLD");
        else if (getStatus() == false) System.out.println("|| Item status: NOT SOLD");

    }

    @Override
    public int compareTo(Item o) {
        if(id > o.getId()) return 1;
        else if(id < o.getId()) return -1;
        return 0;
    }
}
