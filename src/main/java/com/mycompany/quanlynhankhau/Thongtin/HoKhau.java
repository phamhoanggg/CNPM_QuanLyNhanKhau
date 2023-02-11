/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlynhankhau.Thongtin;

/**
 *
 * @author HP
 */
public class HoKhau {
    private String idHK, cccd, hoTen, ghiChu;

// Constructors
    public HoKhau() {
    }

    public HoKhau(String idHK, String cccd, String hoTen, String ngaySinh, String queQuan, String ghiChu) {
        this.idHK = idHK;        
        this.cccd = cccd;
        this.hoTen = hoTen;
        this.ghiChu = ghiChu;
    }

    // Getters and Setters

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

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

}
