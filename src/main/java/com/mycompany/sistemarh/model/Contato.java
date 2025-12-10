/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemarh.model;

/**
 *
 * @author Pichau
 */
public class Contato {

    private int id;
    private String telefone;
    private String email;
    private boolean ativo;        
    private int idFuncionario;

    public Contato() {}

    public Contato(int id, String telefone, String email, boolean ativo, int idFuncionario) {
        this.id = id;
        this.telefone = telefone;
        this.email = email;
        this.ativo = ativo;
        this.idFuncionario = idFuncionario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    @Override
    public String toString() {
        return "Contato{" + "id=" + id + ", telefone=" + telefone + ", email=" + email + ", ativo=" + ativo + ", idFuncionario=" + idFuncionario + '}';
    }

    

}
