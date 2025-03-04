/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import dao.ChiTietHoaDonDichVuDAO;
import dao.ChiTietHoaDonPhongDAO;
import dao.HoaDonDichVuDAO;
import dao.HoaDonPhongDAO;
import dao.TaiKhoanDAO;

import dao.KhachHangDAO;

import java.awt.Desktop;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import model.ChiTietHoaDonDichVu;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.Iterator;
import model.ChiTietHoaDonPhong;
import model.HoaDonPhong;
import model.TaiKhoan;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class HoaDonPhongForm extends javax.swing.JInternalFrame {

    private DefaultTableModel tblModel;
    DecimalFormat formatter = new DecimalFormat("###,###,###");
    SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/YYYY HH:mm");

    public DecimalFormat getFormatter() {
        return formatter;
    }

    public SimpleDateFormat getFormatDate() {
        return formatDate;
    }

    public HoaDonPhongForm(TaiKhoan accCur) {
        initComponents();
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        tblPhieuNhap.setDefaultEditor(Object.class, null);
        initTable();
        loadDataToTable();
        changeTextFind();
        jDateChooserFrom.setDateFormatString("dd/MM/yyyy");
        jDateChooserTo.setDateFormatString("dd/MM/yyyy");
        if (accCur.getVaiTro().equals("Nhân viên nhập")) {
         

        }
    }

    public final void initTable() {
        tblModel = new DefaultTableModel();
        String[] headerTbl = new String[]{"STT", "Mã hóa đơn phòng", "Người tạo"," Tên khách hàng ","Phòng được thuê " ,"Thời gian tạo", "Tổng tiền"};
        tblModel.setColumnIdentifiers(headerTbl);
        tblPhieuNhap.setModel(tblModel);
        tblPhieuNhap.getColumnModel().getColumn(0).setPreferredWidth(30);
        tblPhieuNhap.getColumnModel().getColumn(1).setPreferredWidth(60);
        tblPhieuNhap.getColumnModel().getColumn(2).setPreferredWidth(40);
        tblPhieuNhap.getColumnModel().getColumn(3).setPreferredWidth(60);
        tblPhieuNhap.getColumnModel().getColumn(4).setPreferredWidth(50);
        tblPhieuNhap.getColumnModel().getColumn(4).setPreferredWidth(50);
    }

  public void loadDataToTable() {
    try {
        ArrayList<HoaDonPhong> allPhieuNhap = HoaDonPhongDAO.getInstance().selectAll();
        if (!allPhieuNhap.isEmpty()) { // Kiểm tra nếu danh sách dữ liệu không trống
            tblModel.setRowCount(0); // Xóa dữ liệu cũ trong bảng
            for (int i = 0; i < allPhieuNhap.size(); i++) {
                tblModel.addRow(new Object[]{
                  i + 1, allPhieuNhap.get(i).getMaHoaDonPhong(),allPhieuNhap.get(i).getNguoiTao(),allPhieuNhap.get(i).getTenKH(),allPhieuNhap.get(i).getMaPhong(),formatDate.format(allPhieuNhap.get(i).getCheckOut()), formatter.format(allPhieuNhap.get(i).getTongTienKHTra()) + "đ"
                });
            }
        } else {
            // Hiển thị thông báo hoặc thực hiện hành động phù hợp nếu không có dữ liệu
            // Ví dụ: JOptionPane.showMessageDialog(this, "Không có dữ liệu để hiển thị.");
        }
    } catch (Exception e) {
        // Xử lý ngoại lệ nếu có
        e.printStackTrace();
    }
}
  
    private void loadDataToTableSearch(ArrayList<HoaDonPhong> result) {
        try {

            tblModel.setRowCount(0);
            for (int i = 0; i < result.size(); i++) {
                tblModel.addRow(new Object[]{
                    i + 1, result.get(i).getMaHoaDonPhong(), 
                    result.get(i).getNguoiTao() , result.get(i).getTenKH() ,
                    result.get(i).getMaPhong(), formatDate.format(result.get(i).getCheckOut()),
                    formatter.format(result.get(i).getTongTienKHTra()) + "đ"
                });
            }
        } catch (Exception e) {
        }
    }


   
    public ArrayList<HoaDonPhong> searchTatCa(String text) {
        ArrayList<HoaDonPhong> result = new ArrayList<>();
        ArrayList<HoaDonPhong> armt = HoaDonPhongDAO.getInstance().selectAll();
        for (var phieu : armt) {
            if (phieu.getMaHoaDonPhong().toLowerCase().contains(text.toLowerCase())
                    || phieu.getMaKH().toLowerCase().contains(text.toLowerCase())
                    || phieu.getNguoiTao().toLowerCase().contains(text.toLowerCase())) {
                result.add(phieu);
            

        }
       
    }
        return result;
    }
    public ArrayList<HoaDonPhong> searchMaHoaDonPhong(String text) {
        ArrayList<HoaDonPhong> result = new ArrayList<>();
        ArrayList<HoaDonPhong> armt = HoaDonPhongDAO.getInstance().selectAll();
        for (var phieu : armt) {
            if (phieu.getMaHoaDonPhong().toLowerCase().contains(text.toLowerCase())) {
                result.add(phieu);
            }

        }
        return result;
    }
    public ArrayList<HoaDonPhong> searchTenKH(String text) {
        ArrayList<HoaDonPhong> result = new ArrayList<>();
        ArrayList<HoaDonPhong> armt = HoaDonPhongDAO.getInstance().selectAll();
        for (var phieu : armt) {
            if (phieu.getTenKH().toLowerCase().contains(text.toLowerCase())) {
                result.add(phieu);
            }

        }
        return result;
    }
//
    public ArrayList<HoaDonPhong> searchNguoiTao(String text) {
        ArrayList<HoaDonPhong> result = new ArrayList<>();
        ArrayList<HoaDonPhong> armt = HoaDonPhongDAO.getInstance().selectAll();
        for (var phieu : armt) {
            if (phieu.getNguoiTao().toLowerCase().contains(text.toLowerCase())) {
                result.add(phieu);
            }

        }
        return result;
    }
    public void changeTextFind() {
        jTextFieldSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                /* do nothing */
                if (jTextFieldSearch.getText().length() == 0) {
                    loadDataToTable();
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });
    }
    
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        btnDetail = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jComboBoxLuaChon = new javax.swing.JComboBox<>();
        jTextFieldSearch = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPhieuNhap = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jDateChooserFrom = new com.toedter.calendar.JDateChooser();
        jDateChooserTo = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        giaTu = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        giaDen = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(1380, 859));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1380, 859));

        jToolBar1.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar1.setBorder(javax.swing.BorderFactory.createTitledBorder("Chức năng"));
        jToolBar1.setRollover(true);

        btnDetail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/eye.png"))); // NOI18N
        btnDetail.setText("Xem chi tiết");
        btnDetail.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDetail.setFocusable(false);
        btnDetail.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDetail.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailActionPerformed(evt);
            }
        });
        jToolBar1.add(btnDetail);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBoxLuaChon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Mã hóa đơn", "Người tạo" }));
        jComboBoxLuaChon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxLuaChonActionPerformed(evt);
            }
        });
        jPanel3.add(jComboBoxLuaChon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 210, 40));

        jTextFieldSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldSearchKeyReleased(evt);
            }
        });
        jPanel3.add(jTextFieldSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, 310, 40));

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refresh.png"))); // NOI18N
        jButton7.setText("Làm mới");
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 30, 140, 40));

        tblPhieuNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblPhieuNhap);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Lọc theo ngày"));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jDateChooserFrom.setBackground(new java.awt.Color(255, 255, 255));
        jDateChooserFrom.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooserFromPropertyChange(evt);
            }
        });
        jDateChooserFrom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jDateChooserFromKeyReleased(evt);
            }
        });
        jPanel4.add(jDateChooserFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 170, -1));

        jDateChooserTo.setBackground(new java.awt.Color(255, 255, 255));
        jDateChooserTo.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooserToPropertyChange(evt);
            }
        });
        jDateChooserTo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jDateChooserToKeyReleased(evt);
            }
        });
        jPanel4.add(jDateChooserTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, 170, -1));

        jLabel1.setText("Đến");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 40, 20));

        jLabel5.setFont(new java.awt.Font("SF Pro Display", 0, 14)); // NOI18N
        jLabel5.setText("Từ");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 20, 20));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Lọc theo giá"));

        giaTu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                giaTuActionPerformed(evt);
            }
        });
        giaTu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                giaTuKeyReleased(evt);
            }
        });

        jLabel4.setText("Đến");

        giaDen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                giaDenActionPerformed(evt);
            }
        });
        giaDen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                giaDenKeyReleased(evt);
            }
        });

        jLabel3.setText("Từ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(giaTu, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97)
                .addComponent(jLabel4)
                .addGap(28, 28, 28)
                .addComponent(giaDen, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(giaTu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(giaDen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(146, 146, 146)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1282, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents



    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        loadDataToTable();
        jComboBoxLuaChon.setSelectedIndex(0);
        jTextFieldSearch.setText("");
        jDateChooserFrom.setCalendar(null);
        jDateChooserTo.setCalendar(null);
        giaDen.setText("");
        giaTu.setText("");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void btnDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailActionPerformed
        if (tblPhieuNhap.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn cần sửa");
        } else {
            ChiTietHoaDonPhongForm a = new ChiTietHoaDonPhongForm(this, (JFrame) javax.swing.SwingUtilities.getWindowAncestor(this), rootPaneCheckingEnabled);
            a.setVisible(true);
        }
    }//GEN-LAST:event_btnDetailActionPerformed

    private void giaDenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_giaDenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_giaDenActionPerformed

    private void jComboBoxLuaChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxLuaChonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxLuaChonActionPerformed

    private void jTextFieldSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchKeyReleased
        // TODO add your handling code here:
        searchAllRepect();
    }//GEN-LAST:event_jTextFieldSearchKeyReleased

    private void giaTuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_giaTuActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_giaTuActionPerformed

    private void giaTuKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_giaTuKeyReleased
        // TODO add your handling code here:
        searchAllRepect();
    }//GEN-LAST:event_giaTuKeyReleased

    private void jDateChooserFromKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooserFromKeyReleased
        // TODO add your handling code here:
        searchAllRepect();
    }//GEN-LAST:event_jDateChooserFromKeyReleased

    private void jDateChooserToKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooserToKeyReleased
        // TODO add your handling code here:
        searchAllRepect();
    }//GEN-LAST:event_jDateChooserToKeyReleased

    private void giaDenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_giaDenKeyReleased
        // TODO add your handling code here:
        searchAllRepect();
        System.out.println(giaDen.getText());
    }//GEN-LAST:event_giaDenKeyReleased

    private void jDateChooserFromPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooserFromPropertyChange
        // TODO add your handling code here:
        searchAllRepect();
    }//GEN-LAST:event_jDateChooserFromPropertyChange

    private void jDateChooserToPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooserToPropertyChange
        // TODO add your handling code here:
        searchAllRepect();
    }//GEN-LAST:event_jDateChooserToPropertyChange

     public boolean checkDate(Date dateTest, Date star, Date end) {
        return dateTest.getTime() >= star.getTime() && dateTest.getTime() <= end.getTime();
    }

    public ArrayList<HoaDonPhong> searchDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        ArrayList<HoaDonPhong> result = new ArrayList<HoaDonPhong>();
        Date from = jDateChooserFrom.getDate();
        Date to = jDateChooserTo.getDate();
        ArrayList<HoaDonPhong> armt = HoaDonPhongDAO.getInstance().selectAll();
        for (var phieu : armt) {
            System.out.println("From:" + from + " " + from.getTime());
            System.out.println("To: " + to + " " + to.getTime());
            System.out.println("Current: " + phieu.getCheckOut() + " " + phieu.getCheckOut().getTime());
            System.out.println("Check: " + checkDate(phieu.getCheckOut(), from, to));
            if (checkDate(phieu.getCheckOut(), from, to)) {
                result.add(phieu);
            }

        }
        return result;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetail;
    private javax.swing.JTextField giaDen;
    private javax.swing.JTextField giaTu;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBoxLuaChon;
    private com.toedter.calendar.JDateChooser jDateChooserFrom;
    private com.toedter.calendar.JDateChooser jDateChooserTo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldSearch;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tblPhieuNhap;
    // End of variables declaration//GEN-END:variables

    private void openFile(String file) {
        try {
            File path = new File(file);
            Desktop.getDesktop().open(path);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void searchAllRepect() {
        String luaChon = jComboBoxLuaChon.getSelectedItem().toString();
        String content = jTextFieldSearch.getText();
        ArrayList<HoaDonPhong> result = null;
        if (content.length() > 0) {
            result = new ArrayList<>();
            switch (luaChon) {
                case "Tất cả":
                    result = searchTatCa(content);
                    break;
                case "Mã hóa đơn":
                    result = searchMaHoaDonPhong(content);
                    break;
                case "Người tạo":
                    result = searchNguoiTao(content);
                    break;
            }
        } else if (content.length() == 0) {
            result = HoaDonPhongDAO.getInstance().selectAll();
        }
        Iterator<HoaDonPhong> itr = result.iterator();
        if (jDateChooserFrom.getDate() != null || jDateChooserTo.getDate() != null) {
            Date from;
            Date to;
            if (jDateChooserFrom.getDate() != null && jDateChooserTo.getDate() == null) {
                try {
                    from = ChangeFrom(jDateChooserFrom.getDate());
                    to = ChangeTo(new Date());
                    while (itr.hasNext()) {
                        HoaDonPhong phieu = itr.next();
                        if (!checkDate(phieu.getCheckOut(), from, to)) {
                            itr.remove();
                        }
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(HoaDonPhongForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (jDateChooserTo.getDate() != null && jDateChooserFrom.getDate() == null) {
                try {
                    String sDate1 = "01/01/2002";
                    from = ChangeFrom(new SimpleDateFormat("dd/MM/yyyy").parse(sDate1));
                    to = ChangeTo(jDateChooserTo.getDate());
                    while (itr.hasNext()) {
                        HoaDonPhong phieu = itr.next();
                        if (!checkDate(phieu.getCheckOut(), from, to)) {
                            itr.remove();
                        }
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(HoaDonPhongForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    from = ChangeFrom(jDateChooserFrom.getDate());
                    to = ChangeTo(jDateChooserTo.getDate());
                    if (from.getTime() > to.getTime()) {
                        JOptionPane.showMessageDialog(this, "Thời gian không hợp lệ !", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                        jDateChooserFrom.setCalendar(null);
                        jDateChooserTo.setCalendar(null);
                    } else {
                        while (itr.hasNext()) {
                            HoaDonPhong phieu = itr.next();
                            if (!checkDate(phieu.getCheckOut(), from, to)) {
                                itr.remove();
                            }
                        }
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(HoaDonPhongForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        ArrayList<HoaDonPhong> result1 = new ArrayList<>();
        if (giaTu.getText().length() > 0 || giaDen.getText().length() > 0) {
            double a;
            double b;
            if (giaTu.getText().length() > 0 && giaDen.getText().length() == 0) {
                a = Double.parseDouble(giaTu.getText());
                for (int i = 0; i < result.size(); i++) {
                    if (result.get(i).getTongTienKHTra()>= a) {
                        result1.add(result.get(i));
                    }
                }
            } else if (giaTu.getText().length() == 0 && giaDen.getText().length() > 0) {;
                b = Double.parseDouble(giaDen.getText());
                for (int i = 0; i < result.size(); i++) {
                    if (result.get(i).getTongTienKHTra()<= b) {
                        result1.add(result.get(i));
                    }
                }
            } else if (giaTu.getText().length() > 0 && giaDen.getText().length() > 0) {
                a = Double.parseDouble(giaTu.getText());
                b = Double.parseDouble(giaDen.getText());
                for (int i = 0; i < result.size(); i++) {
                    if (result.get(i).getTongTienKHTra()>= a && result.get(i).getTongTienKHTra()<= b) {
                        result1.add(result.get(i));
                    }
                }
            }
        }
        if (giaTu.getText().length() > 0 || giaDen.getText().length() > 0) {
            loadDataToTableSearch(result1);
        } else {
            loadDataToTableSearch(result);
        }
    }

    public Date ChangeFrom(Date date) throws ParseException {
        SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy 00:00:00");
        String dateText = fm.format(date);
        SimpleDateFormat par = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        Date result = par.parse(dateText);
        return result;
    }

    public Date ChangeTo(Date date) throws ParseException {
        SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy 23:59:59");
        String dateText = fm.format(date);
        SimpleDateFormat par = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        Date result = par.parse(dateText);
        return result;
    }

    HoaDonPhong getDuLieuSelect() {
        int i_row = tblPhieuNhap.getSelectedRow();
        HoaDonPhong ncc = HoaDonPhongDAO.getInstance().selectAll().get(i_row);
        return ncc;

    }
}
