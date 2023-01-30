/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlynhankhau.dao;

import com.mycompany.quanlynhankhau.Helpers.DatabaseHelper;
import com.mycompany.quanlynhankhau.Thongtin.NguoiQuanLy;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author minhd
 */
public class NguoiQuanLyDao {
    public NguoiQuanLy checkLogin(String username, String password) throws SQLException{
        try(
            Connection conn = DatabaseHelper.ConnectDB();
            PreparedStatement prepSt = conn.prepareStatement(DatabaseHelper.CHECKLOGIN_SQL);
        ){
            prepSt.setString(1, username);
            prepSt.setString(2, password);


            try(ResultSet rs = prepSt.executeQuery();){
                if(rs.next()){
                    NguoiQuanLy nql = new NguoiQuanLy(username, password);
                    return nql;
                }    
            }
        }
        return null;
    }
    
    public void SetRememberPassword(boolean isRemember, String username) throws Exception{
        String sql = "UPDATE `users` SET `rememberPassword` = ? WHERE `users`.`username` = ?";
        
        try(
            Connection conn = DatabaseHelper.ConnectDB();
            PreparedStatement prepSt = conn.prepareStatement(sql);
        ){
            prepSt.setInt(1, isRemember ? 1 : 0);
            prepSt.setString(2, username);

            prepSt.execute();
        }
    }
    
    public String GetRememberPassword(String username) throws Exception{
        String sql = "SELECT * FROM `users` WHERE `username` = ?";
        try(
            Connection conn = DatabaseHelper.ConnectDB();
            PreparedStatement prepSt = conn.prepareStatement(sql);
        ){
            prepSt.setString(1, username);

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

