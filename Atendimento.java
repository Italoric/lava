package telas;

import conexão.AgendamentoDAO;
import conexão.ClienteDAO;
import javax.swing.JOptionPane;
import modelos.Sonumero;
import conexão.FuncionarioDAO;
import modelos.Agendamento;
import modelos.Cliente;
import modelos.Funcionario;

public class Atendimento extends javax.swing.JFrame {

    Cliente mod = new Cliente();
    ClienteDAO cdao = new ClienteDAO();
    Funcionario f = new Funcionario();
    FuncionarioDAO fdao = new FuncionarioDAO();

    public Atendimento() {
        initComponents();
        txtValor.setDocument(new Sonumero());
        btLavar.setEnabled(false);
        btMenuFun.setEnabled(false);
    }

    public void transfereAge(Agendamento a) {
        AgendamentoDAO agd = new AgendamentoDAO();
        Agendamento b = agd.buscarAgendamento(a);
        mod.setPesquisa(b.getCliente());
        mod = cdao.buscarClienteNome(mod);
        txtCliente.setText(mod.getNome());
        txtNumero.setText(mod.getNumero());
        txtQtd.setText("" + mod.getQuantidade());
        cbVeiculo.setSelectedItem(b.getTipoveiculo());
    }

    public void nomeUsuarioTela(Funcionario pes) {
        f = fdao.buscarFuncionarioUsuario(pes);
        jlUsuario.setText(f.getUsuario());
        if ((f.getTipoUsuario().equals("Administrador")) || (f.getTipoUsuario().equals("Super"))) {
            menu2.setEnabled(true);
            btMenuFun.setEnabled(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        txtDescricao = new javax.swing.JTextField();
        cbVeiculo = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbPagamento = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        btLavar = new javax.swing.JButton();
        cbLavador = new javax.swing.JComboBox();
        txtPesquisa = new javax.swing.JTextField();
        btPesquisarPorNome = new javax.swing.JButton();
        txtImagem = new javax.swing.JLabel();
        jlUsuario = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtfPlaca = new javax.swing.JFormattedTextField();
        txtNumero = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtQtd = new javax.swing.JTextField();
        jbPesquisarPorCPF = new javax.swing.JButton();
        txtPertence = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu = new javax.swing.JMenu();
        btMenuFun = new javax.swing.JMenuItem();
        btMenuCli = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        btAlteraSenha = new javax.swing.JMenuItem();
        menu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        menu3 = new javax.swing.JMenu();
        btAgendar = new javax.swing.JMenuItem();
        btSair = new javax.swing.JMenu();
        btSair1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatório de Lavagens");
        setPreferredSize(new java.awt.Dimension(870, 508));

        jLabel1.setText("Cliente:");

        jLabel2.setText("Veículo:");

        jLabel3.setText("Pertence:");

        jLabel4.setText("Descrição:");

        txtCliente.setEnabled(false);

        cbVeiculo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecionar", "Carro", "Moto" }));

        jLabel5.setText("Lavador:");

        jLabel6.setText("Pagamento:");

        cbPagamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecionar", "Débito", "Crédito", "Dinheiro", "Transferência" }));
        cbPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPagamentoActionPerformed(evt);
            }
        });

        jLabel7.setText("Valor à pagar:");

        btLavar.setText("Lavar");
        btLavar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLavarActionPerformed(evt);
            }
        });

        cbLavador.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecionar", "Paulo", "Ítalo" }));

        btPesquisarPorNome.setText("Buscar por Nome");
        btPesquisarPorNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarPorNomeActionPerformed(evt);
            }
        });

        txtImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/LavajatoR.jpg"))); // NOI18N
        txtImagem.setPreferredSize(new java.awt.Dimension(400, 300));

        jLabel9.setText("Usuário:");

        jLabel8.setText("Placa:");

        txtNumero.setEnabled(false);

        jLabel10.setText("Número:");

        jLabel11.setText("Quantidade:");

        txtQtd.setEnabled(false);

        jbPesquisarPorCPF.setText("Buscar por CPF");
        jbPesquisarPorCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPesquisarPorCPFActionPerformed(evt);
            }
        });

        menu.setText("Cadastros");

        btMenuFun.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        btMenuFun.setText("Cadastrar Funcionário");
        btMenuFun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMenuFunActionPerformed(evt);
            }
        });
        menu.add(btMenuFun);

        btMenuCli.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        btMenuCli.setText("Cadastrar Cliente");
        btMenuCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMenuCliActionPerformed(evt);
            }
        });
        menu.add(btMenuCli);
        menu.add(jSeparator1);

        btAlteraSenha.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        btAlteraSenha.setText("Alterar Senha");
        btAlteraSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlteraSenhaActionPerformed(evt);
            }
        });
        menu.add(btAlteraSenha);

        jMenuBar1.add(menu);

        menu2.setText("Relatórios");
        menu2.setEnabled(false);

        jMenuItem1.setText("Lavagens");
        menu2.add(jMenuItem1);

        jMenuItem2.setText("jMenuItem2");
        menu2.add(jMenuItem2);

        jMenuBar1.add(menu2);

        menu3.setText("Agendar");

        btAgendar.setText("Agendar");
        btAgendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgendarActionPerformed(evt);
            }
        });
        menu3.add(btAgendar);

        jMenuBar1.add(menu3);

        btSair.setText("Sair");

        btSair1.setText("Sair");
        btSair1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSair1ActionPerformed(evt);
            }
        });
        btSair.add(btSair1);

        jMenuBar1.add(btSair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10)
                    .addComponent(jLabel1))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCliente)
                    .addComponent(txtNumero, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtQtd, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtValor, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbVeiculo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtfPlaca, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                    .addComponent(txtPertence, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btLavar)
                            .addComponent(cbLavador, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtPesquisa)
                                .addComponent(txtImagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(btPesquisarPorNome, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(jbPesquisarPorCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(114, 114, 114))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9)
                    .addComponent(jlUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btPesquisarPorNome)
                            .addComponent(jbPesquisarPorCPF)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtfPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtPertence, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbLavador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addGap(44, 44, 44)
                                .addComponent(btLavar))))
                    .addComponent(txtImagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(338, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPagamentoActionPerformed

        if ((cbVeiculo.getSelectedItem().equals("Selecionar")) || (cbLavador.getSelectedItem().equals("Selecionar")) || (txtPertence.getText().isEmpty()) || (cbPagamento.getSelectedItem().equals("Selecionar"))) {
            JOptionPane.showMessageDialog(null, "Por favor, preencha os dados corretamente!");
            btLavar.setEnabled(false);
        } else {

            if ((cbPagamento.getSelectedItem().equals("Transferência")) || (cbPagamento.getSelectedItem().equals("Dinheiro")) || (cbPagamento.getSelectedItem().equals("Débito"))||(cbPagamento.getSelectedItem().equals("Crédito"))) {

                btLavar.setEnabled(true);
            }
        }
    }//GEN-LAST:event_cbPagamentoActionPerformed

    private void btLavarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLavarActionPerformed
        if ((cbVeiculo.getSelectedItem().equals("Selecionar")) || (cbLavador.getSelectedItem().equals("Selecionar")) || (txtCliente.getText().isEmpty()) || (cbPagamento.getSelectedItem().equals("Selecionar"))||(txtDescricao.getText().isEmpty())||txtfPlaca.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, preencha os dados corretamente!");
            btLavar.setEnabled(false);
        } else {
            mod.setPesquisa(txtCliente.getText());
            Cliente cli = cdao.buscarClienteNome(mod);
            int b = 1 + cli.getQuantidade();
            cli.setQuantidade(b);
            cdao.quantCliente(cli);
            f.setPesquisa(jlUsuario.getText());
            f = fdao.buscarFuncionarioUsuario(f);
            Atendimento a1 = new Atendimento();
            a1.nomeUsuarioTela(f);
            a1.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btLavarActionPerformed

    private void btAgendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgendarActionPerformed
        f.setUsuario(jlUsuario.getText());
        Agendamentos age = new Agendamentos();
        age.nomeUsuarioTela(f);
        age.setVisible(true);
    }//GEN-LAST:event_btAgendarActionPerformed

    private void btMenuCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMenuCliActionPerformed
        CadastroCliente cad = new CadastroCliente();
        f.setUsuario(jlUsuario.getText());
        cad.nomeUsuarioTela(f);
        cad.setVisible(true);
    }//GEN-LAST:event_btMenuCliActionPerformed

    private void btMenuFunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMenuFunActionPerformed
        CadastroFuncionario fun = new CadastroFuncionario();
        fun.setVisible(true);
        f.setUsuario(jlUsuario.getText());
        fun.nomeUsuarioTela(f);
    }//GEN-LAST:event_btMenuFunActionPerformed

    private void jbPesquisarPorCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPesquisarPorCPFActionPerformed
        mod.setPesquisa(txtPesquisa.getText());
        Cliente cli = cdao.buscarClienteCPF(mod);
        txtCliente.setText(cli.getNome());
        txtNumero.setText(cli.getNumero());
        txtQtd.setText("" + cli.getQuantidade());
    }//GEN-LAST:event_jbPesquisarPorCPFActionPerformed

    private void btPesquisarPorNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarPorNomeActionPerformed
        mod.setPesquisa(txtPesquisa.getText());
        Cliente cli = cdao.buscarClienteNome(mod);
        txtCliente.setText(cli.getNome());
        txtNumero.setText(cli.getNumero());
        txtQtd.setText("" + cli.getQuantidade());
    }//GEN-LAST:event_btPesquisarPorNomeActionPerformed

    private void btAlteraSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlteraSenhaActionPerformed
        AlterarSenha fun = new AlterarSenha();
        Funcionario usu2 = new Funcionario();
        fun.setVisible(true);
        usu2.setUsuario(jlUsuario.getText());
        fun.nomeUsuarioTela(usu2);
    }//GEN-LAST:event_btAlteraSenhaActionPerformed

    private void btSair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSair1ActionPerformed
        Login l = new Login();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btSair1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Atendimento a1 = new Atendimento();
                a1.setLocationRelativeTo(null);
                a1.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btAgendar;
    private javax.swing.JMenuItem btAlteraSenha;
    private javax.swing.JButton btLavar;
    private javax.swing.JMenuItem btMenuCli;
    private javax.swing.JMenuItem btMenuFun;
    private javax.swing.JButton btPesquisarPorNome;
    private javax.swing.JMenu btSair;
    private javax.swing.JMenuItem btSair1;
    private javax.swing.JComboBox cbLavador;
    private javax.swing.JComboBox cbPagamento;
    private javax.swing.JComboBox cbVeiculo;
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
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JButton jbPesquisarPorCPF;
    private javax.swing.JLabel jlUsuario;
    private javax.swing.JMenu menu;
    private javax.swing.JMenu menu2;
    private javax.swing.JMenu menu3;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JLabel txtImagem;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtPertence;
    private javax.swing.JTextField txtPesquisa;
    private javax.swing.JTextField txtQtd;
    private javax.swing.JTextField txtValor;
    private javax.swing.JFormattedTextField txtfPlaca;
    // End of variables declaration//GEN-END:variables
}
