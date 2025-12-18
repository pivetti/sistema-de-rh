    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemarh.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Funcionario {

    private int id;
    private String nome;
    private int idade;
    private double salario;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    

    private Cargo cargo;
    private List<Endereco> enderecos;  
    private List<Contato> contatos;    

    public Funcionario() {
        enderecos = new ArrayList<>();
        contatos = new ArrayList<>();
    }

    public Funcionario(int id, String nome, int idade, double salario, LocalDate dataEntrada, LocalDate dataSaida,
                       Cargo cargo) {
        this();
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.salario = salario;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.cargo = cargo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }

    public Endereco getEnderecoAtivo() {
        for (Endereco e : enderecos) {
            if (e.isAtivo()) return e;
        }
        return null;
    }

    public Contato getContatoAtivo() {
        for (Contato c : contatos) {
            if (c.isAtivo()) return c;
        }
        return null;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "id=" + id + ", nome=" + nome + ", idade=" + idade + ", salario=" + salario + ", dataEntrada=" + dataEntrada + ", dataSaida=" + dataSaida + ", cargo=" + cargo + ", enderecos=" + enderecos + ", contatos=" + contatos + '}';
    }

    

}

