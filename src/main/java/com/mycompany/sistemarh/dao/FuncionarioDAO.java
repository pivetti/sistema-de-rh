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
import com.mycompany.sistemarh.model.Contato;
import com.mycompany.sistemarh.model.Departamento;
import com.mycompany.sistemarh.model.Endereco;
import com.mycompany.sistemarh.model.Funcionario;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FuncionarioDAO {

    public void inserir(Funcionario f) {
        String sql = """
            INSERT INTO tb_funcionario (nome, salario, data_entrada, data_saida, id_cargo)
            VALUES (?, ?, ?, ?, ?)
            RETURNING id
        """;

        try (
            Connection con = Conexao.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setString(1, f.getNome());
            ps.setBigDecimal(2, BigDecimal.valueOf(f.getSalario()));
            ps.setDate(3, Date.valueOf(f.getDataEntrada()));

            if (f.getDataSaida() != null)
                ps.setDate(4, Date.valueOf(f.getDataSaida()));
            else
                ps.setNull(4, Types.DATE);

            ps.setInt(5, f.getCargo().getId());

            ResultSet rs = ps.executeQuery();
            rs.next();
            int idFuncionario = rs.getInt("id");

            String sqlEnd = """
                INSERT INTO tb_endereco 
                    (rua, numero, bairro, cep, cidade, estado, ativo, id_funcionario)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?)
            """;

            PreparedStatement psEnd = con.prepareStatement(sqlEnd);

            for (Endereco e : f.getEnderecos()) {
                psEnd.setString(1, e.getRua());
                psEnd.setString(2, e.getNumero());
                psEnd.setString(3, e.getBairro());
                psEnd.setString(4, e.getCep());
                psEnd.setString(5, e.getCidade());
                psEnd.setString(6, e.getEstado());
                psEnd.setBoolean(7, e.isAtivo());
                psEnd.setInt(8, idFuncionario);
                psEnd.executeUpdate();
            }

            String sqlContato = """
                INSERT INTO tb_contato 
                    (telefone, email, ativo, id_funcionario)
                VALUES (?, ?, ?, ?)
            """;

            PreparedStatement psCont = con.prepareStatement(sqlContato);

            for (Contato c : f.getContatos()) {
                psCont.setString(1, c.getTelefone());
                psCont.setString(2, c.getEmail());
                psCont.setBoolean(3, c.isAtivo());
                psCont.setInt(4, idFuncionario);
                psCont.executeUpdate();
            }

        } catch (SQLException e) {
            System.out.println("Erro ao inserir funcionário -> " + e);
        }
    }


    public List<Funcionario> listar() {
        Map<Integer, Funcionario> mapa = new LinkedHashMap<>();

        String sql = """
            SELECT 
                f.id AS func_id,
                f.nome AS func_nome,
                f.salario,
                f.data_entrada,
                f.data_saida,

                c.id AS cargo_id,
                c.nome AS cargo_nome,
                d.id AS dep_id,
                d.nome AS dep_nome,

                e.id AS end_id,
                e.rua,
                e.numero,
                e.bairro,
                e.cep,
                e.cidade,
                e.estado,
                e.ativo AS end_ativo,

                ct.id AS cont_id,
                ct.telefone,
                ct.email,
                ct.ativo AS cont_ativo

            FROM tb_funcionario f
            JOIN tb_cargo c ON f.id_cargo = c.id
            JOIN tb_departamento d ON c.id_departamento = d.id
            LEFT JOIN tb_endereco e ON f.id = e.id_funcionario
            LEFT JOIN tb_contato ct ON f.id = ct.id_funcionario

            ORDER BY f.id
        """;

        try (Connection con = Conexao.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                int idFunc = rs.getInt("func_id");

                //verifica se ja existe no map
                Funcionario f = mapa.get(idFunc);

                if (f == null) {

                    Departamento dep = new Departamento(
                        rs.getInt("dep_id"),
                        rs.getString("dep_nome")
                    );

                    Cargo cargo = new Cargo(
                        rs.getInt("cargo_id"),
                        rs.getString("cargo_nome"),
                        dep
                    );

                    f = new Funcionario();
                    f.setId(idFunc);
                    f.setNome(rs.getString("func_nome"));
                    f.setSalario(rs.getDouble("salario"));

                    Date e1 = rs.getDate("data_entrada");
                    if (e1 != null) f.setDataEntrada(e1.toLocalDate());

                    Date e2 = rs.getDate("data_saida");
                    if (e2 != null) f.setDataSaida(e2.toLocalDate());

                    f.setCargo(cargo);

                    f.setEnderecos(new ArrayList<>());
                    f.setContatos(new ArrayList<>());

                    mapa.put(idFunc, f);
                }

                int idEnd = rs.getInt("end_id");
                if (!rs.wasNull()) {
                    Endereco e = new Endereco(
                        idEnd,
                        rs.getString("rua"),
                        rs.getString("numero"),
                        rs.getString("bairro"),
                        rs.getString("cep"),
                        rs.getString("cidade"),
                        rs.getString("estado"),
                        rs.getBoolean("end_ativo"),
                        idFunc
                    );
                    f.getEnderecos().add(e);
                }

                int idCont = rs.getInt("cont_id");
                if (!rs.wasNull()) {
                    Contato ctt = new Contato(
                        idCont,
                        rs.getString("telefone"),
                        rs.getString("email"),
                        rs.getBoolean("cont_ativo"),
                        idFunc
                    );
                    f.getContatos().add(ctt);
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar funcionários -> " + e);
        }

        return new ArrayList<>(mapa.values());
    }

    public void atualizar(Funcionario f) {
        String sqlFunc = """
            UPDATE tb_funcionario
            SET nome = ?, salario = ?, data_entrada = ?, data_saida = ?, id_cargo = ?
            WHERE id = ?
        """;

        String sqlEnd = """
            UPDATE tb_endereco
            SET rua = ?, numero = ?, bairro = ?, cep = ?, cidade = ?, estado = ?, ativo = ?
            WHERE id = ? AND id_funcionario = ?
        """;

        String sqlCont = """
            UPDATE tb_contato
            SET telefone = ?, email = ?, ativo = ?
            WHERE id = ? AND id_funcionario = ?
        """;

        try (Connection con = Conexao.getConnection();
             PreparedStatement psFunc = con.prepareStatement(sqlFunc);
             PreparedStatement psEnd = con.prepareStatement(sqlEnd);
             PreparedStatement psCont = con.prepareStatement(sqlCont)) {

            //atualizar funcionario
            psFunc.setString(1, f.getNome());
            psFunc.setBigDecimal(2, BigDecimal.valueOf(f.getSalario()));
            psFunc.setDate(3, Date.valueOf(f.getDataEntrada()));

            if (f.getDataSaida() != null)
                psFunc.setDate(4, Date.valueOf(f.getDataSaida()));
            else
                psFunc.setNull(4, Types.DATE);

            psFunc.setInt(5, f.getCargo().getId());
            psFunc.setInt(6, f.getId());
            psFunc.executeUpdate();

            //atualiza os enderecos
            for (Endereco e : f.getEnderecos()) {
                psEnd.setString(1, e.getRua());
                psEnd.setString(2, e.getNumero());
                psEnd.setString(3, e.getBairro());
                psEnd.setString(4, e.getCep());
                psEnd.setString(5, e.getCidade());
                psEnd.setString(6, e.getEstado());
                psEnd.setBoolean(7, e.isAtivo());
                psEnd.setInt(8, e.getId());
                psEnd.setInt(9, f.getId());
                psEnd.executeUpdate();
            }

            //atualiza os contatos
            for (Contato c : f.getContatos()) {
                psCont.setString(1, c.getTelefone());
                psCont.setString(2, c.getEmail());
                psCont.setBoolean(3, c.isAtivo());
                psCont.setInt(4, c.getId());
                psCont.setInt(5, f.getId());
                psCont.executeUpdate();
            }

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar funcionário -> " + e);
        }
    }

    public void excluir(int id) {
        //apagar as constraints FK
        String sqlEnd = "DELETE FROM tb_endereco WHERE id_funcionario = ?";
        String sqlCont = "DELETE FROM tb_contato WHERE id_funcionario = ?";
        String sqlFunc = "DELETE FROM tb_funcionario WHERE id = ?";

        try (Connection con = Conexao.getConnection()) {
            
            try (PreparedStatement ps = con.prepareStatement(sqlEnd)) {
                ps.setInt(1, id);
                ps.executeUpdate();
            }

            try (PreparedStatement ps = con.prepareStatement(sqlCont)) {
                ps.setInt(1, id);
                ps.executeUpdate();
            }

            try (PreparedStatement ps = con.prepareStatement(sqlFunc)) {
                ps.setInt(1, id);
                ps.executeUpdate();
            }

        } catch (SQLException e) {
            System.out.println("Erro ao excluir funcionário -> " + e);
        }
    }

    public Funcionario buscarPorId(int id) {
        String sql = """
            SELECT * 
            FROM tb_funcionario f
            JOIN tb_cargo c ON f.id_cargo = c.id
            JOIN tb_departamento d ON c.id_departamento = d.id
            LEFT JOIN tb_endereco e ON f.id = e.id_funcionario
            LEFT JOIN tb_contato ct ON f.id = ct.id_funcionario
            WHERE f.id = ?
        """;

        Funcionario f = null;

        try (Connection con = Conexao.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    if (f == null) {
                        Departamento dep = new Departamento(
                            rs.getInt("d.id"),
                            rs.getString("d.nome")
                        );

                        Cargo cargo = new Cargo(
                            rs.getInt("c.id"),
                            rs.getString("c.nome"),
                            dep
                        );

                        f = new Funcionario();
                        f.setId(rs.getInt("f.id"));
                        f.setNome(rs.getString("f.nome"));
                        f.setSalario(rs.getDouble("f.salario"));

                        Date dataEntrada = rs.getDate("f.data_entrada");
                        if (dataEntrada != null) f.setDataEntrada(dataEntrada.toLocalDate());

                        Date dataSaida = rs.getDate("f.data_saida");
                        if (dataSaida != null) f.setDataSaida(dataSaida.toLocalDate());

                        f.setCargo(cargo);
                        f.setEnderecos(new ArrayList<>());
                        f.setContatos(new ArrayList<>());
                    }

                    int idEnd = rs.getInt("e.id");
                    if (!rs.wasNull()) {
                        Endereco e = new Endereco(
                            idEnd,
                            rs.getString("e.rua"),
                            rs.getString("e.numero"),
                            rs.getString("e.bairro"),
                            rs.getString("e.cep"),
                            rs.getString("e.cidade"),
                            rs.getString("e.estado"),
                            rs.getBoolean("e.ativo"),
                            f.getId()
                        );
                        f.getEnderecos().add(e);
                    }

                    int idCont = rs.getInt("ct.id");
                    if (!rs.wasNull()) {
                        Contato ctt = new Contato(
                            idCont,
                            rs.getString("ct.telefone"),
                            rs.getString("ct.email"),
                            rs.getBoolean("ct.ativo"),
                            f.getId()
                        );
                        f.getContatos().add(ctt);
                    }
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar funcionário -> " + e);
        }

        return f;
    }

    
}