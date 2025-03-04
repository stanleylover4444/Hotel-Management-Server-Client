/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Customizer.java to edit this template
 */
package view;

import com.formdev.flatlaf.FlatLightLaf;
import dao.DichVuDAO;
import java.text.DecimalFormat;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import model.DichVu;
import model.KhachHang;

/**
 *
 * @author ASUS
 */
public class UpdateDichVu extends javax.swing.JDialog {

    private QuanLiKhoDichVu parent;

    public UpdateDichVu(JInternalFrame parent, JFrame owner, boolean modal) {
       super(owner, modal);
    this.parent = (QuanLiKhoDichVu) parent; // Giả sử QuanLiKhoDichVu là subclass của JInternalFrame
    initComponents();
    setSize(400, 600); // Thiết lập kích thước trước khi gọi setLocationRelativeTo
    setLocationRelativeTo(null); // Đặt vị trí trung tâm sau khi kích thước đã được xác định
    displayInfo();

    }

    private void displayInfo() {
        DichVu a = parent.getDVSelect();
        txtMaDv2.setText(a.getMaDichVu());
        txtTenDV2.setText(a.getTenDichVu());
        txtsoluongdv.setText(String.valueOf(a.getSoLuong()));

        DecimalFormat df = new DecimalFormat("#.##");
        txtgiadv.setText(df.format(a.getGia()));

    }

    public static void main(String args[]) throws UnsupportedLookAndFeelException {
         UIManager.setLookAndFeel(new FlatLightLaf());
    /* Create and display the dialog */
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            JInternalFrame parentFrame = new JInternalFrame();
            UpdateDichVu dialog = new UpdateDichVu(parentFrame, new JFrame(), true);
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


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtMaDv2 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtTenDV2 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btnsave2 = new javax.swing.JButton();
        btnHuy2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtsoluongdv = new javax.swing.JTextField();
        txtgiadv = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setText("Mã Dịch Vụ");
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 70, -1));

        txtMaDv2.setEnabled(false);
        txtMaDv2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaDvActionPerformed(evt);
            }
        });
        jPanel6.add(txtMaDv2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 298, 38));

        jLabel11.setText("Tên dịch vụ");
        jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, 24));
        jPanel6.add(txtTenDV2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 298, 38));

        jLabel12.setText("Số lượng");
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 100, -1));

        btnsave2.setBackground(new java.awt.Color(153, 0, 51));
        btnsave2.setForeground(new java.awt.Color(255, 255, 255));
        btnsave2.setText("Lưu");
        btnsave2.setBorder(null);
        btnsave2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnsave2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });
        jPanel6.add(btnsave2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 140, 38));

        btnHuy2.setBackground(new java.awt.Color(51, 51, 51));
        btnHuy2.setForeground(new java.awt.Color(255, 255, 255));
        btnHuy2.setText("Huỷ");
        btnHuy2.setBorder(null);
        btnHuy2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHuy2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });
        jPanel6.add(btnHuy2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 450, 140, 38));

        jPanel5.setBackground(new java.awt.Color(153, 0, 51));

        jLabel13.setFont(new java.awt.Font("SF Pro Display", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("SỬA DỊCH VỤ");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(110, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(17, 17, 17))
        );

        jPanel6.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 70));
        jPanel5.getAccessibleContext().setAccessibleName("");

        jPanel6.add(txtsoluongdv, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 298, 38));
        jPanel6.add(txtgiadv, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 298, 38));

        jLabel6.setText("Đơn giá");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 50, -1));

        getContentPane().add(jPanel6, java.awt.BorderLayout.CENTER);
        jPanel6.getAccessibleContext().setAccessibleName("Cập nhập dịch vụ");
    }// </editor-fold>//GEN-END:initComponents

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        try {
            // Kiểm tra xem các trường số lượng và giá đã được nhập chưa
            if (txtsoluongdv.getText().isEmpty() || txtgiadv.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!");
                return; // Kết thúc phương thức nếu có trường không được nhập
            }

            // Lấy giá trị từ các trường nhập liệu
            String maDichVu = txtMaDv2.getText();
            String tenDichVu = txtTenDV2.getText();
            int soLuong = Integer.parseInt(txtsoluongdv.getText());
            double gia = Double.parseDouble(txtgiadv.getText());

            // Tạo đối tượng DichVu với thông tin vừa lấy được
            DichVu dv = new DichVu();
            dv.setMaDichVu(maDichVu);
            dv.setTenDichVu(tenDichVu);
            dv.setSoLuong(soLuong);
            dv.setGia(gia);

            // Cập nhật dịch vụ trong CSDL
            DichVuDAO dvDAO = new DichVuDAO();
            dvDAO.update(dv);

            // Hiển thị thông báo và cập nhật lại bảng dữ liệu trong parent form
            JOptionPane.showMessageDialog(this, "Sửa thành công !");
            parent.loadDataToTable(DichVuDAO.getInstance().selectAll());

            this.dispose();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Số lượng và giá phải là số!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Thất bại !");
        }
    }//GEN-LAST:event_btnsaveActionPerformed

    private void txtMaDvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaDvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaDvActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy2;
    private javax.swing.JButton btnsave2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTextField txtMaDv2;
    private javax.swing.JTextField txtTenDV2;
    private javax.swing.JTextField txtgiadv;
    private javax.swing.JTextField txtsoluongdv;
    // End of variables declaration//GEN-END:variables
}
