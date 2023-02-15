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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author HP
 */
public class HoKhauDao {
    public boolean IsExist(String id) throws Exception{
        String checkExist_sql = "SELECT * FROM hokhau" +
                            "  WHERE idhokhau = ?";
        try(
            Connection conn = DatabaseHelper.ConnectDB();
            PreparedStatement checkPrepSt = conn.prepareStatement(checkExist_sql);    
            ){
            checkPrepSt.setString(1,id);

            ResultSet rs = checkPrepSt.executeQuery();
            return rs.next();
        }
    }
    
    public void InsertHK(HoKhau hk) throws Exception{
        String insert_sql = "INSERT INTO `hokhau` (`idhokhau`, `hotenchuho`, `CCCD`, `ghichu`) "
                + "VALUES (?,?,?,?)";
        
        try(
            Connection conn = DatabaseHelper.ConnectDB();
            PreparedStatement insertPrepSt = conn.prepareStatement(insert_sql);
        ){
            insertPrepSt.setString(1, hk.getIdHK());
            insertPrepSt.setString(2, hk.getHoTen());
            insertPrepSt.setString(3, hk.getCccd());
            insertPrepSt.setString(4, hk.getGhiChu());

            insertPrepSt.execute();
        }
    }
    
    public HoKhau SearchHK(String info) throws Exception{
        String search_HK_sql = "SELECT * FROM `hokhau`"+
                            "  WHERE `hokhau`.`idhokhau` = ? OR `hokhau`.`cccd` = ?";
        try(
            Connection conn = DatabaseHelper.ConnectDB();
            PreparedStatement searchPrepSt = conn.prepareStatement(search_HK_sql);
        ){
            searchPrepSt.setString(1, info);
            searchPrepSt.setString(2, info);


            ResultSet rs = searchPrepSt.executeQuery();
            if (rs.next()){
                HoKhau hk = new HoKhau();
                
                hk.setIdHK(rs.getString("idhokhau"));
                hk.setCccd(rs.getString("cccd")); 
                hk.setHoTen(rs.getString("hotenchuho"));               
                hk.setGhiChu(rs.getString("ghichu"));
                
                return hk;
            }else{
                return null;
            }
        }
    }
    
    public List<NhanKhau> GetNKInHK(String idhokhau) throws Exception{
        String sql = "SELECT * FROM `nhankhau` WHERE `idhokhau` = ?";
        List<NhanKhau> nkList = new ArrayList<>();
        try(
            Connection conn = DatabaseHelper.ConnectDB();
            PreparedStatement prepSt = conn.prepareStatement(sql);
        ){
            prepSt.setString(1, idhokhau);

            ResultSet rs = prepSt.executeQuery();
            while(rs.next()){
                NhanKhau nk = new NhanKhau(rs.getString("idnhankhau"), rs.getString("idhokhau"),
                                        rs.getString("CCCD"), rs.getString("hoten"), rs.getString("ngaysinh"),
                                        rs.getString("gioitinh"), rs.getString("quanhevoichuho"), rs.getString("quequan"),
                                        rs.getString("dantoc"), rs.getString("nghenghiep"), rs.getString("ngaydangkythuongtru"),
                                        rs.getString("noidangkythuongtruchuyenden"), rs.getString("ghichu"));
                
                nkList.add(nk);
            }
            return nkList;
        }
    }
    
    public List<HoKhau> GetAllHK() throws Exception{
        String sql = "SELECT * FROM `hokhau`";
        
        List<HoKhau> hkList = new ArrayList<>();
        try(
            Connection conn = DatabaseHelper.ConnectDB();
            Statement st = conn.createStatement();
        ){
            ResultSet rs = st.executeQuery(sql);
            HoKhau hk;
            while(rs.next()){
                hk = new HoKhau(rs.getString("idhokhau"), rs.getString("hotenchuho"), rs.getString("cccd"), rs.getString("ghichu"));
                
                hkList.add(hk);
            }
            if (!hkList.isEmpty()){
                Collections.sort(hkList, (d1, d2) -> {
                    return Integer.parseInt(d1.getIdHK()) - Integer.parseInt(d2.getIdHK());
                });
            }
            return hkList;
        }
    }
    
    public void UpdateHK(HoKhau hk) throws Exception{
        String insert_sql = "UPDATE `hokhau` SET `hotenchuho` = ?, `CCCD` = ?, `ghichu` = ? "
                + "WHERE `idhokhau` = ?";
        
        try(
            Connection conn = DatabaseHelper.ConnectDB();
            PreparedStatement insertPrepSt = conn.prepareStatement(insert_sql);
        ){
            insertPrepSt.setString(1, hk.getHoTen());
            insertPrepSt.setString(2, hk.getCccd());
            insertPrepSt.setString(3, hk.getGhiChu());
            insertPrepSt.setString(4, hk.getIdHK());
            insertPrepSt.execute();
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
