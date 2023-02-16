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
    
    public static final String CHECK_LOGIN_ADMIN_SQL = "select * from `admin` "+
                "  where `admin`.`name` = ? and `admin`.`password` = ?";
    
    public static final String CHECK_LOGIN_USER_SQL = "select * from `nhankhau` "+
                "  where `username` = ? and `password` = ?";
    
    public static final String INSERT_NK_SQL = "INSERT INTO `nhankhau` (`idnhankhau`, `idhokhau`, `hoten`, `ngaysinh`, `gioitinh`, `quanhevoichuho`,"
                + "`quequan`, `dantoc`, `nghenghiep`, `CCCD`, `diachithuongtru`, `ghichu`) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
    
    public static final String UPDATE_NK_SQL = "UPDATE `nhankhau` SET `hoten` = ?, `idhokhau` = ?, `ngaysinh` = ?, `gioitinh` = ?, `quanhevoichuho` = ?,"
                + "`quequan` = ?, `dantoc` = ?, `nghenghiep` = ?, `CCCD` = ?, `diachithuongtru` = ?, `ghichu` = ? "+
                "WHERE `idnhankhau` = ?";
    
    public static final String CHECKEXIST_NK_SQL = "SELECT * FROM `nhankhau`" +
                            "  WHERE `CCCD` = ? OR `idnhankhau` = ?";
   
    
    public static final String SEARCH_NK_SQL = "SELECT * FROM `nhankhau`"+
                            "  WHERE `nhankhau`.`idnhankhau` = ?";
    
    public static final String DELETE_NK_SQL = "DELETE `nhankhau`,`nhankhau_hokhau` FROM `nhankhau` INNER JOIN `nhankhau_hokhau` ON `nhankhau`.`idnhankhau` = `nhankhau_hokhau`.`idnhankhau`"+
                            "  WHERE `nhankhau`.`idnhankhau` = ? OR `nhankhau`.`CCCD`";
    
    public static final String CHECKEXIST_HK_SQL = "SELECT * FROM `hokhau`" +
                            "  WHERE `CCCD` = ? OR `idhokhau` = ?";
    
    public static final String INSERT_HK_SQL = "INSERT INTO `hokhau` (`idhokhau`, `hotenchuho`, `quequan`, `CCCD`, `ngaysinh`, `ghichu`) "
                            + "VALUES (?,?,?,?,?,?)";
    
    public static final String SEARCH_HK_SQL = "SELECT * FROM `hokhau`"+
                            "  WHERE `hokhau`.`idhokhau` = ?";
    
    public static final String DELETE_HK_SQL = "DELETE FROM `hokhau` WHERE `hokhau`.`idhokhau` = ?";  
    public static Connection ConnectDB() throws SQLException {
        Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
        return connection;
    }
    
    
}
