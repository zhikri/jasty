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
            pst.setString(2, password);
            
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
       String sql = "INSERT INTO users (nama_lengkap, email, username, password) VALUES (?, ?, ?, ?)";
       
       try(Connection conn = DatabaseConnection.getConnection();
               PreparedStatement pst = conn.prepareStatement(sql)){
           
           pst.setString(1, user.getFullName());
           pst.setString(2, user.getEmail());
           pst.setString(3, user.getUsername());
           pst.setString(4, user.getPassword());
           
           pst.executeUpdate();
           
       }catch (SQLException e) {
            // Sebaiknya log error ini
            System.err.println("Error saat proses registrasi: " + e.getMessage());
            // Anda bisa melempar exception custom di sini jika ingin ditangani oleh pemanggil
        }
       
    }

    @Override
    public User findByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        User user = null;
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, username);
            
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
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
            System.err.println("Error saat mencari user: " + e.getMessage());
        }
        return user;
    }
    
}
