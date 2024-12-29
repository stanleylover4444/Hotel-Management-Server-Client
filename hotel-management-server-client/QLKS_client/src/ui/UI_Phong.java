package ui;

import entity.Room;
import entity.RoomStatusType;
import entity.RoomType;
import javax.swing.JPanel;
import java.awt.*; 
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class UI_Phong extends javax.swing.JPanel {

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(61, 139, 233));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));
        jPanel1.setMinimumSize(new java.awt.Dimension(225, 210));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36));  
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("101");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 20));  
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Giường đơn");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-checkmark-48.png")));  
        jLabel1.setName("");  

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    } 

    private void formMouseClicked(java.awt.event.MouseEvent evt) { 
        // TODO add your handling code here:
    } 

    private void formMouseReleased(java.awt.event.MouseEvent evt) { 
        // TODO add your handling code here:
        jLabel1.setVisible(!jLabel1.isVisible()); 
    } 
    

    
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1; 
    
    Room phong = null; 
    public UI_Phong( Room phong1) {
        phong = phong1; 
        Color colorTrong = new Color(70, 141, 188); 
        Color colorDonDep = new Color(181, 171, 107); 
        Color colorBaoTri = new Color(240,119,37); 
        Color colorCoKhach = new Color(219,51,60); 
        Color colorDaDat = new Color(46,139,87);
        String typeDon = "Giường đơn"; 
        String typeDoi = "Giường đôi"; 
        String typeDoiLon = "Giường đôi lớn"; 
        
        
        initComponents();
        jLabel1.setVisible(false);
        
        
        jLabel4.setText("Giường đơn");
        if(phong.getRoomType().getRoomTypeID().equals("LP002"))
            jLabel4.setText("Giường đôi");
        if(phong.getRoomType().getRoomTypeID().equals("LP003"))
            jLabel4.setText("Giường đôi lớn");
        

        if( phong.getRoomStatusType().getRoomStatusTypeID().equals("LTTP001") ) {
            jPanel1.setBackground(colorTrong);
        }
        if( phong.getRoomStatusType().getRoomStatusTypeID().equals("LTTP002") ) 
            jPanel1.setBackground(colorCoKhach);
        if( phong.getRoomStatusType().getRoomStatusTypeID().equals("LTTP003") ) 
            jPanel1.setBackground(colorDaDat);
        if( phong.getRoomStatusType().getRoomStatusTypeID().equals("LTTP004") ) 
            jPanel1.setBackground(colorBaoTri);
        if( phong.getRoomStatusType().getRoomStatusTypeID().equals("LTTP005") ) 
            jPanel1.setBackground(colorDonDep);

        jLabel3.setText(phong.getRoomID());
    }
    
    public JPanel getBGR() {
        return jPanel1; 
    }
    
    public Room getRoom() {
        return phong; 
    }
    
    public boolean isSelect() {
        return jLabel1.isVisible(); 
    }
}
