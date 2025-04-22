package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.RoundRectangle2D;
import java.lang.reflect.Constructor;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.tools.DocumentationTool;
import keeptoo.KGradientPanel;

public class GD_NhanVien extends javax.swing.JFrame {

    private static String username;
    private static Component component;
    private final GD_GioiThieu frGioiThieu;

    public GD_NhanVien(String user,Component c) {
        username=user;
        component=c;
        this.setResizable(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Quản lý khách sạn");
        initComponents();
        this.setLocationRelativeTo(null);
        // set size max
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        pnlGioiThieu.setkEndColor(new java.awt.Color(185, 237, 221));
        pnlGioiThieu.setkStartColor(new java.awt.Color(185, 237, 221));
        lblGioiThieu.setForeground(new Color(36, 89, 83));
        
        frGioiThieu = new GD_GioiThieu(username);
        openComponent(frGioiThieu);
        
//        eD = new EmployeeDAO();
//        lblTen.setText(eD.findEmpID(user).getEmployeeName());
//        lblChucVu.setText(eD.findEmpID(user).getEmployeeType().getEmployeeTypeName());
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
        pnlDonDat = new keeptoo.KGradientPanel();
        lblDonDat = new javax.swing.JLabel();
        pnlDichVu = new keeptoo.KGradientPanel();
        lblDichVu = new javax.swing.JLabel();
        pnlHoaDon = new keeptoo.KGradientPanel();
        lblHoaDon = new javax.swing.JLabel();
        pnlThongKe = new keeptoo.KGradientPanel();
        lblThongKe = new javax.swing.JLabel();
        pnlTroGiup = new keeptoo.KGradientPanel();
        lblTroGiup = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnDoiMatKhau = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnDangXuat = new javax.swing.JButton();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(200, 200));
        getContentPane().setLayout(new javax.swing.OverlayLayout(getContentPane()));

        pnlMain.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlMain.setDoubleBuffered(false);
        pnlMain.setEnabled(false);
        pnlMain.setFocusable(false);
        pnlMain.setInheritsPopupMenu(true);
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
        lblChucVu.setText("Nhân viên");

        lblImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImage.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblTen.setFont(new java.awt.Font("Verdana", 1, 12));
        lblTen.setForeground(new java.awt.Color(36, 89, 83));
        lblTen.setText("Trần Văn A");

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

        pnlGioiThieu.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        pnlGioiThieu.setkEndColor(new java.awt.Color(0, 102, 102));
        pnlGioiThieu.setkGradientFocus(10);
        pnlGioiThieu.setkStartColor(new java.awt.Color(0, 102, 102));
        pnlGioiThieu.setMaximumSize(new java.awt.Dimension(2147483647, 40));
        pnlGioiThieu.setPreferredSize(new java.awt.Dimension(250, 40));
        pnlGioiThieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlGioiThieuMousePressed(evt);
            }
        });
        pnlGioiThieu.setLayout(new java.awt.BorderLayout());

        lblGioiThieu.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblGioiThieu.setForeground(new java.awt.Color(240, 238, 237));
        lblGioiThieu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGioiThieu.setText("GIỚI THIỆU");
        pnlGioiThieu.add(lblGioiThieu, java.awt.BorderLayout.CENTER);

        kGradientPanel2.add(pnlGioiThieu);

        pnlDonDat.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        pnlDonDat.setkEndColor(new java.awt.Color(0, 102, 102));
        pnlDonDat.setkGradientFocus(10);
        pnlDonDat.setkStartColor(new java.awt.Color(0, 102, 102));
        pnlDonDat.setMaximumSize(new java.awt.Dimension(2147483647, 40));
        pnlDonDat.setPreferredSize(new java.awt.Dimension(250, 40));
        pnlDonDat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlDonDatMousePressed(evt);
            }
        });
        pnlDonDat.setLayout(new java.awt.BorderLayout());

        lblDonDat.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblDonDat.setForeground(new java.awt.Color(240, 238, 237));
        lblDonDat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDonDat.setText("ĐẶT PHÒNG");
        pnlDonDat.add(lblDonDat, java.awt.BorderLayout.CENTER);

        kGradientPanel2.add(pnlDonDat);

        pnlDichVu.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        pnlDichVu.setkEndColor(new java.awt.Color(0, 102, 102));
        pnlDichVu.setkGradientFocus(10);
        pnlDichVu.setkStartColor(new java.awt.Color(0, 102, 102));
        pnlDichVu.setMaximumSize(new java.awt.Dimension(2147483647, 40));
        pnlDichVu.setPreferredSize(new java.awt.Dimension(250, 40));
        pnlDichVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlDichVuMousePressed(evt);
            }
        });
        pnlDichVu.setLayout(new java.awt.BorderLayout());

        lblDichVu.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblDichVu.setForeground(new java.awt.Color(240, 238, 237));
        lblDichVu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDichVu.setText("DỊCH VỤ");
        pnlDichVu.add(lblDichVu, java.awt.BorderLayout.CENTER);

        kGradientPanel2.add(pnlDichVu);

        pnlHoaDon.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        pnlHoaDon.setkEndColor(new java.awt.Color(0, 102, 102));
        pnlHoaDon.setkGradientFocus(10);
        pnlHoaDon.setkStartColor(new java.awt.Color(0, 102, 102));
        pnlHoaDon.setMaximumSize(new java.awt.Dimension(2147483647, 40));
        pnlHoaDon.setPreferredSize(new java.awt.Dimension(250, 40));
        pnlHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlHoaDonMousePressed(evt);
            }
        });
        pnlHoaDon.setLayout(new java.awt.BorderLayout());

        lblHoaDon.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblHoaDon.setForeground(new java.awt.Color(240, 238, 237));
        lblHoaDon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHoaDon.setText("HÓA ĐƠN");
        pnlHoaDon.add(lblHoaDon, java.awt.BorderLayout.CENTER);

        kGradientPanel2.add(pnlHoaDon);

        pnlThongKe.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        pnlThongKe.setkEndColor(new java.awt.Color(0, 102, 102));
        pnlThongKe.setkGradientFocus(10);
        pnlThongKe.setkStartColor(new java.awt.Color(0, 102, 102));
        pnlThongKe.setMaximumSize(new java.awt.Dimension(2147483647, 40));
        pnlThongKe.setPreferredSize(new java.awt.Dimension(250, 40));
        pnlThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlThongKeMousePressed(evt);
            }
        });
        pnlThongKe.setLayout(new java.awt.BorderLayout());

        lblThongKe.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblThongKe.setForeground(new java.awt.Color(240, 238, 237));
        lblThongKe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblThongKe.setText("THỐNG KÊ");
        pnlThongKe.add(lblThongKe, java.awt.BorderLayout.CENTER);

        kGradientPanel2.add(pnlThongKe);

        pnlTroGiup.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        pnlTroGiup.setkEndColor(new java.awt.Color(0, 102, 102));
        pnlTroGiup.setkGradientFocus(10);
        pnlTroGiup.setkStartColor(new java.awt.Color(0, 102, 102));
        pnlTroGiup.setMaximumSize(new java.awt.Dimension(2147483647, 40));
        pnlTroGiup.setPreferredSize(new java.awt.Dimension(250, 40));
        pnlTroGiup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlTroGiupMousePressed(evt);
            }
        });
        pnlTroGiup.setLayout(new java.awt.BorderLayout());

        lblTroGiup.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblTroGiup.setForeground(new java.awt.Color(240, 238, 237));
        lblTroGiup.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTroGiup.setText("TRỢ GIÚP");
        pnlTroGiup.add(lblTroGiup, java.awt.BorderLayout.CENTER);

        kGradientPanel2.add(pnlTroGiup);

        pnlMenu.add(kGradientPanel2);

        jPanel1.setLayout(new java.awt.BorderLayout());

        btnDoiMatKhau.setBackground(new java.awt.Color(36, 89, 83));
        btnDoiMatKhau.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDoiMatKhau.setForeground(new java.awt.Color(255, 255, 255));
        btnDoiMatKhau.setText("ĐỔI MẬT KHẨU");
        btnDoiMatKhau.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(36, 89, 83), 3, true));
        btnDoiMatKhau.setMaximumSize(new java.awt.Dimension(254, 42));
        btnDoiMatKhau.setPreferredSize(new java.awt.Dimension(254, 40));
        btnDoiMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiMatKhauActionPerformed(evt);
            }
        });
        jPanel1.add(btnDoiMatKhau, java.awt.BorderLayout.SOUTH);

        pnlMenu.add(jPanel1);

        jPanel2.setLayout(new java.awt.BorderLayout());

        btnDangXuat.setBackground(new java.awt.Color(252, 249, 250));
        btnDangXuat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
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

        jLabel3.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(36, 89, 83));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("PHẦN MỀM QUẢN LÝ KHÁCH SẠN");
        jLabel3.setToolTipText("");
        jLabel3.setAlignmentX(1.0F);
        jLabel3.setAlignmentY(0.0F);
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        kGradientPanel1.add(jLabel3);

        pnlMain.add(kGradientPanel1, java.awt.BorderLayout.NORTH);

        getContentPane().add(pnlMain);

        pack();
        setLocationRelativeTo(null);
    }

    private void pnlGioiThieuMousePressed(java.awt.event.MouseEvent evt) {
        doiMauPnl();
        
        pnlGioiThieu.setkEndColor(new java.awt.Color(185, 237, 221));
        pnlGioiThieu.setkStartColor(new java.awt.Color(185, 237, 221));
        lblGioiThieu.setForeground(new Color(36, 89, 83));
        openComponent(frGioiThieu);
    }
private void doiMauPnl(){
        pnlGioiThieu.setkEndColor(new java.awt.Color(0,102,102));
        pnlGioiThieu.setkStartColor(new java.awt.Color(0,102,102));
        lblGioiThieu.setForeground(new java.awt.Color(240,238,237));
        
       pnlDonDat.setkEndColor(new java.awt.Color(0,102,102));
        pnlDonDat.setkStartColor(new java.awt.Color(0,102,102));
        lblDonDat.setForeground(new java.awt.Color(240,238,237));

        pnlHoaDon.setkEndColor(new java.awt.Color(0,102,102));
        pnlHoaDon.setkStartColor(new java.awt.Color(0,102,102));
        lblHoaDon.setForeground(new java.awt.Color(240,238,237));
        
        pnlDichVu.setkEndColor(new java.awt.Color(0,102,102));
        pnlDichVu.setkStartColor(new java.awt.Color(0,102,102));
        lblDichVu.setForeground(new java.awt.Color(240,238,237));
        
      
        
        pnlThongKe.setkEndColor(new java.awt.Color(0,102,102));
        pnlThongKe.setkStartColor(new java.awt.Color(0,102,102));
        lblThongKe.setForeground(new java.awt.Color(240,238,237));
        
        pnlTroGiup.setkEndColor(new java.awt.Color(0,102,102));
        pnlTroGiup.setkStartColor(new java.awt.Color(0,102,102));
        lblTroGiup.setForeground(new java.awt.Color(240,238,237));
}
    private void pnlTroGiupMousePressed(java.awt.event.MouseEvent evt) {
        doiMauPnl();
        
        pnlTroGiup.setkEndColor(new java.awt.Color(185,237,221));
        pnlTroGiup.setkStartColor(new java.awt.Color(185,237,221));
        lblTroGiup.setForeground(new Color(36,89,83)); 
        
        GD_QLTroGiup gdtg1=new GD_QLTroGiup(username);
        openComponent(gdtg1);
    }

    private void pnlHoaDonMousePressed(java.awt.event.MouseEvent evt) {
        try {
            doiMauPnl();
            
            pnlHoaDon.setkEndColor(new java.awt.Color(185,237,221));
            pnlHoaDon.setkStartColor(new java.awt.Color(185,237,221));
            lblHoaDon.setForeground(new Color(36,89,83));
            
            GD_ThanhToan gdhd=new GD_ThanhToan();
            openComponent(gdhd);
        } catch (ParseException ex) {
            Logger.getLogger(GD_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void pnlThongKeMousePressed(java.awt.event.MouseEvent evt) {
        doiMauPnl();
        
        pnlThongKe.setkEndColor(new java.awt.Color(185,237,221));
        pnlThongKe.setkStartColor(new java.awt.Color(185,237,221));
        lblThongKe.setForeground(new Color(36,89,83)); 
        GD_ThongKe gdtk=new GD_ThongKe();
        openComponent(gdtk);
    }

    private void btnDangXuatActionPerformed(java.awt.event.ActionEvent evt) {
        if (JOptionPane.showConfirmDialog(this, "Bạn có muốn thoát ?", "Thoát", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            this.setVisible(false);
            component.setVisible(true);
        }
    } 

    private void btnDoiMatKhauActionPerformed(java.awt.event.ActionEvent evt) { 
        GD_DoiMatKhau gd=new GD_DoiMatKhau(username);
        gd.setVisible(true);
    } 

    private void pnlDichVuMousePressed(java.awt.event.MouseEvent evt) { 
        doiMauPnl();
        
        pnlDichVu.setkEndColor(new java.awt.Color(185,237,221));
        pnlDichVu.setkStartColor(new java.awt.Color(185,237,221));
        lblDichVu.setForeground(new Color(36,89,83)); 
        try {
            GD_DichVu_NhanVien gddvnv = new GD_DichVu_NhanVien();
            openComponent(gddvnv);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GD_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GD_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    } 

    private void pnlDonDatMousePressed(java.awt.event.MouseEvent evt) { 
        doiMauPnl();
        System.out.println("Don dat");
        pnlDonDat.setkEndColor(new java.awt.Color(185,237,221));
        pnlDonDat.setkStartColor(new java.awt.Color(185,237,221));
        lblDonDat.setForeground(new Color(36,89,83)); 
        
        GD_DonDat gdDonDat=new GD_DonDat(username);
        openComponent(gdDonDat);
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
    public static void main(String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
  
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GD_NhanVien(username,component);
            }
        });
    }

 
    private javax.swing.JButton btnDangXuat;
    private javax.swing.JButton btnDoiMatKhau;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private javax.swing.JLabel lblChucVu;
    private javax.swing.JLabel lblDichVu;
    private javax.swing.JLabel lblDonDat;
    private javax.swing.JLabel lblGioiThieu;
    private javax.swing.JLabel lblHoaDon;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblTen;
    private javax.swing.JLabel lblThongKe;
    private javax.swing.JLabel lblTroGiup;
    private keeptoo.KGradientPanel pnlDichVu;
    private keeptoo.KGradientPanel pnlDonDat;
    private javax.swing.JPanel pnlForm;
    private keeptoo.KGradientPanel pnlGioiThieu;
    private keeptoo.KGradientPanel pnlHoaDon;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlNguoiDung;
    private keeptoo.KGradientPanel pnlThongKe;
    private keeptoo.KGradientPanel pnlTroGiup; 


}
