package ui;


import entity.Account;
import entity.Customer;
import entity.CustomerDTO;
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

import dao.AccountDAO;
import dao.CustomerDAO;
import dao.CustomerTypeDAO;
import dao.EmployeeDAO;
import dao.EmployeeTypeDAO;
import socket.implement.CustomerClient;

public class GD_QLKhachHang extends javax.swing.JInternalFrame {
      public static DefaultTableModel modelKhachHang;
    List<RowFilter<DefaultTableModel,Object>> filters = new ArrayList<>();
    private TableRowSorter<DefaultTableModel> tr;
    private CustomerClient cD;
    private dao.AccountDAO accD;
    private CustomerTypeDAO cTD;
    
    public GD_QLKhachHang() {
        this.setRootPaneCheckingEnabled(false);
        javax.swing.plaf.InternalFrameUI ui
                = this.getUI();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) ui).setNorthPane(null);
        initComponents();
        cD = new CustomerClient();
        this.setFocusable(true);
        // cTD = new CustomerTypeDAO();

        modelKhachHang=(DefaultTableModel) tblKhachHang.getModel();
        loadDataToTable(cD.getAll() , modelKhachHang);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        grbGioiTinh = new javax.swing.ButtonGroup();
        pnlMain = new javax.swing.JPanel();
        pnlTren = new javax.swing.JPanel();
        pnlThongTin = new javax.swing.JPanel();
        txtTenKH = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCCCD = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtSoDienThoai = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cmbLoaiKH = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        radNam = new javax.swing.JRadioButton();
        radNu = new javax.swing.JRadioButton();
        pnlNut = new javax.swing.JPanel();
        btnThemKhachHang = new javax.swing.JButton();
        btnXoaTrang = new javax.swing.JButton();
        btnSuaThongTinNV = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        pnlGiua = new javax.swing.JPanel();
        cmbLocLoaiKH = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cmbLocGioiTinh = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        findTF = new javax.swing.JTextField();
        pnlDuoi = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();

        grbGioiTinh.add(radNam);
        grbGioiTinh.add(radNu);

        setBorder(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setFrameIcon(null);
        getContentPane().setLayout(new javax.swing.OverlayLayout(getContentPane()));

        pnlMain.setBackground(new java.awt.Color(252, 210, 165));
        pnlMain.setLayout(new javax.swing.BoxLayout(pnlMain, javax.swing.BoxLayout.Y_AXIS));

        pnlTren.setBackground(new java.awt.Color(240, 233, 210));
        pnlTren.setMaximumSize(new java.awt.Dimension(2147483647, 340));
        pnlTren.setMinimumSize(new java.awt.Dimension(100, 200));
        pnlTren.setPreferredSize(new java.awt.Dimension(1324, 340));
        pnlTren.setLayout(new java.awt.BorderLayout());

        pnlThongTin.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(36, 89, 83)), "ThÃ´ng tin khÃ¡ch hÃ ng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 3, 14), new java.awt.Color(36, 89, 83))); // NOI18N
        pnlThongTin.setToolTipText("");
        pnlThongTin.setMaximumSize(new java.awt.Dimension(841, 32767));
        pnlThongTin.setPreferredSize(new java.awt.Dimension(980, 270));

        txtTenKH.setFont(new java.awt.Font("Segoe UI", 0, 15)); 
        txtTenKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenKHActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 15)); 
        jLabel4.setForeground(new java.awt.Color(36, 89, 83));
        jLabel4.setText("Tên khách hàng :");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 15)); 
        jLabel6.setForeground(new java.awt.Color(36, 89, 83));
        jLabel6.setText("CCCD :");

        txtCCCD.setFont(new java.awt.Font("Segoe UI", 0, 15)); 
        txtCCCD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCCCDActionPerformed(evt);
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
        jLabel8.setText("Loại khách hàng  :");

        cmbLoaiKH.setFont(new java.awt.Font("Segoe UI", 0, 15)); 
        cmbLoaiKH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vip", "Normal" }));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 15)); 
        jLabel10.setForeground(new java.awt.Color(36, 89, 83));
        jLabel10.setText("Giới tính:");

        radNam.setBackground(new java.awt.Color(255, 255, 255));
        grbGioiTinh.add(radNam);
        radNam.setFont(new java.awt.Font("Segoe UI", 0, 15)); 
        radNam.setSelected(true);
        radNam.setText("Nam");

        radNu.setBackground(new java.awt.Color(255, 255, 255));
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
                    .addComponent(jLabel7)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addGap(40, 40, 40)
                .addGroup(pnlThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlThongTinLayout.createSequentialGroup()
                        .addComponent(cmbLoaiKH, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addGap(31, 31, 31)
                        .addComponent(radNam)
                        .addGap(28, 28, 28)
                        .addComponent(radNu)
                        .addGap(191, 191, 191))
                    .addGroup(pnlThongTinLayout.createSequentialGroup()
                        .addGroup(pnlThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSoDienThoai, javax.swing.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)
                            .addComponent(txtCCCD)
                            .addComponent(txtTenKH))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pnlThongTinLayout.setVerticalGroup(
            pnlThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongTinLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(pnlThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(pnlThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(21, 21, 21)
                .addGroup(pnlThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(pnlThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(cmbLoaiKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(radNam)
                        .addComponent(radNu)
                        .addComponent(jLabel10)))
                .addContainerGap(107, Short.MAX_VALUE))
        );

        pnlTren.add(pnlThongTin, java.awt.BorderLayout.WEST);

        pnlNut.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(36, 89, 83)), "Xá»­ lÃ½", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(36, 89, 83))); // NOI18N
        pnlNut.setMaximumSize(new java.awt.Dimension(300, 32767));
        pnlNut.setPreferredSize(new java.awt.Dimension(300, 270));

        btnThemKhachHang.setBackground(new java.awt.Color(36, 89, 83));
        btnThemKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 16)); 
        btnThemKhachHang.setForeground(new java.awt.Color(255, 255, 255));
        btnThemKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/them.png")));
        btnThemKhachHang.setText("Thêm khách hàng");
        btnThemKhachHang.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnThemKhachHang.setIconTextGap(20);
        btnThemKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemKhachHangActionPerformed(evt);
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
        btnSuaThongTinNV.setText("Cập nhật thông tin khách hàng");
        btnSuaThongTinNV.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnSuaThongTinNV.setIconTextGap(20);
        btnSuaThongTinNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaThongTinNVActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(36, 89, 83));
        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/xoa.png"))); // NOI18N
        btnXoa.setText("Xóa khách hàng");
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
            .addComponent(btnThemKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnSuaThongTinNV, javax.swing.GroupLayout.DEFAULT_SIZE, 2676, Short.MAX_VALUE)
            .addComponent(btnXoaTrang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlNutLayout.setVerticalGroup(
            pnlNutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThemKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSuaThongTinNV, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoaTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(129, Short.MAX_VALUE))
        );

        pnlTren.add(pnlNut, java.awt.BorderLayout.CENTER);

        pnlMain.add(pnlTren);

        pnlGiua.setBackground(new java.awt.Color(255, 255, 255));
        pnlGiua.setMaximumSize(new java.awt.Dimension(32767, 50));
        pnlGiua.setPreferredSize(new java.awt.Dimension(3666, 60));

        cmbLocLoaiKH.setFont(new java.awt.Font("Segoe UI", 0, 15));
        cmbLocLoaiKH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Vip", "Normal" }));
        cmbLocLoaiKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbLocLoaiKHActionPerformed(evt);
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
                .addComponent(cmbLocLoaiKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbLocGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(2873, Short.MAX_VALUE))
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
                        .addComponent(cmbLocLoaiKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13)
                        .addComponent(findTF, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pnlMain.add(pnlGiua);

        pnlDuoi.setBackground(new java.awt.Color(255, 255, 255));
        pnlDuoi.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(36, 89, 83)), "Danh sÃ¡ch khÃ¡ch hÃ ng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(36, 89, 83))); // NOI18N
        pnlDuoi.setMaximumSize(new java.awt.Dimension(2147483647, 500));
        pnlDuoi.setPreferredSize(new java.awt.Dimension(1314, 440));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(452, 200));

        tblKhachHang.setAutoCreateRowSorter(true);
        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã ", "Tên khách hàng", "CMND", "Giới tính", "Số điện thoại", "Loại khách hàng", "Points"
            }
        ));
        tblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKhachHang);

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
        if(txtTenKH.getText().trim().equals("") || txtSoDienThoai.getText().trim().equals("") || txtCCCD.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Hãy nhập đầy đủ thông tin!");
            return false;
        }
        else
        {
            String thongBao="";
            if (!RegexHelper.regexCMND(txtCCCD.getText()))
                thongBao+="*Số chứng minh nhân dân có 9 số, không chứa kí tự!\n";
//            if(!RegexHelper.regexCustomerName(txtTenKH.getText()))
//                thongBao+="*Tên khách hàng sai định dạng\n";
            if(!RegexHelper.regexPhoneNumber(txtSoDienThoai.getText()))
                thongBao+="*Số điện thoại không chứa kí tự, phải từ 10 số và bắt đầu bằng ( 09, 08, 03, 07, 05 )! VD: 0343229978\n";
            if (thongBao.isEmpty())
                return true;
            else{
                JOptionPane.showMessageDialog(this, thongBao);
                return false;
            }
        }
    }
    private void txtTenKHActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void txtCCCDActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void txtSoDienThoaiActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private Customer createEmp() throws SQLException, ClassNotFoundException
    {
        String name = txtTenKH.getText();
        String iden = txtCCCD.getText();
        String phone = txtSoDienThoai.getText();
        String gender = radNam.isSelected() ? "Nam" : "Nữ";
        EmployeeTypeDAO etD = new EmployeeTypeDAO();
        entity.CustomerType ctype = cTD.findCusByName(cmbLoaiKH.getSelectedItem().toString());
        String email = name.toLowerCase().trim() + "@gmail.com";
        entity.Customer c = new Customer(setMaKH() , name, iden, phone, email, 0, ctype, gender );
        return c;
    }
     private String setMaKH(){
        String s="NV";
        int ma= cD.getalltbKhachHang().size();
        if (ma<9)
            s=s+ "00"+ (ma+1);
        else
            s=s+"0"+(ma+1);
        return s;
    }
    private void loadDataToTable(List<CustomerDTO> list, DefaultTableModel dtm) {  
        dtm.setRowCount(0);
        accD =new AccountDAO();
        for (CustomerDTO c: list) {
            
            Object[] row = {
                c.getCustomerID(), c.getCustomerName(), c.getCCCD(), c.getGender(),c.getPhone(), "VIP",c.getPoints()
            };
            dtm.addRow(row);
        }
    }
    private void btnThemKhachHangActionPerformed(java.awt.event.ActionEvent evt) {
        if (checkData()) {
            try {
                Customer c = createEmp();
                if (cD.getCustomerByCCCD(txtCCCD.getText()) == null) {
                    cD.add(c);
                    loadDataToTable(cD.getalltbKhachHang(), modelKhachHang);
                    clearInput();
                    JOptionPane.showMessageDialog(this, "Thêm thành công!");
                } else {
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
        int index = tblKhachHang.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Hãy chọn khách hàng cần cập nhật!");
        } else {
            if (checkData()) {
                Customer c = cD.getById(tblKhachHang.getValueAt(index, 0).toString());
                c.setCustomerName(txtTenKH.getText());
                c.setCCCD(txtCCCD.getText());
                c.setPhone(txtSoDienThoai.getText());
                c.setGender(radNam.isSelected() ? "Nam" : "Nữ");
                try {
                    c.setCustomerType(cTD.findCusByName(cmbLoaiKH.getSelectedItem().toString()));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                cD.update(c);
                loadDataToTable(cD.getalltbKhachHang(), modelKhachHang);
                clearInput();
                JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
            }
        }
    }

    private void tblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {
        int index=tblKhachHang.getSelectedRow();
        txtTenKH.setText(tblKhachHang.getValueAt(index, 1).toString());
        txtCCCD.setText(tblKhachHang.getValueAt(index, 2).toString());
        if (tblKhachHang.getValueAt(index, 3).toString().equals("Nam")){
            radNam.setSelected(true);
        }else{
            radNu.setSelected(true);
        }
        txtSoDienThoai.setText(tblKhachHang.getValueAt(index, 4).toString());
        cmbLoaiKH.setSelectedItem(tblKhachHang.getValueAt(index, 5));
    }

    private void cmbLocLoaiKHActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
        
        String s = cmbLocLoaiKH.getSelectedItem().toString();
        if(s.equals("Tất cả"))
        {
            loadDataToTable(cD.getalltbKhachHang(), modelKhachHang);
        }
        else
        {
            entity.CustomerType cT = cTD.findCusByName(s);
            if(s.equals("Vip"))
            {
                loadDataToTable(cD.getAllEmpType(cT.getCustomerTypeID()), modelKhachHang);
            }
            else
            {
                loadDataToTable(cD.getAllEmpType(cT.getCustomerTypeID()), modelKhachHang);
            }
        }
       

    }

    private void cmbLocGioiTinhActionPerformed(java.awt.event.ActionEvent evt) {
        
        String s= cmbLocGioiTinh.getSelectedItem().toString();
        if(s.equals("Tất cả"))
        {
            loadDataToTable(cD.getalltbKhachHang(), modelKhachHang);
        }
        else
        {
            if(s.equals("Nam"))
                loadDataToTable(cD.getListEmpGender(s), modelKhachHang);
            else
                loadDataToTable(cD.getListEmpGender(s), modelKhachHang);
        }

            
    }

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {
        String f=findTF.getText();
        filter(f);
    }

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {
        int index = tblKhachHang.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn khách hàng cần xóa!");
        } else {
            if (JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa khách hàng này?", "Cảnh báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                String customerId = tblKhachHang.getValueAt(index, 0).toString();
                if (cD.delete(customerId)) {
                    JOptionPane.showMessageDialog(this, "Xóa thành công");
                    clearInput();
                    loadDataToTable(cD.getalltbKhachHang(), modelKhachHang);
                } else {
                    JOptionPane.showMessageDialog(this, "Không thể xóa khách hàng!");
                }
            }
        }
    }

    private void findTFKeyReleased(java.awt.event.KeyEvent evt) {
        String f = findTF.getText();
        filter(f);
    }
    private void filter(String s){
        TableRowSorter<DefaultTableModel> tr=new TableRowSorter<DefaultTableModel>(modelKhachHang);
        tblKhachHang.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter("(?i)"+s));
    }

    private void clearInput(){
        txtCCCD.setText("");
        txtSoDienThoai.setText("");
        txtTenKH.setText("");
        txtTenKH.requestFocus();
        cmbLoaiKH.setSelectedIndex(1);
        radNam.setSelected(true);
    }

    private javax.swing.JButton btnSuaThongTinNV;
    private javax.swing.JButton btnThemKhachHang;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoaTrang;
    private javax.swing.JComboBox<String> cmbLoaiKH;
    private javax.swing.JComboBox<String> cmbLocGioiTinh;
    private javax.swing.JComboBox<String> cmbLocLoaiKH;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlDuoi;
    private javax.swing.JPanel pnlGiua;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlNut;
    private javax.swing.JPanel pnlThongTin;
    private javax.swing.JPanel pnlTren;
    private javax.swing.JRadioButton radNam;
    private javax.swing.JRadioButton radNu;
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JTextField txtCCCD;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtTenKH;
}
