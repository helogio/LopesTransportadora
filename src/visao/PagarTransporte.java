package visao;

import controle.PagamentoTransporteControleDAO;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.PagamentoTransporte;
import modelo.Transporte;

/**
 *
 * @author giov
 */
public class PagarTransporte extends javax.swing.JDialog {

    private Transporte transporte = new Transporte();
    private final List<PagamentoTransporte> listaPagamentos = new ArrayList<>();
    private final PagamentoTransporteControleDAO controlePagamentoTransporte = new PagamentoTransporteControleDAO();
    private final Locale localMoeda = new Locale("pt", "BR");
    
    public PagarTransporte(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public List<PagamentoTransporte> getPagamento(){
        return listaPagamentos;
    }
    
    public void atualizarTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tabPagamento.getModel();
        modelo.setRowCount(0);

        listaPagamentos.clear();
        listaPagamentos.addAll(controlePagamentoTransporte.getPorIdTransporte(transporte.getIdTransporte()));

        for (PagamentoTransporte p : listaPagamentos) {
            modelo.addRow(new Object[]{p.getIdPagamentoTransporte(), NumberFormat.getCurrencyInstance(localMoeda).format(p.getValorParcela()), p.getDataVencimentoFormatado(), p.getSituacaoPagamento()});
        }
    }

    public void setTransporte(Transporte transporte) {
        this.transporte = transporte;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabPagamento = new javax.swing.JTable();
        panBtns = new javax.swing.JPanel();
        btnVoltar = new javax.swing.JButton();
        btnPagar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBackground(new java.awt.Color(185, 209, 234));

        jPanel5.setBackground(new java.awt.Color(0, 153, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mao-segurando-usd.png"))); // NOI18N
        jLabel1.setText("Pagamento de Transporte");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(jLabel1)
                .addContainerGap(94, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabPagamento.setBackground(new java.awt.Color(204, 204, 204));
        tabPagamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N° Parcela", "Valor", "Data Vendimento", "Data Pagamento"
            }
        ));
        jScrollPane1.setViewportView(tabPagamento);

        panBtns.setBackground(new java.awt.Color(185, 209, 234));
        panBtns.setLayout(new java.awt.GridLayout(1, 3, 12, 0));

        btnVoltar.setBackground(new java.awt.Color(0, 153, 255));
        btnVoltar.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btnVoltar.setForeground(new java.awt.Color(255, 255, 255));
        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/seta-para-a-esquerda.png"))); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });
        panBtns.add(btnVoltar);

        btnPagar.setBackground(new java.awt.Color(0, 153, 255));
        btnPagar.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btnPagar.setForeground(new java.awt.Color(255, 255, 255));
        btnPagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/circulo-usd.png"))); // NOI18N
        btnPagar.setText("Pagar");
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });
        panBtns.add(btnPagar);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(panBtns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panBtns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed


    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        int linha = tabPagamento.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Nenhuma parcela foi selecionada!");
        } else {
            if(listaPagamentos.get(linha).getDataPagamento() != null){
                JOptionPane.showMessageDialog(null, "Esta parcela já foi paga!");
            }else{
                int resposta = JOptionPane.showConfirmDialog(null,
                        "Deseja pagar essa parcela?",
                        "Pagar Transporte",
                        JOptionPane.YES_NO_OPTION);

                if (resposta == JOptionPane.YES_OPTION) {
                    PagamentoTransporte p = listaPagamentos.get(linha);
                    p.setDataPagamento(new Date());
                    listaPagamentos.set(linha, p);
                    controlePagamentoTransporte.alterar(p);
                    atualizarTabela();
                }
            }

        }
    }//GEN-LAST:event_btnPagarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PagarTransporte dialog = new PagarTransporte(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panBtns;
    private javax.swing.JTable tabPagamento;
    // End of variables declaration//GEN-END:variables
}
