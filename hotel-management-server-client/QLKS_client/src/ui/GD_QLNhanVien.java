package ui;


import dao.AccountDAO;
import dao.EmployeeDAO;
import dao.EmployeeTypeDAO;
import entity.Account;
import entity.Employee;
import entity.EmployeeType;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonModel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import regex.RegexHelper;

public class GD_QLNhanVien extends javax.swing.JInternalFrame {
      public static DefaultTableModel modelNhanVien;

    List<RowFilter<DefaultTableModel,Object>> filters = new ArrayList<>();
    private TableRowSorter<DefaultTableModel> tr;
    private dao.EmployeeDAO eD;
    private dao.AccountDAO accD;
    private EmployeeTypeDAO eTD;
    
    public GD_QLNhanVien() {
        this.setRootPaneCheckingEnabled(false);
        javax.swing.plaf.InternalFrameUI ui
                = this.getUI();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) ui).setNorthPane(null);
        initComponents();
        eD = new EmployeeDAO();
        this.setFocusable(true);
        eTD = new EmployeeTypeDAO();

        modelNhanVien=(DefaultTableModel) tblNhanVien.getModel();
        loadDataToTable(eD.getAllList(), modelNhanVien);  
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        grbGioiTinh = new javax.swing.ButtonGroup();
        pnlMain = new javax.swing.JPanel();
        pnlTren = new javax.swing.JPanel();
        pnlThongTin = new javax.swing.JPanel();
        txtTenNhanVien = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCMND = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtSoDienThoai = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtLuongCoBan = new javax.swing.JTextField();
        cmbChucVu = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        radNam = new javax.swing.JRadioButton();
        radNu = new javax.swing.JRadioButton();
        pnlNut = new javax.swing.JPanel();
        btnTaoTaiKhoanNV = new javax.swing.JButton();
        btnThemNhanVien = new javax.swing.JButton();
        btnXoaTrang = new javax.swing.JButton();
        btnSuaThongTinNV = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        pnlGiua = new javax.swing.JPanel();
        cmbLocChucVu = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cmbLocGioiTinh = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        findTF = new javax.swing.JTextField();
        pnlDuoi = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();

        grbGioiTinh.add(radNam);
        grbGioiTinh.add(radNu);

        setBorder(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setFrameIcon(null);
        getContentPane().setLayout(new javax.swing.OverlayLayout(getContentPane()));

        pnlMain.setBackground(new java.awt.Color(252, 210, 165));
        pnlMain.setLayout(new javax.swing.BoxLayout(pnlMain, javax.swing.BoxLayout.Y_AXIS));

        pnlTren.setBackground(new java.awt.Color(252, 210, 165));
        pnlTren.setMaximumSize(new java.awt.Dimension(2147483647, 340));
        pnlTren.setMinimumSize(new java.awt.Dimension(100, 200));
        pnlTren.setPreferredSize(new java.awt.Dimension(1324, 340));
        pnlTren.setLayout(new java.awt.BorderLayout());

        pnlThongTin.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(36, 89, 83)), "ThÃ´ng tin nhÃ¢n viÃªn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 3, 14), new java.awt.Color(36, 89, 83))); // NOI18N
        pnlThongTin.setToolTipText("");
        pnlThongTin.setMaximumSize(new java.awt.Dimension(841, 32767));
        pnlThongTin.setPreferredSize(new java.awt.Dimension(980, 270));

        txtTenNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 15)); 
        txtTenNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenNhanVienActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 15)); 
        jLabel4.setForeground(new java.awt.Color(36, 89, 83));
        jLabel4.setText("Tên nhân viên :");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 15)); 
        jLabel6.setForeground(new java.awt.Color(36, 89, 83));
        jLabel6.setText("CCCD :");

        txtCMND.setFont(new java.awt.Font("Segoe UI", 0, 15));
        txtCMND.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCMNDActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 15));
        jLabel7.setForeground(new java.awt.Color(36, 89, 83));
        jLabel7.setText("Số điện thoại :");

        txtSoDienThoai.setFont(new java.awt.Font("Segoe UI", 0, 15));
        txtSoDienThoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoDienThoaiActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 15));
        jLabel8.setForeground(new java.awt.Color(36, 89, 83));
        jLabel8.setText("Chức vụ :");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 15));
        jLabel9.setForeground(new java.awt.Color(36, 89, 83));
        jLabel9.setText("Lương cơ bản :");

        txtLuongCoBan.setFont(new java.awt.Font("Segoe UI", 0, 15)); 
        txtLuongCoBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLuongCoBanActionPerformed(evt);
            }
        });

        cmbChucVu.setFont(new java.awt.Font("Segoe UI", 0, 15)); 
        cmbChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thu ngân", "Quản lý" }));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 15)); 
        jLabel10.setForeground(new java.awt.Color(36, 89, 83));
        jLabel10.setText("Giới tính :");

        radNam.setBackground(new java.awt.Color(245, 245, 245));
        grbGioiTinh.add(radNam);
        radNam.setFont(new java.awt.Font("Segoe UI", 0, 15)); 
        radNam.setSelected(true);
        radNam.setText("Nam");

        radNu.setBackground(new java.awt.Color(245, 245, 245));
        grbGioiTinh.add(radNu);
        radNu.setFont(new java.awt.Font("Segoe UI", 0, 15)); 
        radNu.setText("Nữ");

        javax.swing.GroupLayout pnlThongTinLayout = new javax.swing.GroupLayout(pnlThongTin);
        pnlThongTin.setLayout(pnlThongTinLayout);
        pnlThongTinLayout.setHorizontalGroup(
            pnlThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongTinLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(pnlThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlThongTinLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(68, 68, 68)
                        .addComponent(txtLuongCoBan, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlThongTinLayout.createSequentialGroup()
                        .addGroup(pnlThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addGap(68, 68, 68)
                        .addGroup(pnlThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlThongTinLayout.createSequentialGroup()
                                .addComponent(cmbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                                .addComponent(jLabel10)
                                .addGap(31, 31, 31)
                                .addComponent(radNam)
                                .addGap(28, 28, 28)
                                .addComponent(radNu)
                                .addGap(191, 191, 191))
                            .addGroup(pnlThongTinLayout.createSequentialGroup()
                                .addGroup(pnlThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)
                                    .addComponent(txtCMND)
                                    .addComponent(txtTenNhanVien))
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );
        pnlThongTinLayout.setVerticalGroup(
            pnlThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongTinLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(pnlThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCMND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(21, 21, 21)
                .addGroup(pnlThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(pnlThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(cmbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(radNam)
                        .addComponent(radNu)
                        .addComponent(jLabel10)))
                .addGap(18, 18, 18)
                .addGroup(pnlThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLuongCoBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap(83, Short.MAX_VALUE))
        );

        pnlTren.add(pnlThongTin, java.awt.BorderLayout.WEST);

        pnlNut.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(36, 89, 83)), "Xá»­ lÃ½", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(36, 89, 83))); // NOI18N
        pnlNut.setMaximumSize(new java.awt.Dimension(300, 32767));
        pnlNut.setPreferredSize(new java.awt.Dimension(300, 270));

        btnTaoTaiKhoanNV.setBackground(new java.awt.Color(36, 89, 83));
        btnTaoTaiKhoanNV.setFont(new java.awt.Font("Segoe UI", 1, 16)); 
        btnTaoTaiKhoanNV.setForeground(new java.awt.Color(255, 255, 255));
        btnTaoTaiKhoanNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/themTK.png")));
        btnTaoTaiKhoanNV.setText("Tạo tài khoản");
        btnTaoTaiKhoanNV.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnTaoTaiKhoanNV.setIconTextGap(20);
        btnTaoTaiKhoanNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoTaiKhoanNVActionPerformed(evt);
            }
        });

        btnThemNhanVien.setBackground(new java.awt.Color(36, 89, 83));
        btnThemNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 16));  
        btnThemNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        btnThemNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/them.png")));  
        btnThemNhanVien.setText("Thêm nhân viên");
        btnThemNhanVien.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnThemNhanVien.setIconTextGap(20);
        btnThemNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemNhanVienActionPerformed(evt);
            }
        });

        btnXoaTrang.setBackground(new java.awt.Color(36, 89, 83));
        btnXoaTrang.setFont(new java.awt.Font("Segoe UI", 1, 16)); 
        btnXoaTrang.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaTrang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/xoaTrang.png")));  
        btnXoaTrang.setText("Xóa trắng");
        btnXoaTrang.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnXoaTrang.setIconTextGap(20);
        btnXoaTrang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaTrangActionPerformed(evt);
            }
        });

        btnSuaThongTinNV.setBackground(new java.awt.Color(36, 89, 83));
        btnSuaThongTinNV.setFont(new java.awt.Font("Segoe UI", 1, 16));  
        btnSuaThongTinNV.setForeground(new java.awt.Color(255, 255, 255));
        btnSuaThongTinNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/capNhat.png")));  
        btnSuaThongTinNV.setText("Cập nhật thông tin nhân viên");
        btnSuaThongTinNV.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnSuaThongTinNV.setIconTextGap(20);
        btnSuaThongTinNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaThongTinNVActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(36, 89, 83));
        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 16)); 
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/xoa.png")));
        btnXoa.setText("Xóa nhân viên");
        btnXoa.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnXoa.setIconTextGap(20);
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlNutLayout = new javax.swing.GroupLayout(pnlNut);
        pnlNut.setLayout(pnlNutLayout);
        pnlNutLayout.setHorizontalGroup(
            pnlNutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnThemNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnSuaThongTinNV, javax.swing.GroupLayout.DEFAULT_SIZE, 2676, Short.MAX_VALUE)
            .addComponent(btnXoaTrang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnTaoTaiKhoanNV, javax.swing.GroupLayout.DEFAULT_SIZE, 2676, Short.MAX_VALUE)
            .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlNutLayout.setVerticalGroup(
            pnlNutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThemNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSuaThongTinNV, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoaTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTaoTaiKhoanNV, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        pnlTren.add(pnlNut, java.awt.BorderLayout.CENTER);

        pnlMain.add(pnlTren);

        pnlGiua.setBackground(new java.awt.Color(255, 255, 255));
        pnlGiua.setMaximumSize(new java.awt.Dimension(32767, 50));
        pnlGiua.setPreferredSize(new java.awt.Dimension(3666, 60));

        cmbLocChucVu.setFont(new java.awt.Font("Segoe UI", 0, 15));  
        cmbLocChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Thu ngân", "Quản lý" }));
        cmbLocChucVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbLocChucVuActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 15));  
        jLabel11.setForeground(new java.awt.Color(36, 89, 83));
        jLabel11.setText("Chức vụ :");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 15));  
        jLabel12.setForeground(new java.awt.Color(36, 89, 83));
        jLabel12.setText("Giới tính");

        cmbLocGioiTinh.setFont(new java.awt.Font("Segoe UI", 0, 15));  
        cmbLocGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Nam", "Nữ" }));
        cmbLocGioiTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbLocGioiTinhActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 15)); 
        jLabel13.setForeground(new java.awt.Color(36, 89, 83));
        jLabel13.setText("Tìm kiếm :");

        findTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                findTFKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout pnlGiuaLayout = new javax.swing.GroupLayout(pnlGiua);
        pnlGiua.setLayout(pnlGiuaLayout);
        pnlGiuaLayout.setHorizontalGroup(
            pnlGiuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGiuaLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(findTF, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbLocChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbLocGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(2859, Short.MAX_VALUE))
        );
        pnlGiuaLayout.setVerticalGroup(
            pnlGiuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGiuaLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(pnlGiuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlGiuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(cmbLocGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlGiuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(cmbLocChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13)
                        .addComponent(findTF, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pnlMain.add(pnlGiua);

        pnlDuoi.setBackground(new java.awt.Color(255, 255, 255));
        pnlDuoi.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(36, 89, 83)), "Danh sÃ¡ch nhÃ¢n viÃªn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(36, 89, 83))); // NOI18N
        pnlDuoi.setMaximumSize(new java.awt.Dimension(2147483647, 500));
        pnlDuoi.setPreferredSize(new java.awt.Dimension(1314, 440));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(452, 200));

        tblNhanVien.setAutoCreateRowSorter(true);
        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã ", "Tên nhân viên", "CCCD", "Giới tính", "Số điện thoại", "Chức vụ", "Lương cơ bản", "Tài khoản"
            }
        ));
        tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNhanVien);

        javax.swing.GroupLayout pnlDuoiLayout = new javax.swing.GroupLayout(pnlDuoi);
        pnlDuoi.setLayout(pnlDuoiLayout);
        pnlDuoiLayout.setHorizontalGroup(
            pnlDuoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1314, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlDuoiLayout.setVerticalGroup(
            pnlDuoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pnlMain.add(pnlDuoi);

        getContentPane().add(pnlMain);

        pack();
    }

    private boolean checkData()
    {
        if(txtTenNhanVien.getText().trim().equals("") || txtSoDienThoai.getText().trim().equals("") || txtLuongCoBan.getText().trim().equals("") || txtCMND.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Hãy nhập đầy đủ thông tin!");
            return false;
        }
        else
        {
            String thongBao="";
            if (!RegexHelper.regexCMND(txtCMND.getText()))
                thongBao+="*Số CCCD gồm 9 số, không chứa kí tự!\n";
//            if(!RegexHelper.regexCustomerName(txtTenNhanVien.getText()))
//                thongBao+="*TÃªn khÃ¡ch hÃ ng sai Ä‘á»‹nh dáº¡ng! VD: LÃª Tuáº¥n\n";
            if(!RegexHelper.regexPhoneNumber(txtSoDienThoai.getText()))
                thongBao+="*Số điện thoại không chứa kí tự, gồm 10 số và bắt đầu bằng ( 09, 08, 03, 07, 05 )! VD: 0343229978\n";
            if (!RegexHelper.regexLuong(txtLuongCoBan.getText()))
                thongBao+="*Lương phải là số!\n";
            if (thongBao.isEmpty())
                return true;
            else{
                JOptionPane.showMessageDialog(this, thongBao);
                return false;
            }
        }
    }
    private void txtTenNhanVienActionPerformed(java.awt.event.ActionEvent evt) { 
        // TODO add your handling code here:
    }

    private void txtCMNDActionPerformed(java.awt.event.ActionEvent evt) { 
        // TODO add your handling code here:
    } 

    private void txtSoDienThoaiActionPerformed(java.awt.event.ActionEvent evt) { 
        // TODO add your handling code here:
    } 

    private void txtLuongCoBanActionPerformed(java.awt.event.ActionEvent evt) { 
        // TODO add your handling code here:
    } 

    private Employee createEmp() throws SQLException, ClassNotFoundException
    {
        String name = txtTenNhanVien.getText();
        String iden = txtCMND.getText();
        String phone = txtSoDienThoai.getText();
        String salary = txtLuongCoBan.getText();
        String gender = radNam.isSelected() ? "Nam" : "Nữ";
        EmployeeTypeDAO etD = new EmployeeTypeDAO();
        entity.EmployeeType et = etD.findEmpByName(cmbChucVu.getSelectedItem().toString());
        String email = name.toLowerCase().trim() + "@gmail.com";
        entity.Employee e = new Employee(setMaNV(), name, iden, phone, email, Double.parseDouble(salary),  et, gender);
        return e;
    }
     private String setMaNV(){
        String s="NV";
        int ma= eD.getAllList().size();
        if (ma<9)
            s=s+ "00"+ (ma+1);
        else
            s=s+"0"+(ma+1);
        return s;
    }
    private void loadDataToTable(List<Employee> list, DefaultTableModel dtm) {  
        dtm.setRowCount(0);
        accD =new AccountDAO();
        for (Employee s: list) {
            String taiKhoan = "Chưa có";
            if (accD.getAccountById(s.getEmployeeID()) != null )
                if (!s.getEmployeeType().getEmployeeTypeName().equals("LNV002"))
                    taiKhoan="Ä�Ã£ khÃ³a";
                else
                    taiKhoan=s.getEmployeeID();
            Object[] row = {
                s.getEmployeeID(), s.getEmployeeName(), s.getCCCD(), s.getGender(),s.getPhone(),s.getEmployeeType().getEmployeeTypeName(),s.getSalary(),taiKhoan
            };
            dtm.addRow(row);
        }
    }
    private void btnThemNhanVienActionPerformed(java.awt.event.ActionEvent evt) { 

          if(checkData())
          {
             
              try {
                  Employee e = createEmp();
                  if(eD.findEmpCCCD(txtCMND.getText()) == null)
                  {
                        eD.add(e);
                        loadDataToTable(eD.getAllList(), modelNhanVien);
                        clearInput();
                        JOptionPane.showMessageDialog(this, "Thêm thành công!");
                  }
                  else
                  {
                      JOptionPane.showMessageDialog(this, "Mã CCCD bị trùng!");
                  }
              } catch (Exception e1) {
                  JOptionPane.showMessageDialog(this, e1.getMessage());
              }
          }
        
    } 

    private void btnXoaTrangActionPerformed(java.awt.event.ActionEvent evt) { 
        clearInput();
    } 

    private void btnSuaThongTinNVActionPerformed(java.awt.event.ActionEvent evt) { 
        int index = tblNhanVien.getSelectedRow();
        if (index==-1){
            JOptionPane.showMessageDialog(this, "Hãy chọn dòng cần cập nhật!");
        }
        else
        {
            if(checkData())
            {
                Employee e = eD.findEmpID(tblNhanVien.getValueAt(index, 0).toString());
                e.setEmployeeName(txtTenNhanVien.getText());
                e.setCCCD(txtCMND.getText());
                e.setPhone(txtSoDienThoai.getText());
                e.setGender(radNam.isSelected() ? "Nam": "Nữ");
                e.setSalary(Double.parseDouble(txtLuongCoBan.getText()));
                try {
                    e.setEmployeeType(eTD.findEmpByName(cmbChucVu.getSelectedItem().toString()));
                } catch (SQLException ex) {
                    Logger.getLogger(GD_QLNhanVien.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(GD_QLNhanVien.class.getName()).log(Level.SEVERE, null, ex);
                }
                eD.update(e);
                loadDataToTable(eD.getAllList(), modelNhanVien);
                clearInput();
                JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
            }
        }
    }

    private void tblNhanVienMouseClicked(java.awt.event.MouseEvent evt) { 
        int index=tblNhanVien.getSelectedRow();
        txtTenNhanVien.setText(tblNhanVien.getValueAt(index, 1).toString());
        txtCMND.setText(tblNhanVien.getValueAt(index, 2).toString());
        if (tblNhanVien.getValueAt(index, 3).toString().equals("Nam")){
            radNam.setSelected(true);
        }else{
            radNu.setSelected(true);
        }
        txtSoDienThoai.setText(tblNhanVien.getValueAt(index, 4).toString());
        cmbChucVu.setSelectedItem(tblNhanVien.getValueAt(index, 5));
        txtLuongCoBan.setText(tblNhanVien.getValueAt(index, 6).toString());
        
        
    } 

    private void cmbLocChucVuActionPerformed(java.awt.event.ActionEvent evt) { 
        
        String s = cmbLocChucVu.getSelectedItem().toString();
        if(s.equals("Tất cả"))
        {
            loadDataToTable(eD.getAllList(), modelNhanVien);
        }
        else
        {
            try {
                EmployeeType e = eTD.findEmpByName(s);
                if(s.equals("Thu ngân"))
                {
                    loadDataToTable(eD.getAllEmpType(e.getEmployeeTypeID()), modelNhanVien);
                }
                else
                {
                    loadDataToTable(eD.getAllEmpType(e.getEmployeeTypeID()), modelNhanVien);
                }
            } catch (SQLException ex) {
                Logger.getLogger(GD_QLNhanVien.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(GD_QLNhanVien.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       

    } 

    private void cmbLocGioiTinhActionPerformed(java.awt.event.ActionEvent evt) { 
        
        String s= cmbLocGioiTinh.getSelectedItem().toString();
        if(s.equals("Tất cả"))
        {
            loadDataToTable(eD.getAllList(), modelNhanVien);
        }
        else
        {
            if(s.equals("Nam"))
                loadDataToTable(eD.getListEmpGender(s), modelNhanVien);
            else
                loadDataToTable(eD.getListEmpGender(s), modelNhanVien);
        }

            
    } 

    private void btnTaoTaiKhoanNVActionPerformed(java.awt.event.ActionEvent evt) { 
        int index= tblNhanVien.getSelectedRow();        
        if (index==-1){
            JOptionPane.showMessageDialog(this, "Hãy chọn nhân viên cần tạo tài khoản!");
        }
        else
        {
            
            if(modelNhanVien.getValueAt(index, 7) != "Chưa có"){
                JOptionPane.showMessageDialog(this, "Nhân viên này đã có tài khoản!!!");
            }
            else
            {
                
                int choose = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn tạo tài khoản cho nhân viên này?", "Há»�i", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (choose == JOptionPane.YES_OPTION) {
                    Employee e = eD.findEmpID(modelNhanVien.getValueAt(index, 0)+"");
                    String taiKhoan= e.getEmployeeID();
                    Account a=new Account(taiKhoan,"123456");
                    accD.insertAccount(a);
                    loadDataToTable(eD.getAllList(), modelNhanVien);
                    JOptionPane.showMessageDialog(this, "Tạo thành công! \n Username: " + taiKhoan+"\n Pass: 123456");
                    clearInput();
                }
            } 
        } 
    }

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {
        String f=findTF.getText();
        filter(f);
    }

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        int index = tblNhanVien.getSelectedRow();
        if(index == -1)
        {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên cần xóa!");
        }
        else
        {
            if(modelNhanVien.getValueAt(index, 7) != "Chưa có"){
                if(JOptionPane.showConfirmDialog(this, "HBạn có chắc muốn xóa tài khỏa nhân viên này?", "Cảnh báo", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
                {
                    Employee e = eD.findEmpID(tblNhanVien.getValueAt(index, 0).toString());
                    accD.delete(accD.getAccountById(tblNhanVien.getValueAt(index, 0).toString()));
                    if(eD.delete(e))
                    {
                        JOptionPane.showMessageDialog(this, "Xóa thành công");
                        clearInput();
                        loadDataToTable(eD.getAllList(), modelNhanVien);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this, "Không thể xóa nhân viên!");
                    }
                }
            }
            else
            {
                if(JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa nhân viên này không?", "Cảnh báo", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
                {
                    Employee e = eD.findEmpID(tblNhanVien.getValueAt(index, 0).toString());
                    if(eD.delete(e))
                    {
                        JOptionPane.showMessageDialog(this, "Xóa thành công");
                        clearInput();
                        loadDataToTable(eD.getAllList(), modelNhanVien);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this, "Không thể xóa nhân viên!");
                    }
                }
            }
        }
        
    } 

    private void findTFKeyReleased(java.awt.event.KeyEvent evt) { 
        // TODO add your handling code here:
        String f = findTF.getText();
        filter(f);
    } 
    private void filter(String s){
        TableRowSorter<DefaultTableModel> tr=new TableRowSorter<DefaultTableModel>(modelNhanVien);
        tblNhanVien.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter("(?i)"+s));
    }

    private void clearInput(){
        txtCMND.setText(""); 
        txtSoDienThoai.setText("");
        txtTenNhanVien.setText("");
        txtLuongCoBan.setText("");
        txtTenNhanVien.requestFocus();
        cmbChucVu.setSelectedIndex(1);
        radNam.setSelected(true);
    }
 
    private javax.swing.JButton btnSuaThongTinNV;
    private javax.swing.JButton btnTaoTaiKhoanNV;
    private javax.swing.JButton btnThemNhanVien;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoaTrang;
    private javax.swing.JComboBox<String> cmbChucVu;
    private javax.swing.JComboBox<String> cmbLocChucVu;
    private javax.swing.JComboBox<String> cmbLocGioiTinh;
    private javax.swing.JTextField findTF;
    private javax.swing.ButtonGroup grbGioiTinh;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlDuoi;
    private javax.swing.JPanel pnlGiua;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlNut;
    private javax.swing.JPanel pnlThongTin;
    private javax.swing.JPanel pnlTren;
    private javax.swing.JRadioButton radNam;
    private javax.swing.JRadioButton radNu;
    private javax.swing.JTable tblNhanVien;
    private javax.swing.JTextField txtCMND;
    private javax.swing.JTextField txtLuongCoBan;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtTenNhanVien; 
}
