/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.sistemarh.view;

import com.mycompany.sistemarh.dao.CargoDAO;
import com.mycompany.sistemarh.dao.DepartamentoDAO;
import com.mycompany.sistemarh.dao.FuncionarioDAO;
import com.mycompany.sistemarh.database.Conexao;
import com.mycompany.sistemarh.model.Cargo;
import com.mycompany.sistemarh.model.Contato;
import com.mycompany.sistemarh.model.Departamento;
import com.mycompany.sistemarh.model.Endereco;
import com.mycompany.sistemarh.model.Funcionario;
import com.mycompany.sistemarh.util.ConfiguraComponentes;
import com.mycompany.sistemarh.util.RelatorioUtil;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author Pichau
 */
public class Principal extends TelaBase {
    private static final DepartamentoDAO dDAO = new DepartamentoDAO();
    private static final CargoDAO cargoDAO = new CargoDAO();
    private static final FuncionarioDAO fDAO = new FuncionarioDAO();
    private Integer idDepartamentoEdicao = null;
    private Integer idCargoEdicao = null;
      

    public Principal() throws SQLException {
        initComponents();
        configurarTela16x9();
        configurarTabelas();
        configurarTabelaDepartamento();
        configurarPlaceholders();
        estilizarTabela(tblFuncionarios);
        estilizarTabela(tblDep);
        estilizarTabela(tblCargo);

        estilizarCabecalho(tblFuncionarios);
        estilizarCabecalho(tblDep);
        estilizarCabecalho(tblCargo);
        
        jScrollPane1.getViewport().setOpaque(false);
        jScrollPane2.getViewport().setOpaque(false);
        jScrollPane3.getViewport().setOpaque(false);

        
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
        btnCancelarCargo = new javax.swing.JButton();
        btnExcluirCargo = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCargo = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFuncionarios = new javax.swing.JTable();
        btnRegistrarFuncionarios = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnCancelarFuncionario = new javax.swing.JButton();
        btnDesligarFuncionario = new javax.swing.JButton();
        btnImprimirFuncionarios = new javax.swing.JButton();
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

        jPanel7.setPreferredSize(new java.awt.Dimension(1280, 720));

        jPanel9.setPreferredSize(new java.awt.Dimension(1280, 720));

        btnSalvarDep.setText("Salvar");
        btnSalvarDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarDepActionPerformed(evt);
            }
        });

        txtNomeDep.setBorder(null);
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
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDep.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDepMouseClicked(evt);
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

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setText("CADASTRAR DEPARTAMENTO");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(txtNomeDep, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(btnLimparDep, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSalvarDep, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(176, 741, Short.MAX_VALUE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCancelarDep, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExcluirDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(btnCancelarDep, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomeDep, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimparDep, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvarDep, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(btnExcluirDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 1305, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE)
        );

        paneDep.addTab("Departamento", jPanel7);

        btnSalvarCargo.setText("Salvar");
        btnSalvarCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarCargoActionPerformed(evt);
            }
        });

        txtNomeCargo.setBorder(null);
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

        cbxDepCargo.setBorder(null);

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

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setText("CADASTRAR CARGOS");

        tblCargo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Departamento ID", "Departamento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCargo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCargoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblCargo);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(txtNomeCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExcluirCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(cbxDepCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96)
                        .addComponent(btnLimparCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalvarCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 639, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelarCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
            .addComponent(jScrollPane3)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel6))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(btnCancelarCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(cbxDepCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLimparCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSalvarCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(txtNomeCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExcluirCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        paneDep.addTab("Cargo", jPanel3);

        tblFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Idade", "Salario", "Departamento", "Cargo", "Data Admissao", "Data Saida"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblFuncionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFuncionariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblFuncionarios);

        btnRegistrarFuncionarios.setText("Registrar novo");
        btnRegistrarFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarFuncionariosActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setText("FUNCIONÁRIOS");

        btnCancelarFuncionario.setText("Cancelar");
        btnCancelarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarFuncionarioActionPerformed(evt);
            }
        });

        btnDesligarFuncionario.setText("Desligar funcionário");
        btnDesligarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesligarFuncionarioActionPerformed(evt);
            }
        });

        btnImprimirFuncionarios.setText("Gerar relatório");
        btnImprimirFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirFuncionariosActionPerformed(evt);
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1305, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnImprimirFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegistrarFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDesligarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluirFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluirFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDesligarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrarFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnImprimirFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addComponent(paneDep, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarDepActionPerformed
        try {
            DepartamentoDAO dDAO = new DepartamentoDAO();

            String nome = txtNomeDep.getText();

            if (nome == null || nome.trim().isEmpty()) {
                JOptionPane.showMessageDialog(
                    this,
                    "O nome do departamento não pode estar vazio.",
                    "Validação",
                    JOptionPane.WARNING_MESSAGE
                );
                return; 
            }

            if (idDepartamentoEdicao == null) {
                //insert
                Departamento d = new Departamento();
                d.setNome(nome.trim());
                dDAO.inserir(d);
            } else {
                //update
                Departamento d = new Departamento(idDepartamentoEdicao, nome.trim());
                dDAO.atualizar(d);
            }

            carregarCombos();
            atualizarTabelaDep();
            limparCampos();
            idDepartamentoEdicao = null;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar departamento");
        }

    }//GEN-LAST:event_btnSalvarDepActionPerformed

    private void txtNomeDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeDepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeDepActionPerformed

    private void btnLimparDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparDepActionPerformed
        txtNomeDep.setText("");
        idDepartamentoEdicao = null;
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

    private void btnCancelarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarFuncionarioActionPerformed
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelarFuncionarioActionPerformed

    private void btnDesligarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesligarFuncionarioActionPerformed
        int linhaSelecionada = tblFuncionarios.getSelectedRow();

        if (linhaSelecionada >= 0) {

            int idFuncionario = (int) tblFuncionarios.getValueAt(linhaSelecionada, 0);
            int idUsuarioLogado = 1;

            int opcao = javax.swing.JOptionPane.showConfirmDialog(
                this,
                "Tem certeza que deseja desligar este funcionário?",
                "Confirmar desligamento",
                javax.swing.JOptionPane.YES_NO_OPTION
            );

            if (opcao == javax.swing.JOptionPane.YES_OPTION) {
                try {
                    fDAO.desligarFuncionario(idFuncionario, idUsuarioLogado);

                    javax.swing.JOptionPane.showMessageDialog(
                        this,
                        "Funcionário desligado com sucesso!"
                    );

                    atualizarTabelaFuncionario();
                    limparCampos();

                } catch (SQLException ex) {

                    if (ex.getMessage().contains("Funcionário já está desligado")) {
                        javax.swing.JOptionPane.showMessageDialog(
                            this,
                            "Este funcionário já está desligado.",
                            "Aviso",
                            javax.swing.JOptionPane.WARNING_MESSAGE
                        );
                    } else {
                        javax.swing.JOptionPane.showMessageDialog(
                            this,
                            "Erro ao desligar funcionário: " + ex.getMessage(),
                            "Erro",
                            javax.swing.JOptionPane.ERROR_MESSAGE
                        );
                    }
                }
            }

        } else {
            javax.swing.JOptionPane.showMessageDialog(
                this,
                "Selecione um funcionário para desligar!"
            );
        } 
    }//GEN-LAST:event_btnDesligarFuncionarioActionPerformed

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

    private void tblDepMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDepMouseClicked
        if (evt.getClickCount() != 2) return;

        int viewRow = tblDep.getSelectedRow();
        if (viewRow == -1) {
            viewRow = tblDep.rowAtPoint(evt.getPoint());
        }
        if (viewRow < 0) return;

        int modelRow = tblDep.convertRowIndexToModel(viewRow);

        Object idObj = tblDep.getModel().getValueAt(modelRow, 0);
        Object nomeObj = tblDep.getModel().getValueAt(modelRow, 1);

        if (idObj == null || nomeObj == null) return;

        try {
            int id = Integer.parseInt(idObj.toString());
            String nome = nomeObj.toString();

            // 🔴 LINHA QUE FALTAVA
            idDepartamentoEdicao = id;

            txtNomeDep.setText(nome);

            System.out.printf("Editando departamento id=%d nome=%s%n", id, nome);

        } catch (NumberFormatException ex) {
            System.out.println("Erro ao converter ID -> " + ex.getMessage());
        }
    }//GEN-LAST:event_tblDepMouseClicked

    private void tblFuncionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFuncionariosMouseClicked
        if (evt.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(evt)) {

            int viewRow = tblFuncionarios.getSelectedRow();

            if (viewRow == -1) {
                viewRow = tblFuncionarios.rowAtPoint(evt.getPoint());
            }

            if (viewRow < 0) return;

            int modelRow = tblFuncionarios.convertRowIndexToModel(viewRow);

            Object idObj = tblFuncionarios.getModel().getValueAt(modelRow, 0);

            if (idObj == null) {
                JOptionPane.showMessageDialog(this, "ID não encontrado na linha selecionada.");
                return;
            }

            int id = Integer.parseInt(idObj.toString());

            try {
                new RegistrarFuncionarios(this, id).setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Erro ao abrir o funcionário: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_tblFuncionariosMouseClicked

    private void btnImprimirFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirFuncionariosActionPerformed
        gerarRelatorio("rel_funcionarios");
    }//GEN-LAST:event_btnImprimirFuncionariosActionPerformed

    private void btnExcluirFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirFuncionarioActionPerformed
        int row = tblFuncionarios.getSelectedRow();

        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Selecione um funcionário.");
            return;
        }

        int id = (int) tblFuncionarios.getValueAt(row, 0);
        Object dataSaidaObj = tblFuncionarios.getValueAt(row, 6); // coluna data_saida

        if (dataSaidaObj == null) {
            JOptionPane.showMessageDialog(
                this,
                "Não é possível excluir um funcionário ativo.\n\nRealize o desligamento primeiro.",
                "Exclusão não permitida",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(
            this,
            "Deseja realmente excluir este funcionário?\nEssa ação é irreversível.",
            "Confirmar exclusão",
            JOptionPane.YES_NO_OPTION
        );

        if (confirm != JOptionPane.YES_OPTION) return;

        FuncionarioDAO dao = new FuncionarioDAO();
        dao.excluir(id);

        JOptionPane.showMessageDialog(this, "Funcionário excluído com sucesso.");
        try {
            atualizarTabelaFuncionario();
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExcluirFuncionarioActionPerformed

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

    private void btnCancelarCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarCargoActionPerformed
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelarCargoActionPerformed

    private void tblCargoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCargoMouseClicked
        if (evt.getClickCount() == 2) {
            int viewRow = tblCargo.getSelectedRow();
            if (viewRow == -1) viewRow = tblCargo.rowAtPoint(evt.getPoint());
            if (viewRow < 0) return;

            int modelRow = tblCargo.convertRowIndexToModel(viewRow);

            int id = (int) tblCargo.getModel().getValueAt(modelRow, 0);
            String nome = tblCargo.getModel().getValueAt(modelRow, 1).toString();
            int idDepartamento = (int) tblCargo.getModel().getValueAt(modelRow, 2);

            idCargoEdicao = id;

            txtNomeCargo.setText(nome);

            for (int i = 0; i < cbxDepCargo.getItemCount(); i++) {
                Departamento d = cbxDepCargo.getItemAt(i);
                if (d.getId() == idDepartamento) {
                    cbxDepCargo.setSelectedIndex(i);
                    break;
                }
            }
        }
    }//GEN-LAST:event_tblCargoMouseClicked

    private void btnLimparCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparCargoActionPerformed
        txtNomeCargo.setText("");
        cbxDepCargo.setSelectedIndex(0);
        idCargoEdicao = null;
    }//GEN-LAST:event_btnLimparCargoActionPerformed

    private void txtNomeCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeCargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeCargoActionPerformed

    private void btnSalvarCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarCargoActionPerformed
        try {
            CargoDAO cDAO = new CargoDAO();

            String nome = txtNomeCargo.getText();
            Departamento dep = (Departamento) cbxDepCargo.getSelectedItem();

            if (nome == null || nome.trim().isEmpty()) {
                JOptionPane.showMessageDialog(
                    this,
                    "O nome do cargo não pode estar vazio.",
                    "Validação",
                    JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            if (dep == null || dep.getId() == 0) {
                JOptionPane.showMessageDialog(
                    this,
                    "Selecione um departamento válido.",
                    "Validação",
                    JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            Cargo c = new Cargo();
            c.setNome(nome.trim());
            c.setDepartamento(dep);

            if (idCargoEdicao == null) {
                // INSERT
                cDAO.inserir(c);
            } else {
                // UPDATE
                c.setId(idCargoEdicao);
                cDAO.atualizar(c);
            }

            atualizarTabelaCargo();
            txtNomeCargo.setText("");
            cbxDepCargo.setSelectedIndex(0);
            idCargoEdicao = null;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar cargo: " + e.getMessage());
        }
    }//GEN-LAST:event_btnSalvarCargoActionPerformed

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
    private javax.swing.JButton btnDesligarFuncionario;
    private javax.swing.JButton btnExcluirCargo;
    private javax.swing.JButton btnExcluirDepartamento;
    private javax.swing.JButton btnExcluirFuncionario;
    private javax.swing.JButton btnImprimirFuncionarios;
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
 
    private void gerarRelatorio(String tipo) {
        try {
            Connection con = Conexao.getConnection();
            Map<String, Object> parametros = new HashMap<>();

            RelatorioUtil.abrirPDF(tipo, parametros, con);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
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
                f.getIdade(),
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
                c.getDepartamento().getId(),
                c.getDepartamento().getNome()
            });
        }
    }

    public void configurarTabelas() {

        // Renderers
        DefaultTableCellRenderer centro = new DefaultTableCellRenderer();
        centro.setHorizontalAlignment(SwingConstants.CENTER);

        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);

        // ================= FUNCIONÁRIOS =================
        configurarColuna(tblFuncionarios, 0, 15, centro);   // ID
        configurarColuna(tblFuncionarios, 1, 160, centro); // Nome
        configurarColuna(tblFuncionarios, 2, 80, centro);   // Idade
        configurarColuna(tblFuncionarios, 3, 100, centro);  // Salário
        configurarColuna(tblFuncionarios, 4, 140, centro);  // Departamento
        configurarColuna(tblFuncionarios, 5, 160, centro);  // Cargo
        configurarColuna(tblFuncionarios, 6, 120, centro);  // Data admissão
        configurarColuna(tblFuncionarios, 7, 120, centro);  // Data saída

        // ================= DEPARTAMENTO =================
        configurarColuna(tblDep, 0, 15, centro);     // ID
        configurarColuna(tblDep, 1, 220, centro);  // Nome

        // ================= CARGO =================
        configurarColuna(tblCargo, 0, 15, centro);     // ID
        configurarColuna(tblCargo, 1, 220, centro);  // Nome
        configurarColuna(tblCargo, 2, 15, centro);    // Departamento ID
        configurarColuna(tblCargo, 3, 220, centro);  // Nome
    }
    
    private void configurarColuna(JTable tabela, int indice, int largura, TableCellRenderer renderer) {
        TableColumn coluna = tabela.getColumnModel().getColumn(indice);
        coluna.setPreferredWidth(largura);
        coluna.setMinWidth(largura);
        coluna.setCellRenderer(renderer);
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
    
    private void estilizarCabecalho(JTable tabela) {
        JTableHeader header = tabela.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 13));
        header.setPreferredSize(new Dimension(header.getWidth(), 36));
    }


    private void estilizarTabela(JTable tabela) {

        tabela.setShowGrid(false);
        tabela.setRowHeight(32);
        tabela.setIntercellSpacing(new Dimension(0, 0));
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        tabela.putClientProperty("Table.alternateRowColor", true);
        tabela.putClientProperty("Table.showHorizontalLines", false);
        tabela.putClientProperty("Table.showVerticalLines", false);

        tabela.getTableHeader().setReorderingAllowed(false);
        tabela.getTableHeader().setResizingAllowed(true);

        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    }

    private void configurarTabelaDepartamento() {

        DefaultTableCellRenderer centro = new DefaultTableCellRenderer();
        centro.setHorizontalAlignment(SwingConstants.CENTER);

        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);

        TableColumn colId = tblDep.getColumnModel().getColumn(0);
        colId.setMinWidth(60);
        colId.setMaxWidth(60);
        colId.setPreferredWidth(60);
        colId.setCellRenderer(centro);

        TableColumn colNome = tblDep.getColumnModel().getColumn(1);
        colNome.setPreferredWidth(600);
        colNome.setCellRenderer(centro);
    }

    private void configurarPlaceholders() {
        ConfiguraComponentes ui = new ConfiguraComponentes();

        // Departamento
        ui.configCampoTexto(txtNomeDep, " Nome do departamento");

        // Cargo
        ui.configCampoTexto(txtNomeCargo, " Nome do cargo");
    }

    
}
