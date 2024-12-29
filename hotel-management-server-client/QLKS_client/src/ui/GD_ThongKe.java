package ui;

import dao.BookRoomDAO;
import dao.OrderDAO;
import dao.ServiceDetailDAO;
import entity.BookRoom;
import entity.Order;
import entity.ServiceDetail;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.util.PublicCloneable;

public class GD_ThongKe extends javax.swing.JInternalFrame {
    private final OrderDAO odDAO = new OrderDAO();
    private final BookRoomDAO brDAO = new BookRoomDAO();
    private final ServiceDetailDAO srDAO = new ServiceDetailDAO(); 
    public GD_ThongKe() {
        this.setRootPaneCheckingEnabled(false);
        javax.swing.plaf.InternalFrameUI ui
                = this.getUI();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) ui).setNorthPane(null);
        initComponents();

    } 
    @SuppressWarnings("unchecked") 
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        bieudo1 = new javax.swing.JPanel();
        bieudo2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(245, 245, 245));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(36, 89, 83)), "Biá»ƒu Ä‘á»“ thá»‘ng kÃª", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(36, 89, 83))); // NOI18N

        bieudo1.setMaximumSize(new java.awt.Dimension(100, 100));
        bieudo1.setPreferredSize(new java.awt.Dimension(500, 300));
        bieudo1.setLayout(new java.awt.BorderLayout());

        bieudo2.setPreferredSize(new java.awt.Dimension(720, 300));
        bieudo2.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(bieudo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bieudo2, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bieudo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bieudo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );

        jPanel1.setBackground(new java.awt.Color(245, 245, 245));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(36, 89, 83)), "Lá»±a chá»�n", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(36, 89, 83))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 13));  
        jLabel1.setText("Thời gian");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 13)); 
        jLabel3.setText("Thống kê doanh thu theo:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Phòng", "Dịch vụ" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 tuần trước", "1 tháng trước", "6 tháng trước", "1 năm trước", "Tổng thời gian" }));

        jButton1.setBackground(new java.awt.Color(36, 89, 83));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12));  
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Thống kê");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(59, 59, 59)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(5, 5, 5)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(245, 245, 245));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(36, 89, 83)), "ThÃ´ng tin chi tiáº¿t\n", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(36, 89, 83))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 13)); 
        jLabel4.setText("Tổng số hóa đơn:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 13)); 
        jLabel5.setText("Tổng doanh thu:");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72))
        );

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); 
        jLabel10.setForeground(new java.awt.Color(36, 89, 83));
        jLabel10.setText("THỐNG KÊ DOANH THU");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(26, 26, 26)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(146, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(335, 335, 335))
        );

        jScrollPane2.setViewportView(jPanel5);

        getContentPane().add(jScrollPane2, java.awt.BorderLayout.PAGE_START);
    } 

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) { 
        // TODO add your handling code here:
        bieudo2.add(new JLabel("cjalkcj"));
        int time = -1000, sl = 0;
        double tongtien = 0;
        if (jComboBox3.getSelectedItem().toString().equals("1 tuần trước"))
            time = -1;
        else if (jComboBox3.getSelectedItem().toString().equals("1 tháng trước"))
            time = -4;
        else if (jComboBox3.getSelectedItem().toString().equals("6 tháng trước"))
            time = -24;
        else if (jComboBox3.getSelectedItem().toString().equals("1 năm trước"))
            time = -52;
        ArrayList<Order> list = odDAO.getOrderBeforeTime(time);
        Map<String, Double> count = new HashMap<String, Double>();
        Map<String, Double> count2 = new HashMap<String, Double>();
        sl = list.size();
        jTextField2.setText(Integer.toString(sl));
        
        if (jComboBox1.getSelectedItem().toString().equals("Phòng")) {
            for (int i = 0; i < list.size(); i++) {
                try {
                    tongtien = tongtien + list.get(i).getTongTienPhong();
                } catch (ParseException ex) {
                    Logger.getLogger(GD_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
                }
                BookRoom br = brDAO.getBookRoomByID(list.get(i).getBookRooms().get(0).getBookRoomID());
                String roomname = br.getRoom().getRoomName();
                
                String loaiPhong = br.getRoom().getRoomType().getRoomTypeName();
                
//                System.out.println(loaiPhong);
                if (count2.containsKey(loaiPhong)) {
                    try {
                        count2.put(loaiPhong, list.get(i).getTongTienPhong() + count.get(loaiPhong));
                    } catch (ParseException ex) {
                        Logger.getLogger(GD_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else try {
                    count2.put(loaiPhong, list.get(i).getTongTienPhong());
                } catch (ParseException ex) {
                    Logger.getLogger(GD_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                
                if (count.containsKey(roomname)) {
                    try {
                        count.put(roomname, list.get(i).getTongTienPhong() + count.get(roomname));
                    } catch (ParseException ex) {
                        Logger.getLogger(GD_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else try {
                    count.put(roomname, list.get(i).getTongTienPhong());
                } catch (ParseException ex) {
                    Logger.getLogger(GD_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            String tongtienFormatted = String.format("%,.0f VNĐ", tongtien);
            jTextField1.setText(tongtienFormatted);
            
            
            
            JFreeChart pieChart = createChart(createDataset(count2));
            ChartPanel chartPanel = new ChartPanel(pieChart);
            bieudo1.add(chartPanel);
            bieudo1.validate();
            bieudo1.repaint();
            
            
            ChartPanel chartPanel23 = new ChartPanel(creatChart2(count));
            bieudo2.add(chartPanel23);  
            bieudo2.validate();
            bieudo2.repaint();        
        }
        else {
            for (int i = 0; i < list.size(); i++) {
                try {
                    tongtien = tongtien + list.get(i).getTongTienDichVu();
                } catch (SQLException ex) {
                    Logger.getLogger(GD_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(GD_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                ArrayList<ServiceDetail> list_servicedetail_orderid = srDAO.getListServiceDetailByOrderID(list.get(i).getOrderID());
                for (ServiceDetail srdt: list_servicedetail_orderid) {
                    
                    // Tinh cho bieu do 1
                    if (count2.containsKey(srdt.getService().getServiceName())) {
                        count2.put(srdt.getService().getServiceName(), srdt.getQuantity() * srdt.getService().getPrice() + count.get(srdt.getService().getServiceName()));
                    }
                    else count2.put(srdt.getService().getServiceName(), srdt.getQuantity() * srdt.getService().getPrice());
                     // Tinh cho bieu do 2
                    if (count.containsKey(srdt.getService().getServiceName())) {
                        count.put(srdt.getService().getServiceName(), srdt.getQuantity() * srdt.getService().getPrice() + count.get(srdt.getService().getServiceName()));
                    }
                    else count.put(srdt.getService().getServiceName(), srdt.getQuantity() * srdt.getService().getPrice());
                }
            }
            String tongtienFormatted = String.format("%,.0f VNĐ", tongtien);
            jTextField1.setText(tongtienFormatted);
            
            
            
            JFreeChart pieChart = createChart(createDataset(count2));
            ChartPanel chartPanel = new ChartPanel(pieChart);
            bieudo1.removeAll();
            bieudo1.add(chartPanel);
            bieudo1.validate();
            bieudo1.repaint();
            
            
            ChartPanel chartPanel23 = new ChartPanel(creatChart2(count));
            bieudo2.removeAll();
            bieudo2.add(chartPanel23);  
            bieudo2.validate();
            bieudo2.repaint();
            
        }
    } 

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) { 
        // TODO add your handling code here:
    } 

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) { 
        // TODO add your handling code here:
    } 

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) { 
        // TODO add your handling code here:
    } 
     private static JFreeChart createChart(PieDataset dataset) {
        JFreeChart chart = ChartFactory.createPieChart(
                "THỐNG KÊ DOANH THU THEO", dataset, true, true, true);
        return chart;
    }

    private static PieDataset createDataset(Map<String, Double> data) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        double tong = 0;
        for (String id : data.keySet()) {
            tong += data.get(id);
        }
        for (String id : data.keySet()) {
            dataset.setValue(id, data.get(id) / tong * 100);
        }
        return dataset;
    }
    
    public static JFreeChart creatChart2(Map<String, Double> data) {
        JFreeChart barChart = ChartFactory.createBarChart("Biểu đồ thống kê doanh thu", "Năm", "Doanh Thu VND", createDataset2(data), PlotOrientation.VERTICAL, false, false, false);
        return barChart;
    }
    
    
    private static CategoryDataset createDataset2(Map<String, Double> data) {
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (String id : data.keySet()) {
            dataset.addValue(data.get(id), "Doanh thu", id);
        }
        return dataset;
    }
    private javax.swing.JPanel bieudo1;
    private javax.swing.JPanel bieudo2;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
}
