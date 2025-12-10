/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemarh.controller;

import com.mycompany.sistemarh.dao.CargoDAO;
import com.mycompany.sistemarh.model.Cargo;
import java.util.List;

/**
 *
 * @author Pichau
 */
public class ControllerCargo {
    private CargoDAO dao;

    public ControllerCargo() {
        this.dao = new CargoDAO();
    }
    
    public void cadastrarCargo(Cargo c) {
        if (c.getNome() != null && !c.getNome().isBlank() && c.getDepartamento() != null) {
            dao.inserir(c);
        } else {
            System.out.println("Erro: Dados do cargo inválidos (Nome ou Departamento faltando).");
        }
    }
    
    public void excluirCargo(int id) {
        dao.excluir(id);
    }
    
    public void atualizarCargo(Cargo c) {
        if (c.getId() > 0 && c.getNome() != null && !c.getNome().isBlank()) {
            dao.atualizar(c);
        } else {
            System.out.println("Erro: Dados inválidos para atualização.");
        }
    }
    
    public List<Cargo> listarCargos() {
        return dao.listar();
    }
    
    public List<Cargo> listarPorDepartamento(int idDepartamento) {
        return dao.listarPorDepartamento(idDepartamento);
    }
}
