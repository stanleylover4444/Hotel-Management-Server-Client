/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;


import controller.SearchTaiKhoan;
import dao.TaiKhoanDAO;
import dao.DichVuDAO;
import dao.HoaDonDichVuDAO;
import dao.HoaDonPhongDAO;
import dao.KhachHangDAO;
import java.awt.BasicStroke;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.geom.Ellipse2D;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

import java.util.Iterator;
import java.util.Map;
import javax.swing.JPanel;
import model.TaiKhoan;
import model.Phong;
import model.ChiTietHoaDonDichVu;
import model.HoaDonDichVu;
import model.HoaDonPhong;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.DefaultCategoryDataset;


/**
 *
 * @author Robot
 */
public class QuanLiThongKe extends javax.swing.JInternalFrame {

    private DefaultTableModel tblModel;
    DecimalFormat formatter = new DecimalFormat("###,###,###");
    SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/YYYY HH:mm");

    public DecimalFormat getFormatter() {
        return formatter;
    }

    public SimpleDateFormat getFormatDate() {
        return formatDate;
    }

    public QuanLiThongKe() {
        initComponents();
        showBarChartDichVu();
         showBarChartPhong();
       showLineChartSLDV();
        showLineChartSLP();
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
       
    
       
        txtQuantityNcc.setText(Integer.toString(KhachHangDAO.getInstance().selectAll().size()));
        txtQuantityUser.setText(Integer.toString(TaiKhoanDAO.getInstance().selectAll().size()));
        //
     
    
        
        
        //
     
        
      
    }
 public void showBarChartDichVu() {
    HoaDonDichVuDAO dao = new HoaDonDichVuDAO();
    Map<LocalDate, Double> salesData = dao.thongKeDoanhSoTheoThang(LocalDate.of(2024, 1, 1), LocalDate.of(2024, 12, 31));

    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    double maxSales = 0; // Biến để theo dõi giá trị doanh thu tối đa
    for (Map.Entry<LocalDate, Double> entry : salesData.entrySet()) {
        LocalDate date = entry.getKey();
        double sales = entry.getValue();
        dataset.setValue(sales, "Amount", String.valueOf(date.getMonthValue()));
        System.out.println("Month: " + date.getMonthValue() + ", Sales: " + sales);
        if (sales > maxSales) {
            maxSales = sales; // Cập nhật giá trị doanh thu tối đa
        }
    }

    JFreeChart chart = ChartFactory.createBarChart("Doanh thu dịch vụ theo tháng", "Tháng", "Doanh thu",
            dataset, PlotOrientation.VERTICAL, false, true, false);

    CategoryPlot categoryPlot = chart.getCategoryPlot();
    categoryPlot.setBackgroundPaint(Color.WHITE);
    categoryPlot.setDomainGridlinePaint(Color.GRAY);
    categoryPlot.setRangeGridlinePaint(Color.GRAY);

    // Định dạng lại trục y để tự động chia khoảng tiền theo dữ liệu
    NumberAxis yAxis = (NumberAxis) categoryPlot.getRangeAxis();
    yAxis.setAutoRangeIncludesZero(true); // Bao gồm cả giá trị 0 trong khoảng trục y
    yAxis.setAutoRange(true); // Tự động xác định khoảng trục y
    yAxis.setTickLabelFont(new Font("SansSerif", Font.PLAIN, 12));
    yAxis.setLabelFont(new Font("SansSerif", Font.BOLD, 14));

    CategoryAxis xAxis = categoryPlot.getDomainAxis();
    xAxis.setTickLabelFont(new Font("SansSerif", Font.PLAIN, 12));
    xAxis.setLabelFont(new Font("SansSerif", Font.BOLD, 14));

    BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();
    Color clr3 = new Color(0,51,204);
    renderer.setSeriesPaint(0, clr3);
    renderer.setDrawBarOutline(true);
    renderer.setBarPainter(new StandardBarPainter()); // Use standard bar painter
    renderer.setShadowVisible(false); // Remove shadow for a cleaner look

    // Adjust bar width
    renderer.setMaximumBarWidth(0.1); // Set bar width to 10% of available space

    // Hiển thị biểu đồ trên panel
    ChartPanel barChartPanel = new ChartPanel(chart);
    barChartPanel.setPreferredSize(new Dimension(800, 600));
    panelLineChart.removeAll();
    panelLineChart.add(barChartPanel, BorderLayout.CENTER);
    panelLineChart.validate();
}
public void showBarChartPhong() {
    HoaDonPhongDAO dao = new HoaDonPhongDAO();
    Map<LocalDate, Double> salesData = dao.thongKeDoanhSoTheoThangPhong(LocalDate.of(2024, 1, 1), LocalDate.of(2024, 12, 31));

    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    double maxSales = 0; // Biến để theo dõi giá trị doanh thu tối đa
    for (Map.Entry<LocalDate, Double> entry : salesData.entrySet()) {
        LocalDate date = entry.getKey();
        double sales = entry.getValue();
        dataset.setValue(sales, "Amount", String.valueOf(date.getMonthValue()));
        System.out.println("Month: " + date.getMonthValue() + ", Sales: " + sales);
        if (sales > maxSales) {
            maxSales = sales; // Cập nhật giá trị doanh thu tối đa
        }
    }

    JFreeChart chart = ChartFactory.createBarChart("Doanh thu phòng theo tháng", "Tháng", "Doanh thu",
            dataset, PlotOrientation.VERTICAL, false, true, false);

    CategoryPlot categoryPlot = chart.getCategoryPlot();
    categoryPlot.setBackgroundPaint(Color.WHITE);
    categoryPlot.setDomainGridlinePaint(Color.GRAY);
    categoryPlot.setRangeGridlinePaint(Color.GRAY);

    // Định dạng lại trục y để tự động chia khoảng tiền theo dữ liệu
    NumberAxis yAxis = (NumberAxis) categoryPlot.getRangeAxis();
    yAxis.setAutoRangeIncludesZero(true); // Bao gồm cả giá trị 0 trong khoảng trục y
    yAxis.setAutoRange(true); // Tự động xác định khoảng trục y
    yAxis.setTickLabelFont(new Font("SansSerif", Font.PLAIN, 12));
    yAxis.setLabelFont(new Font("SansSerif", Font.BOLD, 14));

    CategoryAxis xAxis = categoryPlot.getDomainAxis();
    xAxis.setTickLabelFont(new Font("SansSerif", Font.PLAIN, 12));
    xAxis.setLabelFont(new Font("SansSerif", Font.BOLD, 14));

    BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();
    Color clr3 = new Color(0,51,204);
    renderer.setSeriesPaint(0, clr3);
    renderer.setDrawBarOutline(true);
    renderer.setBarPainter(new StandardBarPainter()); // Use standard bar painter
    renderer.setShadowVisible(false); // Remove shadow for a cleaner look

    // Adjust bar width
    renderer.setMaximumBarWidth(0.1); // Set bar width to 10% of available space

    // Hiển thị biểu đồ trên panel
    ChartPanel barChartPanel = new ChartPanel(chart);
    barChartPanel.setPreferredSize(new Dimension(800, 600));
    panelLineChart6.removeAll();
    panelLineChart6.add(barChartPanel, BorderLayout.CENTER);
    panelLineChart6.validate();
}


   
  

    

    

   

    
    
    
    

  /* */
  
   
  
    
 public void showLineChartSLDV() {
    // Lấy dữ liệu từ cơ sở dữ liệu
    HoaDonDichVuDAO dao = new HoaDonDichVuDAO();
    LocalDate fromDate = LocalDate.of(2024, 1, 1);
    LocalDate toDate = LocalDate.of(2024, 12, 31);
    Map<LocalDate, Double> salesData = dao.thongKeSoLuongTheoThang(fromDate, toDate);

    // Tạo dataset cho biểu đồ
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

    for (Map.Entry<LocalDate, Double> entry : salesData.entrySet()) {
        LocalDate date = entry.getKey();
        double value = entry.getValue();
        dataset.addValue(value, "Số lượng", date.getMonth().toString());
    }

    // Tạo biểu đồ
    JFreeChart lineChart = ChartFactory.createLineChart(
            "Số lượng hóa đơn dịch vụ", "Tháng", "Số lượng",
            dataset, PlotOrientation.VERTICAL, false, true, false);

    // Tuỳ chỉnh plot
    CategoryPlot lineCategoryPlot = lineChart.getCategoryPlot();
    lineCategoryPlot.setBackgroundPaint(Color.WHITE);
    lineCategoryPlot.setDomainGridlinePaint(Color.GRAY);
    lineCategoryPlot.setRangeGridlinePaint(Color.GRAY);

    // Tuỳ chỉnh line renderer
    LineAndShapeRenderer lineRenderer = (LineAndShapeRenderer) lineCategoryPlot.getRenderer();
    Color lineChartColor = new Color(204, 51, 0);
    lineRenderer.setSeriesPaint(0, lineChartColor);

    // Tăng độ dày của đường
    lineRenderer.setSeriesStroke(0, new BasicStroke(2.0f));

    // Thêm hình dạng cho các điểm dữ liệu
    lineRenderer.setSeriesShapesVisible(0, true);
    lineRenderer.setSeriesShape(0, new Ellipse2D.Double(-3.0, -3.0, 6.0, 6.0));

    // Tuỳ chỉnh font
    Font labelFont = new Font("SansSerif", Font.BOLD, 12);
    lineCategoryPlot.getDomainAxis().setLabelFont(labelFont);
    lineCategoryPlot.getRangeAxis().setLabelFont(labelFont);
    lineCategoryPlot.getDomainAxis().setTickLabelFont(labelFont);
    lineCategoryPlot.getRangeAxis().setTickLabelFont(labelFont);

    // Tạo panel biểu đồ để hiển thị
    ChartPanel lineChartPanel = new ChartPanel(lineChart);
    lineChartPanel.setPreferredSize(new Dimension(800, 600));
    panelLineChart7.removeAll();
    panelLineChart7.add(lineChartPanel, BorderLayout.CENTER);
    panelLineChart7.validate();
}
public void showLineChartSLP() {
    // Lấy dữ liệu từ cơ sở dữ liệu
    HoaDonPhongDAO dao = new HoaDonPhongDAO();
    LocalDate fromDate = LocalDate.of(2024, 1, 1);
    LocalDate toDate = LocalDate.of(2024, 12, 31);
    Map<LocalDate, Double> salesData = dao.thongKeSoLuongTheoThangPhong(fromDate, toDate);

    // Tạo dataset cho biểu đồ
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

    for (Map.Entry<LocalDate, Double> entry : salesData.entrySet()) {
        LocalDate date = entry.getKey();
        double value = entry.getValue();
        dataset.addValue(value, "Số lượng", date.getMonth().toString());
    }

    // Tạo biểu đồ
    JFreeChart lineChart = ChartFactory.createLineChart(
            "Số lượng hóa đơn phòng", "Tháng", "Số lượng",
            dataset, PlotOrientation.VERTICAL, false, true, false);

    // Tuỳ chỉnh plot
    CategoryPlot lineCategoryPlot = lineChart.getCategoryPlot();
    lineCategoryPlot.setBackgroundPaint(Color.WHITE);
    lineCategoryPlot.setDomainGridlinePaint(Color.GRAY);
    lineCategoryPlot.setRangeGridlinePaint(Color.GRAY);

    // Tuỳ chỉnh line renderer
    LineAndShapeRenderer lineRenderer = (LineAndShapeRenderer) lineCategoryPlot.getRenderer();
    Color lineChartColor = new Color(204, 51, 0);
    lineRenderer.setSeriesPaint(0, lineChartColor);

    // Tăng độ dày của đường
    lineRenderer.setSeriesStroke(0, new BasicStroke(2.0f));

    // Thêm hình dạng cho các điểm dữ liệu
    lineRenderer.setSeriesShapesVisible(0, true);
    lineRenderer.setSeriesShape(0, new Ellipse2D.Double(-3.0, -3.0, 6.0, 6.0));

    // Tuỳ chỉnh font
    Font labelFont = new Font("SansSerif", Font.BOLD, 12);
    lineCategoryPlot.getDomainAxis().setLabelFont(labelFont);
    lineCategoryPlot.getRangeAxis().setLabelFont(labelFont);
    lineCategoryPlot.getDomainAxis().setTickLabelFont(labelFont);
    lineCategoryPlot.getRangeAxis().setTickLabelFont(labelFont);

    // Tạo panel biểu đồ để hiển thị
    ChartPanel lineChartPanel = new ChartPanel(lineChart);
    lineChartPanel.setPreferredSize(new Dimension(800, 600));
    panelLineChart8.removeAll();
    panelLineChart8.add(lineChartPanel, BorderLayout.CENTER);
    panelLineChart8.validate();
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel8 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtQuantityNcc = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtQuantityUser = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        panel1 = new java.awt.Panel();
        panelLineChart = new javax.swing.JPanel();
        panelLineChart7 = new javax.swing.JPanel();
        panelLineChart6 = new javax.swing.JPanel();
        panelLineChart8 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setPreferredSize(new java.awt.Dimension(1700, 1200));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jPanel10.setBackground(new java.awt.Color(0, 153, 153));
        jPanel10.setPreferredSize(new java.awt.Dimension(630, 179));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/customer-service.png"))); // NOI18N

        txtQuantityNcc.setFont(new java.awt.Font("SF Pro Display", 1, 36)); // NOI18N
        txtQuantityNcc.setForeground(new java.awt.Color(255, 255, 255));
        txtQuantityNcc.setText("100");

        jLabel14.setFont(new java.awt.Font("SF Pro Display", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Khách hàng ");

        jLabel18.setFont(new java.awt.Font("SF Pro Display", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Khách hàng");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(250, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtQuantityNcc, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addGap(76, 76, 76)))
                .addGap(130, 130, 130))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(txtQuantityNcc, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel18))
                    .addComponent(jLabel13))
                .addGap(55, 55, 55)
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11.setBackground(new java.awt.Color(204, 51, 0));
        jPanel11.setPreferredSize(new java.awt.Dimension(630, 125));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/management.png"))); // NOI18N

        txtQuantityUser.setFont(new java.awt.Font("SF Pro Display", 1, 36)); // NOI18N
        txtQuantityUser.setForeground(new java.awt.Color(255, 255, 255));
        txtQuantityUser.setText("100");

        jLabel17.setFont(new java.awt.Font("SF Pro Display", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Tài khoản ");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(204, 204, 204)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(txtQuantityUser, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(266, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(txtQuantityUser, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17)))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1300, 130));

        panelLineChart.setBackground(new java.awt.Color(0, 51, 204));
        panelLineChart.setBorder(new javax.swing.border.MatteBorder(null));
        panelLineChart.setPreferredSize(new java.awt.Dimension(584, 316));
        panelLineChart.setLayout(new java.awt.BorderLayout());

        panelLineChart7.setBackground(new java.awt.Color(51, 255, 153));
        panelLineChart7.setBorder(new javax.swing.border.MatteBorder(null));
        panelLineChart7.setPreferredSize(new java.awt.Dimension(584, 316));
        panelLineChart7.setLayout(new java.awt.BorderLayout());

        panelLineChart6.setBackground(new java.awt.Color(51, 255, 153));
        panelLineChart6.setBorder(new javax.swing.border.MatteBorder(null));
        panelLineChart6.setPreferredSize(new java.awt.Dimension(584, 316));
        panelLineChart6.setLayout(new java.awt.BorderLayout());

        panelLineChart8.setBackground(new java.awt.Color(51, 255, 153));
        panelLineChart8.setBorder(new javax.swing.border.MatteBorder(null));
        panelLineChart8.setPreferredSize(new java.awt.Dimension(584, 316));
        panelLineChart8.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelLineChart7, javax.swing.GroupLayout.DEFAULT_SIZE, 647, Short.MAX_VALUE)
                    .addComponent(panelLineChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelLineChart8, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
                    .addComponent(panelLineChart6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelLineChart6, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                    .addComponent(panelLineChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelLineChart8, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                    .addComponent(panelLineChart7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(120, Short.MAX_VALUE))
        );

        getContentPane().add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 1300, 820));

        pack();
    }// </editor-fold>//GEN-END:initComponents


   

    

    

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel8;
    private java.awt.Panel panel1;
    private javax.swing.JPanel panelLineChart;
    private javax.swing.JPanel panelLineChart6;
    private javax.swing.JPanel panelLineChart7;
    private javax.swing.JPanel panelLineChart8;
    private javax.swing.JLabel txtQuantityNcc;
    private javax.swing.JLabel txtQuantityUser;
    // End of variables declaration//GEN-END:variables

   

    

    
}