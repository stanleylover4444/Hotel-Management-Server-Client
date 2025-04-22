package ui;

import socket.SocketClient;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;

public class GD_QuanLy extends javax.swing.JFrame {
    private static String username;
    private static Component component;
    private entity.Employee e;
    private static SocketClient socketClient = new SocketClient("localhost", 31000);

    public GD_QuanLy(String _username, Component c) {
        component=c;
        username=_username;
        this.setUndecorated(true);
        this.setResizable(true);
        initComponents();
        setCursorForPanelÌ£();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        
        
        pnlGioiThieu.setkEndColor(new java.awt.Color(185, 237, 221));
        pnlGioiThieu.setkStartColor(new java.awt.Color(185, 237, 221));
        lblGioiThieu.setForeground(new Color(36, 89, 83));
        
        GD_GioiThieu frGioiThieu = new GD_GioiThieu(username);
        openComponent(frGioiThieu);
        try {
            e = socketClient.getEmployee(_username);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        lblTen.setText(e.getEmployeeName());
        lblChucVu.setText(e.getEmployeeType().getEmployeeTypeName());
        
        

    }
    @SuppressWarnings("unchecked")
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        pnlForm = new javax.swing.JPanel();
        pnlMenu = new javax.swing.JPanel();
        pnlNguoiDung = new javax.swing.JPanel();
        lblChucVu = new javax.swing.JLabel();
        lblImage = new javax.swing.JLabel();
        lblTen = new javax.swing.JLabel();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        pnlGioiThieu = new keeptoo.KGradientPanel();
        lblGioiThieu = new javax.swing.JLabel();
        pnlPhong = new keeptoo.KGradientPanel();
        lblPhong = new javax.swing.JLabel();
        pnlNhanVien = new keeptoo.KGradientPanel();
        lblNhanVien = new javax.swing.JLabel();
        pnlKhachHang = new keeptoo.KGradientPanel();
        lblKhachHang = new javax.swing.JLabel();
        pnlDichVu = new keeptoo.KGradientPanel();
        lblDichVu = new javax.swing.JLabel();
        pnlTaiKhoan = new keeptoo.KGradientPanel();
        lblTaiKhoan = new javax.swing.JLabel();
        pnlThongKe = new keeptoo.KGradientPanel();
        lblThongKe = new javax.swing.JLabel();
        pnlTroGiup = new keeptoo.KGradientPanel();
        lblTroGiup = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnDoiMatKhau1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnDangXuat = new javax.swing.JButton();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(200, 200));

        pnlMain.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        pnlMain.setLayout(new java.awt.BorderLayout());

        pnlForm.setBackground(new java.awt.Color(255, 255, 255));
        pnlForm.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        pnlForm.setLayout(new java.awt.BorderLayout());
        pnlMain.add(pnlForm, java.awt.BorderLayout.CENTER);

        pnlMenu.setBackground(new java.awt.Color(249, 234, 249));
        pnlMenu.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlMenu.setPreferredSize(new java.awt.Dimension(250, 200));
        pnlMenu.setLayout(new javax.swing.BoxLayout(pnlMenu, javax.swing.BoxLayout.Y_AXIS));

        pnlNguoiDung.setBackground(new java.awt.Color(255, 255, 255));

        lblChucVu.setFont(new java.awt.Font("Verdana", 1, 12));  
        lblChucVu.setForeground(new java.awt.Color(36, 89, 83));
        lblChucVu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblChucVu.setText("Quản lý");

        lblImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImage.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblTen.setFont(new java.awt.Font("Verdana", 1, 12));  
        lblTen.setForeground(new java.awt.Color(36, 89, 83));
        lblTen.setText("Trần Văn B");

        javax.swing.GroupLayout pnlNguoiDungLayout = new javax.swing.GroupLayout(pnlNguoiDung);
        pnlNguoiDung.setLayout(pnlNguoiDungLayout);
        pnlNguoiDungLayout.setHorizontalGroup(
            pnlNguoiDungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNguoiDungLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlNguoiDungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlNguoiDungLayout.createSequentialGroup()
                        .addComponent(lblChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pnlNguoiDungLayout.setVerticalGroup(
            pnlNguoiDungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNguoiDungLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlNguoiDungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlNguoiDungLayout.createSequentialGroup()
                        .addComponent(lblChucVu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTen)
                        .addGap(30, 30, 30))
                    .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlMenu.add(pnlNguoiDung);

        kGradientPanel2.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel2.setkStartColor(new java.awt.Color(255, 255, 255));
        kGradientPanel2.setMaximumSize(new java.awt.Dimension(999, 2000));
        kGradientPanel2.setPreferredSize(new java.awt.Dimension(245, 814));
        kGradientPanel2.setLayout(new javax.swing.BoxLayout(kGradientPanel2, javax.swing.BoxLayout.PAGE_AXIS));

        pnlGioiThieu.setBackground(new java.awt.Color(0, 102, 102));
        pnlGioiThieu.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        pnlGioiThieu.setkEndColor(new java.awt.Color(0, 102, 102));
        pnlGioiThieu.setkGradientFocus(100);
        pnlGioiThieu.setkStartColor(new java.awt.Color(0, 102, 102));
        pnlGioiThieu.setMaximumSize(new java.awt.Dimension(2147483647, 40));
        pnlGioiThieu.setPreferredSize(new java.awt.Dimension(250, 60));
        pnlGioiThieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlGioiThieuMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlGioiThieuMousePressed(evt);
            }
        });
        pnlGioiThieu.setLayout(new java.awt.BorderLayout());

        lblGioiThieu.setFont(new java.awt.Font("Verdana", 1, 14)); 
        lblGioiThieu.setForeground(new java.awt.Color(240, 238, 237));
        lblGioiThieu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGioiThieu.setText("GIỚI THIỆU");
        pnlGioiThieu.add(lblGioiThieu, java.awt.BorderLayout.CENTER);

        kGradientPanel2.add(pnlGioiThieu);

        pnlPhong.setBackground(new java.awt.Color(0, 102, 102));
        pnlPhong.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        pnlPhong.setkEndColor(new java.awt.Color(0, 102, 102));
        pnlPhong.setkGradientFocus(100);
        pnlPhong.setkStartColor(new java.awt.Color(0, 102, 102));
        pnlPhong.setMaximumSize(new java.awt.Dimension(2147483647, 40));
        pnlPhong.setPreferredSize(new java.awt.Dimension(250, 40));
        pnlPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlPhongMouseClicked(evt);
            }
        });
        pnlPhong.setLayout(new java.awt.BorderLayout());

        lblPhong.setFont(new java.awt.Font("Verdana", 1, 14)); 
        lblPhong.setForeground(new java.awt.Color(240, 238, 237));
        lblPhong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPhong.setText("PHÒNG");
        pnlPhong.add(lblPhong, java.awt.BorderLayout.CENTER);

        kGradientPanel2.add(pnlPhong);

        pnlNhanVien.setBackground(new java.awt.Color(0, 102, 102));
        pnlNhanVien.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        pnlNhanVien.setkEndColor(new java.awt.Color(0, 102, 102));
        pnlNhanVien.setkGradientFocus(100);
        pnlNhanVien.setkStartColor(new java.awt.Color(0, 102, 102));
        pnlNhanVien.setMaximumSize(new java.awt.Dimension(2147483647, 40));
        pnlNhanVien.setPreferredSize(new java.awt.Dimension(250, 40));
        pnlNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlNhanVienMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlNhanVienMousePressed(evt);
            }
        });
        pnlNhanVien.setLayout(new java.awt.BorderLayout());

        lblNhanVien.setFont(new java.awt.Font("Verdana", 1, 14)); 
        lblNhanVien.setForeground(new java.awt.Color(240, 238, 237));
        lblNhanVien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNhanVien.setText("NHÂN VIÊN");
        pnlNhanVien.add(lblNhanVien, java.awt.BorderLayout.CENTER);

        kGradientPanel2.add(pnlNhanVien);

        pnlKhachHang.setBackground(new java.awt.Color(0, 102, 102));
        pnlKhachHang.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        pnlKhachHang.setkEndColor(new java.awt.Color(0, 102, 102));
        pnlKhachHang.setkGradientFocus(100);
        pnlKhachHang.setkStartColor(new java.awt.Color(0, 102, 102));
        pnlKhachHang.setMaximumSize(new java.awt.Dimension(300, 40));
        pnlKhachHang.setMinimumSize(new java.awt.Dimension(50, 40));
        pnlKhachHang.setPreferredSize(new java.awt.Dimension(250, 40));
        pnlKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlKhachHangMouseClicked(evt);
            }
        });
        pnlKhachHang.setLayout(new java.awt.BorderLayout());

        lblKhachHang.setFont(new java.awt.Font("Verdana", 1, 14));  
        lblKhachHang.setForeground(new java.awt.Color(240, 238, 237));
        lblKhachHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblKhachHang.setText("KHÁCH HÀNG");
        lblKhachHang.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlKhachHang.add(lblKhachHang, java.awt.BorderLayout.CENTER);

        kGradientPanel2.add(pnlKhachHang);

        pnlDichVu.setBackground(new java.awt.Color(0, 102, 102));
        pnlDichVu.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        pnlDichVu.setkEndColor(new java.awt.Color(0, 102, 102));
        pnlDichVu.setkGradientFocus(100);
        pnlDichVu.setkStartColor(new java.awt.Color(0, 102, 102));
        pnlDichVu.setMaximumSize(new java.awt.Dimension(2147483647, 40));
        pnlDichVu.setPreferredSize(new java.awt.Dimension(250, 40));
        pnlDichVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlDichVuMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlDichVuMousePressed(evt);
            }
        });
        pnlDichVu.setLayout(new java.awt.BorderLayout());

        lblDichVu.setFont(new java.awt.Font("Verdana", 1, 14)); 
        lblDichVu.setForeground(new java.awt.Color(240, 238, 237));
        lblDichVu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDichVu.setText("DỊCH VỤ");
        pnlDichVu.add(lblDichVu, java.awt.BorderLayout.CENTER);

        kGradientPanel2.add(pnlDichVu);

        pnlTaiKhoan.setBackground(new java.awt.Color(0, 102, 102));
        pnlTaiKhoan.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        pnlTaiKhoan.setkEndColor(new java.awt.Color(0, 102, 102));
        pnlTaiKhoan.setkGradientFocus(100);
        pnlTaiKhoan.setkStartColor(new java.awt.Color(0, 102, 102));
        pnlTaiKhoan.setMaximumSize(new java.awt.Dimension(2147483647, 40));
        pnlTaiKhoan.setPreferredSize(new java.awt.Dimension(250, 40));
        pnlTaiKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlTaiKhoanMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlTaiKhoanMousePressed(evt);
            }
        });
        pnlTaiKhoan.setLayout(new java.awt.BorderLayout());

        lblTaiKhoan.setFont(new java.awt.Font("Verdana", 1, 14)); 
        lblTaiKhoan.setForeground(new java.awt.Color(240, 238, 237));
        lblTaiKhoan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTaiKhoan.setText("TÀI KHOẢN");
        pnlTaiKhoan.add(lblTaiKhoan, java.awt.BorderLayout.CENTER);

        kGradientPanel2.add(pnlTaiKhoan);

        pnlThongKe.setBackground(new java.awt.Color(0, 102, 102));
        pnlThongKe.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        pnlThongKe.setkEndColor(new java.awt.Color(0, 102, 102));
        pnlThongKe.setkGradientFocus(100);
        pnlThongKe.setkStartColor(new java.awt.Color(0, 102, 102));
        pnlThongKe.setMaximumSize(new java.awt.Dimension(2147483647, 40));
        pnlThongKe.setPreferredSize(new java.awt.Dimension(250, 40));
        pnlThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlThongKeMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlThongKeMousePressed(evt);
            }
        });
        pnlThongKe.setLayout(new java.awt.BorderLayout());

        lblThongKe.setFont(new java.awt.Font("Verdana", 1, 14)); 
        lblThongKe.setForeground(new java.awt.Color(240, 238, 237));
        lblThongKe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblThongKe.setText("THỐNG KÊ");
        pnlThongKe.add(lblThongKe, java.awt.BorderLayout.CENTER);

        kGradientPanel2.add(pnlThongKe);

        pnlTroGiup.setBackground(new java.awt.Color(0, 102, 102));
        pnlTroGiup.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        pnlTroGiup.setkEndColor(new java.awt.Color(0, 102, 102));
        pnlTroGiup.setkGradientFocus(100);
        pnlTroGiup.setkStartColor(new java.awt.Color(0, 102, 102));
        pnlTroGiup.setMaximumSize(new java.awt.Dimension(2147483647, 40));
        pnlTroGiup.setPreferredSize(new java.awt.Dimension(250, 40));
        pnlTroGiup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlTroGiupMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlTroGiupMousePressed(evt);
            }
        });
        pnlTroGiup.setLayout(new java.awt.BorderLayout());

        lblTroGiup.setFont(new java.awt.Font("Verdana", 1, 14));
        lblTroGiup.setForeground(new java.awt.Color(240, 238, 237));
        lblTroGiup.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTroGiup.setText("TRỢ GIÚP");
        pnlTroGiup.add(lblTroGiup, java.awt.BorderLayout.CENTER);

        kGradientPanel2.add(pnlTroGiup);

        pnlMenu.add(kGradientPanel2);

        jPanel1.setLayout(new java.awt.BorderLayout());

        btnDoiMatKhau1.setBackground(new java.awt.Color(36, 89, 83));
        btnDoiMatKhau1.setFont(new java.awt.Font("Segoe UI", 1, 18)); 
        btnDoiMatKhau1.setForeground(new java.awt.Color(255, 255, 255));
        btnDoiMatKhau1.setText("ĐỔI MẬT KHẨU");
        btnDoiMatKhau1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(36, 89, 83), 3, true));
        btnDoiMatKhau1.setFocusPainted(false);
        btnDoiMatKhau1.setMaximumSize(new java.awt.Dimension(254, 42));
        btnDoiMatKhau1.setPreferredSize(new java.awt.Dimension(254, 40));
        btnDoiMatKhau1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiMatKhau1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnDoiMatKhau1, java.awt.BorderLayout.SOUTH);

        pnlMenu.add(jPanel1);

        jPanel2.setLayout(new java.awt.BorderLayout());

        btnDangXuat.setBackground(new java.awt.Color(252, 249, 250));
        btnDangXuat.setFont(new java.awt.Font("Segoe UI", 1, 18)); 
        btnDangXuat.setForeground(new java.awt.Color(87, 197, 182));
        btnDangXuat.setText("ĐĂNG XUẤT");
        btnDangXuat.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(36, 89, 83), 3, true));
        btnDangXuat.setMaximumSize(new java.awt.Dimension(254, 42));
        btnDangXuat.setPreferredSize(new java.awt.Dimension(254, 40));
        btnDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuatActionPerformed(evt);
            }
        });
        jPanel2.add(btnDangXuat, java.awt.BorderLayout.PAGE_END);

        pnlMenu.add(jPanel2);

        pnlMain.add(pnlMenu, java.awt.BorderLayout.WEST);
        pnlMenu.getAccessibleContext().setAccessibleParent(this);

        kGradientPanel1.setkEndColor(new java.awt.Color(185, 237, 221));
        kGradientPanel1.setkGradientFocus(2600);
        kGradientPanel1.setkStartColor(new java.awt.Color(135, 203, 185));
        kGradientPanel1.setPreferredSize(new java.awt.Dimension(1155, 45));
        kGradientPanel1.setLayout(new java.awt.GridLayout(1, 1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 22));  
        jLabel3.setForeground(new java.awt.Color(36, 89, 83));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("PHẦN MỀM QUẢN LÝ KHÁCH SẠN");
        jLabel3.setToolTipText("");
        jLabel3.setAlignmentX(1.0F);
        jLabel3.setAlignmentY(0.0F);
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        kGradientPanel1.add(jLabel3);

        pnlMain.add(kGradientPanel1, java.awt.BorderLayout.NORTH);

        getContentPane().add(pnlMain, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    } 

    private void pnlGioiThieuMousePressed(java.awt.event.MouseEvent evt) {
   
    } 

    private void pnlTaiKhoanMousePressed(java.awt.event.MouseEvent evt) { 
        
    } 

    private void pnlTroGiupMousePressed(java.awt.event.MouseEvent evt) { 
       
    } 

    private void pnlThongKeMousePressed(java.awt.event.MouseEvent evt) { 
     
    } 

    private void pnlNhanVienMousePressed(java.awt.event.MouseEvent evt) { 
      
    } 

    private void btnDangXuatActionPerformed(java.awt.event.ActionEvent evt) { 
        if (JOptionPane.showConfirmDialog(this, "Bạn có muốn thoát ?", "Thoát", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            this.setVisible(false);
            component.setVisible(true);
        }
    } 

    private void pnlKhachHangMouseClicked(java.awt.event.MouseEvent evt) {
        doiMauPnl();
        
        pnlKhachHang.setkEndColor(new java.awt.Color(185, 237, 221));
        pnlKhachHang.setkStartColor(new java.awt.Color(185, 237, 221));
        lblKhachHang.setForeground(new Color(36, 89, 83));
        openComponent(new GD_QLKhachHang());
    } 

    private void pnlDichVuMousePressed(java.awt.event.MouseEvent evt) { 
        // TODO add your handling code here:
    } 

    private void pnlNhanVienMouseClicked(java.awt.event.MouseEvent evt) { 
        
        
        doiMauPnl();
        
        pnlNhanVien.setkEndColor(new java.awt.Color(185, 237, 221));
        pnlNhanVien.setkStartColor(new java.awt.Color(185, 237, 221));
        lblNhanVien.setForeground(new Color(36, 89, 83));
        
        GD_QLNhanVien gd=new GD_QLNhanVien();
        openComponent(gd);
    } 

    private void pnlGioiThieuMouseClicked(java.awt.event.MouseEvent evt) { 
       doiMauPnl();
        
        pnlGioiThieu.setkEndColor(new java.awt.Color(185, 237, 221));
        pnlGioiThieu.setkStartColor(new java.awt.Color(185, 237, 221));
        lblGioiThieu.setForeground(new Color(36, 89, 83));
        
        GD_GioiThieu gdgt=new GD_GioiThieu(username);
        openComponent(gdgt);
    } 

    private void pnlDichVuMouseClicked(java.awt.event.MouseEvent evt) { 
        doiMauPnl();
        
        pnlDichVu.setkEndColor(new java.awt.Color(185, 237, 221));
        pnlDichVu.setkStartColor(new java.awt.Color(185, 237, 221));
        lblDichVu.setForeground(new Color(36, 89, 83));
        
        GD_DichVu_QuanLy gddv=new GD_DichVu_QuanLy();
        openComponent(gddv);
    } 

    private void pnlTaiKhoanMouseClicked(java.awt.event.MouseEvent evt) { 
        doiMauPnl();
        
        pnlTaiKhoan.setkEndColor(new java.awt.Color(185, 237, 221));
        pnlTaiKhoan.setkStartColor(new java.awt.Color(185, 237, 221));
        lblTaiKhoan.setForeground(new Color(36, 89, 83));
        GD_TaiKhoan gdtk=new GD_TaiKhoan(username);
        openComponent(gdtk);
    } 

    private void pnlThongKeMouseClicked(java.awt.event.MouseEvent evt) { 
       doiMauPnl();
        
        pnlThongKe.setkEndColor(new java.awt.Color(185, 237, 221));
        pnlThongKe.setkStartColor(new java.awt.Color(185, 237, 221));
        lblThongKe.setForeground(new Color(36, 89, 83));
        GD_ThongKe gdtk=new GD_ThongKe();
        openComponent(gdtk);
    } 

    private void pnlTroGiupMouseClicked(java.awt.event.MouseEvent evt) { 
        doiMauPnl();
        
        pnlTroGiup.setkEndColor(new java.awt.Color(185, 237, 221));
        pnlTroGiup.setkStartColor(new java.awt.Color(185, 237, 221));
        lblTroGiup.setForeground(new Color(36, 89, 83));
        GD_QLTroGiup gdtg1=new GD_QLTroGiup(username);
        openComponent(gdtg1);
    } 

    private void pnlPhongMouseClicked(java.awt.event.MouseEvent evt) { 
        doiMauPnl();
        
        pnlPhong.setkEndColor(new Color(185, 237, 221));
        pnlPhong.setkStartColor(new Color(185, 237, 221));
        lblPhong.setForeground(new Color(36, 89, 83));
        
        openComponent(new GD_QLPhong());
        
    }

    private void btnDoiMatKhau1ActionPerformed(java.awt.event.ActionEvent evt) { 
        GD_DoiMatKhau gd=new GD_DoiMatKhau(username);
        gd.setVisible(true);
    }
    
private void doiMauPnl(){
        pnlGioiThieu.setkEndColor(new java.awt.Color(0,102,102));
        pnlGioiThieu.setkStartColor(new java.awt.Color(0,102,102));
        lblGioiThieu.setForeground(new java.awt.Color(240,238,237));
        
       pnlPhong.setkEndColor(new java.awt.Color(0,102,102));
        pnlPhong.setkStartColor(new java.awt.Color(0,102,102));
        lblPhong.setForeground(new java.awt.Color(240,238,237));

        pnlNhanVien.setkEndColor(new java.awt.Color(0,102,102));
        pnlNhanVien.setkStartColor(new java.awt.Color(0,102,102));
        lblNhanVien.setForeground(new java.awt.Color(240,238,237));
        
        pnlDichVu.setkEndColor(new java.awt.Color(0,102,102));
        pnlDichVu.setkStartColor(new java.awt.Color(0,102,102));
        lblDichVu.setForeground(new java.awt.Color(240,238,237));

        pnlTaiKhoan.setkEndColor(new java.awt.Color(0,102,102));
        pnlTaiKhoan.setkStartColor(new java.awt.Color(0,102,102));
        lblTaiKhoan.setForeground(new java.awt.Color(240,238,237));
        
        pnlKhachHang.setkEndColor(new java.awt.Color(0,102,102));
        pnlKhachHang.setkStartColor(new java.awt.Color(0,102,102));
        lblKhachHang.setForeground(new java.awt.Color(240,238,237));
        
        pnlThongKe.setkEndColor(new java.awt.Color(0,102,102));
        pnlThongKe.setkStartColor(new java.awt.Color(0,102,102));
        lblThongKe.setForeground(new java.awt.Color(240,238,237));
        
        pnlTroGiup.setkEndColor(new java.awt.Color(0,102,102));
        pnlTroGiup.setkStartColor(new java.awt.Color(0,102,102));
        lblTroGiup.setForeground(new java.awt.Color(240,238,237));
        
        pnlKhachHang.setkEndColor(new java.awt.Color(0,102,102));
        pnlKhachHang.setkStartColor(new java.awt.Color(0,102,102));
        pnlKhachHang.setForeground(new java.awt.Color(240,238,237));
} 
    
    void openComponent(JInternalFrame frame) {
        Component[] components = pnlForm.getComponents();
        Component component = null;
        for (int i = 0; i < components.length; i++) {
            component = components[i];
            if (component != null) {
                component.setVisible(false);
            }
        }
        pnlForm.add(frame);
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new GD_QuanLy(username, component).setVisible(true);
        });
    }


    
    private javax.swing.JButton btnDangXuat;
    private javax.swing.JButton btnDoiMatKhau1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private javax.swing.JLabel lblChucVu;
    private javax.swing.JLabel lblDichVu;
    private javax.swing.JLabel lblGioiThieu;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblKhachHang;
    private javax.swing.JLabel lblNhanVien;
    private javax.swing.JLabel lblPhong;
    private javax.swing.JLabel lblTaiKhoan;
    private javax.swing.JLabel lblTen;
    private javax.swing.JLabel lblThongKe;
    private javax.swing.JLabel lblTroGiup;
    private keeptoo.KGradientPanel pnlDichVu;
    private javax.swing.JPanel pnlForm;
    private keeptoo.KGradientPanel pnlGioiThieu;
    private keeptoo.KGradientPanel pnlKhachHang;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlNguoiDung;
    private keeptoo.KGradientPanel pnlNhanVien;
    private keeptoo.KGradientPanel pnlPhong;
    private keeptoo.KGradientPanel pnlTaiKhoan;
    private keeptoo.KGradientPanel pnlThongKe;
    private keeptoo.KGradientPanel pnlTroGiup;
    private void setCursorForPanelÌ£() {
        pnlGioiThieu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pnlPhong.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pnlNhanVien.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pnlDichVu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pnlTaiKhoan.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pnlKhachHang.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pnlThongKe.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pnlTroGiup.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnDoiMatKhau1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnDangXuat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }


}
