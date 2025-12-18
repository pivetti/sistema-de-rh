/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemarh.util;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author Pichau
 */
public class Tema {
    private static boolean modoEscuro = false;

    public static void aplicarClaro() {
        try {
            FlatLightLaf.setup();
            modoEscuro = false;

            UIManager.put("TextField.foreground", new java.awt.Color(40, 40, 40));
            UIManager.put("PasswordField.foreground", new java.awt.Color(40, 40, 40));
            UIManager.put("TextField.caretForeground", new java.awt.Color(40, 40, 40));
            UIManager.put("PasswordField.caretForeground", new java.awt.Color(40, 40, 40));

            UIManager.put("TextField.placeholderForeground", new java.awt.Color(120, 120, 120));
            UIManager.put("PasswordField.placeholderForeground", new java.awt.Color(120, 120, 120));

            atualizarUI();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


public static void aplicarEscuro() {
    try {
        FlatDarkLaf.setup();
        modoEscuro = true;

        UIManager.put("TextField.foreground", new java.awt.Color(230, 230, 230));
        UIManager.put("PasswordField.foreground", new java.awt.Color(230, 230, 230));
        UIManager.put("TextField.caretForeground", new java.awt.Color(230, 230, 230));
        UIManager.put("PasswordField.caretForeground", new java.awt.Color(230, 230, 230));

        UIManager.put("TextField.placeholderForeground", new java.awt.Color(160, 160, 160));
        UIManager.put("PasswordField.placeholderForeground", new java.awt.Color(160, 160, 160));

        atualizarUI();
    } catch (Exception e) {
        e.printStackTrace();
    }
}


    public static boolean isModoEscuro() {
        return modoEscuro;
    }

    private static void atualizarUI() {
        for (java.awt.Window window : java.awt.Window.getWindows()) {
            SwingUtilities.updateComponentTreeUI(window);
        }
    }
}
