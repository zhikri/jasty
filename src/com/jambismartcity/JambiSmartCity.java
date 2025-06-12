/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.jambismartcity;

import com.jambismartcity.presentation.login.LoginView; 
import javax.swing.SwingUtilities;
/**
 *
 * @author Kelompok 3
 */
public class JambiSmartCity {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //Membuat objek LoginView dan menampilkannya
                new LoginView().setVisible(true);
            }
        });
        
        
    }
    
}
