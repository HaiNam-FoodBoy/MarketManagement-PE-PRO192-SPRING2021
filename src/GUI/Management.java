/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import UI.GetChoice;
import UI.Menu;
import DTO.Customer;
import DTO.Item;
import DTO.Invoice;
import DTO.Order;
import DTO.Shopping;
import Storage.OrderList;
import Storage.CustomerList;
import Storage.ItemList;
import Storage.InvoiceList;
import Storage.ShoppingList;
import java.util.Scanner;
import Util.MyToys;


/**
 *
 * @author Admin
 */

public  class Management {              

    public static void main(String[] args) {  
        CustomerList ds1=new CustomerList();
        OrderList ds2=new OrderList();
        ItemList ds3=new ItemList();
        ShoppingList ds4=new ShoppingList();
        InvoiceList ds5=new InvoiceList();
        Menu menu=null;
        GetChoice choices=null;
        int choice = 0;
        
        Scanner sc=new Scanner(System.in);
        do {         
            Menu.menu(); 
            choice = choices.getChoiceMenu();       
            
            switch(choice){
///////////////////////////////// CUSTOMER /////////////////////////////////////////              
                case 1:
                    int choice1=0;
                    do{
                        Menu.menuCustomer();
                        choice1 = choices.getChoiceCustomer();                       
                        
                        switch(choice1) {
                            case 1:
                                Customer c=new Customer();
                                int i = 0;
                                do {
                                    c.inputCustomer();
                                    i = ds1.findCustomer(c.getId());
                                    if(i>=0) System.err.println("ID " + (i+1) + " da ton tai!!");
                                }while(i>=0);
                                
                                if(ds1.addCustomer(c)) System.out.println("ADD SUCCESSED");
                                else  System.out.println("ADD FAILED");
                                break;
                                
                                
                            case 2:
                                if(ds1.getSizeList()<=0) break;                                    
                                else {
                                    if(ds1.updateCustomer()) System.out.println("UPDATE SUCCESSED");    
                                    else System.err.println("UPDATE FAILED");
                                }
                                break;
                                
                                
                            case 3:
                                if(ds1.getSizeList()<=0) break;   
                                int id = ds1.checkValidCustomer();
                                if(id >= 0){
                                    ds2.removeCustomerOrder(ds1.searchCustomer(id));
                                    if(ds1.removeCustomer(ds1.searchCustomer(id))) {    
                                        System.out.println("REMOVE SUCCESSED");    
                                    }
                                    
                                    else System.out.println("REMOVE FAILED");
                                }
                                
                                
                            case 4:
                                if(ds1.getSizeList()<=0) break;                                                              
                                ds1.sortById();
                                break;
                                
                                
                            case 5:
                                if(ds1.getSizeList()<=0) break;
                                
                                ds1.displayAll();
                                break;
                                
                            default:
                                break;
                        }
                    }while(choice1<=5);
                    break;
                    
                    
                    
///////////////////////////////// ORDER ///////////////////////////////////////                 
                case 2:
                    int choice2 = 0;
                    do {    
                        menu.menuOrder();
                        choice2 = choices.getChoiceOrder();
                        
                        switch(choice2) {
                            case 1: 
                                Order o=new Order();
                                int i = 0;
                                do {                                    
                                    o.inputOrder();
                                    i = ds2.findOrder(o.getId());
                                    if (i>=0) System.err.println("ID " + (i+1) + " da ton tai!!");
                                } while (i>=0);
                                
                                if (ds2.addOrder(o)) System.out.println("ADD SUCCESS");
                                else System.err.println("ADD FAILED");
                                break;
                                
                            case 2:
                                if(ds2.getSizeList()<=0) break;
                                else{
                                    if(ds2.updateOrder()) System.out.println("UPDATE SUCCESSED");
                                    else System.err.println("UPDATE FAILED");
                                }
                                break;
                                
                            case 3:
                                if(ds1.getSizeList()<=0) break;
                                else {
                                    if(ds2.removeOrder()) System.out.println("REMOVE SUCCESSED");
                                    else System.err.println("REMOVE FAILED");
                                }
                                break;
                                
                            case 4:
                                if(ds2.getSizeList()<=0) break;
                                
                                ds2.sortById();
                                break;
                                
                            case 5:
                                if(ds2.getSizeList()<=0) break;
                                
                                ds2.displayAll();
                                break;
                                
                            default:
                                break;
                        }
                        
                    } while (choice2<=5);
                    break;
                    
                    
                    
///////////////////////////////// Items /////////////////////////////////////                 
                case 3:
                    int choice3=0;
                    do{
                        menu.menuItem();
                        choice3 = choices.getChoiceItem();

                        switch(choice3) {
                            case 1: 
                                Item it=new Item();
                                int i=0;
                                do {
                                    it.inputItem();
                                    i = ds3.findItem(it.getId());
                                    if (i>=0) System.err.println("ID " + (i+1) + " da ton tai!!");
                                } while (i>=0);

                                if(ds3.addItem(it)) System.out.println("ADD SUCCESSED");
                                else System.err.println("ADD FAILED");
                                break;

                            case 2:
                                if(ds3.getSizeList()<=0) break;
                                else{
                                    if(ds3.updateItem()) System.out.println("UPDATE SUCCESSED");
                                    else System.err.println("UPDATE FAILED");
                                }
                                break;
                                
                            case 3:
                                if(ds3.getSizeList()<=0) break;
                                else{
                                    if(ds3.removeItem()) System.out.println("REMOVE SUCCESSED");
                                    else System.err.println("REMOVE FAILED");
                                }
                                break;
                                
                            case 4:
                                if(ds3.getSizeList()<=0) break;
                                ds3.sortById();
                                break;
                                
                            case 5:
                                if(ds3.getSizeList()<=0) break;
                                ds3.displayAll();
                                break;
                                
                            default:
                                    break;
                            
                        }
                    }while(choice3<=5);
                    
                    break;
                    
                    
                    
///////////////////////////////// RELATIONSHIPS ////////////////////////////////                  
                case 4:
                    int choice4 = 0;
                    if(ds1.getSizeList()==0 || ds2.getSizeList()==0 ) break;
                    else{
                        do{             

                            menu.menuRS();
                            choice4 = choices.getChoiceRS();

                            switch(choice4){
                                case 1:
                                    Order o = new Order();
                                    Customer c = new  Customer();
                                    int ido = ds2.checkValidOrder();
                                    
                                    if(ido >=0){
                                        o = ds2.searchOrder(ido);

                                        if (o.getCustomer() != null) {
                                            System.err.println("THE ORDER HAS CUSTOMER");
                                            break;
                                        }
                                        else {
                                            int idc = ds1.checkValidCustomer();
                                            c = ds1.searchCustomer(idc);

                                            if(c != null){
                                                o.setCustomer(c);
                                                System.out.println("ADD SUCCESSED");
                                            }
                                            else System.err.println("ADD FAILED");
                                        }
                                    }
                                    break;

                                case 2:
                                    
                                    ido=ds2.checkValidOrder();
                                    o = ds2.searchOrder(ido);

                                    if(o != null && o.getCustomer()!=null){
                                        int idc = ds1.checkValidCustomer();
                                        c = ds1.searchCustomer(idc);
                                        
                                        if(c!=null) {
                                            o.setCustomer(c);
                                            System.out.println("UPDATE SUCCESSED");
                                        }                   
                                    } else System.err.println("UPDATE FAILED!!");
                                break;
                                
                                case 3:
                                    ido = ds2.checkValidOrder();                                   
                                    o = ds2.searchOrder(ido);
                                    if(o!=null && o.getCustomer()!=null){
                                        o.setCustomer(null);
                                        System.out.println("REMOVE SUCESSED");
                                    }else System.err.println("REMOVE FAILED!!");
                                    break;

                                default: 
                                    break;
                           }
                        }while(choice4<4);
                    }
                    break;
                    
                    
///////////////////////////////// SHOPPING ////////////////////////////////                     
                case 5:
                    int choice5 = 0;
                    
                    if(ds2.getSizeList()==0 || ds3.getSizeList()==0 ) break;
                    else{
                        do{
                            menu.menuShopping();
                            choice5 = choices.getChoiceShopping();
                            sc=new Scanner(System.in);

                            switch(choice5){
                                case 1:
                                    Order o=new Order();
                                    Item it=new Item();
                                    Shopping sp=new Shopping();
                                    int id=0; 
                                    String date=null;
                                    int ido=0;
                                    int idit=0;
                                    
                                    do{                                                   
                                        id = sp.inputShoppingId();
                                        if(ds4.findShoppingList(id)>=0){
                                            System.err.println("ID "+(id)+" da ton tai!!");
                                        }
                                    }while(ds4.findShoppingList(id)>=0);                                                                       
                                    
                                    do {
                                        ido = ds2.checkValidOrder();
                                        o = ds2.searchOrder(ido);
                                    }while(o == null);
                                    
                                    do {
                                        idit = ds3.checkValidItem();
                                        it = ds3.searchItem(idit);   
                                    }while(it==null);
                                    
                                    if(it.getStatus()==true) {
                                        System.out.println("ITEM WAS SOLVED");
                                        break;
                                    }
                                    
                                    sp = new Shopping(id, o, it);
                                    if(ds4.addShoppingList(sp)) {
                                        System.out.println("ADD SUCCESSED");
                                        it.setStatus(true);
                                    }
                                    else System.out.println("ADD FALSE");
                                    break;

                                case 2:          
                                    if(ds4.getSizeList()<=0) break;
                                    
                                    id=ds4.checkValidShoppingList();                                   
                                    if(id>=0) {
                                        sp = ds4.searchShoppingListID(id);
                                        do{
                                            System.out.println("New Order");
                                            ido = ds2.checkValidOrder();
                                            if(ido >= 0) sp.setOrder(ds2.searchOrder(ido));
                                        }while(ido<0);
                                         
                                        do{
                                            System.out.println("New Item");
                                            idit=ds3.checkValidItem();
                                            if(idit >= 0) sp.setItem(ds3.searchItem(idit));
                                        }while(idit < 0);
                                        
                                        System.out.println("UPDATE SUCCESSES");
                                    }
          
                                    break;  
                                    
                                case 3:
                                    if(ds4.getSizeList()<=0) break;
                                    
                                    if(ds4.removeShoppingList()) System.out.println("REMOVE SUCCESSED");
                                    else System.out.println("REMOVE FAILED");
                                    break;
                                    
                                case 4:
                                    if(ds4.getSizeList()<=0) break;
                                    
                                    ds4.sortById();
                                    break;
                                    
                                case 5:
                                    if(ds4.getSizeList()<=0) break;
                                    ds4.displayAll();
                                break;
                                
                                default:
                                    break;
                            }
                        }while(choice5 < 6 );
                    }
                    break;
                    
                    
///////////////////////////////// INVOICE ////////////////////////////////                     
                case 6:
                    int choice6 = 0;
                    
                    if(ds2.getSizeList()==0 || ds3.getSizeList()==0 ) break;
                    else{
                        do{
                            menu.menuInvoice();
                            choice5 = choices.getChoiceInvoice();
                            sc=new Scanner(System.in);

                            switch(choice5){
                                case 1:
                                    Order o=new Order();
                                    Invoice iv=new Invoice();
                                    String date=null;
                                    int id=0;                              
                                    int ido=0;
                                    
                                    do{                                                   
                                        id = iv.inputId();
                                        if(ds5.findInvoice(id)>=0){
                                            System.err.println("ID "+(id)+" da ton tai!!");
                                        }                  
                                        
                                    }while(ds5.findInvoice(id)>=0);                                                                       
                                    
                                    date = iv.inputDate();
                                    
                                    do {
                                        ido= ds2.checkValidOrder();
                                        o = ds2.searchOrder(ido);            
                                    }while(o==null);
                                    
                                    if(ds5.searchOrderInvoice(o)) {
                                        System.err.println("THE ORDER HAS INVOICE");
                                        break;
                                    }
                                    
                                    iv=new Invoice(id, date, o);
                                    if(ds5.addInvoice(iv)) System.out.println("ADD SUCCESSED");
                                    else System.out.println("ADD FALSE");
                                    break;
                                    
                                case 2:
                                    if(ds5.getSizeList()<=0) break;
                                    
                                    if(ds5.updateInvoice()) System.out.println("UPDATE SUCCESSED");
                                    else System.err.println("UPDATE FAILED");
                                    break;
                                    
                                case 3:
                                    if(ds5.getSizeList()<=0) break;
                                    
                                    if(ds5.removeInvoice()) System.out.println("REMOVE SUCCESSED");
                                    else System.out.println("REMOVE FAILED");
                                    break;
                                    
                                case 4:
                                    if(ds4.getSizeList()<=0) break;
                                    
                                    ds4.sortById();
                                    break;
                                    
                                case 5:
                                    if(ds4.getSizeList()<=0) break;
                                    
                                    ido = ds2.checkValidOrder();
                                    if(ido >=0){
                                        o = ds2.searchOrder(ido); 
                                        if(ds5.searchOrderInvoice(o)){
                                                ds5.outputInvoice(ido);
                                                ds4.outputShoppingList(o.getId());       
                                        } else System.err.println("PRINT FAILED");
                                    }
                                break;
                                
                                default:
                                    break;
                            }
                        
                        }while(choice5 < 6 );                   
                    }
                    break;
                    
            }
        }while(choice <=7 );
    }
}
