/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.CustoController;
import controller.UsuarioController;
import dao.ExceptionDAO;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Custo;

/**
 *
 * @author Gabriel
 */
public class ViewCusto extends javax.swing.JFrame {

    /**
     * Creates new form ViewCusto
     */
    public ViewCusto() {
        initComponents();
        refreshTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelCusto = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCusto = new javax.swing.JTable();
        jLabelTituloCusto = new javax.swing.JLabel();
        jLabelSubtituloCusto = new javax.swing.JLabel();
        jLabelRetornar = new javax.swing.JLabel();
        jTextFieldIdentificacao = new javax.swing.JTextField();
        jLabelIdentificacao = new javax.swing.JLabel();
        jLabelValor = new javax.swing.JLabel();
        jTextFieldValor = new javax.swing.JTextField();
        jComboBoxPeriodicidade = new javax.swing.JComboBox<>();
        jLabelPeriodicidade = new javax.swing.JLabel();
        jButtonCadastrar = new javax.swing.JButton();
        jButtonGerenciarAlterar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Free! - Gerenciar Custos");
        setResizable(false);

        jPanelCusto.setBackground(new java.awt.Color(0, 0, 0));

        jTableCusto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Identificação", "Periodicidade", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableCusto);

        jLabelTituloCusto.setFont(new java.awt.Font("The Bold Font", 0, 30)); // NOI18N
        jLabelTituloCusto.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTituloCusto.setText("Gerenciar custos");

        jLabelSubtituloCusto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelSubtituloCusto.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSubtituloCusto.setText("Suas finanças sob controle.");

        jLabelRetornar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelRetornar.setForeground(new java.awt.Color(255, 255, 255));
        jLabelRetornar.setText("Retornar >>");
        jLabelRetornar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelRetornar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelRetornarMouseClicked(evt);
            }
        });

        jTextFieldIdentificacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIdentificacaoActionPerformed(evt);
            }
        });

        jLabelIdentificacao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelIdentificacao.setForeground(new java.awt.Color(255, 255, 255));
        jLabelIdentificacao.setText("Identificação do custo:");

        jLabelValor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelValor.setForeground(new java.awt.Color(255, 255, 255));
        jLabelValor.setText("Valor:");

        jTextFieldValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldValorActionPerformed(evt);
            }
        });
        jTextFieldValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldValorKeyTyped(evt);
            }
        });

        jComboBoxPeriodicidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Diário", "Semanal", "Mensal", "Anual" }));

        jLabelPeriodicidade.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelPeriodicidade.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPeriodicidade.setText("Periodicidade");

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

        javax.swing.GroupLayout jPanelCustoLayout = new javax.swing.GroupLayout(jPanelCusto);
        jPanelCusto.setLayout(jPanelCustoLayout);
        jPanelCustoLayout.setHorizontalGroup(
            jPanelCustoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanelCustoLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanelCustoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCustoLayout.createSequentialGroup()
                        .addGroup(jPanelCustoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldIdentificacao, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelIdentificacao))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelCustoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelValor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelCustoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelPeriodicidade)
                            .addComponent(jComboBoxPeriodicidade, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addGroup(jPanelCustoLayout.createSequentialGroup()
                        .addComponent(jLabelSubtituloCusto)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelCustoLayout.createSequentialGroup()
                        .addComponent(jLabelTituloCusto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelRetornar)
                        .addGap(18, 18, 18))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCustoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonGerenciarAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137))
        );
        jPanelCustoLayout.setVerticalGroup(
            jPanelCustoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCustoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCustoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCustoLayout.createSequentialGroup()
                        .addGroup(jPanelCustoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelSubtituloCusto, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelTituloCusto, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelCustoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelCustoLayout.createSequentialGroup()
                                .addGroup(jPanelCustoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelIdentificacao, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelPeriodicidade, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelCustoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextFieldIdentificacao, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxPeriodicidade, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanelCustoLayout.createSequentialGroup()
                                .addComponent(jLabelValor, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42))))
                    .addGroup(jPanelCustoLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabelRetornar, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanelCustoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGerenciarAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelCusto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelCusto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldIdentificacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIdentificacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIdentificacaoActionPerformed

    private void jTextFieldValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldValorActionPerformed

    
     private void limparTelaCusto(java.awt.event.ActionEvent evt)
    {
        jTextFieldIdentificacao.setText("");
        jTextFieldValor.setText("");
        jComboBoxPeriodicidade.setSelectedItem("Diário");
    }
     
    private void refreshTable()
    {
        DefaultTableModel tableModel = (DefaultTableModel) jTableCusto.getModel();
        tableModel.setRowCount(0);
        CustoController custoController = new CustoController();
        try
        {
            
            ArrayList<Custo> custos = custoController.listarCustos();
            custos.forEach((Custo custo) -> {
                String periodicidade = "";
                if(custo.getPeriodicidade() == 'd')
                    periodicidade = "Diário";
                if(custo.getPeriodicidade() == 's')
                    periodicidade = "Semanal";
                if(custo.getPeriodicidade() == 'm')
                    periodicidade = "Mensal";
                if(custo.getPeriodicidade() == 'a')
                    periodicidade = "Anual";
                tableModel.addRow(new Object[] {custo.getIdentificacao(),
                                                periodicidade,
                                                custo.getValor()
                });
            });
            jTableCusto.setModel(tableModel);
        }
        catch(ExceptionDAO e)
        {
            e.printStackTrace();
        }
    }
     
    private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarActionPerformed
        // TODO add your handling code here:
        String identificacao = jTextFieldIdentificacao.getText();
        System.out.println(identificacao);
        float valor = Float.parseFloat(jTextFieldValor.getText());
        char periodicidade = 'd';
        if(jComboBoxPeriodicidade.getSelectedItem().toString() == "Diário")
            periodicidade = 'd';
        if(jComboBoxPeriodicidade.getSelectedItem().toString() == "Semanal")
            periodicidade = 's';
        if(jComboBoxPeriodicidade.getSelectedItem().toString() == "Mensal")
            periodicidade = 'm';
        if(jComboBoxPeriodicidade.getSelectedItem().toString() == "Anual")
            periodicidade = 'a';
        boolean sucesso;
        try
        {
            CustoController custoController = new CustoController();
            sucesso = custoController.cadastrarCusto(identificacao, valor, periodicidade);
            if(sucesso == true)
            {
                JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
                refreshTable();
                this.limparTelaCusto(evt);
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

    private void jButtonGerenciarAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGerenciarAlterarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonGerenciarAlterarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jTextFieldValorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldValorKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(((c < '0') || (c > '9')) && (c != '.'))
        {
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldValorKeyTyped

    private void jLabelRetornarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRetornarMouseClicked
        // TODO add your handling code here:
        ViewPrincipal viewPrincipal = new ViewPrincipal();
        viewPrincipal.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabelRetornarMouseClicked

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
            java.util.logging.Logger.getLogger(ViewCusto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewCusto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewCusto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewCusto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewCusto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCadastrar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonGerenciarAlterar;
    private javax.swing.JComboBox<String> jComboBoxPeriodicidade;
    private javax.swing.JLabel jLabelIdentificacao;
    private javax.swing.JLabel jLabelPeriodicidade;
    private javax.swing.JLabel jLabelRetornar;
    private javax.swing.JLabel jLabelSubtituloCusto;
    private javax.swing.JLabel jLabelTituloCusto;
    private javax.swing.JLabel jLabelValor;
    private javax.swing.JPanel jPanelCusto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCusto;
    private javax.swing.JTextField jTextFieldIdentificacao;
    private javax.swing.JTextField jTextFieldValor;
    // End of variables declaration//GEN-END:variables
}