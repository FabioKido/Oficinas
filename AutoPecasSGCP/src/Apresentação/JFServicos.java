/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Apresentação;

import DataAccess.ServicoMecanicoDAO;
import DomainModel.ServicoMecanico;
import DomainModel.Servicos;
import DataAccess.ServicosDAO;
import DomainModel.ItemServico;
import DataAccess.ItemServicoDAO;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kido
 */

public class JFServicos extends javax.swing.JFrame {

    /**
     * Creates new form JFVendas
     */
    List<ServicoMecanico> servicosMecanicos;
    
    public JFServicos() {
        initComponents();
        formatarData();
        
        servicosMecanicos = ServicoMecanicoDAO.getInstance().findAll();
        
        preencherComboBox();
    }
    
    public JFServicos(Servicos s){
        
        initComponents();
        
        jTFServicoCodigo.setText(String.valueOf(s.getCodigo()));
        jTFValorTotal.setText(String.valueOf(s.getValorTotal()));
                
        formatarData();
        
        servicosMecanicos = ServicoMecanicoDAO.getInstance().findAll();
        
        preencherComboBox();
        
        DefaultTableModel dtm = (DefaultTableModel) jTServicos.getModel();
        
        List<ItemServico> itensServico = ItemServicoDAO.getInstance().findAll();
        for(ItemServico c: itensServico){
            if(c.getServicos().getCodigo() == s.getCodigo()){
                dtm.addRow(new Object[]{c.getServicoMecanico().getCodigo(),c.getServicoMecanico().getDescricao(),c.getServicoMecanico().getValorCobrado(),c.getQuantidade(),c.getQuantidade() * c.getServicoMecanico().getValorCobrado()});
            }
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

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTFQuantidade = new javax.swing.JTextField();
        jBAdicionarItem = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTFServicoCodigo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTFValorTotal = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jCBServico = new javax.swing.JComboBox<>();
        jTFDescricao = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jFTFDataServico = new javax.swing.JFormattedTextField();
        jBRemoverItem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTServicos = new javax.swing.JTable();
        jBPagamento = new javax.swing.JButton();
        jBFinalizarServicos = new javax.swing.JButton();
        jBTelaPrincipal = new javax.swing.JButton();
        jBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setText("Quantidade");

        jBAdicionarItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Icones/add.png"))); // NOI18N
        jBAdicionarItem.setText("Adicionar");
        jBAdicionarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAdicionarItemActionPerformed(evt);
            }
        });

        jLabel2.setText("Nº Serviço");

        jTFServicoCodigo.setBackground(new java.awt.Color(108, 251, 103));
        jTFServicoCodigo.setEnabled(false);

        jLabel4.setText("Total R$");

        jTFValorTotal.setEnabled(false);

        jLabel5.setText("Serviço");

        jLabel1.setText("Data");

        jCBServico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jTFDescricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFDescricaoKeyReleased(evt);
            }
        });

        jLabel6.setText("Descrição");

        jFTFDataServico.setToolTipText("");

        jBRemoverItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Icones/delete.png"))); // NOI18N
        jBRemoverItem.setText("Remover");
        jBRemoverItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRemoverItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel2))
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTFServicoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(254, 254, 254)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFTFDataServico, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTFDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                                    .addComponent(jTFQuantidade))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTFValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCBServico, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jBRemoverItem)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jBAdicionarItem)))))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTFServicoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jFTFDataServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jCBServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTFQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBAdicionarItem)
                    .addComponent(jBRemoverItem))
                .addContainerGap())
        );

        jTServicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Serviço", "Valor Cobrado", "Quantidade", "Valor Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTServicos);

        jBPagamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Icones/money.png"))); // NOI18N
        jBPagamento.setText("Pagamento");
        jBPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPagamentoActionPerformed(evt);
            }
        });

        jBFinalizarServicos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Icones/tick.png"))); // NOI18N
        jBFinalizarServicos.setText("Finalizar ");
        jBFinalizarServicos.setEnabled(false);
        jBFinalizarServicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBFinalizarServicosActionPerformed(evt);
            }
        });

        jBTelaPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Icones/door_in.png"))); // NOI18N
        jBTelaPrincipal.setText("Tela Principal");
        jBTelaPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTelaPrincipalActionPerformed(evt);
            }
        });

        jBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Icones/magnifier.png"))); // NOI18N
        jBuscar.setText("Listar");
        jBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBTelaPrincipal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBFinalizarServicos)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBPagamento)
                    .addComponent(jBFinalizarServicos)
                    .addComponent(jBTelaPrincipal)
                    .addComponent(jBuscar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBTelaPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTelaPrincipalActionPerformed
        // TODO add your handling code here:
        new JFAutoPecasPrincipal().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBTelaPrincipalActionPerformed

    private void somarValorTotal(){
        
        Double valor, soma = 0.0;
        
        int cont = jTServicos.getRowCount();
        
        for(int i = 0; i < cont; i++){
            valor = (Double) jTServicos.getValueAt(i, 4);
            soma += valor;
        }
        
        jTFValorTotal.setText(String.valueOf(soma));
    }
    
    private void jBAdicionarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAdicionarItemActionPerformed
        // TODO add your handling code here:
        ServicoMecanico servicoMecanico = null;
        String busca = (String) jCBServico.getSelectedItem();
        for (ServicoMecanico c: servicosMecanicos){
            if(busca.equals(c.getDescricao()))
                servicoMecanico = c;
        }
        
        DefaultTableModel dtm = (DefaultTableModel) jTServicos.getModel();
        
        int cont = 0;
        Double quantidade = 0.0;
        quantidade = Double.parseDouble(jTFQuantidade.getText());
        int qtd = Integer.parseInt(jTFQuantidade.getText());
        
        for(int i=0; i < cont; i++){
            dtm.setNumRows(0);
        }
        
        dtm.addRow(new Object[]{servicoMecanico.getCodigo(),servicoMecanico.getDescricao(),servicoMecanico.getValorCobrado(),qtd,quantidade * servicoMecanico.getValorCobrado()});
        
        somarValorTotal();
    }//GEN-LAST:event_jBAdicionarItemActionPerformed

    private void jTFDescricaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFDescricaoKeyReleased
        // TODO add your handling code here:
        preencherComboBox();
    }//GEN-LAST:event_jTFDescricaoKeyReleased

    private void formatarData(){
        try{
            MaskFormatter mask = new MaskFormatter("##/##/####");
            mask.install(jFTFDataServico);
        }catch(ParseException ex){
            JOptionPane.showMessageDialog(null, "Erro ao Formatar Campo", "ERRO", JOptionPane.ERROR);
        }
    }
    
    private void jBFinalizarServicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBFinalizarServicosActionPerformed
        // TODO add your handling code here:
        
        Servicos servicos = new Servicos();
        ItemServico itemServico = new ItemServico();
        
        servicos.setValorTotal(Double.parseDouble(jTFValorTotal.getText()));
        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date data = formato.parse(jFTFDataServico.getText());
            servicos.setDataDeServico(data);
        } catch (ParseException ex) {
            Logger.getLogger(JFCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(jTFServicoCodigo.getText().equals("")){
            ServicosDAO.getInstance().persist(servicos);
        }else{
            servicos.setCodigo(Integer.parseInt(jTFServicoCodigo.getText()));
            ServicosDAO.getInstance().merge(servicos);
        }

        int cont = jTServicos.getRowCount();
        ServicoMecanico servico = new ServicoMecanico();        
        
        for(int i = 0; i < cont; i++){
            itemServico = new ItemServico();
            servico = new ServicoMecanico();
            servico = ServicoMecanicoDAO.getInstance().getById((int) jTServicos.getValueAt(i, 0));
            itemServico.setServicoMecanico(servico);
            itemServico.setServicos(servicos);
            itemServico.setQuantidade((int) jTServicos.getValueAt(i, 3));
            ItemServicoDAO.getInstance().persist(itemServico);
        }
        
        limpar();
        JOptionPane.showMessageDialog(this, " Serviço Prestado registrado com sucesso!");
        
    }//GEN-LAST:event_jBFinalizarServicosActionPerformed

    private void jBRemoverItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRemoverItemActionPerformed
        // TODO add your handling code here:
        
        DefaultTableModel dtm = (DefaultTableModel)jTServicos.getModel();
        if (jTServicos.getSelectedRow() >= 0){
            dtm.removeRow(jTServicos.getSelectedRow());
            jTServicos.setModel(dtm);
        }else{
            JOptionPane.showMessageDialog(null, "Favor selecionar uma linha");
        }
        
        somarValorTotal();
    }//GEN-LAST:event_jBRemoverItemActionPerformed

    private void jBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBuscarActionPerformed
        // TODO add your handling code here:
        
        new JFServicosBusca().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBuscarActionPerformed

    private void jBPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPagamentoActionPerformed
        // TODO add your handling code here:
        
        new JFPagamento().setVisible(true);
        jBFinalizarServicos.setEnabled(true);
    }//GEN-LAST:event_jBPagamentoActionPerformed
    
    public void preencherComboBox(){
        jCBServico.removeAllItems();
        String descricao = jTFDescricao.getText();
        for(ServicoMecanico c: servicosMecanicos){
            if(c.getDescricao().toUpperCase().startsWith(descricao.toUpperCase()))
            jCBServico.addItem(c.getDescricao());
        }
    }
    
    private void limpar(){
        jTFDescricao.setText("");
        jTFQuantidade.setText("");
        jTFValorTotal.setText("");
        
        DefaultTableModel dtm = (DefaultTableModel) jTServicos.getModel();
        dtm.setNumRows(0);
    }
    
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
            java.util.logging.Logger.getLogger(JFServicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFServicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFServicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFServicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFServicos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAdicionarItem;
    private javax.swing.JButton jBFinalizarServicos;
    private javax.swing.JButton jBPagamento;
    private javax.swing.JButton jBRemoverItem;
    private javax.swing.JButton jBTelaPrincipal;
    private javax.swing.JButton jBuscar;
    private javax.swing.JComboBox<String> jCBServico;
    private javax.swing.JFormattedTextField jFTFDataServico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFDescricao;
    private javax.swing.JTextField jTFQuantidade;
    private javax.swing.JTextField jTFServicoCodigo;
    private javax.swing.JTextField jTFValorTotal;
    private javax.swing.JTable jTServicos;
    // End of variables declaration//GEN-END:variables
}
