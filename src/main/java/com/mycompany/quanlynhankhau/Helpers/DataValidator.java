/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlynhankhau.Helpers;

import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author minhd
 */
public class DataValidator {
    public static void validateEmpty(JTextField field, StringBuilder sb, String errorMessage){
        if (field.getText().equals("")){
            sb.append(errorMessage).append("\n");
            field.setBackground(Color.red);
            field.requestFocus();
        }else{
            field.setBackground(Color.white);
        }
    }
    
    public static void validateEmpty(JPasswordField field, StringBuilder sb, String errorMessage){
        String password = new String(field.getPassword());
        if (password.equals("")){
            sb.append(errorMessage).append("\n");
            field.setBackground(Color.red);
            field.requestFocus();
        }else{
            field.setBackground(Color.white);
        }
    }
    
    public static void DateValidator(String Day, String Month, String Year, StringBuilder sb, String errorMessage){
        int day = Integer.parseInt(Day);
        int month = Integer.parseInt(Month);
        int year = Integer.parseInt(Year);
        if (month <= 7){
            if (month % 2 == 1 && day == 31){
                sb.append(errorMessage).append("\n");
            }else if (month % 2 == 0){
                if (year % 4 == 0 && year % 100 != 0 && day > 29){
                    sb.append(errorMessage).append("\n");
                }else if (year % 400 == 0 && day > 29){
                    sb.append(errorMessage).append("\n");
                }else{
                    if (day > 28){
                        sb.append(errorMessage).append("\n");
                    }
                }
            }
        }else{
            if (month % 2 == 1 && day == 31){
                sb.append(errorMessage).append("\n");
            }
        }
    }
    
    public static String DatePerformer(String day, String month, String year){
        return year + "-" + month + " " + day;  
    }
}
