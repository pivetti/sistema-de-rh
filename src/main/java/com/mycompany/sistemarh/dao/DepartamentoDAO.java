/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemarh.dao;

/**
 *
 * @author Pichau
 */
import com.mycompany.sistemarh.database.Conexao;
import com.mycompany.sistemarh.model.Departamento;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoDAO {

    public void inserir(Departamento d) {
        String sql = "INSERT INTO tb_departamento (nome) VALUES (?)";

        try (
            Connection con = Conexao.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        ) {
            ps.setString(1, d.getNome());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir departamento -> " + e);
        }
    }

    public List<Departamento> listar() {
        List<Departamento> lista = new ArrayList<>();
        String sql = "SELECT * FROM tb_departamento ORDER BY id";

        try (
            Connection con = Conexao.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        ) {
            while (rs.next()) {
                lista.add(new Departamento(rs.getInt("id"), rs.getString("nome")));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar departamentos -> " + e);
        }

        return lista;
    }
    
    public void excluir(int id) {
        String sql = "DELETE FROM tb_departamento WHERE id = ?";

        try (
            Connection con = Conexao.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Departamento excluído com sucesso!");

        } catch (SQLException e) {
            //verifica se o erro é de chave estrangeira (código 23503 no PostgreSQL)
            if (e.getSQLState().equals("23503")) {
                System.out.println("ERRO: Não é possível excluir este departamento pois existem CARGOS associados a ele.");
                System.out.println("Solução: Exclua os cargos primeiro.");
            } else {
                System.out.println("Erro genérico ao excluir: " + e.getMessage());
            }
        }
    }
    
    public void atualizar(Departamento d) {
        String sql = "UPDATE tb_departamento SET nome = ? WHERE id = ?";

        try (
            Connection con = Conexao.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setString(1, d.getNome());
            ps.setInt(2, d.getId()); //o ID é usado no where pra saber qual atualizar
            
            ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar departamento -> " + e);
        }
    }
    
}
