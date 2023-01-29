/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlynhankhau.Thongtin;

/**
 *
 * @author HP
 */
public class CachLy {
    private String idNK, idHK, cccd, hoTen, tgBatDau, hinhThuc, tgKiemTra, kiemTra, ketQua, mucDo, trangThai;

// Constructors
    public CachLy() {
    }

    public CachLy(String idNK, String idHK, String cccd, String hoTen, String tgBatDau, String hinhThuc, String tgKiemTra, String kiemTra, String ketQua, String mucDo, String trangThai) {
        this.idNK = idNK;
        this.idHK = idHK;
        this.cccd = cccd;
        this.hoTen = hoTen;
        this.tgBatDau = tgBatDau;
        this.hinhThuc = hinhThuc;
        this.tgKiemTra = tgKiemTra;
        this.kiemTra = kiemTra;
        this.ketQua = ketQua;
        this.mucDo = mucDo;
        this.trangThai = trangThai;        
    }

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

    public String getTgBatDau() {
        return tgBatDau;
    }

    public void setTgBatDau(String tgBatDau) {
        this.tgBatDau = tgBatDau;
    }

    public String getHinhThuc() {
        return hinhThuc;
    }

    public void setHinhThuc(String hinhThuc) {
        this.hinhThuc = hinhThuc;
    }

    public String getTgKiemTra() {
        return tgKiemTra;
    }

    public void setTgKiemTra(String tgKiemTra) {
        this.tgKiemTra = tgKiemTra;
    }

    public String getKiemTra() {
        return kiemTra;
    }

    public void setKiemTra(String kiemTra) {
        this.kiemTra = kiemTra;
    }

    public String getKetQua() {
        return ketQua;
    }

    public void setKetQua(String ketQua) {
        this.ketQua = ketQua;
    }

    public String getMucDo() {
        return mucDo;
    }

    public void setMucDo(String mucDo) {
        this.mucDo = mucDo;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    
    
    
}
