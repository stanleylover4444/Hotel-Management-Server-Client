/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import controller.SearchDichVu;
import controller.InPDF;
import dao.ChiTietHoaDonDichVuDAO;

import dao.DichVuDAO;
import dao.HoaDonDichVuDAO;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;
import javax.swing.SwingUtilities;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import model.ChiTietHoaDonDichVu;
import model.HoaDonDichVu;

import model.DichVu;

public class QuanLiDichVuForm extends javax.swing.JInternalFrame {
    private String MaHoaDon;
    private DefaultTableModel tblModel;
    DecimalFormat formatter = new DecimalFormat("###,###,###");


   private ArrayList<DichVu> sanPham;
   private ArrayList<ChiTietHoaDonDichVu> CTHDDV;

 
   

    public QuanLiDichVuForm() {
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        initComponents();
        sanPham = DichVuDAO.getInstance().selectAllExist();
        
        
        initTable();
        loadDataToTableProduct(sanPham);
        tblDichVu.setDefaultEditor(Object.class, null);
        tblDichVu1.setDefaultEditor(Object.class, null);
        CTHDDV = new ArrayList<ChiTietHoaDonDichVu>();
        MaHoaDon = createId(HoaDonDichVuDAO.getInstance().selectAll());
        txtmahdbl.setText(MaHoaDon);
        txtNguoiTao.setFocusable(false);
    }

    public final void initTable() {
        tblModel = new DefaultTableModel();
        String[] headerTbl = new String[]{"Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Đơn giá"};
        tblModel.setColumnIdentifiers(headerTbl);
        tblDichVu.setModel(tblModel);

    }

    private void loadDataToTableProduct(ArrayList<DichVu> arrProd) {
    try {
            tblModel.setRowCount(0);
            for (var i : arrProd) {
                tblModel.addRow(new Object[]{
                    i.getMaDichVu(), i.getTenDichVu(), i.getSoLuong(), formatter.format(i.getGia()) + "đ"
                });
            }
        } catch (Exception e) {
        }
    }

    public void loadDataToTableNhapHang() {
       double sum = 0;
        try {
            DefaultTableModel tblNhapHangmd = (DefaultTableModel) tblDichVu1.getModel();
            tblNhapHangmd.setRowCount(0);

            for (int i = 0; i < CTHDDV.size(); i++) {
                tblNhapHangmd.addRow(new Object[]{
                    i + 1, CTHDDV.get(i).getMaDichvu(), findDichVu(CTHDDV.get(i).getMaDichvu()).getTenDichVu(), CTHDDV.get(i).getSoLuong(), formatter.format(CTHDDV.get(i).getDonGia()) + "đ"
                });
                sum += CTHDDV.get(i).getDonGia();
            }
        } catch (Exception e) {
        }
        textTongTien.setText(formatter.format(sum) + "đ");
    }

    public void setNguoiTao(String name) {
        txtNguoiTao.setText(name);
    }
public ArrayList<ChiTietHoaDonDichVu> getDataForOtherClass() {
    return CTHDDV;
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtNguoiTao = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDichVu1 = new javax.swing.JTable();
        deleteProduct = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txtmahdbl = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDichVu = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        btnReset = new javax.swing.JButton();
        addProduct = new javax.swing.JButton();
        txtSoLuong = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        textTongTien = new javax.swing.JLabel();
        btnThanhToan = new javax.swing.JButton();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtNguoiTao1 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDichVu2 = new javax.swing.JTable();
        btnThanhToan1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        textTongTien1 = new javax.swing.JLabel();
        deleteProduct1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblDichVu3 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txtSoLuong1 = new javax.swing.JTextField();
        addProduct1 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        txtSearch1 = new javax.swing.JTextField();
        btnReset1 = new javax.swing.JButton();

        setBorder(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1380, 859));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Mã HĐBL");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        txtNguoiTao.setEditable(false);
        txtNguoiTao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNguoiTaoActionPerformed(evt);
            }
        });
        jPanel2.add(txtNguoiTao, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 380, 36));

        tblDichVu1.setFont(tblDichVu1.getFont().deriveFont((float)15));
        tblDichVu1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã dịch vụ", "Tên dịch vụ", "Số lượng", "Đơn giá"
            }
        ));
        jScrollPane1.setViewportView(tblDichVu1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 580, 540));

        deleteProduct.setBackground(new java.awt.Color(51, 51, 51));
        deleteProduct.setForeground(new java.awt.Color(255, 255, 255));
        deleteProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_delete_25px_1.png"))); // NOI18N
        deleteProduct.setText("Xoá sản phẩm");
        deleteProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteProductActionPerformed(evt);
            }
        });
        jPanel2.add(deleteProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 700, 150, 40));

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_edit_25px.png"))); // NOI18N
        jButton1.setText("Sửa số lượng");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 700, -1, 40));

        txtmahdbl.setEditable(false);
        txtmahdbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmahdblActionPerformed(evt);
            }
        });
        jPanel2.add(txtmahdbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 380, 36));

        jLabel9.setText("Người bán");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 620, 750));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tblDichVu.setFont(tblDichVu.getFont().deriveFont((float)15));
        tblDichVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã dịch vụ", "Tên dịch vụ", "Số lượng", "Đơn giá"
            }
        ));
        jScrollPane2.setViewportView(tblDichVu);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refresh.png"))); // NOI18N
        btnReset.setText("Làm mới");
        btnReset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnReset)
                .addGap(38, 38, 38))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 770));

        addProduct.setBackground(new java.awt.Color(51, 51, 51));
        addProduct.setForeground(new java.awt.Color(255, 255, 255));
        addProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        addProduct.setText("Thêm");
        addProduct.setBorder(null);
        addProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProductActionPerformed(evt);
            }
        });
        jPanel1.add(addProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 790, 115, 38));

        txtSoLuong.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSoLuong.setText("1");
        txtSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoLuongActionPerformed(evt);
            }
        });
        jPanel1.add(txtSoLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 790, -1, 37));

        jLabel4.setText("Số lượng");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 800, -1, -1));

        jLabel5.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel5.setText("Tổng tiền:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 770, 130, 30));

        textTongTien.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        textTongTien.setForeground(new java.awt.Color(255, 0, 0));
        textTongTien.setText("0đ");
        jPanel1.add(textTongTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 770, -1, 30));

        btnThanhToan.setBackground(new java.awt.Color(153, 0, 51));
        btnThanhToan.setForeground(new java.awt.Color(255, 255, 255));
        btnThanhToan.setText("Thanh Toán");
        btnThanhToan.setBorder(null);
        btnThanhToan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });
        jPanel1.add(btnThanhToan, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 770, 123, 37));

        jInternalFrame1.setBorder(null);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setText("Người bán");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        txtNguoiTao1.setEditable(false);
        txtNguoiTao1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNguoiTao1ActionPerformed(evt);
            }
        });
        jPanel6.add(txtNguoiTao1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 380, 36));

        tblDichVu2.setFont(tblDichVu2.getFont().deriveFont((float)15));
        tblDichVu2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã dịch vụ", "Tên dịch vụ", "Số lượng", "Đơn giá"
            }
        ));
        jScrollPane3.setViewportView(tblDichVu2);

        jPanel6.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 580, 450));

        btnThanhToan1.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Green"));
        btnThanhToan1.setForeground(new java.awt.Color(255, 255, 255));
        btnThanhToan1.setText("Thanh Toán");
        btnThanhToan1.setBorder(null);
        btnThanhToan1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThanhToan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToan1ActionPerformed(evt);
            }
        });
        jPanel6.add(btnThanhToan1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 690, 123, 37));

        jLabel7.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel7.setText("Tổng tiền:");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 690, 130, 30));

        textTongTien1.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        textTongTien1.setForeground(new java.awt.Color(255, 0, 0));
        textTongTien1.setText("0đ");
        jPanel6.add(textTongTien1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 690, -1, 30));

        deleteProduct1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_delete_25px_1.png"))); // NOI18N
        deleteProduct1.setText("Xoá sản phẩm");
        deleteProduct1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteProduct1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteProduct1ActionPerformed(evt);
            }
        });
        jPanel6.add(deleteProduct1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 620, 150, 40));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_edit_25px.png"))); // NOI18N
        jButton2.setText("Sửa số lượng");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 620, -1, 40));

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 620, 750));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        tblDichVu3.setFont(tblDichVu3.getFont().deriveFont((float)15));
        tblDichVu3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã dịch vụ", "Tên dịch vụ", "Số lượng", "Đơn giá"
            }
        ));
        jScrollPane4.setViewportView(tblDichVu3);

        jLabel8.setText("Số lượng");

        txtSoLuong1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSoLuong1.setText("1");
        txtSoLuong1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoLuong1ActionPerformed(evt);
            }
        });

        addProduct1.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Green"));
        addProduct1.setForeground(new java.awt.Color(255, 255, 255));
        addProduct1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_add_25px_5.png"))); // NOI18N
        addProduct1.setText("Thêm");
        addProduct1.setBorder(null);
        addProduct1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addProduct1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProduct1ActionPerformed(evt);
            }
        });

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));

        txtSearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearch1ActionPerformed(evt);
            }
        });
        txtSearch1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearch1KeyReleased(evt);
            }
        });

        btnReset1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_reset_25px_1.png"))); // NOI18N
        btnReset1.setText("Làm mới");
        btnReset1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReset1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReset1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(txtSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnReset1)
                .addGap(38, 38, 38))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jLabel8)
                .addGap(27, 27, 27)
                .addComponent(txtSoLuong1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(addProduct1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(187, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuong1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(addProduct1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        jPanel5.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 750));

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
         if (CTHDDV.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn sản phẩm để xuất hàng !","Cảnh báo", JOptionPane.WARNING_MESSAGE);
        } else {
            int check = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xuất hàng ?", "Xác nhận xuất hàng", JOptionPane.YES_NO_OPTION);
            if (check == JOptionPane.YES_OPTION) {
                // Lay thoi gian hien tai
                long now = System.currentTimeMillis();
                Timestamp sqlTimestamp = new Timestamp(now);
                // Tao doi tuong phieu nhap
                HoaDonDichVu pn = new HoaDonDichVu(MaHoaDon, sqlTimestamp, txtNguoiTao.getText(), CTHDDV, tinhTongTien());
                try {
                    HoaDonDichVuDAO.getInstance().insert(pn);
                    DichVuDAO dvdao = DichVuDAO.getInstance();
                    for (var i : CTHDDV) {
                        ChiTietHoaDonDichVuDAO.getInstance().insert(i);
                        dvdao.updateSoLuong(i.getMaDichvu(), dvdao.selectById(i.getMaDichvu()).getSoLuong() - i.getSoLuong());
                    }

                    JOptionPane.showMessageDialog(this, "Xuất hàng thành công !");
                  int res = JOptionPane.showConfirmDialog(this, "Bạn có muốn xuất file pdf ?");
                    if (res == JOptionPane.YES_OPTION) {
                        InPDF writepdf = new InPDF();
                        writepdf.writePhieuXuat(MaHoaDon);
                    }
                    sanPham = DichVuDAO.getInstance().selectAllExist();
                    loadDataToTableProduct(sanPham);
                    DefaultTableModel l = (DefaultTableModel) tblDichVu1.getModel();
                    l.setRowCount(0);
                    CTHDDV = new ArrayList<ChiTietHoaDonDichVu>();
                    txtSoLuong.setText("1");
                    textTongTien.setText(0 + "đ");
                    this.MaHoaDon = createId(HoaDonDichVuDAO.getInstance().selectAll());
                    txtmahdbl.setText(this.MaHoaDon);
                } catch (Exception e) {
                 e.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_btnThanhToanActionPerformed
public String createId(ArrayList<HoaDonDichVu> arr) {
        int id = arr.size() + 1;
        String check = "";
        for (HoaDonDichVu hoaDonDichVu : arr) {
            if (hoaDonDichVu.getMaHoaDon().equals("HDBL" + id)) {
                check = hoaDonDichVu.getMaHoaDon();
            }
        }
        while (check.length() != 0) {
            String c = check;
            id++;
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i).getMaHoaDon().equals("HDBL" + id)) {
                    check = arr.get(i).getMaHoaDon();
                }
            }
            if (check.equals(c)) {
                check = "";
            }
        }
        return "HDBL" + id;
}
    private void addProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProductActionPerformed
        // TODO add your handling code here:
        int i_row = tblDichVu.getSelectedRow();
        if (i_row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm để xuất hàng !");
        } else {
            int soluongselect = sanPham.get(i_row).getSoLuong();
            if (soluongselect == 0) {
                JOptionPane.showMessageDialog(this, "Sản phẩm đã hết hàng !");
            } else {
                int soluong;
                try {
                    soluong = Integer.parseInt(txtSoLuong.getText().trim());
                    if (soluong > 0) {
                        if (soluongselect < soluong) {
                            JOptionPane.showMessageDialog(this, "Số lượng không đủ !");
                        } else {
                            ChiTietHoaDonDichVu mtl = findCTDichVu((String) tblDichVu.getValueAt(i_row, 0));
                            if (mtl != null) {
                                if (findDichVu((String) tblDichVu.getValueAt(i_row, 0)).getSoLuong() < mtl.getSoLuong() + soluong) {
                                    JOptionPane.showMessageDialog(this, "Số lượng máy không đủ !");
                                } else {
                                    mtl.setSoLuong(mtl.getSoLuong() + soluong);
                                }
                            } else {
                                DichVu mt = SearchDichVu.getInstance().searchId((String) tblDichVu.getValueAt(i_row, 0));
                               ChiTietHoaDonDichVu ctp = new ChiTietHoaDonDichVu(MaHoaDon, mt.getMaDichVu(), soluong, mt.getGia());
                               CTHDDV.add(ctp);
                            }
                            loadDataToTableNhapHang();
                            textTongTien.setText(formatter.format(tinhTongTien()) + "đ");
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng lớn hơn 0");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng ở dạng số nguyên!");
                }
            }
        }
    }//GEN-LAST:event_addProductActionPerformed

    private void deleteProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteProductActionPerformed
        // TODO add your handling code here:
        int i_row = tblDichVu1.getSelectedRow();
        if (i_row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm để xoá khỏi bảng xuất hàng !");
        } else {
            CTHDDV.remove(i_row);
            loadDataToTableNhapHang();
            textTongTien.setText(formatter.format(tinhTongTien()) + "đ");
        }
        
    }//GEN-LAST:event_deleteProductActionPerformed
    public double tinhTongTien() {
    double tt = 0;
        for (var i : CTHDDV) {
            tt += i.getDonGia() * i.getSoLuong();
        }
        return tt;
    }

    public DichVu findDichVu(String maDichVu) {
         for (var i : sanPham) {
            if (maDichVu.equals(i.getMaDichVu())) {
                return i;
            }
        }
        return null;
       
    }

    public ChiTietHoaDonDichVu findCTDichVu(String maDichVu) {
        
           for (var i : CTHDDV) {
            if (maDichVu.equals(i.getMaDichvu())) {
                return i;
            }
        }
        return null;
        
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 // TODO add your handling code here:
        int i_row = tblDichVu1.getSelectedRow();
        if (i_row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm để xoá sửa số lượng !");
        } else {
            String newSL = JOptionPane.showInputDialog(this, "Nhập số lượng cần thay đổi", "Thay đổi số lượng", QUESTION_MESSAGE);
            if (newSL != null) {
                int soLuong;
                try {
                    soLuong = Integer.parseInt(newSL);
                    if (soLuong > 0) {
                        if (soLuong > findCTDichVu(CTHDDV.get(i_row).getMaDichvu()).getSoLuong()) {
                            JOptionPane.showMessageDialog(this, "Số lượng không đủ !");
                        } else {
                            CTHDDV.get(i_row).setSoLuong(soLuong);
                            loadDataToTableNhapHang();

                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng lớn hơn 0");

                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng ở dạng số nguyên!");
                }
            }
        }        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
       // TODO add your handling code here:
        DefaultTableModel tblsp = (DefaultTableModel) tblDichVu.getModel();
        String textSearch = txtSearch.getText().toLowerCase();
        ArrayList<DichVu> Mtkq = new ArrayList<>();
        for (DichVu i : sanPham) {
            if (i.getMaDichVu().concat(i.getTenDichVu()).toLowerCase().contains(textSearch)) {
                Mtkq.add(i);
            }
        }
        loadDataToTableProduct(Mtkq);
       
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtSearch.setText("");
        loadDataToTableProduct(sanPham);
    }//GEN-LAST:event_btnResetActionPerformed

    private void txtNguoiTaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNguoiTaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNguoiTaoActionPerformed

    private void txtSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoLuongActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtNguoiTao1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNguoiTao1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNguoiTao1ActionPerformed

    private void btnThanhToan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToan1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThanhToan1ActionPerformed

    private void deleteProduct1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteProduct1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteProduct1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtSoLuong1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoLuong1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoLuong1ActionPerformed

    private void addProduct1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProduct1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addProduct1ActionPerformed

    private void txtSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearch1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearch1ActionPerformed

    private void txtSearch1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearch1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearch1KeyReleased

    private void btnReset1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReset1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReset1ActionPerformed

    private void txtmahdblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmahdblActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmahdblActionPerformed
 public HoaDonDichVu getHoaDonDichVuSelect() {
        int i_row = tblDichVu.getSelectedRow();
        HoaDonDichVu pn = HoaDonDichVuDAO.getInstance().selectAll().get(i_row);
        return pn;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addProduct;
    private javax.swing.JButton addProduct1;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnReset1;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThanhToan1;
    private javax.swing.JButton deleteProduct;
    private javax.swing.JButton deleteProduct1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tblDichVu;
    private javax.swing.JTable tblDichVu1;
    private javax.swing.JTable tblDichVu2;
    private javax.swing.JTable tblDichVu3;
    private javax.swing.JLabel textTongTien;
    private javax.swing.JLabel textTongTien1;
    private javax.swing.JTextField txtNguoiTao;
    private javax.swing.JTextField txtNguoiTao1;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSearch1;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtSoLuong1;
    private javax.swing.JTextField txtmahdbl;
    // End of variables declaration//GEN-END:variables

}
