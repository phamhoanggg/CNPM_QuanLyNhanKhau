/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.quanlynhankhau;

import com.mycompany.quanlynhankhau.ui.HomepageForm;
import com.mycompany.quanlynhankhau.ui.LoginForm;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author minhd
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {    
        LoginForm login = new LoginForm();
        login.setVisible(true);


    }
}
