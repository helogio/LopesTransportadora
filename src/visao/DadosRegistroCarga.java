package visao;

import controle.FuncionarioControleDAO;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.Produto;
import modelo.Cliente;
import modelo.Carga;

/**
 *
 * @author giov
 */
public class DadosRegistroCarga extends javax.swing.JDialog {

    private Cliente clienteSelecionado = null;
    private Produto produtoSelecionado = null;
    private boolean confirmou = false;
    private int id;

    public DadosRegistroCarga(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);

        if(!"A".equals(FuncionarioControleDAO.getFuncLogado().getNivel())){
            fmtValor.setEnabled(false);
        }
    }

    public void desabilitar() {
        txtProcuraC.setEditable(false);
        btnPeesquisaProduto.setVisible(false);
        txtOrigem.setEditable(false);
        txtDestino.setEditable(false);
        txtProcuraP.setEditable(false);
        btnPesquisaCliente.setVisible(false);
        fmtQtdTotal.setEditable(false);
        fmtValor.setEditable(false);
        txtUniMed.setEditable(false);
        datAprovacao.setEnabled(false);
        btnSalvar.setVisible(false);

    }

    public void desabilitarApro() {
        txtProcuraC.setEditable(false);
        btnPeesquisaProduto.setVisible(false);
        txtOrigem.setEditable(false);
        txtDestino.setEditable(false);
        txtProcuraP.setEditable(false);
        btnPesquisaCliente.setVisible(false);
        fmtQtdTotal.setEditable(false);
        fmtValor.setEditable(false);
        txtUniMed.setEditable(false);
    }

    public Date getAprovacao() {
        return datAprovacao.getDate();
    }

    public boolean isConfirmou() {
        return confirmou;
    }

    public void setCarga(Carga c) {
        this.id = c.getIdCarga();
        this.clienteSelecionado = c.getCliente();
        this.produtoSelecionado = c.getProduto();

        txtProcuraC.setText(this.clienteSelecionado.getNome());
        txtOrigem.setText(c.getOrigem());
        txtDestino.setText(c.getDestino());
        fmtValor.setValue(c.getValorCarga());
        txtProcuraP.setText(this.produtoSelecionado.getTipo());
        fmtQtdTotal.setValue(((Number) c.getQtdeTotal()).doubleValue());
        txtUniMed.setText(c.getUnidadeMedida());
        datAprovacao.setDate(c.getDataAprovacao());
    }

    public Carga getCarga() {
        Carga c = new Carga();

        c.setIdCarga(this.id);
        c.setCliente(this.clienteSelecionado);
        c.setProduto(this.produtoSelecionado);
        c.setOrigem(txtOrigem.getText());
        c.setDestino(txtDestino.getText());
        c.setQtdeTotal(((Number) fmtQtdTotal.getValue()).doubleValue());
        c.setValorCarga(((Number) fmtValor.getValue()).doubleValue());
        c.setUnidadeMedida(txtUniMed.getText());
        c.setDataAprovacao(datAprovacao.getDate());

        c.setDataAprovacao(null);
        return c;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnPesquisaCliente = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtOrigem = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtDestino = new javax.swing.JTextField();
        txtProcuraC = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtProcuraP = new javax.swing.JTextField();
        btnPeesquisaProduto = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtUniMed = new javax.swing.JTextField();
        fmtQtdTotal = new javax.swing.JFormattedTextField();
        fmtValor = new javax.swing.JFormattedTextField();
        btnSalvar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        datAprovacao = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));

        jLabel1.setBackground(new java.awt.Color(0, 153, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registro da Carga");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(89, 89, 89))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Registro"));

        jLabel3.setText("Cliente");

        btnPesquisaCliente.setBackground(new java.awt.Color(0, 153, 255));
        btnPesquisaCliente.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btnPesquisaCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnPesquisaCliente.setText("?");
        btnPesquisaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaClienteActionPerformed(evt);
            }
        });

        jLabel7.setText("Origem");

        jLabel12.setText("Destino");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtProcuraC, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPesquisaCliente)
                        .addGap(14, 14, 14))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(txtOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(43, 43, 43)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12)))
                            .addComponent(jLabel3))
                        .addContainerGap(203, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPesquisaCliente)
                    .addComponent(txtProcuraC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Produto"));

        jLabel6.setText("Produto");

        btnPeesquisaProduto.setBackground(new java.awt.Color(0, 153, 255));
        btnPeesquisaProduto.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btnPeesquisaProduto.setForeground(new java.awt.Color(255, 255, 255));
        btnPeesquisaProduto.setText("?");
        btnPeesquisaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPeesquisaProdutoActionPerformed(evt);
            }
        });

        jLabel8.setText("Quantidade total");

        jLabel9.setText("Valor da carga");

        jLabel4.setText("Unidade de Medida");

        fmtQtdTotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));

        fmtValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtProcuraP, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnPeesquisaProduto))
                            .addComponent(jLabel6)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(fmtQtdTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(fmtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtUniMed, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 15, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(182, 182, 182)
                                .addComponent(jLabel9)
                                .addGap(84, 84, 84)
                                .addComponent(jLabel4))
                            .addComponent(jLabel8))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProcuraP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPeesquisaProduto))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fmtQtdTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUniMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fmtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnSalvar.setBackground(new java.awt.Color(0, 153, 255));
        btnSalvar.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btnSalvar.setForeground(new java.awt.Color(255, 255, 255));
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/salvar.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnSair.setBackground(new java.awt.Color(0, 153, 255));
        btnSair.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btnSair.setForeground(new java.awt.Color(255, 255, 255));
        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cruz-pequeno.png"))); // NOI18N
        btnSair.setText("Cancelar");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Data de Aprovação"));

        jLabel2.setText("Data");

        datAprovacao.setDateFormatString("dd/MM/yyyy");
        datAprovacao.setEnabled(false);
        datAprovacao.setMaxSelectableDate(new java.util.Date(253370779286000L));
        datAprovacao.setMinSelectableDate(new Date());

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datAprovacao, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(datAprovacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSair)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalvar))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSalvar)
                        .addComponent(btnSair)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaClienteActionPerformed
        PesquisarCli tela = new PesquisarCli(null, true);
        tela.setVisible(true);

        if (tela.isSelecionado()) {
            this.clienteSelecionado = tela.getClienteSelecionado();
            txtProcuraC.setText(this.clienteSelecionado.getNome());
        }
    }//GEN-LAST:event_btnPesquisaClienteActionPerformed

    private void btnPeesquisaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPeesquisaProdutoActionPerformed
        PesquisarProd tela = new PesquisarProd(null, true);
        tela.setVisible(true);
        if (tela.isSelecionado()) {
            txtProcuraP.setText(tela.getProdutoSelecionado().getTipo());
            this.produtoSelecionado = tela.getProdutoSelecionado();
        }
    }//GEN-LAST:event_btnPeesquisaProdutoActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (txtProcuraC.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "o cliente precisa ser preenchido.");
            txtProcuraC.requestFocus();
        } else if (txtOrigem.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "a origem precisa ser preenchida.");
            txtOrigem.requestFocus();
        } else if (txtDestino.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "o destino precisa ser preenchido.");
            txtDestino.requestFocus();
        } else if (txtProcuraP.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "o produto precisa ser preenchido.");
            txtProcuraP.requestFocus();
        } else if (fmtQtdTotal.getText() == null) {
            JOptionPane.showMessageDialog(null, "a qtde total precisa ser preenchida.");
            fmtQtdTotal.requestFocus();
        } else if (fmtValor.getText() == null) {
            JOptionPane.showMessageDialog(null, "o valor precisa ser preenchido.");
            fmtValor.requestFocus();
        } else if (txtUniMed.getText() == null) {
            JOptionPane.showMessageDialog(null, "a unidade de medida precisa ser preenchida.");
            txtUniMed.requestFocus();
        } else {
            this.confirmou = true;
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DadosRegistroCarga dialog = new DadosRegistroCarga(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnPeesquisaProduto;
    private javax.swing.JButton btnPesquisaCliente;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private com.toedter.calendar.JDateChooser datAprovacao;
    private javax.swing.JFormattedTextField fmtQtdTotal;
    private javax.swing.JFormattedTextField fmtValor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField txtDestino;
    private javax.swing.JTextField txtOrigem;
    private javax.swing.JTextField txtProcuraC;
    private javax.swing.JTextField txtProcuraP;
    private javax.swing.JTextField txtUniMed;
    // End of variables declaration//GEN-END:variables

}
