/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.sistemarh.view;

import com.mycompany.sistemarh.dao.CargoDAO;
import com.mycompany.sistemarh.dao.DepartamentoDAO;
import com.mycompany.sistemarh.dao.FuncionarioDAO;
import com.mycompany.sistemarh.model.Cargo;
import com.mycompany.sistemarh.model.Contato;
import com.mycompany.sistemarh.model.Departamento;
import com.mycompany.sistemarh.model.Endereco;
import com.mycompany.sistemarh.model.Funcionario;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pichau
 */
public class Principal extends javax.swing.JFrame {
    private static final DepartamentoDAO dDAO = new DepartamentoDAO();
    private static final CargoDAO cargoDAO = new CargoDAO();
    private static final FuncionarioDAO fDAO = new FuncionarioDAO();
      

    public Principal() throws SQLException {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(this);
        carregarCombos();
        atualizarTabelaCargo();
        atualizarTabelaDep();
        atualizarTabelaFuncionario();
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        paneDep = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        btnSalvarDep = new javax.swing.JButton();
        txtNomeDep = new javax.swing.JTextField();
        btnLimparDep = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDep = new javax.swing.JTable();
        btnCancelarDep = new javax.swing.JButton();
        btnExcluirDepartamento = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btnSalvarCargo = new javax.swing.JButton();
        txtNomeCargo = new javax.swing.JTextField();
        btnLimparCargo = new javax.swing.JButton();
        cbxDepCargo = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCargo = new javax.swing.JTable();
        btnCancelarCargo = new javax.swing.JButton();
        btnExcluirCargo = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFuncionarios = new javax.swing.JTable();
        btnRegistrarFuncionarios = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnCancelarFuncionario = new javax.swing.JButton();
        btnExcluirFuncionario = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setForeground(new java.awt.Color(255, 255, 255));

        btnSalvarDep.setText("Salvar");
        btnSalvarDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarDepActionPerformed(evt);
            }
        });

        txtNomeDep.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome:"));
        txtNomeDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeDepActionPerformed(evt);
            }
        });

        btnLimparDep.setText("Limpar");
        btnLimparDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparDepActionPerformed(evt);
            }
        });

        tblDep.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblDep);

        btnCancelarDep.setText("Cancelar");
        btnCancelarDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarDepActionPerformed(evt);
            }
        });

        btnExcluirDepartamento.setText("Excluir");
        btnExcluirDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirDepartamentoActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel7.setText("Departamentos");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(txtNomeDep, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(btnLimparDep, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalvarDep, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(692, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnExcluirDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCancelarDep, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelarDep)
                    .addComponent(jLabel7))
                .addGap(81, 81, 81)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNomeDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnSalvarDep, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnLimparDep, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(154, 154, 154)
                .addComponent(btnExcluirDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(343, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        paneDep.addTab("Departamento", jPanel7);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setForeground(new java.awt.Color(255, 255, 255));

        btnSalvarCargo.setText("Salvar");
        btnSalvarCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarCargoActionPerformed(evt);
            }
        });

        txtNomeCargo.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome:"));
        txtNomeCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeCargoActionPerformed(evt);
            }
        });

        btnLimparCargo.setText("Limpar");
        btnLimparCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparCargoActionPerformed(evt);
            }
        });

        cbxDepCargo.setBorder(javax.swing.BorderFactory.createTitledBorder("Departamento:"));

        tblCargo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Departamento ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblCargo);

        btnCancelarCargo.setText("Cancelar");
        btnCancelarCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarCargoActionPerformed(evt);
            }
        });

        btnExcluirCargo.setText("Excluir");
        btnExcluirCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirCargoActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel6.setText("Cargos");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1272, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExcluirCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCancelarCargo)
                                .addGap(9, 9, 9))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtNomeCargo, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxDepCargo, javax.swing.GroupLayout.Alignment.LEADING, 0, 297, Short.MAX_VALUE))
                                .addGap(133, 133, 133)
                                .addComponent(btnLimparCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(btnSalvarCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel6)
                        .addGap(57, 57, 57)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxDepCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLimparCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSalvarCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(btnCancelarCargo)))
                .addGap(18, 18, 18)
                .addComponent(txtNomeCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96)
                .addComponent(btnExcluirCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(195, 195, 195))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 1042, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        paneDep.addTab("Cargo", jPanel3);

        tblFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Salario", "Departamento", "Cargo", "Data Admissao", "Data Saida"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblFuncionarios);

        btnRegistrarFuncionarios.setText("Registrar novo");
        btnRegistrarFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarFuncionariosActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel5.setText("Colaboradores");

        btnCancelarFuncionario.setText("Cancelar");
        btnCancelarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarFuncionarioActionPerformed(evt);
            }
        });

        btnExcluirFuncionario.setText("Excluir");
        btnExcluirFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirFuncionarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1266, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnRegistrarFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluirFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelarFuncionario)))
                .addGap(30, 30, 30))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(btnCancelarFuncionario)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 241, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluirFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrarFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        paneDep.addTab("Funcionarios", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paneDep)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paneDep, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 851, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarCargoActionPerformed

        String nome = txtNomeCargo.getText();
               
        if (nome.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos obrigatórios.");
            return;
        }

        try {
            Departamento dep = (Departamento) cbxDepCargo.getSelectedItem();
            if (dep == null) {
                JOptionPane.showMessageDialog(this, "Selecione um departamento!");
                return;
            }

            Cargo c = new Cargo();
            c.setNome(txtNomeCargo.getText());
            c.setDepartamento(dep);

            cargoDAO.inserir(c);

            JOptionPane.showMessageDialog(this, "Cargo cadastrado com sucesso!");
            atualizarTabelaFuncionario();
            atualizarTabelaCargo();
            limparCampos();
            carregarCombos();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Salário inválido. Digite um número válido.");
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSalvarCargoActionPerformed

    private void txtNomeCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeCargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeCargoActionPerformed

    private void btnSalvarDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarDepActionPerformed

        String nome = txtNomeDep.getText();
               
        if (nome.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Informe um departamento.");
            return;
        }

        try {
            Departamento d = new Departamento(0, nome);
            dDAO.inserir(d);
            JOptionPane.showMessageDialog(this, "Departamento cadastrado com sucesso!");
            atualizarTabelaFuncionario();
            atualizarTabelaDep();
            limparCampos();
            carregarCombos();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Salário inválido. Digite um número válido.");
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSalvarDepActionPerformed

    private void txtNomeDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeDepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeDepActionPerformed

    private void btnLimparCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparCargoActionPerformed
        txtNomeCargo.setText("");
        cbxDepCargo.setSelectedIndex(0);
    }//GEN-LAST:event_btnLimparCargoActionPerformed

    private void btnLimparDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparDepActionPerformed
        txtNomeDep.setText("");
    }//GEN-LAST:event_btnLimparDepActionPerformed

    private void btnRegistrarFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarFuncionariosActionPerformed
        try {
            RegistrarFuncionarios tela = new RegistrarFuncionarios(this);
            tela.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRegistrarFuncionariosActionPerformed

    private void btnCancelarDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarDepActionPerformed
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelarDepActionPerformed

    private void btnCancelarCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarCargoActionPerformed
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelarCargoActionPerformed

    private void btnCancelarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarFuncionarioActionPerformed
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelarFuncionarioActionPerformed

    private void btnExcluirFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirFuncionarioActionPerformed
        int linhaSelecionada = tblFuncionarios.getSelectedRow();
        if (linhaSelecionada >= 0) {
            
            int idFuncionario = (int) tblFuncionarios.getValueAt(linhaSelecionada, 0);
            fDAO.excluir(idFuncionario);

            try {
                atualizarTabelaFuncionario();
            } catch (SQLException ex) {
                ex.printStackTrace();
                javax.swing.JOptionPane.showMessageDialog(this, "Erro ao atualizar tabela: " + ex.getMessage());
            }
            limparCampos();
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Selecione um funcionário para excluir!");
        } 
    }//GEN-LAST:event_btnExcluirFuncionarioActionPerformed

    private void btnExcluirDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirDepartamentoActionPerformed
        int linhaSelecionada = tblDep.getSelectedRow();
        if (linhaSelecionada >= 0) {
            
            int id = (int) tblDep.getValueAt(linhaSelecionada, 0);

            dDAO.excluir(id);

            try {
                atualizarTabelaDep();
                carregarCombos();
            } catch (SQLException ex) {
                ex.printStackTrace();
                javax.swing.JOptionPane.showMessageDialog(this, "Erro ao atualizar tabela: " + ex.getMessage());
            }
            limparCampos();
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Selecione um departamento para excluir!");
        } 
    }//GEN-LAST:event_btnExcluirDepartamentoActionPerformed

    private void btnExcluirCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirCargoActionPerformed
        int linhaSelecionada = tblCargo.getSelectedRow();
        if (linhaSelecionada >= 0) {
            int id = (int) tblCargo.getValueAt(linhaSelecionada, 0);

            cargoDAO.excluir(id);
            
            try {
                atualizarTabelaCargo();
            } catch (SQLException ex) {
                ex.printStackTrace();
                javax.swing.JOptionPane.showMessageDialog(this, "Erro ao atualizar tabela: " + ex.getMessage());
            }
            limparCampos();
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Selecione um cargo para excluir!");
        } 
    }//GEN-LAST:event_btnExcluirCargoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Principal().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarCargo;
    private javax.swing.JButton btnCancelarDep;
    private javax.swing.JButton btnCancelarFuncionario;
    private javax.swing.JButton btnExcluirCargo;
    private javax.swing.JButton btnExcluirDepartamento;
    private javax.swing.JButton btnExcluirFuncionario;
    private javax.swing.JButton btnLimparCargo;
    private javax.swing.JButton btnLimparDep;
    private javax.swing.JButton btnRegistrarFuncionarios;
    private javax.swing.JButton btnSalvarCargo;
    private javax.swing.JButton btnSalvarDep;
    private javax.swing.JComboBox<Departamento> cbxDepCargo;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane paneDep;
    private javax.swing.JTable tblCargo;
    private javax.swing.JTable tblDep;
    private javax.swing.JTable tblFuncionarios;
    private javax.swing.JTextField txtNomeCargo;
    private javax.swing.JTextField txtNomeDep;
    // End of variables declaration//GEN-END:variables
 
    public void atualizarTabelaFuncionario() throws SQLException {
        DefaultTableModel tabela = (DefaultTableModel) tblFuncionarios.getModel();
        tabela.setRowCount(0);

        FuncionarioDAO fDAO = new FuncionarioDAO();

        for (Funcionario f : fDAO.listar()) {

            Endereco end = f.getEnderecoAtivo();
            Contato cont = f.getContatoAtivo();

            tabela.addRow(new Object[]{
                f.getId(),
                f.getNome(),
                f.getSalario(),
                f.getCargo().getDepartamento().getNome(),
                f.getCargo().getNome(),
                f.getDataEntrada(),
                f.getDataSaida(),

                //endereco ativo
                end != null ? end.getRua() : "",
                end != null ? end.getNumero() : "",
                end != null ? end.getBairro() : "",
                end != null ? end.getCidade() : "",
                end != null ? end.getEstado() : "",
                end != null ? end.getCep() : "",

                //contato ativo
                cont != null ? cont.getTelefone() : "",
                cont != null ? cont.getEmail() : ""
            });
        }
    }
    
    public void atualizarTabelaDep() throws SQLException {
        DefaultTableModel tabela = (DefaultTableModel) tblDep.getModel();
        tabela.setRowCount(0); 

        DepartamentoDAO dDAO = new DepartamentoDAO();
        for (Departamento d : dDAO.listar()) {
            tabela.addRow(new Object[]{
                d.getId(),
                d.getNome(),
            });
        }
    }
    
    public void atualizarTabelaCargo() throws SQLException {
        DefaultTableModel tabela = (DefaultTableModel) tblCargo.getModel();
        tabela.setRowCount(0); 

        CargoDAO cDAO = new CargoDAO();
        for (Cargo c : cDAO.listar()) {
            tabela.addRow(new Object[]{
                c.getId(),
                c.getNome(),
                c.getDepartamento().getId()
            });
        }
    }

    public void configurarTabelas() {
        tblFuncionarios.getColumnModel().getColumn(0).setPreferredWidth(25); 
        tblFuncionarios.getColumnModel().getColumn(1).setPreferredWidth(120); 
        tblFuncionarios.getColumnModel().getColumn(2).setPreferredWidth(80); 
        tblFuncionarios.getColumnModel().getColumn(3).setPreferredWidth(100); 
        tblFuncionarios.getColumnModel().getColumn(4).setPreferredWidth(200); 
        tblFuncionarios.getColumnModel().getColumn(5).setPreferredWidth(100); 
        tblFuncionarios.getColumnModel().getColumn(6).setPreferredWidth(100); 


        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        tblFuncionarios.getColumnModel().getColumn(0).setCellRenderer(esquerda);
        
        tblDep.getColumnModel().getColumn(0).setPreferredWidth(25); 
        tblDep.getColumnModel().getColumn(1).setPreferredWidth(120); 
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        tblDep.getColumnModel().getColumn(0).setCellRenderer(esquerda);

        tblCargo.getColumnModel().getColumn(0).setPreferredWidth(25); 
        tblCargo.getColumnModel().getColumn(1).setPreferredWidth(120); 
        tblCargo.getColumnModel().getColumn(2).setPreferredWidth(80); 
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        tblCargo.getColumnModel().getColumn(0).setCellRenderer(esquerda);
    }

    private void limparCampos() {
        txtNomeDep.setText("");
        txtNomeCargo.setText("");
    }
    
    private void carregarCombos() throws SQLException {
        cbxDepCargo.removeAllItems();

        cbxDepCargo.addItem(new Departamento(0, "Selecione"));
        for (Departamento d : dDAO.listar()) {
            cbxDepCargo.addItem(d);
        }
    }


    
}
