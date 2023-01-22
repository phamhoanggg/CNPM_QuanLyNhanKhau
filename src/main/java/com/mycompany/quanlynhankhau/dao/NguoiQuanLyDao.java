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

        String sql = "select username, password from users "+
                "  where username = ? and password = ?";
        try(
            Connection conn = DatabaseHelper.ConnectDB();
            PreparedStatement prepSt = conn.prepareStatement(sql);
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
}

