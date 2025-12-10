/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemarh.controller;

import com.mycompany.sistemarh.dao.FuncionarioDAO;
import com.mycompany.sistemarh.model.Funcionario;

/**
 *
 * @author Pichau
 */
public class ControllerFuncionario {

    private FuncionarioDAO dao;

    public ControllerFuncionario() {
        dao = new FuncionarioDAO();
    }
    
    
    public void atualizarFuncionario(Funcionario f) {
        dao.atualizar(f);
    }

    public void excluirFuncionario(int id) {
        dao.excluir(id);
    }
}
