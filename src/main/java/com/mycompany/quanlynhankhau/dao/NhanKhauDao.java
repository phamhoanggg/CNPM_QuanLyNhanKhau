/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlynhankhau.dao;

import com.mycompany.quanlynhankhau.Helpers.DatabaseHelper;
import com.mycompany.quanlynhankhau.Thongtin.NhanKhau;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author minhd
 */
public class NhanKhauDao {
    public boolean IsExist(String CCCD, String id) throws Exception{
        String checkExist_sql = "SELECT * FROM nhankhau" +
                            "  WHERE CCCD = ? OR idnhankhau = ?";
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
    
    public void InsertNK(NhanKhau nk) throws Exception{
        String insert_sql = "INSERT INTO `nhankhau` (`idnhankhau`, `hoten`, `ngaysinh`, `gioitinh`, `quanhevoichuho`,"
                + "`quequan`, `dantoc`, `nghenghiep`, `CCCD`, `ngaydangkythuongtru`, `noidangkythuongtruchuyenden`, `ghichu`) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        
        try(
            Connection conn = DatabaseHelper.ConnectDB();
            PreparedStatement insertPrepSt = conn.prepareStatement(insert_sql);
        ){
            insertPrepSt.setString(1, nk.getIdNK());
            insertPrepSt.setString(2, nk.getHoTen());
            insertPrepSt.setString(3, nk.getNgaySinh());
            insertPrepSt.setString(4, nk.getGioiTinh());
            insertPrepSt.setString(5, nk.getQuanHeVoiChuHo());
            insertPrepSt.setString(6, nk.getQueQuan());
            insertPrepSt.setString(7, nk.getDanToc());
            insertPrepSt.setString(8, nk.getNgheNghiep());
            insertPrepSt.setString(9, nk.getCccd());
            insertPrepSt.setString(10, nk.getNgayDkThuongTru());
            insertPrepSt.setString(11, nk.getNoiDkThuongTru());
            insertPrepSt.setString(12, nk.getGhiChu());

            insertPrepSt.execute();
        }
    }
    
    public void InsertNK_HK(String idhokhau, String idnhankhau, String quanhe) throws Exception{        
        String insert_Into_NK_HK_sql = "INSERT INTO `nhankhau_hokhau`(`idhokhau`, `idnhankhau`, `quanhevoichuho`)"+
                                "VALUES (?, ?, ?)";
        
        try(
            Connection conn = DatabaseHelper.ConnectDB();
            PreparedStatement insertPrepSt = conn.prepareStatement(insert_Into_NK_HK_sql);
        ){
            insertPrepSt.setString(1, idhokhau);
            insertPrepSt.setString(2, idnhankhau);
            insertPrepSt.setString(3, quanhe);

            insertPrepSt.execute();
        }
    }
    
    public NhanKhau SearchNK(String ID) throws Exception{
        String search_NK_sql = "SELECT * FROM `nhankhau` JOIN `nhankhau_hokhau` ON `nhankhau`.`idnhankhau` = `nhankhau_hokhau`.`idnhankhau`"+
                            "  WHERE `nhankhau`.`idnhankhau` = ?";
        try(
            Connection conn = DatabaseHelper.ConnectDB();
            PreparedStatement searchPrepSt = conn.prepareStatement(search_NK_sql);
        ){
            searchPrepSt.setString(1, ID);

            ResultSet rs = searchPrepSt.executeQuery();
            if (rs.next()){
                NhanKhau nk = new NhanKhau();
                
                nk.setIdNK(ID);
                nk.setIdHK(rs.getString("idhokhau"));
                nk.setCccd(rs.getString("CCCD"));
                nk.setDanToc(rs.getString("dantoc"));
                nk.setGioiTinh(rs.getString("gioitinh"));
                nk.setHoTen(rs.getString("hoten"));
                nk.setNgaySinh(rs.getString("ngaysinh"));
                nk.setQuanHeVoiChuHo(rs.getString("quanhevoichuho"));
                nk.setNgheNghiep(rs.getString("nghenghiep"));
                nk.setQueQuan(rs.getString("quequan"));
                nk.setNoiDkThuongTru(rs.getString("noidangkythuongtruchuyenden"));
                nk.setNgayDkThuongTru(rs.getString("ngaydangkythuongtru"));
                nk.setGhiChu(rs.getString("ghichu"));
                
                return nk;
            }else{
                return null;
            }
        }
    }
    
    public void DeleteNK(String ID) throws Exception{
        String delete_sql1 = "DELETE FROM `nhankhau` WHERE `nhankhau`.`idnhankhau` = ?";
        String delete_sql2 = "DELETE FROM `nhankhau_hokhau` WHERE `nhankhau_hokhau`.`idnhankhau` = ?";

        try(
            Connection conn = DatabaseHelper.ConnectDB();
            PreparedStatement deletePrepSt1 = conn.prepareStatement(delete_sql1);
            PreparedStatement deletePrepSt2 = conn.prepareStatement(delete_sql2);

        ){
            deletePrepSt1.setString(1, ID);
            deletePrepSt2.setString(1, ID);
            
            deletePrepSt1.execute();
            deletePrepSt2.execute();
        }
    }
}
