/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Storage;

import Util.MyToys;
import DTO.Invoice;
import DTO.Order;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Ho Hai Nam
 */
public class InvoiceList {
        ArrayList<Invoice> list;
    
    public InvoiceList() {
        list=new ArrayList<>();
    }
    
    public int getSizeList() {
        if(list.size()<=0) System.err.println("THE LIST IS EMPTY");
        return list.size();
    }
    
    public boolean addInvoice(Invoice t) {
        return list.add(t);
    }
    
    public int findInvoice(int id) {
        for(int i=0; i<list.size(); i++ ) {
            if (list.get(i).getId() == id) return i;
        }
        return -1;
    }
    
    public Invoice searchInvoice(int id) {
        for(int i=0; i<list.size(); i++ ) {
            if (list.get(i).getId() == id) return list.get(i);
        }
        return null;
    }
    
    public boolean searchOrderInvoice(Order o) {
        for(int i=0; i<list.size(); i++ ) {
            if (list.get(i).getOrder() == o) return true;
        }
        return false;
    }
    
    public int checkValidInvoice() {
        int id=MyToys.getInt("Input Invoice ID: ", "WRONG FORMAT", "MIN IS 0", 0);
        if(searchInvoice(id) == null ) {
            System.err.println("THE ID IS INVALID");
            return -1;
        }
        return id;
    }
    public boolean updateInvoice() {
        int id = checkValidInvoice();
        if(id>=0){
            Invoice iv=searchInvoice(id);
            
            System.out.println("Input new Date: ");
            String date = iv.inputDate();
            iv.setDate(date);
            
            return true;
        }
        
        return false;
    }
    
    public boolean removeInvoice() {
        int id=checkValidInvoice();
        Invoice ts=searchInvoice(id);
        if(ts == null ) return false;
        return list.remove(ts);
    }
    
    public void sortById() {
        Collections.sort(list);
    }

    public void outputInvoice (int ido) {    
        System.out.println("--------- ORDER "+ido+" INVOICE ---------");
            for(int i = 0; i< list.size(); i++) {
                if(list.get(i).getOrder().getId() == ido){                                    
                    list.get(i).outputInvoice();
                }
            }
    }
}
