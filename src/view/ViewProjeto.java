/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.BeneficioController;
import controller.ProjetoController;
import controller.UsuarioController;
import dao.ExceptionDAO;
import dao.UsuarioDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Beneficio;
import model.Projeto;

/**
 *
 * @author Gabriel
 */
public class ViewProjeto extends javax.swing.JFrame {

    /**
     * Creates new form ViewProjeto
     */
    public ViewProjeto() {
        initComponents();
        gerenciaBotoes(0);
        refreshTable();
    }
    
    private void preencheCampos(String identificacao, String descricao, String cliente, Date data_entrega, int previsao)
    {
        SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyy");
        String data = formato.format(data_entrega);
        jTextFieldIdentificacao.setText(identificacao);
        jTextFieldCliente.setText(cliente);
        jFormattedTextFieldDataEntrega.setText(data);
        jTextFieldHorasConclusao.setText(String.valueOf(previsao));
        jTextAreaDescricao.setText(descricao);
    }
    
    private void refreshTable()
    {
        DefaultTableModel tableModel = (DefaultTableModel) jTableProjeto.getModel();
        tableModel.setRowCount(0);
        ProjetoController projetoController = new ProjetoController();
        try
        {
            
            ArrayList<Projeto> projetos = projetoController.listarProjetos();
            projetos.forEach((Projeto projeto) -> {
                tableModel.addRow(new Object[] {projeto.getCodigo(),
                                                projeto.getIdentificacao(),
                                                projeto.getDescricao(),
                                                projeto.getCliente(),
                                                projeto.getData_entrega(),
                                                projeto.getHoras_conclusao(),
                                                projeto.getValor()
                });
            });
            jTableProjeto.setModel(tableModel);
        }
        catch(ExceptionDAO e)
        {
            e.printStackTrace();
        }
    }
    
    private void limparTelaProjeto()
    {
        jTextFieldIdentificacao.setText("");
        jTextFieldCliente.setText("");
        jFormattedTextFieldDataEntrega.setText("");
        jTextFieldHorasConclusao.setText("");
        jTextAreaDescricao.setText("");
        gerenciaBotoes(0);
    }
    
    private void gerenciaBotoes(int cod)
    {
        if(cod == 0)
        {
            jButtonCadastrar.setEnabled(true);
            jButtonGerenciarAlterar.setEnabled(false);
            jButtonExcluir.setEnabled(false);
        }
        else
        {
            jButtonCadastrar.setEnabled(false);
            jButtonGerenciarAlterar.setEnabled(true);
            jButtonExcluir.setEnabled(true);
        }
    } 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelSubtituloProjeto1 = new javax.swing.JLabel();
        jPanelProjeto = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProjeto = new javax.swing.JTable();
        jLabelTituloProjeto = new javax.swing.JLabel();
        jLabelSubtituloProjeto = new javax.swing.JLabel();
        jLabelIdentificacao = new javax.swing.JLabel();
        jTextFieldIdentificacao = new javax.swing.JTextField();
        jTextFieldCliente = new javax.swing.JTextField();
        jLabelCliente = new javax.swing.JLabel();
        jLabelDataEntrega = new javax.swing.JLabel();
        jFormattedTextFieldDataEntrega = new javax.swing.JFormattedTextField();
        jTextFieldHorasConclusao = new javax.swing.JTextField();
        jLabelHorasConclusao = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaDescricao = new javax.swing.JTextArea();
        jLabelRetornar = new javax.swing.JLabel();
        jLabelDescricao1 = new javax.swing.JLabel();
        jButtonGerenciarAlterar = new javax.swing.JButton();
        jButtonCadastrar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();

        jLabelSubtituloProjeto1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelSubtituloProjeto1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSubtituloProjeto1.setText("Selecione uma funcionalidade.");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Free! - Gerenciar Projetos");
        setResizable(false);

        jPanelProjeto.setBackground(new java.awt.Color(0, 0, 0));
        jPanelProjeto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelProjetoMouseClicked(evt);
            }
        });

        jTableProjeto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Identificação", "Descrição", "Cliente", "Data de Entrega", "Horas para conclusão", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableProjeto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProjetoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableProjeto);

        jLabelTituloProjeto.setFont(new java.awt.Font("The Bold Font", 0, 30)); // NOI18N
        jLabelTituloProjeto.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTituloProjeto.setText("Gerenciar projetos");

        jLabelSubtituloProjeto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelSubtituloProjeto.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSubtituloProjeto.setText("Organização é a chave do sucesso.");

        jLabelIdentificacao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelIdentificacao.setForeground(new java.awt.Color(255, 255, 255));
        jLabelIdentificacao.setText("Identificação do projeto:");

        jTextFieldIdentificacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIdentificacaoActionPerformed(evt);
            }
        });

        jTextFieldCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldClienteActionPerformed(evt);
            }
        });

        jLabelCliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelCliente.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCliente.setText("Cliente:");

        jLabelDataEntrega.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelDataEntrega.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDataEntrega.setText("Data de entrega:");

        try {
            jFormattedTextFieldDataEntrega.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jTextFieldHorasConclusao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldHorasConclusaoActionPerformed(evt);
            }
        });

        jLabelHorasConclusao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelHorasConclusao.setForeground(new java.awt.Color(255, 255, 255));
        jLabelHorasConclusao.setText("Previsão de horas para conclusão:");

        jTextAreaDescricao.setColumns(20);
        jTextAreaDescricao.setRows(5);
        jScrollPane2.setViewportView(jTextAreaDescricao);

        jLabelRetornar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelRetornar.setForeground(new java.awt.Color(255, 255, 255));
        jLabelRetornar.setText("Retornar >>");
        jLabelRetornar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelRetornar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelRetornarMouseClicked(evt);
            }
        });

        jLabelDescricao1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelDescricao1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDescricao1.setText("Descrição do projeto:");

        jButtonGerenciarAlterar.setBackground(new java.awt.Color(255, 0, 102));
        jButtonGerenciarAlterar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonGerenciarAlterar.setText("Alterar");
        jButtonGerenciarAlterar.setToolTipText("");
        jButtonGerenciarAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonGerenciarAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGerenciarAlterarActionPerformed(evt);
            }
        });

        jButtonCadastrar.setBackground(new java.awt.Color(255, 0, 102));
        jButtonCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCadastrar.setText("Cadastrar");
        jButtonCadastrar.setToolTipText("");
        jButtonCadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarActionPerformed(evt);
            }
        });

        jButtonExcluir.setBackground(new java.awt.Color(255, 0, 102));
        jButtonExcluir.setForeground(new java.awt.Color(255, 255, 255));
        jButtonExcluir.setText("Excluir");
        jButtonExcluir.setToolTipText("");
        jButtonExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelProjetoLayout = new javax.swing.GroupLayout(jPanelProjeto);
        jPanelProjeto.setLayout(jPanelProjetoLayout);
        jPanelProjetoLayout.setHorizontalGroup(
            jPanelProjetoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelProjetoLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanelProjetoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTituloProjeto)
                    .addComponent(jLabelSubtituloProjeto)
                    .addGroup(jPanelProjetoLayout.createSequentialGroup()
                        .addGroup(jPanelProjetoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDataEntrega)
                            .addComponent(jLabelCliente)
                            .addComponent(jTextFieldIdentificacao, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelProjetoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jFormattedTextFieldDataEntrega, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                                .addComponent(jLabelHorasConclusao, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldHorasConclusao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))
                            .addComponent(jLabelIdentificacao))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelProjetoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelRetornar)
                            .addComponent(jLabelDescricao1, javax.swing.GroupLayout.Alignment.LEADING))))
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelProjetoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonGerenciarAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115))
        );
        jPanelProjetoLayout.setVerticalGroup(
            jPanelProjetoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelProjetoLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanelProjetoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelProjetoLayout.createSequentialGroup()
                        .addComponent(jLabelRetornar, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(jLabelSubtituloProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelTituloProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelProjetoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelIdentificacao, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDescricao1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelProjetoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelProjetoLayout.createSequentialGroup()
                        .addComponent(jTextFieldIdentificacao, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelDataEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextFieldDataEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelHorasConclusao, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldHorasConclusao, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanelProjetoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGerenciarAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelProjeto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelProjeto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldIdentificacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIdentificacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIdentificacaoActionPerformed

    private void jTextFieldClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldClienteActionPerformed

    private void jTextFieldHorasConclusaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldHorasConclusaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldHorasConclusaoActionPerformed

    private void jButtonGerenciarAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGerenciarAlterarActionPerformed
        // TODO add your handling code here:
        UsuarioDAO usuariodao = new UsuarioDAO();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date data_entrega = null;
        String identificacao = jTextFieldIdentificacao.getText();
        String descricao = jTextAreaDescricao.getText();
        String cliente = jTextFieldCliente.getText();
        int codigo = Integer.parseInt(String.valueOf(jTableProjeto.getValueAt(jTableProjeto.getSelectedRow(), 0)));
        try
        {
            data_entrega = formato.parse(jFormattedTextFieldDataEntrega.getText());
        }
        catch(ParseException e)
        {
            e.printStackTrace();
        }
        int horas_conclusao = Integer.parseInt(jTextFieldHorasConclusao.getText());
        float valor = usuariodao.getValorHora() * horas_conclusao;
        boolean sucesso;
        try
        {
            ProjetoController projetoController = new ProjetoController();
            sucesso = projetoController.atualizarProjeto(codigo, identificacao, descricao, cliente, data_entrega, horas_conclusao, valor);
            if(sucesso == true)
            {
                JOptionPane.showMessageDialog(null, "Atualização realizada com sucesso!");
                refreshTable();
                this.limparTelaProjeto();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Campos não preenchidos corretamente!");
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
        }
    }//GEN-LAST:event_jButtonGerenciarAlterarActionPerformed

    private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarActionPerformed
        // TODO add your handling code here:
        UsuarioDAO usuariodao = new UsuarioDAO();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date data_entrega = null;
        String identificacao = jTextFieldIdentificacao.getText();
        String descricao = jTextAreaDescricao.getText();
        String cliente = jTextFieldCliente.getText();
        try
        {
            data_entrega = formato.parse(jFormattedTextFieldDataEntrega.getText());
        }
        catch(ParseException e)
        {
            e.printStackTrace();
        }
        int horas_conclusao = Integer.parseInt(jTextFieldHorasConclusao.getText());
        float valor = usuariodao.getValorHora() * horas_conclusao;
        boolean sucesso;
        System.out.println(data_entrega);
        try
        {
            ProjetoController projetoController = new ProjetoController();
            sucesso = projetoController.cadastrarProjeto(identificacao, descricao, cliente, data_entrega, horas_conclusao, valor);
            if(sucesso == true)
            {
                JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
                refreshTable();
                this.limparTelaProjeto();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Campos não preenchidos corretamente!");
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
        }
    }//GEN-LAST:event_jButtonCadastrarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        // TODO add your handling code here:
        int codigo = Integer.parseInt(String.valueOf(jTableProjeto.getValueAt(jTableProjeto.getSelectedRow(), 0)));
        boolean sucesso;
        try
        {
            ProjetoController projetoController = new ProjetoController();
            UsuarioController usuarioController = new UsuarioController();
            sucesso = projetoController.excluirProjeto(codigo);
            if(sucesso == true)
            {
                JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso!");
                refreshTable();
                this.limparTelaProjeto();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro!");
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jLabelRetornarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRetornarMouseClicked
        // TODO add your handling code here:
        ViewPrincipal viewPrincipal = new ViewPrincipal();
        viewPrincipal.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabelRetornarMouseClicked

    private void jTableProjetoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProjetoMouseClicked
        // TODO add your handling code here:
        gerenciaBotoes(1);
        if(evt.getClickCount() == 1)
        {
            Date data_entrega = null;
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            try
            {
                data_entrega = formato.parse(String.valueOf(jTableProjeto.getModel().getValueAt(jTableProjeto.getSelectedRow(), 4)));
                System.out.println(data_entrega);
            }
            catch(ParseException e)
            {
                e.printStackTrace();
            }
            String identificacao = (String)jTableProjeto.getModel().getValueAt(jTableProjeto.getSelectedRow(), 1);
            String descricao = (String)jTableProjeto.getModel().getValueAt(jTableProjeto.getSelectedRow(), 2);
            String cliente = (String)jTableProjeto.getModel().getValueAt(jTableProjeto.getSelectedRow(), 3);
            int horas_conclusao = Integer.parseInt(String.valueOf(jTableProjeto.getModel().getValueAt(jTableProjeto.getSelectedRow(), 5)));
            preencheCampos(identificacao, descricao, cliente, data_entrega, horas_conclusao);
        }
    }//GEN-LAST:event_jTableProjetoMouseClicked

    private void jPanelProjetoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelProjetoMouseClicked
        // TODO add your handling code here:
        jTableProjeto.clearSelection();
        limparTelaProjeto();
    }//GEN-LAST:event_jPanelProjetoMouseClicked

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
            java.util.logging.Logger.getLogger(ViewProjeto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewProjeto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewProjeto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewProjeto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewProjeto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCadastrar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonGerenciarAlterar;
    private javax.swing.JFormattedTextField jFormattedTextFieldDataEntrega;
    private javax.swing.JLabel jLabelCliente;
    private javax.swing.JLabel jLabelDataEntrega;
    private javax.swing.JLabel jLabelDescricao1;
    private javax.swing.JLabel jLabelHorasConclusao;
    private javax.swing.JLabel jLabelIdentificacao;
    private javax.swing.JLabel jLabelRetornar;
    private javax.swing.JLabel jLabelSubtituloProjeto;
    private javax.swing.JLabel jLabelSubtituloProjeto1;
    private javax.swing.JLabel jLabelTituloProjeto;
    private javax.swing.JPanel jPanelProjeto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableProjeto;
    private javax.swing.JTextArea jTextAreaDescricao;
    private javax.swing.JTextField jTextFieldCliente;
    private javax.swing.JTextField jTextFieldHorasConclusao;
    private javax.swing.JTextField jTextFieldIdentificacao;
    // End of variables declaration//GEN-END:variables
}
