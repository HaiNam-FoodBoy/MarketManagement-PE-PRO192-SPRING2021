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
public class Shopping implements Comparable<Shopping>{
    int id;
    Order order;
    Item item;

    public Shopping() {
        this.id = 0;
        this.order = null;
        this.item = null;
    }

    public Shopping(int id, Order order, Item item) {
        this.id = id;
        this.order = order;
        this.item = item;
    }

    public int getId() {
        return id;
    }

    public Order getOrder() {
        return order;
    }

    public Item getItem() {
        return item;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setItem(Item item) {
        this.item = item;
    }
    
    public int inputShoppingId() {
        return  id = MyToys.getInt("Input ID: ", "WRONG FORMAT", "MIN IS 0", 0);
    }
    
    public void ouputShopping() {
        order.outputOrder();
        System.out.println("---------- ITEMS OF ORDER ---------");
        item.outputItem();
    }

    @Override
    public int compareTo(Shopping o) {
        if(id > o.id) return 1;
        else if(id < o.id) return -1;
        return 0;
    }
}
