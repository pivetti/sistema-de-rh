/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemarh.controller;

import com.mycompany.sistemarh.model.Usuario;
import java.util.ArrayList;

/**
 *
 * @author Pichau
 */
public class ControllerUsuario {
    private ArrayList<Usuario> usuarios;

    public ControllerUsuario() {
        this.usuarios = new ArrayList<>();
    }

    public boolean addUsuario(Usuario usuario) {
        //verifica se o email ja esta cadastrado
        for (Usuario u : usuarios) {
            if (u.getEmail().equals(usuario.getEmail())) {
                return false;
            }
        }
        return usuarios.add(usuario);
    }

    public Usuario autenticar(String email, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                return usuario;
            }
        }
        return null;
    }

    public ArrayList<Usuario> getUsuarios() {
        return new ArrayList<>(usuarios); 
    }
}
