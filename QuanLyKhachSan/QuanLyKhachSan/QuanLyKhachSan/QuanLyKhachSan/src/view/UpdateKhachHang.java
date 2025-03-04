package view;

import com.formdev.flatlaf.FlatLightLaf;
import dao.KhachHangDAO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import model.KhachHang;

public class UpdateKhachHang extends javax.swing.JDialog {

    /**
     * Creates new form AddAccount
     */
    private QuanLiKhachHangForm parent;

    public UpdateKhachHang(javax.swing.JInternalFrame parent, javax.swing.JFrame owner, boolean modal) {
        super(owner, modal);
        this.parent = (QuanLiKhachHangForm) parent;
        initComponents();
        setLocationRelativeTo(null);
        displayInfo();
    }

    private UpdateKhachHang(JFrame jFrame, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void displayInfo() {
        KhachHang a = parent.getNhaCungCapSelect();
        txtMaKH.setText(a.getMaKhachHang());
        txtTenKH.setText(a.getTenKhachHang());
        txtsdtKH.setText(a.getSoDienThoai());
        txtDiaChiKH.setText(a.getDiaChi());
        txtcmtKH.setText(a.getChungMinhThu());
        cbxgioitinh.setSelectedIndex(1);
        txtngaySinh.setText(a.getNgaySinh());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTenKH = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtsdtKH = new javax.swing.JTextField();
        txtDiaChiKH = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtcmtKH = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtngaySinh = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cbxgioitinh = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cập nhật thông tin");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Mã khách hàng");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 120, -1));

        txtMaKH.setEnabled(false);
        jPanel1.add(txtMaKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 298, 38));

        jLabel3.setText("Tên khách hàng");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, 24));
        jPanel1.add(txtTenKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 298, 38));

        jLabel4.setText("Ngay Sinh");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 100, -1));

        jLabel5.setText("Giới tính");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 520, 50, 20));

        jButton1.setBackground(new java.awt.Color(153, 0, 51));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Lưu");
        jButton1.setBorder(null);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 630, 140, 38));

        jButton2.setBackground(new java.awt.Color(51, 51, 51));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Huỷ");
        jButton2.setBorder(null);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 630, 140, 38));

        jPanel2.setBackground(new java.awt.Color(153, 0, 51));

        jLabel1.setFont(new java.awt.Font("SF Pro Display", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SỬA KHÁCH HÀNG");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(19, 19, 19))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 70));
        jPanel1.add(txtsdtKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 298, 38));
        jPanel1.add(txtDiaChiKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 298, 38));

        jLabel6.setText("Địa chỉ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 50, -1));
        jPanel1.add(txtcmtKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, 298, 38));

        jLabel7.setText("CCCD/CMND");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 80, -1));
        jPanel1.add(txtngaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 298, 38));

        jLabel8.setText("Số điện thoại");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 100, -1));

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
        jPanel1.add(cbxgioitinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 540, 300, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            KhachHang kh = new KhachHang();
  
            kh.setMaKhachHang(txtMaKH.getText());
            kh.setTenKhachHang(txtTenKH.getText());
            kh.setSoDienThoai(txtsdtKH.getText());
           
        
            kh.setChungMinhThu(txtcmtKH.getText());
               kh.setNgaySinh(txtngaySinh.getText());
            kh.setDiaChi(txtDiaChiKH.getText());
           
            kh.setGioiTinh(cbxgioitinh.getSelectedIndex() == 1) ;

            KhachHangDAO khDAO = new KhachHangDAO();
            khDAO.update(kh);
            this.dispose();
            JOptionPane.showMessageDialog(this, "Sửa thành công !");
            parent.loadDataToTable(KhachHangDAO.getInstance().selectAll());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Thất bại !");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cbxgioitinhItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxgioitinhItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxgioitinhItemStateChanged

    private void cbxgioitinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxgioitinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxgioitinhActionPerformed

    private void cbxgioitinhPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cbxgioitinhPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxgioitinhPropertyChange

    public static void main(String args[]) throws UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(new FlatLightLaf());
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UpdateKhachHang dialog = new UpdateKhachHang(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> cbxgioitinh;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtDiaChiKH;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtcmtKH;
    private javax.swing.JTextField txtngaySinh;
    private javax.swing.JTextField txtsdtKH;
    // End of variables declaration//GEN-END:variables
}
