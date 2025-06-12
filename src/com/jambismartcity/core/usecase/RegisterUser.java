/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jambismartcity.core.usecase;

import com.jambismartcity.core.domain.User;
import com.jambismartcity.core.repository.UserRepository;
/**
 *
 * @author Kelompok 3;
 */
public class RegisterUser {
     private final UserRepository userRepository;

    public RegisterUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    
    
 public boolean execute(User newUser) {
        // Aturan Bisnis 1: Cek apakah username sudah terdaftar
        User existingUser = userRepository.findByUsername(newUser.getUsername());
        if (existingUser != null) {
            // Username sudah ada, registrasi gagal
            return false;
        }
        
        userRepository.register(newUser);
        return true;
 }
 
}
