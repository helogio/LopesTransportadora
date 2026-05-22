package visao;

import controle.CargaControleDAO;
import controle.FuncionarioControleDAO;
import controle.PagamentoControleDAO;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Carga;
import modelo.Pagamento;
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
public class ManutRegistroCarga extends javax.swing.JDialog {

    private int tabelaSelecionada;
    private final Locale localMoeda = new Locale("pt", "BR");
    private List<Carga> lista1 = new ArrayList<>();
    private List<Carga> lista2 = new ArrayList<>();
    private final CargaControleDAO controleCarga = new CargaControleDAO();
    private final PagamentoControleDAO controlePagamento = new PagamentoControleDAO();

    private void atualizarTabela() {
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) tabela1.getModel();
        modelo.setRowCount(0);
        this.lista1.clear();
        this.lista1 = controleCarga.getPorNaoPaga();
        for (Carga c : lista1) {
            modelo.addRow(new Object[]{c.getCliente().getNome(), c.getProduto().getTipo(), NumberFormat.getCurrencyInstance(localMoeda).format(c.getValorCarga()), c.getOrigem(), c.getDestino()});
        }

        modelo = (DefaultTableModel) tabela2.getModel();
        modelo.setRowCount(0);
        this.lista2.clear();
        this.lista2 = controleCarga.getPorPaga();
        for (Carga c : lista2) {
            modelo.addRow(new Object[]{c.getCliente().getNome(), c.getProduto().getTipo(), NumberFormat.getCurrencyInstance(localMoeda).format(c.getValorCarga()), c.getOrigem(), c.getDestino()});
        }
    }

    private void atualizarTabela1(String pesquisa) {
        DefaultTableModel modelo = (DefaultTableModel) tabela1.getModel();
        modelo.setRowCount(0);
        this.lista1.clear();
        this.lista1 = controleCarga.getPorNaoPaga(pesquisa);
        for (Carga c : lista1) {
            modelo.addRow(new Object[]{c.getCliente().getNome(), c.getProduto().getTipo(), NumberFormat.getCurrencyInstance(localMoeda).format(c.getValorCarga()), c.getOrigem(), c.getDestino()});
        }
    }

    private void atualizarTabela2(String pesquisa) {
        DefaultTableModel modelo = (DefaultTableModel) tabela2.getModel();
        modelo.setRowCount(0);
        this.lista2.clear();
        this.lista2 = controleCarga.getPorPaga(pesquisa);
        for (Carga c : lista2) {
            modelo.addRow(new Object[]{c.getCliente().getNome(), c.getProduto().getTipo(), NumberFormat.getCurrencyInstance(localMoeda).format(c.getValorCarga()), c.getOrigem(), c.getDestino()});
        }
    }

    public ManutRegistroCarga(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        atualizarTabela();
 
        if (!"A".equals(FuncionarioControleDAO.getFuncLogado().getNivel())) {
            btnNovo.setEnabled(false);
//            btnPagar.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnNovo = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnVer = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnPagar = new javax.swing.JButton();
        btnAlterar1 = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
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
        jPanel9 = new javax.swing.JPanel();
        txtPesquisa2 = new javax.swing.JTextField();
        btnPesquisa2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela2 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        dataFim = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        dataInicio = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        btnRelatorioCarga = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(185, 209, 234));

        jPanel3.setBackground(new java.awt.Color(0, 153, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/semeadura-manual.png"))); // NOI18N
        jLabel1.setText("Manutenção do Registro");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(209, 209, 209)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(189, 211, 237));

        jPanel4.setBackground(new java.awt.Color(189, 211, 237));
        jPanel4.setLayout(new java.awt.GridLayout(8, 1, 0, 6));

        btnNovo.setBackground(new java.awt.Color(0, 153, 255));
        btnNovo.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btnNovo.setForeground(new java.awt.Color(255, 255, 255));
        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/adicionar.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });
        jPanel4.add(btnNovo);

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

        btnAlterar1.setBackground(new java.awt.Color(0, 153, 255));
        btnAlterar1.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btnAlterar1.setForeground(new java.awt.Color(255, 255, 255));
        btnAlterar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/caderno.png"))); // NOI18N
        btnAlterar1.setText("Nota fiscal");
        btnAlterar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterar1ActionPerformed(evt);
            }
        });
        jPanel4.add(btnAlterar1);

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
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        panTab1.setBackground(new java.awt.Color(0, 153, 255));

        labTitulo1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labTitulo1.setForeground(new java.awt.Color(255, 255, 255));
        labTitulo1.setText("Cargas esperando pagamento");

        tabela1.setBackground(new java.awt.Color(204, 204, 204));
        tabela1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tabela1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cliente", "Produto", "Valor", "Origem", "Destino"
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
                        .addGap(0, 208, Short.MAX_VALUE)
                        .addComponent(labTitulo1)
                        .addGap(0, 207, Short.MAX_VALUE))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Não Pagas", panTab1);

        panTab2.setBackground(new java.awt.Color(0, 153, 255));

        labTitulo2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labTitulo2.setForeground(new java.awt.Color(255, 255, 255));
        labTitulo2.setText("Cargas pagas");

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

        tabela2.setBackground(new java.awt.Color(204, 204, 204));
        tabela2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tabela2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cliente", "Produto", "Valor", "Origem", "Destino"
            }
        ));
        tabela2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabela2);

        javax.swing.GroupLayout panTab2Layout = new javax.swing.GroupLayout(panTab2);
        panTab2.setLayout(panTab2Layout);
        panTab2Layout.setHorizontalGroup(
            panTab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panTab2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panTab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panTab2Layout.createSequentialGroup()
                        .addGap(0, 278, Short.MAX_VALUE)
                        .addComponent(labTitulo2)
                        .addGap(0, 278, Short.MAX_VALUE))
                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Pagas", panTab2);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Relatório", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        dataFim.setMinSelectableDate(new Date());

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel4.setText("Data de Fim");

        dataInicio.setMinSelectableDate(new Date());

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

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dataFim, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRelatorioCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(dataFim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dataInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRelatorioCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jTabbedPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        int linha = tabela1.getSelectedRow();
        if (linha == -1 && this.tabelaSelecionada == 0) {
            JOptionPane.showMessageDialog(this, "Nenhuma carga foi selecionada");
        } else if (this.tabelaSelecionada == 1) {
            JOptionPane.showMessageDialog(this, "Ação indisponivel para esta tabela.");
        } else {
            Carga c = lista1.get(linha);
            if ("Aprovada".equals(c.getSituacao())) {
                JOptionPane.showMessageDialog(null, "Carga já foi aprovada, não é possível realizar alteração.");
            } else if (!controlePagamento.getPorCarga(c.getIdCarga()).isEmpty()) {
                JOptionPane.showMessageDialog(null, "Carga já foi paga, não é possível realizar alteração.");
            } else {
                DadosRegistroCarga tela = new DadosRegistroCarga(null, true);
                tela.setCarga(c);
                tela.setVisible(true);

                if (tela.isConfirmou()) {
                    controleCarga.alterar(tela.getCarga());
                    atualizarTabela();
                }
            }
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int linha = tabela1.getSelectedRow();
        if (linha == -1 && this.tabelaSelecionada == 0) {
            JOptionPane.showMessageDialog(this, "Nenhuma carga foi selecionada");
        } else if (this.tabelaSelecionada == 1) {
            JOptionPane.showMessageDialog(this, "Ação indisponivel para esta tabela.");
        } else {
            Carga c = lista1.get(linha);
            try {
                controleCarga.excluir(c.getIdCarga());
                atualizarTabela();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Não é possivel excluir carga!");
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed

        DadosRegistroCarga telaReg = new DadosRegistroCarga(null, true);
        telaReg.setVisible(true);

        if (telaReg.isConfirmou()) {
            Carga c = telaReg.getCarga();
            controleCarga.adicionar(c);
            atualizarTabela();
        }

    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerActionPerformed
        int linha = -1;
        switch (tabelaSelecionada) {
            case 0:
                linha = tabela1.getSelectedRow();
                break;
            case 1:
                linha = tabela2.getSelectedRow();
                break;
        }

        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Nenhuma carga foi selecionada");
        } else {
            Carga c;
            if (tabelaSelecionada == 0) {
                c = lista1.get(linha);
            } else {
                c = lista2.get(linha);
            }

            DadosRegistroCarga tela = new DadosRegistroCarga(null, true);
            tela.setCarga(c);
            tela.desabilitar();
            tela.setVisible(true);
        }
    }//GEN-LAST:event_btnVerActionPerformed

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
         int linha = tabela1.getSelectedRow();
        if (linha == -1 && this.tabelaSelecionada == 0) {
            JOptionPane.showMessageDialog(this, "Nenhuma carga foi selecionada");
        } else if (this.tabelaSelecionada == 1) {
            JOptionPane.showMessageDialog(this, "Ação indisponivel para esta tabela.");
        } else {
            Carga c;
            if (tabelaSelecionada == 0) {
                c = lista1.get(linha);
            } else {
                c = lista2.get(linha);
            }

            PagarCarga tela = new PagarCarga(null, true);
            tela.setCarga(c);
            tela.setVisible(true);
            atualizarTabela();
        }
    }//GEN-LAST:event_btnPagarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void tabela1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela1MouseClicked
        this.tabelaSelecionada = 0;
    }//GEN-LAST:event_tabela1MouseClicked

    private void btnPesquisa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisa1ActionPerformed
        atualizarTabela1(txtPesquisa1.getText());
    }//GEN-LAST:event_btnPesquisa1ActionPerformed

    private void btnRelatorioCargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioCargaActionPerformed
        CargaControleDAO controle = new CargaControleDAO();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            JasperReport relatorioCompilado
                    = JasperCompileManager.compileReport("src/relatorio/RelatorioCarga.jrxml");

            Map<String, Object> parametros = new HashMap<>();
            parametros.put("dataInicio", dataInicio.getDate());
            parametros.put("dataFinal", sdf.format(dataFim.getDate()));

            JasperPrint relatorioPreenchido = JasperFillManager.fillReport(relatorioCompilado, parametros,
                    new JRBeanCollectionDataSource(controle.getTodosOrdemCliente()));

            JDialog tela = new JDialog(this, "Relatório de Cargas", true);
            tela.setSize(850, 800);
            tela.setLocationRelativeTo(null);

            JRViewer painelRelatorio = new JRViewer(relatorioPreenchido);
            tela.getContentPane().add(painelRelatorio);

            tela.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRelatorioCargaActionPerformed

    private void tabela2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela2MouseClicked
        this.tabelaSelecionada = 1;
    }//GEN-LAST:event_tabela2MouseClicked

    private void btnPesquisa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisa2ActionPerformed
        atualizarTabela2(txtPesquisa2.getText());
    }//GEN-LAST:event_btnPesquisa2ActionPerformed

    private void btnAlterar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterar1ActionPerformed
        int linhaTabela1 = tabela1.getSelectedRow();
        int linhaTabela2 = tabela2.getSelectedRow();

        if (linhaTabela1 == -1 && this.tabelaSelecionada == 0 && linhaTabela2 == -1 && this.tabelaSelecionada == 1) {
            JOptionPane.showMessageDialog(this, "Nenhuma carga foi selecionada");
        } else {
            List<Carga> cargas = new ArrayList<>();

            if (this.tabelaSelecionada == 0) {
                cargas.add(lista1.get(linhaTabela1));
            } else {
                cargas.add(lista2.get(linhaTabela2));
            }

            try {

                JasperReport relatorioCompilado
                        = JasperCompileManager.compileReport("src/relatorio/NotaFiscal.jrxml");

                JasperPrint relatorioPreenchido = JasperFillManager.fillReport(relatorioCompilado, null, //mudar quando tiver parametro
                        new JRBeanCollectionDataSource(cargas));

                JDialog tela = new JDialog(this, "Relatório de Carga", true);
                tela.setSize(850, 800);
                tela.setLocationRelativeTo(null);

                JRViewer painelRelatorio = new JRViewer(relatorioPreenchido);

                tela.getContentPane().add(painelRelatorio);

                tela.setVisible(true);

            } catch (JRException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Erro ao gerar o relatório da Carga!!");
            }

        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnAlterar1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ManutRegistroCarga dialog = new ManutRegistroCarga(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAlterar1;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton btnPesquisa1;
    private javax.swing.JButton btnPesquisa2;
    private javax.swing.JButton btnRelatorioCarga;
    private javax.swing.JButton btnVer;
    private javax.swing.JButton btnVoltar;
    private com.toedter.calendar.JDateChooser dataFim;
    private com.toedter.calendar.JDateChooser dataInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
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
