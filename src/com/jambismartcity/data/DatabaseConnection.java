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
    
    
    public static Connection getConnection(){
        if (connection == null){
            try {
            String url = "jdbc:mysql://localhost:8889/jasty";
            String user = "root";
            String password = "root";
            
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            
            connection = DriverManager.getConnection(url, user, password);
            
            System.out.println("Koneksi ke database berhasil");
                
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Koneksi ke database gagal! Error: " + e.getMessage());
                // Keluar dari aplikasi jika koneksi gagal, karena aplikasi tidak bisa berjalan tanpanya
                System.exit(1); 
            }
            
        }
        return connection;
    }
    
}
