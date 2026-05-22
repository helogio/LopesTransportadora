package visao;

import controle.CargaControleDAO;
import controle.TransporteControleDAO;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Carga;
import modelo.PagamentoTransporte;
import modelo.Transporte;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author giov
 */
public class ManutTransporte extends javax.swing.JDialog {

    private List<Transporte> lista1 = new ArrayList<>();
    private List<Transporte> lista2 = new ArrayList<>();
    private final Locale localMoeda = new Locale("pt", "BR");

    private int tabelaSelecionada = -1;

    private final TransporteControleDAO controleTransporte = new TransporteControleDAO();
    private final CargaControleDAO controleCarga = new CargaControleDAO();

    public ManutTransporte(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);

        atualizarTabela();
    }

    private void atualizarTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tabela1.getModel();
        modelo.setRowCount(0);
        this.lista1.clear();
        this.lista1 = controleTransporte.getPorEmAndamento();
        for (Transporte t : lista1) {

            modelo.addRow(new Object[]{t.getColaborador().getNome(), t.getCarga().getCliente().getNome(), t.getCarga().getProduto().getTipo(), t.getDataCarregouFormatado(), t.getPagouTudo(), NumberFormat.getCurrencyInstance(localMoeda).format(t.getValorFrete())});
        }

        modelo = (DefaultTableModel) tabela2.getModel();
        modelo.setRowCount(0);
        this.lista2.clear();
        this.lista2 = controleTransporte.getPorFinalizado();
        for (Transporte t : lista2) {

            modelo.addRow(new Object[]{t.getColaborador().getNome(), t.getCarga().getCliente().getNome(), t.getCarga().getProduto().getTipo(), t.getDataCarregouFormatado(), t.getPagouTudo(), NumberFormat.getCurrencyInstance(localMoeda).format(t.getValorFrete())});
        }
    }

    private void atualizarTabela1(String pesquisa) {
        DefaultTableModel modelo = (DefaultTableModel) tabela1.getModel();
        modelo.setRowCount(0);
        this.lista1.clear();
        this.lista1 = controleTransporte.getPorEmAndamentoPesquisa(pesquisa);
        for (Transporte t : lista1) {

            modelo.addRow(new Object[]{t.getColaborador().getNome(), t.getCarga().getCliente().getNome(), t.getCarga().getProduto().getTipo(), t.getDataCarregouFormatado(), t.getPagouTudo(), NumberFormat.getCurrencyInstance(localMoeda).format(t.getValorFrete())});
        }
    }

    private void atualizarTabela2(String pesquisa) {
        DefaultTableModel modelo = (DefaultTableModel) tabela2.getModel();
        modelo.setRowCount(0);
        this.lista2.clear();
        this.lista2 = controleTransporte.getPorFinalizadoPesquisa(pesquisa);
        for (Transporte t : lista2) {

            modelo.addRow(new Object[]{t.getColaborador().getNome(), t.getCarga().getCliente().getNome(), t.getCarga().getProduto().getTipo(), t.getDataCarregouFormatado(), t.getPagouTudo(), NumberFormat.getCurrencyInstance(localMoeda).format(t.getValorFrete())});
        }
    }

    private boolean todasParcelasPagas(Transporte t) {
        for (PagamentoTransporte p : t.getPagamento()) {
            if (p.getDataPagamento() == null) {
                return false;
            }
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        panTab1 = new javax.swing.JPanel();
        labTitulo1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela1 = new javax.swing.JTable();
        panPesquisa = new javax.swing.JPanel();
        txtPesquisa1 = new javax.swing.JTextField();
        btnPesquisa1 = new javax.swing.JButton();
        panTab2 = new javax.swing.JPanel();
        labTitulo2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela2 = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        txtPesquisa2 = new javax.swing.JTextField();
        btnPesquisa2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnNovo = new javax.swing.JButton();
        btnDesembarque = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnVer = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnPagar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        dataFim = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        datainicio = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        btnRelatorioCarga = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(189, 211, 237));

        jPanel2.setBackground(new java.awt.Color(0, 153, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/seta-do-caminhao-para-a-direita.png"))); // NOI18N
        jLabel1.setText("Transporte");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panTab1.setBackground(new java.awt.Color(0, 153, 255));

        labTitulo1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labTitulo1.setForeground(new java.awt.Color(255, 255, 255));
        labTitulo1.setText("Em andamento");

        tabela1.setBackground(new java.awt.Color(204, 204, 204));
        tabela1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tabela1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Colaborador", "Cliente", "Produto", "Embarque", "Pagamentos", "Valor"
            }
        ));
        tabela1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela1);

        panPesquisa.setBackground(new java.awt.Color(0, 153, 255));

        txtPesquisa1.setPreferredSize(new java.awt.Dimension(350, 23));

        btnPesquisa1.setText("Procurar");
        btnPesquisa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisa1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panPesquisaLayout = new javax.swing.GroupLayout(panPesquisa);
        panPesquisa.setLayout(panPesquisaLayout);
        panPesquisaLayout.setHorizontalGroup(
            panPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panPesquisaLayout.createSequentialGroup()
                .addComponent(txtPesquisa1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPesquisa1))
        );
        panPesquisaLayout.setVerticalGroup(
            panPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panPesquisaLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(panPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPesquisa1)
                    .addComponent(txtPesquisa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout panTab1Layout = new javax.swing.GroupLayout(panTab1);
        panTab1.setLayout(panTab1Layout);
        panTab1Layout.setHorizontalGroup(
            panTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panTab1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(panTab1Layout.createSequentialGroup()
                        .addGap(0, 284, Short.MAX_VALUE)
                        .addComponent(labTitulo1)
                        .addGap(0, 284, Short.MAX_VALUE))
                    .addComponent(panPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panTab1Layout.setVerticalGroup(
            panTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panTab1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labTitulo1)
                .addGap(6, 6, 6)
                .addComponent(panPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Em andamento", panTab1);

        panTab2.setBackground(new java.awt.Color(0, 153, 255));

        labTitulo2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labTitulo2.setForeground(new java.awt.Color(255, 255, 255));
        labTitulo2.setText("Realizados");

        tabela2.setBackground(new java.awt.Color(204, 204, 204));
        tabela2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tabela2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Colaborador", "Cliente", "Produto", "Embarque", "Pagamento", "Valor"
            }
        ));
        tabela2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabela2);

        jPanel9.setBackground(new java.awt.Color(0, 153, 255));

        txtPesquisa2.setPreferredSize(new java.awt.Dimension(350, 23));

        btnPesquisa2.setText("Procurar");
        btnPesquisa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisa2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(txtPesquisa2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPesquisa2))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPesquisa2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisa2))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout panTab2Layout = new javax.swing.GroupLayout(panTab2);
        panTab2.setLayout(panTab2Layout);
        panTab2Layout.setHorizontalGroup(
            panTab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panTab2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panTab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addGroup(panTab2Layout.createSequentialGroup()
                        .addGap(0, 302, Short.MAX_VALUE)
                        .addComponent(labTitulo2)
                        .addGap(0, 303, Short.MAX_VALUE))
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panTab2Layout.setVerticalGroup(
            panTab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panTab2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labTitulo2)
                .addGap(6, 6, 6)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Realizados", panTab2);

        jPanel5.setBackground(new java.awt.Color(189, 211, 237));

        jPanel4.setBackground(new java.awt.Color(189, 211, 237));
        jPanel4.setLayout(new java.awt.GridLayout(8, 1, 0, 6));

        btnNovo.setBackground(new java.awt.Color(0, 153, 255));
        btnNovo.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btnNovo.setForeground(new java.awt.Color(255, 255, 255));
        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/seta-do-caminhao-para-a-direita.png"))); // NOI18N
        btnNovo.setText("Embarque");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });
        jPanel4.add(btnNovo);

        btnDesembarque.setBackground(new java.awt.Color(0, 153, 255));
        btnDesembarque.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btnDesembarque.setForeground(new java.awt.Color(255, 255, 255));
        btnDesembarque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/seta-do-caminhao-para-a-esquerda.png"))); // NOI18N
        btnDesembarque.setText("Desembarque");
        btnDesembarque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesembarqueActionPerformed(evt);
            }
        });
        jPanel4.add(btnDesembarque);

        btnAlterar.setBackground(new java.awt.Color(0, 153, 255));
        btnAlterar.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btnAlterar.setForeground(new java.awt.Color(255, 255, 255));
        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/vire-a-esquerda.png"))); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        jPanel4.add(btnAlterar);

        btnVer.setBackground(new java.awt.Color(0, 153, 255));
        btnVer.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btnVer.setForeground(new java.awt.Color(255, 255, 255));
        btnVer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/visao-geral.png"))); // NOI18N
        btnVer.setText("Ver");
        btnVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerActionPerformed(evt);
            }
        });
        jPanel4.add(btnVer);

        btnExcluir.setBackground(new java.awt.Color(0, 153, 255));
        btnExcluir.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btnExcluir.setForeground(new java.awt.Color(255, 255, 255));
        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/marca-de-lixo.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        jPanel4.add(btnExcluir);

        btnPagar.setBackground(new java.awt.Color(0, 153, 255));
        btnPagar.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btnPagar.setForeground(new java.awt.Color(255, 255, 255));
        btnPagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mao-segurando-usd.png"))); // NOI18N
        btnPagar.setText("Pagar");
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });
        jPanel4.add(btnPagar);

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

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVoltar)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Relatório", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel4.setText("Data de Fim");

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel3.setText("Data de Inicio");

        btnRelatorioCarga.setBackground(new java.awt.Color(0, 153, 255));
        btnRelatorioCarga.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btnRelatorioCarga.setForeground(new java.awt.Color(255, 255, 255));
        btnRelatorioCarga.setText("Gerar Retório");
        btnRelatorioCarga.setPreferredSize(new java.awt.Dimension(37, 37));
        btnRelatorioCarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorioCargaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(datainicio, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dataFim, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRelatorioCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(dataFim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(datainicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRelatorioCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jTabbedPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(3, 3, 3))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        DadosTransporte tela = new DadosTransporte(null, true);
        tela.setVisible(true);
        if (tela.isConfirmou()) {
            Transporte t = tela.getTransporte();

            for (int i = 0; i < t.getPagamento().size(); i++) {
                PagamentoTransporte p = t.getPagamento().get(i);
                p.setTransporte(t);
                t.getPagamento().set(i, p);
            }
            Carga c = t.getCarga();
            c.setQtdeTransportada(c.getQtdeTransportada() + t.getQtde());
            controleCarga.alterar(c);
            controleTransporte.adicionar(t);
            atualizarTabela();
        }
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnDesembarqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesembarqueActionPerformed
        int linha = -1;
        switch (tabelaSelecionada) {
            case 0 ->
                linha = tabela1.getSelectedRow();
            case 1 ->
                linha = tabela2.getSelectedRow();
        }

        if (linha == -1 && tabelaSelecionada == 0) {
            JOptionPane.showMessageDialog(this, "Nenhum transporte foi selecionado");
        } else if (tabelaSelecionada == 0) {
            Transporte t = lista1.get(linha);
            // Verificar se o transporte tem parcelas pendentes
            if ("Pendente".equals(t.getPagouTudo())) {
                JOptionPane.showMessageDialog(this, "Este transporte tem parcelas pendentes e não pode ser desembarcado.");
            } else if (t.getDataDescarregou() == null) {
                DesembarcarTrasnporte tela = new DesembarcarTrasnporte(null, true);
                tela.setVisible(true);
                if (tela.isConfirmou()) {
                    t.setDataDescarregou(tela.getDataDesembarque());
                    controleTransporte.alterar(t);
                    atualizarTabela();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Item já foi desembarcado!");
            }

        } else {
            JOptionPane.showMessageDialog(this, "Ação indisponível para esta tabela.");
        }
    }//GEN-LAST:event_btnDesembarqueActionPerformed

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        int linha = tabela1.getSelectedRow();
        if (linha == -1 && this.tabelaSelecionada == 0) {
            JOptionPane.showMessageDialog(this, "Nenhuma carga foi selecionada");
        } else if (this.tabelaSelecionada == 1) {
            JOptionPane.showMessageDialog(this, "Ação indisponivel para esta tabela.");
        } else {

            PagarTransporte tela = new PagarTransporte(null, true);
            if (tabelaSelecionada == 0) {
                tela.setTransporte(lista1.get(linha));
                lista1.get(linha).setPagamento(tela.getPagamento());
            } else {
                tela.setTransporte(lista2.get(linha));
                lista2.get(linha).setPagamento(tela.getPagamento());
            }

            tela.atualizarTabela();
            tela.setVisible(true);

            atualizarTabela();
        }


    }//GEN-LAST:event_btnPagarActionPerformed

    private void btnVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerActionPerformed
        int linha = -1;
        switch (tabelaSelecionada) {
            case 0:
                linha = tabela1.getSelectedRow();
                break;
            case 1:
                linha = tabela2.getSelectedRow();
                break;
            default:
                throw new AssertionError();
        }
        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Nenhum transporte foi selecionado");
        } else {
            Transporte t;
            if (tabelaSelecionada == 0) {
                t = lista1.get(linha);

            } else {
                t = lista2.get(linha);
            }
            DadosTransporte tela = new DadosTransporte(null, true);
            tela.desabilitar();
            tela.setTransporte(t);

            tela.setVisible(true);
        }
    }//GEN-LAST:event_btnVerActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int linha = -1;
        switch (tabelaSelecionada) {
            case 0 ->
                linha = tabela1.getSelectedRow();
            case 1 ->
                linha = tabela2.getSelectedRow();
        }

        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Nenhum transporte foi selecionado");
        } else {
            Transporte t;
            if (tabelaSelecionada == 0) {
                t = lista1.get(linha);
            } else {
                t = lista2.get(linha);
            }
            if (t.getIsPagamento()) {
                Carga c = t.getCarga();
                c.setQtdeTotal(c.getQuantRestante() + t.getQtde());
                c.setQtdeTransportada(c.getQtdeTransportada() - t.getQtde());
                controleCarga.alterar(c);

                controleTransporte.excluir(t);
                atualizarTabela();

            } else {
                JOptionPane.showMessageDialog(this, "Não é possível excluir esse transporte!");
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void tabela2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela2MouseClicked
        this.tabelaSelecionada = 1;
    }//GEN-LAST:event_tabela2MouseClicked

    private void tabela1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela1MouseClicked
        this.tabelaSelecionada = 0;
    }//GEN-LAST:event_tabela1MouseClicked

    private void btnPesquisa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisa1ActionPerformed
        atualizarTabela1(txtPesquisa1.getText());
    }//GEN-LAST:event_btnPesquisa1ActionPerformed

    private void btnRelatorioCargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioCargaActionPerformed
        TransporteControleDAO controle = new TransporteControleDAO();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            JasperReport relatorioCompilado
                    = JasperCompileManager.compileReport("src/relatorio/Transporte.jrxml");

            Map<String, Object> parametros = new HashMap<>();
            parametros.put("dataInicio", datainicio.getDate());
            parametros.put("dataFinal", sdf.format(dataFim.getDate()));

            JasperPrint relatorioPreenchido = JasperFillManager.fillReport(relatorioCompilado, parametros,
                    new JRBeanCollectionDataSource(controle.getTodosOrdemColab()));

            JDialog tela = new JDialog(this, "Relatório de Transportes", true);
            tela.setSize(850, 800);
            tela.setLocationRelativeTo(null);

            JRViewer painelRelatorio = new JRViewer(relatorioPreenchido);
            tela.getContentPane().add(painelRelatorio);

            tela.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnRelatorioCargaActionPerformed

    private void btnPesquisa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisa2ActionPerformed
        atualizarTabela2(txtPesquisa2.getText());
    }//GEN-LAST:event_btnPesquisa2ActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        int linha = tabela1.getSelectedRow();
        if (linha == -1 && this.tabelaSelecionada == 0) {
            JOptionPane.showMessageDialog(this, "Nenhuma Transporte foi selecionadp");
        } else if (this.tabelaSelecionada == 1) {
            JOptionPane.showMessageDialog(this, "Ação indisponivel para esta tabela.");
        } else {
            Transporte t = lista1.get(linha);
            if (todasParcelasPagas(t)) {
                JOptionPane.showMessageDialog(null, "Transporte já foi pago, não é possível realizar alteração.");
            } else {
                DadosTransporte tela = new DadosTransporte(null, true);
                tela.setTransporte(t);
                tela.setVisible(true);
                tela.desabilitarDes();
                if (tela.isConfirmou()) {
                    lista1.set(linha, tela.getTransporte());
                    controleTransporte.alterar(tela.getTransporte());
                    atualizarTabela();
                }
            }
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ManutTransporte dialog = new ManutTransporte(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnDesembarque;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton btnPesquisa1;
    private javax.swing.JButton btnPesquisa2;
    private javax.swing.JButton btnRelatorioCarga;
    private javax.swing.JButton btnVer;
    private javax.swing.JButton btnVoltar;
    private com.toedter.calendar.JDateChooser dataFim;
    private com.toedter.calendar.JDateChooser datainicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel labTitulo1;
    private javax.swing.JLabel labTitulo2;
    private javax.swing.JPanel panPesquisa;
    private javax.swing.JPanel panTab1;
    private javax.swing.JPanel panTab2;
    private javax.swing.JTable tabela1;
    private javax.swing.JTable tabela2;
    private javax.swing.JTextField txtPesquisa1;
    private javax.swing.JTextField txtPesquisa2;
    // End of variables declaration//GEN-END:variables
}
