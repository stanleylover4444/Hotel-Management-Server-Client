package ui;

import entity.Employee;
import socket.SocketClient;
import socket.implement.AccountClient;
import socket.implement.EmployeeClient;

import java.io.IOException;

import javax.swing.JOptionPane;

public class Frm_Login extends javax.swing.JFrame {

	private final Frm_Login comp;
    private AccountClient accountClient = new AccountClient();
    private EmployeeClient employeeClient = new EmployeeClient();
 
    public Frm_Login(){
        initComponents();
        comp=this;
    }
 
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        kGradientPanel3 = new keeptoo.KGradientPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTenDN = new javax.swing.JTextField();
        txtMatKhau = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        btnDangNhap = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(955, 371));
        getContentPane().setLayout(new javax.swing.OverlayLayout(getContentPane()));

        jPanel1.setLayout(new java.awt.BorderLayout());

        kGradientPanel3.setForeground(new java.awt.Color(255, 255, 255));
        
        kGradientPanel3.setkEndColor(new java.awt.Color(86, 157, 170));
        kGradientPanel3.setkGradientFocus(2000);
        kGradientPanel3.setkStartColor(new java.awt.Color(135, 203, 185));
        kGradientPanel3.setLayout(null);

        jLabel7.setFont(new java.awt.Font("Ink Free", 0, 150));  
        jLabel7.setForeground(new java.awt.Color(36, 89, 83));
        jLabel7.setText("H");
        kGradientPanel3.add(jLabel7);
        jLabel7.setBounds(130, 20, 110, 250);

        jLabel5.setFont(new java.awt.Font("Viner Hand ITC", 0, 48));  
        jLabel5.setForeground(new java.awt.Color(36, 89, 83));
        jLabel5.setText("&");
        kGradientPanel3.add(jLabel5);
        jLabel5.setBounds(230, 90, 60, 170);

        jLabel8.setFont(new java.awt.Font("Ink Free", 0, 150));  
        jLabel8.setForeground(new java.awt.Color(36, 89, 83));
        jLabel8.setText("M");
        kGradientPanel3.add(jLabel8);
        jLabel8.setBounds(250, 120, 140, 250);

        jLabel10.setFont(new java.awt.Font("Corbel Light", 2, 24)); 
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("H&M Hotel");
        kGradientPanel3.add(jLabel10);
        jLabel10.setBounds(50, 310, 400, 40);

        jPanel1.add(kGradientPanel3, java.awt.BorderLayout.CENTER);

        kGradientPanel1.setBackground(new java.awt.Color(246, 246, 246));
        kGradientPanel1.setkEndColor(new java.awt.Color(135, 203, 185));
        kGradientPanel1.setkGradientFocus(1500);
        kGradientPanel1.setkStartColor(new java.awt.Color(216, 216, 216));
        kGradientPanel1.setPreferredSize(new java.awt.Dimension(400, 423));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); 
        jLabel1.setForeground(new java.awt.Color(87, 125, 134));
        jLabel1.setText("Tài khoản :");

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 14));  
        jLabel2.setForeground(new java.awt.Color(87, 125, 134));
        jLabel2.setText("Mật khẩu :");

        txtTenDN.setBackground(new java.awt.Color(241, 246, 249));
        txtTenDN.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        txtTenDN.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        txtMatKhau.setBackground(new java.awt.Color(241, 246, 249));
        txtMatKhau.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        txtMatKhau.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMatKhauActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 1, 24));  
        jLabel6.setForeground(new java.awt.Color(36, 89, 83));
        jLabel6.setText("ĐĂNG NHẬP");

        jSeparator3.setForeground(new java.awt.Color(87, 125, 134));
        jSeparator3.setMinimumSize(new java.awt.Dimension(50, 10));
        jSeparator3.setPreferredSize(new java.awt.Dimension(50, 10));

        jSeparator4.setForeground(new java.awt.Color(87, 125, 134));
        jSeparator4.setMinimumSize(new java.awt.Dimension(50, 10));
        jSeparator4.setPreferredSize(new java.awt.Dimension(50, 10));

        jButton1.setBackground(new java.awt.Color(36, 89, 83));
        jButton1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); 
        jButton1.setForeground(new java.awt.Color(135, 203, 185));
        jButton1.setText("Thoát");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 3, true));
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusPainted(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnDangNhap.setBackground(new java.awt.Color(36, 89, 83));
        btnDangNhap.setFont(new java.awt.Font("Segoe UI Black", 1, 14));  
        btnDangNhap.setForeground(new java.awt.Color(135, 203, 185));
        btnDangNhap.setText("Đăng nhập");
        btnDangNhap.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 3, true));
        btnDangNhap.setBorderPainted(false);
        btnDangNhap.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDangNhap.setFocusPainted(false);
        btnDangNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    btnDangNhapMouseClicked(evt);
                } catch (ClassNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); 
        jButton3.setForeground(new java.awt.Color(36, 89, 83));
        jButton3.setText("Quên mật khẩu");
        jButton3.setToolTipText("Nhấn vào khi quên mật khẩu");
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(131, 131, 131))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenDN, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(105, 105, 105))))
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(btnDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtTenDN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jButton3)
                .addGap(37, 37, 37))
        );

        jPanel1.add(kGradientPanel1, java.awt.BorderLayout.EAST);

        getContentPane().add(jPanel1);

        pack();
        setLocationRelativeTo(null);
    }

    private void txtMatKhauActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(this, "Bạn hãy liên hệ lại với nhân viên quầy để được cấp lại mật khẩu");
    }

    private void btnDangNhapMouseClicked(java.awt.event.MouseEvent evt) throws ClassNotFoundException {
        
        String username=txtTenDN.getText();
        String password=String.valueOf(txtMatKhau.getPassword());
        if(username.equals("") || password.equals("")){
            JOptionPane.showMessageDialog(null, "Hãy nhập đúng thông tin đăng nhập!");
        }else{
            System.out.println("username: " + username + ", password: " + password);
            if(accountClient.findPass(username).equals(password)) {
                Employee emp;
                emp = employeeClient.getById(username);
                System.out.println("emp: " + emp);
                if(emp.getEmployeeType().getEmployeeTypeID().equals("LNV001")){
                    this.setVisible(false);
                    GD_QuanLy gdql = new GD_QuanLy(username, comp);
                    gdql.setVisible(true);
                } else {
                    this.setVisible(false);
                    GD_NhanVien gdnv = new GD_NhanVien(username, comp);
                    gdnv.setVisible(true);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Mật khẩu không hợp lệ");
            }
        }
    }
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	Frm_Login gd;
                gd = new Frm_Login();
                gd.setDefaultCloseOperation(HIDE_ON_CLOSE);
                gd.setLocationRelativeTo(null);
                gd.setVisible(true);
            }
        });
    }

    private javax.swing.JButton btnDangNhap;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel3;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JTextField txtTenDN; 
}
