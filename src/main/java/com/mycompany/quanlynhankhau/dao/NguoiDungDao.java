/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlynhankhau.dao;

import com.mycompany.quanlynhankhau.Helpers.DatabaseHelper;
import com.mycompany.quanlynhankhau.Thongtin.NguoiDung;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author minhd
 */
public class NguoiDungDao {
    public NguoiDung checkLogin(String username, String password, String roll) throws SQLException{
        try(
            Connection conn = DatabaseHelper.ConnectDB();
            PreparedStatement prepSt = conn.prepareStatement(roll.equals("admin") ? DatabaseHelper.CHECK_LOGIN_ADMIN_SQL : DatabaseHelper.CHECK_LOGIN_USER_SQL);
        ){
            prepSt.setString(1, username);
            prepSt.setString(2, password);

            try(ResultSet rs = prepSt.executeQuery();){
                if(rs.next()){
                    NguoiDung user = new NguoiDung(username, password);
                    return user;
                }    
            }
        }
        return null;
    }
    
    public void SetRememberPassword(boolean isRemember, String username) throws Exception{
        String sql1 = "UPDATE `users` SET `rememberPassword` = ? WHERE `username` = ?";
        String sql2 = "UPDATE `admin` SET `rememberPassword` = ? WHERE `name` = ?";

        
        try(
            Connection conn = DatabaseHelper.ConnectDB();
            PreparedStatement prepSt1 = conn.prepareStatement(sql1);
            PreparedStatement prepSt2 = conn.prepareStatement(sql2);
            
        ){
            prepSt1.setInt(1, isRemember ? 1 : 0);
            prepSt1.setString(2, username);
            prepSt2.setInt(1, isRemember ? 1 : 0);
            prepSt2.setString(2, username);

            prepSt1.execute();
            prepSt2.execute();

        }
    }
    
    public String GetRememberPassword(String username) throws Exception{
        String sql = "SELECT * FROM `users`, `admin` WHERE `users`.`username` = ? or `admin`.`name` = ?";
        try(
            Connection conn = DatabaseHelper.ConnectDB();
            PreparedStatement prepSt = conn.prepareStatement(sql);
        ){
            prepSt.setString(1, username);
            prepSt.setString(2, username);


            try(ResultSet rs = prepSt.executeQuery();){
                if(rs.next()){
                    int isRemember = rs.getInt(3);
                    if (isRemember == 1){
                        String password = rs.getString(2);
                        return password;
                    }  
                }    
            }
        }
        return null;
    }
}

