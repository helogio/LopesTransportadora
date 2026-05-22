package visao;

import controle.CargaControleDAO;
import controle.FuncionarioControleDAO;
import controle.PagamentoControleDAO;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import modelo.Carga;
import modelo.Pagamento;

/**
 *
 * @author giov
 */
public class PagarCarga extends javax.swing.JDialog {

    private Carga carga = new Carga();
    private final List<Pagamento> listaPagamentos = new ArrayList<>();
    private final PagamentoControleDAO controlePagamentoCarga = new PagamentoControleDAO();
    private final CargaControleDAO controleCarga = new CargaControleDAO();

    private final Locale localMoeda = new Locale("pt", "BR");
    private boolean confirmou = false;

    public PagarCarga(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);

        DefaultTableCellRenderer centralizarRenderer = new DefaultTableCellRenderer();
        centralizarRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        tabPagamento.getColumnModel().getColumn(0).setPreferredWidth(100); // ID da Carga
        tabPagamento.getColumnModel().getColumn(1).setPreferredWidth(100); // Valor
        tabPagamento.getColumnModel().getColumn(2).setPreferredWidth(120); // Data de Aprovação (Pendente ou Data)

        for (int i = 0; i < 3; i++) {
            tabPagamento.getColumnModel().getColumn(i).setCellRenderer(centralizarRenderer);
            tabPagamento.getColumnModel().getColumn(i).setCellRenderer(centralizarRenderer); // Data de Aprovação
        }

    }

    public void atualizarTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tabPagamento.getModel();

        modelo.setRowCount(0); // Limpa a tabela antes de adicionar novos dados

        // Adiciona os dados da carga na tabela
        modelo.addRow(new Object[]{
            carga.getIdCarga(), // ID da carga
            NumberFormat.getCurrencyInstance(localMoeda).format(carga.getValorCarga()),
            carga.getDataAprovacao() == null ? "Pendente" : carga.getDataAprovacao() // Exibe "Pendente" ou a data, sem toString
        });
    }

    public void setCarga(Carga transporte) {
        this.carga = transporte;
        atualizarTabela();
    }

    public boolean isConfirmou() {
        return confirmou;
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
        jLabel1.setText("Pagamento de Carga");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(jLabel1)
                .addContainerGap(85, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabPagamento.setBackground(new java.awt.Color(204, 204, 204));
        tabPagamento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tabPagamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Carga", "Valor Total", "Data Pagamento"
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panBtns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnVoltarActionPerformed


    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        int linha = tabPagamento.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Nenhum pagamento foi selecionado!");
        } else {

            int idCarga = (int) tabPagamento.getValueAt(linha, 0);  // A coluna 0 deve conter o ID da carga, ajuste conforme necessário
            Carga cargaSelecionada = controleCarga.getCargaPorId(idCarga);

            // Verifica se já foi pago
            if (controlePagamentoCarga.getPorCarga(cargaSelecionada.getIdCarga()).isEmpty()) {
                // Se não houver pagamento, solicita confirmação
                int resposta = JOptionPane.showConfirmDialog(null,
                        "Deseja realmente pagar?",
                        "Confirmação",
                        JOptionPane.YES_NO_OPTION);

                if (resposta == JOptionPane.YES_OPTION) {
                    // Cria o pagamento
                    Pagamento p = new Pagamento();
                    p.setCarga(cargaSelecionada);
                    p.setDataPagamento(new Date()); // Data de pagamento
                    p.setFuncionario(FuncionarioControleDAO.getFuncLogado()); // Funcionario logado
                    p.setValorTotal(cargaSelecionada.getValorCarga()); // Valor da carga
                    controlePagamentoCarga.adicionar(p); // Adiciona o pagamento no banco de dados

                    // Atualiza a carga (se necessário)
                    cargaSelecionada.setDataAprovacao(new Date()); // Marca a data de aprovação
                    controleCarga.alterar(cargaSelecionada); // Atualiza a carga no banco

                    atualizarTabela(); // Atualiza a tabela para refletir o pagamento

                    // Define que o pagamento foi confirmado e fecha a tela
                    confirmou = true;
                    setVisible(false);
                }
            } else {
                // Se já houve pagamento
                JOptionPane.showMessageDialog(null, "Esta carga já foi paga!");
            }
        }
    }//GEN-LAST:event_btnPagarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PagarCarga dialog = new PagarCarga(new javax.swing.JFrame(), true);
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
