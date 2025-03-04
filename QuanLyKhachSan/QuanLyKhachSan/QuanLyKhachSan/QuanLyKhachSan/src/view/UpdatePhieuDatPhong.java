/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import com.formdev.flatlaf.FlatLightLaf;

import component.ThongTinTaiKhoan;
import controller.SearchDichVu;
import dao.ChiTietHoaDonDichVuDAO;
import dao.ChiTietHoaDonPhongDAO;
import dao.DichVuDAO;
import dao.KhachHangDAO;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import model.ChiTietHoaDonDichVu;
import model.ChiTietHoaDonPhong;
import model.DichVu;
import model.DichVuPTP;
import model.HoaDonDichVu;
import model.KhachHang;

public class UpdatePhieuDatPhong extends javax.swing.JDialog {

    /**
     * Creates new form ThemSP
     */
    private ArrayList<DichVu> dichvu = DichVuDAO.getInstance().selectAll();
   // private ArrayList<ChiTietHoaDonPhong> dichvusudung = ChiTietHoaDonPhongDAO.getInstance()
            
            
    private DefaultTableModel tblModel;
    private DefaultTableModel tblNhapHangmd1;
    private QuanLiPhongForm parent;
    private ChiTietHoaDonDichVu phieunhap;
    private String MaHoaDon;
        private ArrayList<ChiTietHoaDonDichVu> CTHDDV;
   private DichVu ctdv;

    
    private ArrayList<ChiTietHoaDonDichVu> huhu;
      SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    DecimalFormat formatter = new DecimalFormat("###,###,###");

    private ArrayList<DichVu> sanPham;
   

    public UpdatePhieuDatPhong(javax.swing.JInternalFrame parent, javax.swing.JFrame owner, boolean modal) {
        super(owner, modal);
        this.parent = (QuanLiPhongForm) parent;

        initComponents();
        setLocationRelativeTo(null);
        
        
        initTable(); // Khởi tạo bảng trước khi tải dữ liệu
        dichvudachon();
        
           this.CTHDDV = new ArrayList<>();
        tblDichVu.setDefaultEditor(Object.class, null);
        tblDichVuDaChon.setDefaultEditor(Object.class, null);

        sanPham = DichVuDAO.getInstance().selectAllExist();
    
        loadDataToTableProduct(dichvu);
        displayInfo();
        loadDataToTableProduct1();
        txtmaKH.setEnabled(false);
        txttenKH.setEnabled(false);
        txtcmtkh.setEnabled(false);
        cbxgioitinh.setEnabled(false);
        txtSDT.setEnabled(false);
        txtDCKH.setEnabled(false);
        txtDATEKH.setEnabled(false);
        txtloaiphong.setEnabled(false);
        txtdongiaPhong.setEnabled(false);
        cbxkieuthue.setEnabled(false);
        txtMaPhieuThue.setEnabled(false);
        txttratroc.setEnabled(false);
        txtSoNguoi.setEnabled(false);

        txtdukienCO.setEnabled(false);
        tblDichVuDaChon.setModel(tblNhapHangmd1);

    }

    public DecimalFormat getFormatter() {
        return formatter;
    }
   


    public final void initTable() {
        tblModel = new DefaultTableModel();
        String[] headerTbl = new String[]{"Mã dịch vụ", "Tên dịch vụ", "Số lượng", "Đơn giá"};
        tblModel.setColumnIdentifiers(headerTbl);
        tblDichVu.setModel(tblModel);
        tblDichVu.getColumnModel().getColumn(0).setPreferredWidth(50);
        tblDichVu.getColumnModel().getColumn(1).setPreferredWidth(200);
        tblDichVu.getColumnModel().getColumn(2).setPreferredWidth(50);
        tblDichVu.getColumnModel().getColumn(3).setPreferredWidth(20);

    }

    public final void dichvudachon() {
        tblNhapHangmd1 = new DefaultTableModel();
        String[] headerTbl = new String[]{  "Tên dịch vụ", "Số lượng", "Đơn giá"};
        tblNhapHangmd1.setColumnIdentifiers(headerTbl);
        tblDichVuDaChon.setModel(tblNhapHangmd1);
         tblDichVuDaChon.getColumnModel().getColumn(0).setPreferredWidth(200);
        tblDichVuDaChon.getColumnModel().getColumn(1).setPreferredWidth(50);
       
        tblDichVuDaChon.getColumnModel().getColumn(2).setPreferredWidth(50);
      
      

    }

    private void loadDataToTableProduct(ArrayList<DichVu> arrProd) {
        try {
            tblModel.setRowCount(0);
            for (var i : arrProd) {
                tblModel.addRow(new Object[]{
                    i.getMaDichVu(), i.getTenDichVu(), i.getSoLuong(), formatter.format(i.getGia())
                });
            }
        } catch (Exception e) {
        }
    }

    

    private void displayInfo() {
        ChiTietHoaDonPhong a = parent.getNhaCungCapSelect();
             txttenKH.setText(a.getTenKH());
        txtmaKH.setText(a.getMaKH());
      
        txtcmtkh.setText(a.getCmtKH());

        cbxgioitinh.setSelectedIndex(a.isGioiTinhKH() ? 1 : 0);
        cbxkieuthue.setSelectedIndex(a.isHinhThucThue() ? 1 : 0);
        txtSDT.setText(a.getSdtKH());
        txtDCKH.setText(a.getDiaChi());
        txtDATEKH.setText(a.getNgaySinhKH());

        txtTenNhanVien.setText(a.getTenNV());

        txttimenhanphong.setText(formatDate.format(a.getCheckIn()));
     
        
        
        
        txtdukienCO.setText(a.getDuKienCheckOut());
        txtPhong.setText(a.getMaPhong());
        txtloaiphong.setText(a.getLoaiPhong());

        double donGiaPhong = a.getDonGiaPhong();
        String formattedDonGiaPhong = formatter.format(donGiaPhong);
        txtdongiaPhong.setText(formattedDonGiaPhong);

        double phuThu = a.getPhuThu();
        String formattedPhuThu = formatter.format(phuThu);
        txtphuthu.setText(formattedPhuThu);


        double duaTruoc = a.getDuaTruoc();
        String formattedDuaTruoc = formatter.format(duaTruoc);
        txttratroc.setText(formattedDuaTruoc);

        txtMaPhieuThue.setText(a.getMaPhieuThuePhong());
        txtSoNguoi.setText(Integer.toString(a.getSoNguoi()));


    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txttenKH = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtcmtkh = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtDCKH = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtDATEKH = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtmaKH = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        cbxgioitinh = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        txtloaiphong = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txttimenhanphong = new javax.swing.JTextField();
        txttimenhanphong.setEnabled(false)
        ;
        jLabel11 = new javax.swing.JLabel();
        txtdongiaPhong = new javax.swing.JTextField()
        ;
        txtPhong = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cbxkieuthue = new javax.swing.JComboBox<>();
        txttratroc = new javax.swing.JTextField();
        txttimenhanphong.setEnabled(false)
        ;
        jLabel12 = new javax.swing.JLabel();
        txtSoNguoi = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtMaPhieuThue = new javax.swing.JTextField()

        ;
        jLabel14 = new javax.swing.JLabel();
        txtphuthu = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtTenNhanVien = new javax.swing.JTextField();
        txtTenNhanVien.setEnabled(false)
        ;
        jLabel3 = new javax.swing.JLabel();
        txthehe = new javax.swing.JLabel();
        txtdukienCO = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDichVu = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDichVuDaChon = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        btnCancel = new javax.swing.JButton();
        btnDatPhong = new javax.swing.JButton();
        addDichVu = new javax.swing.JButton();
        deleteDV = new javax.swing.JButton();
        txtSoLuong = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Chỉnh sửa sản phẩm");
        setPreferredSize(new java.awt.Dimension(1200, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 700));

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin khách hàng"));
        jPanel8.setPreferredSize(new java.awt.Dimension(462, 350));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Tên khách hàng:");

        txttenKH.setPreferredSize(new java.awt.Dimension(200, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("CCCD/CMND :");

        txtcmtkh.setPreferredSize(new java.awt.Dimension(200, 30));
        txtcmtkh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcmtkhActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("Giới tính :");

        txtSDT.setPreferredSize(new java.awt.Dimension(200, 30));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setText("Số điện thoại :");

        txtDCKH.setPreferredSize(new java.awt.Dimension(200, 30));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText("Địa chỉ :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Ngày sinh :");

        txtmaKH.setPreferredSize(new java.awt.Dimension(200, 30));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setText("Mã khách hàng :");

        cbxgioitinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
        cbxgioitinh.setPreferredSize(new java.awt.Dimension(200, 30));
        cbxgioitinh.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxgioitinhItemStateChanged(evt);
            }
        });
        cbxgioitinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxgioitinhActionPerformed(evt);
            }
        });
        cbxgioitinh.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cbxgioitinhPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel21)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel20))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtmaKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txttenKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtcmtkh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDATEKH)
                        .addComponent(txtDCKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSDT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(cbxgioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtmaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txttenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13)
                            .addComponent(txtcmtkh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxgioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSDT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDCKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDATEKH, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin phòng"));
        jPanel7.setPreferredSize(new java.awt.Dimension(694, 324));

        txtloaiphong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtloaiphong.setPreferredSize(new java.awt.Dimension(200, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Loại phòng :");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Thời gian nhận  :");

        txttimenhanphong.setPreferredSize(new java.awt.Dimension(200, 30));
        txttimenhanphong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttimenhanphongActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Đơn giá  :");

        txtdongiaPhong.setPreferredSize(new java.awt.Dimension(200, 30));
        txtdongiaPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdongiaPhongActionPerformed(evt);
            }
        });

        txtPhong.setEditable(false);
        txtPhong.setPreferredSize(new java.awt.Dimension(200, 30));
        txtPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhongActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Mã phòng:");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Hình thức thuê :");

        cbxkieuthue.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thuê theo giờ", "Thuê theo ngày" }));
        cbxkieuthue.setPreferredSize(new java.awt.Dimension(200, 30));
        cbxkieuthue.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxkieuthueItemStateChanged(evt);
            }
        });
        cbxkieuthue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxkieuthueActionPerformed(evt);
            }
        });

        txttratroc.setPreferredSize(new java.awt.Dimension(200, 30));
        txttratroc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttratrocActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Trả trước : ");

        txtSoNguoi.setPreferredSize(new java.awt.Dimension(200, 30));
        txtSoNguoi.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSoNguoiFocusLost(evt);
            }
        });
        txtSoNguoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoNguoiActionPerformed(evt);
            }
        });
        txtSoNguoi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSoNguoiKeyReleased(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Số người :");

        txtMaPhieuThue.setPreferredSize(new java.awt.Dimension(200, 30));
        txtMaPhieuThue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaPhieuThueActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Mã phiếu thuê :");

        txtphuthu.setPreferredSize(new java.awt.Dimension(200, 30));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setText("Phụ thu :");

        txtTenNhanVien.setPreferredSize(new java.awt.Dimension(200, 30));
        txtTenNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenNhanVienActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Nhân viên thực hiện :");

        txthehe.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txthehe.setText("/");

        txtdukienCO.setPreferredSize(new java.awt.Dimension(200, 30));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setText("Dự kiến trả :");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSoNguoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(jLabel11))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(139, 139, 139)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMaPhieuThue, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel22))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txttimenhanphong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxkieuthue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtdukienCO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel10)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel23))))))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(txtdongiaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txthehe, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtloaiphong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                                .addComponent(txtPhong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txttratroc, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                            .addComponent(txtphuthu, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(txtPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtMaPhieuThue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtloaiphong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoNguoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel11)
                    .addComponent(txtdongiaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txthehe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txttimenhanphong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(txttratroc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbxkieuthue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel23))
                            .addComponent(jLabel16))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(txtdukienCO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtphuthu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Chọn dịch vụ"));

        tblDichVu.setFont(tblDichVu.getFont().deriveFont((float)15));
        tblDichVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã dịch vụ", "Tên dịch vụ", "Tồn kho", "Đơn giá"
            }
        ));
        tblDichVu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(tblDichVu);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Dịch vụ đã chọn"));

        tblDichVuDaChon.setFont(tblDichVuDaChon.getFont().deriveFont((float)15));
        tblDichVuDaChon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã dịch vụ", "Tên dịch vụ", "Số lượn", "Đơn giá"
            }
        ));
        jScrollPane1.setViewportView(tblDichVuDaChon);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnCancel.setBackground(new java.awt.Color(51, 51, 51));
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Huỷ bỏ");
        btnCancel.setBorder(null);
        btnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancel.setPreferredSize(new java.awt.Dimension(103, 29));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnDatPhong.setBackground(new java.awt.Color(153, 0, 51));
        btnDatPhong.setForeground(new java.awt.Color(255, 255, 255));
        btnDatPhong.setText("Lưu");
        btnDatPhong.setBorder(null);
        btnDatPhong.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDatPhong.setPreferredSize(new java.awt.Dimension(103, 29));
        btnDatPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatPhongActionPerformed(evt);
            }
        });

        addDichVu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        addDichVu.setText("Thêm");
        addDichVu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.lightGray, null, null));
        addDichVu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addDichVu.setPreferredSize(new java.awt.Dimension(103, 29));
        addDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDichVuActionPerformed(evt);
            }
        });

        deleteDV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_delete_25px_1.png"))); // NOI18N
        deleteDV.setText("Xoá dịch vụ");
        deleteDV.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.lightGray, null, null));
        deleteDV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteDV.setPreferredSize(new java.awt.Dimension(103, 29));
        deleteDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteDVActionPerformed(evt);
            }
        });

        txtSoLuong.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSoLuong.setText("1");
        txtSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoLuongActionPerformed(evt);
            }
        });

        jLabel9.setText("Số lượng dịch vụ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel9)
                .addGap(4, 4, 4)
                .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deleteDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDatPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(btnDatPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 25, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 60, 1220, -1));

        jPanel2.setBackground(new java.awt.Color(153, 0, 51));
        jPanel2.setPreferredSize(new java.awt.Dimension(1191, 60));

        jLabel1.setFont(new java.awt.Font("SF Pro Display", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CẬP NHẬT THÔNG TIN PHIẾU THUÊ PHÒNG");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(417, 417, 417)
                .addComponent(jLabel1)
                .addContainerGap(276, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, -1));

        getAccessibleContext().setAccessibleName("Chỉnh sửa phiếu đặt");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTenNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenNhanVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenNhanVienActionPerformed

    private void txtMaPhieuThueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaPhieuThueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaPhieuThueActionPerformed

    private void txtSoNguoiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoNguoiKeyReleased

    }//GEN-LAST:event_txtSoNguoiKeyReleased

    private void txtSoNguoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoNguoiActionPerformed

    }//GEN-LAST:event_txtSoNguoiActionPerformed

    private void txtSoNguoiFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSoNguoiFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoNguoiFocusLost

    private void txttratrocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttratrocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttratrocActionPerformed

    private void cbxkieuthueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxkieuthueActionPerformed
       
    }//GEN-LAST:event_cbxkieuthueActionPerformed

    private void cbxkieuthueItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxkieuthueItemStateChanged

    }//GEN-LAST:event_cbxkieuthueItemStateChanged

    private void txtPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhongActionPerformed

    private void txtdongiaPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdongiaPhongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdongiaPhongActionPerformed

    private void txttimenhanphongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttimenhanphongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttimenhanphongActionPerformed

    private void cbxgioitinhPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cbxgioitinhPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxgioitinhPropertyChange

    private void cbxgioitinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxgioitinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxgioitinhActionPerformed

    private void cbxgioitinhItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxgioitinhItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxgioitinhItemStateChanged

    private void txtcmtkhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcmtkhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcmtkhActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnDatPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatPhongActionPerformed

    }//GEN-LAST:event_btnDatPhongActionPerformed
 public void loadDataToTableProduct1() {
        try {
            // Initialize or update the global variable huhu
            huhu = ChiTietHoaDonDichVuDAO.getInstance().selectAll1(this.parent.getNhaCungCapSelect().getMaPhieuThuePhong());
            DefaultTableModel tblNhapHangmd1 = (DefaultTableModel) tblDichVuDaChon.getModel();
            tblNhapHangmd1.setRowCount(0); // Xóa các hàng hiện có trong bảng

            for (ChiTietHoaDonDichVu cthddv : huhu) {
                tblNhapHangmd1.addRow(new Object[]{
                    cthddv.getMaDichvu(),
                    cthddv.getSoLuong(),
                    formatter.format(cthddv.getDonGia())
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDichVuActionPerformed
 int i_row = tblDichVu.getSelectedRow();
    if (i_row == -1) {
        JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm để nhập hàng!");
    } else {
        try {
            int soluong = Integer.parseInt(txtSoLuong.getText().trim());
            if (soluong > 0) {
                // Lấy mã dịch vụ từ bảng và kiểm tra
                String maDichVu = (String) tblDichVu.getValueAt(i_row, 0);
                if (maDichVu == null || maDichVu.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Mã dịch vụ không hợp lệ!");
                    return;
                }
                
                ChiTietHoaDonDichVu existingService = findCTPhieu(maDichVu);
                if (existingService != null) {
                    existingService.setSoLuong(existingService.getSoLuong() + soluong);
                } else {
                    DichVu newService = SearchDichVu.getInstance().searchId(maDichVu);
                    if (newService == null) {
                        JOptionPane.showMessageDialog(this, "Không tìm thấy dịch vụ!");
                        return;
                    }
                    ChiTietHoaDonDichVu newDetail = new ChiTietHoaDonDichVu(newService.getMaDichVu(), soluong, newService.getGia());
                    huhu.add(newDetail);
                }

                // In danh sách `huhu` ra console
                printHuhuList();
                
                // Lấy mã hóa đơn từ trường `txtMaPhieuThue`
                String maHoaDon = txtMaPhieuThue.getText().trim();
                if (maHoaDon.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Mã phiếu thuê không hợp lệ!");
                    return;
                }
                
                // Cập nhật cơ sở dữ liệu với danh sách `huhu` đã cập nhật
                ChiTietHoaDonDichVuDAO.getInstance().updateByMaHoaDon(maHoaDon, huhu);
                
                // Tải lại bảng với dữ liệu mới
                loadDataToTableProduct1();
            } else {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng lớn hơn 0");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng ở dạng số nguyên!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    }//GEN-LAST:event_addDichVuActionPerformed
private void printHuhuList() {
    for (ChiTietHoaDonDichVu product : huhu) {
        System.out.println("MaDichVu: " + product.getMaDichvu() + 
                           ", SoLuong: " + product.getSoLuong() + 
                           ", DonGia: " + product.getDonGia());
    }
}private ChiTietHoaDonDichVu findCTPhieu(String maDichVu) {
    for (ChiTietHoaDonDichVu ctp : huhu) {
    	 if (maDichVu.equals(ctp.getMaDichvu())) {
            return ctp;
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
    private void deleteDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteDVActionPerformed
  // TODO add your handling code here:
        int i_row = tblDichVuDaChon.getSelectedRow();
        if (i_row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm để xoá khỏi bảng xuất hàng !");
        } else {
            huhu.remove(i_row);
            for (ChiTietHoaDonDichVu product : huhu) {
                    System.out.println("MaDichVu: " + product.getMaDichvu() + 
                                       ", SoLuong: " + product.getSoLuong() + 
                                       ", DonGia: " + product.getDonGia());
                }
          String maHoaDon = txtMaPhieuThue.getText().trim();
        
        // Cập nhật cơ sở dữ liệu với danh sách `huhu` đã cập nhật
        ChiTietHoaDonDichVuDAO.getInstance().updateByMaHoaDon(maHoaDon, huhu);
        loadDataToTableProduct1();

        }
    }//GEN-LAST:event_deleteDVActionPerformed

    private void txtSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoLuongActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws UnsupportedLookAndFeelException {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(new FlatLightLaf());
                } catch (UnsupportedLookAndFeelException e) {
                    e.printStackTrace();
                }
                DatPhong dialog = new DatPhong(new javax.swing.JInternalFrame(), new javax.swing.JFrame(), true);
                dialog.setSize(400, 300); // Thiết lập kích thước
                dialog.setLocationRelativeTo(null); // Đặt vị trí hiển thị
                dialog.setVisible(true);

            }
        });

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addDichVu;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDatPhong;
    private javax.swing.JComboBox<String> cbxgioitinh;
    private javax.swing.JComboBox<String> cbxkieuthue;
    private javax.swing.JButton deleteDV;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblDichVu;
    private javax.swing.JTable tblDichVuDaChon;
    private javax.swing.JTextField txtDATEKH;
    private javax.swing.JTextField txtDCKH;
    private javax.swing.JTextField txtMaPhieuThue;
    private javax.swing.JTextField txtPhong;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtSoNguoi;
    private javax.swing.JTextField txtTenNhanVien;
    private javax.swing.JTextField txtcmtkh;
    private javax.swing.JTextField txtdongiaPhong;
    private javax.swing.JTextField txtdukienCO;
    private javax.swing.JLabel txthehe;
    private javax.swing.JTextField txtloaiphong;
    private javax.swing.JTextField txtmaKH;
    private javax.swing.JTextField txtphuthu;
    private javax.swing.JTextField txttenKH;
    private javax.swing.JTextField txttimenhanphong;
    private javax.swing.JTextField txttratroc;
    // End of variables declaration//GEN-END:variables

   

    public DichVu findDichVu(String maDichVu) {
        for (var i : sanPham) {
            if (maDichVu.equals(i.getMaDichVu())) {
                return i;
            }
        }
        return null;

    }
}

   
