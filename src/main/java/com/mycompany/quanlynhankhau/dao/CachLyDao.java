/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlynhankhau.dao;

import com.mycompany.quanlynhankhau.Helpers.DatabaseHelper;
import com.mycompany.quanlynhankhau.Thongtin.CachLy;
import com.mycompany.quanlynhankhau.Thongtin.HoKhau;
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
public class CachLyDao {
    public boolean IsExist(String CCCD, String id) throws Exception{
        String checkExist_sql = "SELECT * FROM cachly" +
                            "  WHERE idnhankhau = ?";
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
    
    public void InsertCL(CachLy cl) throws Exception{
        String insert_sql = "INSERT INTO `cachly` (`idnhankhau`, `hoten`, `trangthaicachly, `thoigianbatdaucachly`, `mucdocachly`,"
                + "`dakiemtracovid`, `hinhthuckiemtra`, `thoigiankiemtra`, `ketquakiemtra`) "
                + "VALUES (?,?,?,?,?,?,?,?,?)";
        
        try(
            Connection conn = DatabaseHelper.ConnectDB();
            PreparedStatement insertPrepSt = conn.prepareStatement(insert_sql);
        ){
            insertPrepSt.setString(1, cl.getIdNK());
            insertPrepSt.setString(2, cl.getHoTen());
            insertPrepSt.setString(3, cl.getTrangThai());
            insertPrepSt.setString(4, cl.getTgBatDau());
            insertPrepSt.setString(5, cl.getMucDo());
            insertPrepSt.setString(6, cl.getKiemTra());
            insertPrepSt.setString(7, cl.getHinhThuc());
            insertPrepSt.setString(8, cl.getTgKiemTra());
            insertPrepSt.setString(9, cl.getKetQua());

            insertPrepSt.execute();
        }
    }
    
    public CachLy SearchCL(String info) throws Exception{
        String search_CL_sql = "SELECT * FROM `cachly`"+
                            "  WHERE `cachly`.`idnhankhau` = ? OR `cachly`.`CCCD` = ?";
        try(
            Connection conn = DatabaseHelper.ConnectDB();
            PreparedStatement searchPrepSt = conn.prepareStatement(search_CL_sql);
        ){
            searchPrepSt.setString(1, info);
            searchPrepSt.setString(2, info);
            ResultSet rs = searchPrepSt.executeQuery();
            if (rs.next()){
                CachLy cl = new CachLy(rs.getString("idnhankhau"), rs.getString("CCCD"), rs.getString("hoten"),
                                rs.getString("thoigianbatdaucachly"), rs.getString("hinhthuckiemtra"), rs.getString("thoigiankiemtra"), rs.getString("dakiemtracovid"),
                                 rs.getString("ketquakiemtra"), rs.getString("mucdocachly"), rs.getString("trangthaicachly"));
                
                
                return cl;
            }else{
                return null;
            }
        }
    }
    
    public void DeleteCL(String ID) throws Exception{
        String delete_sql1 = "DELETE FROM `cachly` WHERE `cachly`.`idnhankhau` = ?";
        
        try(
            Connection conn = DatabaseHelper.ConnectDB();
            PreparedStatement deletePrepSt1 = conn.prepareStatement(delete_sql1);
            
        ){
            deletePrepSt1.setString(1, ID);
                     
            deletePrepSt1.execute();           
        }
    }
    
    public List<CachLy> GetAllCL() throws Exception{
        String sql = "SELECT * FROM `cachly`";
        
        List<CachLy> clList = new ArrayList<>();
        try(
            Connection conn = DatabaseHelper.ConnectDB();
            Statement st = conn.createStatement();
        ){
            ResultSet rs = st.executeQuery(sql);
            CachLy cl;
            while(rs.next()){
                cl = new CachLy(rs.getString("idnhankhau"), rs.getString("CCCD"), rs.getString("hoten"),
                                rs.getString("thoigianbatdaucachly"), rs.getString("hinhthuckiemtra"), rs.getString("thoigiankiemtra"), rs.getString("dakiemtracovid"),
                                 rs.getString("ketquakiemtra"), rs.getString("mucdocachly"), rs.getString("trangthaicachly"));
                
                clList.add(cl);
            }
            if (!clList.isEmpty()){
                Collections.sort(clList, (d1, d2) -> {
                    return Integer.parseInt(d1.getIdNK()) - Integer.parseInt(d2.getIdNK());
                });
            }
            return clList;
        }
    }
}
