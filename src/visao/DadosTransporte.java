package visao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Carga;
import modelo.Colaborador;
import modelo.PagamentoTransporte;
import modelo.Transporte;

/**
 *
 * @author giov
 */
public class DadosTransporte extends javax.swing.JDialog {

    private Carga cargaSelecionada = new Carga();
    private Colaborador colaboSelecionado = new Colaborador();
    private double valorFrete = 0;
    private int codigo = 0;

    private List<PagamentoTransporte> pagamentos = new ArrayList<>();
    private boolean confirmou = false;

    public DadosTransporte(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        dataDesembarque.setVisible(false);
        dateDesembarque.setVisible(false);
    }

    public boolean isConfirmou() {
        return confirmou;
    }

    private void atualizarCarga() {
        txtOrigem.setText(cargaSelecionada.getOrigem());
        txtDestino.setText(cargaSelecionada.getDestino());
        fmtQtdeDisponivel.setValue(cargaSelecionada.getQuantRestante());
        txtProduto.setText(cargaSelecionada.getProduto().getTipo());
    }

    private void atualizarColaborador() {
        txtNome.setText(colaboSelecionado.getNome());
        txtCPF.setText(colaboSelecionado.getCpf());
        txtTelefone.setText(colaboSelecionado.getTelefone());
    }

    private void atualizaTabelaParcela() {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setRowCount(0);

        for (PagamentoTransporte p : pagamentos) {
            modelo.addRow(new Object[]{p.getValorParcela(), p.getDataVencimentoFormatado(), p.getSituacaoPagamento()});
        }
    }

    public void desabilitar() {
        btnCarga.setVisible(false);
        btnColab.setVisible(false);
        datEmbarque.setEnabled(false);
        fmtQtdeLevada.setEditable(false);
        fmtValorTrans.setEditable(false);
        datVencimento.setEnabled(false);
        btnGerar.setVisible(false);
        dateDesembarque.setEnabled(false);

    }

    public void desabilitarDes() {
        btnCarga.setVisible(false);
        btnColab.setVisible(false);
        datEmbarque.setEnabled(false);
        fmtQtdeLevada.setEditable(false);
        fmtValorTrans.setEditable(false);
        datVencimento.setEnabled(false);
        btnGerar.setVisible(false);
    }

    public void habilitarINputs() {
        dataDesembarque.setVisible(true);
        dateDesembarque.setVisible(true);
    }

    public Transporte getTransporte() {
        Transporte t = new Transporte();
        t.setIdTransporte(codigo);
        t.setCarga(cargaSelecionada);
        t.setColaborador(colaboSelecionado);
        t.setDataCarregou(datEmbarque.getDate());
        t.setQtde(Double.parseDouble(fmtQtdeLevada.getValue().toString()));
        t.setPagamento(pagamentos);
        t.setValorFrete(this.valorFrete);
        t.setDataDescarregou(dateDesembarque.getDate());
        return t;
    }

    public void setTransporte(Transporte t) {
        this.codigo = t.getIdTransporte();
        cargaSelecionada = t.getCarga();
        colaboSelecionado = t.getColaborador();
        pagamentos = t.getPagamento();
        valorFrete = t.getValorFrete();
        atualizarCarga();
        atualizarColaborador();
        atualizaTabelaParcela();
        datEmbarque.setDate(t.getDataCarregou());
        fmtQtdeLevada.setValue(t.getQtde());
        dateDesembarque.setDate(t.getDataDescarregou());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnCarga = new javax.swing.JButton();
        panInputsCarga = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtProduto = new javax.swing.JTextField();
        fmtQtdeDisponivel = new javax.swing.JFormattedTextField();
        txtDestino = new javax.swing.JTextField();
        txtOrigem = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnColab = new javax.swing.JButton();
        txtTelefone = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCPF = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        datEmbarque = new com.toedter.calendar.JDateChooser();
        fmtQtdeLevada = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        dataDesembarque = new javax.swing.JLabel();
        dateDesembarque = new com.toedter.calendar.JDateChooser();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        panGerarParcelas = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        fmtValorTrans = new javax.swing.JFormattedTextField();
        datVencimento = new com.toedter.calendar.JDateChooser();
        panVazio = new javax.swing.JPanel();
        btnGerar = new javax.swing.JButton();
        panBtnsFooter = new javax.swing.JPanel();
        btnSair = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));

        jLabel1.setBackground(new java.awt.Color(0, 153, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Dados do Embarque");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Carga"));

        btnCarga.setBackground(new java.awt.Color(0, 153, 255));
        btnCarga.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btnCarga.setForeground(new java.awt.Color(255, 255, 255));
        btnCarga.setText("Selecione");
        btnCarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargaActionPerformed(evt);
            }
        });

        panInputsCarga.setLayout(new java.awt.GridLayout(2, 4, 12, 6));

        jLabel2.setText("Produto");
        panInputsCarga.add(jLabel2);

        jLabel3.setText("Qtde Disponivel");
        panInputsCarga.add(jLabel3);

        jLabel12.setText("Destino");
        panInputsCarga.add(jLabel12);

        jLabel7.setText("Origem");
        panInputsCarga.add(jLabel7);

        txtProduto.setEnabled(false);
        txtProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProdutoActionPerformed(evt);
            }
        });
        panInputsCarga.add(txtProduto);

        fmtQtdeDisponivel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        fmtQtdeDisponivel.setEnabled(false);
        panInputsCarga.add(fmtQtdeDisponivel);

        txtDestino.setEnabled(false);
        panInputsCarga.add(txtDestino);

        txtOrigem.setEnabled(false);
        panInputsCarga.add(txtOrigem);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnCarga)
                        .addContainerGap(847, Short.MAX_VALUE))
                    .addComponent(panInputsCarga, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panInputsCarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCarga)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Colaborador"));

        jLabel6.setText("Nome do Colaborador");

        txtNome.setEnabled(false);

        btnColab.setBackground(new java.awt.Color(0, 153, 255));
        btnColab.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btnColab.setForeground(new java.awt.Color(255, 255, 255));
        btnColab.setText("Selecione");
        btnColab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColabActionPerformed(evt);
            }
        });

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefone.setEnabled(false);

        jLabel4.setText("Telefone");

        try {
            txtCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCPF.setEnabled(false);

        jLabel5.setText("CPF");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNome)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCPF)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTelefone)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnColab)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(0, 0, 0))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(btnColab)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Embarque"));

        jLabel10.setText("Data de Embarque");

        datEmbarque.setDateFormatString("dd/MM/yyyy");
        datEmbarque.setMaxSelectableDate(new java.util.Date(253370779286000L));
        datEmbarque.setMinSelectableDate(new Date());

        fmtQtdeLevada.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        jLabel13.setText("Quantidade Transportada");

        dataDesembarque.setText("Data de Desembarque");

        dateDesembarque.setDateFormatString("dd/MM/yyyy");
        dateDesembarque.setMaxSelectableDate(new java.util.Date(253370779286000L));
        dateDesembarque.setMinSelectableDate(new Date());

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(dateDesembarque, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel10)
                        .addComponent(datEmbarque, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dataDesembarque, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fmtQtdeLevada, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addContainerGap(216, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fmtQtdeLevada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(datEmbarque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dataDesembarque)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateDesembarque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Pagamento"));

        tabela.setBackground(new java.awt.Color(204, 204, 204));
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Valor  ", "Data Vencimento", "Data Pagamento"
            }
        ));
        jScrollPane1.setViewportView(tabela);

        panGerarParcelas.setLayout(new java.awt.GridLayout(3, 2, 12, 6));

        jLabel14.setText("Valor Transporte");
        panGerarParcelas.add(jLabel14);

        jLabel11.setText("Data de Vencimento");
        panGerarParcelas.add(jLabel11);

        fmtValorTrans.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        panGerarParcelas.add(fmtValorTrans);

        datVencimento.setDateFormatString("dd/MM/yyyy");
        datVencimento.setMinSelectableDate(new Date());
        panGerarParcelas.add(datVencimento);

        javax.swing.GroupLayout panVazioLayout = new javax.swing.GroupLayout(panVazio);
        panVazio.setLayout(panVazioLayout);
        panVazioLayout.setHorizontalGroup(
            panVazioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 134, Short.MAX_VALUE)
        );
        panVazioLayout.setVerticalGroup(
            panVazioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        panGerarParcelas.add(panVazio);

        btnGerar.setBackground(new java.awt.Color(0, 153, 255));
        btnGerar.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btnGerar.setForeground(new java.awt.Color(255, 255, 255));
        btnGerar.setText("Gerar Parcelas");
        btnGerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarActionPerformed(evt);
            }
        });
        panGerarParcelas.add(btnGerar);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(6, 6, 6))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panGerarParcelas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(panGerarParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                .addContainerGap())
        );

        panBtnsFooter.setLayout(new java.awt.GridLayout(1, 2, 12, 0));

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
        panBtnsFooter.add(btnSair);

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
        panBtnsFooter.add(btnSalvar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panBtnsFooter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panBtnsFooter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargaActionPerformed
        PesquisarCarga telaPesCarga = new PesquisarCarga(null, true);

        telaPesCarga.setVisible(true);
        if (telaPesCarga.isSelecionado()) {
            this.cargaSelecionada = telaPesCarga.getCargaSelecionada();

            atualizarCarga();
        }
    }//GEN-LAST:event_btnCargaActionPerformed

    private void btnColabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColabActionPerformed
        PesquisarColab telaPesColabo = new PesquisarColab(null, true);

        telaPesColabo.setVisible(true);
        if (telaPesColabo.isSelecionado()) {
            this.colaboSelecionado = telaPesColabo.getColaboradorSelecionado();

            atualizarColaborador();
        }
    }//GEN-LAST:event_btnColabActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (txtOrigem.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Selecione uma Carga!");
        } else if (txtNome.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Selecione um Colaborador!");
        } else if (datEmbarque.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Insira uma data para embarque!");
            datEmbarque.requestFocus();
        } else if (fmtQtdeLevada.getValue() == null) {
            JOptionPane.showMessageDialog(null, "Insira a quantidade transportada!");
            fmtQtdeLevada.requestFocus();
        } else if (Double.parseDouble(fmtQtdeLevada.getValue().toString()) <= 0) {
            JOptionPane.showMessageDialog(null, "A quantidade transportada deve ser positiva!");
            fmtQtdeLevada.requestFocus();
        } else if (Double.parseDouble(fmtQtdeLevada.getValue().toString()) > cargaSelecionada.getQuantRestante()) {
            JOptionPane.showMessageDialog(null, "Quantidade maxima de carga é de: " + cargaSelecionada.getQuantRestante());
            fmtQtdeLevada.requestFocus();
        } else if (pagamentos.size() <= 0) {
            JOptionPane.showMessageDialog(null, "Você deve gerar o pagamento!");
        } else {
            confirmou = true;
            setVisible(false);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void txtProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProdutoActionPerformed

    }//GEN-LAST:event_txtProdutoActionPerformed

    private void btnGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarActionPerformed
        if (fmtValorTrans.getValue() == null) {
            JOptionPane.showMessageDialog(null, "Insira o valor de transporte!");
            fmtValorTrans.requestFocus();
        } else if (Double.parseDouble(fmtValorTrans.getValue().toString()) <= 0) {
            JOptionPane.showMessageDialog(null, "O valor de transporte deve ser maior que 0!");
            fmtValorTrans.requestFocus();
        } else if (datVencimento.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Insira a data de pagamento!");
            datVencimento.requestFocus();
        } else {
            pagamentos.clear();
            this.valorFrete = Double.parseDouble(fmtValorTrans.getValue().toString());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(datVencimento.getDate());

            for (int i = 0; i < 2; i++) {
                PagamentoTransporte pt = new PagamentoTransporte();
                pt.setIdPagamentoTransporte(i + 1);
                pt.setDataVencimento(calendar.getTime());
                pt.setValorParcela(valorFrete / 2);
                pagamentos.add(pt);

                calendar.add(Calendar.DAY_OF_MONTH, 30);
            }
            atualizaTabelaParcela();
        }
    }//GEN-LAST:event_btnGerarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DadosTransporte dialog = new DadosTransporte(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnCarga;
    private javax.swing.JButton btnColab;
    private javax.swing.JButton btnGerar;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private com.toedter.calendar.JDateChooser datEmbarque;
    private com.toedter.calendar.JDateChooser datVencimento;
    private javax.swing.JLabel dataDesembarque;
    private com.toedter.calendar.JDateChooser dateDesembarque;
    private javax.swing.JFormattedTextField fmtQtdeDisponivel;
    private javax.swing.JFormattedTextField fmtQtdeLevada;
    private javax.swing.JFormattedTextField fmtValorTrans;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panBtnsFooter;
    private javax.swing.JPanel panGerarParcelas;
    private javax.swing.JPanel panInputsCarga;
    private javax.swing.JPanel panVazio;
    private javax.swing.JTable tabela;
    private javax.swing.JFormattedTextField txtCPF;
    private javax.swing.JTextField txtDestino;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtOrigem;
    private javax.swing.JTextField txtProduto;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables

}
