/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemarh.util;


import javax.swing.JCheckBox;
import javax.swing.JPasswordField;

/**
 *
 * @author Pichau
 */
public class ConfiguraComponentes {
    public void configCampoTexto(javax.swing.JTextField componente, String placeholder) {
        componente.putClientProperty("JTextField.placeholderText", placeholder);
    }

    public void configCampoSenha(JPasswordField componente, String placeholder) {
        componente.putClientProperty("JTextField.placeholderText", placeholder);
    }
    
    public void configCheckBox(JCheckBox componente, JPasswordField campoSenha, String texto, String senha){
        if(componente.isSelected() || senha.equals(texto)){
            campoSenha.setEchoChar((char) 0); 
        }else{
            campoSenha.setEchoChar('•');
        }
    }
}
