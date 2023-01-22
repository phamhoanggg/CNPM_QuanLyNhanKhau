/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlynhankhau.Helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author minhd
 */
public class DatabaseHelper {
    private static final String DATABASE_URL = "jdbc:mysql://localhost/quanlynhankhau";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "";
    
    public static final String insert_sql = "INSERT INTO `nhankhau` (`idnhankhau`, `hoten`, `bidanh`, `ngaysinh`, `gioitinh`, `quanhevoichuho`, `noisinh`, "
                + "`quequan`, `dantoc`, `nghenghiep`, `noilamviec`, `CCCD`, `ngaycap`, `noicap`, `ngaydangkythuongtru`, `noidangkythuongtruchuyenden`, `ghichu`) "
                + "VALUES (NULL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    
    public static final String checkExist_sql = "SELECT `CCCD` from `nhankhau`"+
                "  WHERE `CCCD` = ?";
    
    public static Connection ConnectDB() throws SQLException {
        Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
        return connection;
    }
    
    
}
