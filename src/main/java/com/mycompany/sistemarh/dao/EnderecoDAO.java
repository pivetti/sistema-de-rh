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
import com.mycompany.sistemarh.model.Endereco;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDAO {

    public int inserir(Endereco e) {
        String sql = """
            INSERT INTO tb_endereco 
                (rua, numero, bairro, cep, cidade, estado, id_funcionario, ativo)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?)
            RETURNING id
        """;

        try (
            Connection con = Conexao.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        ) {
            ps.setString(1, e.getRua());
            ps.setString(2, e.getNumero());
            ps.setString(3, e.getBairro());
            ps.setString(4, e.getCep());
            ps.setString(5, e.getCidade());
            ps.setString(6, e.getEstado());
            ps.setInt(7, e.getIdFuncionario());
            ps.setBoolean(8, e.isAtivo());

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao inserir endereço -> " + ex);
        }

        return -1;
    }


    public List<Endereco> listar() {
        List<Endereco> lista = new ArrayList<>();
        String sql = "SELECT * FROM tb_endereco ORDER BY id";

        try (
            Connection con = Conexao.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        ) {
            while (rs.next()) {
                Endereco e = new Endereco(
                    rs.getInt("id"),
                    rs.getString("rua"),
                    rs.getString("numero"),
                    rs.getString("bairro"),
                    rs.getString("cep"),
                    rs.getString("cidade"),
                    rs.getString("estado"),
                    rs.getBoolean("ativo"),
                    rs.getInt("id_funcionario")
                );
                lista.add(e);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar endereços -> " + e);
        }

        return lista;
    }


    public Endereco buscarPorId(int id) {
        String sql = "SELECT * FROM tb_endereco WHERE id = ?";

        try (
            Connection con = Conexao.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        ) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Endereco(
                    rs.getInt("id"),
                    rs.getString("rua"),
                    rs.getString("numero"),
                    rs.getString("bairro"),
                    rs.getString("cep"),
                    rs.getString("cidade"),
                    rs.getString("estado"),
                    rs.getBoolean("ativo"),
                    rs.getInt("id_funcionario")
                );
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar endereço por ID -> " + e);
        }

        return null;
    }


    public void atualizar(Endereco e) {
        String sql = """
            UPDATE tb_endereco
            SET rua = ?, numero = ?, bairro = ?, cep = ?, cidade = ?, estado = ?,
                ativo = ?, id_funcionario = ?
            WHERE id = ?
        """;

        try (
            Connection con = Conexao.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        ) {
            ps.setString(1, e.getRua());
            ps.setString(2, e.getNumero());
            ps.setString(3, e.getBairro());
            ps.setString(4, e.getCep());
            ps.setString(5, e.getCidade());
            ps.setString(6, e.getEstado());
            ps.setBoolean(7, e.isAtivo());
            ps.setInt(8, e.getIdFuncionario());
            ps.setInt(9, e.getId());

            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar endereço -> " + ex);
        }
    }


    public void excluir(int id) {
        String sql = "DELETE FROM tb_endereco WHERE id = ?";

        try (
            Connection con = Conexao.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        ) {
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Erro ao excluir endereço -> " + ex);
        }
    }
}