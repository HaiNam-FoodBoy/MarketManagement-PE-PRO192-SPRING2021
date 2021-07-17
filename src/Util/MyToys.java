/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class MyToys {
    private static Scanner sc=new Scanner(System.in);
    
    public static String getString(String inputMsg, String errMsg) {
        String s;
        while (true) {
            try {
                sc=new Scanner(System.in);
                System.out.print(inputMsg);
                s = sc.nextLine();
                if(s.isEmpty() || s.isBlank()) throw new Exception();
                else return s;
            } catch (Exception e) {
                System.err.println(errMsg);
            }
        }
    }
    
    public static String getCode(String inputMsg, String errMsg) {
        String s;
        String regex = "^(FU)(HCM|CT|DN|HN)$";
        while (true) {
            try {
                sc=new Scanner(System.in);
                System.out.print(inputMsg);
                s = sc.nextLine();
                if(s.isEmpty() || s.isBlank() ) throw new Exception();
                else return s;
            } catch (Exception e) {
                System.err.println(errMsg);
            }
        }
    }
    
    public static boolean getBoolean(String inputMsg, String errMsg1, String errMsg2) {
        String s;
        String regexTrue = "(1|T|t|True|true|Da ban|Sold)";
        String regexFalse = "(0|F|f|False|false|Chua ban|Not sold)";
        while (true) {
            try {
                sc=new Scanner(System.in);
                System.out.print(inputMsg);
                s = sc.nextLine();
                if(s.isEmpty() || s.isBlank()) throw new Exception(errMsg1);
                else if ( !s.matches(regexTrue) && !s.matches(regexFalse) )throw new Exception(errMsg2);               
                else if (s.matches(regexTrue)) return true;
                else if (s.matches(regexFalse)) return false;                  
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
    
    
    public static int getInt(String inputMsg, String InputMismatchException, String errMsg, int min) {
        int n;
        while (true) {
            try {
                sc=new Scanner(System.in);
                System.out.print(inputMsg);
                n = sc.nextInt();
                if(n<min) throw new Exception();
                else return n;
            } catch (InputMismatchException e) {
                System.err.println(InputMismatchException);
            } catch(Exception e2) {
                System.err.println(errMsg);
            }
        }
    }
    
    public static int getChoice(String inputMsg, String InputMismatchException, int min, int max) {
        int choice;
        while (true) {
            try {
                sc=new Scanner(System.in);
                System.out.print(inputMsg);
                choice = sc.nextInt();
                if(choice<min || choice>max) throw new Exception();
                else return choice;
            } catch (InputMismatchException e){
                System.err.println(InputMismatchException);
            } catch (Exception e2) {
                System.err.println("PLEASE INPUT ["+min+"-"+max+"]");
            }
        }
    }
    
    public static String getGender() {
        String gender;
        String regex="^male|female|Male|Female|MALE|FEMALE$";
        while (true) {
            try {
                sc=new Scanner(System.in);
                System.out.print("Male/Female: ");
                gender = sc.nextLine();
                if(!gender.matches(regex) || gender.isEmpty() || gender.isBlank()) throw new Exception();
                else return gender;
            } catch (Exception e) {
                System.err.println("PLEASE INPUT Male OR Female");
            }
        }
    }
    
    public static String getDay(String msg){
        String bday;
        String regex=("^(((0[1-9]|[12]\\d|3[01])\\/(0[13578]|1[02])\\/((19|[2-9]\\d)\\d{2}))|((0[1-9]|[12]\\d|30)\\/(0[13456789]|1[012])\\/((19|[2-9]\\d)\\d{2}))|((0[1-9]|1\\d|2[0-8])\\/02\\/((19|[2-9]\\d)\\d{2}))|(29\\/02\\/((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))))$");
        while (true) {
            try {
                sc=new Scanner(System.in);
                System.out.print(msg);
                bday = sc.nextLine();
                if(!bday.matches(regex) || bday.isEmpty() || bday.isBlank()) throw new Exception("PLEASE INPUT dd/mm/yyyy or dd-mm-yyyy");
                else return bday;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            } 
        }
    }
    
    
}
