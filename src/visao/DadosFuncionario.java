package visao;

import javax.swing.JOptionPane;
import modelo.Funcionario;

/**
 *
 * @author giov
 */
public class DadosFuncionario extends javax.swing.JDialog {

    private int cod = 0;

    private boolean editar = false;
    private boolean confirmaSenha = true;
    private String senha = "";
    private boolean senhaVisivel = false;
    private Funcionario funcionarioSelecionado;

    public DadosFuncionario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        labAlterarSenha.setVisible(false);
//        txtSenha.setEnabled(false);
    }

    public void setEditar(boolean editar) {
        this.editar = editar;
    }

    public boolean isEditar() {
        return editar;
    }

    public void setSistemaSenha() {
        confirmaSenha = false;
        labAlterarSenha.setVisible(true);
    }

    public Funcionario getFuncionario() {
        Funcionario func = new Funcionario();
        func.setIdFuncionario(this.cod);
        func.setCpf(txtCPF.getText());
        func.setNome(txtNome.getText());
        func.setTelefone(txtTelefone.getText());
        func.setEmail(txtEmail.getText());
        func.setCidade(txtCidade.getText());
        func.setEstado(txtEstado.getSelectedItem().toString());
        func.setBairro(txtBairro.getText());
        func.setRua(txtRua.getText());
        func.setNivel(txtNivel.getSelectedItem().toString());
        func.setSenha(new String(txtSenha.getPassword())); // Ajuste aqui
        return func;
    }

    public void setFuncionario(Funcionario func) {
        this.funcionarioSelecionado = func;
        this.cod = func.getIdFuncionario();
        txtCPF.setText(func.getCpf());
        txtNome.setText(func.getNome());
        txtTelefone.setText(func.getTelefone());
        txtEmail.setText(func.getEmail());
        txtCidade.setText(func.getCidade());
        txtEstado.setSelectedItem(func.getEstado());
        txtBairro.setText(func.getBairro());
        txtRua.setText(func.getRua());
        txtNivel.setSelectedItem(func.getNivel());
        txtSenha.setText(func.getSenha()); // Ajuste aqui
        this.senha = func.getSenha();
//        labSenhaC.setVisible(false);
//        txtConfrimar.setVisible(false);
    }

    public void setVizualizar() {
        txtCPF.setEditable(false);
        txtNome.setEditable(false);
        txtTelefone.setEditable(false);
        txtEmail.setEditable(false);
        txtCidade.setEditable(false);
        txtEstado.setEnabled(false);
        txtNivel.setEnabled(false);
        txtBairro.setEditable(false);
        txtRua.setEditable(false);
        btnSalvar.setVisible(false);
        txtSenha.setEditable(false);
//        txtConfrimar.setEditable(false);
        labSenha.setEnabled(editar);
//        labSenhaC.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCPF = new javax.swing.JFormattedTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtNivel = new javax.swing.JComboBox<>();
        jPanel9 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JFormattedTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JComboBox<>();
        jPanel12 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtRua = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        labSenha = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        jPanel15 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        labAlterarSenha = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel2.setBackground(new java.awt.Color(185, 209, 234));

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/do-utilizador.png"))); // NOI18N
        jLabel1.setText("Dados do Funcionário");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(142, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(143, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(20, 20, 20))
        );

        jPanel11.setBackground(new java.awt.Color(185, 209, 234));
        jPanel11.setLayout(new java.awt.GridLayout(5, 2, 20, 12));

        jPanel6.setBackground(new java.awt.Color(185, 209, 234));
        jPanel6.setLayout(new java.awt.GridLayout(2, 1, 0, 6));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel3.setText("Nome");
        jPanel6.add(jLabel3);
        jPanel6.add(txtNome);

        jPanel11.add(jPanel6);

        jPanel3.setBackground(new java.awt.Color(185, 209, 234));
        jPanel3.setLayout(new java.awt.GridLayout(2, 1, 0, 6));

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel8.setText("Bairro");
        jPanel3.add(jLabel8);
        jPanel3.add(txtBairro);

        jPanel11.add(jPanel3);

        jPanel7.setBackground(new java.awt.Color(185, 209, 234));
        jPanel7.setLayout(new java.awt.GridLayout(2, 1, 0, 6));

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel2.setText("CPF");
        jPanel7.add(jLabel2);

        try {
            txtCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel7.add(txtCPF);

        jPanel11.add(jPanel7);

        jPanel4.setBackground(new java.awt.Color(185, 209, 234));
        jPanel4.setLayout(new java.awt.GridLayout(2, 1, 0, 6));

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel6.setText("Cidade");
        jPanel4.add(jLabel6);
        jPanel4.add(txtCidade);

        jPanel11.add(jPanel4);

        jPanel5.setBackground(new java.awt.Color(185, 209, 234));
        jPanel5.setLayout(new java.awt.GridLayout(2, 1, 0, 6));

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel5.setText("Email");
        jPanel5.add(jLabel5);

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        jPanel5.add(txtEmail);

        jPanel11.add(jPanel5);

        jPanel8.setBackground(new java.awt.Color(185, 209, 234));
        jPanel8.setLayout(new java.awt.GridLayout(2, 1, 0, 6));

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel9.setText("Nível de Acesso");
        jPanel8.add(jLabel9);

        txtNivel.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        txtNivel.setForeground(new java.awt.Color(204, 204, 204));
        txtNivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "F" }));
        jPanel8.add(txtNivel);

        jPanel11.add(jPanel8);

        jPanel9.setBackground(new java.awt.Color(185, 209, 234));
        jPanel9.setLayout(new java.awt.GridLayout(2, 1, 0, 6));

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel4.setText("Telefone");
        jPanel9.add(jLabel4);

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel9.add(txtTelefone);

        jPanel11.add(jPanel9);

        jPanel10.setBackground(new java.awt.Color(185, 209, 234));
        jPanel10.setLayout(new java.awt.GridLayout(2, 1, 0, 6));

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel7.setText("Estado");
        jPanel10.add(jLabel7);

        txtEstado.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        txtEstado.setForeground(new java.awt.Color(204, 204, 204));
        txtEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        jPanel10.add(txtEstado);

        jPanel11.add(jPanel10);

        jPanel12.setBackground(new java.awt.Color(185, 209, 234));
        jPanel12.setLayout(new java.awt.GridLayout(2, 1, 0, 6));

        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel10.setText("Rua");
        jPanel12.add(jLabel10);
        jPanel12.add(txtRua);

        jPanel11.add(jPanel12);

        jPanel13.setBackground(new java.awt.Color(185, 209, 234));
        jPanel13.setLayout(new java.awt.GridLayout(2, 1, 0, 6));

        labSenha.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        labSenha.setText("Senha");
        jPanel13.add(labSenha);
        jPanel13.add(txtSenha);

        jPanel11.add(jPanel13);

        jPanel15.setBackground(new java.awt.Color(185, 209, 234));
        jPanel15.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jPanel14.setBackground(new java.awt.Color(185, 209, 234));
        jPanel14.setLayout(new java.awt.GridLayout(1, 0, 20, 0));
        jPanel15.add(jPanel14);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LOGO-removebg-preview.png"))); // NOI18N

        jPanel16.setBackground(new java.awt.Color(185, 209, 234));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/viewSenha.png"))); // NOI18N
        jLabel11.setText("Visualizar Senha");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VisualizarSenha(evt);
            }
        });

        labAlterarSenha.setBackground(new java.awt.Color(51, 102, 255));
        labAlterarSenha.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labAlterarSenha.setForeground(new java.awt.Color(0, 153, 255));
        labAlterarSenha.setText("Alterar senha!");
        labAlterarSenha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labAlterarSenhaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap(218, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labAlterarSenha, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(labAlterarSenha))
        );

        btnCancelar.setBackground(new java.awt.Color(0, 153, 255));
        btnCancelar.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cruz-pequeno.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(133, 133, 133)
                                .addComponent(btnCancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnSalvar))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel12)))
                .addContainerGap())
        );

        getContentPane().add(jPanel2);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (txtCPF.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "o CPF precisa ser preenchido");
            txtCPF.requestFocus();
        } else if (txtNome.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "o nome precisa ser preenchido");
            txtNome.requestFocus();
        } else if (txtTelefone.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "o telefone precisa ser preenchido");
            txtTelefone.requestFocus();
        } else if (txtEmail.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "o email precisa ser preenchido");
            txtEmail.requestFocus();
        } else if (txtCidade.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "a cidade precisa ser preenchida");
            txtCidade.requestFocus();
        } else if (txtBairro.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "o bairro precisa ser preenchido");
            txtBairro.requestFocus();
        } else if (txtRua.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "a rua precisa ser preenchida");
            txtRua.requestFocus();
        } else if (txtSenha.getPassword().length == 0) { // Ajuste aqui
            JOptionPane.showMessageDialog(null, "a senha precisa ser preenchida");
            txtSenha.requestFocus();
        } else {
            this.setEditar(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed

    }//GEN-LAST:event_txtEmailActionPerformed

    private void labAlterarSenhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labAlterarSenhaMouseClicked
        AlterarSenha telaAlte = new AlterarSenha(null, true);
        telaAlte.setFuncionario(funcionarioSelecionado);
        telaAlte.setVisible(true);

        if (telaAlte.isAlterou()) {
            this.senha = telaAlte.getSenha();
            txtSenha.setText(this.senha);
        }
    }//GEN-LAST:event_labAlterarSenhaMouseClicked

    private void VisualizarSenha(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VisualizarSenha

        if (senhaVisivel) {
            txtSenha.setEchoChar('*'); 
            senhaVisivel = false;
        } else {
            txtSenha.setEchoChar((char) 0); 
            senhaVisivel = true;
        }
    }//GEN-LAST:event_VisualizarSenha

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DadosFuncionario dialog = new DadosFuncionario(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel labAlterarSenha;
    private javax.swing.JLabel labSenha;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JFormattedTextField txtCPF;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JComboBox<String> txtEstado;
    private javax.swing.JComboBox<String> txtNivel;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtRua;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
