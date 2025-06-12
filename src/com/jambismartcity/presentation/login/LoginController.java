/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jambismartcity.presentation.login;

import com.jambismartcity.core.domain.User;
import com.jambismartcity.core.repository.UserRepository;
import com.jambismartcity.data.UserRepositoryImpl;
//import com.jambismartcity.presentation.mainmenu.MainMenuView;
import javax.swing.JOptionPane;

/**
 *
 * @author Kelompok 3;
 */
public class LoginController {
     private final LoginView view;
     private final UserRepository userRepository;
     
     public LoginController(LoginView view){
         this.view = view;
         this.userRepository = new UserRepositoryImpl(); // Kita langsung membuat implementasinya di sini
    }
     
     public void login(){
         String username = view.getUsernameField().getText();
         String password = new String(view.getPasswordField().getPassword());
         if (username.trim().isEmpty() || password.trim().isEmpty()) {
            JOptionPane.showMessageDialog(view, "Username dan password tidak boleh kosong!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        User user = userRepository.login(username, password);
        
        if (user != null) {
            // Login Berhasil
            JOptionPane.showMessageDialog(view, "Login berhasil! Selamat datang, " + user.getFullName(), "Sukses", JOptionPane.INFORMATION_MESSAGE);
            
            // Buka MainMenuView
            //new MainMenuView().setVisible(true);
            
            // Tutup LoginView
            //view.dispose();
            
        } else {
            // Login Gagal
            JOptionPane.showMessageDialog(view, "Username atau password salah!", "Login Gagal", JOptionPane.ERROR_MESSAGE);
        }
     }
     
    
}
