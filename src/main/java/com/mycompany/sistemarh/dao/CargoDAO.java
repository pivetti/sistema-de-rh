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
import com.mycompany.sistemarh.model.Cargo;
import com.mycompany.sistemarh.model.Departamento;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CargoDAO {

    public void inserir(Cargo c) {
        String sql = "INSERT INTO tb_cargo (nome, id_departamento) VALUES (?, ?)";

        try (Connection con = Conexao.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, c.getNome());
            ps.setInt(2, c.getDepartamento().getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir cargo -> " + e);
        }
    }

    public List<Cargo> listar() {
    List<Cargo> lista = new ArrayList<>();

    String sql = """
        SELECT c.id, c.nome, d.id AS dep_id, d.nome AS dep_nome
        FROM tb_cargo c
        JOIN tb_departamento d ON c.id_departamento = d.id
        ORDER BY c.id
    """;

    try (Connection con = Conexao.getConnection();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            Departamento dep = new Departamento(
                rs.getInt("dep_id"),
                rs.getString("dep_nome")
            );

            Cargo cargo = new Cargo(
                rs.getInt("id"),
                rs.getString("nome"),
                dep
            );

            lista.add(cargo);
        }

    } catch (SQLException e) {
        System.out.println("Erro ao listar cargos -> " + e);
    }

    return lista;
    }
    
    public List<Cargo> listarPorDepartamento(int idDepartamento) {
        List<Cargo> lista = new ArrayList<>();

        String sql = """
            SELECT c.id, c.nome, d.id AS dep_id, d.nome AS dep_nome
            FROM tb_cargo c
            JOIN tb_departamento d ON c.id_departamento = d.id
            WHERE d.id = ?
            ORDER BY c.id
        """;

        try (Connection con = Conexao.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idDepartamento);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Departamento dep = new Departamento(
                        rs.getInt("dep_id"),
                        rs.getString("dep_nome")
                    );

                    Cargo cargo = new Cargo(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        dep
                    );

                    lista.add(cargo);
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar cargos por departamento -> " + e);
        }

        return lista;
    }

    public void excluir(int id) {
        String sql = "DELETE FROM tb_cargo WHERE id = ?";

        try (Connection con = Conexao.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Cargo excluído com sucesso!");

        } catch (SQLException e) {
            //verifica erro de chave estrangeira fk
            if (e.getSQLState().equals("23503")) {
                System.out.println("ERRO: Não é possível excluir este cargo pois existem FUNCIONÁRIOS ocupando-o.");
            } else {
                System.out.println("Erro ao excluir cargo -> " + e);
            }
        }
    }

    public void atualizar(Cargo c) {
        String sql = "UPDATE tb_cargo SET nome = ?, id_departamento = ? WHERE id = ?";

        try (Connection con = Conexao.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, c.getNome());
            ps.setInt(2, c.getDepartamento().getId());
            ps.setInt(3, c.getId());

            ps.executeUpdate();
            System.out.println("Cargo atualizado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar cargo -> " + e);
        }
    
    }
}