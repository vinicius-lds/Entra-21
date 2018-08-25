package br.com.proway.view;

import br.com.proway.bean.ContatosBean;
import br.com.proway.bean.EnderecosBean;
import br.com.proway.controller.ControllerUsuario;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 * @author Vinícius Luis da Silva
 */
public class Usuario extends javax.swing.JFrame {

    private ControllerUsuario controller;
    
    public Usuario() {
        initComponents();
        this.controller = new ControllerUsuario(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        lbl_cliente = new javax.swing.JLabel();
        btn_deletar = new javax.swing.JButton();
        btn_editar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        list_contatos = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        list_enderecos = new javax.swing.JList<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btn_adcEndereco = new javax.swing.JButton();
        btn_adcContato = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        tf_nomeFuncionario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cb_sexoFuncionario = new javax.swing.JComboBox<>();
        tf_nascFuncionario = new javax.swing.JFormattedTextField();
        cb_cargoFuncionario = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        btn_cadastrarFuncionario = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_funcionarios = new javax.swing.JTable();
        btn_salvarFuncionario = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        tf_nomeCliente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cb_sexoCliente = new javax.swing.JComboBox<>();
        tf_nascCliente = new javax.swing.JFormattedTextField();
        btn_cadastrarCliente = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_clientes = new javax.swing.JTable();
        btn_salvarCliente = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        tf_cargo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btn_cadastrarCargo = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tb_cargos = new javax.swing.JTable();
        tf_salario = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_deletar.setText("Deletar");
        btn_deletar.setEnabled(false);
        btn_deletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deletarActionPerformed(evt);
            }
        });

        btn_editar.setText("Editar");
        btn_editar.setEnabled(false);
        btn_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarActionPerformed(evt);
            }
        });

        list_contatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                list_contatosMouseClicked(evt);
            }
        });
        list_contatos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                list_contatosKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(list_contatos);

        list_enderecos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                list_enderecosMouseClicked(evt);
            }
        });
        list_enderecos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                list_enderecosKeyPressed(evt);
            }
        });
        jScrollPane4.setViewportView(list_enderecos);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Enderecos");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Contatos");

        btn_adcEndereco.setText("Adicionar Endereço");
        btn_adcEndereco.setEnabled(false);
        btn_adcEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_adcEnderecoActionPerformed(evt);
            }
        });

        btn_adcContato.setText("AdicionarContato");
        btn_adcContato.setEnabled(false);
        btn_adcContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_adcContatoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_adcContato)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_adcEndereco)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_editar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_deletar))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane3))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_deletar)
                    .addComponent(btn_editar)
                    .addComponent(btn_adcEndereco)
                    .addComponent(btn_adcContato))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Principal", jPanel3);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Nome");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Sexo");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Data de Nascimento");
        jLabel3.setToolTipText("");

        cb_sexoFuncionario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino" }));

        try {
            tf_nascFuncionario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Cargo");

        btn_cadastrarFuncionario.setText("Cadastrar");
        btn_cadastrarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cadastrarFuncionarioActionPerformed(evt);
            }
        });

        tb_funcionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Cargo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_funcionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_funcionariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_funcionarios);
        if (tb_funcionarios.getColumnModel().getColumnCount() > 0) {
            tb_funcionarios.getColumnModel().getColumn(0).setMinWidth(50);
            tb_funcionarios.getColumnModel().getColumn(0).setPreferredWidth(50);
            tb_funcionarios.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        btn_salvarFuncionario.setText("Salvar Alterações");
        btn_salvarFuncionario.setEnabled(false);
        btn_salvarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salvarFuncionarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_cadastrarFuncionario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_salvarFuncionario)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tf_nomeFuncionario)
                                    .addComponent(tf_nascFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)))
                            .addComponent(cb_cargoFuncionario, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_sexoFuncionario, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tf_nomeFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cb_sexoFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tf_nascFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_cargoFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cadastrarFuncionario)
                    .addComponent(btn_salvarFuncionario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Funcionarios", jPanel1);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Nome");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Sexo");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Data de Nascimento");
        jLabel7.setToolTipText("");

        cb_sexoCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino" }));

        try {
            tf_nascCliente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btn_cadastrarCliente.setText("Cadastrar");
        btn_cadastrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cadastrarClienteActionPerformed(evt);
            }
        });

        tb_clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class
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
        tb_clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_clientesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb_clientes);
        if (tb_clientes.getColumnModel().getColumnCount() > 0) {
            tb_clientes.getColumnModel().getColumn(0).setMinWidth(50);
            tb_clientes.getColumnModel().getColumn(0).setPreferredWidth(50);
            tb_clientes.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        btn_salvarCliente.setText("Salvar Alterações");
        btn_salvarCliente.setEnabled(false);
        btn_salvarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salvarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cb_sexoCliente, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(btn_cadastrarCliente)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btn_salvarCliente))
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tf_nomeCliente)
                                        .addComponent(tf_nascCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE))))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tf_nomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cb_sexoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tf_nascCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cadastrarCliente)
                    .addComponent(btn_salvarCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Clientes", jPanel2);

        tf_cargo.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Cargo");

        btn_cadastrarCargo.setText("Cadastrar");
        btn_cadastrarCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cadastrarCargoActionPerformed(evt);
            }
        });

        tb_cargos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cargo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_cargos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_cargosMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tb_cargos);

        tf_salario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_salario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_salarioKeyTyped(evt);
            }
        });

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Salario");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
                    .addComponent(tf_cargo)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_cadastrarCargo))
                    .addComponent(tf_salario)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_cargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_salario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_cadastrarCargo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Cargos", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cadastrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cadastrarClienteActionPerformed
        this.controller.cadastrarCliente();
    }//GEN-LAST:event_btn_cadastrarClienteActionPerformed

    private void btn_cadastrarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cadastrarFuncionarioActionPerformed
        this.controller.cadastrarFuncionario();
    }//GEN-LAST:event_btn_cadastrarFuncionarioActionPerformed

    private void tb_clientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_clientesMouseClicked
        if(evt.getClickCount() == 2) {
            this.controller.vizualizarCliente();
        }
    }//GEN-LAST:event_tb_clientesMouseClicked

    private void tb_funcionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_funcionariosMouseClicked
        if(evt.getClickCount() == 2) {
            this.controller.vizualizarFuncionario();
        }
    }//GEN-LAST:event_tb_funcionariosMouseClicked

    private void btn_deletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deletarActionPerformed
        if(JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir esse cliente do banco de dados? Essa ação exluirá tambem os endereços e contatos relacionados a essa pessoa!") == 0) {
            this.controller.excluirCliente();
        }
    }//GEN-LAST:event_btn_deletarActionPerformed

    private void btn_adcContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_adcContatoActionPerformed
        this.controller.adicionarContato();
    }//GEN-LAST:event_btn_adcContatoActionPerformed

    private void btn_adcEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_adcEnderecoActionPerformed
        this.controller.adicionarEndereco();
    }//GEN-LAST:event_btn_adcEnderecoActionPerformed

    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed
        this.controller.editarPessoa();
    }//GEN-LAST:event_btn_editarActionPerformed

    private void btn_salvarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salvarClienteActionPerformed
        this.controller.editarCliente();
    }//GEN-LAST:event_btn_salvarClienteActionPerformed

    private void btn_salvarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salvarFuncionarioActionPerformed
        this.controller.editarFuncionario();
    }//GEN-LAST:event_btn_salvarFuncionarioActionPerformed

    private void list_enderecosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_list_enderecosMouseClicked
        if(evt.getClickCount() == 2) {
            this.controller.editarEndereco();
        }
    }//GEN-LAST:event_list_enderecosMouseClicked

    private void list_contatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_list_contatosMouseClicked
        if(evt.getClickCount() == 2) {
            this.controller.editarContato();
        }
    }//GEN-LAST:event_list_contatosMouseClicked

    private void list_enderecosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_list_enderecosKeyPressed
        if(evt.getKeyChar() == 127) {
            this.controller.excluirEndereco();
        }
    }//GEN-LAST:event_list_enderecosKeyPressed

    private void list_contatosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_list_contatosKeyPressed
        if(evt.getKeyChar() == 127) {
            this.controller.excluirContato();
        }
    }//GEN-LAST:event_list_contatosKeyPressed

    private void btn_cadastrarCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cadastrarCargoActionPerformed
        this.controller.cadastrarCargo();
    }//GEN-LAST:event_btn_cadastrarCargoActionPerformed

    private void tb_cargosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_cargosMouseClicked
        if(evt.getClickCount() == 2) {
            this.controller.editarCargo();
        }
    }//GEN-LAST:event_tb_cargosMouseClicked

    private void tf_salarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_salarioKeyTyped
        if((!Character.isDigit(evt.getKeyChar())) && (evt.getKeyChar() != '.')) {
            evt.consume();
        }
    }//GEN-LAST:event_tf_salarioKeyTyped

    public JLabel getjLabel11() {
        return jLabel11;
    }

    public void setjLabel11(JLabel jLabel11) {
        this.jLabel11 = jLabel11;
    }

    public JTextField getTf_salario() {
        return tf_salario;
    }

    public void setTf_salario(JTextField tf_salario) {
        this.tf_salario = tf_salario;
    }

    
    public JButton getBtn_adcContato() {
        return btn_adcContato;
    }

    public void setBtn_adcContato(JButton btn_adcContato) {
        this.btn_adcContato = btn_adcContato;
    }

    public JButton getBtn_adcEndereco() {
        return btn_adcEndereco;
    }

    public void setBtn_adcEndereco(JButton btn_adcEndereco) {
        this.btn_adcEndereco = btn_adcEndereco;
    }

    public ControllerUsuario getController() {
        return controller;
    }

    public JScrollPane getjScrollPane5() {
        return jScrollPane5;
    }

    public void setjScrollPane5(JScrollPane jScrollPane5) {
        this.jScrollPane5 = jScrollPane5;
    }

    public JTable getTb_cargos() {
        return tb_cargos;
    }

    public void setTb_cargos(JTable tb_cargos) {
        this.tb_cargos = tb_cargos;
    }

    public JButton getBtn_cadastrarCargo() {
        return btn_cadastrarCargo;
    }

    public void setBtn_cadastrarCargo(JButton btn_cadastrarCargo) {
        this.btn_cadastrarCargo = btn_cadastrarCargo;
    }

    public JLabel getjLabel8() {
        return jLabel8;
    }

    public void setjLabel8(JLabel jLabel8) {
        this.jLabel8 = jLabel8;
    }

    public JPanel getjPanel4() {
        return jPanel4;
    }

    public void setjPanel4(JPanel jPanel4) {
        this.jPanel4 = jPanel4;
    }

    public JTextField getTf_cargo() {
        return tf_cargo;
    }

    public void setTf_cargo(JTextField tf_cargo) {
        this.tf_cargo = tf_cargo;
    }

    public JButton getBtn_salvarCliente() {
        return btn_salvarCliente;
    }

    public void setBtn_salvarCliente(JButton btn_salvarCliente) {
        this.btn_salvarCliente = btn_salvarCliente;
    }

    public JButton getBtn_salvarFuncionario() {
        return btn_salvarFuncionario;
    }

    public void setBtn_salvarFuncionario(JButton btn_salvarFuncionario) {
        this.btn_salvarFuncionario = btn_salvarFuncionario;
    }

    public void setController(ControllerUsuario controller) {
        this.controller = controller;
    }

    public JButton getBtn_cadastrarCliente() {
        return btn_cadastrarCliente;
    }

    public void setBtn_cadastrarCliente(JButton btn_cadastrarCliente) {
        this.btn_cadastrarCliente = btn_cadastrarCliente;
    }

    public JButton getBtn_cadastrarFuncionario() {
        return btn_cadastrarFuncionario;
    }

    public void setBtn_cadastrarFuncionario(JButton btn_cadastrarFuncionario) {
        this.btn_cadastrarFuncionario = btn_cadastrarFuncionario;
    }

    public JButton getBtn_deletar() {
        return btn_deletar;
    }

    public void setBtn_deletar(JButton btn_deletar) {
        this.btn_deletar = btn_deletar;
    }

    public JButton getBtn_editar() {
        return btn_editar;
    }

    public void setBtn_editar(JButton btn_editar) {
        this.btn_editar = btn_editar;
    }

    public JComboBox<String> getCb_sexoCliente() {
        return cb_sexoCliente;
    }

    public void setCb_sexoCliente(JComboBox<String> cb_sexoCliente) {
        this.cb_sexoCliente = cb_sexoCliente;
    }

    public JComboBox<String> getCb_sexoFuncionario() {
        return cb_sexoFuncionario;
    }

    public void setCb_sexoFuncionario(JComboBox<String> cb_sexoFuncionario) {
        this.cb_sexoFuncionario = cb_sexoFuncionario;
    }

    public JComboBox<String> getjComboBox1() {
        return cb_cargoFuncionario;
    }

    public void setjComboBox1(JComboBox<String> jComboBox1) {
        this.cb_cargoFuncionario = jComboBox1;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel10() {
        return jLabel10;
    }

    public void setjLabel10(JLabel jLabel10) {
        this.jLabel10 = jLabel10;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public void setjLabel3(JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public void setjLabel4(JLabel jLabel4) {
        this.jLabel4 = jLabel4;
    }

    public JLabel getjLabel5() {
        return jLabel5;
    }

    public void setjLabel5(JLabel jLabel5) {
        this.jLabel5 = jLabel5;
    }

    public JLabel getjLabel6() {
        return jLabel6;
    }

    public void setjLabel6(JLabel jLabel6) {
        this.jLabel6 = jLabel6;
    }

    public JLabel getjLabel7() {
        return jLabel7;
    }

    public void setjLabel7(JLabel jLabel7) {
        this.jLabel7 = jLabel7;
    }

    public JLabel getjLabel9() {
        return jLabel9;
    }

    public void setjLabel9(JLabel jLabel9) {
        this.jLabel9 = jLabel9;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JPanel getjPanel2() {
        return jPanel2;
    }

    public void setjPanel2(JPanel jPanel2) {
        this.jPanel2 = jPanel2;
    }

    public JPanel getjPanel3() {
        return jPanel3;
    }

    public void setjPanel3(JPanel jPanel3) {
        this.jPanel3 = jPanel3;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public void setjScrollPane2(JScrollPane jScrollPane2) {
        this.jScrollPane2 = jScrollPane2;
    }

    public JScrollPane getjScrollPane3() {
        return jScrollPane3;
    }

    public void setjScrollPane3(JScrollPane jScrollPane3) {
        this.jScrollPane3 = jScrollPane3;
    }

    public JScrollPane getjScrollPane4() {
        return jScrollPane4;
    }

    public void setjScrollPane4(JScrollPane jScrollPane4) {
        this.jScrollPane4 = jScrollPane4;
    }

    public JTabbedPane getjTabbedPane1() {
        return jTabbedPane1;
    }

    public void setjTabbedPane1(JTabbedPane jTabbedPane1) {
        this.jTabbedPane1 = jTabbedPane1;
    }

    public JLabel getLbl_cliente() {
        return lbl_cliente;
    }

    public void setLbl_cliente(JLabel lbl_cliente) {
        this.lbl_cliente = lbl_cliente;
    }

    public JList<ContatosBean> getList_contatos() {
        return list_contatos;
    }

    public void setList_contatos(JList<ContatosBean> list_contatos) {
        this.list_contatos = list_contatos;
    }

    public JList<EnderecosBean> getList_enderecos() {
        return list_enderecos;
    }

    public void setList_enderecos(JList<EnderecosBean> list_enderecos) {
        this.list_enderecos = list_enderecos;
    }

    public JTable getTb_clientes() {
        return tb_clientes;
    }

    public void setTb_clientes(JTable tb_clientes) {
        this.tb_clientes = tb_clientes;
    }

    public JTable getTb_funcionarios() {
        return tb_funcionarios;
    }

    public void setTb_funcionarios(JTable tb_funcionarios) {
        this.tb_funcionarios = tb_funcionarios;
    }

    public JFormattedTextField getTf_nascCliente() {
        return tf_nascCliente;
    }

    public void setTf_nascCliente(JFormattedTextField tf_nascCliente) {
        this.tf_nascCliente = tf_nascCliente;
    }

    public JFormattedTextField getTf_nascFuncionario() {
        return tf_nascFuncionario;
    }

    public void setTf_nascFuncionario(JFormattedTextField tf_nascFuncionario) {
        this.tf_nascFuncionario = tf_nascFuncionario;
    }

    public JTextField getTf_nomeCliente() {
        return tf_nomeCliente;
    }

    public void setTf_nomeCliente(JTextField tf_nomeCliente) {
        this.tf_nomeCliente = tf_nomeCliente;
    }

    public JTextField getTf_nomeFuncionario() {
        return tf_nomeFuncionario;
    }

    public void setTf_nomeFuncionario(JTextField tf_nomeFuncionario) {
        this.tf_nomeFuncionario = tf_nomeFuncionario;
    }

    public JComboBox<String> getCb_cargoFuncionario() {
        return cb_cargoFuncionario;
    }

    public void setCb_cargoFuncionario(JComboBox<String> cb_cargoFuncionario) {
        this.cb_cargoFuncionario = cb_cargoFuncionario;
    }

    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_adcContato;
    private javax.swing.JButton btn_adcEndereco;
    private javax.swing.JButton btn_cadastrarCargo;
    private javax.swing.JButton btn_cadastrarCliente;
    private javax.swing.JButton btn_cadastrarFuncionario;
    private javax.swing.JButton btn_deletar;
    private javax.swing.JButton btn_editar;
    private javax.swing.JButton btn_salvarCliente;
    private javax.swing.JButton btn_salvarFuncionario;
    private javax.swing.JComboBox<String> cb_cargoFuncionario;
    private javax.swing.JComboBox<String> cb_sexoCliente;
    private javax.swing.JComboBox<String> cb_sexoFuncionario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbl_cliente;
    private javax.swing.JList<ContatosBean> list_contatos;
    private javax.swing.JList<EnderecosBean> list_enderecos;
    private javax.swing.JTable tb_cargos;
    private javax.swing.JTable tb_clientes;
    private javax.swing.JTable tb_funcionarios;
    private javax.swing.JTextField tf_cargo;
    private javax.swing.JFormattedTextField tf_nascCliente;
    private javax.swing.JFormattedTextField tf_nascFuncionario;
    private javax.swing.JTextField tf_nomeCliente;
    private javax.swing.JTextField tf_nomeFuncionario;
    private javax.swing.JTextField tf_salario;
    // End of variables declaration//GEN-END:variables
}
