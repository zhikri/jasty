/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jambismartcity.presentation.register;

import com.jambismartcity.core.domain.User;
import com.jambismartcity.core.usecase.RegisterUser;
import com.jambismartcity.data.UserRepositoryImpl;
import javax.swing.JOptionPane;

/**
 *
 * @author Kelompok 3;
 */
public class RegisterController {
    
    private final RegisterView view;
    private final RegisterUser registerUseCase;

    public RegisterController(RegisterView view) {
        this.view = view;
        this.registerUseCase = new RegisterUser(new UserRepositoryImpl());
    }

    public void register() {
        String namaLengkap = view.getFullNameField().getText();
        String email = view.getEmailField().getText();
        String username = view.getUsernameField().getText();
        String password = new String(view.getPasswordField().getPassword());

        if (namaLengkap.trim().isEmpty() || email.trim().isEmpty() || username.trim().isEmpty() || password.trim().isEmpty()) {
            JOptionPane.showMessageDialog(view, "Semua kolom harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        User newUser = new User();
        newUser.setFullName(namaLengkap);
        newUser.setEmail(email);
        newUser.setUsername(username);
        newUser.setPassword(password);

        boolean success = registerUseCase.execute(newUser);

        if (success) {
            JOptionPane.showMessageDialog(view, "Registrasi berhasil! Silakan login.", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            //view.getLoginLabel().doClick(); // Otomatis klik tombol kembali
        } else {
            JOptionPane.showMessageDialog(view, "Registrasi gagal! Username mungkin sudah digunakan.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
