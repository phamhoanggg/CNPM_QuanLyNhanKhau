/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.quanlynhankhau;

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
        Connection  conn = null;
        Statement st = null;
        ResultSet rs = null;
        ResultSetMetaData metadata = null;
        
        String dbURL = "jdbc:mysql://localhost/quanlynhankhau";
        String userName = "root";
        String password = "";
        
        
        try {
            // Get connection
            conn = DriverManager.getConnection(dbURL, userName, password);
            if (conn != null){
                System.out.println("Connected!");
                st = conn.createStatement();
                rs = st.executeQuery("select * from users");
                
                metadata = rs.getMetaData();     
                
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        
    }
}
