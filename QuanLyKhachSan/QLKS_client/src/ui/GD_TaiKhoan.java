package ui;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import dao2.AccountDAO;

public class GD_TaiKhoan extends javax.swing.JInternalFrame {
    private String username;
    private dao2.AccountDAO aD ;
    private DefaultTableModel modelTaiKhoan;
    public GD_TaiKhoan(String _username) {
        this.setRootPaneCheckingEnabled(false);
        javax.swing.plaf.InternalFrameUI ui
                = this.getUI();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) ui).setNorthPane(null);
        initComponents();
        this.setFocusable(true);
        username=_username;
  
        modelTaiKhoan=(DefaultTableModel)tblTaiKhoan.getModel();
        DocDuLieuLenTable();
    }
    private void DocDuLieuLenTable(){
        aD = new AccountDAO();
        List<entity.Account> list =aD.getAllListAccount();
        modelTaiKhoan.setRowCount(0);
        for (entity.Account a : list) {
            modelTaiKhoan.addRow(new Object[]{
                a.getUserName(),a.getPassword()});
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnlMain = new javax.swing.JPanel();
        pnlTren = new javax.swing.JPanel();
        pnlThongTin = new javax.swing.JPanel();
        txtTenDN = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMK = new javax.swing.JTextField();
        pnlNut = new javax.swing.JPanel();
        btnDatLaiMatKhau = new javax.swing.JButton();
        btnXoaTK = new javax.swing.JButton();
        pnlGiua = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtFind = new javax.swing.JTextField();
        pnlDuoi = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTaiKhoan = new javax.swing.JTable();

        setBorder(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setFrameIcon(null);
        getContentPane().setLayout(new javax.swing.OverlayLayout(getContentPane()));

        pnlMain.setBackground(new java.awt.Color(252, 209, 164));
        pnlMain.setLayout(new javax.swing.BoxLayout(pnlMain, javax.swing.BoxLayout.Y_AXIS));

        pnlTren.setBackground(new java.awt.Color(240, 233, 210));
        pnlTren.setMaximumSize(new java.awt.Dimension(2147483647, 130));
        pnlTren.setMinimumSize(new java.awt.Dimension(100, 100));
        pnlTren.setPreferredSize(new java.awt.Dimension(1324, 130));
        pnlTren.setLayout(new java.awt.BorderLayout());

        pnlThongTin.setBackground(new java.awt.Color(245, 245, 245));
        pnlThongTin.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(36, 89, 83)), "ThÃ´ng tin tÃ i khoáº£n", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 3, 14), new java.awt.Color(36, 89, 83))); // NOI18N
        pnlThongTin.setToolTipText("");
        pnlThongTin.setMaximumSize(new java.awt.Dimension(841, 32767));
        pnlThongTin.setPreferredSize(new java.awt.Dimension(980, 280));

        txtTenDN.setFont(new java.awt.Font("Segoe UI", 0, 15));  
        txtTenDN.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtTenDN.setEnabled(false);
        txtTenDN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenDNActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 15)); 
        jLabel4.setForeground(new java.awt.Color(36, 89, 83));
        jLabel4.setText("Tên đăng nhập :");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 15)); 
        jLabel6.setForeground(new java.awt.Color(36, 89, 83));
        jLabel6.setText("Mật khẩu :");

        txtMK.setFont(new java.awt.Font("Segoe UI", 0, 15));  
        txtMK.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtMK.setEnabled(false);
        txtMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlThongTinLayout = new javax.swing.GroupLayout(pnlThongTin);
        pnlThongTin.setLayout(pnlThongTinLayout);
        pnlThongTinLayout.setHorizontalGroup(
            pnlThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongTinLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(pnlThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addGap(68, 68, 68)
                .addGroup(pnlThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMK, javax.swing.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)
                    .addComponent(txtTenDN))
                .addGap(0, 6, Short.MAX_VALUE))
        );
        pnlThongTinLayout.setVerticalGroup(
            pnlThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongTinLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(pnlThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenDN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(pnlThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlTren.add(pnlThongTin, java.awt.BorderLayout.WEST);

        pnlNut.setBackground(new java.awt.Color(245, 245, 245));
        pnlNut.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(36, 89, 83)), "Xá»­ lÃ½", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(36, 89, 83))); // NOI18N
        pnlNut.setMaximumSize(new java.awt.Dimension(300, 32767));
        pnlNut.setPreferredSize(new java.awt.Dimension(300, 300));

        btnDatLaiMatKhau.setBackground(new java.awt.Color(36, 89, 83));
        btnDatLaiMatKhau.setFont(new java.awt.Font("Segoe UI", 1, 17));  
        btnDatLaiMatKhau.setForeground(new java.awt.Color(255, 255, 255));
        btnDatLaiMatKhau.setText("Đặt lại mật khẩu");
        btnDatLaiMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatLaiMatKhauActionPerformed(evt);
            }
        });

        btnXoaTK.setBackground(new java.awt.Color(255, 102, 102));
        btnXoaTK.setFont(new java.awt.Font("Segoe UI", 1, 17)); 
        btnXoaTK.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaTK.setText("Xóa tài khoản");
        btnXoaTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaTKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlNutLayout = new javax.swing.GroupLayout(pnlNut);
        pnlNut.setLayout(pnlNutLayout);
        pnlNutLayout.setHorizontalGroup(
            pnlNutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNutLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlNutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDatLaiMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoaTK, javax.swing.GroupLayout.DEFAULT_SIZE, 2664, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlNutLayout.setVerticalGroup(
            pnlNutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnDatLaiMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoaTK, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlTren.add(pnlNut, java.awt.BorderLayout.CENTER);

        pnlMain.add(pnlTren);

        pnlGiua.setBackground(new java.awt.Color(255, 255, 255));
        pnlGiua.setMaximumSize(new java.awt.Dimension(32767, 50));
        pnlGiua.setPreferredSize(new java.awt.Dimension(3666, 60));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 15)); 
        jLabel13.setForeground(new java.awt.Color(36, 89, 83));
        jLabel13.setText("Tìm kiếm :");

        javax.swing.GroupLayout pnlGiuaLayout = new javax.swing.GroupLayout(pnlGiua);
        pnlGiua.setLayout(pnlGiuaLayout);
        pnlGiuaLayout.setHorizontalGroup(
            pnlGiuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGiuaLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(3356, Short.MAX_VALUE))
        );
        pnlGiuaLayout.setVerticalGroup(
            pnlGiuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGiuaLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(pnlGiuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pnlMain.add(pnlGiua);

        pnlDuoi.setBackground(new java.awt.Color(245, 245, 245));
        pnlDuoi.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(36, 89, 83)), "Danh sÃ¡ch tÃ i khoáº£n", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(36, 89, 83))); // NOI18N
        pnlDuoi.setMaximumSize(new java.awt.Dimension(2147483647, 900));
        pnlDuoi.setPreferredSize(new java.awt.Dimension(1314, 505));
        pnlDuoi.setLayout(new javax.swing.BoxLayout(pnlDuoi, javax.swing.BoxLayout.LINE_AXIS));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(452, 200));

        tblTaiKhoan.setAutoCreateRowSorter(true);
        tblTaiKhoan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên đăng nhập", "Mật khẩu"
            }
        ));
        tblTaiKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTaiKhoanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTaiKhoan);

        pnlDuoi.add(jScrollPane1);

        pnlMain.add(pnlDuoi);

        getContentPane().add(pnlMain);

        pack();
    }

    private void txtTenDNActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void txtMKActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void btnXoaTKActionPerformed(java.awt.event.ActionEvent evt) {
        int index = tblTaiKhoan.getSelectedRow();
        if (index==-1){
            JOptionPane.showMessageDialog(this, "Hãy chọn tài khoản cần xóa!");
        }else{
            int chon= JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa tài khoản này?", "Há»�i",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(chon==JOptionPane.YES_OPTION){
                aD.delete(aD.getAccountById(tblTaiKhoan.getValueAt(index, 0).toString()));
                DocDuLieuLenTable();
                JOptionPane.showMessageDialog(this, "Xóa thành công!");
                txtTenDN.setText("");
                txtMK.setText("");
            }
            
            }
    } 

    private void btnDatLaiMatKhauActionPerformed(java.awt.event.ActionEvent evt) { 
        int index = tblTaiKhoan.getSelectedRow();
        if (index==-1){
            JOptionPane.showMessageDialog(this, "Hãy chọn tài khoản cần đặt lại mật khẩu!");
        }else{
            aD.update("123456", modelTaiKhoan.getValueAt(index, 0)+"");
            
            DocDuLieuLenTable();
            JOptionPane.showMessageDialog(this, "Đặt lại mật khẩu thành công!");
            txtTenDN.setText("");
            txtMK.setText("");
            }
        
    } 

    private void tblTaiKhoanMouseClicked(java.awt.event.MouseEvent evt) { 
        int index=tblTaiKhoan.getSelectedRow();
        txtTenDN.setText(tblTaiKhoan.getValueAt(index, 0).toString());
        txtMK.setText(tblTaiKhoan.getValueAt(index, 1).toString());
    } 

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) { 
        String f= txtFind.getText();
        filter(f);
    } 

                                      
    private void filter(String s){
        TableRowSorter<DefaultTableModel> tr=new TableRowSorter<DefaultTableModel>(modelTaiKhoan);
        tblTaiKhoan.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter("(?i)"+s,0));

        
    }

    private javax.swing.JButton btnDatLaiMatKhau;
    private javax.swing.JButton btnXoaTK;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlDuoi;
    private javax.swing.JPanel pnlGiua;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlNut;
    private javax.swing.JPanel pnlThongTin;
    private javax.swing.JPanel pnlTren;
    private javax.swing.JTable tblTaiKhoan;
    private javax.swing.JTextField txtFind;
    private javax.swing.JTextField txtMK;
    private javax.swing.JTextField txtTenDN;
}
