/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlynhankhau.dao;

import com.mycompany.quanlynhankhau.Helpers.DatabaseHelper;
import com.mycompany.quanlynhankhau.Thongtin.HoKhau;
import com.mycompany.quanlynhankhau.Thongtin.NhanKhau;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author HP
 */
public class HoKhauDao {
    public boolean IsExist(String CCCD, String id) throws Exception{
        try(
            Connection conn = DatabaseHelper.ConnectDB();
            PreparedStatement checkPrepSt = conn.prepareStatement(DatabaseHelper.CHECKEXIST_HK_SQL);    
            ){
            checkPrepSt.setString(1,CCCD);
            checkPrepSt.setString(2,id);

            ResultSet rs = checkPrepSt.executeQuery();
            return rs.next();
        }
    }
    
    public void InsertHK(HoKhau hk) throws Exception{
        try(
            Connection conn = DatabaseHelper.ConnectDB();
            PreparedStatement insertPrepSt = conn.prepareStatement(DatabaseHelper.INSERT_HK_SQL);
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
        try(
            Connection conn = DatabaseHelper.ConnectDB();
            PreparedStatement searchPrepSt = conn.prepareStatement(DatabaseHelper.SEARCH_HK_SQL);
        ){
            searchPrepSt.setString(1, ID);

            ResultSet rs = searchPrepSt.executeQuery();
            if (rs.next()){
                HoKhau hk = new HoKhau();
                
                hk.setIdHK(rs.getString("idhokhau"));
                hk.setCccd(rs.getString("CCCD"));
                hk.setHoTen(rs.getString("hotenchuho"));                                          
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
        try(
            Connection conn = DatabaseHelper.ConnectDB();
            PreparedStatement deletePrepSt1 = conn.prepareStatement(DatabaseHelper.DELETE_HK_SQL);
        ){
            deletePrepSt1.setString(1, ID);
            deletePrepSt1.execute();       
        }
    }
}
