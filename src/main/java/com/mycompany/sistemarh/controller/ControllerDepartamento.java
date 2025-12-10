/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemarh.controller;

import com.mycompany.sistemarh.dao.DepartamentoDAO;
import com.mycompany.sistemarh.model.Departamento;

/**
 *
 * @author Pichau
 */
public class ControllerDepartamento {
    private DepartamentoDAO dao;

    public ControllerDepartamento() {
        dao = new DepartamentoDAO();
    }

    public void excluirDepartamento(int id) {
        dao.excluir(id);
    }
    
    public void atualizarDepartamento(Departamento d) {
        //o nome não pode ser vazio
        if (d.getNome() != null && !d.getNome().isBlank()) {
            dao.atualizar(d);
        } else {
            System.out.println("Erro: O nome do departamento não pode estar vazio.");
        }
    }
}
