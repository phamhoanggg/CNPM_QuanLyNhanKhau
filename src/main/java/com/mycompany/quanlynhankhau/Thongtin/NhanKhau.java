/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlynhankhau.Thongtin;

/**
 *
 * @author minhd
 */
public class NhanKhau {
    private String idNK, idHK, cccd, hoTen, ngaySinh, gioiTinh, quanHeVoiChuHo, queQuan,
            danToc, ngheNghiep, diachithuongtru, ghiChu;

// Constructors
    public NhanKhau() {
    }

    public NhanKhau(String idNK, String idHK, String cccd, String hoTen, String ngaySinh, String gioiTinh, String quanHeVoiChuHo, String queQuan, String danToc, String ngheNghiep, String diachithuongtru, String ghiChu) {
        this.idNK = idNK;
        this.idHK = idHK;
        this.cccd = cccd;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.quanHeVoiChuHo = quanHeVoiChuHo;
        this.queQuan = queQuan;
        this.danToc = danToc;
        this.ngheNghiep = ngheNghiep;
        this.diachithuongtru = diachithuongtru;
        this.ghiChu = ghiChu;
    }

    // Getters and Setters
    public String getIdNK() {
        return idNK;
    }

    public void setIdNK(String idNK) {
        this.idNK = idNK;
    }

    public String getIdHK() {
        return idHK;
    }

    public void setIdHK(String idHK) {
        this.idHK = idHK;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getQuanHeVoiChuHo() {
        return quanHeVoiChuHo;
    }

    public void setQuanHeVoiChuHo(String quanHeVoiChuHo) {
        this.quanHeVoiChuHo = quanHeVoiChuHo;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getDanToc() {
        return danToc;
    }

    public void setDanToc(String danToc) {
        this.danToc = danToc;
    }

    public String getNgheNghiep() {
        return ngheNghiep;
    }

    public void setNgheNghiep(String ngheNghiep) {
        this.ngheNghiep = ngheNghiep;
    }

    public String getDiachithuongtru() {
        return diachithuongtru;
    }

    public void setDiachithuongtru(String diachithuongtru) {
        this.diachithuongtru = diachithuongtru;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    
    
    
    
}
