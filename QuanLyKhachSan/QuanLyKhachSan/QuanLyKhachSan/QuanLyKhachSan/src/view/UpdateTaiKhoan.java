/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import view.QuanLiTaiKhoan;
import model.TaiKhoan;
import dao.TaiKhoanDAO;

public class UpdateTaiKhoan extends javax.swing.JDialog {

    private QuanLiTaiKhoan homeAcc;

    public UpdateTaiKhoan(javax.swing.JInternalFrame parent, javax.swing.JFrame owner, boolean modal) {
        super(owner, modal);

        initComponents();
        setLocationRelativeTo(null);
        homeAcc = (QuanLiTaiKhoan) parent;
        TaiKhoan acc = homeAcc.getAccountSelect();

        txtfullname.setText(acc.getTenNV());
        txtusername.setText(acc.getTaiKhoan());
        txtsdt.setText(acc.getSDT());

        vaitro.setSelectedItem(acc.getVaiTro());
        cbxtrangthai.setSelectedItem(acc.getTrangThai());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtfullname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtusername = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        vaitro = new javax.swing.JComboBox<>();
        btnupdate = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbxtrangthai = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtsdt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sửa tài khoản");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Tên tài khoản");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 110, -1));

        txtfullname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfullnameActionPerformed(evt);
            }
        });
        jPanel1.add(txtfullname, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 298, 38));

        jLabel3.setText("Tên đăng nhập");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, 24));

        txtusername.setEditable(false);
        jPanel1.add(txtusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 298, 38));

        jLabel5.setText("Vai trò");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 50, -1));

        vaitro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhân viên lễ tân" }));
        vaitro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vaitro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vaitroActionPerformed(evt);
            }
        });
        jPanel1.add(vaitro, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 298, 38));

        btnupdate.setBackground(new java.awt.Color(153, 0, 51));
        btnupdate.setForeground(new java.awt.Color(255, 255, 255));
        btnupdate.setText("Cập nhật");
        btnupdate.setBorder(null);
        btnupdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnupdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnupdateMouseClicked(evt);
            }
        });
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });
        jPanel1.add(btnupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 510, 140, 38));

        btnClose.setBackground(new java.awt.Color(51, 51, 51));
        btnClose.setText("Huỷ");
        btnClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        jPanel1.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 510, 140, 38));

        jPanel2.setBackground(new java.awt.Color(153, 0, 51));

        jLabel1.setFont(new java.awt.Font("SF Pro Display", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CẬP NHẬT THÔNG TIN");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel1)
                .addContainerGap(75, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 70));

        jLabel6.setText("Trạng thái");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 90, -1));

        cbxtrangthai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bị Khóa", "Hoạt động" }));
        cbxtrangthai.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbxtrangthai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxtrangthaiActionPerformed(evt);
            }
        });
        jPanel1.add(cbxtrangthai, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 298, 38));

        jLabel4.setText("SĐT");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));
        jPanel1.add(txtsdt, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 300, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        String tenNV = txtfullname.getText();
        String taiKhoan = txtusername.getText();
        String SDT = txtsdt.getText();
        String vaiTro = vaitro.getSelectedItem().toString();
        int trangThai = cbxtrangthai.getSelectedIndex();
        TaiKhoan acc = new TaiKhoan(tenNV, taiKhoan, SDT, vaiTro, trangThai);
        TaiKhoanDAO.getInstance().update(acc);
        this.dispose();
        homeAcc.loadDataToTable(TaiKhoanDAO.getInstance().selectAll());
        JOptionPane.showMessageDialog(this, "Cập nhật thành công !");

    }//GEN-LAST:event_btnupdateActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed

        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnupdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnupdateMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_btnupdateMouseClicked

    private void txtfullnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfullnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfullnameActionPerformed

    private void vaitroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vaitroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vaitroActionPerformed

    private void cbxtrangthaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxtrangthaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxtrangthaiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnupdate;
    private javax.swing.JComboBox<String> cbxtrangthai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtfullname;
    private javax.swing.JTextField txtsdt;
    private javax.swing.JTextField txtusername;
    private javax.swing.JComboBox<String> vaitro;
    // End of variables declaration//GEN-END:variables
}
