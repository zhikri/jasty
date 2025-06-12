/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jambismartcity.core.repository;

import com.jambismartcity.core.domain.User;

/**
 *
 * @author Kelompok 3;
 */
public interface UserRepository {
    
    // method untuk login, akan mengembalikan User jika berhasil, null jika gagal
    User login(String username, String password);
    
    // method untuk mendaftarkan user baru
    void register(User user);
    
}
