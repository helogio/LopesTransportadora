package visao;

import controle.FuncionarioControleDAO;
import java.awt.Frame;
/**
 *
 * @author giov
 */
public class Principal extends javax.swing.JFrame {
    
    public Principal() {
        initComponents();
        setExtendedState(Frame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        labNomeUsuario.setText(FuncionarioControleDAO.getFuncLogado().getNome());
    }

    public void setDesativarADM() {
        btnFunc.setVisible(false);
        labTipoAcesso.setText("Funcionário");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panDadosLogado = new javax.swing.JPanel();
        labNomeUsuario = new javax.swing.JLabel();
        labTipoAcesso = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        btnFunc = new javax.swing.JButton();
        btnColab = new javax.swing.JButton();
        btnCliente = new javax.swing.JButton();
        btnProduto = new javax.swing.JButton();
        btnEmbarque = new javax.swing.JButton();
        btnCarga = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBackground(new java.awt.Color(189, 211, 237));

        jPanel2.setBackground(new java.awt.Color(0, 153, 255));
        jPanel2.setLayout(new java.awt.GridLayout(1, 2, 0, 5));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LOGO-removebg-preview.png"))); // NOI18N
        jPanel2.add(jLabel1);

        panDadosLogado.setBackground(new java.awt.Color(0, 153, 255));

        labNomeUsuario.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        labNomeUsuario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labNomeUsuario.setText("Nome*");

        labTipoAcesso.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        labTipoAcesso.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labTipoAcesso.setText("Administrador");

        javax.swing.GroupLayout panDadosLogadoLayout = new javax.swing.GroupLayout(panDadosLogado);
        panDadosLogado.setLayout(panDadosLogadoLayout);
        panDadosLogadoLayout.setHorizontalGroup(
            panDadosLogadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panDadosLogadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panDadosLogadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labTipoAcesso, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
                    .addComponent(labNomeUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );
        panDadosLogadoLayout.setVerticalGroup(
            panDadosLogadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panDadosLogadoLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(labNomeUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labTipoAcesso)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jPanel2.add(panDadosLogado);

        btnSair.setBackground(new java.awt.Color(189, 211, 237));
        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sair-alt(1).png"))); // NOI18N
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        jPanel8.setBackground(new java.awt.Color(189, 211, 237));
        jPanel8.setLayout(new java.awt.GridLayout(1, 0, 3, 0));

        btnFunc.setBackground(new java.awt.Color(0, 153, 255));
        btnFunc.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btnFunc.setForeground(new java.awt.Color(255, 255, 255));
        btnFunc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/funcionario-homem-alt.png"))); // NOI18N
        btnFunc.setText("Funcionario");
        btnFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFuncActionPerformed(evt);
            }
        });
        jPanel8.add(btnFunc);

        btnColab.setBackground(new java.awt.Color(0, 153, 255));
        btnColab.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btnColab.setForeground(new java.awt.Color(255, 255, 255));
        btnColab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/adicionar-usuario.png"))); // NOI18N
        btnColab.setText("Colaborador");
        btnColab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColabActionPerformed(evt);
            }
        });
        jPanel8.add(btnColab);

        btnCliente.setBackground(new java.awt.Color(0, 153, 255));
        btnCliente.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btnCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/analise.png"))); // NOI18N
        btnCliente.setText("Cliente");
        btnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteActionPerformed(evt);
            }
        });
        jPanel8.add(btnCliente);

        btnProduto.setBackground(new java.awt.Color(0, 153, 255));
        btnProduto.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btnProduto.setForeground(new java.awt.Color(255, 255, 255));
        btnProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/trigo.png"))); // NOI18N
        btnProduto.setText("Produto");
        btnProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdutoActionPerformed(evt);
            }
        });
        jPanel8.add(btnProduto);

        btnEmbarque.setBackground(new java.awt.Color(0, 153, 255));
        btnEmbarque.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btnEmbarque.setForeground(new java.awt.Color(255, 255, 255));
        btnEmbarque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/seta-do-caminhao-para-a-direita.png"))); // NOI18N
        btnEmbarque.setText("Transporte");
        btnEmbarque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmbarqueActionPerformed(evt);
            }
        });
        jPanel8.add(btnEmbarque);

        btnCarga.setBackground(new java.awt.Color(0, 153, 255));
        btnCarga.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btnCarga.setForeground(new java.awt.Color(255, 255, 255));
        btnCarga.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/caminhao-medico.png"))); // NOI18N
        btnCarga.setText("Cargas");
        btnCarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargaActionPerformed(evt);
            }
        });
        jPanel8.add(btnCarga);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LOGO-removebg-preview.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(btnSair)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 292, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSair)))
        );

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargaActionPerformed
        ManutRegistroCarga tela = new ManutRegistroCarga(null, true);
        tela.setVisible(true);
    }//GEN-LAST:event_btnCargaActionPerformed

    private void btnEmbarqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmbarqueActionPerformed
        ManutTransporte tela = new ManutTransporte(null, true);
        tela.setVisible(true);
    }//GEN-LAST:event_btnEmbarqueActionPerformed

    private void btnProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdutoActionPerformed
        ManutProduto tela = new ManutProduto(null, true);
        tela.setVisible(true);
    }//GEN-LAST:event_btnProdutoActionPerformed

    private void btnColabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColabActionPerformed
        ManutColaborador tela = new ManutColaborador(null, true);
        tela.setVisible(true);
    }//GEN-LAST:event_btnColabActionPerformed

    private void btnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteActionPerformed
        ManutCliente tela = new ManutCliente(null, true);
        tela.setVisible(true);
    }//GEN-LAST:event_btnClienteActionPerformed

    private void btnFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFuncActionPerformed
        ManutFuncionario tela = new ManutFuncionario(null, true);
        tela.setVisible(true);
    }//GEN-LAST:event_btnFuncActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSairActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCarga;
    private javax.swing.JButton btnCliente;
    private javax.swing.JButton btnColab;
    private javax.swing.JButton btnEmbarque;
    private javax.swing.JButton btnFunc;
    private javax.swing.JButton btnProduto;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel labNomeUsuario;
    private javax.swing.JLabel labTipoAcesso;
    private javax.swing.JPanel panDadosLogado;
    // End of variables declaration//GEN-END:variables
}
