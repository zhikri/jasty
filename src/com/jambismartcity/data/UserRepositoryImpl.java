/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jambismartcity.data;

import com.jambismartcity.core.domain.User;
import com.jambismartcity.core.repository.UserRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author Kelompok 3;
 */
public class UserRepositoryImpl implements UserRepository{

    @Override
    public User login(String username, String password) {
         String sql = "SELECT * FROM users WHERE username = ? AND password = ?"; // Gunakan tabel 'users'
        User user = null;
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, username);
            pst.setString(2, password); // Note: Untuk produksi nyata, password harus di-hash!
            
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    // Jika data ditemukan, buat object User
                    user = new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("nama_lengkap"),
                        rs.getString("email")
                    );
                }
            }
            
        } catch (SQLException e) {
            // Sebaiknya log error ini daripada menampilkannya ke user
            System.err.println("Error saat proses login: " + e.getMessage());
        }
        
        return user;
    }

    @Override
    public void register(User user) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
