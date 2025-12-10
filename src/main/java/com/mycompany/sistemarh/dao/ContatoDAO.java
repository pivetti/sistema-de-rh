/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemarh.dao;

import com.mycompany.sistemarh.database.Conexao;
import com.mycompany.sistemarh.model.Contato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pichau
 */
public class ContatoDAO {

    public int inserir(Contato c) {

        String sql = """
            INSERT INTO tb_contato 
                (telefone, email, id_funcionario, ativo)
            VALUES (?, ?, ?, ?)
            RETURNING id
        """;

        try (
            Connection con = Conexao.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setString(1, c.getTelefone());
            ps.setString(2, c.getEmail());
            ps.setInt(3, c.getIdFuncionario());
            ps.setBoolean(4, c.isAtivo());

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao inserir contato -> " + e);
        }

        return -1;
    }

    public List<Contato> listar() {

        List<Contato> lista = new ArrayList<>();
        String sql = "SELECT * FROM tb_contato ORDER BY id";

        try (
            Connection con = Conexao.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {

                Contato c = new Contato(
                    rs.getInt("id"),
                    rs.getString("telefone"),
                    rs.getString("email"),
                    rs.getBoolean("ativo"),
                    rs.getInt("id_funcionario")
                );

                lista.add(c);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar contatos -> " + e);
        }

        return lista;
    }


    public Contato buscarPorId(int id) {

        String sql = "SELECT * FROM tb_contato WHERE id = ?";

        try (
            Connection con = Conexao.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return new Contato(
                    rs.getInt("id"),
                    rs.getString("telefone"),
                    rs.getString("email"),
                    rs.getBoolean("ativo"),
                    rs.getInt("id_funcionario")
                );
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar contato por ID -> " + e);
        }

        return null;
    }

    public void atualizar(Contato c) {

        String sql = """
            UPDATE tb_contato
            SET telefone = ?, email = ?, ativo = ?, id_funcionario = ?
            WHERE id = ?
        """;

        try (
            Connection con = Conexao.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, c.getTelefone());
            ps.setString(2, c.getEmail());
            ps.setBoolean(3, c.isAtivo());
            ps.setInt(4, c.getIdFuncionario());
            ps.setInt(5, c.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar contato -> " + e);
        }
    }

    public void excluir(int id) {

        String sql = "DELETE FROM tb_contato WHERE id = ?";

        try (
            Connection con = Conexao.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao excluir contato -> " + e);
        }
    }
}

