/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import dao.ChiTietHoaDonPhongDAO;

import dao.PhongDAO;

import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import model.ChiTietHoaDonPhong;


import model.DichVu;
import model.Phong;

public class ChuyenPhongForm extends javax.swing.JDialog {

    /**
     * Creates new form ThemSP
     */    
    // private ProductForm owner;
    private QuanLiPhongForm owner;
     private DefaultTableModel tblModel;
    private static ArrayList<Phong> phong;
     
    public ChuyenPhongForm(javax.swing.JInternalFrame parent, javax.swing.JFrame owner, boolean modal) {
        super(owner, modal);
        this.owner = (QuanLiPhongForm) parent;
        initComponents();
        initTable();
        displayInfo();
        setLocationRelativeTo(null);
        
         txtPhongDangO.setEnabled(false);
         txtPhongDangO1.setEnabled(false);
            
            
        tblDuLieuPhong.setDefaultEditor(Object.class, null);
        phong = PhongDAO.getInstance().selectAll();
        loadDataToTablePhong(phong);
    }
    
    
private void displayInfo() {
        ChiTietHoaDonPhong a = owner.getNhaCungCapSelect();
        txtPhongDangO.setText(a.getMaPhong());
        txtPhongDangO1.setText(a.getLoaiPhong());
        
    }
   public final void initTable() {
        tblModel = new DefaultTableModel();
        String[] headerTbl = new String[]{"Mã phòng", "Loại Phòng","Trạng Thái"};
        tblModel.setColumnIdentifiers(headerTbl);
        tblDuLieuPhong.setModel(tblModel);
    }
    public void loadDataToTablePhong(ArrayList<Phong> phong) {
        try {
            tblModel.setRowCount(0);
            for (Phong i : phong) {
                tblModel.addRow(new Object[]{
                    i.getMaPhong(), i.getLoaiPhong(),i.getTinhtrangPhong()});
            }
        } catch (Exception e) {
        }
    }


    private ChuyenPhongForm(JFrame jFrame, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtDonGia1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtPhongDangO = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnChuyenPhong = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtPhongDangO1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDuLieuPhong = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbxPhongMuonChuyen = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Thêm sản phẩm mới");
        setPreferredSize(new java.awt.Dimension(790, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Phòng đang ở ");

        txtPhongDangO.setEditable(false);
        txtPhongDangO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhongDangOActionPerformed(evt);
            }
        });

        jLabel4.setText("Phòng muốn chuyển");

        btnChuyenPhong.setBackground(new java.awt.Color(153, 0, 51));
        btnChuyenPhong.setForeground(new java.awt.Color(255, 255, 255));
        btnChuyenPhong.setText("Chuyển Phòng ");
        btnChuyenPhong.setBorder(null);
        btnChuyenPhong.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnChuyenPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChuyenPhongActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(51, 51, 51));
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Huỷ bỏ");
        btnCancel.setBorder(null);
        btnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jPanel3.setLayout(new java.awt.CardLayout());

        jLabel3.setText("Loại Phòng Đang Ở");

        txtPhongDangO1.setEditable(false);

        tblDuLieuPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã phòng", "Loại phòng", "Tình trạng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDuLieuPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDuLieuPhongMouseClicked(evt);
            }
        });
        tblDuLieuPhong.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                tblDuLieuPhongVetoableChange(evt);
            }
        });
        jScrollPane1.setViewportView(tblDuLieuPhong);

        jLabel6.setForeground(new java.awt.Color(153, 0, 51));
        jLabel6.setText("* Chỉ được phép chuyển qua");

        jLabel7.setForeground(new java.awt.Color(153, 0, 51));
        jLabel7.setText("các phòng cũng loại phòng");

        jLabel8.setForeground(new java.awt.Color(153, 0, 51));
        jLabel8.setText("đang ở");

        cbxPhongMuonChuyen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "P1.01", "P1.02", "P1.03", "P1.04", "P1.05", "P2.01", "P2.02", "P2.03", "P2.04", "P2.05", "P3.01", "P3.02", "P3.03", "P3.04", "P3.05" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addComponent(btnChuyenPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(114, 114, 114)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(121, 121, 121)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPhongDangO, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(txtPhongDangO1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbxPhongMuonChuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxPhongMuonChuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPhongDangO, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPhongDangO1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel8)
                        .addGap(228, 228, 228))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnChuyenPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 800, 510));

        jPanel2.setBackground(new java.awt.Color(153, 0, 51));
        jPanel2.setPreferredSize(new java.awt.Dimension(790, 60));

        jLabel1.setFont(new java.awt.Font("SF Pro Display", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Chuyển Phòng");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(334, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(289, 289, 289))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnChuyenPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChuyenPhongActionPerformed
   // 1. Lấy thông tin về phòng đang ở và phòng muốn chuyển
    String maPhong = txtPhongDangO.getText().trim();
    Object selectedItem = cbxPhongMuonChuyen.getSelectedItem();
String phongMuonChuyen = (selectedItem != null) ? selectedItem.toString().trim() : "";

    
    String trangThaiPhongDangO = PhongDAO.getInstance().getTrangThaiPhong(maPhong);
    String trangThaiPhongMuonChuyen = PhongDAO.getInstance().getTrangThaiPhong(phongMuonChuyen);

    // Kiểm tra nếu phòng đang ở hoặc phòng muốn chuyển có trạng thái "Đang Sửa", "Đang Dọn" hoặc "Có Khách"
   if (trangThaiPhongMuonChuyen.equals("Sẵn Sàng")) {
    // Cho phép chuyển phòng
} else {
    JOptionPane.showMessageDialog(this, "Phòng muốn chuyển không ở trạng thái 'Sẵn Sàng'.", "Lỗi", JOptionPane.ERROR_MESSAGE);
    return; // Dừng thực hiện phương thức nếu phòng không thể chuyển
}

    // Kiểm tra xem phòng muốn chuyển có phù hợp với yêu cầu hay không
    if ((maPhong.matches("P1\\.0[1-5]") && 
     !(phongMuonChuyen.matches("P2\\.0[1-5]") || 
       phongMuonChuyen.matches("P3\\.0[1-3]") || 
       phongMuonChuyen.matches("P3\\.0[4-5]"))) ||

    (maPhong.matches("P2\\.0[1-5]") && 
     !(phongMuonChuyen.matches("P3\\.0[1-3]") || 
       phongMuonChuyen.matches("P1\\.0[1-5]") || 
       phongMuonChuyen.matches("P3\\.0[4-5]"))) ||

    (maPhong.matches("P3\\.0[1-3]") && 
     !(phongMuonChuyen.matches("P2\\.0[1-5]") || 
       phongMuonChuyen.matches("P1\\.0[1-5]") || 
       phongMuonChuyen.matches("P3\\.0[4-5]"))) ||

    (maPhong.matches("P3\\.0[4-5]") && 
     !(phongMuonChuyen.matches("P2\\.0[1-5]") || 
       phongMuonChuyen.matches("P1\\.0[1-5]") || 
       phongMuonChuyen.matches("P3\\.0[1-3]")))) {
    // Thực hiện các hành động khi phòng muốn chuyển hợp lệ
} else {
   JOptionPane.showMessageDialog(this, "Phòng muốn chuyển không cùng loại", "Lỗi", JOptionPane.ERROR_MESSAGE);
    return; // Dừng thực hiện phương thức nếu phòng không hợp lệ
     
}
     
    
     
    // 2. Cập nhật trạng thái của phòng đang ở thành "Đang Dọn"
    int updateOldRoomStatus = PhongDAO.getInstance().updateTrangThai(maPhong, "Đang Dọn");
    
    // 3. Cập nhật trạng thái của phòng mới thành "Có Khách"
    int updateNewRoomStatus = PhongDAO.getInstance().updateTrangThai(phongMuonChuyen, "Có Khách");
    
    // 4. Kiểm tra xem cả hai cập nhật đều thành công hay không
    if (updateOldRoomStatus > 0 && updateNewRoomStatus > 0) {
        // Tạo một đối tượng mới của ChiTietHoaDonPhong để cập nhật mã phòng mới
        ChiTietHoaDonPhong chiTietPhong = new ChiTietHoaDonPhong();
        chiTietPhong.setMaPhong(phongMuonChuyen);
        
        // Lưu thay đổi vào cơ sở dữ liệu
        int updateChiTietPhong = ChiTietHoaDonPhongDAO.getInstance().updateMaPhong(maPhong, chiTietPhong);
        
        if (updateChiTietPhong > 0) {
            JOptionPane.showMessageDialog(this, "Chuyển phòng thành công !");
            
            // Đóng form Chuyển Phòng
            this.dispose();
            
            // Cập nhật lại dữ liệu trên giao diện chính sau khi chuyển phòng thành công
            owner.loadDataToTablePhong(PhongDAO.getInstance().selectAll());
            owner.loadDateToTablePTP(ChiTietHoaDonPhongDAO.getInstance().selectAll());
            owner.setColorForPanels();
        } else {
            JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi khi cập nhật thông tin chi tiết phòng. Vui lòng thử lại !", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi. Vui lòng thử lại !", "Lỗi", JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_btnChuyenPhongActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void tblDuLieuPhongVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_tblDuLieuPhongVetoableChange
   
    }//GEN-LAST:event_tblDuLieuPhongVetoableChange

    private void tblDuLieuPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDuLieuPhongMouseClicked
      

    }//GEN-LAST:event_tblDuLieuPhongMouseClicked

    private void txtPhongDangOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhongDangOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhongDangOActionPerformed
   
    /**
     * @param args the command line arguments
     */
    

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ChuyenPhongForm dialog = new ChuyenPhongForm(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnChuyenPhong;
    private javax.swing.JComboBox<String> cbxPhongMuonChuyen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDuLieuPhong;
    private javax.swing.JTextField txtDonGia1;
    private javax.swing.JTextField txtPhongDangO;
    private javax.swing.JTextField txtPhongDangO1;
    // End of variables declaration//GEN-END:variables
}
