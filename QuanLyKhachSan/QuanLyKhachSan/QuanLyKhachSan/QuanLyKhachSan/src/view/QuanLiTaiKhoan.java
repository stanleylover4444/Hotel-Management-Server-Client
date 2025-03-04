/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import controller.BCrypt;
import controller.SearchTaiKhoan;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import model.TaiKhoan;
import dao.TaiKhoanDAO;
import java.awt.Desktop;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.swing.JFrame;
import model.KhachHang;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class QuanLiTaiKhoan extends javax.swing.JInternalFrame {

    /**
     * Creates new form QuanLiTaiKhoan
     */
    private DefaultTableModel tblModel;
    private ArrayList<TaiKhoan> accounts = TaiKhoanDAO.getInstance().selectAll();

    public QuanLiTaiKhoan() {
        initComponents();
        UIManager.put("Table.showVerticalLines", true);
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        tblAccount.setDefaultEditor(Object.class, null);
        initTable();
        loadDataToTable(accounts);
    }

    public final void initTable() {
        tblModel = new DefaultTableModel();
        String[] headerTbl = new String[]{"Tên nhân viên", "Tài khoản", "Mật khẩu", "Vai trò", "Trạng thái", "Số điện thoại"};
        tblModel.setColumnIdentifiers(headerTbl);
        tblAccount.setModel(tblModel);
    }

    public void loadDataToTable(ArrayList<TaiKhoan> acc) {
        try {
            tblModel.setRowCount(0);
            for (TaiKhoan i : acc) {
                tblModel.addRow(new Object[]{
                    i.getTenNV(), i.getTaiKhoan(), i.getMatKhau(), i.getVaiTro(), i.getTrangThai() == 0 ? "Đã khóa" : "Hoạt động", i.getSDT()
                });
            }
        } catch (Exception e) {
        }
    }

    public TaiKhoan getAccountSelect() {
        int i_row = tblAccount.getSelectedRow();
        TaiKhoan acc = TaiKhoanDAO.getInstance().selectById(tblAccount.getValueAt(i_row, 1).toString());
        return acc;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jPanel2 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        btnAdd = new javax.swing.JButton();
        btnDeleteAccount = new javax.swing.JButton();
        btnEditAccount = new javax.swing.JButton();
        btnEditAccount1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        cbxLuachon = new javax.swing.JComboBox<>();
        txtSearch = new javax.swing.JTextField();
        btnreset = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAccount = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("THÊM TÀI KHOẢN");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Họ và tên");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Tên đăng nhập");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Mật khẩu");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Vai trò");

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setText("Thêm tài khoản");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jTextField1)
                            .addComponent(jLabel3)
                            .addComponent(jTextField2)
                            .addComponent(jTextField3)
                            .addComponent(jComboBox1, 0, 269, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1380, 859));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jToolBar1.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar1.setBorder(javax.swing.BorderFactory.createTitledBorder("Chức năng"));
        jToolBar1.setRollover(true);

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/plus.png"))); // NOI18N
        btnAdd.setText("Thêm");
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd.setFocusable(false);
        btnAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAdd);

        btnDeleteAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        btnDeleteAccount.setText("Xoá");
        btnDeleteAccount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeleteAccount.setFocusable(false);
        btnDeleteAccount.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDeleteAccount.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDeleteAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteAccountActionPerformed(evt);
            }
        });
        jToolBar1.add(btnDeleteAccount);

        btnEditAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/edit.png"))); // NOI18N
        btnEditAccount.setText("Sửa");
        btnEditAccount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditAccount.setFocusable(false);
        btnEditAccount.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditAccount.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEditAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditAccountActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEditAccount);

        btnEditAccount1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/transfer.png"))); // NOI18N
        btnEditAccount1.setText("Đặt lại");
        btnEditAccount1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditAccount1.setFocusable(false);
        btnEditAccount1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditAccount1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEditAccount1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditAccount1ActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEditAccount1);

        jPanel2.add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 210, 90));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbxLuachon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Tên tài khoản", "Tên đăng nhập", "Vai trò" }));
        jPanel3.add(cbxLuachon, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 130, 40));

        txtSearch.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtSearchInputMethodTextChanged(evt);
            }
        });
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtSearchPropertyChange(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        jPanel3.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 320, 40));

        btnreset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refresh.png"))); // NOI18N
        btnreset.setText("Làm mới");
        btnreset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresetActionPerformed(evt);
            }
        });
        jPanel3.add(btnreset, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, 170, 40));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, 720, 90));

        jScrollPane1.setBorder(null);

        tblAccount.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên nhân viên", "Tài khoản", "Vai trò", "Trạng thái"
            }
        ));
        tblAccount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblAccount.setGridColor(new java.awt.Color(204, 204, 204));
        tblAccount.setShowGrid(true);
        jScrollPane1.setViewportView(tblAccount);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 1250, 720));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -40, -1, 870));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        AddTaiKhoan a;
        a = new AddTaiKhoan(this, (JFrame) javax.swing.SwingUtilities.getWindowAncestor(this), rootPaneCheckingEnabled);
        a.setVisible(true);


    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditAccountActionPerformed
        // TODO add your handling code here:
        if (tblAccount.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn tài khoản cần chỉnh sửa !");
        } else {
            if (getAccountSelect().getVaiTro().equals("Admin")) {
                JOptionPane.showMessageDialog(this, "Không thể sửa tài khoản admin tại đây !", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            } else {
                UpdateTaiKhoan u = new UpdateTaiKhoan(this, (JFrame) javax.swing.SwingUtilities.getWindowAncestor(this), rootPaneCheckingEnabled);
                u.setVisible(true);
            }
        }
    }//GEN-LAST:event_btnEditAccountActionPerformed

    private void btnDeleteAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteAccountActionPerformed
        // TODO add your handling code here:
        if (tblAccount.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn tài khoản cần xoá !");
        } else {
            TaiKhoan select = getAccountSelect();
            if (select.getVaiTro().equals("Admin")) {
                JOptionPane.showMessageDialog(this, "Không thể xóa tài khoản admin !");
            } else {
                int checkVl = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa tài khoản này ?", "Xác nhận xóa tài khoản", JOptionPane.YES_NO_OPTION);
                if (checkVl == JOptionPane.YES_OPTION) {
                    try {
                        TaiKhoanDAO.getInstance().delete(select);
                        JOptionPane.showMessageDialog(this, "Xoá thành công tài khoản !");
                        loadDataToTable(TaiKhoanDAO.getInstance().selectAll());
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Xoá thất bại !");
                    }
                }
            }
        }
    }//GEN-LAST:event_btnDeleteAccountActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtSearchPropertyChange
        // TODO add your handling code here:

    }//GEN-LAST:event_txtSearchPropertyChange

    private void txtSearchInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtSearchInputMethodTextChanged
        // TODO add your handling code here: 
    }//GEN-LAST:event_txtSearchInputMethodTextChanged

    private void btnresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetActionPerformed
        // TODO add your handling code here:
        loadDataToTable(accounts);
    }//GEN-LAST:event_btnresetActionPerformed

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtSearchKeyPressed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        String luachon = (String) cbxLuachon.getSelectedItem();
        String searchContent = txtSearch.getText();
        ArrayList<TaiKhoan> result = new ArrayList<>();
        switch (luachon) {
            case "Tất cả":
                 //result = SearchTaiKhoan.getInstance().searchTatCaAcc(searchContent);
                break;
            case "Tên tài khoản":
                // result = SearchTaiKhoan.getInstance().searchFullName(searchContent);
                break;
            case "Tên đăng nhập":
                // result = SearchTaiKhoan.getInstance().searchUserName(searchContent);
                break;
            case "Vai trò":
                // result = SearchTaiKhoan.getInstance().searchRole(searchContent);
                break;
        }
        loadDataToTable(result);
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnEditAccount1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditAccount1ActionPerformed
        // TODO add your handling code here:
        if (tblAccount.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn tài khoản cần đặt lại mật khẩu !");
        } else {
            int check = JOptionPane.showConfirmDialog(this, "Bạn có muổn reset tài khoản này ?", "Reset", JOptionPane.YES_NO_OPTION);
            if (check == JOptionPane.YES_OPTION) {
                String textct = JOptionPane.showInputDialog(this, "Nhập mật khẩu bạn muốn thay đổi: ");
                if (textct.equals("")) {
                    JOptionPane.showMessageDialog(this, "Không được để trống !");
                } else {
                    int row = tblAccount.getSelectedRow();
                    String userName = tblAccount.getValueAt(row, 1).toString();
                    TaiKhoan accReset = TaiKhoanDAO.getInstance().selectById(userName);
                    accReset.setMatKhau(BCrypt.hashpw(textct, BCrypt.gensalt(12)));
                    try {
                        TaiKhoanDAO.getInstance().update(accReset);
                        JOptionPane.showMessageDialog(this, "Thay đổi thành công !");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Thay đổi không thành công !");
                    }
                    accounts = TaiKhoanDAO.getInstance().selectAll();
                    loadDataToTable(accounts);
                }
            }
        }
    }//GEN-LAST:event_btnEditAccount1ActionPerformed

    public void openFile(String file) {
        try {
            File path = new File(file);
            Desktop.getDesktop().open(path);
        } catch (IOException e) {
            System.out.println(e);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDeleteAccount;
    private javax.swing.JButton btnEditAccount;
    private javax.swing.JButton btnEditAccount1;
    private javax.swing.JButton btnreset;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbxLuachon;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JToolBar jToolBar1;
    public javax.swing.JTable tblAccount;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

}
