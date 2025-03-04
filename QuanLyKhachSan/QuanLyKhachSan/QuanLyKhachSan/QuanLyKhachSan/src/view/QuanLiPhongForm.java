/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

//import controller.SearchDichVu;
import com.formdev.flatlaf.FlatLightLaf;
import controller.InPDF;
import dao.ChiTietHoaDonPhongDAO;
import dao.TaiKhoanDAO;

import dao.DichVuDAO;
import dao.KhachHangDAO;
import dao.PhongDAO;


import java.awt.Color;
import java.awt.Desktop;
import java.awt.Label;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import listener.DatPhongListener;
import listener.TraPhongListener;
import model.ChiTietHoaDonPhong;

import model.HoaDonPhong;
import model.DichVu;
import model.KhachHang;

import model.Phong;
import model.TaiKhoan;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class QuanLiPhongForm extends javax.swing.JInternalFrame {

    Color DefaultColor, ClickedColor;

    private DatPhong datPhong;
    private ThanhToanPhong thanhToanPhong;
   
    DecimalFormat formatter = new DecimalFormat("###,###,###");
    SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    
 
   private DefaultTableModel tblModel;
    private static ArrayList<Phong> phong;
       private DefaultTableModel tblptp;
    private static ArrayList<ChiTietHoaDonPhong> ptp;

    public QuanLiPhongForm() {
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        initComponents();
        initTable();
        initTablePTP();
        datPhong = new DatPhong(this, (JFrame) javax.swing.SwingUtilities.getWindowAncestor(this), rootPaneCheckingEnabled);
        datPhong.setDatPhongListener(new DatPhongListener() {
            @Override
            public void datPhongThanhCong() {
                //System.out.print("datPhongThanhCong -- cc");
                 loadDateToTablePTP(ptp);
                 loadDataToTablePhong(phong);
            }
        });
        
     
      
        
        
        
        
        
        tblDuLieuPhong.setDefaultEditor(Object.class, null);
        phong = PhongDAO.getInstance().selectAll();
        loadDataToTablePhong(phong);
    
        tblPhieuThuePhong.setDefaultEditor(Object.class, null);
        ptp = ChiTietHoaDonPhongDAO.getInstance().selectAll();
        loadDateToTablePTP(ptp);
        
         setColorForPanels();
    }

    public final void initTable() {
        tblModel = new DefaultTableModel();
        String[] headerTbl = new String[]{"Mã phòng", "Trạng thái"};
        tblModel.setColumnIdentifiers(headerTbl);
        tblDuLieuPhong.setModel(tblModel);
    }
     public final void initTablePTP() {
        tblptp = new DefaultTableModel();
        String[] headerTbl = new String[]{"Mã phiếu thuê", "Nhân viên thực hiện","Thời Gian Vào","Tên Khách Hàng","Phòng Thực Hiện"};
        tblptp.setColumnIdentifiers(headerTbl);
        tblPhieuThuePhong.setModel(tblptp);
    }

    public void loadDataToTableNhapHang() {

    }

    public void setNguoiNhapHang(String name) {

    }

    private void createDatPhongWindow(String maPhong, String loaiPhong) {
        datPhong.setMaPhong(maPhong);
        datPhong.setLoaiPhong(loaiPhong);
        datPhong.setNguoiTao();
        datPhong.setThoiGianNhanPhong();
        datPhong.setVisible(true);
 
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDuLieuPhong = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jToolBar2 = new javax.swing.JToolBar();
        btnChuyenPhong = new javax.swing.JButton();
        btnTraPhong = new javax.swing.JButton();
        btnChuyenTrangThai = new javax.swing.JButton();
        btnEditPhong = new javax.swing.JButton();
        btnChuyenTrangThai2 = new javax.swing.JButton();
        btnChuyenTrangThai8 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        phong2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tinhtrangp2 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        phong1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tinhtrangp1 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        phong7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        tinhtrangp7 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        phong10 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        tinhtrangp10 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        phong5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        tinhtrangp5 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        phong4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        tinhtrangp4 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        phong6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        tinhtrangp6 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        phong9 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        tinhtrangp9 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        phong8 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        tinhtrangp8 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        phong15 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        tinhtrangp15 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        phong12 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        tinhtrangp12 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        phong14 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        tinhtrangp14 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        phong13 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        tinhtrangp13 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        panel1 = new java.awt.Panel();
        jLabel37 = new javax.swing.JLabel();
        panel2 = new java.awt.Panel();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        jLabel35 = new javax.swing.JLabel();
        panel3 = new java.awt.Panel();
        jLabel36 = new javax.swing.JLabel();
        phong3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tinhtrangp3 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        phong11 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        tinhtrangp11 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        trangthai1 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        trangthai3 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        trangthai4 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        trangthai5 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPhieuThuePhong = new javax.swing.JTable();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDuLieuPhong1 = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        jToolBar3 = new javax.swing.JToolBar();
        btnDetailPhong1 = new javax.swing.JButton();
        btnChuyenPhong1 = new javax.swing.JButton();
        btnTraPhong1 = new javax.swing.JButton();
        btnChuyenTrangThai1 = new javax.swing.JButton();
        btnEditPhong1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        phong16 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        phong17 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        phong18 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        phong19 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        phong20 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        phong21 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        phong22 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        phong23 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        phong24 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        phong25 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        phong26 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        phong27 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        phong28 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        phong29 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        panel4 = new java.awt.Panel();
        panel5 = new java.awt.Panel();
        label3 = new java.awt.Label();
        label4 = new java.awt.Label();
        panel6 = new java.awt.Panel();
        phong30 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        jPanel6 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblDuLieuPhong2 = new javax.swing.JTable();
        jLabel51 = new javax.swing.JLabel();
        jToolBar4 = new javax.swing.JToolBar();
        btnChuyenPhong2 = new javax.swing.JButton();
        btnTraPhong2 = new javax.swing.JButton();
        btnChuyenTrangThai4 = new javax.swing.JButton();
        btnEditPhong2 = new javax.swing.JButton();
        btnChuyenTrangThai5 = new javax.swing.JButton();
        btnChuyenTrangThai6 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        phong31 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        tinhtrangp16 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        phong32 = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        tinhtrangp17 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        phong33 = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        tinhtrangp18 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        phong34 = new javax.swing.JPanel();
        jLabel66 = new javax.swing.JLabel();
        tinhtrangp19 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        phong35 = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        tinhtrangp20 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        phong36 = new javax.swing.JPanel();
        jLabel70 = new javax.swing.JLabel();
        tinhtrangp21 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        phong37 = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        tinhtrangp22 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        phong38 = new javax.swing.JPanel();
        jLabel74 = new javax.swing.JLabel();
        tinhtrangp23 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        phong39 = new javax.swing.JPanel();
        jLabel76 = new javax.swing.JLabel();
        tinhtrangp24 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        phong40 = new javax.swing.JPanel();
        jLabel78 = new javax.swing.JLabel();
        tinhtrangp25 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        phong41 = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        tinhtrangp26 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        phong42 = new javax.swing.JPanel();
        jLabel82 = new javax.swing.JLabel();
        tinhtrangp27 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        phong43 = new javax.swing.JPanel();
        jLabel84 = new javax.swing.JLabel();
        tinhtrangp28 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        panel7 = new java.awt.Panel();
        jLabel86 = new javax.swing.JLabel();
        panel8 = new java.awt.Panel();
        label5 = new java.awt.Label();
        label6 = new java.awt.Label();
        jLabel87 = new javax.swing.JLabel();
        panel9 = new java.awt.Panel();
        jLabel88 = new javax.swing.JLabel();
        phong44 = new javax.swing.JPanel();
        jLabel89 = new javax.swing.JLabel();
        tinhtrangp29 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        phong45 = new javax.swing.JPanel();
        jLabel91 = new javax.swing.JLabel();
        tinhtrangp30 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        trangthai2 = new javax.swing.JPanel();
        jLabel93 = new javax.swing.JLabel();
        trangthai6 = new javax.swing.JPanel();
        jLabel94 = new javax.swing.JLabel();
        trangthai7 = new javax.swing.JPanel();
        jLabel95 = new javax.swing.JLabel();
        trangthai8 = new javax.swing.JPanel();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblPhieuThuePhong1 = new javax.swing.JTable();
        jInternalFrame3 = new javax.swing.JInternalFrame();
        jPanel9 = new javax.swing.JPanel();
        jLabel98 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblDuLieuPhong3 = new javax.swing.JTable();
        jLabel99 = new javax.swing.JLabel();
        jToolBar5 = new javax.swing.JToolBar();
        btnDetailPhong2 = new javax.swing.JButton();
        btnChuyenPhong3 = new javax.swing.JButton();
        btnTraPhong3 = new javax.swing.JButton();
        btnChuyenTrangThai7 = new javax.swing.JButton();
        btnEditPhong3 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        phong46 = new javax.swing.JPanel();
        jLabel100 = new javax.swing.JLabel();
        phong47 = new javax.swing.JPanel();
        jLabel101 = new javax.swing.JLabel();
        phong48 = new javax.swing.JPanel();
        jLabel102 = new javax.swing.JLabel();
        phong49 = new javax.swing.JPanel();
        jLabel103 = new javax.swing.JLabel();
        phong50 = new javax.swing.JPanel();
        jLabel104 = new javax.swing.JLabel();
        phong51 = new javax.swing.JPanel();
        jLabel105 = new javax.swing.JLabel();
        phong52 = new javax.swing.JPanel();
        jLabel106 = new javax.swing.JLabel();
        phong53 = new javax.swing.JPanel();
        jLabel107 = new javax.swing.JLabel();
        phong54 = new javax.swing.JPanel();
        jLabel108 = new javax.swing.JLabel();
        phong55 = new javax.swing.JPanel();
        jLabel109 = new javax.swing.JLabel();
        phong56 = new javax.swing.JPanel();
        jLabel110 = new javax.swing.JLabel();
        phong57 = new javax.swing.JPanel();
        jLabel111 = new javax.swing.JLabel();
        phong58 = new javax.swing.JPanel();
        jLabel112 = new javax.swing.JLabel();
        phong59 = new javax.swing.JPanel();
        jLabel113 = new javax.swing.JLabel();
        panel10 = new java.awt.Panel();
        panel11 = new java.awt.Panel();
        label7 = new java.awt.Label();
        label8 = new java.awt.Label();
        panel12 = new java.awt.Panel();
        phong60 = new javax.swing.JPanel();
        jLabel114 = new javax.swing.JLabel();

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(1700, 1200));
        setRequestFocusEnabled(false);
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(1380, 859));
        jPanel1.setVerifyInputWhenFocusTarget(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(204, 255, 204));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("SƠ ĐỒ QUẢN LÍ PHÒNG");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, -1, 59));

        tblDuLieuPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã phòng", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblDuLieuPhong);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 620, 590, 210));

        jLabel5.setBackground(new java.awt.Color(153, 0, 51));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Danh Sách Trạng Thái Phòng");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 590, -1, -1));

        jToolBar2.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar2.setBorder(javax.swing.BorderFactory.createTitledBorder("Chức năng"));
        jToolBar2.setRollover(true);

        btnChuyenPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/transfer.png"))); // NOI18N
        btnChuyenPhong.setText("Chuyển phòng");
        btnChuyenPhong.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnChuyenPhong.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnChuyenPhong.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnChuyenPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChuyenPhongActionPerformed(evt);
            }
        });
        jToolBar2.add(btnChuyenPhong);

        btnTraPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logout (1).png"))); // NOI18N
        btnTraPhong.setText("Trả Phong");
        btnTraPhong.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTraPhong.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTraPhong.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnTraPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraPhongActionPerformed(evt);
            }
        });
        jToolBar2.add(btnTraPhong);

        btnChuyenTrangThai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/exchange.png"))); // NOI18N
        btnChuyenTrangThai.setText("Trạng thái trống");
        btnChuyenTrangThai.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnChuyenTrangThai.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnChuyenTrangThai.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnChuyenTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChuyenTrangThaiActionPerformed(evt);
            }
        });
        jToolBar2.add(btnChuyenTrangThai);

        btnEditPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/edit.png"))); // NOI18N
        btnEditPhong.setText("Cập nhật");
        btnEditPhong.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditPhong.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditPhong.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEditPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditPhongActionPerformed(evt);
            }
        });
        jToolBar2.add(btnEditPhong);

        btnChuyenTrangThai2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/up-and-down-arrows (1).png"))); // NOI18N
        btnChuyenTrangThai2.setText("Trạng thái sửa");
        btnChuyenTrangThai2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnChuyenTrangThai2.setFocusable(false);
        btnChuyenTrangThai2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnChuyenTrangThai2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnChuyenTrangThai2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChuyenTrangThai2ActionPerformed(evt);
            }
        });
        jToolBar2.add(btnChuyenTrangThai2);

        btnChuyenTrangThai8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refresh (2).png"))); // NOI18N
        btnChuyenTrangThai8.setText("Làm mới");
        btnChuyenTrangThai8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnChuyenTrangThai8.setFocusable(false);
        btnChuyenTrangThai8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnChuyenTrangThai8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnChuyenTrangThai8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChuyenTrangThai8ActionPerformed(evt);
            }
        });
        jToolBar2.add(btnChuyenTrangThai8);

        jPanel1.add(jToolBar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, 90));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hiện trạng phòng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        phong2.setBackground(new java.awt.Color(51, 0, 0));
        phong2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        phong2.setPreferredSize(new java.awt.Dimension(200, 121));
        phong2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong2MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phong2MousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hotel (7).png"))); // NOI18N
        jLabel1.setText("P1.02");

        tinhtrangp2.setBackground(new java.awt.Color(255, 255, 255));
        tinhtrangp2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tinhtrangp2.setText("tinhtrang1");

        jLabel44.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("Trạng thái :");

        javax.swing.GroupLayout phong2Layout = new javax.swing.GroupLayout(phong2);
        phong2.setLayout(phong2Layout);
        phong2Layout.setHorizontalGroup(
            phong2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong2Layout.createSequentialGroup()
                .addGroup(phong2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phong2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel44)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tinhtrangp2))
                    .addGroup(phong2Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel1)))
                .addGap(0, 35, Short.MAX_VALUE))
        );
        phong2Layout.setVerticalGroup(
            phong2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(phong2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tinhtrangp2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        phong1.setBackground(new java.awt.Color(0, 0, 51));
        phong1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        phong1.setPreferredSize(new java.awt.Dimension(200, 121));
        phong1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phong1MousePressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hotel (7).png"))); // NOI18N
        jLabel2.setText("P1.01");
        jLabel2.setPreferredSize(new java.awt.Dimension(75, 25));

        tinhtrangp1.setBackground(new java.awt.Color(255, 255, 255));
        tinhtrangp1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tinhtrangp1.setText("tinhtrang1");

        jLabel43.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Trạng thái :");

        javax.swing.GroupLayout phong1Layout = new javax.swing.GroupLayout(phong1);
        phong1.setLayout(phong1Layout);
        phong1Layout.setHorizontalGroup(
            phong1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel43)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(tinhtrangp1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addGroup(phong1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        phong1Layout.setVerticalGroup(
            phong1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(phong1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tinhtrangp1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        phong7.setBackground(new java.awt.Color(222, 14, 66));
        phong7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        phong7.setPreferredSize(new java.awt.Dimension(200, 121));
        phong7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong7MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phong7MousePressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hotel (7).png"))); // NOI18N
        jLabel6.setText("P2.02");

        tinhtrangp7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tinhtrangp7.setText("tinhtrang1");

        jLabel45.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("Trạng thái :");

        javax.swing.GroupLayout phong7Layout = new javax.swing.GroupLayout(phong7);
        phong7.setLayout(phong7Layout);
        phong7Layout.setHorizontalGroup(
            phong7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong7Layout.createSequentialGroup()
                .addGroup(phong7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phong7Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(phong7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel45)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tinhtrangp7, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        phong7Layout.setVerticalGroup(
            phong7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(29, 29, 29)
                .addGroup(phong7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tinhtrangp7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        phong10.setBackground(new java.awt.Color(222, 14, 66));
        phong10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        phong10.setPreferredSize(new java.awt.Dimension(200, 121));
        phong10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong10MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phong10MousePressed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hotel (7).png"))); // NOI18N
        jLabel13.setText("P2.05");

        tinhtrangp10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tinhtrangp10.setText("tinhtrang1");

        jLabel59.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setText("Trạng thái :");

        javax.swing.GroupLayout phong10Layout = new javax.swing.GroupLayout(phong10);
        phong10.setLayout(phong10Layout);
        phong10Layout.setHorizontalGroup(
            phong10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong10Layout.createSequentialGroup()
                .addGroup(phong10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phong10Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel13))
                    .addGroup(phong10Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel59)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tinhtrangp10)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        phong10Layout.setVerticalGroup(
            phong10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addGap(26, 26, 26)
                .addGroup(phong10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tinhtrangp10, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel59))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        phong5.setBackground(new java.awt.Color(222, 14, 66));
        phong5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        phong5.setPreferredSize(new java.awt.Dimension(200, 121));
        phong5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong5MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phong5MousePressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hotel (7).png"))); // NOI18N
        jLabel8.setText("P1.05");

        tinhtrangp5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tinhtrangp5.setText("tinhtrang1");

        jLabel58.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setText("Trạng thái :");

        javax.swing.GroupLayout phong5Layout = new javax.swing.GroupLayout(phong5);
        phong5.setLayout(phong5Layout);
        phong5Layout.setHorizontalGroup(
            phong5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong5Layout.createSequentialGroup()
                .addGroup(phong5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phong5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel58)
                        .addGap(21, 21, 21)
                        .addComponent(tinhtrangp5, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(phong5Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel8)))
                .addContainerGap(8, Short.MAX_VALUE))
        );
        phong5Layout.setVerticalGroup(
            phong5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(28, 28, 28)
                .addGroup(phong5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tinhtrangp5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel58))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        phong4.setBackground(new java.awt.Color(51, 51, 0));
        phong4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        phong4.setPreferredSize(new java.awt.Dimension(200, 121));
        phong4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong4MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phong4MousePressed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hotel (7).png"))); // NOI18N
        jLabel9.setText("P1.04");

        tinhtrangp4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tinhtrangp4.setText("tinhtrang1");

        jLabel55.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("Trạng thái :");

        javax.swing.GroupLayout phong4Layout = new javax.swing.GroupLayout(phong4);
        phong4.setLayout(phong4Layout);
        phong4Layout.setHorizontalGroup(
            phong4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong4Layout.createSequentialGroup()
                .addGroup(phong4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phong4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel55)
                        .addGap(12, 12, 12)
                        .addComponent(tinhtrangp4))
                    .addGroup(phong4Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel9)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        phong4Layout.setVerticalGroup(
            phong4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(26, 26, 26)
                .addGroup(phong4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tinhtrangp4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel55))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        phong6.setBackground(new java.awt.Color(222, 14, 66));
        phong6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        phong6.setPreferredSize(new java.awt.Dimension(200, 121));
        phong6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong6MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phong6MousePressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hotel (7).png"))); // NOI18N
        jLabel7.setText("P2.01");

        tinhtrangp6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tinhtrangp6.setText("tinhtrang1");

        jLabel47.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("Trạng thái :");

        javax.swing.GroupLayout phong6Layout = new javax.swing.GroupLayout(phong6);
        phong6.setLayout(phong6Layout);
        phong6Layout.setHorizontalGroup(
            phong6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong6Layout.createSequentialGroup()
                .addGroup(phong6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phong6Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel7))
                    .addGroup(phong6Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel47)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tinhtrangp6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        phong6Layout.setVerticalGroup(
            phong6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(phong6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tinhtrangp6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel47))
                .addGap(30, 30, 30))
        );

        phong9.setBackground(new java.awt.Color(222, 14, 66));
        phong9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        phong9.setPreferredSize(new java.awt.Dimension(200, 121));
        phong9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong9MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phong9MousePressed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hotel (7).png"))); // NOI18N
        jLabel10.setText("P2.04");

        tinhtrangp9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tinhtrangp9.setText("tinhtrang1");

        jLabel56.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setText("Trạng thái :");

        javax.swing.GroupLayout phong9Layout = new javax.swing.GroupLayout(phong9);
        phong9.setLayout(phong9Layout);
        phong9Layout.setHorizontalGroup(
            phong9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong9Layout.createSequentialGroup()
                .addGroup(phong9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phong9Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel10))
                    .addGroup(phong9Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel56)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tinhtrangp9)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        phong9Layout.setVerticalGroup(
            phong9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(27, 27, 27)
                .addGroup(phong9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tinhtrangp9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel56))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        phong8.setBackground(new java.awt.Color(222, 14, 66));
        phong8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        phong8.setPreferredSize(new java.awt.Dimension(200, 121));
        phong8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phong8MousePressed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hotel (7).png"))); // NOI18N
        jLabel11.setText("P2.03");

        tinhtrangp8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tinhtrangp8.setText("tinhtrang1");

        jLabel53.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("Trạng thái :");

        javax.swing.GroupLayout phong8Layout = new javax.swing.GroupLayout(phong8);
        phong8.setLayout(phong8Layout);
        phong8Layout.setHorizontalGroup(
            phong8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel53)
                .addGap(9, 9, 9)
                .addComponent(tinhtrangp8)
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(59, 59, 59))
        );
        phong8Layout.setVerticalGroup(
            phong8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGap(26, 26, 26)
                .addGroup(phong8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tinhtrangp8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel53))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        phong15.setBackground(new java.awt.Color(222, 14, 66));
        phong15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        phong15.setPreferredSize(new java.awt.Dimension(200, 121));
        phong15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong15MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phong15MousePressed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hotel (7).png"))); // NOI18N
        jLabel18.setText("P3.05");

        tinhtrangp15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tinhtrangp15.setText("tinhtrang1");

        jLabel60.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 255, 255));
        jLabel60.setText("Trạng thái :");

        javax.swing.GroupLayout phong15Layout = new javax.swing.GroupLayout(phong15);
        phong15.setLayout(phong15Layout);
        phong15Layout.setHorizontalGroup(
            phong15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong15Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addGroup(phong15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong15Layout.createSequentialGroup()
                        .addComponent(jLabel60)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tinhtrangp15)
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong15Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(61, 61, 61))))
        );
        phong15Layout.setVerticalGroup(
            phong15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addGap(18, 18, 18)
                .addGroup(phong15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tinhtrangp15, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel60))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        phong12.setBackground(new java.awt.Color(222, 14, 66));
        phong12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        phong12.setPreferredSize(new java.awt.Dimension(200, 121));
        phong12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong12MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phong12MousePressed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hotel (7).png"))); // NOI18N
        jLabel15.setText("P3.02");

        tinhtrangp12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tinhtrangp12.setText("tinhtrang1");

        jLabel46.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("Trạng thái :");

        javax.swing.GroupLayout phong12Layout = new javax.swing.GroupLayout(phong12);
        phong12.setLayout(phong12Layout);
        phong12Layout.setHorizontalGroup(
            phong12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong12Layout.createSequentialGroup()
                .addGroup(phong12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phong12Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel15))
                    .addGroup(phong12Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel46)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tinhtrangp12)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        phong12Layout.setVerticalGroup(
            phong12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong12Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addGroup(phong12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tinhtrangp12, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        phong14.setBackground(new java.awt.Color(222, 14, 66));
        phong14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        phong14.setPreferredSize(new java.awt.Dimension(200, 121));
        phong14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong14MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phong14MousePressed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hotel (7).png"))); // NOI18N
        jLabel17.setText("P3.04");

        tinhtrangp14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tinhtrangp14.setText("tinhtrang1");

        jLabel57.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setText("Trạng thái :");

        javax.swing.GroupLayout phong14Layout = new javax.swing.GroupLayout(phong14);
        phong14.setLayout(phong14Layout);
        phong14Layout.setHorizontalGroup(
            phong14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong14Layout.createSequentialGroup()
                .addGroup(phong14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phong14Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel57)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tinhtrangp14))
                    .addGroup(phong14Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel17)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        phong14Layout.setVerticalGroup(
            phong14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addGroup(phong14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tinhtrangp14, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel57))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        phong13.setBackground(new java.awt.Color(222, 14, 66));
        phong13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        phong13.setPreferredSize(new java.awt.Dimension(200, 121));
        phong13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong13MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phong13MousePressed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hotel (7).png"))); // NOI18N
        jLabel16.setText("P3.03");

        tinhtrangp13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tinhtrangp13.setText("tinhtrang1");

        jLabel54.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setText("Trạng thái :");

        javax.swing.GroupLayout phong13Layout = new javax.swing.GroupLayout(phong13);
        phong13.setLayout(phong13Layout);
        phong13Layout.setHorizontalGroup(
            phong13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong13Layout.createSequentialGroup()
                .addGroup(phong13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phong13Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel16))
                    .addGroup(phong13Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel54)
                        .addGap(9, 9, 9)
                        .addComponent(tinhtrangp13, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        phong13Layout.setVerticalGroup(
            phong13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addGroup(phong13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tinhtrangp13, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel54))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        panel1.setBackground(new java.awt.Color(51, 51, 51));
        panel1.setPreferredSize(new java.awt.Dimension(100, 121));

        jLabel37.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Tầng 3");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel37)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel37)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel2.setBackground(new java.awt.Color(51, 51, 51));

        label1.setText("label1");

        label2.setText("label2");

        jLabel35.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Tầng 1");

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel35)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel35)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        panel3.setBackground(new java.awt.Color(51, 51, 51));

        jLabel36.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Tầng 2");

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel36)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel36)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        phong3.setBackground(new java.awt.Color(14, 74, 82));
        phong3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        phong3.setPreferredSize(new java.awt.Dimension(200, 121));
        phong3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong3MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phong3MousePressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hotel (7).png"))); // NOI18N
        jLabel3.setText("P1.03");

        tinhtrangp3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tinhtrangp3.setText("tinhtrang1");

        jLabel49.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("Trạng thái :");

        javax.swing.GroupLayout phong3Layout = new javax.swing.GroupLayout(phong3);
        phong3.setLayout(phong3Layout);
        phong3Layout.setHorizontalGroup(
            phong3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel49)
                .addGap(9, 9, 9)
                .addComponent(tinhtrangp3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(58, 58, 58))
        );
        phong3Layout.setVerticalGroup(
            phong3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(28, 28, 28)
                .addGroup(phong3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tinhtrangp3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        phong11.setBackground(new java.awt.Color(222, 14, 66));
        phong11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        phong11.setPreferredSize(new java.awt.Dimension(200, 121));
        phong11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong11MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phong11MousePressed(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hotel (7).png"))); // NOI18N
        jLabel41.setText("P3.01");

        tinhtrangp11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tinhtrangp11.setText("tinhtrang1");

        jLabel48.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("Trạng thái :");

        javax.swing.GroupLayout phong11Layout = new javax.swing.GroupLayout(phong11);
        phong11.setLayout(phong11Layout);
        phong11Layout.setHorizontalGroup(
            phong11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong11Layout.createSequentialGroup()
                .addGroup(phong11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phong11Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel41))
                    .addGroup(phong11Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel48)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tinhtrangp11)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        phong11Layout.setVerticalGroup(
            phong11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel41)
                .addGap(18, 18, 18)
                .addGroup(phong11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tinhtrangp11, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel48))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(phong6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(phong1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(phong2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phong7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(phong11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phong12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(phong3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phong4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(phong8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phong9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(phong13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phong14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phong10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phong5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phong15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(phong3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phong4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phong5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(phong10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phong8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phong9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(phong2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phong1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(phong6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phong7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(phong11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phong12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phong13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phong14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phong15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(83, 83, 83))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 1170, 400));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ghi chú trạng thái phòng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        trangthai1.setBackground(new java.awt.Color(4, 105, 4));
        trangthai1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        trangthai1.setPreferredSize(new java.awt.Dimension(153, 54));
        trangthai1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                trangthai1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                trangthai1MousePressed(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Sẵn Sàng");

        javax.swing.GroupLayout trangthai1Layout = new javax.swing.GroupLayout(trangthai1);
        trangthai1.setLayout(trangthai1Layout);
        trangthai1Layout.setHorizontalGroup(
            trangthai1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(trangthai1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel38)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        trangthai1Layout.setVerticalGroup(
            trangthai1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(trangthai1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel38)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        trangthai3.setBackground(new java.awt.Color(204, 0, 0));
        trangthai3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        trangthai3.setPreferredSize(new java.awt.Dimension(153, 54));
        trangthai3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                trangthai3MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                trangthai3MousePressed(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Có Khách");

        javax.swing.GroupLayout trangthai3Layout = new javax.swing.GroupLayout(trangthai3);
        trangthai3.setLayout(trangthai3Layout);
        trangthai3Layout.setHorizontalGroup(
            trangthai3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(trangthai3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel40)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        trangthai3Layout.setVerticalGroup(
            trangthai3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(trangthai3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel40)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        trangthai4.setBackground(new java.awt.Color(67, 39, 39));
        trangthai4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        trangthai4.setPreferredSize(new java.awt.Dimension(153, 54));
        trangthai4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                trangthai4MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                trangthai4MousePressed(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText(" Đang Dọn");

        javax.swing.GroupLayout trangthai4Layout = new javax.swing.GroupLayout(trangthai4);
        trangthai4.setLayout(trangthai4Layout);
        trangthai4Layout.setHorizontalGroup(
            trangthai4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(trangthai4Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel42)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        trangthai4Layout.setVerticalGroup(
            trangthai4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(trangthai4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel42)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        trangthai5.setBackground(new java.awt.Color(0, 51, 102));
        trangthai5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        trangthai5.setPreferredSize(new java.awt.Dimension(153, 54));
        trangthai5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                trangthai5MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                trangthai5MousePressed(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Đang Sửa");

        javax.swing.GroupLayout trangthai5Layout = new javax.swing.GroupLayout(trangthai5);
        trangthai5.setLayout(trangthai5Layout);
        trangthai5Layout.setHorizontalGroup(
            trangthai5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trangthai5Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(jLabel39)
                .addGap(32, 32, 32))
        );
        trangthai5Layout.setVerticalGroup(
            trangthai5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(trangthai5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel39)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(trangthai1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(trangthai5, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(trangthai3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(trangthai4, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(trangthai5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(trangthai1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(trangthai4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(trangthai3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(512, 80, 670, 90));

        jLabel14.setBackground(new java.awt.Color(153, 0, 51));
        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Danh Sách Phiếu Thuê Phòng");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 590, 340, -1));

        tblPhieuThuePhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã phiếu thuê", "Nhân viên thực hiện ", "Thời gian tạo phiếu", "Tên khách hàng", "Phòng thực hiện "
            }
        ));
        jScrollPane3.setViewportView(tblPhieuThuePhong);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 620, 590, 210));

        jInternalFrame1.setBorder(null);
        jInternalFrame1.setPreferredSize(new java.awt.Dimension(1700, 1200));
        jInternalFrame1.setRequestFocusEnabled(false);
        try {
            jInternalFrame1.setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }

        jPanel3.setBackground(new java.awt.Color(0, 255, 204));
        jPanel3.setForeground(new java.awt.Color(204, 204, 204));
        jPanel3.setPreferredSize(new java.awt.Dimension(1180, 750));
        jPanel3.setVerifyInputWhenFocusTarget(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setBackground(new java.awt.Color(204, 255, 204));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 102));
        jLabel12.setText("SƠ ĐỒ QUẢN LÍ PHÒNG");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, -1, 59));

        tblDuLieuPhong1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã phòng", "Tiền dịch vụ", "Loại phòng", "Nhân viên thực hiện ", "Thời gian vào nhận phòng", "Số người", "CCCD/CMND", "Trạng thái", "Tên khách hàng"
            }
        ));
        jScrollPane2.setViewportView(tblDuLieuPhong1);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 620, 1270, 220));

        jLabel19.setBackground(new java.awt.Color(153, 0, 51));
        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(222, 14, 66));
        jLabel19.setText("Danh Sách Phiếu Thuê");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 580, -1, -1));

        jToolBar3.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar3.setBorder(javax.swing.BorderFactory.createTitledBorder("Chức năng"));
        jToolBar3.setRollover(true);

        btnDetailPhong1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/eye.png"))); // NOI18N
        btnDetailPhong1.setText("Xem chi tiết");
        btnDetailPhong1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDetailPhong1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDetailPhong1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDetailPhong1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailPhong1ActionPerformed(evt);
            }
        });
        jToolBar3.add(btnDetailPhong1);

        btnChuyenPhong1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/transfer.png"))); // NOI18N
        btnChuyenPhong1.setText("Chuyển phòng");
        btnChuyenPhong1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnChuyenPhong1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnChuyenPhong1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnChuyenPhong1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChuyenPhong1ActionPerformed(evt);
            }
        });
        jToolBar3.add(btnChuyenPhong1);

        btnTraPhong1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logout (1).png"))); // NOI18N
        btnTraPhong1.setText("Trả Phong");
        btnTraPhong1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTraPhong1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTraPhong1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnTraPhong1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraPhong1ActionPerformed(evt);
            }
        });
        jToolBar3.add(btnTraPhong1);

        btnChuyenTrangThai1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/exchange.png"))); // NOI18N
        btnChuyenTrangThai1.setText("Trạng thái phòng sẵn");
        btnChuyenTrangThai1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnChuyenTrangThai1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnChuyenTrangThai1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnChuyenTrangThai1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChuyenTrangThai1ActionPerformed(evt);
            }
        });
        jToolBar3.add(btnChuyenTrangThai1);

        btnEditPhong1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/edit.png"))); // NOI18N
        btnEditPhong1.setText("Sửa");
        btnEditPhong1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditPhong1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditPhong1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEditPhong1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditPhong1ActionPerformed(evt);
            }
        });
        jToolBar3.add(btnEditPhong1);

        jPanel3.add(jToolBar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 400, 90));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "huhu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        phong16.setBackground(new java.awt.Color(222, 14, 66));
        phong16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        phong16.setPreferredSize(new java.awt.Dimension(200, 121));
        phong16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong16MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phong16MousePressed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hotel (7).png"))); // NOI18N
        jLabel20.setText("P1.02");

        javax.swing.GroupLayout phong16Layout = new javax.swing.GroupLayout(phong16);
        phong16.setLayout(phong16Layout);
        phong16Layout.setHorizontalGroup(
            phong16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong16Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel20)
                .addContainerGap(77, Short.MAX_VALUE))
        );
        phong16Layout.setVerticalGroup(
            phong16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        phong17.setBackground(new java.awt.Color(222, 14, 66));
        phong17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        phong17.setPreferredSize(new java.awt.Dimension(200, 121));
        phong17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong17MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phong17MousePressed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hotel (7).png"))); // NOI18N
        jLabel21.setText("P1.01");
        jLabel21.setPreferredSize(new java.awt.Dimension(75, 25));

        javax.swing.GroupLayout phong17Layout = new javax.swing.GroupLayout(phong17);
        phong17.setLayout(phong17Layout);
        phong17Layout.setHorizontalGroup(
            phong17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong17Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );
        phong17Layout.setVerticalGroup(
            phong17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );

        phong18.setBackground(new java.awt.Color(222, 14, 66));
        phong18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        phong18.setPreferredSize(new java.awt.Dimension(200, 121));
        phong18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong18MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phong18MousePressed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hotel (7).png"))); // NOI18N
        jLabel22.setText("P2.02");

        javax.swing.GroupLayout phong18Layout = new javax.swing.GroupLayout(phong18);
        phong18.setLayout(phong18Layout);
        phong18Layout.setHorizontalGroup(
            phong18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong18Layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(jLabel22)
                .addGap(60, 60, 60))
        );
        phong18Layout.setVerticalGroup(
            phong18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        phong19.setBackground(new java.awt.Color(222, 14, 66));
        phong19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        phong19.setPreferredSize(new java.awt.Dimension(200, 121));
        phong19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong19MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phong19MousePressed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hotel (7).png"))); // NOI18N
        jLabel23.setText("P2.05");

        javax.swing.GroupLayout phong19Layout = new javax.swing.GroupLayout(phong19);
        phong19.setLayout(phong19Layout);
        phong19Layout.setHorizontalGroup(
            phong19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong19Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel23)
                .addContainerGap(71, Short.MAX_VALUE))
        );
        phong19Layout.setVerticalGroup(
            phong19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        phong20.setBackground(new java.awt.Color(222, 14, 66));
        phong20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        phong20.setPreferredSize(new java.awt.Dimension(200, 121));
        phong20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong20MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phong20MousePressed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hotel (7).png"))); // NOI18N
        jLabel24.setText("P1.05");

        javax.swing.GroupLayout phong20Layout = new javax.swing.GroupLayout(phong20);
        phong20.setLayout(phong20Layout);
        phong20Layout.setHorizontalGroup(
            phong20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong20Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel24)
                .addContainerGap(73, Short.MAX_VALUE))
        );
        phong20Layout.setVerticalGroup(
            phong20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        phong21.setBackground(new java.awt.Color(222, 14, 66));
        phong21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        phong21.setPreferredSize(new java.awt.Dimension(200, 121));
        phong21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong21MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phong21MousePressed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hotel (7).png"))); // NOI18N
        jLabel25.setText("P1.04");

        javax.swing.GroupLayout phong21Layout = new javax.swing.GroupLayout(phong21);
        phong21.setLayout(phong21Layout);
        phong21Layout.setHorizontalGroup(
            phong21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong21Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel25)
                .addContainerGap(71, Short.MAX_VALUE))
        );
        phong21Layout.setVerticalGroup(
            phong21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        phong22.setBackground(new java.awt.Color(222, 14, 66));
        phong22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        phong22.setPreferredSize(new java.awt.Dimension(200, 121));
        phong22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong22MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phong22MousePressed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hotel (7).png"))); // NOI18N
        jLabel26.setText("P2.01");

        javax.swing.GroupLayout phong22Layout = new javax.swing.GroupLayout(phong22);
        phong22.setLayout(phong22Layout);
        phong22Layout.setHorizontalGroup(
            phong22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong22Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel26)
                .addGap(59, 59, 59))
        );
        phong22Layout.setVerticalGroup(
            phong22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        phong23.setBackground(new java.awt.Color(222, 14, 66));
        phong23.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        phong23.setPreferredSize(new java.awt.Dimension(200, 121));
        phong23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong23MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phong23MousePressed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hotel (7).png"))); // NOI18N
        jLabel27.setText("P2.04");

        javax.swing.GroupLayout phong23Layout = new javax.swing.GroupLayout(phong23);
        phong23.setLayout(phong23Layout);
        phong23Layout.setHorizontalGroup(
            phong23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong23Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel27)
                .addContainerGap(66, Short.MAX_VALUE))
        );
        phong23Layout.setVerticalGroup(
            phong23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        phong24.setBackground(new java.awt.Color(222, 14, 66));
        phong24.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        phong24.setPreferredSize(new java.awt.Dimension(200, 121));
        phong24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong24MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phong24MousePressed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hotel (7).png"))); // NOI18N
        jLabel28.setText("P2.03");

        javax.swing.GroupLayout phong24Layout = new javax.swing.GroupLayout(phong24);
        phong24.setLayout(phong24Layout);
        phong24Layout.setHorizontalGroup(
            phong24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong24Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel28)
                .addContainerGap(68, Short.MAX_VALUE))
        );
        phong24Layout.setVerticalGroup(
            phong24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        phong25.setBackground(new java.awt.Color(222, 14, 66));
        phong25.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        phong25.setPreferredSize(new java.awt.Dimension(200, 121));
        phong25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong25MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phong25MousePressed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hotel (7).png"))); // NOI18N
        jLabel29.setText("P3.05");

        javax.swing.GroupLayout phong25Layout = new javax.swing.GroupLayout(phong25);
        phong25.setLayout(phong25Layout);
        phong25Layout.setHorizontalGroup(
            phong25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong25Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel29)
                .addContainerGap(68, Short.MAX_VALUE))
        );
        phong25Layout.setVerticalGroup(
            phong25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        phong26.setBackground(new java.awt.Color(222, 14, 66));
        phong26.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        phong26.setPreferredSize(new java.awt.Dimension(200, 121));
        phong26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong26MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phong26MousePressed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hotel (7).png"))); // NOI18N
        jLabel30.setText("P3.02");

        javax.swing.GroupLayout phong26Layout = new javax.swing.GroupLayout(phong26);
        phong26.setLayout(phong26Layout);
        phong26Layout.setHorizontalGroup(
            phong26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong26Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel30)
                .addContainerGap(62, Short.MAX_VALUE))
        );
        phong26Layout.setVerticalGroup(
            phong26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        phong27.setBackground(new java.awt.Color(222, 14, 66));
        phong27.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        phong27.setPreferredSize(new java.awt.Dimension(200, 121));
        phong27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong27MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phong27MousePressed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hotel (7).png"))); // NOI18N
        jLabel31.setText("P3.04");

        javax.swing.GroupLayout phong27Layout = new javax.swing.GroupLayout(phong27);
        phong27.setLayout(phong27Layout);
        phong27Layout.setHorizontalGroup(
            phong27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong27Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel31)
                .addContainerGap(64, Short.MAX_VALUE))
        );
        phong27Layout.setVerticalGroup(
            phong27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel31)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        phong28.setBackground(new java.awt.Color(222, 14, 66));
        phong28.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        phong28.setPreferredSize(new java.awt.Dimension(200, 121));
        phong28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong28MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phong28MousePressed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hotel (7).png"))); // NOI18N
        jLabel32.setText("P3.01");

        javax.swing.GroupLayout phong28Layout = new javax.swing.GroupLayout(phong28);
        phong28.setLayout(phong28Layout);
        phong28Layout.setHorizontalGroup(
            phong28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong28Layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(jLabel32)
                .addGap(60, 60, 60))
        );
        phong28Layout.setVerticalGroup(
            phong28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel32)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        phong29.setBackground(new java.awt.Color(222, 14, 66));
        phong29.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        phong29.setPreferredSize(new java.awt.Dimension(200, 121));
        phong29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong29MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phong29MousePressed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hotel (7).png"))); // NOI18N
        jLabel33.setText("P3.03");

        javax.swing.GroupLayout phong29Layout = new javax.swing.GroupLayout(phong29);
        phong29.setLayout(phong29Layout);
        phong29Layout.setHorizontalGroup(
            phong29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong29Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel33)
                .addContainerGap(66, Short.MAX_VALUE))
        );
        phong29Layout.setVerticalGroup(
            phong29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel33)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        panel4.setBackground(new java.awt.Color(153, 153, 153));
        panel4.setPreferredSize(new java.awt.Dimension(100, 121));

        javax.swing.GroupLayout panel4Layout = new javax.swing.GroupLayout(panel4);
        panel4.setLayout(panel4Layout);
        panel4Layout.setHorizontalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        panel4Layout.setVerticalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panel5.setBackground(new java.awt.Color(153, 153, 153));

        label3.setText("label1");

        label4.setText("label2");

        javax.swing.GroupLayout panel5Layout = new javax.swing.GroupLayout(panel5);
        panel5.setLayout(panel5Layout);
        panel5Layout.setHorizontalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        panel5Layout.setVerticalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 121, Short.MAX_VALUE)
        );

        panel6.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout panel6Layout = new javax.swing.GroupLayout(panel6);
        panel6.setLayout(panel6Layout);
        panel6Layout.setHorizontalGroup(
            panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        panel6Layout.setVerticalGroup(
            panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 121, Short.MAX_VALUE)
        );

        phong30.setBackground(new java.awt.Color(222, 14, 66));
        phong30.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        phong30.setPreferredSize(new java.awt.Dimension(200, 121));
        phong30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong30MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phong30MousePressed(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hotel (7).png"))); // NOI18N
        jLabel34.setText("P1.03");

        javax.swing.GroupLayout phong30Layout = new javax.swing.GroupLayout(phong30);
        phong30.setLayout(phong30Layout);
        phong30Layout.setHorizontalGroup(
            phong30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong30Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel34)
                .addContainerGap(68, Short.MAX_VALUE))
        );
        phong30Layout.setVerticalGroup(
            phong30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong30Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel34)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(phong22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(phong17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(phong16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phong18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(phong28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phong26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(phong30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phong21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(phong24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phong23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(phong29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phong27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phong19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phong20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phong25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(117, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(panel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(panel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(phong28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(phong26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(phong29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(phong27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(phong25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(83, 83, 83))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(phong30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(phong21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(phong20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(2, 2, 2)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(phong19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(phong24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(phong23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(phong16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(phong17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(2, 2, 2)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(phong22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(phong18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 1270, 400));

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 859, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jInternalFrame2.setBorder(null);
        jInternalFrame2.setPreferredSize(new java.awt.Dimension(1700, 1200));
        jInternalFrame2.setRequestFocusEnabled(false);
        try {
            jInternalFrame2.setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setForeground(new java.awt.Color(204, 204, 204));
        jPanel6.setPreferredSize(new java.awt.Dimension(1380, 859));
        jPanel6.setVerifyInputWhenFocusTarget(false);
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel50.setBackground(new java.awt.Color(204, 255, 204));
        jLabel50.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(0, 0, 0));
        jLabel50.setText("SƠ ĐỒ QUẢN LÍ PHÒNG");
        jPanel6.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, -1, 59));

        tblDuLieuPhong2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã phòng", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblDuLieuPhong2);

        jPanel6.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 620, 590, 210));

        jLabel51.setBackground(new java.awt.Color(153, 0, 51));
        jLabel51.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(0, 0, 0));
        jLabel51.setText("Danh Sách Trạng Thái Phòng");
        jPanel6.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 590, -1, -1));

        jToolBar4.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar4.setBorder(javax.swing.BorderFactory.createTitledBorder("Chức năng"));
        jToolBar4.setRollover(true);

        btnChuyenPhong2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/transfer.png"))); // NOI18N
        btnChuyenPhong2.setText("Chuyển phòng");
        btnChuyenPhong2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnChuyenPhong2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnChuyenPhong2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnChuyenPhong2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChuyenPhong2ActionPerformed(evt);
            }
        });
        jToolBar4.add(btnChuyenPhong2);

        btnTraPhong2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logout (1).png"))); // NOI18N
        btnTraPhong2.setText("Trả Phong");
        btnTraPhong2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTraPhong2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTraPhong2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnTraPhong2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraPhong2ActionPerformed(evt);
            }
        });
        jToolBar4.add(btnTraPhong2);

        btnChuyenTrangThai4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/exchange.png"))); // NOI18N
        btnChuyenTrangThai4.setText("Trạng thái trống");
        btnChuyenTrangThai4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnChuyenTrangThai4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnChuyenTrangThai4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnChuyenTrangThai4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChuyenTrangThai4ActionPerformed(evt);
            }
        });
        jToolBar4.add(btnChuyenTrangThai4);

        btnEditPhong2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/edit.png"))); // NOI18N
        btnEditPhong2.setText("Cập nhật");
        btnEditPhong2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditPhong2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditPhong2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEditPhong2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditPhong2ActionPerformed(evt);
            }
        });
        jToolBar4.add(btnEditPhong2);

        btnChuyenTrangThai5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/up-and-down-arrows (1).png"))); // NOI18N
        btnChuyenTrangThai5.setText("Trạng thái sửa");
        btnChuyenTrangThai5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnChuyenTrangThai5.setFocusable(false);
        btnChuyenTrangThai5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnChuyenTrangThai5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnChuyenTrangThai5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChuyenTrangThai5ActionPerformed(evt);
            }
        });
        jToolBar4.add(btnChuyenTrangThai5);

        btnChuyenTrangThai6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refresh.png"))); // NOI18N
        btnChuyenTrangThai6.setText("Làm mới");
        btnChuyenTrangThai6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnChuyenTrangThai6.setFocusable(false);
        btnChuyenTrangThai6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnChuyenTrangThai6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnChuyenTrangThai6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChuyenTrangThai6ActionPerformed(evt);
            }
        });
        jToolBar4.add(btnChuyenTrangThai6);

        jPanel6.add(jToolBar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 470, 90));

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hiện trạng phòng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        phong31.setBackground(new java.awt.Color(51, 0, 0));
        phong31.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        phong31.setPreferredSize(new java.awt.Dimension(200, 121));
        phong31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong31MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phong31MousePressed(evt);
            }
        });

        jLabel52.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hotel (7).png"))); // NOI18N
        jLabel52.setText("P1.02");

        tinhtrangp16.setBackground(new java.awt.Color(255, 255, 255));
        tinhtrangp16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tinhtrangp16.setText("tinhtrang1");

        jLabel61.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setText("Trạng thái :");

        javax.swing.GroupLayout phong31Layout = new javax.swing.GroupLayout(phong31);
        phong31.setLayout(phong31Layout);
        phong31Layout.setHorizontalGroup(
            phong31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong31Layout.createSequentialGroup()
                .addGroup(phong31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phong31Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel61)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tinhtrangp16))
                    .addGroup(phong31Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel52)))
                .addGap(0, 35, Short.MAX_VALUE))
        );
        phong31Layout.setVerticalGroup(
            phong31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel52)
                .addGap(27, 27, 27)
                .addGroup(phong31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tinhtrangp16, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel61))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        phong32.setBackground(new java.awt.Color(0, 0, 51));
        phong32.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        phong32.setPreferredSize(new java.awt.Dimension(200, 121));
        phong32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong32MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phong32MousePressed(evt);
            }
        });

        jLabel62.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(255, 255, 255));
        jLabel62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hotel (7).png"))); // NOI18N
        jLabel62.setText("P1.01");
        jLabel62.setPreferredSize(new java.awt.Dimension(75, 25));

        tinhtrangp17.setBackground(new java.awt.Color(255, 255, 255));
        tinhtrangp17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tinhtrangp17.setText("tinhtrang1");

        jLabel63.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(255, 255, 255));
        jLabel63.setText("Trạng thái :");

        javax.swing.GroupLayout phong32Layout = new javax.swing.GroupLayout(phong32);
        phong32.setLayout(phong32Layout);
        phong32Layout.setHorizontalGroup(
            phong32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong32Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel63)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(tinhtrangp17, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addGroup(phong32Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        phong32Layout.setVerticalGroup(
            phong32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong32Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(phong32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tinhtrangp17, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel63))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        phong33.setBackground(new java.awt.Color(222, 14, 66));
        phong33.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        phong33.setPreferredSize(new java.awt.Dimension(200, 121));
        phong33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong33MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phong33MousePressed(evt);
            }
        });

        jLabel64.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(255, 255, 255));
        jLabel64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hotel (7).png"))); // NOI18N
        jLabel64.setText("P2.02");

        tinhtrangp18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tinhtrangp18.setText("tinhtrang1");

        jLabel65.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(255, 255, 255));
        jLabel65.setText("Trạng thái :");

        javax.swing.GroupLayout phong33Layout = new javax.swing.GroupLayout(phong33);
        phong33.setLayout(phong33Layout);
        phong33Layout.setHorizontalGroup(
            phong33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong33Layout.createSequentialGroup()
                .addGroup(phong33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phong33Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(phong33Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel65)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tinhtrangp18, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        phong33Layout.setVerticalGroup(
            phong33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong33Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel64)
                .addGap(29, 29, 29)
                .addGroup(phong33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tinhtrangp18, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel65))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        phong34.setBackground(new java.awt.Color(222, 14, 66));
        phong34.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        phong34.setPreferredSize(new java.awt.Dimension(200, 121));
        phong34.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong34MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phong34MousePressed(evt);
            }
        });

        jLabel66.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(255, 255, 255));
        jLabel66.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hotel (7).png"))); // NOI18N
        jLabel66.setText("P2.05");

        tinhtrangp19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tinhtrangp19.setText("tinhtrang1");

        jLabel67.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(255, 255, 255));
        jLabel67.setText("Trạng thái :");

        javax.swing.GroupLayout phong34Layout = new javax.swing.GroupLayout(phong34);
        phong34.setLayout(phong34Layout);
        phong34Layout.setHorizontalGroup(
            phong34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong34Layout.createSequentialGroup()
                .addGroup(phong34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phong34Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel66))
                    .addGroup(phong34Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel67)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tinhtrangp19)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        phong34Layout.setVerticalGroup(
            phong34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong34Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel66)
                .addGap(26, 26, 26)
                .addGroup(phong34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tinhtrangp19, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel67))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        phong35.setBackground(new java.awt.Color(222, 14, 66));
        phong35.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        phong35.setPreferredSize(new java.awt.Dimension(200, 121));
        phong35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong35MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phong35MousePressed(evt);
            }
        });

        jLabel68.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(255, 255, 255));
        jLabel68.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hotel (7).png"))); // NOI18N
        jLabel68.setText("P1.05");

        tinhtrangp20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tinhtrangp20.setText("tinhtrang1");

        jLabel69.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(255, 255, 255));
        jLabel69.setText("Trạng thái :");

        javax.swing.GroupLayout phong35Layout = new javax.swing.GroupLayout(phong35);
        phong35.setLayout(phong35Layout);
        phong35Layout.setHorizontalGroup(
            phong35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong35Layout.createSequentialGroup()
                .addGroup(phong35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phong35Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel69)
                        .addGap(21, 21, 21)
                        .addComponent(tinhtrangp20, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(phong35Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel68)))
                .addContainerGap(8, Short.MAX_VALUE))
        );
        phong35Layout.setVerticalGroup(
            phong35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong35Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel68)
                .addGap(28, 28, 28)
                .addGroup(phong35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tinhtrangp20, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel69))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        phong36.setBackground(new java.awt.Color(51, 51, 0));
        phong36.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        phong36.setPreferredSize(new java.awt.Dimension(200, 121));
        phong36.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong36MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phong36MousePressed(evt);
            }
        });

        jLabel70.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(255, 255, 255));
        jLabel70.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hotel (7).png"))); // NOI18N
        jLabel70.setText("P1.04");

        tinhtrangp21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tinhtrangp21.setText("tinhtrang1");

        jLabel71.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(255, 255, 255));
        jLabel71.setText("Trạng thái :");

        javax.swing.GroupLayout phong36Layout = new javax.swing.GroupLayout(phong36);
        phong36.setLayout(phong36Layout);
        phong36Layout.setHorizontalGroup(
            phong36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong36Layout.createSequentialGroup()
                .addGroup(phong36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phong36Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel71)
                        .addGap(12, 12, 12)
                        .addComponent(tinhtrangp21))
                    .addGroup(phong36Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel70)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        phong36Layout.setVerticalGroup(
            phong36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong36Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel70)
                .addGap(26, 26, 26)
                .addGroup(phong36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tinhtrangp21, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel71))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        phong37.setBackground(new java.awt.Color(222, 14, 66));
        phong37.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        phong37.setPreferredSize(new java.awt.Dimension(200, 121));
        phong37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong37MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phong37MousePressed(evt);
            }
        });

        jLabel72.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(255, 255, 255));
        jLabel72.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hotel (7).png"))); // NOI18N
        jLabel72.setText("P2.01");

        tinhtrangp22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tinhtrangp22.setText("tinhtrang1");

        jLabel73.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(255, 255, 255));
        jLabel73.setText("Trạng thái :");

        javax.swing.GroupLayout phong37Layout = new javax.swing.GroupLayout(phong37);
        phong37.setLayout(phong37Layout);
        phong37Layout.setHorizontalGroup(
            phong37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong37Layout.createSequentialGroup()
                .addGroup(phong37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phong37Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel72))
                    .addGroup(phong37Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel73)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tinhtrangp22)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        phong37Layout.setVerticalGroup(
            phong37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong37Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel72)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(phong37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tinhtrangp22, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel73))
                .addGap(30, 30, 30))
        );

        phong38.setBackground(new java.awt.Color(222, 14, 66));
        phong38.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        phong38.setPreferredSize(new java.awt.Dimension(200, 121));
        phong38.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong38MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phong38MousePressed(evt);
            }
        });

        jLabel74.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(255, 255, 255));
        jLabel74.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hotel (7).png"))); // NOI18N
        jLabel74.setText("P2.04");

        tinhtrangp23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tinhtrangp23.setText("tinhtrang1");

        jLabel75.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(255, 255, 255));
        jLabel75.setText("Trạng thái :");

        javax.swing.GroupLayout phong38Layout = new javax.swing.GroupLayout(phong38);
        phong38.setLayout(phong38Layout);
        phong38Layout.setHorizontalGroup(
            phong38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong38Layout.createSequentialGroup()
                .addGroup(phong38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phong38Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel74))
                    .addGroup(phong38Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel75)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tinhtrangp23)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        phong38Layout.setVerticalGroup(
            phong38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong38Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel74)
                .addGap(27, 27, 27)
                .addGroup(phong38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tinhtrangp23, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel75))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        phong39.setBackground(new java.awt.Color(222, 14, 66));
        phong39.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        phong39.setPreferredSize(new java.awt.Dimension(200, 121));
        phong39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phong39MousePressed(evt);
            }
        });

        jLabel76.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(255, 255, 255));
        jLabel76.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hotel (7).png"))); // NOI18N
        jLabel76.setText("P2.03");

        tinhtrangp24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tinhtrangp24.setText("tinhtrang1");

        jLabel77.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(255, 255, 255));
        jLabel77.setText("Trạng thái :");

        javax.swing.GroupLayout phong39Layout = new javax.swing.GroupLayout(phong39);
        phong39.setLayout(phong39Layout);
        phong39Layout.setHorizontalGroup(
            phong39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong39Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel77)
                .addGap(9, 9, 9)
                .addComponent(tinhtrangp24)
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong39Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel76)
                .addGap(59, 59, 59))
        );
        phong39Layout.setVerticalGroup(
            phong39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong39Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel76)
                .addGap(26, 26, 26)
                .addGroup(phong39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tinhtrangp24, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel77))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        phong40.setBackground(new java.awt.Color(222, 14, 66));
        phong40.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        phong40.setPreferredSize(new java.awt.Dimension(200, 121));
        phong40.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong40MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phong40MousePressed(evt);
            }
        });

        jLabel78.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(255, 255, 255));
        jLabel78.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hotel (7).png"))); // NOI18N
        jLabel78.setText("P3.05");

        tinhtrangp25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tinhtrangp25.setText("tinhtrang1");

        jLabel79.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(255, 255, 255));
        jLabel79.setText("Trạng thái :");

        javax.swing.GroupLayout phong40Layout = new javax.swing.GroupLayout(phong40);
        phong40.setLayout(phong40Layout);
        phong40Layout.setHorizontalGroup(
            phong40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong40Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addGroup(phong40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong40Layout.createSequentialGroup()
                        .addComponent(jLabel79)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tinhtrangp25)
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong40Layout.createSequentialGroup()
                        .addComponent(jLabel78)
                        .addGap(61, 61, 61))))
        );
        phong40Layout.setVerticalGroup(
            phong40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong40Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel78)
                .addGap(18, 18, 18)
                .addGroup(phong40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tinhtrangp25, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel79))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        phong41.setBackground(new java.awt.Color(222, 14, 66));
        phong41.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        phong41.setPreferredSize(new java.awt.Dimension(200, 121));
        phong41.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong41MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phong41MousePressed(evt);
            }
        });

        jLabel80.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(255, 255, 255));
        jLabel80.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hotel (7).png"))); // NOI18N
        jLabel80.setText("P3.02");

        tinhtrangp26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tinhtrangp26.setText("tinhtrang1");

        jLabel81.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(255, 255, 255));
        jLabel81.setText("Trạng thái :");

        javax.swing.GroupLayout phong41Layout = new javax.swing.GroupLayout(phong41);
        phong41.setLayout(phong41Layout);
        phong41Layout.setHorizontalGroup(
            phong41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong41Layout.createSequentialGroup()
                .addGroup(phong41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phong41Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel80))
                    .addGroup(phong41Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel81)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tinhtrangp26)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        phong41Layout.setVerticalGroup(
            phong41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong41Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel80)
                .addGap(18, 18, 18)
                .addGroup(phong41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tinhtrangp26, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel81))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        phong42.setBackground(new java.awt.Color(222, 14, 66));
        phong42.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        phong42.setPreferredSize(new java.awt.Dimension(200, 121));
        phong42.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong42MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phong42MousePressed(evt);
            }
        });

        jLabel82.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(255, 255, 255));
        jLabel82.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hotel (7).png"))); // NOI18N
        jLabel82.setText("P3.04");

        tinhtrangp27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tinhtrangp27.setText("tinhtrang1");

        jLabel83.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(255, 255, 255));
        jLabel83.setText("Trạng thái :");

        javax.swing.GroupLayout phong42Layout = new javax.swing.GroupLayout(phong42);
        phong42.setLayout(phong42Layout);
        phong42Layout.setHorizontalGroup(
            phong42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong42Layout.createSequentialGroup()
                .addGroup(phong42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phong42Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel83)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tinhtrangp27))
                    .addGroup(phong42Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel82)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        phong42Layout.setVerticalGroup(
            phong42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong42Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel82)
                .addGap(18, 18, 18)
                .addGroup(phong42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tinhtrangp27, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel83))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        phong43.setBackground(new java.awt.Color(222, 14, 66));
        phong43.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        phong43.setPreferredSize(new java.awt.Dimension(200, 121));
        phong43.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong43MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phong43MousePressed(evt);
            }
        });

        jLabel84.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(255, 255, 255));
        jLabel84.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hotel (7).png"))); // NOI18N
        jLabel84.setText("P3.03");

        tinhtrangp28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tinhtrangp28.setText("tinhtrang1");

        jLabel85.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(255, 255, 255));
        jLabel85.setText("Trạng thái :");

        javax.swing.GroupLayout phong43Layout = new javax.swing.GroupLayout(phong43);
        phong43.setLayout(phong43Layout);
        phong43Layout.setHorizontalGroup(
            phong43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong43Layout.createSequentialGroup()
                .addGroup(phong43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phong43Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel84))
                    .addGroup(phong43Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel85)
                        .addGap(9, 9, 9)
                        .addComponent(tinhtrangp28, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        phong43Layout.setVerticalGroup(
            phong43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong43Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel84)
                .addGap(18, 18, 18)
                .addGroup(phong43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tinhtrangp28, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel85))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        panel7.setBackground(new java.awt.Color(51, 51, 51));
        panel7.setPreferredSize(new java.awt.Dimension(100, 121));

        jLabel86.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(255, 255, 255));
        jLabel86.setText("Tầng 3");

        javax.swing.GroupLayout panel7Layout = new javax.swing.GroupLayout(panel7);
        panel7.setLayout(panel7Layout);
        panel7Layout.setHorizontalGroup(
            panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel7Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel86)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        panel7Layout.setVerticalGroup(
            panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel7Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel86)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel8.setBackground(new java.awt.Color(51, 51, 51));

        label5.setText("label1");

        label6.setText("label2");

        jLabel87.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(255, 255, 255));
        jLabel87.setText("Tầng 1");

        javax.swing.GroupLayout panel8Layout = new javax.swing.GroupLayout(panel8);
        panel8.setLayout(panel8Layout);
        panel8Layout.setHorizontalGroup(
            panel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel8Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel87)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        panel8Layout.setVerticalGroup(
            panel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel8Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel87)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        panel9.setBackground(new java.awt.Color(51, 51, 51));

        jLabel88.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(255, 255, 255));
        jLabel88.setText("Tầng 2");

        javax.swing.GroupLayout panel9Layout = new javax.swing.GroupLayout(panel9);
        panel9.setLayout(panel9Layout);
        panel9Layout.setHorizontalGroup(
            panel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel9Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel88)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        panel9Layout.setVerticalGroup(
            panel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel9Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel88)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        phong44.setBackground(new java.awt.Color(14, 74, 82));
        phong44.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        phong44.setPreferredSize(new java.awt.Dimension(200, 121));
        phong44.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong44MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phong44MousePressed(evt);
            }
        });

        jLabel89.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel89.setForeground(new java.awt.Color(255, 255, 255));
        jLabel89.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hotel (7).png"))); // NOI18N
        jLabel89.setText("P1.03");

        tinhtrangp29.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tinhtrangp29.setText("tinhtrang1");

        jLabel90.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel90.setForeground(new java.awt.Color(255, 255, 255));
        jLabel90.setText("Trạng thái :");

        javax.swing.GroupLayout phong44Layout = new javax.swing.GroupLayout(phong44);
        phong44.setLayout(phong44Layout);
        phong44Layout.setHorizontalGroup(
            phong44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong44Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel90)
                .addGap(9, 9, 9)
                .addComponent(tinhtrangp29, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong44Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel89)
                .addGap(58, 58, 58))
        );
        phong44Layout.setVerticalGroup(
            phong44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong44Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel89)
                .addGap(28, 28, 28)
                .addGroup(phong44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tinhtrangp29, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel90))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        phong45.setBackground(new java.awt.Color(222, 14, 66));
        phong45.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        phong45.setPreferredSize(new java.awt.Dimension(200, 121));
        phong45.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong45MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phong45MousePressed(evt);
            }
        });

        jLabel91.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel91.setForeground(new java.awt.Color(255, 255, 255));
        jLabel91.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hotel (7).png"))); // NOI18N
        jLabel91.setText("P3.01");

        tinhtrangp30.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tinhtrangp30.setText("tinhtrang1");

        jLabel92.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel92.setForeground(new java.awt.Color(255, 255, 255));
        jLabel92.setText("Trạng thái :");

        javax.swing.GroupLayout phong45Layout = new javax.swing.GroupLayout(phong45);
        phong45.setLayout(phong45Layout);
        phong45Layout.setHorizontalGroup(
            phong45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong45Layout.createSequentialGroup()
                .addGroup(phong45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phong45Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel91))
                    .addGroup(phong45Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel92)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tinhtrangp30)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        phong45Layout.setVerticalGroup(
            phong45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong45Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel91)
                .addGap(18, 18, 18)
                .addGroup(phong45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tinhtrangp30, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel92))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(phong37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(phong32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(phong31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phong33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(phong45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phong41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(phong44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phong36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(phong39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phong38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(phong43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phong42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phong34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phong35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phong40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(panel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(panel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(phong44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phong36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phong35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(phong34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phong39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phong38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(phong31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phong32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(phong37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phong33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(2, 2, 2)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(phong45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phong41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phong43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phong42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phong40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(83, 83, 83))
        );

        jPanel6.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 1170, 400));

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ghi chú trạng thái phòng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        trangthai2.setBackground(new java.awt.Color(0, 0, 51));
        trangthai2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        trangthai2.setPreferredSize(new java.awt.Dimension(153, 54));
        trangthai2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                trangthai2MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                trangthai2MousePressed(evt);
            }
        });

        jLabel93.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel93.setForeground(new java.awt.Color(255, 255, 255));
        jLabel93.setText("Sẵn Sàng");

        javax.swing.GroupLayout trangthai2Layout = new javax.swing.GroupLayout(trangthai2);
        trangthai2.setLayout(trangthai2Layout);
        trangthai2Layout.setHorizontalGroup(
            trangthai2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(trangthai2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel93)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        trangthai2Layout.setVerticalGroup(
            trangthai2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trangthai2Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel93)
                .addGap(14, 14, 14))
        );

        trangthai6.setBackground(new java.awt.Color(0, 0, 0));
        trangthai6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        trangthai6.setPreferredSize(new java.awt.Dimension(153, 54));
        trangthai6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                trangthai6MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                trangthai6MousePressed(evt);
            }
        });

        jLabel94.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel94.setForeground(new java.awt.Color(255, 255, 255));
        jLabel94.setText("Có Khách");

        javax.swing.GroupLayout trangthai6Layout = new javax.swing.GroupLayout(trangthai6);
        trangthai6.setLayout(trangthai6Layout);
        trangthai6Layout.setHorizontalGroup(
            trangthai6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(trangthai6Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel94)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        trangthai6Layout.setVerticalGroup(
            trangthai6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(trangthai6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel94)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        trangthai7.setBackground(new java.awt.Color(14, 74, 82));
        trangthai7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        trangthai7.setPreferredSize(new java.awt.Dimension(153, 54));
        trangthai7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                trangthai7MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                trangthai7MousePressed(evt);
            }
        });

        jLabel95.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel95.setForeground(new java.awt.Color(255, 255, 255));
        jLabel95.setText(" Đang Dọn");

        javax.swing.GroupLayout trangthai7Layout = new javax.swing.GroupLayout(trangthai7);
        trangthai7.setLayout(trangthai7Layout);
        trangthai7Layout.setHorizontalGroup(
            trangthai7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(trangthai7Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel95)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        trangthai7Layout.setVerticalGroup(
            trangthai7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(trangthai7Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel95)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        trangthai8.setBackground(new java.awt.Color(51, 0, 0));
        trangthai8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        trangthai8.setPreferredSize(new java.awt.Dimension(153, 54));
        trangthai8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                trangthai8MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                trangthai8MousePressed(evt);
            }
        });

        jLabel96.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel96.setForeground(new java.awt.Color(255, 255, 255));
        jLabel96.setText("Đang Sửa");

        javax.swing.GroupLayout trangthai8Layout = new javax.swing.GroupLayout(trangthai8);
        trangthai8.setLayout(trangthai8Layout);
        trangthai8Layout.setHorizontalGroup(
            trangthai8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(trangthai8Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel96)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        trangthai8Layout.setVerticalGroup(
            trangthai8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(trangthai8Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel96)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(trangthai2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(trangthai8, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(trangthai6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(trangthai7, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(trangthai8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(trangthai2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(trangthai7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(trangthai6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, 670, 90));

        jLabel97.setBackground(new java.awt.Color(153, 0, 51));
        jLabel97.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel97.setForeground(new java.awt.Color(0, 0, 0));
        jLabel97.setText("Danh Sách Phiếu Thuê Phòng");
        jPanel6.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 590, 340, -1));

        tblPhieuThuePhong1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã phiếu thuê", "Nhân viên thực hiện ", "Thời gian tạo phiếu", "Tên khách hàng", "Phòng thực hiện "
            }
        ));
        jScrollPane5.setViewportView(tblPhieuThuePhong1);

        jPanel6.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 620, 590, 210));

        jInternalFrame3.setBorder(null);
        jInternalFrame3.setPreferredSize(new java.awt.Dimension(1700, 1200));
        jInternalFrame3.setRequestFocusEnabled(false);
        try {
            jInternalFrame3.setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }

        jPanel9.setBackground(new java.awt.Color(0, 255, 204));
        jPanel9.setForeground(new java.awt.Color(204, 204, 204));
        jPanel9.setPreferredSize(new java.awt.Dimension(1180, 750));
        jPanel9.setVerifyInputWhenFocusTarget(false);
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel98.setBackground(new java.awt.Color(204, 255, 204));
        jLabel98.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(255, 0, 102));
        jLabel98.setText("SƠ ĐỒ QUẢN LÍ PHÒNG");
        jPanel9.add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, -1, 59));

        tblDuLieuPhong3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã phòng", "Tiền dịch vụ", "Loại phòng", "Nhân viên thực hiện ", "Thời gian vào nhận phòng", "Số người", "CCCD/CMND", "Trạng thái", "Tên khách hàng"
            }
        ));
        jScrollPane6.setViewportView(tblDuLieuPhong3);

        jPanel9.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 620, 1270, 220));

        jLabel99.setBackground(new java.awt.Color(153, 0, 51));
        jLabel99.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel99.setForeground(new java.awt.Color(222, 14, 66));
        jLabel99.setText("Danh Sách Phiếu Thuê");
        jPanel9.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 580, -1, -1));

        jToolBar5.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar5.setBorder(javax.swing.BorderFactory.createTitledBorder("Chức năng"));
        jToolBar5.setRollover(true);

        btnDetailPhong2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/eye.png"))); // NOI18N
        btnDetailPhong2.setText("Xem chi tiết");
        btnDetailPhong2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDetailPhong2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDetailPhong2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDetailPhong2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailPhong2ActionPerformed(evt);
            }
        });
        jToolBar5.add(btnDetailPhong2);

        btnChuyenPhong3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/transfer.png"))); // NOI18N
        btnChuyenPhong3.setText("Chuyển phòng");
        btnChuyenPhong3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnChuyenPhong3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnChuyenPhong3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnChuyenPhong3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChuyenPhong3ActionPerformed(evt);
            }
        });
        jToolBar5.add(btnChuyenPhong3);

        btnTraPhong3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logout (1).png"))); // NOI18N
        btnTraPhong3.setText("Trả Phong");
        btnTraPhong3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTraPhong3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTraPhong3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnTraPhong3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraPhong3ActionPerformed(evt);
            }
        });
        jToolBar5.add(btnTraPhong3);

        btnChuyenTrangThai7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/exchange.png"))); // NOI18N
        btnChuyenTrangThai7.setText("Trạng thái phòng sẵn");
        btnChuyenTrangThai7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnChuyenTrangThai7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnChuyenTrangThai7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnChuyenTrangThai7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChuyenTrangThai7ActionPerformed(evt);
            }
        });
        jToolBar5.add(btnChuyenTrangThai7);

        btnEditPhong3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/edit.png"))); // NOI18N
        btnEditPhong3.setText("Sửa");
        btnEditPhong3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditPhong3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditPhong3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEditPhong3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditPhong3ActionPerformed(evt);
            }
        });
        jToolBar5.add(btnEditPhong3);

        jPanel9.add(jToolBar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 400, 90));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "huhu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        phong46.setBackground(new java.awt.Color(222, 14, 66));
        phong46.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        phong46.setPreferredSize(new java.awt.Dimension(200, 121));
        phong46.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong46MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phong46MousePressed(evt);
            }
        });

        jLabel100.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel100.setForeground(new java.awt.Color(255, 255, 255));
        jLabel100.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hotel (7).png"))); // NOI18N
        jLabel100.setText("P1.02");

        javax.swing.GroupLayout phong46Layout = new javax.swing.GroupLayout(phong46);
        phong46.setLayout(phong46Layout);
        phong46Layout.setHorizontalGroup(
            phong46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong46Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel100)
                .addContainerGap(77, Short.MAX_VALUE))
        );
        phong46Layout.setVerticalGroup(
            phong46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong46Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel100)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        phong47.setBackground(new java.awt.Color(222, 14, 66));
        phong47.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        phong47.setPreferredSize(new java.awt.Dimension(200, 121));
        phong47.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong47MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phong47MousePressed(evt);
            }
        });

        jLabel101.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel101.setForeground(new java.awt.Color(255, 255, 255));
        jLabel101.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hotel (7).png"))); // NOI18N
        jLabel101.setText("P1.01");
        jLabel101.setPreferredSize(new java.awt.Dimension(75, 25));

        javax.swing.GroupLayout phong47Layout = new javax.swing.GroupLayout(phong47);
        phong47.setLayout(phong47Layout);
        phong47Layout.setHorizontalGroup(
            phong47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong47Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel101, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );
        phong47Layout.setVerticalGroup(
            phong47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong47Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel101, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );

        phong48.setBackground(new java.awt.Color(222, 14, 66));
        phong48.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        phong48.setPreferredSize(new java.awt.Dimension(200, 121));
        phong48.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong48MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phong48MousePressed(evt);
            }
        });

        jLabel102.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel102.setForeground(new java.awt.Color(255, 255, 255));
        jLabel102.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hotel (7).png"))); // NOI18N
        jLabel102.setText("P2.02");

        javax.swing.GroupLayout phong48Layout = new javax.swing.GroupLayout(phong48);
        phong48.setLayout(phong48Layout);
        phong48Layout.setHorizontalGroup(
            phong48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong48Layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(jLabel102)
                .addGap(60, 60, 60))
        );
        phong48Layout.setVerticalGroup(
            phong48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong48Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel102)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        phong49.setBackground(new java.awt.Color(222, 14, 66));
        phong49.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        phong49.setPreferredSize(new java.awt.Dimension(200, 121));
        phong49.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong49MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phong49MousePressed(evt);
            }
        });

        jLabel103.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel103.setForeground(new java.awt.Color(255, 255, 255));
        jLabel103.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hotel (7).png"))); // NOI18N
        jLabel103.setText("P2.05");

        javax.swing.GroupLayout phong49Layout = new javax.swing.GroupLayout(phong49);
        phong49.setLayout(phong49Layout);
        phong49Layout.setHorizontalGroup(
            phong49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong49Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel103)
                .addContainerGap(71, Short.MAX_VALUE))
        );
        phong49Layout.setVerticalGroup(
            phong49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong49Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel103)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        phong50.setBackground(new java.awt.Color(222, 14, 66));
        phong50.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        phong50.setPreferredSize(new java.awt.Dimension(200, 121));
        phong50.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong50MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phong50MousePressed(evt);
            }
        });

        jLabel104.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel104.setForeground(new java.awt.Color(255, 255, 255));
        jLabel104.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hotel (7).png"))); // NOI18N
        jLabel104.setText("P1.05");

        javax.swing.GroupLayout phong50Layout = new javax.swing.GroupLayout(phong50);
        phong50.setLayout(phong50Layout);
        phong50Layout.setHorizontalGroup(
            phong50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong50Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel104)
                .addContainerGap(73, Short.MAX_VALUE))
        );
        phong50Layout.setVerticalGroup(
            phong50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong50Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel104)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        phong51.setBackground(new java.awt.Color(222, 14, 66));
        phong51.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        phong51.setPreferredSize(new java.awt.Dimension(200, 121));
        phong51.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong51MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phong51MousePressed(evt);
            }
        });

        jLabel105.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel105.setForeground(new java.awt.Color(255, 255, 255));
        jLabel105.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hotel (7).png"))); // NOI18N
        jLabel105.setText("P1.04");

        javax.swing.GroupLayout phong51Layout = new javax.swing.GroupLayout(phong51);
        phong51.setLayout(phong51Layout);
        phong51Layout.setHorizontalGroup(
            phong51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong51Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel105)
                .addContainerGap(71, Short.MAX_VALUE))
        );
        phong51Layout.setVerticalGroup(
            phong51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong51Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel105)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        phong52.setBackground(new java.awt.Color(222, 14, 66));
        phong52.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        phong52.setPreferredSize(new java.awt.Dimension(200, 121));
        phong52.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong52MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phong52MousePressed(evt);
            }
        });

        jLabel106.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel106.setForeground(new java.awt.Color(255, 255, 255));
        jLabel106.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hotel (7).png"))); // NOI18N
        jLabel106.setText("P2.01");

        javax.swing.GroupLayout phong52Layout = new javax.swing.GroupLayout(phong52);
        phong52.setLayout(phong52Layout);
        phong52Layout.setHorizontalGroup(
            phong52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong52Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel106)
                .addGap(59, 59, 59))
        );
        phong52Layout.setVerticalGroup(
            phong52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong52Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel106)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        phong53.setBackground(new java.awt.Color(222, 14, 66));
        phong53.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        phong53.setPreferredSize(new java.awt.Dimension(200, 121));
        phong53.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong53MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phong53MousePressed(evt);
            }
        });

        jLabel107.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel107.setForeground(new java.awt.Color(255, 255, 255));
        jLabel107.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hotel (7).png"))); // NOI18N
        jLabel107.setText("P2.04");

        javax.swing.GroupLayout phong53Layout = new javax.swing.GroupLayout(phong53);
        phong53.setLayout(phong53Layout);
        phong53Layout.setHorizontalGroup(
            phong53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong53Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel107)
                .addContainerGap(66, Short.MAX_VALUE))
        );
        phong53Layout.setVerticalGroup(
            phong53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong53Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel107)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        phong54.setBackground(new java.awt.Color(222, 14, 66));
        phong54.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        phong54.setPreferredSize(new java.awt.Dimension(200, 121));
        phong54.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong54MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phong54MousePressed(evt);
            }
        });

        jLabel108.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel108.setForeground(new java.awt.Color(255, 255, 255));
        jLabel108.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hotel (7).png"))); // NOI18N
        jLabel108.setText("P2.03");

        javax.swing.GroupLayout phong54Layout = new javax.swing.GroupLayout(phong54);
        phong54.setLayout(phong54Layout);
        phong54Layout.setHorizontalGroup(
            phong54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong54Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel108)
                .addContainerGap(68, Short.MAX_VALUE))
        );
        phong54Layout.setVerticalGroup(
            phong54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong54Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel108)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        phong55.setBackground(new java.awt.Color(222, 14, 66));
        phong55.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        phong55.setPreferredSize(new java.awt.Dimension(200, 121));
        phong55.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong55MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phong55MousePressed(evt);
            }
        });

        jLabel109.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel109.setForeground(new java.awt.Color(255, 255, 255));
        jLabel109.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hotel (7).png"))); // NOI18N
        jLabel109.setText("P3.05");

        javax.swing.GroupLayout phong55Layout = new javax.swing.GroupLayout(phong55);
        phong55.setLayout(phong55Layout);
        phong55Layout.setHorizontalGroup(
            phong55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong55Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel109)
                .addContainerGap(68, Short.MAX_VALUE))
        );
        phong55Layout.setVerticalGroup(
            phong55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong55Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel109)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        phong56.setBackground(new java.awt.Color(222, 14, 66));
        phong56.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        phong56.setPreferredSize(new java.awt.Dimension(200, 121));
        phong56.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong56MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phong56MousePressed(evt);
            }
        });

        jLabel110.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel110.setForeground(new java.awt.Color(255, 255, 255));
        jLabel110.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hotel (7).png"))); // NOI18N
        jLabel110.setText("P3.02");

        javax.swing.GroupLayout phong56Layout = new javax.swing.GroupLayout(phong56);
        phong56.setLayout(phong56Layout);
        phong56Layout.setHorizontalGroup(
            phong56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong56Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel110)
                .addContainerGap(62, Short.MAX_VALUE))
        );
        phong56Layout.setVerticalGroup(
            phong56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong56Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel110)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        phong57.setBackground(new java.awt.Color(222, 14, 66));
        phong57.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        phong57.setPreferredSize(new java.awt.Dimension(200, 121));
        phong57.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong57MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phong57MousePressed(evt);
            }
        });

        jLabel111.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel111.setForeground(new java.awt.Color(255, 255, 255));
        jLabel111.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hotel (7).png"))); // NOI18N
        jLabel111.setText("P3.04");

        javax.swing.GroupLayout phong57Layout = new javax.swing.GroupLayout(phong57);
        phong57.setLayout(phong57Layout);
        phong57Layout.setHorizontalGroup(
            phong57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong57Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel111)
                .addContainerGap(64, Short.MAX_VALUE))
        );
        phong57Layout.setVerticalGroup(
            phong57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong57Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel111)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        phong58.setBackground(new java.awt.Color(222, 14, 66));
        phong58.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        phong58.setPreferredSize(new java.awt.Dimension(200, 121));
        phong58.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong58MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phong58MousePressed(evt);
            }
        });

        jLabel112.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel112.setForeground(new java.awt.Color(255, 255, 255));
        jLabel112.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hotel (7).png"))); // NOI18N
        jLabel112.setText("P3.01");

        javax.swing.GroupLayout phong58Layout = new javax.swing.GroupLayout(phong58);
        phong58.setLayout(phong58Layout);
        phong58Layout.setHorizontalGroup(
            phong58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong58Layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(jLabel112)
                .addGap(60, 60, 60))
        );
        phong58Layout.setVerticalGroup(
            phong58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong58Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel112)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        phong59.setBackground(new java.awt.Color(222, 14, 66));
        phong59.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        phong59.setPreferredSize(new java.awt.Dimension(200, 121));
        phong59.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong59MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phong59MousePressed(evt);
            }
        });

        jLabel113.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel113.setForeground(new java.awt.Color(255, 255, 255));
        jLabel113.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hotel (7).png"))); // NOI18N
        jLabel113.setText("P3.03");

        javax.swing.GroupLayout phong59Layout = new javax.swing.GroupLayout(phong59);
        phong59.setLayout(phong59Layout);
        phong59Layout.setHorizontalGroup(
            phong59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong59Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel113)
                .addContainerGap(66, Short.MAX_VALUE))
        );
        phong59Layout.setVerticalGroup(
            phong59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong59Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel113)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        panel10.setBackground(new java.awt.Color(153, 153, 153));
        panel10.setPreferredSize(new java.awt.Dimension(100, 121));

        javax.swing.GroupLayout panel10Layout = new javax.swing.GroupLayout(panel10);
        panel10.setLayout(panel10Layout);
        panel10Layout.setHorizontalGroup(
            panel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        panel10Layout.setVerticalGroup(
            panel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panel11.setBackground(new java.awt.Color(153, 153, 153));

        label7.setText("label1");

        label8.setText("label2");

        javax.swing.GroupLayout panel11Layout = new javax.swing.GroupLayout(panel11);
        panel11.setLayout(panel11Layout);
        panel11Layout.setHorizontalGroup(
            panel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        panel11Layout.setVerticalGroup(
            panel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 121, Short.MAX_VALUE)
        );

        panel12.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout panel12Layout = new javax.swing.GroupLayout(panel12);
        panel12.setLayout(panel12Layout);
        panel12Layout.setHorizontalGroup(
            panel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        panel12Layout.setVerticalGroup(
            panel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 121, Short.MAX_VALUE)
        );

        phong60.setBackground(new java.awt.Color(222, 14, 66));
        phong60.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        phong60.setPreferredSize(new java.awt.Dimension(200, 121));
        phong60.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong60MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phong60MousePressed(evt);
            }
        });

        jLabel114.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel114.setForeground(new java.awt.Color(255, 255, 255));
        jLabel114.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hotel (7).png"))); // NOI18N
        jLabel114.setText("P1.03");

        javax.swing.GroupLayout phong60Layout = new javax.swing.GroupLayout(phong60);
        phong60.setLayout(phong60Layout);
        phong60Layout.setHorizontalGroup(
            phong60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong60Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel114)
                .addContainerGap(68, Short.MAX_VALUE))
        );
        phong60Layout.setVerticalGroup(
            phong60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong60Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel114)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(phong52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(phong47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(phong46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phong48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(phong58, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phong56, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(phong60, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phong51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(phong54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phong53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(phong59, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phong57, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phong49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phong50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phong55, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(116, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(panel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(panel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(phong58, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(phong56, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(phong59, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(phong57, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(phong55, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(83, 83, 83))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(phong60, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(phong51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(phong50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(2, 2, 2)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(phong49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(phong54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(phong53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(phong46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(phong47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(2, 2, 2)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(phong52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(phong48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel9.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 1270, 400));

        javax.swing.GroupLayout jInternalFrame3Layout = new javax.swing.GroupLayout(jInternalFrame3.getContentPane());
        jInternalFrame3.getContentPane().setLayout(jInternalFrame3Layout);
        jInternalFrame3Layout.setHorizontalGroup(
            jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 1380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jInternalFrame3Layout.setVerticalGroup(
            jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 859, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jInternalFrame2Layout = new javax.swing.GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jInternalFrame2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jInternalFrame3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jInternalFrame2Layout.setVerticalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jInternalFrame2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jInternalFrame3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(314, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jInternalFrame2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jInternalFrame2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void phong2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong2MouseClicked


    }//GEN-LAST:event_phong2MouseClicked

    private void phong2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong2MousePressed
    String maPhong = "P1.02"; // Mã phòng bạn muốn kiểm tra
    String trangThaiPhong = getTrangThaiPhongFromDatabase(maPhong); // Lấy trạng thái của phòng từ cơ sở dữ liệu
    if (trangThaiPhong != null) { // Kiểm tra xem trạng thái có tồn tại không
        switch (trangThaiPhong) {
              case "Sẵn Sàng":
                int choice = JOptionPane.showConfirmDialog(null, "Bạn có muốn đặt phòng?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    createDatPhongWindow(maPhong, "Phòng Đơn");
                } else {
                    // Không làm gì cả
                }
                break;
                case "Đang Dọn":
                JOptionPane.showMessageDialog(null, "Phòng đang dọn, vui lòng chọn phòng khác");
                break;
                case "Đang Sửa":
                JOptionPane.showMessageDialog(null, "Phòng đang sửa, vui lòng chọn phòng khác");
                break;
                case "Có Khách":
                JOptionPane.showMessageDialog(null, "Phòng đã có người thuê, vui lòng chọn phòng khác");
                break;
                default:
                JOptionPane.showMessageDialog(null, "Trạng thái phòng không hợp lệ");
                break;
        }
    } else {
        JOptionPane.showMessageDialog(null, "Không thể truy cập trạng thái của phòng"); // Hiển thị thông báo nếu không thể truy cập trạng thái của phòng
    }
    }//GEN-LAST:event_phong2MousePressed

    private void phong1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong1MouseClicked

    }//GEN-LAST:event_phong1MouseClicked

    private void phong1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong1MousePressed
     String maPhong = "P1.01"; // Mã phòng bạn muốn kiểm tra
    String trangThaiPhong = getTrangThaiPhongFromDatabase(maPhong); // Lấy trạng thái của phòng từ cơ sở dữ liệu
    if (trangThaiPhong != null) { // Kiểm tra xem trạng thái có tồn tại không
        switch (trangThaiPhong) {
              case "Sẵn Sàng":
                int choice = JOptionPane.showConfirmDialog(null, "Bạn có muốn đặt phòng?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    createDatPhongWindow(maPhong, "Phòng Đơn");
                } else {
                    // Không làm gì cả
                }
                break;
                case "Đang Dọn":
                JOptionPane.showMessageDialog(null, "Phòng đang dọn, vui lòng chọn phòng khác");
                break;
                case "Đang Sửa":
                JOptionPane.showMessageDialog(null, "Phòng đang sửa, vui lòng chọn phòng khác");
                break;
                case "Có Khách":
                JOptionPane.showMessageDialog(null, "Phòng đã có người thuê, vui lòng chọn phòng khác");
                break;
                default:
                JOptionPane.showMessageDialog(null, "Trạng thái phòng không hợp lệ");
                break;
        }
    } else {
        JOptionPane.showMessageDialog(null, "Không thể truy cập trạng thái của phòng"); // Hiển thị thông báo nếu không thể truy cập trạng thái của phòng
    }

    }//GEN-LAST:event_phong1MousePressed
    private void phong1ActionPerformed(java.awt.event.ActionEvent evt) {

    }


    private void phong3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong3MouseClicked

    }//GEN-LAST:event_phong3MouseClicked

    private void phong3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong3MousePressed
      String maPhong = "P1.03"; // Mã phòng bạn muốn kiểm tra
    String trangThaiPhong = getTrangThaiPhongFromDatabase(maPhong); // Lấy trạng thái của phòng từ cơ sở dữ liệu
    if (trangThaiPhong != null) { // Kiểm tra xem trạng thái có tồn tại không
        switch (trangThaiPhong) {
             case "Sẵn Sàng":
                int choice = JOptionPane.showConfirmDialog(null, "Bạn có muốn đặt phòng?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    createDatPhongWindow(maPhong, "Phòng Đơn");
                } else {
                    // Không làm gì cả
                }
                break;
                case "Đang Dọn":
                JOptionPane.showMessageDialog(null, "Phòng đang dọn, vui lòng chọn phòng khác");
                break;
                case "Đang Sửa":
                JOptionPane.showMessageDialog(null, "Phòng đang sửa, vui lòng chọn phòng khác");
                break;
                case "Có Khách":
                JOptionPane.showMessageDialog(null, "Phòng đã có người thuê, vui lòng chọn phòng khác");
                break;
                default:
                JOptionPane.showMessageDialog(null, "Trạng thái phòng không hợp lệ");
                break;
        }
    } else {
        JOptionPane.showMessageDialog(null, "Không thể truy cập trạng thái của phòng"); // Hiển thị thông báo nếu không thể truy cập trạng thái của phòng
    }
    }//GEN-LAST:event_phong3MousePressed

    private void phong7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong7MouseClicked

    }//GEN-LAST:event_phong7MouseClicked

    private void phong7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong7MousePressed
      String maPhong = "P2.02"; // Mã phòng bạn muốn kiểm tra
    String trangThaiPhong = getTrangThaiPhongFromDatabase(maPhong); // Lấy trạng thái của phòng từ cơ sở dữ liệu
    if (trangThaiPhong != null) { // Kiểm tra xem trạng thái có tồn tại không
        switch (trangThaiPhong) {
             case "Sẵn Sàng":
                int choice = JOptionPane.showConfirmDialog(null, "Bạn có muốn đặt phòng?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    createDatPhongWindow(maPhong, "Phòng Đôi");
                } else {
                    // Không làm gì cả
                }
                break;
                case "Đang Dọn":
                JOptionPane.showMessageDialog(null, "Phòng đang dọn, vui lòng chọn phòng khác");
                break;
                case "Đang Sửa":
                JOptionPane.showMessageDialog(null, "Phòng đang sửa, vui lòng chọn phòng khác");
                break;
                case "Có Khách":
                JOptionPane.showMessageDialog(null, "Phòng đã có người thuê, vui lòng chọn phòng khác");
                break;
                default:
                JOptionPane.showMessageDialog(null, "Trạng thái phòng không hợp lệ");
                break;
        }
    } else {
        JOptionPane.showMessageDialog(null, "Không thể truy cập trạng thái của phòng"); // Hiển thị thông báo nếu không thể truy cập trạng thái của phòng
    }
    }//GEN-LAST:event_phong7MousePressed


    private void phong6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong6MouseClicked

    }//GEN-LAST:event_phong6MouseClicked

    private void phong6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong6MousePressed
    String maPhong = "P2.01"; // Mã phòng bạn muốn kiểm tra
    String trangThaiPhong = getTrangThaiPhongFromDatabase(maPhong); // Lấy trạng thái của phòng từ cơ sở dữ liệu
    if (trangThaiPhong != null) { // Kiểm tra xem trạng thái có tồn tại không
        switch (trangThaiPhong) {
              case "Sẵn Sàng":
                int choice = JOptionPane.showConfirmDialog(null, "Bạn có muốn đặt phòng?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    createDatPhongWindow(maPhong, "Phòng Đôi");
                } else {
                    // Không làm gì cả
                }
                break;
                case "Đang Dọn":
                JOptionPane.showMessageDialog(null, "Phòng đang dọn, vui lòng chọn phòng khác");
                break;
                case "Đang Sửa":
                JOptionPane.showMessageDialog(null, "Phòng đang sửa, vui lòng chọn phòng khác");
                break;
                case "Có Khách":
                JOptionPane.showMessageDialog(null, "Phòng đã có người thuê, vui lòng chọn phòng khác");
                break;
                default:
                JOptionPane.showMessageDialog(null, "Trạng thái phòng không hợp lệ");
                break;
        }
    } else {
        JOptionPane.showMessageDialog(null, "Không thể truy cập trạng thái của phòng"); // Hiển thị thông báo nếu không thể truy cập trạng thái của phòng
    }
    }//GEN-LAST:event_phong6MousePressed

    private void phong5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong5MouseClicked

    }//GEN-LAST:event_phong5MouseClicked

    private void phong5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong5MousePressed
    String maPhong = "P1.05"; // Mã phòng bạn muốn kiểm tra
    String trangThaiPhong = getTrangThaiPhongFromDatabase(maPhong); // Lấy trạng thái của phòng từ cơ sở dữ liệu
    if (trangThaiPhong != null) { // Kiểm tra xem trạng thái có tồn tại không
        switch (trangThaiPhong) {
             case "Sẵn Sàng":
                int choice = JOptionPane.showConfirmDialog(null, "Bạn có muốn đặt phòng?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    createDatPhongWindow(maPhong, "Phòng Đơn");
                } else {
                    // Không làm gì cả
                }
                break;
                case "Đang Dọn":
                JOptionPane.showMessageDialog(null, "Phòng đang dọn, vui lòng chọn phòng khác");
                break;
                case "Đang Sửa":
                JOptionPane.showMessageDialog(null, "Phòng đang sửa, vui lòng chọn phòng khác");
                break;
                case "Có Khách":
                JOptionPane.showMessageDialog(null, "Phòng đã có người thuê, vui lòng chọn phòng khác");
                break;
                default:
                JOptionPane.showMessageDialog(null, "Trạng thái phòng không hợp lệ");
                break;
        }
    } else {
        JOptionPane.showMessageDialog(null, "Không thể truy cập trạng thái của phòng"); // Hiển thị thông báo nếu không thể truy cập trạng thái của phòng
    }
    }//GEN-LAST:event_phong5MousePressed

    private void phong4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong4MouseClicked

    }//GEN-LAST:event_phong4MouseClicked

    private void phong4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong4MousePressed
      String maPhong = "P1.04"; // Mã phòng bạn muốn kiểm tra
    String trangThaiPhong = getTrangThaiPhongFromDatabase(maPhong); // Lấy trạng thái của phòng từ cơ sở dữ liệu
    if (trangThaiPhong != null) { // Kiểm tra xem trạng thái có tồn tại không
        switch (trangThaiPhong) {
              case "Sẵn Sàng":
                int choice = JOptionPane.showConfirmDialog(null, "Bạn có muốn đặt phòng?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    createDatPhongWindow(maPhong, "Phòng Đơn");
                } else {
                    // Không làm gì cả
                }
                break;
                case "Đang Dọn":
                JOptionPane.showMessageDialog(null, "Phòng đang dọn, vui lòng chọn phòng khác");
                break;
                case "Đang Sửa":
                JOptionPane.showMessageDialog(null, "Phòng đang sửa, vui lòng chọn phòng khác");
                break;
                case "Có Khách":
                JOptionPane.showMessageDialog(null, "Phòng đã có người thuê, vui lòng chọn phòng khác");
                break;
                default:
                JOptionPane.showMessageDialog(null, "Trạng thái phòng không hợp lệ");
                break;
        }
    } else {
        JOptionPane.showMessageDialog(null, "Không thể truy cập trạng thái của phòng"); // Hiển thị thông báo nếu không thể truy cập trạng thái của phòng
    }
    }//GEN-LAST:event_phong4MousePressed

    private void phong9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong9MouseClicked

    }//GEN-LAST:event_phong9MouseClicked

    private void phong9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong9MousePressed
     String maPhong = "P2.04"; // Mã phòng bạn muốn kiểm tra
    String trangThaiPhong = getTrangThaiPhongFromDatabase(maPhong); // Lấy trạng thái của phòng từ cơ sở dữ liệu
    if (trangThaiPhong != null) { // Kiểm tra xem trạng thái có tồn tại không
        switch (trangThaiPhong) {
              case "Sẵn Sàng":
                int choice = JOptionPane.showConfirmDialog(null, "Bạn có muốn đặt phòng?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    createDatPhongWindow(maPhong, "Phòng Đôi");
                } else {
                    // Không làm gì cả
                }
                break;
                case "Đang Dọn":
                JOptionPane.showMessageDialog(null, "Phòng đang dọn, vui lòng chọn phòng khác");
                break;
                case "Đang Sửa":
                JOptionPane.showMessageDialog(null, "Phòng đang sửa, vui lòng chọn phòng khác");
                break;
                case "Có Khách":
                JOptionPane.showMessageDialog(null, "Phòng đã có người thuê, vui lòng chọn phòng khác");
                break;
                default:
                JOptionPane.showMessageDialog(null, "Trạng thái phòng không hợp lệ");
                break;
        }
    } else {
        JOptionPane.showMessageDialog(null, "Không thể truy cập trạng thái của phòng"); // Hiển thị thông báo nếu không thể truy cập trạng thái của phòng
    }
    }//GEN-LAST:event_phong9MousePressed

    private void btnEditPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditPhongActionPerformed

        if (tblPhieuThuePhong.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn phiếu đặt phòng cần sửa");
        } else {
            UpdatePhieuDatPhong a = new UpdatePhieuDatPhong(this, (JFrame) javax.swing.SwingUtilities.getWindowAncestor(this), rootPaneCheckingEnabled);
            a.setVisible(true);
        }
    }//GEN-LAST:event_btnEditPhongActionPerformed


    private void btnChuyenTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChuyenTrangThaiActionPerformed
        int selectedRow = tblDuLieuPhong.getSelectedRow();
    if (selectedRow != -1) { // Kiểm tra xem có dòng nào được chọn không
        // Lấy giá trị từ cột "Mã phòng" của dòng được chọn
        String maPhong = tblDuLieuPhong.getValueAt(selectedRow, 0).toString();
        // Lấy trạng thái phòng từ cơ sở dữ liệu dựa trên mã phòng
        String trangThaiPhong = getTrangThaiPhongFromDatabase(maPhong);
        // Kiểm tra nếu trạng thái phòng là "Đang dọn" hoặc "Đang sửa"
        if (trangThaiPhong != null && (trangThaiPhong.equals("Đang Dọn") || trangThaiPhong.equals("Đang Sửa"))) {
            // Cập nhật trạng thái của phòng thành "Trống"
            if (updateTrangThai(maPhong, "Sẵn Sàng")) {
                JOptionPane.showMessageDialog(null, "Cập nhật trạng thái phòng thành công");
                // Cập nhật lại dữ liệu trong bảng sau khi cập nhật trạng thái phòng
                 
                loadDataToTablePhong(PhongDAO.getInstance().selectAll());
                  setColorForPanels();
            } else {
                JOptionPane.showMessageDialog(null, "Cập nhật trạng thái phòng thất bại");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Phòng không ở trạng thái 'Đang dọn' hoặc 'Đang sửa'");
        }
    } else {
        JOptionPane.showMessageDialog(null, "Vui lòng chọn phòng 'Đang dọn' hoặc 'Đang sửa'");
    }
    

    }//GEN-LAST:event_btnChuyenTrangThaiActionPerformed

    private void btnChuyenPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChuyenPhongActionPerformed
        if (tblPhieuThuePhong.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn phiếu đặt phòng để chuyển phòng");
        } else {
            ChuyenPhongForm a = new ChuyenPhongForm(this, (JFrame) javax.swing.SwingUtilities.getWindowAncestor(this), rootPaneCheckingEnabled);
            a.setVisible(true);
        } 
    }//GEN-LAST:event_btnChuyenPhongActionPerformed

    private void btnTraPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraPhongActionPerformed

        if (tblPhieuThuePhong.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn phiếu đặt phòng cần sửa");
        } else {
           ThanhToanPhong a = new ThanhToanPhong(this, (JFrame) javax.swing.SwingUtilities.getWindowAncestor(this), rootPaneCheckingEnabled);
             a.setNguoiTao();
        a.setThoiGianNhanPhong();
         
      // Mã phòng bạn muốn kiểm tra
      a.calculateTotalTime();
           a.setVisible(true);
        }
       

    }//GEN-LAST:event_btnTraPhongActionPerformed

    private void phong12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong12MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_phong12MouseClicked

    private void phong12MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong12MousePressed
        String maPhong = "P3.02"; // Mã phòng bạn muốn kiểm tra
    String trangThaiPhong = getTrangThaiPhongFromDatabase(maPhong); // Lấy trạng thái của phòng từ cơ sở dữ liệu
    if (trangThaiPhong != null) { // Kiểm tra xem trạng thái có tồn tại không
        switch (trangThaiPhong) {
              case "Sẵn Sàng":
                int choice = JOptionPane.showConfirmDialog(null, "Bạn có muốn đặt phòng?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    createDatPhongWindow(maPhong, "Phòng Đơn VIP");
                } else {
                    // Không làm gì cả
                }
                break;
                case "Đang Dọn":
                JOptionPane.showMessageDialog(null, "Phòng đang dọn, vui lòng chọn phòng khác");
                break;
                case "Đang Sửa":
                JOptionPane.showMessageDialog(null, "Phòng đang sửa, vui lòng chọn phòng khác");
                break;
                case "Có Khách":
                JOptionPane.showMessageDialog(null, "Phòng đã có người thuê, vui lòng chọn phòng khác");
                break;
                default:
                JOptionPane.showMessageDialog(null, "Trạng thái phòng không hợp lệ");
                break;
        }
    } else {
        JOptionPane.showMessageDialog(null, "Không thể truy cập trạng thái của phòng"); // Hiển thị thông báo nếu không thể truy cập trạng thái của phòng
    }
    }//GEN-LAST:event_phong12MousePressed

    private void phong13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong13MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_phong13MouseClicked

    private void phong13MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong13MousePressed
    String maPhong = "P3.03"; // Mã phòng bạn muốn kiểm tra
    String trangThaiPhong = getTrangThaiPhongFromDatabase(maPhong); // Lấy trạng thái của phòng từ cơ sở dữ liệu
    if (trangThaiPhong != null) { // Kiểm tra xem trạng thái có tồn tại không
        switch (trangThaiPhong) {
            case "Sẵn Sàng":
                int choice = JOptionPane.showConfirmDialog(null, "Bạn có muốn đặt phòng?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    createDatPhongWindow(maPhong, "Phòng Đơn VIP");
                } else {
                    // Không làm gì cả
                }
                break;
                case "Đang Dọn":
                JOptionPane.showMessageDialog(null, "Phòng đang dọn, vui lòng chọn phòng khác");
                break;
                case "Đang Sửa":
                JOptionPane.showMessageDialog(null, "Phòng đang sửa, vui lòng chọn phòng khác");
                break;
                case "Có Khách":
                JOptionPane.showMessageDialog(null, "Phòng đã có người thuê, vui lòng chọn phòng khác");
                break;
                default:
                JOptionPane.showMessageDialog(null, "Trạng thái phòng không hợp lệ");
                break;
        }
    } else {
        JOptionPane.showMessageDialog(null, "Không thể truy cập trạng thái của phòng"); // Hiển thị thông báo nếu không thể truy cập trạng thái của phòng
    }
    }//GEN-LAST:event_phong13MousePressed

    private void phong14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong14MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_phong14MouseClicked
private String getTrangThaiPhongFromDatabase(String maPhong) {
    // Thực hiện truy vấn để lấy trạng thái của phòng từ cơ sở dữ liệu
    // Return trạng thái của phòng hoặc null nếu không thể lấy được
    String trangThai = null;
    try {
       
         trangThai = PhongDAO.getInstance().getTinhtrangPhong(maPhong);
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    return trangThai;
}
    private void phong14MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong14MousePressed
     String maPhong = "P3.04"; // Mã phòng bạn muốn kiểm tra
    String trangThaiPhong = getTrangThaiPhongFromDatabase(maPhong); // Lấy trạng thái của phòng từ cơ sở dữ liệu
    if (trangThaiPhong != null) { // Kiểm tra xem trạng thái có tồn tại không
        switch (trangThaiPhong) {
              case "Sẵn Sàng":
                int choice = JOptionPane.showConfirmDialog(null, "Bạn có muốn đặt phòng?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    createDatPhongWindow(maPhong, "Phòng Đôi VIP");
                } else {
                    // Không làm gì cả
                }
                break;
                case "Đang Dọn":
                JOptionPane.showMessageDialog(null, "Phòng đang dọn, vui lòng chọn phòng khác");
                break;
                case "Đang Sửa":
                JOptionPane.showMessageDialog(null, "Phòng đang sửa, vui lòng chọn phòng khác");
                break;
                case "Có Khách":
                JOptionPane.showMessageDialog(null, "Phòng đã có người thuê, vui lòng chọn phòng khác");
                break;
                default:
                JOptionPane.showMessageDialog(null, "Trạng thái phòng không hợp lệ");
                break;
        }
    } else {
        JOptionPane.showMessageDialog(null, "Không thể truy cập trạng thái của phòng"); // Hiển thị thông báo nếu không thể truy cập trạng thái của phòng
    }
    }//GEN-LAST:event_phong14MousePressed

    private void phong15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong15MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_phong15MouseClicked

    private void phong15MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong15MousePressed
        String maPhong = "P3.05"; // Mã phòng bạn muốn kiểm tra
    String trangThaiPhong = getTrangThaiPhongFromDatabase(maPhong); // Lấy trạng thái của phòng từ cơ sở dữ liệu
    if (trangThaiPhong != null) { // Kiểm tra xem trạng thái có tồn tại không
        switch (trangThaiPhong) {
              case "Sẵn Sàng":
                int choice = JOptionPane.showConfirmDialog(null, "Bạn có muốn đặt phòng?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    createDatPhongWindow(maPhong, "Phòng Đôi VIP");
                } else {
                    // Không làm gì cả
                }
                break;
                case "Đang Dọn":
                JOptionPane.showMessageDialog(null, "Phòng đang dọn, vui lòng chọn phòng khác");
                break;
                case "Đang Sửa":
                JOptionPane.showMessageDialog(null, "Phòng đang sửa, vui lòng chọn phòng khác");
                break;
                case "Có Khách":
                JOptionPane.showMessageDialog(null, "Phòng đã có người thuê, vui lòng chọn phòng khác");
                break;
                default:
                JOptionPane.showMessageDialog(null, "Trạng thái phòng không hợp lệ");
                break;
        }
    } else {
        JOptionPane.showMessageDialog(null, "Không thể truy cập trạng thái của phòng"); // Hiển thị thông báo nếu không thể truy cập trạng thái của phòng
    }
    }//GEN-LAST:event_phong15MousePressed

    private void btnDetailPhong1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailPhong1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDetailPhong1ActionPerformed

    private void btnChuyenPhong1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChuyenPhong1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnChuyenPhong1ActionPerformed

    private void btnTraPhong1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraPhong1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTraPhong1ActionPerformed

    private void btnChuyenTrangThai1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChuyenTrangThai1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnChuyenTrangThai1ActionPerformed

    private void btnEditPhong1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditPhong1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditPhong1ActionPerformed

    private void phong16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong16MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_phong16MouseClicked

    private void phong16MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong16MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_phong16MousePressed

    private void phong17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong17MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_phong17MouseClicked

    private void phong17MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong17MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_phong17MousePressed

    private void phong18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong18MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_phong18MouseClicked

    private void phong18MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong18MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_phong18MousePressed

    private void phong19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong19MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_phong19MouseClicked

    private void phong19MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong19MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_phong19MousePressed

    private void phong20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong20MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_phong20MouseClicked

    private void phong20MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong20MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_phong20MousePressed

    private void phong21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong21MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_phong21MouseClicked

    private void phong21MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong21MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_phong21MousePressed

    private void phong22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong22MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_phong22MouseClicked

    private void phong22MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong22MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_phong22MousePressed

    private void phong23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong23MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_phong23MouseClicked

    private void phong23MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong23MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_phong23MousePressed

    private void phong24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong24MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_phong24MouseClicked

    private void phong24MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong24MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_phong24MousePressed

    private void phong25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong25MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_phong25MouseClicked

    private void phong25MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong25MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_phong25MousePressed

    private void phong26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong26MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_phong26MouseClicked

    private void phong26MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong26MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_phong26MousePressed

    private void phong27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong27MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_phong27MouseClicked

    private void phong27MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong27MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_phong27MousePressed

    private void phong28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong28MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_phong28MouseClicked

    private void phong28MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong28MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_phong28MousePressed

    private void phong29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong29MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_phong29MouseClicked

    private void phong29MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong29MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_phong29MousePressed

    private void phong30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong30MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_phong30MouseClicked

    private void phong30MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong30MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_phong30MousePressed

    private void trangthai1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trangthai1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_trangthai1MouseClicked

    private void trangthai1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trangthai1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_trangthai1MousePressed

    private void trangthai3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trangthai3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_trangthai3MouseClicked

    private void trangthai3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trangthai3MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_trangthai3MousePressed

    private void trangthai4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trangthai4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_trangthai4MouseClicked

    private void trangthai4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trangthai4MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_trangthai4MousePressed

    private void trangthai5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trangthai5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_trangthai5MouseClicked

    private void trangthai5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trangthai5MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_trangthai5MousePressed

    private void phong11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong11MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_phong11MouseClicked

    private void phong11MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong11MousePressed
     String maPhong = "P3.01"; // Mã phòng bạn muốn kiểm tra
        String trangThaiPhong = getTrangThaiPhongFromDatabase(maPhong); // Lấy trạng thái của phòng từ cơ sở dữ liệu
        if (trangThaiPhong != null) { // Kiểm tra xem trạng thái có tồn tại không
            switch (trangThaiPhong) {
                case "Sẵn Sàng":
                int choice = JOptionPane.showConfirmDialog(null, "Bạn có muốn đặt phòng?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    createDatPhongWindow(maPhong, "Phòng Đơn VIP");
                } else {
                    // Không làm gì cả
                }
                break;
                case "Đang Dọn":
                JOptionPane.showMessageDialog(null, "Phòng đang dọn, vui lòng chọn phòng khác");
                break;
                case "Đang Sửa":
                JOptionPane.showMessageDialog(null, "Phòng đang sửa, vui lòng chọn phòng khác");
                break;
                case "Có Khách":
                JOptionPane.showMessageDialog(null, "Phòng đã có người thuê, vui lòng chọn phòng khác");
                break;
                default:
                JOptionPane.showMessageDialog(null, "Trạng thái phòng không hợp lệ");
                break;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Không thể truy cập trạng thái của phòng"); // Hiển thị thông báo nếu không thể truy cập trạng thái của phòng
        }
    }//GEN-LAST:event_phong11MousePressed

    private void btnChuyenTrangThai2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChuyenTrangThai2ActionPerformed
     int selectedRow = tblDuLieuPhong.getSelectedRow();
    if (selectedRow != -1) { // Kiểm tra xem có dòng nào được chọn không
        // Lấy giá trị từ cột "Mã phòng" của dòng được chọn
        String maPhong = tblDuLieuPhong.getValueAt(selectedRow, 0).toString();
        // Lấy trạng thái phòng từ cơ sở dữ liệu dựa trên mã phòng
        String trangThaiPhong = getTrangThaiPhongFromDatabase(maPhong);
        // Kiểm tra nếu trạng thái phòng là "Đang dọn" hoặc "Trống"
        if (trangThaiPhong != null && (trangThaiPhong.equals("Đang Dọn") || trangThaiPhong.equals("Sẵn Sàng"))) {
            // Cập nhật trạng thái của phòng thành "Phòng sửa"
            if (updateTrangThai(maPhong, "Đang Sửa")) {
                JOptionPane.showMessageDialog(null, "Cập nhật trạng thái phòng thành công");
                // Cập nhật lại dữ liệu trong bảng sau khi cập nhật trạng thái phòng
              loadDataToTablePhong(PhongDAO.getInstance().selectAll());
              setColorForPanels();
            } else {
                JOptionPane.showMessageDialog(null, "Cập nhật trạng thái phòng thất bại");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Phòng không ở trạng thái 'Đang dọn' hoặc 'Trống'");
        }
    } else {
        JOptionPane.showMessageDialog(null, "Vui lòng chọn một phòng ở trạng thái 'Đang dọn' hoặc 'Trống'");
    }
    }//GEN-LAST:event_btnChuyenTrangThai2ActionPerformed

    private void phong10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong10MousePressed
        String maPhong = "P2.05"; // Mã phòng bạn muốn kiểm tra
        String trangThaiPhong = getTrangThaiPhongFromDatabase(maPhong); // Lấy trạng thái của phòng từ cơ sở dữ liệu
        if (trangThaiPhong != null) { // Kiểm tra xem trạng thái có tồn tại không
            switch (trangThaiPhong) {
                case "Sẵn Sàng":
                int choice = JOptionPane.showConfirmDialog(null, "Bạn có muốn đặt phòng?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    createDatPhongWindow(maPhong, "Phòng Đôi");
                } else {
                    // Không làm gì cả
                }
                break;
                case "Đang Dọn":
                JOptionPane.showMessageDialog(null, "Phòng đang dọn, vui lòng chọn phòng khác");
                break;
                case "Đang Sửa":
                JOptionPane.showMessageDialog(null, "Phòng đang sửa, vui lòng chọn phòng khác");
                break;
                case "Có Khách":
                JOptionPane.showMessageDialog(null, "Phòng đã có người thuê, vui lòng chọn phòng khác");
                break;
                default:
                JOptionPane.showMessageDialog(null, "Trạng thái phòng không hợp lệ");
                break;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Không thể truy cập trạng thái của phòng"); // Hiển thị thông báo nếu không thể truy cập trạng thái của phòng
        }
    }//GEN-LAST:event_phong10MousePressed

    private void phong10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong10MouseClicked

    }//GEN-LAST:event_phong10MouseClicked

    private void phong8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong8MousePressed
        String maPhong = "P2.03"; // Mã phòng bạn muốn kiểm tra
        String trangThaiPhong = getTrangThaiPhongFromDatabase(maPhong); // Lấy trạng thái của phòng từ cơ sở dữ liệu
        if (trangThaiPhong != null) { // Kiểm tra xem trạng thái có tồn tại không
            switch (trangThaiPhong) {
                case "Sẵn Sàng":
                int choice = JOptionPane.showConfirmDialog(null, "Bạn có muốn đặt phòng?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    createDatPhongWindow(maPhong, "Phòng Đôi");
                } else {
                    // Không làm gì cả
                }
                break;
                case "Đang Dọn":
                JOptionPane.showMessageDialog(null, "Phòng đang dọn, vui lòng chọn phòng khác");
                break;
                case "Đang Sửa":
                JOptionPane.showMessageDialog(null, "Phòng đang sửa, vui lòng chọn phòng khác");
                break;
                case "Có Khách":
                JOptionPane.showMessageDialog(null, "Phòng đã có người thuê, vui lòng chọn phòng khác");
                break;
                default:
                JOptionPane.showMessageDialog(null, "Trạng thái phòng không hợp lệ");
                break;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Không thể truy cập trạng thái của phòng"); // Hiển thị thông báo nếu không thể truy cập trạng thái của phòng
        }
    }//GEN-LAST:event_phong8MousePressed

    private void btnChuyenPhong2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChuyenPhong2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnChuyenPhong2ActionPerformed

    private void btnTraPhong2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraPhong2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTraPhong2ActionPerformed

    private void btnChuyenTrangThai4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChuyenTrangThai4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnChuyenTrangThai4ActionPerformed

    private void btnEditPhong2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditPhong2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditPhong2ActionPerformed

    private void btnChuyenTrangThai5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChuyenTrangThai5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnChuyenTrangThai5ActionPerformed

    private void btnChuyenTrangThai6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChuyenTrangThai6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnChuyenTrangThai6ActionPerformed

    private void phong31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong31MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_phong31MouseClicked

    private void phong31MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong31MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_phong31MousePressed

    private void phong32MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong32MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_phong32MouseClicked

    private void phong32MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong32MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_phong32MousePressed

    private void phong33MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong33MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_phong33MouseClicked

    private void phong33MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong33MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_phong33MousePressed

    private void phong34MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong34MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_phong34MouseClicked

    private void phong34MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong34MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_phong34MousePressed

    private void phong35MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong35MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_phong35MouseClicked

    private void phong35MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong35MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_phong35MousePressed

    private void phong36MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong36MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_phong36MouseClicked

    private void phong36MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong36MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_phong36MousePressed

    private void phong37MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong37MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_phong37MouseClicked

    private void phong37MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong37MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_phong37MousePressed

    private void phong38MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong38MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_phong38MouseClicked

    private void phong38MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong38MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_phong38MousePressed

    private void phong39MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong39MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_phong39MousePressed

    private void phong40MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong40MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_phong40MouseClicked

    private void phong40MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong40MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_phong40MousePressed

    private void phong41MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong41MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_phong41MouseClicked

    private void phong41MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong41MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_phong41MousePressed

    private void phong42MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong42MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_phong42MouseClicked

    private void phong42MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong42MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_phong42MousePressed

    private void phong43MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong43MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_phong43MouseClicked

    private void phong43MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong43MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_phong43MousePressed

    private void phong44MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong44MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_phong44MouseClicked

    private void phong44MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong44MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_phong44MousePressed

    private void phong45MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong45MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_phong45MouseClicked

    private void phong45MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong45MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_phong45MousePressed

    private void trangthai2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trangthai2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_trangthai2MouseClicked

    private void trangthai2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trangthai2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_trangthai2MousePressed

    private void trangthai6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trangthai6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_trangthai6MouseClicked

    private void trangthai6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trangthai6MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_trangthai6MousePressed

    private void trangthai7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trangthai7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_trangthai7MouseClicked

    private void trangthai7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trangthai7MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_trangthai7MousePressed

    private void trangthai8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trangthai8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_trangthai8MouseClicked

    private void trangthai8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trangthai8MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_trangthai8MousePressed

    private void btnDetailPhong2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailPhong2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDetailPhong2ActionPerformed

    private void btnChuyenPhong3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChuyenPhong3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnChuyenPhong3ActionPerformed

    private void btnTraPhong3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraPhong3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTraPhong3ActionPerformed

    private void btnChuyenTrangThai7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChuyenTrangThai7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnChuyenTrangThai7ActionPerformed

    private void btnEditPhong3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditPhong3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditPhong3ActionPerformed

    private void phong46MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong46MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_phong46MouseClicked

    private void phong46MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong46MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_phong46MousePressed

    private void phong47MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong47MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_phong47MouseClicked

    private void phong47MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong47MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_phong47MousePressed

    private void phong48MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong48MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_phong48MouseClicked

    private void phong48MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong48MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_phong48MousePressed

    private void phong49MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong49MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_phong49MouseClicked

    private void phong49MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong49MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_phong49MousePressed

    private void phong50MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong50MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_phong50MouseClicked

    private void phong50MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong50MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_phong50MousePressed

    private void phong51MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong51MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_phong51MouseClicked

    private void phong51MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong51MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_phong51MousePressed

    private void phong52MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong52MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_phong52MouseClicked

    private void phong52MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong52MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_phong52MousePressed

    private void phong53MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong53MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_phong53MouseClicked

    private void phong53MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong53MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_phong53MousePressed

    private void phong54MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong54MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_phong54MouseClicked

    private void phong54MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong54MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_phong54MousePressed

    private void phong55MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong55MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_phong55MouseClicked

    private void phong55MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong55MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_phong55MousePressed

    private void phong56MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong56MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_phong56MouseClicked

    private void phong56MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong56MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_phong56MousePressed

    private void phong57MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong57MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_phong57MouseClicked

    private void phong57MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong57MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_phong57MousePressed

    private void phong58MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong58MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_phong58MouseClicked

    private void phong58MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong58MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_phong58MousePressed

    private void phong59MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong59MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_phong59MouseClicked

    private void phong59MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong59MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_phong59MousePressed

    private void phong60MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong60MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_phong60MouseClicked

    private void phong60MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong60MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_phong60MousePressed

    private void btnChuyenTrangThai8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChuyenTrangThai8ActionPerformed
             loadDateToTablePTP(ptp); loadDataToTablePhong(phong);
    }//GEN-LAST:event_btnChuyenTrangThai8ActionPerformed

    public static void main(String[] args) throws UnsupportedLookAndFeelException {

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(new FlatLightLaf());
                } catch (UnsupportedLookAndFeelException e) {
                    e.printStackTrace();
                }
              

            }
        });

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChuyenPhong;
    private javax.swing.JButton btnChuyenPhong1;
    private javax.swing.JButton btnChuyenPhong2;
    private javax.swing.JButton btnChuyenPhong3;
    private javax.swing.JButton btnChuyenTrangThai;
    private javax.swing.JButton btnChuyenTrangThai1;
    private javax.swing.JButton btnChuyenTrangThai2;
    private javax.swing.JButton btnChuyenTrangThai4;
    private javax.swing.JButton btnChuyenTrangThai5;
    private javax.swing.JButton btnChuyenTrangThai6;
    private javax.swing.JButton btnChuyenTrangThai7;
    private javax.swing.JButton btnChuyenTrangThai8;
    private javax.swing.JButton btnDetailPhong1;
    private javax.swing.JButton btnDetailPhong2;
    private javax.swing.JButton btnEditPhong;
    private javax.swing.JButton btnEditPhong1;
    private javax.swing.JButton btnEditPhong2;
    private javax.swing.JButton btnEditPhong3;
    private javax.swing.JButton btnTraPhong;
    private javax.swing.JButton btnTraPhong1;
    private javax.swing.JButton btnTraPhong2;
    private javax.swing.JButton btnTraPhong3;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JInternalFrame jInternalFrame3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JToolBar jToolBar4;
    private javax.swing.JToolBar jToolBar5;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private java.awt.Label label6;
    private java.awt.Label label7;
    private java.awt.Label label8;
    private java.awt.Panel panel1;
    private java.awt.Panel panel10;
    private java.awt.Panel panel11;
    private java.awt.Panel panel12;
    private java.awt.Panel panel2;
    private java.awt.Panel panel3;
    private java.awt.Panel panel4;
    private java.awt.Panel panel5;
    private java.awt.Panel panel6;
    private java.awt.Panel panel7;
    private java.awt.Panel panel8;
    private java.awt.Panel panel9;
    private javax.swing.JPanel phong1;
    private javax.swing.JPanel phong10;
    private javax.swing.JPanel phong11;
    private javax.swing.JPanel phong12;
    private javax.swing.JPanel phong13;
    private javax.swing.JPanel phong14;
    private javax.swing.JPanel phong15;
    private javax.swing.JPanel phong16;
    private javax.swing.JPanel phong17;
    private javax.swing.JPanel phong18;
    private javax.swing.JPanel phong19;
    private javax.swing.JPanel phong2;
    private javax.swing.JPanel phong20;
    private javax.swing.JPanel phong21;
    private javax.swing.JPanel phong22;
    private javax.swing.JPanel phong23;
    private javax.swing.JPanel phong24;
    private javax.swing.JPanel phong25;
    private javax.swing.JPanel phong26;
    private javax.swing.JPanel phong27;
    private javax.swing.JPanel phong28;
    private javax.swing.JPanel phong29;
    private javax.swing.JPanel phong3;
    private javax.swing.JPanel phong30;
    private javax.swing.JPanel phong31;
    private javax.swing.JPanel phong32;
    private javax.swing.JPanel phong33;
    private javax.swing.JPanel phong34;
    private javax.swing.JPanel phong35;
    private javax.swing.JPanel phong36;
    private javax.swing.JPanel phong37;
    private javax.swing.JPanel phong38;
    private javax.swing.JPanel phong39;
    private javax.swing.JPanel phong4;
    private javax.swing.JPanel phong40;
    private javax.swing.JPanel phong41;
    private javax.swing.JPanel phong42;
    private javax.swing.JPanel phong43;
    private javax.swing.JPanel phong44;
    private javax.swing.JPanel phong45;
    private javax.swing.JPanel phong46;
    private javax.swing.JPanel phong47;
    private javax.swing.JPanel phong48;
    private javax.swing.JPanel phong49;
    private javax.swing.JPanel phong5;
    private javax.swing.JPanel phong50;
    private javax.swing.JPanel phong51;
    private javax.swing.JPanel phong52;
    private javax.swing.JPanel phong53;
    private javax.swing.JPanel phong54;
    private javax.swing.JPanel phong55;
    private javax.swing.JPanel phong56;
    private javax.swing.JPanel phong57;
    private javax.swing.JPanel phong58;
    private javax.swing.JPanel phong59;
    private javax.swing.JPanel phong6;
    private javax.swing.JPanel phong60;
    private javax.swing.JPanel phong7;
    private javax.swing.JPanel phong8;
    private javax.swing.JPanel phong9;
    private javax.swing.JTable tblDuLieuPhong;
    private javax.swing.JTable tblDuLieuPhong1;
    private javax.swing.JTable tblDuLieuPhong2;
    private javax.swing.JTable tblDuLieuPhong3;
    private javax.swing.JTable tblPhieuThuePhong;
    private javax.swing.JTable tblPhieuThuePhong1;
    private javax.swing.JLabel tinhtrangp1;
    private javax.swing.JLabel tinhtrangp10;
    private javax.swing.JLabel tinhtrangp11;
    private javax.swing.JLabel tinhtrangp12;
    private javax.swing.JLabel tinhtrangp13;
    private javax.swing.JLabel tinhtrangp14;
    private javax.swing.JLabel tinhtrangp15;
    private javax.swing.JLabel tinhtrangp16;
    private javax.swing.JLabel tinhtrangp17;
    private javax.swing.JLabel tinhtrangp18;
    private javax.swing.JLabel tinhtrangp19;
    private javax.swing.JLabel tinhtrangp2;
    private javax.swing.JLabel tinhtrangp20;
    private javax.swing.JLabel tinhtrangp21;
    private javax.swing.JLabel tinhtrangp22;
    private javax.swing.JLabel tinhtrangp23;
    private javax.swing.JLabel tinhtrangp24;
    private javax.swing.JLabel tinhtrangp25;
    private javax.swing.JLabel tinhtrangp26;
    private javax.swing.JLabel tinhtrangp27;
    private javax.swing.JLabel tinhtrangp28;
    private javax.swing.JLabel tinhtrangp29;
    private javax.swing.JLabel tinhtrangp3;
    private javax.swing.JLabel tinhtrangp30;
    private javax.swing.JLabel tinhtrangp4;
    private javax.swing.JLabel tinhtrangp5;
    private javax.swing.JLabel tinhtrangp6;
    private javax.swing.JLabel tinhtrangp7;
    private javax.swing.JLabel tinhtrangp8;
    private javax.swing.JLabel tinhtrangp9;
    private javax.swing.JPanel trangthai1;
    private javax.swing.JPanel trangthai2;
    private javax.swing.JPanel trangthai3;
    private javax.swing.JPanel trangthai4;
    private javax.swing.JPanel trangthai5;
    private javax.swing.JPanel trangthai6;
    private javax.swing.JPanel trangthai7;
    private javax.swing.JPanel trangthai8;
    // End of variables declaration//GEN-END:variables

    public final void initTablePhong() {
        tblModel = new DefaultTableModel();
        String[] headerTbl = new String[]{"Mã phòng", "Tình trạng"};
        tblModel.setColumnIdentifiers(headerTbl);
        tblDuLieuPhong.setModel(tblModel);
        tblDuLieuPhong.getColumnModel().getColumn(0).setPreferredWidth(50);
}

    public void loadDataToTablePhong(ArrayList<Phong> phong) {
        try {
            tblModel.setRowCount(0);
            for (Phong i : phong) {
                tblModel.addRow(new Object[]{
                    i.getMaPhong(), i.getTinhtrangPhong()});
            }
        } catch (Exception e) {
        }
    }
   public void loadDateToTablePTP(ArrayList<ChiTietHoaDonPhong> ptp) {
    try {
        tblptp.setRowCount(0); // Giả sử tblptp là DefaultTableModel của bảng của bạn
        for (ChiTietHoaDonPhong i : ptp) {
            // Kiểm tra nếu trangThaiPhieu là false mới thêm vào bảng
            if (!i.isTrangThaiPhieu()) {
                tblptp.addRow(new Object[]{
                    i.getMaPhieuThuePhong(), i.getTenNV(), formatDate.format(i.getCheckIn()), i.getTenKH(), i.getMaPhong()
                });
            }
        }
    } catch (Exception e) {
        e.printStackTrace(); // Thêm để in lỗi ra nếu có
    }
}


    void setColorForPanels() {
         // Lặp qua từng dòng trong bảng và lấy trạng thái của từng phòng
    for (int i = 0; i < tblDuLieuPhong.getRowCount(); i++) {
        String maPhong = (String) tblDuLieuPhong.getValueAt(i, 0); // Lấy mã phòng
        String tinhTrangPhong = (String) tblDuLieuPhong.getValueAt(i, 1); // Lấy trạng thái
        
        // Kiểm tra trạng thái và thiết lập màu cho panel phù hợp
        if (maPhong.equals("P1.01")) {
            setColorForPanel(phong1, tinhTrangPhong);
             updateLabels(tinhtrangp1, tinhTrangPhong);
        } else if (maPhong.equals("P1.02")) {
            setColorForPanel(phong2, tinhTrangPhong);
            updateLabels(tinhtrangp2, tinhTrangPhong);
        }
        else if (maPhong.equals("P1.03")) {
            setColorForPanel(phong3, tinhTrangPhong);
            updateLabels(tinhtrangp3, tinhTrangPhong);
        }
        else if (maPhong.equals("P1.04")) {
            setColorForPanel(phong4, tinhTrangPhong);
            updateLabels(tinhtrangp4, tinhTrangPhong);
        }
        else if (maPhong.equals("P1.05")) {
            setColorForPanel(phong5, tinhTrangPhong);
            updateLabels(tinhtrangp5, tinhTrangPhong);
        }
        else if (maPhong.equals("P2.01")) {
            setColorForPanel(phong6, tinhTrangPhong);
            updateLabels(tinhtrangp6, tinhTrangPhong);
        }else if (maPhong.equals("P2.02")) {
            setColorForPanel(phong7, tinhTrangPhong);
            updateLabels(tinhtrangp7, tinhTrangPhong);
        }else if (maPhong.equals("P2.03")) {
            setColorForPanel(phong8, tinhTrangPhong);
            updateLabels(tinhtrangp8, tinhTrangPhong);
        }
        else if (maPhong.equals("P2.04")) {
            setColorForPanel(phong9, tinhTrangPhong);
            updateLabels(tinhtrangp9, tinhTrangPhong);
        }
        else if (maPhong.equals("P2.05")) {
            setColorForPanel(phong10, tinhTrangPhong);
            updateLabels(tinhtrangp10, tinhTrangPhong);
        }
         else if (maPhong.equals("P3.01")) {
            setColorForPanel(phong11, tinhTrangPhong);
            updateLabels(tinhtrangp11, tinhTrangPhong);
        }
         else if (maPhong.equals("P3.02")) {
            setColorForPanel(phong12, tinhTrangPhong);
            updateLabels(tinhtrangp12, tinhTrangPhong);
        }
         else if (maPhong.equals("P3.03")) {
            setColorForPanel(phong13, tinhTrangPhong);
            updateLabels(tinhtrangp13, tinhTrangPhong);
        }
         else if (maPhong.equals("P3.04")) {
            setColorForPanel(phong14, tinhTrangPhong);
            updateLabels(tinhtrangp14, tinhTrangPhong);
        }
         else if (maPhong.equals("P3.05")) {
            setColorForPanel(phong15, tinhTrangPhong);
            updateLabels(tinhtrangp15, tinhTrangPhong);
        }
        
        
        
        
    }
    }
    private void updateLabels(JLabel label, String tinhTrangPhong) {
    // Cập nhật nội dung của JLabel dựa trên trạng thái của phòng
        label.setText(tinhTrangPhong);
     label.setForeground(Color.WHITE);
}
    
    

     
public ChiTietHoaDonPhong getNhaCungCapSelect() {
    int selectedRow = tblPhieuThuePhong.getSelectedRow();
    if (selectedRow != -1) { // Kiểm tra xem đã chọn hàng nào chưa
        // Lấy dữ liệu từ cột 1 (cột thứ hai, index 1) của hàng đã chọn
        String maPhieuThuePhong = tblPhieuThuePhong.getValueAt(selectedRow, 0).toString();
        for (ChiTietHoaDonPhong phong : ChiTietHoaDonPhongDAO.getInstance().selectAll()) {
            if (phong != null && phong.getMaPhieuThuePhong() != null && phong.getMaPhieuThuePhong().equals(maPhieuThuePhong)) {
                return phong;
            }
        }
    }
    return null;
}



    
   public void setColorForPanel(JPanel panel, String tinhTrangPhong) {
    Color color;
    switch (tinhTrangPhong) {
        case "Sẵn Sàng":
            color = new Color(4,105,4); // Màu xanh đậm cho trạng thái "Trống"
            break;
        case "Đang Sửa":
            color = new Color(0,51,102); // Màu đỏ tối cho trạng thái "Đang thuê"
            break;
        case "Có Khách":
           color = new Color(204,0,0); // Màu đen cho trạng thái "Đang dọn"
            break;
        case "Đang Dọn":
            color = new Color(67,39,39); // Màu tím cho trạng thái "Đang sửa"
            break;
        default:
            color = Color.WHITE; // Màu mặc định
            break;
    }
    panel.setBackground(color); // Thiết lập màu cho panel
}

    private boolean updateTrangThai(String maPhong, String tinhTrangPhong) {
 int ketQua = PhongDAO.getInstance().updateTrangThai(maPhong, tinhTrangPhong);
    // Trả về true nếu có ít nhất một hàng được cập nhật thành công
    return ketQua > 0;
    }

   

   

 
}
