/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemarh.dao;

import com.mycompany.sistemarh.database.Conexao;
import com.mycompany.sistemarh.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Pichau
 */
public class UsuarioDAO {
    public void cadastrar(Usuario u) throws SQLException {
        String sql = "INSERT INTO tb_usuario (nome_completo, email, senha) VALUES (?, ?, ?)";
        
        try (Connection con = Conexao.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, u.getNomeCompleto());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getSenha());
            
            ps.executeUpdate();
            
        } catch (SQLException e) {
            throw new SQLException("Erro ao cadastrar usuário: " + e.getMessage());
        }
    }
    
    public boolean validarLogin(String email, String senha) {
        String sql = "SELECT * FROM tb_usuario WHERE email = ? AND senha = ?";
        boolean check = false;
        
        try (Connection con = Conexao.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, email);
            ps.setString(2, senha);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    check = true; //se encontrou alguém com esse email e senha retorna true
                }
            }
            
        } catch (SQLException e) {
            System.out.println("Erro ao validar login: " + e.getMessage());
        }
        
        return check;
    }
}
