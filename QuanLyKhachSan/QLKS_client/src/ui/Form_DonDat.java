
package ui;
import java.awt.Desktop;

import java.awt.Graphics2D;
import java.io.File;
import java.io.FileOutputStream;

import java.text.DecimalFormat;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import javax.swing.table.DefaultTableModel;

public class Form_DonDat extends javax.swing.JFrame {

    private static String maHD;
    public DefaultTableModel modalXuatHoaDon;

    DecimalFormat df = new DecimalFormat("#,##0 VND");

    public Form_DonDat(String ma) {
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.addInternalFrameListener(new InternalFrameAdapter() {
    @Override
    public void internalFrameClosing(InternalFrameEvent e) {
        dispose(); // Ä�Ã³ng frame hÃ³a Ä‘Æ¡n
    }
});

        maHD = ma;
        initComponents();
        setLocationRelativeTo(null);

    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
//
        jPanel3 = new javax.swing.JPanel();
        pnlHoaDon = new javax.swing.JPanel();
        pblTren = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lblNgay = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblThuNgan = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        lblMaPhieu = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblTenKH = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        pnlGiua = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        lblKM = new javax.swing.JPanel();
        lblKhuyenMai = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        pnlDuoi = new javax.swing.JPanel();
        btnHoanThanh = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnIn = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pnlHoaDon.setPreferredSize(new java.awt.Dimension(515, 790));
        pnlHoaDon.setLayout(new javax.swing.BoxLayout(pnlHoaDon, javax.swing.BoxLayout.Y_AXIS));

        pblTren.setLayout(new javax.swing.BoxLayout(pblTren, javax.swing.BoxLayout.Y_AXIS));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("ĐƠN ĐẶT PHÒNG");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Quận Gò Vấp, Thành Phố Hồ Chí Minh");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Khách Sạn H&M");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("SDT: 08214851251");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Địac chỉ: 12 Nguyễn Văn Bảo, phường 4");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 523, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 114, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1)
                    .addGap(0, 0, 0)
                    .addComponent(jLabel2)
                    .addGap(0, 0, 0)
                    .addComponent(jLabel3)
                    .addGap(0, 0, 0)
                    .addComponent(jLabel4)
                    .addGap(0, 0, 0)
                    .addComponent(jLabel5)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pblTren.add(jPanel5);

        jPanel10.setLayout(new javax.swing.BoxLayout(jPanel10, javax.swing.BoxLayout.X_AXIS));

        jPanel14.setMaximumSize(new java.awt.Dimension(20, 32767));
        jPanel14.setPreferredSize(new java.awt.Dimension(20, 40));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        jPanel10.add(jPanel14);

        jPanel12.setLayout(new java.awt.GridLayout(3, 2));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Ngày:");
        jPanel12.add(jLabel6);

        lblNgay.setText("24/10/2022");
        jPanel12.add(lblNgay);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Thu ngân:");
        jPanel12.add(jLabel7);

        lblThuNgan.setText("Nguyễn Văn A");
        jPanel12.add(lblThuNgan);

        jLabel17.setText("CCCD:");
        jPanel12.add(jLabel17);

        jLabel18.setText("2302555663");
        jPanel12.add(jLabel18);

        jPanel10.add(jPanel12);

        jPanel15.setMaximumSize(new java.awt.Dimension(50, 32767));
        jPanel15.setPreferredSize(new java.awt.Dimension(50, 40));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        jPanel10.add(jPanel15);

        jPanel11.setLayout(new java.awt.GridLayout(2, 2));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Mã phiếu");
        jPanel11.add(jLabel8);

        lblMaPhieu.setText("DD001");
        jPanel11.add(lblMaPhieu);

        jLabel9.setText("Khách hàng");
        jPanel11.add(jLabel9);

        lblTenKH.setText("Ngô Đình Bảo Yến");
        jPanel11.add(lblTenKH);

        jPanel10.add(jPanel11);

        jPanel13.setMaximumSize(new java.awt.Dimension(20, 32767));
        jPanel13.setPreferredSize(new java.awt.Dimension(20, 40));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        jPanel10.add(jPanel13);

        pblTren.add(jPanel10);

        pnlHoaDon.add(pblTren);

        jPanel8.setLayout(new javax.swing.BoxLayout(jPanel8, javax.swing.BoxLayout.X_AXIS));

        jPanel16.setMaximumSize(new java.awt.Dimension(1200, 600));
        jPanel16.setMinimumSize(new java.awt.Dimension(50, 50));
        jPanel16.setPreferredSize(new java.awt.Dimension(60, 600));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 64, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 474, Short.MAX_VALUE)
        );

        jPanel8.add(jPanel16);

        jPanel6.setLayout(new java.awt.GridLayout(4, 2));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel21.setText("Phòng: ");
        jPanel6.add(jLabel21);

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel25.setText("P001");
        jPanel6.add(jLabel25);

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel19.setText("Đơn giá phòng: ");
        jPanel6.add(jLabel19);

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel24.setText("6.000.000");
        jPanel6.add(jLabel24);

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel22.setText("Giờ nhận phòng: ");
        jPanel6.add(jLabel22);

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel23.setText("15:30");
        jPanel6.add(jLabel23);

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel20.setText("Ngày nhận phòng:");
        jPanel6.add(jLabel20);

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel26.setText("24/04/2023");
        jPanel6.add(jLabel26);

        jPanel8.add(jPanel6);

        jPanel17.setMaximumSize(new java.awt.Dimension(1200, 600));
        jPanel17.setMinimumSize(new java.awt.Dimension(50, 50));
        jPanel17.setPreferredSize(new java.awt.Dimension(60, 600));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 64, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 474, Short.MAX_VALUE)
        );

        jPanel8.add(jPanel17);

        pnlHoaDon.add(jPanel8);

        pnlGiua.setLayout(new javax.swing.BoxLayout(pnlGiua, javax.swing.BoxLayout.X_AXIS));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 88, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );

        pnlGiua.add(jPanel4);

        jPanel2.setMaximumSize(new java.awt.Dimension(500, 32767));
        jPanel2.setPreferredSize(new java.awt.Dimension(350, 122));
        jPanel2.setLayout(new java.awt.GridLayout(1, 2));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Khuyến mãi: ");
        jPanel2.add(jLabel11);

        lblKM.setLayout(new javax.swing.BoxLayout(lblKM, javax.swing.BoxLayout.X_AXIS));

        lblKhuyenMai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblKhuyenMai.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblKhuyenMai.setText("10%");
        lblKhuyenMai.setMaximumSize(new java.awt.Dimension(700, 900));
        lblKhuyenMai.setMinimumSize(new java.awt.Dimension(80, 0));
        lblKhuyenMai.setPreferredSize(new java.awt.Dimension(80, 0));
        lblKM.add(lblKhuyenMai);

        jPanel2.add(lblKM);
        jPanel2.add(jLabel16);

        pnlGiua.add(jPanel2);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 84, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );

        pnlGiua.add(jPanel9);

        pnlHoaDon.add(pnlGiua);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 523, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlHoaDon.add(jPanel7);

        pnlDuoi.setLayout(new javax.swing.BoxLayout(pnlDuoi, javax.swing.BoxLayout.X_AXIS));

        btnHoanThanh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnHoanThanh.setText("Hoàn thành");
        btnHoanThanh.setMaximumSize(new java.awt.Dimension(107, 40));
        btnHoanThanh.setPreferredSize(new java.awt.Dimension(107, 40));
        btnHoanThanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoanThanhActionPerformed(evt);
            }
        });
        pnlDuoi.add(btnHoanThanh);

        jPanel1.setMaximumSize(new java.awt.Dimension(50, 60));
        jPanel1.setMinimumSize(new java.awt.Dimension(20, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(50, 50));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 44, Short.MAX_VALUE)
        );

        pnlDuoi.add(jPanel1);

        btnIn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnIn.setText("In hóa đơn");
        btnIn.setMaximumSize(new java.awt.Dimension(103, 40));
        btnIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInActionPerformed(evt);
            }
        });
        pnlDuoi.add(btnIn);

        pnlHoaDon.add(pnlDuoi);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 523, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 790, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnlHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHoanThanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoanThanhActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnHoanThanhActionPerformed

    private void btnInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInActionPerformed
        JOptionPane.showMessageDialog(null, "In hóa đơn thành công");
        this.setVisible(false);
//        PrintFrameToPDF(pnlHoaDon);
         try{
           File file =new File ("C:\\Users\\bohie\\OneDrive\\Documents\\GitHub\\BHTT_JAVA\\BHTT\\HoaDon.pdf");
           if(file.exists()) {
               if(Desktop.isDesktopSupported()){
                   Desktop.getDesktop().open(file);
               }else{
                   JOptionPane.showMessageDialog(this, "Not Supported");
               }
           }else{
               JOptionPane.showMessageDialog(this, "File Not Exist");
           }
       }catch(Exception e){
           e.printStackTrace();
       }

    }//GEN-LAST:event_btnInActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.setVisible(false);
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Form_DonDat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_DonDat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_DonDat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_DonDat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_DonDat(maHD).setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHoanThanh;
    private javax.swing.JButton btnIn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel lblKM;
    private javax.swing.JLabel lblKhuyenMai;
    private javax.swing.JLabel lblMaPhieu;
    private javax.swing.JLabel lblNgay;
    private javax.swing.JLabel lblTenKH;
    private javax.swing.JLabel lblThuNgan;
    private javax.swing.JPanel pblTren;
    private javax.swing.JPanel pnlDuoi;
    private javax.swing.JPanel pnlGiua;
    private javax.swing.JPanel pnlHoaDon;
    // End of variables declaration//GEN-END:variables

    private void addInternalFrameListener(InternalFrameAdapter internalFrameAdapter) {
    }
}
