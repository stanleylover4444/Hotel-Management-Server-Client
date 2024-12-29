package ui;

import java.awt.Desktop;
import java.io.File;
import javax.swing.JOptionPane;

public class GD_QLTroGiup extends javax.swing.JInternalFrame {
    private String username;
    public GD_QLTroGiup(String _username) {
        this.setRootPaneCheckingEnabled(false);
        javax.swing.plaf.InternalFrameUI ui
                = this.getUI();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) ui).setNorthPane(null);
        initComponents();
        this.setFocusable(true);
        username=_username;
    }
    @SuppressWarnings("unchecked")
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setBorder(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setFrameIcon(null);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        jLabel2.setText("Phần mềm được cài đặt trên máy tính và chạy không phụ thuộc vào mạng internet. Ngoài ra, nhà quản lý có thể theo dõi tình hình kinh doanh của cơ sở dễ dàng.");

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 22)); 
        jButton1.setText("Hướng dẫn sử dụng phần mềm");
        jButton1.setPreferredSize(new java.awt.Dimension(257, 47));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        jLabel3.setText("Đay là phần mềm quản lý cửa hàng chạy trên nền tảng Window.");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18));  
        jLabel4.setText("Nhằm mang đến cho quý khách hàng hài lòng nhất cũng như dễ dàng tiếp cận với hệ thống quản lý cửa hàng, chúng tôi đã đưa ra bản hướng dẫn sử dụng hệ thống quản lý khách sạn.");

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addGap(309, 309, 309)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addGap(389, 389, 389)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1372, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1607, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(3161, Short.MAX_VALUE))
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(jLabel3)
                .addGap(36, 36, 36)
                .addComponent(jLabel2)
                .addGap(27, 27, 27)
                .addComponent(jLabel4)
                .addGap(138, 138, 138)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(320, Short.MAX_VALUE))
        );

        getContentPane().add(pnlMain, java.awt.BorderLayout.CENTER);

        pack();
    } 

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) { 
       try{
           File file =new File ("D:\\Help.pdf");
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
    } 


     
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel pnlMain;
}
