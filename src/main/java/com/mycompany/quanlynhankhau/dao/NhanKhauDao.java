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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author minhd
 */
public class NhanKhauDao {
    public NhanKhau IsExist(String CCCD, String id) throws Exception{
        try(
            Connection conn = DatabaseHelper.ConnectDB();
            PreparedStatement checkPrepSt = conn.prepareStatement(DatabaseHelper.CHECKEXIST_NK_SQL);    
            ){
            checkPrepSt.setString(1,CCCD);
            checkPrepSt.setString(2,id);

            ResultSet rs = checkPrepSt.executeQuery();
            NhanKhau nk = null;
            if (rs.next()){
                nk = new NhanKhau(rs.getString("idnhankhau"), rs.getString("idhokhau"),
                                        rs.getString("CCCD"), rs.getString("hoten"), rs.getString("ngaysinh"),
                                        rs.getString("gioitinh"), rs.getString("quanhevoichuho"), rs.getString("quequan"),
                                        rs.getString("dantoc"), rs.getString("nghenghiep"), rs.getString("ngaydangkythuongtru"),
                                        rs.getString("noidangkythuongtruchuyenden"), rs.getString("ghichu"));
            
            }
            return nk;
        }
    }
    
    public void InsertNK(NhanKhau nk) throws Exception{
        
        try(
            Connection conn = DatabaseHelper.ConnectDB();
            PreparedStatement insertPrepSt = conn.prepareStatement(DatabaseHelper.INSERT_NK_SQL);
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
    
    public List<NhanKhau> GetAllNK() throws Exception{
        String sql = "SELECT * FROM `nhankhau`";
        
        List<NhanKhau> nkList = new ArrayList<>();
        try(
            Connection conn = DatabaseHelper.ConnectDB();
            Statement st = conn.createStatement();
        ){
            ResultSet rs = st.executeQuery(sql);
            NhanKhau nk;
            while(rs.next()){
                nk = new NhanKhau(rs.getString("idnhankhau"), rs.getString("idhokhau"),
                                        rs.getString("CCCD"), rs.getString("hoten"), rs.getString("ngaysinh"),
                                        rs.getString("gioitinh"), rs.getString("quanhevoichuho"), rs.getString("quequan"),
                                        rs.getString("dantoc"), rs.getString("nghenghiep"), rs.getString("ngaydangkythuongtru"),
                                        rs.getString("noidangkythuongtruchuyenden"), rs.getString("ghichu"));
                
                nkList.add(nk);
            }
            return nkList;
        }
    }
    public NhanKhau SearchNK(String ID) throws Exception{
        try(
            Connection conn = DatabaseHelper.ConnectDB();
            PreparedStatement searchPrepSt = conn.prepareStatement(DatabaseHelper.SEARCH_NK_SQL);
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
    
    public void UpdateNK(NhanKhau nk) throws Exception{
        try(
            Connection conn = DatabaseHelper.ConnectDB();
            PreparedStatement insertPrepSt = conn.prepareStatement(DatabaseHelper.UPDATE_NK_SQL);
        ){
            insertPrepSt.setString(1, nk.getHoTen());
            insertPrepSt.setString(2, nk.getNgaySinh());
            insertPrepSt.setString(3, nk.getGioiTinh());
            insertPrepSt.setString(4, nk.getQuanHeVoiChuHo());
            insertPrepSt.setString(5, nk.getQueQuan());
            insertPrepSt.setString(6, nk.getDanToc());
            insertPrepSt.setString(7, nk.getNgheNghiep());
            insertPrepSt.setString(8, nk.getCccd());
            insertPrepSt.setString(9, nk.getNgayDkThuongTru());
            insertPrepSt.setString(10, nk.getNoiDkThuongTru());
            insertPrepSt.setString(11, nk.getGhiChu());
            insertPrepSt.setString(12, nk.getIdNK());
            
            insertPrepSt.execute();
        }
    }
    
    public void DeleteNK(String ID) throws Exception{
        try(
            Connection conn = DatabaseHelper.ConnectDB();
            PreparedStatement deletePrepSt = conn.prepareStatement(DatabaseHelper.DELETE_NK_SQL);
        ){
//            deletePrepSt.setString(1, ID);
            
            deletePrepSt.execute();
        }
    }
}
