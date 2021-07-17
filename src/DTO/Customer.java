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
public class Customer implements Comparable<Customer>{
    private int id;
    private String name;
    private String address;

    public Customer() {
    }

    public Customer(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public void inputCustomer() {
        id = MyToys.getInt("Input customer ID: ", "WRONG FORMAT", "MIN IS 0", 0);
        name = MyToys.getString("Input customer name: ", "PLEASE INPUT CUSTOMER NAME");
        address = MyToys.getString("Input customer address: ", "PLEASE INPUT CUSTOMER ADDRESS");
    }
    
    public void outputCustomer() {
        System.out.print("|| Customer ID: "+getId());
        System.out.print(" || Customer name: "+getName());
        System.out.println(" || Customer address: "+getAddress());
    }

    @Override
    public int compareTo(Customer o) {
        if(id > o.id) return 1;
        else if(id < o.id) return -1;
        return 0;
    }
    
}
