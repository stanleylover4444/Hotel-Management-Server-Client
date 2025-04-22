
package ui;
import entity.*;
import socket.SocketClient;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import dao.EmployeeDAO;
import dao.ServiceDAO;

public class GD_DichVu_QuanLy extends javax.swing.JInternalFrame {
    private DefaultTableModel model;
       
    private ServiceDAO serviceD;
    private EmployeeDAO empD;

    private static SocketClient socketClient = new SocketClient("localhost", 31000);

    public GD_DichVu_QuanLy() {
        this.setRootPaneCheckingEnabled(false);
        javax.swing.plaf.InternalFrameUI ui
                = this.getUI();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) ui).setNorthPane(null);
        
        initComponents();
        model = new DefaultTableModel();
        serviceD = new ServiceDAO();
        // helper = new RegexHelper();
        model = (DefaultTableModel) tbService.getModel();
        loadDataToTBService();        
    }
    
    private void loadDataToTBService() {
        tbService.setModel(model);
        
        model.setRowCount(0);
        
           try {
               for(Service s : serviceD.getAllService())
               {
                   Object[] row = {
                       s.getServiceID(),s.getServiceName(), s.getPrice(), s.getInventory()
                   };
                   model.addRow(row);
               }  } catch (ClassNotFoundException ex) {
               Logger.getLogger(GD_DichVu_QuanLy.class.getName()).log(Level.SEVERE, null, ex);
           } catch (SQLException ex) {
               Logger.getLogger(GD_DichVu_QuanLy.class.getName()).log(Level.SEVERE, null, ex);
           }
           model.fireTableDataChanged();
    }
                                   

    private boolean checkData()
    {
        if(nameTF.getText().equals("") || priceTF.getText().equals("") || quantityTF.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!");
            return false;
        }
        else
        {
            String thongBao="";
            // if (!helper.regexPriceService(priceTF.getText().trim()))
            //     thongBao+="*Giá phải là số và lớn hơn 0!\n";
            // if(!helper.regexSoLuongTon(quantityTF.getText().trim()))
            //     thongBao+="*Số lượng phải là số\n";
            // if (thongBao.isEmpty())
            //     return true;
            // else{
            //     JOptionPane.showMessageDialog(this, thongBao);
            //     return false;
            // }
            return false;
        }
    }
    
    private String idService(){
        String s="DV";
        int ma = 0;
        try {
            ma = serviceD.getAllService().size();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GD_DichVu_QuanLy.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GD_DichVu_QuanLy.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (ma<9)
            s=s+ "00"+ (ma+1);
        else
            s=s+"0"+(ma+1);
        return s;
    }

    private void clearText()
    {
        nameTF.setText("");
        priceTF.setText("");
        quantityTF.setText("");
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        Main = new javax.swing.JPanel();
        pnTitle = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nameTF = new javax.swing.JTextField();
        priceTF = new javax.swing.JTextField();
        quantityTF = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        findTF = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbService = new javax.swing.JTable();

        Main.setLayout(new javax.swing.BoxLayout(Main, javax.swing.BoxLayout.Y_AXIS));

        pnTitle.setBackground(new java.awt.Color(255, 255, 255));
        pnTitle.setLayout(new java.awt.BorderLayout());

        title.setBackground(new java.awt.Color(36, 89, 83));
        title.setFont(new java.awt.Font("Segoe UI", 1, 18)); 
        title.setForeground(new java.awt.Color(36, 89, 83));
        title.setText("Quản Lý Dịch Vụ");
        pnTitle.add(title, java.awt.BorderLayout.CENTER);

        Main.add(pnTitle);

        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(36, 89, 83)), "ThÃ´ng tin chi tiáº¿t", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(36, 89, 83))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); 
        jLabel1.setForeground(new java.awt.Color(36, 89, 83));
        jLabel1.setText("Tên dịch vụ: ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); 
        jLabel2.setForeground(new java.awt.Color(36, 89, 83));
        jLabel2.setText("Giá dịch vụ:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12));
        jLabel3.setForeground(new java.awt.Color(36, 89, 83));
        jLabel3.setText("Số lượng: ");

        nameTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(priceTF, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(quantityTF, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(548, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(priceTF, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(quantityTF, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        jPanel5.add(jPanel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(36, 89, 83)), "Xá»­ lÃ½", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(36, 89, 83))); // NOI18N

        btnAdd.setBackground(new java.awt.Color(36, 89, 83));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); 
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Thêm dịch vụ");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(36, 89, 83));
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 14)); 
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Sửa dịch vụ");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(36, 89, 83));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); 
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Xóa dịch vụ");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnClear.setBackground(new java.awt.Color(36, 89, 83));
        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 14)); 
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setText("Xóa trắng");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE)
                    .addComponent(btnClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel2);

        Main.add(jPanel5);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.BorderLayout());
        Main.add(jPanel3);

        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.Y_AXIS));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setPreferredSize(new java.awt.Dimension(1918, 20));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1918, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );

        jPanel6.add(jPanel7);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setBackground(new java.awt.Color(252, 210, 165));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); 
        jLabel4.setForeground(new java.awt.Color(36, 89, 83));
        jLabel4.setText("Tìm kiếm theo danh sách: ");
        jPanel8.add(jLabel4);

        findTF.setPreferredSize(new java.awt.Dimension(200, 30));
        findTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findTFActionPerformed(evt);
            }
        });
        findTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                findTFKeyReleased(evt);
            }
        });
        jPanel8.add(findTF);

        jButton1.setBackground(new java.awt.Color(36, 89, 83));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14));  
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Tìm Kiếm");
        jButton1.setPreferredSize(new java.awt.Dimension(100, 30));
        jPanel8.add(jButton1);

        jPanel6.add(jPanel8);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setPreferredSize(new java.awt.Dimension(1918, 20));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1918, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );

        jPanel6.add(jPanel9);

        Main.add(jPanel6);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(36, 89, 83)), "Danh sÃ¡ch dá»‹ch vá»¥", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(36, 89, 83))); // NOI18N

        tbService.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã dịch vụ", "Tên dịch vụ", "Giá dịch vụ", "Số lượng tồn"
            }
        ));
        tbService.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbServiceMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbService);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
        );

        Main.add(jPanel4);

        getContentPane().add(Main, java.awt.BorderLayout.CENTER);

        pack();
    }

    private void nameTFActionPerformed(java.awt.event.ActionEvent evt) { 
        // TODO add your handling code here:
    } 

    private void findTFActionPerformed(java.awt.event.ActionEvent evt) { 
        // TODO add your handling code here:
    } 

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) { 
        // TODO add your handling code here:
                 if(checkData())
        {
            Service s = new Service(idService(), nameTF.getText(), Double.parseDouble(priceTF.getText()), Integer.parseInt(quantityTF.getText()));
            if(serviceD.add(s))
            {
                JOptionPane.showMessageDialog(this, "Thêm thành công!");
                clearText();
                loadDataToTBService(); 
            }
        }
    } 

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) { 
        // TODO add your handling code here:
        clearText();
    } 

    private void tbServiceMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        int index = tbService.getSelectedRow();
        nameTF.setText(tbService.getValueAt(index, 1).toString());
        priceTF.setText(tbService.getValueAt(index, 2).toString());
        quantityTF.setText(tbService.getValueAt(index, 3).toString());
    } 

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) { 
        // TODO add your handling code here:
        int index = tbService.getSelectedRow();
        if(index == -1)
        {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm muốn xóa!");
        }
        else
        {
            Service s = serviceD.findServiceByID(tbService.getValueAt(index, 0).toString());
            if(JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa ?", "Cảnh báo", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
            {
                if(serviceD.delete(s))
                {
                    JOptionPane.showMessageDialog(this, "Xóa thành công!");
                    clearText();
                    loadDataToTBService();
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Xóa không Thành công!");
                }
            }
        }
    }

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        int index = tbService.getSelectedRow();
        if(index == -1)
        {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm muốn cập nhật!");
        }
        else
        {
            if(checkData())
            {
                Service s = serviceD.findServiceByID(tbService.getValueAt(index, 0).toString());
                s.setServiceName(nameTF.getText());
                s.setPrice(Double.parseDouble(priceTF.getText()));
                s.setInventory(Integer.parseInt(quantityTF.getText()));
                if(serviceD.update(s))
                {
                    JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
                    clearText();
                    loadDataToTBService();
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Cập nhật thất bại!");
                }
            }
        }
    }

    private void findTFKeyReleased(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
        String s = findTF.getText();
        filler(s);
    } 

 
    private javax.swing.JPanel Main;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JTextField findTF;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameTF;
    private javax.swing.JPanel pnTitle;
    private javax.swing.JTextField priceTF;
    private javax.swing.JTextField quantityTF;
    private javax.swing.JTable tbService;
    private javax.swing.JLabel title; 

    private void filler(String s) {
        TableRowSorter<DefaultTableModel> tr=new TableRowSorter<DefaultTableModel>(model);
        tbService.setRowSorter(tr);
    }
}
