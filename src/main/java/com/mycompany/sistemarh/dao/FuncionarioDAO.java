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
import java.util.HashMap;
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
    
    
    
    
    

    public void atualizar(Funcionario f) throws SQLException {
        String sqlUpdateFunc = "UPDATE tb_funcionario SET nome = ?, salario = ?, data_entrada = ?, data_saida = ?, id_cargo = ? WHERE id = ?";

        Connection con = null;
        try {
            con = Conexao.getConnection();
            con.setAutoCommit(false);

            // 1) Atualiza funcionário
            try (PreparedStatement ps = con.prepareStatement(sqlUpdateFunc)) {
                ps.setString(1, f.getNome());
                ps.setDouble(2, f.getSalario());
                ps.setDate(3, Date.valueOf(f.getDataEntrada()));
                if (f.getDataSaida() != null) ps.setDate(4, Date.valueOf(f.getDataSaida())); else ps.setNull(4, Types.DATE);
                ps.setInt(5, f.getCargo().getId());
                ps.setInt(6, f.getId());
                ps.executeUpdate();
            }

            int idFunc = f.getId();

            // 2) Sincronizar ENDEREÇOS (DELETE de removidos, UPDATE de existentes, INSERT de novos)

            // ids atuais enviados pelo cliente
            List<Integer> endsAtuaisIds = new ArrayList<>();
            for (Endereco e : f.getEnderecos()) if (e.getId() > 0) endsAtuaisIds.add(e.getId());

            // ids no BD
            List<Integer> idsNoBD = new ArrayList<>();
            String selEnds = "SELECT id FROM tb_endereco WHERE id_funcionario = ?";
            try (PreparedStatement ps = con.prepareStatement(selEnds)) {
                ps.setInt(1, idFunc);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) idsNoBD.add(rs.getInt("id"));
                }
            }

            // deletes = idsNoBD - endsAtuaisIds
            for (Integer idBd : idsNoBD) {
                if (!endsAtuaisIds.contains(idBd)) {
                    try (PreparedStatement ps = con.prepareStatement("DELETE FROM tb_endereco WHERE id = ?")) {
                        ps.setInt(1, idBd);
                        ps.executeUpdate();
                    }
                }
            }

            // garantir unicidade do ativo: se existe algum ativo na lista, desativa todos antes
            boolean existeAtivo = f.getEnderecos().stream().anyMatch(Endereco::isAtivo);
            if (existeAtivo) {
                try (PreparedStatement ps = con.prepareStatement("UPDATE tb_endereco SET ativo = FALSE WHERE id_funcionario = ?")) {
                    ps.setInt(1, idFunc);
                    ps.executeUpdate();
                }
            }

            // inserir / atualizar
            for (Endereco e : f.getEnderecos()) {
                if (e.getId() == 0) {
                    String ins = "INSERT INTO tb_endereco (rua, numero, bairro, cep, cidade, estado, id_funcionario, ativo) VALUES (?,?,?,?,?,?,?,?) RETURNING id";
                    try (PreparedStatement ps = con.prepareStatement(ins)) {
                        ps.setString(1, e.getRua());
                        ps.setString(2, e.getNumero());
                        ps.setString(3, e.getBairro());
                        ps.setString(4, e.getCep());
                        ps.setString(5, e.getCidade());
                        ps.setString(6, e.getEstado());
                        ps.setInt(7, idFunc);
                        ps.setBoolean(8, e.isAtivo());
                        try (ResultSet rs = ps.executeQuery()) {
                            if (rs.next()) e.setId(rs.getInt(1));
                        }
                    }
                } else {
                    String upd = "UPDATE tb_endereco SET rua=?, numero=?, bairro=?, cep=?, cidade=?, estado=?, ativo=? WHERE id=?";
                    try (PreparedStatement ps = con.prepareStatement(upd)) {
                        ps.setString(1, e.getRua());
                        ps.setString(2, e.getNumero());
                        ps.setString(3, e.getBairro());
                        ps.setString(4, e.getCep());
                        ps.setString(5, e.getCidade());
                        ps.setString(6, e.getEstado());
                        ps.setBoolean(7, e.isAtivo());
                        ps.setInt(8, e.getId());
                        ps.executeUpdate();
                    }
                }
            }

            // 3) Mesma lógica para CONTATOS
            List<Integer> contAtuaisIds = new ArrayList<>();
            for (Contato c : f.getContatos()) if (c.getId() > 0) contAtuaisIds.add(c.getId());

            List<Integer> idsContBD = new ArrayList<>();
            String selCont = "SELECT id FROM tb_contato WHERE id_funcionario = ?";
            try (PreparedStatement ps = con.prepareStatement(selCont)) {
                ps.setInt(1, idFunc);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) idsContBD.add(rs.getInt("id"));
                }
            }

            for (Integer idBd : idsContBD) {
                if (!contAtuaisIds.contains(idBd)) {
                    try (PreparedStatement ps = con.prepareStatement("DELETE FROM tb_contato WHERE id = ?")) {
                        ps.setInt(1, idBd);
                        ps.executeUpdate();
                    }
                }
            }

            boolean existeAtivoCont = f.getContatos().stream().anyMatch(Contato::isAtivo);
            if (existeAtivoCont) {
                try (PreparedStatement ps = con.prepareStatement("UPDATE tb_contato SET ativo = FALSE WHERE id_funcionario = ?")) {
                    ps.setInt(1, idFunc);
                    ps.executeUpdate();
                }
            }

            for (Contato c : f.getContatos()) {
                if (c.getId() == 0) {
                    String ins = "INSERT INTO tb_contato (telefone, email, id_funcionario, ativo) VALUES (?,?,?,?) RETURNING id";
                    try (PreparedStatement ps = con.prepareStatement(ins)) {
                        ps.setString(1, c.getTelefone());
                        ps.setString(2, c.getEmail());
                        ps.setInt(3, idFunc);
                        ps.setBoolean(4, c.isAtivo());
                        try (ResultSet rs = ps.executeQuery()) {
                            if (rs.next()) c.setId(rs.getInt(1));
                        }
                    }
                } else {
                    String upd = "UPDATE tb_contato SET telefone=?, email=?, ativo=? WHERE id=?";
                    try (PreparedStatement ps = con.prepareStatement(upd)) {
                        ps.setString(1, c.getTelefone());
                        ps.setString(2, c.getEmail());
                        ps.setBoolean(3, c.isAtivo());
                        ps.setInt(4, c.getId());
                        ps.executeUpdate();
                    }
                }
            }

            con.commit();
        } catch (SQLException ex) {
            if (con != null) try { con.rollback(); } catch (SQLException e) { /* ignore */ }
            throw ex;
        } finally {
            if (con != null) try { con.setAutoCommit(true); con.close(); } catch (SQLException e) { /* ignore */ }
        }
    }

    public Funcionario buscarPorId(int id) {
        String sql = """
            SELECT 
                f.id AS func_id, f.nome AS func_nome, f.salario, f.data_entrada, f.data_saida,
                c.id AS cargo_id, c.nome AS cargo_nome,
                d.id AS dep_id, d.nome AS dep_nome
            FROM tb_funcionario f
            JOIN tb_cargo c ON f.id_cargo = c.id
            JOIN tb_departamento d ON c.id_departamento = d.id
            WHERE f.id = ?
        """;

        Funcionario f = null;

        try (Connection con = Conexao.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Departamento dep = new Departamento(rs.getInt("dep_id"), rs.getString("dep_nome"));
                    Cargo cargo = new Cargo(rs.getInt("cargo_id"), rs.getString("cargo_nome"), dep);

                    f = new Funcionario();
                    f.setId(rs.getInt("func_id"));
                    f.setNome(rs.getString("func_nome"));
                    f.setSalario(rs.getDouble("salario"));
                    Date d1 = rs.getDate("data_entrada");
                    if (d1 != null) f.setDataEntrada(d1.toLocalDate());
                    Date d2 = rs.getDate("data_saida");
                    if (d2 != null) f.setDataSaida(d2.toLocalDate());
                    f.setCargo(cargo);
                }
            }

            if (f != null) {
                // carregar endereços
                String sqlEnd = "SELECT id, rua, numero, bairro, cep, cidade, estado, ativo FROM tb_endereco WHERE id_funcionario = ?";
                try (PreparedStatement ps2 = con.prepareStatement(sqlEnd)) {
                    ps2.setInt(1, id);
                    try (ResultSet rs2 = ps2.executeQuery()) {
                        List<Endereco> ends = new ArrayList<>();
                        while (rs2.next()) {
                            Endereco e = new Endereco(
                                rs2.getInt("id"),
                                rs2.getString("rua"),
                                rs2.getString("numero"),
                                rs2.getString("bairro"),
                                rs2.getString("cep"),
                                rs2.getString("cidade"),
                                rs2.getString("estado"),
                                rs2.getBoolean("ativo"),
                                id
                            );
                            ends.add(e);
                        }
                        f.setEnderecos(ends);
                    }
                }

                // carregar contatos
                String sqlCont = "SELECT id, telefone, email, ativo FROM tb_contato WHERE id_funcionario = ?";
                try (PreparedStatement ps3 = con.prepareStatement(sqlCont)) {
                    ps3.setInt(1, id);
                    try (ResultSet rs3 = ps3.executeQuery()) {
                        List<Contato> conts = new ArrayList<>();
                        while (rs3.next()) {
                            Contato ctt = new Contato(
                                rs3.getInt("id"),
                                rs3.getString("telefone"),
                                rs3.getString("email"),
                                rs3.getBoolean("ativo"),
                                id
                            );
                            conts.add(ctt);
                        }
                        f.setContatos(conts);
                    }
                }
            }

        } catch (SQLException ex) {
            System.out.println("Erro buscarPorId -> " + ex);
        }

        return f;
    }


    
}