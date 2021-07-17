/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

/**
 *
 * @author Admin
 */
public class Menu {
        public static void menu() {
        System.out.println("----------------------------------- MAIN MENU -----------------------------------");
        System.out.println("1. Quan ly danh sach Customer");
        System.out.println("2. Quan ly danh sach Order");
        System.out.println("3. Quan ly danh sach Item");
        System.out.println("4. Thiet lap Order cho Customer");
        System.out.println("5. Shopping");
        System.out.println("6. Invoice");
        System.out.println("7. Exit");
    }   
    
    public static void menuCustomer() {
        System.out.println("------------------------------------ CUSTOMER MENU -----------------------------------");
        System.out.println("1. Add Customer");
        System.out.println("2. Update Customer");
        System.out.println("3. Remove Customer");
        System.out.println("4. Sort Customer by ID");
        System.out.println("5. Display all Customer");
        System.out.println("6. Exit");
    }   
    
    public static void menuOrder() {
        System.out.println("---------------------------------- ORDER MENU -----------------------------------");
        System.out.println("1. Add Order");
        System.out.println("2. Update Order");
        System.out.println("3. Remove Order");
        System.out.println("4. Sort Order by ID");
        System.out.println("5. Display all Order");
        System.out.println("6. Exit");
    }   
    
    public static void menuItem() {
        System.out.println("--------------------------------- ITEM MENU ----------------------------------");
        System.out.println("1. Add Item");
        System.out.println("2. Upadte Item");
        System.out.println("3. Remove Item");
        System.out.println("4. Sort Item");
        System.out.println("5. Display all Item");
        System.out.println("6. Exit");
    }   
        
    public static void menuRS() {
        System.out.println("------------------------------- RELATIONSHIP MENU--------------------------------");
        System.out.println("1. Add Relationship");
        System.out.println("2. Update Relationship");
        System.out.println("3. Remove Relationship");
        System.out.println("4. Exit");
    }  
    
    public static void menuShopping() {
        System.out.println("----------------------------------- SHOPPING MENU ------------------------------------");
        System.out.println("1. Let's go Shopping");
        System.out.println("2. Upadte Shopping");
        System.out.println("3. Remove Shopping");
        System.out.println("4. Sort Shopping");
        System.out.println("5. Display all Shopping");
        System.out.println("6. Exit");
    }  
    
    public static void menuInvoice() {
        System.out.println("----------------------------------- INVOICE MENU ------------------------------------");
        System.out.println("1. Add Invoice");
        System.out.println("2. Upadte Invoice");
        System.out.println("3. Remove Invoice");
        System.out.println("4. Sort Invoice");
        System.out.println("5. Print order's invoice");
        System.out.println("6. Exit");
    }  
}
