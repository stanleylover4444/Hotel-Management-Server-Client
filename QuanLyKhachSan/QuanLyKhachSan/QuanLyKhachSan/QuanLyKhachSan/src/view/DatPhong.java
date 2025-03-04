/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import com.formdev.flatlaf.FlatLightLaf;
import component.ThoiGianVao;
import component.ThongTinTaiKhoan;
import controller.SearchDichVu;

import dao.ChiTietHoaDonDichVuDAO;
import dao.ChiTietHoaDonPhongDAO;
import dao.DichVuDAO;

import dao.HoaDonDichVuDAO;
import dao.HoaDonPhongDAO;
import dao.KhachHangDAO;
import dao.PhongDAO;

import java.sql.Timestamp;

import java.awt.CardLayout;
import java.awt.Color;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import listener.DatPhongListener;
import model.ChiTietHoaDonDichVu;
import model.ChiTietHoaDonPhong;
import model.HoaDonDichVu;

import model.DichVu;

import model.HoaDonPhong;
import model.KhachHang;
import model.Phong;
import static org.apache.poi.util.DocumentFormatException.check;
import static org.apache.poi.util.RecordFormatException.check;

public class DatPhong extends javax.swing.JDialog {

    private DefaultTableModel tblModel;
    private ArrayList<DichVu> dichvu = DichVuDAO.getInstance().selectAll();
    private QuanLiPhongForm homeAcc;

    String maDichvu = null;
    int soLuong = 0;
    double donGiaDV = 0;
    private QuanLiKhachHangForm tk1;
// Các regex


    private ArrayList<DichVu> sanPham;
    private ArrayList<ChiTietHoaDonPhong> CTHDP;
    private ArrayList<ChiTietHoaDonDichVu> CTHDDV;

    double phuThu = 0;
    double duaTruoc = 0;
    double tongtienDV = 0;
    private String MaHoaDonPhong;

  SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    DecimalFormat formatter = new DecimalFormat("###,###,###");

    private DatPhongListener datPhongListener;

    public void setDatPhongListener(DatPhongListener datPhongListener) {
        this.datPhongListener = datPhongListener;
    }

    public DatPhong(javax.swing.JInternalFrame parent, javax.swing.JFrame owner, boolean modal) {
        super(owner, modal);
        initComponents();
        setLocationRelativeTo(null);
        initTable(); // Khởi tạo bảng trước khi tải dữ liệu
        this.CTHDDV = new ArrayList<>();
        tblDichVu.setDefaultEditor(Object.class, null);
        tblDichVuDaChon.setDefaultEditor(Object.class, null);
        sanPham = DichVuDAO.getInstance().selectAllExist();
        long now = System.currentTimeMillis();
        Timestamp sqlTimestamp = new Timestamp(now);

        loadDataToTableProduct(dichvu);
        homeAcc = (QuanLiPhongForm) parent;

       
        txtloaiphong.setEditable(false);
        txtdongiaPhong.setEditable(false);
        txtmaKH.setEditable(false);
        txtMaPhieuThue.setEditable(false);
        
        
         txtmaKH.setText(createKH1());
       txtMaPhieuThue.setText(createKH());
       
        
          
    }
    
    


    private DatPhong(JFrame jFrame, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public DecimalFormat getFormatter() {
        return formatter;
    }

    public SimpleDateFormat getFormatDate() {
        return formatDate;
    }

    public final void initTable() {
        tblModel = new DefaultTableModel();
        String[] headerTbl = new String[]{"Mã dịch vụ", "Tên dịch vụ", "Số lượng", "Đơn giá"};
        tblModel.setColumnIdentifiers(headerTbl);
        tblDichVu.setModel(tblModel);
        tblDichVu.getColumnModel().getColumn(0).setPreferredWidth(50);
        tblDichVu.getColumnModel().getColumn(1).setPreferredWidth(200);
        tblDichVu.getColumnModel().getColumn(2).setPreferredWidth(50);
        tblDichVu.getColumnModel().getColumn(0).setPreferredWidth(20);

    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException {

        /* Create and display the dialog */
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtTongTienDichVu = new javax.swing.JTextField();

        ;
        txtTongTienDichVu = new javax.swing.JTextField();

        ;
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnCancel = new javax.swing.JButton();
        btnDatPhong = new javax.swing.JButton();
        addDichVu = new javax.swing.JButton();
        deleteDV = new javax.swing.JButton();
        editSLDV = new javax.swing.JButton();
        txtSoLuong = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDichVu = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDichVuDaChon = new javax.swing.JTable();
        txthehe = new javax.swing.JPanel();
        txtloaiphong = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txttimenhanphong = new javax.swing.JTextField();
        txttimenhanphong.setEnabled(false)
        ;
        jLabel11 = new javax.swing.JLabel();
        txtdongiaPhong = new javax.swing.JTextField();
        txtTongTienDichVu.setEditable(false)
        ;
        txtPhong = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cbxkieuthue = new javax.swing.JComboBox<>();
        txttratruoc = new javax.swing.JTextField();
        txttimenhanphong.setEnabled(false)
        ;
        jLabel12 = new javax.swing.JLabel();
        txtSoNguoi = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtMaPhieuThue = new javax.swing.JTextField();
        txtTongTienDichVu.setEditable(false)
        ;
        jLabel13 = new javax.swing.JLabel();
        txtphuthu = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtTenNhanVien = new javax.swing.JTextField();
        txtTenNhanVien.setEnabled(false)
        ;
        jLabel3 = new javax.swing.JLabel();
        txthehe1 = new javax.swing.JLabel();
        txtdukienCO = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txttenKH = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        txtTongTienDichVu.setPreferredSize(new java.awt.Dimension(200, 30));
        txtTongTienDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongTienDichVuActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Thêm sản phẩm mới");
        setPreferredSize(new java.awt.Dimension(1200, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 700));

        jPanel3.setLayout(new java.awt.CardLayout());

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
        btnDatPhong.setText("Đặt phòng");
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

        editSLDV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_edit_25px.png"))); // NOI18N
        editSLDV.setText("Sửa số lượng");
        editSLDV.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.lightGray, null, null));
        editSLDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editSLDVActionPerformed(evt);
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
                .addGap(18, 18, 18)
                .addComponent(editSLDV)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDatPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editSLDV)
                    .addComponent(deleteDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(btnDatPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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
        if (tblDichVu.getColumnModel().getColumnCount() > 0) {
            tblDichVu.getColumnModel().getColumn(0).setPreferredWidth(40);
        }

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

        txthehe.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin phòng"));

        txtloaiphong.setPreferredSize(new java.awt.Dimension(200, 30));
        txtloaiphong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtloaiphongActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Loại phòng :");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Thời gian nhận :");

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
        jLabel2.setText("Mã phòng :");

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
        cbxkieuthue.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cbxkieuthuePropertyChange(evt);
            }
        });

        txttratruoc.setPreferredSize(new java.awt.Dimension(200, 30));
        txttratruoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttratruocActionPerformed(evt);
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

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Mã phiếu thuê :");

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

        txthehe1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txthehe1.setText("/");

        txtdukienCO.setPreferredSize(new java.awt.Dimension(200, 30));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setText("Dự kiến trả :");

        javax.swing.GroupLayout txtheheLayout = new javax.swing.GroupLayout(txthehe);
        txthehe.setLayout(txtheheLayout);
        txtheheLayout.setHorizontalGroup(
            txtheheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtheheLayout.createSequentialGroup()
                .addGroup(txtheheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(txtheheLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(txtheheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel15)
                            .addComponent(jLabel13)
                            .addComponent(jLabel7))
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, txtheheLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(txtheheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel22)
                            .addComponent(jLabel16))
                        .addGap(18, 18, 18)))
                .addGroup(txtheheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(txtheheLayout.createSequentialGroup()
                        .addGroup(txtheheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, txtheheLayout.createSequentialGroup()
                                .addComponent(txtSoNguoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, txtheheLayout.createSequentialGroup()
                                .addComponent(txtMaPhieuThue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(txtheheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(txtheheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(txtheheLayout.createSequentialGroup()
                                .addComponent(txtdongiaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(txthehe1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(txtheheLayout.createSequentialGroup()
                                .addComponent(txtloaiphong, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(txtheheLayout.createSequentialGroup()
                        .addGroup(txtheheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtdukienCO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(txtheheLayout.createSequentialGroup()
                                .addComponent(txtTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, txtheheLayout.createSequentialGroup()
                        .addGroup(txtheheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(txtheheLayout.createSequentialGroup()
                                .addComponent(cbxkieuthue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(jLabel23)
                                .addGap(18, 18, 18)
                                .addComponent(txtphuthu, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                            .addGroup(txtheheLayout.createSequentialGroup()
                                .addComponent(txttimenhanphong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txttratruoc, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(29, 29, 29))))
        );
        txtheheLayout.setVerticalGroup(
            txtheheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtheheLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(txtheheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(txtheheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2))
                    .addComponent(txtPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(txtheheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(txtheheLayout.createSequentialGroup()
                        .addGroup(txtheheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(txtloaiphong, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(txtheheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtdongiaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSoNguoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txthehe1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(80, 80, 80))
                    .addGroup(txtheheLayout.createSequentialGroup()
                        .addGroup(txtheheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtMaPhieuThue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15)
                        .addGap(28, 28, 28)
                        .addGroup(txtheheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txttimenhanphong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel12)
                            .addComponent(txttratruoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)))
                .addGroup(txtheheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxkieuthue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel23)
                    .addComponent(txtphuthu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(txtheheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(txtdukienCO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin khách hàng"));
        jPanel8.setPreferredSize(new java.awt.Dimension(462, 350));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Tên khách hàng:");

        txttenKH.setPreferredSize(new java.awt.Dimension(200, 30));
        txttenKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttenKHActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("CCCD/CMND :");

        txtcmtkh.setPreferredSize(new java.awt.Dimension(200, 30));
        txtcmtkh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcmtkhActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("Giới tính :");

        txtSDT.setFont(txtSDT.getFont().deriveFont((float)12));
        txtSDT.setPreferredSize(new java.awt.Dimension(200, 30));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setText("Số điện thoại :");

        txtDCKH.setFont(txtDCKH.getFont().deriveFont((float)12));
        txtDCKH.setPreferredSize(new java.awt.Dimension(200, 30));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText("Địa chỉ :");

        txtDATEKH.setFont(txtDATEKH.getFont());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Ngày sinh :");

        txtmaKH.setFont(txtmaKH.getFont());
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))))))
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
                .addContainerGap(73, Short.MAX_VALUE))
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
                            .addComponent(jLabel5)
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
                .addContainerGap(56, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1160, 1160, 1160)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 32, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txthehe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                    .addComponent(txthehe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(126, 126, 126))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, -1, -1));

        jPanel2.setBackground(new java.awt.Color(153, 0, 51));

        jLabel1.setFont(new java.awt.Font("SF Pro Display", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("NHẬP THÔNG TIN ĐẶT PHÒNG");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(441, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(394, 394, 394))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 60));

        getAccessibleContext().setAccessibleName("Đặt phòng");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editSLDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editSLDVActionPerformed
        // TODO add your handling code here:
        int i_row = tblDichVuDaChon.getSelectedRow();
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
    }//GEN-LAST:event_editSLDVActionPerformed

    private void deleteDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteDVActionPerformed
        // TODO add your handling code here:
        int i_row = tblDichVuDaChon.getSelectedRow();
        if (i_row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm để xoá khỏi bảng xuất hàng !");
        } else {
            CTHDDV.remove(i_row);
            loadDataToTableNhapHang();

        }
    }//GEN-LAST:event_deleteDVActionPerformed

    private void addDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDichVuActionPerformed

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
                    soluong = Integer.parseInt(txtSoLuong.getText());

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
                                ChiTietHoaDonDichVu ctp = new ChiTietHoaDonDichVu(MaHoaDonPhong, mt.getMaDichVu(), soluong, mt.getGia());
                                CTHDDV.add(ctp);
                            }
                            loadDataToTableNhapHang();

                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng lớn hơn 0");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng ở dạng số nguyên!");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }//GEN-LAST:event_addDichVuActionPerformed

    private void btnDatPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatPhongActionPerformed
    String maKh = txtmaKH.getText().trim();
    String tenKh = txttenKH.getText().trim();
    String cmtKH = txtcmtkh.getText().trim();
    String sdtKh = txtSDT.getText().trim();
    String ngaySinhKH = txtDATEKH.getText().trim();
    String diachiKh = txtDCKH.getText().trim();
    int soNguoi = 0;
    
    // Kiểm tra các trường không được để trống
    if ( tenKh.isEmpty() || cmtKH.isEmpty() || 
        ngaySinhKH.isEmpty() || diachiKh.isEmpty() || txtSoNguoi.getText().trim().isEmpty() || 
        txtTenNhanVien.getText().trim().isEmpty() || txtMaPhieuThue.getText().trim().isEmpty() || 
        txtPhong.getText().trim().isEmpty() || txtdongiaPhong.getText().trim().isEmpty() || 
        txttimenhanphong.getText().trim().isEmpty() || 
        txtloaiphong.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin !", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
        return;
    }

    try {
        soNguoi = Integer.parseInt(txtSoNguoi.getText().trim());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Số người phải là một số nguyên hợp lệ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    String tenNV = txtTenNhanVien.getText().trim();
    String maPhieuThuePhong = txtMaPhieuThue.getText().trim();
    String maPhong = txtPhong.getText().trim();
    boolean gioiTinhKH = (cbxgioitinh.getSelectedIndex() == 1);
    boolean hinhThucThue = (cbxkieuthue.getSelectedIndex() == 1);
    String donGiaPhongStr = txtdongiaPhong.getText().trim();
    double donGiaPhong;
    try {
        donGiaPhong = formatter.parse(donGiaPhongStr).doubleValue();
    } catch (ParseException e) {
        e.printStackTrace();
        donGiaPhong = 0; 
    }

    Timestamp checkIN = null;
    try {
        checkIN = Timestamp.valueOf(txttimenhanphong.getText());
    } catch (IllegalArgumentException e) {
        JOptionPane.showMessageDialog(this, "Thời gian nhận phòng không hợp lệ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return;
    }
    String duKienCheckOut = txtdukienCO.getText().trim();
    String loaiPhong = txtloaiphong.getText().trim();
    double duaTruoc;
    try {
        duaTruoc = Double.parseDouble(txttratruoc.getText().trim());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Số tiền trả trước không hợp lệ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    String phuThuStr = txtphuthu.getText().trim();
    double phuThu;
    try {
        phuThu = formatter.parse(phuThuStr).doubleValue();
    } catch (ParseException e) {           
        e.printStackTrace();           
        phuThu = 0; 
    }

    // Kiểm tra tính hợp lệ của các trường đầu vào
    if (!maKh.matches("^[a-zA-Z0-9]+$")) {
        JOptionPane.showMessageDialog(this, "Mã khách hàng không hợp lệ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    if (!tenKh.matches("^[\\p{L} .'-]+$")) {
        JOptionPane.showMessageDialog(this, "Tên khách hàng không hợp lệ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    if (!cmtKH.matches("^[0-9]{9,12}$")) {
        JOptionPane.showMessageDialog(this, "Chứng minh thư không hợp lệ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    if (!sdtKh.matches("^[0-9]{10}$")) {
        JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    if (!ngaySinhKH.matches("^\\d{4}-\\d{2}-\\d{2}$")) { // Giả sử ngày sinh có định dạng YYYY-MM-DD
        JOptionPane.showMessageDialog(this, "Ngày sinh không hợp lệ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    if (diachiKh.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Địa chỉ không được để trống.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    // Sau khi kiểm tra các trường không trống và hợp lệ
    KhachHang kh1 = new KhachHang();

    kh1.setMaKhachHang(maKh);
    kh1.setTenKhachHang(tenKh);
    kh1.setSoDienThoai(sdtKh);
    kh1.setDiaChi(diachiKh);
    kh1.setNgaySinh(ngaySinhKH);
    kh1.setChungMinhThu(cmtKH);
    kh1.setGioiTinh(gioiTinhKH);

    KhachHangDAO.getInstance().insert(kh1);

    ChiTietHoaDonPhong kh = new ChiTietHoaDonPhong();
    kh.setMaKH(maKh);
    kh.setTenKH(tenKh);
    kh.setSdtKH(sdtKh);
    kh.setDiaChi(diachiKh);
    kh.setNgaySinhKH(ngaySinhKH);
    kh.setCmtKH(cmtKH);
    kh.setGioiTinhKH(gioiTinhKH);
    kh.setTenNV(tenNV);
    kh.setMaPhieuThuePhong(maPhieuThuePhong);
    kh.setMaPhong(maPhong);
    kh.setHinhThucThue(hinhThucThue);
    kh.setLoaiPhong(loaiPhong);
    kh.setDuKienCheckOut(duKienCheckOut);
    kh.setDonGiaPhong(donGiaPhong);
    kh.setSoNguoi(soNguoi);

    long now = System.currentTimeMillis();
    Timestamp sqlTimestamp = new Timestamp(now);

    kh.setCheckIn(checkIN);
    kh.setDuaTruoc(duaTruoc);
    kh.setPhuThu(phuThu);

    DichVuDAO dvdao = DichVuDAO.getInstance();
    ChiTietHoaDonPhongDAO.getInstance().insert(kh);
    for (var i : CTHDDV) {
        i.setMaHoaDon(kh.getMaPhieuThuePhong());
        ChiTietHoaDonDichVuDAO.getInstance().insert(i);
        dvdao.updateSoLuong(i.getMaDichvu(), dvdao.selectById(i.getMaDichvu()).getSoLuong() - i.getSoLuong());
    }

    int updated = PhongDAO.getInstance().updateTrangThai(maPhong, "Có Khách");
    JOptionPane.showMessageDialog(this, "Thêm thành công !");
    homeAcc.loadDataToTablePhong(PhongDAO.getInstance().selectAll());
    homeAcc.loadDateToTablePTP(ChiTietHoaDonPhongDAO.getInstance().selectAll());
    homeAcc.setColorForPanels();
    this.dispose();
    }//GEN-LAST:event_btnDatPhongActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        CTHDDV.clear();        // TODO add your handling code here:
        xoaRong();
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void txtcmtkhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcmtkhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcmtkhActionPerformed

    private void txtTenNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenNhanVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenNhanVienActionPerformed

    private void txttimenhanphongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttimenhanphongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttimenhanphongActionPerformed

    private void txtdongiaPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdongiaPhongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdongiaPhongActionPerformed

    private void txtTongTienDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongTienDichVuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongTienDichVuActionPerformed

    private void txttratruocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttratruocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttratruocActionPerformed

    private void txtMaPhieuThueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaPhieuThueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaPhieuThueActionPerformed

    private void txtSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoLuongActionPerformed

    private void cbxgioitinhItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxgioitinhItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxgioitinhItemStateChanged

    private void cbxgioitinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxgioitinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxgioitinhActionPerformed

    private void cbxgioitinhPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cbxgioitinhPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxgioitinhPropertyChange

    private void txtSoNguoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoNguoiActionPerformed

    }//GEN-LAST:event_txtSoNguoiActionPerformed

    private void txtSoNguoiFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSoNguoiFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoNguoiFocusLost

    private void txtSoNguoiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoNguoiKeyReleased

        // Lấy giá trị được nhập vào từ txtSoNguoi
        String soNguoiText = txtSoNguoi.getText().trim();

        // Kiểm tra xem cbxkieuthue có đang chọn "Phòng Đơn" không
        String loaiPhong = txtloaiphong.getText().trim();
        if (loaiPhong.equals("Phòng Đơn")) {
            // Kiểm tra xem giá trị nhập vào có hợp lệ không
            try {
                int soNguoi = Integer.parseInt(soNguoiText);
                if (soNguoi != 1 && soNguoi != 2) {
                    JOptionPane.showMessageDialog(this, "Vui lòng chỉ nhập số người là 1 hoặc 2.");
                    // Xóa nội dung đã nhập vào txtSoNguoi
                    txtSoNguoi.setText("");
                }
            } catch (NumberFormatException e) {

                // Xóa nội dung đã nhập vào txtSoNguoi
                txtSoNguoi.setText("");
            }
        } else if (loaiPhong.equals("Phòng Đơn VIP")) {
            // Kiểm tra xem giá trị nhập vào có hợp lệ không
            try {
                int soNguoi = Integer.parseInt(soNguoiText);
                if (soNguoi != 1 && soNguoi != 2) {
                    JOptionPane.showMessageDialog(this, "Vui lòng chỉ nhập số người là 1 hoặc 2.");
                    // Xóa nội dung đã nhập vào txtSoNguoi
                    txtSoNguoi.setText("");
                }
            } catch (NumberFormatException e) {

                // Xóa nội dung đã nhập vào txtSoNguoi
                txtSoNguoi.setText("");
            }
        } else if (loaiPhong.equals("Phòng Đôi")) {
            // Kiểm tra xem giá trị nhập vào có hợp lệ không
            try {
                int soNguoi = Integer.parseInt(soNguoiText);
                if (soNguoi != 1 && soNguoi != 2 && soNguoi != 3 && soNguoi != 4) {
                    JOptionPane.showMessageDialog(this, "Vui lòng chỉ nhập số người là 1 , 2 , 3 hoặc 4.");
                    // Xóa nội dung đã nhập vào txtSoNguoi
                    txtSoNguoi.setText("");
                }
            } catch (NumberFormatException e) {

                // Xóa nội dung đã nhập vào txtSoNguoi
                txtSoNguoi.setText("");
            }
        } else if (loaiPhong.equals("Phòng Đôi VIP")) {
            // Kiểm tra xem giá trị nhập vào có hợp lệ không
            try {
                int soNguoi = Integer.parseInt(soNguoiText);
                if (soNguoi != 1 && soNguoi != 2 && soNguoi != 3 && soNguoi != 4) {
                    JOptionPane.showMessageDialog(this, "Vui lòng chỉ nhập số người là 1 đến 4.");
                    // Xóa nội dung đã nhập vào txtSoNguoi
                    txtSoNguoi.setText("");
                }
            } catch (NumberFormatException e) {

                // Xóa nội dung đã nhập vào txtSoNguoi
                txtSoNguoi.setText("");
            }
        }


    }//GEN-LAST:event_txtSoNguoiKeyReleased

    private void cbxkieuthuePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cbxkieuthuePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxkieuthuePropertyChange

    private void cbxkieuthueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxkieuthueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxkieuthueActionPerformed

    private void cbxkieuthueItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxkieuthueItemStateChanged
        String kieuThue = (String) cbxkieuthue.getSelectedItem();
        // Lấy giá trị của loại phòng từ txtloaiphong
        String loaiPhong = txtloaiphong.getText().trim();
        String giaPhong = "0";

        if (loaiPhong.equals("Phòng Đơn") && kieuThue.equals("Thuê theo ngày")) {
            txtdongiaPhong.setText(giaPhong = "250.000");
            txthehe1.setText("/Ngày");

        } else if (loaiPhong.equals("Phòng Đơn") && kieuThue.equals("Thuê theo giờ")) {
            txtdongiaPhong.setText(giaPhong = "70.000");
            txthehe1.setText("/Giờ đầu");
        } else if (loaiPhong.equals("Phòng Đôi") && kieuThue.equals("Thuê theo ngày")) {
            txtdongiaPhong.setText(giaPhong = "400.000");
            txthehe1.setText("/Ngày");
        } else if (loaiPhong.equals("Phòng Đôi") && kieuThue.equals("Thuê theo giờ")) {
            txtdongiaPhong.setText(giaPhong = "100.000");
            txthehe1.setText("/Giờ đầu");
        } else if (loaiPhong.equals("Phòng Đơn VIP") && kieuThue.equals("Thuê theo ngày")) {
            txtdongiaPhong.setText(giaPhong = "400.000");
            txthehe1.setText("/Ngày");
        } else if (loaiPhong.equals("Phòng Đơn VIP") && kieuThue.equals("Thuê theo giờ")) {
            txtdongiaPhong.setText(giaPhong = "120.000");
            txthehe1.setText("/Giờ đầu");
        } else if (loaiPhong.equals("Phòng Đôi VIP") && kieuThue.equals("Thuê theo ngày")) {
            txtdongiaPhong.setText(giaPhong = "600.000");
            txthehe1.setText("/Ngày");
        } else if (loaiPhong.equals("Phòng Đôi VIP") && kieuThue.equals("Thuê theo giờ")) {
            txtdongiaPhong.setText(giaPhong = "170.000");
            txthehe1.setText("/Giờ đầu");
        } else {
            txtdongiaPhong.setText("");
        }
    }//GEN-LAST:event_cbxkieuthueItemStateChanged

    private void txtloaiphongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtloaiphongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtloaiphongActionPerformed

    private void txttenKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttenKHActionPerformed
   
    }//GEN-LAST:event_txttenKHActionPerformed

    private void txtPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhongActionPerformed

    public void loadDataToTableNhapHang() {
        double sum = 0;
        try {
            DefaultTableModel tblNhapHangmd = (DefaultTableModel) tblDichVuDaChon.getModel();
            tblNhapHangmd.setRowCount(0);

            for (int i = 0; i < CTHDDV.size(); i++) {
                tblNhapHangmd.addRow(new Object[]{
                    i + 1, CTHDDV.get(i).getMaDichvu(), findDichVu(CTHDDV.get(i).getMaDichvu()).getTenDichVu(), CTHDDV.get(i).getSoLuong(), formatter.format(CTHDDV.get(i).getDonGia())
                });
                sum += CTHDDV.get(i).getDonGia();
            }
        } catch (Exception e) {
            // Xử lý lỗi ở đây bằng cách log hoặc báo cáo thông báo lỗi
            e.printStackTrace();
        }

    }

    public void setNguoiTao() {
        txtTenNhanVien.setText(ThongTinTaiKhoan.getTaiKhoan().getTenNV());
    }

    public void setThoiGianNhanPhong() {
        ThoiGianVao.setTimeVao(txttimenhanphong);
    }

    public void setMaPhong(String tenPhong) {
        txtPhong.setText(tenPhong);
    }

    public void setLoaiPhong(String loaiPhong) {
        txtloaiphong.setText(loaiPhong);
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

    private void xoaRong() {

        txtmaKH.setText(createKH1());
        txtMaPhieuThue.setText(createKH());
        txttenKH.setText("");
        txtcmtkh.setText("");
        txtSDT.setText("");
        txtDATEKH.setText("");
        txtDCKH.setText("");
        txtSoNguoi.setText("");
        txtTenNhanVien.setText("");

       
        txttratruoc.setText("");
        txtdongiaPhong.setText("");
        txttimenhanphong.setText("");
        txtloaiphong.setText("");

        txttratruoc.setText("");
        txtphuthu.setText("");
        maDichvu = null;
        soLuong = 0;
        donGiaDV = 0;
        DefaultTableModel tblNhapHangmd = (DefaultTableModel) tblDichVuDaChon.getModel();
        tblNhapHangmd.setRowCount(0);
    }

    @Override
    public void setVisible(boolean b) {
        if (!b) {
            xoaRong();
        }
        super.setVisible(b);
    }

    @Override
    public void dispose() {
        CTHDDV.clear();
        xoaRong();
        super.dispose();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addDichVu;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDatPhong;
    private javax.swing.JComboBox<String> cbxgioitinh;
    private javax.swing.JComboBox<String> cbxkieuthue;
    private javax.swing.JButton deleteDV;
    private javax.swing.JButton editSLDV;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
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
    private javax.swing.JTextField txtTongTienDichVu;
    private javax.swing.JTextField txtcmtkh;
    private javax.swing.JTextField txtdongiaPhong;
    private javax.swing.JTextField txtdukienCO;
    private javax.swing.JPanel txthehe;
    private javax.swing.JLabel txthehe1;
    private javax.swing.JTextField txtloaiphong;
    private javax.swing.JTextField txtmaKH;
    private javax.swing.JTextField txtphuthu;
    private javax.swing.JTextField txttenKH;
    private javax.swing.JTextField txttimenhanphong;
    private javax.swing.JTextField txttratruoc;
    // End of variables declaration//GEN-END:variables

   private String createKH() {
        ArrayList<ChiTietHoaDonPhong> mtAll = ChiTietHoaDonPhongDAO.getInstance().selectAll();

        int i = 1;
        while (true) {
            boolean exists = false;
            for (ChiTietHoaDonPhong khachhang : mtAll) {
                if (khachhang.getMaPhieuThuePhong().equals("MPT" + i)) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                break;
            } else {
                i++;
            }
        }

        return "MPT" + i;

    }

    private String createKH1() {
        ArrayList<KhachHang> mtAll = KhachHangDAO.getInstance().selectAll();

        int i = 1;
        while (true) {
            boolean exists = false;
            for (KhachHang khachhang : mtAll) {
                if (khachhang.getMaKhachHang().equals("KH" + i)) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                break;
            } else {
                i++;
            }
        }

        return "KH" + i;

    }

    private boolean updateTrangThai(String maPhong, String đã_đặt) {
        String tinhTrangPhong = null;
        int ketQua = PhongDAO.getInstance().updateTrangThai(maPhong, tinhTrangPhong);
        return ketQua > 0;
    }

  

}
