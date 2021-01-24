package telas;

import conexão.AgendamentoDAO;
import conexão.ClienteDAO;
import conexão.FuncionarioDAO;
import java.text.ParseException;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.MaskFormatter;
import modelos.Agendamento;
import modelos.Cliente;
import modelos.Funcionario;

public class Agendamentos extends javax.swing.JFrame {

    Cliente c = new Cliente();
    ClienteDAO cd = new ClienteDAO();
    Funcionario f = new Funcionario();
    FuncionarioDAO fd = new FuncionarioDAO();
    Agendamento ag = new Agendamento();
    AgendamentoDAO agd = new AgendamentoDAO();

    public Agendamentos() {
        initComponents();
        formatarHora();
        formatarNumero();
        formatarValor();
        DefaultTableModel modelo = (DefaultTableModel) jtAgendamento.getModel();
        jtAgendamento.setRowSorter(new TableRowSorter(modelo));
        readTable();
    }

    public void nomeUsuarioTela(Funcionario pes) {
        f = fd.buscarFuncionarioUsuario(pes);
        txtFuncionario.setText(f.getUsuario());
        if ((f.getTipoUsuario().equals("Administrador")) || (f.getTipoUsuario().equals("Super"))) {
            btLimpar.setEnabled(true);
        }
    }

    public void readTable() {
        DefaultTableModel modelo = (DefaultTableModel) jtAgendamento.getModel();
        modelo.setNumRows(0);

        for (Agendamento ag : agd.listar()) {
            modelo.addRow(new Object[]{
                ag.getId(),
                ag.getCliente(),
                ag.getNumero(),
                ag.getTipoveiculo(),
                ag.getData(),
                ag.getHora(),
                ag.getValor(),
                ag.getFuncionario()
            });
        }
    }

    public String limitaString(String texto) {
        if (texto.length() <= 10) {
            return texto;
        } else {
            return texto.substring(0, 10);
        }
    }

    public boolean comparaData(Date data, Date data1) {
        boolean ret = false;
        if (data.before(data1)) {
            ret = true;
        } else {
        }
        return ret;
    }

    private void formatarHora() {
        try {
            MaskFormatter mask = new MaskFormatter("##:##");
            mask.install(txtfHora);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Erro ao formatar campo de texto!", "Error", JOptionPane.ERROR);
        }
    }

    private void formatarNumero() {
        try {
            MaskFormatter mask = new MaskFormatter("(##)#####-####");
            mask.install(txtfNumero);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Erro ao formatar campo de texto!", "Error", JOptionPane.ERROR);
        }
    }

    private void formatarValor() {
        try {
            MaskFormatter mask = new MaskFormatter("##.##");
            mask.install(txtfValor);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Erro ao formatar campo de texto!", "Error", JOptionPane.ERROR);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btAdicionar = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btApagar = new javax.swing.JButton();
        txtCliente = new javax.swing.JTextField();
        txtFuncionario = new javax.swing.JTextField();
        txtfHora = new javax.swing.JFormattedTextField();
        txtfNumero = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtfValor = new javax.swing.JFormattedTextField();
        cbVeículo = new javax.swing.JComboBox();
        txtPesquisar = new javax.swing.JTextField();
        btPesquisa = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        btTransferir = new javax.swing.JButton();
        txtfData = new com.toedter.calendar.JDateChooser();
        txtId = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtAgendamento = new javax.swing.JTable();
        btLimpar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agendamentos");

        btAdicionar.setText("Adicionar");
        btAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionarActionPerformed(evt);
            }
        });

        btEditar.setText("Editar");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        btApagar.setText("Apagar");
        btApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btApagarActionPerformed(evt);
            }
        });

        txtCliente.setEnabled(false);

        txtFuncionario.setEnabled(false);

        txtfNumero.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("(##)#####-####"))));
        txtfNumero.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabel1.setText("Cliente:");

        jLabel2.setText("Número:");

        jLabel3.setText("Veículo:");

        jLabel4.setText("Data:");

        jLabel5.setText("Hora:");

        jLabel6.setText("Valor:");

        jLabel7.setText("Funcionário:");

        cbVeículo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecionar", "Carro", "Moto" }));

        btPesquisa.setText("Pesquisar");
        btPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisaActionPerformed(evt);
            }
        });

        jLabel8.setText("Pesquisar Cliente:");

        btTransferir.setText("Transfere");
        btTransferir.setEnabled(false);
        btTransferir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTransferirActionPerformed(evt);
            }
        });

        txtfData.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);

        jtAgendamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Cliente", "Número", "Tipo do Veículo", "Data", "Hora", "Valor", "Funcionário"
            }
        ));
        jtAgendamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtAgendamentoKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jtAgendamento);

        btLimpar.setText("Limpar Lista");
        btLimpar.setEnabled(false);
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtfNumero))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(80, 80, 80))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cbVeículo, 0, 115, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(txtfData, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(126, 126, 126)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtfHora, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(txtfValor, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(txtFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27))))
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(btAdicionar)
                .addGap(133, 133, 133)
                .addComponent(btEditar)
                .addGap(123, 123, 123)
                .addComponent(btTransferir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btApagar)
                .addGap(112, 112, 112))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtfHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtfValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbVeículo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtfData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPesquisa)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btLimpar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAdicionar)
                    .addComponent(btEditar)
                    .addComponent(btApagar)
                    .addComponent(btTransferir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisaActionPerformed
        c.setPesquisa(txtPesquisar.getText());
        c = cd.buscarClienteNome(c);
        txtCliente.setText(c.getNome());
        txtfNumero.setText(c.getNumero());
        txtPesquisar.setText("");
    }//GEN-LAST:event_btPesquisaActionPerformed

    private void btAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarActionPerformed
        Date data = new Date();
        String z = "" + comparaData(txtfData.getDate(), data);
        if (txtCliente.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Por favor, verifique o campo cliente! ");
            txtCliente.requestFocus();

        } else {
            if (cbVeículo.getSelectedItem().equals("Selecionar")) {
                JOptionPane.showMessageDialog(rootPane, "Por favor, escolha o tipo do veículo! ");
                txtCliente.requestFocus();
            } else {
                if (z.equals("true")) {
                    JOptionPane.showMessageDialog(rootPane, "Por favor, escolha uma data válida! ");
                    txtfData.requestFocus();
                } else {
                    if (txtfHora.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(rootPane, "Por favor, preencha o campo hora! ");
                        txtfHora.requestFocus();
                    } else {
                        if (txtfValor.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(rootPane, "Por favor, preencha o campo com um valor válido! ");
                            txtfValor.requestFocus();
                        } else {

                            Agendamento a = new Agendamento();
                            a.setId(Integer.parseInt(txtId.getText()));
                            a.setCliente(txtCliente.getText());
                            a.setNumero(txtfNumero.getText());
                            a.setTipoveiculo((String) cbVeículo.getSelectedItem());
                            String h = txtfData.getDate().toLocaleString();
                            a.setData(limitaString(h));
                            a.setHora(txtfHora.getText());
                            a.setValor(Double.parseDouble(txtfValor.getText()));
                            a.setFuncionario(txtFuncionario.getText());
                            agd.inserirAgendamento(a);
                            readTable();

                            txtId.setText("");
                            txtCliente.setText("");
                            txtfNumero.setText("");
                            txtfData.setCalendar(null);
                            txtfHora.setText("");
                            txtfValor.setText("");
                            cbVeículo.setSelectedItem("Selecionar");

                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_btAdicionarActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        Date data = new Date();
        String z = "" + comparaData(txtfData.getDate(), data);
        if (txtCliente.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Por favor, verifique o campo cliente! ");
            txtCliente.requestFocus();

        } else {
            if (cbVeículo.getSelectedItem().equals("Selecionar")) {
                JOptionPane.showMessageDialog(rootPane, "Por favor, escolha o tipo do veículo! ");
                txtCliente.requestFocus();
            } else {
                if (z.equals("true")) {
                    JOptionPane.showMessageDialog(rootPane, "Por favor, escolha uma data válida! ");
                    txtfData.requestFocus();
                } else {
                    if (txtfHora.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(rootPane, "Por favor, preencha o campo hora! ");
                        txtfHora.requestFocus();
                    } else {
                        if (txtfValor.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(rootPane, "Por favor, preencha o campo com um valor válido! ");
                            txtfValor.requestFocus();
                        } else {
                            if (jtAgendamento.getSelectedRow() != -1) {

                                Agendamento a = new Agendamento();
                                a.setId(Integer.parseInt(txtId.getText()));
                                a.setCliente(txtCliente.getText());
                                a.setNumero(txtfNumero.getText());
                                a.setTipoveiculo((String) cbVeículo.getSelectedItem());
                                String h = txtfData.getDate().toLocaleString();
                                a.setData(limitaString(h));
                                a.setHora(txtfHora.getText());
                                a.setValor(Double.parseDouble(txtfValor.getText()));
                                a.setFuncionario(txtFuncionario.getText());
                                agd.alterarAgendamento(a);
                                readTable();

                                txtId.setText("");
                                txtCliente.setText("");
                                txtfNumero.setText("");
                                txtfData.setCalendar(null);
                                txtfHora.setText("");
                                txtfValor.setText("");
                                cbVeículo.setSelectedItem("Selecionar");
                                txtId.setEnabled(true);
                                btAdicionar.setEnabled(true);
                                btPesquisa.setEnabled(true);
                                btTransferir.setEnabled(false);
                            }
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_btEditarActionPerformed

    private void jtAgendamentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtAgendamentoKeyReleased
        if (jtAgendamento.getSelectedRow() != -1) {

            txtId.setText(jtAgendamento.getValueAt(jtAgendamento.getSelectedRow(), 0).toString());
            txtCliente.setText(jtAgendamento.getValueAt(jtAgendamento.getSelectedRow(), 1).toString());
            txtfNumero.setText(jtAgendamento.getValueAt(jtAgendamento.getSelectedRow(), 2).toString());
            cbVeículo.setSelectedItem(jtAgendamento.getValueAt(jtAgendamento.getSelectedRow(), 3).toString());
            txtfHora.setText(jtAgendamento.getValueAt(jtAgendamento.getSelectedRow(), 5).toString());
            txtfValor.setText(jtAgendamento.getValueAt(jtAgendamento.getSelectedRow(), 6).toString());
            txtId.setEnabled(false);
            btAdicionar.setEnabled(false);
            btPesquisa.setEnabled(false);
            btTransferir.setEnabled(true);
        }
    }//GEN-LAST:event_jtAgendamentoKeyReleased

    private void btApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btApagarActionPerformed
        if (!txtId.getText().isEmpty()) {
            Agendamento a = new Agendamento();
            a.setId(Integer.parseInt(txtId.getText()));
            agd.excluirAgendamento(a);
            readTable();
        } else {
            if (jtAgendamento.getSelectedRow() != -1) {
                Agendamento a = new Agendamento();
                a.setId((int) jtAgendamento.getValueAt(jtAgendamento.getSelectedRow(), 0));
                agd.excluirAgendamento(a);
                readTable();
                txtId.setText("");
                txtCliente.setText("");
                txtfNumero.setText("");
                txtfData.setCalendar(null);
                txtfHora.setText("");
                txtfValor.setText("");
                cbVeículo.setSelectedItem("Selecionar");
                txtId.setEnabled(true);
                btAdicionar.setEnabled(true);
                btPesquisa.setEnabled(true);
                btTransferir.setEnabled(false);
            }
        }

    }//GEN-LAST:event_btApagarActionPerformed

    private void btTransferirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTransferirActionPerformed
        Atendimento at = new Atendimento();
        f.setPesquisa(txtFuncionario.getText());
        ag.setPesquisa((txtId.getText()));
        at.nomeUsuarioTela(f);
        at.transfereAge(ag);
        at.setVisible(true);
        ag.setId(Integer.parseInt(txtId.getText()));
        agd.excluirAgendamento(ag);
        this.dispose();
    }//GEN-LAST:event_btTransferirActionPerformed

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        agd.excluirTodosAgendamento(ag);
        readTable();
    }//GEN-LAST:event_btLimparActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Agendamentos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdicionar;
    private javax.swing.JButton btApagar;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btPesquisa;
    private javax.swing.JButton btTransferir;
    private javax.swing.JComboBox cbVeículo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtAgendamento;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtFuncionario;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtPesquisar;
    private com.toedter.calendar.JDateChooser txtfData;
    private javax.swing.JFormattedTextField txtfHora;
    private javax.swing.JFormattedTextField txtfNumero;
    private javax.swing.JFormattedTextField txtfValor;
    // End of variables declaration//GEN-END:variables
}
