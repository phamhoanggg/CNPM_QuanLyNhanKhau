/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlynhankhau.dao;

import com.mycompany.quanlynhankhau.Helpers.DatabaseHelper;
import com.mycompany.quanlynhankhau.Thongtin.HoKhau;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author HP
 */
public class HoKhauDao {
    public boolean IsExist(String CCCD, String id) throws Exception{
        String checkExist_sql = "SELECT * FROM hokhau" +
                            "  WHERE CCCD = ? OR idhokhau = ?";
        try(
            Connection conn = DatabaseHelper.ConnectDB();
            PreparedStatement checkPrepSt = conn.prepareStatement(checkExist_sql);    
            ){
            checkPrepSt.setString(1,CCCD);
            checkPrepSt.setString(2,id);

            ResultSet rs = checkPrepSt.executeQuery();
            return rs.next();
        }
    }
    
    public void InsertHK(HoKhau hk) throws Exception{
        String insert_sql = "INSERT INTO `hokhau` (`idhokhau`, `hotenchuho`, `quequan`, `CCCD`, `ngaysinh`, `ghichu`) "
                + "VALUES (?,?,?,?,?,?)";
        
        try(
            Connection conn = DatabaseHelper.ConnectDB();
            PreparedStatement insertPrepSt = conn.prepareStatement(insert_sql);
        ){
            insertPrepSt.setString(1, hk.getIdHK());
            insertPrepSt.setString(2, hk.getHoTen());
            
            
            insertPrepSt.setString(3, hk.getQueQuan());
  
            insertPrepSt.setString(4, hk.getCccd());
            insertPrepSt.setString(5, hk.getNgaySinh());
        
            insertPrepSt.setString(6, hk.getGhiChu());

            insertPrepSt.execute();
        }
    }
    
    public HoKhau SearchHK(String ID) throws Exception{
        String search_HK_sql = "SELECT * FROM `hokhau`"+
                            "  WHERE `hokhau`.`idhokhau` = ?";
        try(
            Connection conn = DatabaseHelper.ConnectDB();
            PreparedStatement searchPrepSt = conn.prepareStatement(search_HK_sql);
        ){
            searchPrepSt.setString(1, ID);

            ResultSet rs = searchPrepSt.executeQuery();
            if (rs.next()){
                HoKhau hk = new HoKhau();
                
                hk.setIdHK(rs.getString("idhokhau"));
                hk.setCccd(rs.getString("CCCD"));
                
                hk.setHoTen(rs.getString("hoten"));               
                              
                hk.setQueQuan(rs.getString("quequan"));
                hk.setNgaySinh(rs.getString("ngaysinh"));
                hk.setGhiChu(rs.getString("ghichu"));
                
                return hk;
            }else{
                return null;
            }
        }
    }
    
    public void DeleteHK(String ID) throws Exception{
        String delete_sql1 = "DELETE FROM `hokhau` WHERE `hokhau`.`idhokhau` = ?";  

        try(
            Connection conn = DatabaseHelper.ConnectDB();
            PreparedStatement deletePrepSt1 = conn.prepareStatement(delete_sql1);
           

        ){
            deletePrepSt1.setString(1, ID);
            
            
            deletePrepSt1.execute();
            
        }
    }
}
