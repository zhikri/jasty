/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jambismartcity.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Kelompok 3;
 */
public class DatabaseConnection {
    
    private static Connection connection;
    
    
    public static Connection getConnection() throws SQLException{
        // Setiap kali method ini dipanggil, ia akan membuat dan mengembalikan koneksi yang baru.
        String url = "jdbc:mysql://localhost:8889/jasty";
        String user = "root";
        String password = "root"; // Sesuaikan jika perlu
        
        // Tidak perlu lagi DriverManager.registerDriver() di Java modern
        return DriverManager.getConnection(url, user, password);
      
    }
    
}
