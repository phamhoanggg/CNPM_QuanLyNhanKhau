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
    
    public void SignUp(String CCCD, String username, String password) throws Exception{
        String sql = "UPDATE `nhankhau` SET `username` = ?, `password` = ? WHERE `CCCD` = ?";
        
        try(
            Connection conn = DatabaseHelper.ConnectDB();
            PreparedStatement prepSt = conn.prepareStatement(sql);
        ){
            prepSt.setString(1, username);
            prepSt.setString(2, password);
            prepSt.setString(3, CCCD);

            prepSt.execute();
        }
    }
    
    public void SetRememberPassword(boolean isRemember, String username) throws Exception{
        String sql1 = "UPDATE `nhankhau` SET `rememberPassword` = ? WHERE `username` = ?";
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
        String sql1 = "SELECT * FROM `admin` WHERE `name` = ?";
        String sql2 = "SELECT * FROM `nhankhau` WHERE `username` = ?";

        try(
            Connection conn = DatabaseHelper.ConnectDB();
            PreparedStatement prepSt1 = conn.prepareStatement(sql1);
            PreparedStatement prepSt2 = conn.prepareStatement(sql2);

        ){
            prepSt1.setString(1, username);
            prepSt2.setString(1, username);


            try(
                ResultSet rs1 = prepSt1.executeQuery();
                ResultSet rs2 = prepSt2.executeQuery();
            ){
                if(rs1.next()){
                    int isRemember = rs1.getInt("rememberPassword");
                    if (isRemember == 1){
                        String password = rs1.getString("password");
                        return password;
                    }  
                }else if (rs2.next()){
                    int isRemember = rs2.getInt("rememberPassword");
                    if (isRemember == 1){
                        String password = rs2.getString("password");
                        return password;
                    }
                }    
            }
        }
        return null;
    }
}

