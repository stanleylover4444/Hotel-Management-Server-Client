package ui;


import javax.swing.JOptionPane;

import dao2.AccountDAO;

public class GD_DoiMatKhau extends javax.swing.JFrame {

    String username;

    private dao2.AccountDAO aD;
    public GD_DoiMatKhau(String _username) {
        username = _username;
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setAlwaysOnTop(true);
        initComponents();
        aD = new AccountDAO();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txtPassOld = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNewPass = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtAgainPass = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnThoat = new javax.swing.JButton();
        btnDoiMatKhau = new javax.swing.JButton();
        lblTitile = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlMain.setBackground(new java.awt.Color(36, 89, 83));

        jPanel3.setBackground(new java.awt.Color(36, 89, 83));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(185, 237, 221), 2, true), "ThÃ´ng tin chi tiáº¿t", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(185, 237, 221))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(36, 89, 83));

        txtPassOld.setFont(new java.awt.Font("Segoe UI", 1, 14)); 

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14));  
        jLabel3.setForeground(new java.awt.Color(240, 238, 237));
        jLabel3.setText("Mật khẩu cũ: ");

        txtNewPass.setFont(new java.awt.Font("Segoe UI", 1, 14)); 

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14));  
        jLabel4.setForeground(new java.awt.Color(240, 238, 237));
        jLabel4.setText("Nhập mật khẩu mới: ");

        txtAgainPass.setFont(new java.awt.Font("Segoe UI", 1, 14)); 

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14));  
        jLabel5.setForeground(new java.awt.Color(240, 238, 237));
        jLabel5.setText("Nhập lại mật khẩu: ");

        btnThoat.setBackground(new java.awt.Color(185, 237, 221));
        btnThoat.setFont(new java.awt.Font("Segoe UI", 1, 13));  
        btnThoat.setForeground(new java.awt.Color(36, 89, 83));
        btnThoat.setText("THOÁT");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        btnDoiMatKhau.setBackground(new java.awt.Color(185, 237, 221));
        btnDoiMatKhau.setFont(new java.awt.Font("Segoe UI", 1, 13)); 
        btnDoiMatKhau.setForeground(new java.awt.Color(36, 89, 83));
        btnDoiMatKhau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/capNhat1.png")));  
        btnDoiMatKhau.setText("ĐỔI MẬT KHẨU");
        btnDoiMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiMatKhauActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(txtPassOld, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtNewPass))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(27, 27, 27)
                        .addComponent(txtAgainPass)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(btnDoiMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPassOld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNewPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAgainPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDoiMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThoat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        lblTitile.setBackground(new java.awt.Color(235, 144, 46));
        lblTitile.setFont(new java.awt.Font("Segoe UI", 1, 18)); 
        lblTitile.setForeground(new java.awt.Color(255, 255, 255));
        lblTitile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitile.setText("ĐỔI MẬT KHẨU");

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(lblTitile, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitile, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        getContentPane().add(pnlMain, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    } 

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
    } 

    private void btnChangePassActionPerformed(java.awt.event.ActionEvent evt) { 

    } 

    private void btnDoiMatKhauActionPerformed(java.awt.event.ActionEvent evt) { 
        aD = new AccountDAO();
        String passOld = aD.getAccountById(username).getPassword();
        String passNew = txtNewPass.getText();
        if ( !txtPassOld.getText().equals("")) {
            if ( !txtNewPass.getText().equals("")) {
                if ( !txtAgainPass.getText().equals("")) {
                    if (passOld.equals(txtPassOld.getText())) {
                        if (passNew.equals(txtAgainPass.getText())) {
                            aD.update(passNew, username);
                            JOptionPane.showMessageDialog(this, "Đổi mật khẩu thành công");
                            this.setVisible(false);
                        } else {
                            JOptionPane.showMessageDialog(this, "Vui lòng nhập mật khẩu mới");
                        }

                    } else {
                        JOptionPane.showMessageDialog(this, "Bạn nhập sai mật khẩu cũ");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Vui lòng nhập lại mật khẩu mới");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập mật khẩu mới");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mật khẩu cũ");
        }
    } 

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
    } 

 
    private javax.swing.JButton btnDoiMatKhau;
    private javax.swing.JButton btnThoat;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblTitile;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JTextField txtAgainPass;
    private javax.swing.JTextField txtNewPass;
    private javax.swing.JTextField txtPassOld; 
}
