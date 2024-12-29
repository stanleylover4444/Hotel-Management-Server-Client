package ui;

import dao.OrderDAO;
import dao.RoomDAO;
import dao.ServiceDetailDAO;
import entity.BookRoom;
import entity.Order;
import entity.Room;
import entity.RoomStatusType;
import entity.ServiceDetail;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class GD_ThanhToan extends javax.swing.JInternalFrame {

    DecimalFormat df = new DecimalFormat("#,###.#â‚«");
    
    public String chuyenDoiNgay(String timeString1, String dateString1) {
  
        timeString1 = timeString1.substring(0, 8);
        return (dateString1 + " " + timeString1);
    }
    ArrayList<Order> dsHoaDon = null;

    private void loadDataTableHoaDon() throws ParseException {
        dsHoaDon = new OrderDAO().getOrderByStatus("Chưa thanh toán");
        Object[][] data = new Object[dsHoaDon.size()][5];
        for (int i = 0; i < dsHoaDon.size(); i++) {
            BookRoom br = dsHoaDon.get(i).getBookRooms().get(0);
            data[i][0] = dsHoaDon.get(i).getOrderID();
            data[i][1] = br.getCustomer().getCustomerName();
            data[i][2] = br.getCustomer().getCCCD();
            data[i][3] = br.getRoom().getRoomID();
            data[i][4] = chuyenDoiNgay(br.getCheckInTime(), br.getCheckInDate()).toString();
        }

        tableHoaDon.setModel(new javax.swing.table.DefaultTableModel(
                data,
                new String[]{
                    "Mã hóa đơn", "Khách hàng", "CCCD/CMND", "Mã phòng", "Ngày đến"
                }
        ));
    }

    public GD_ThanhToan() throws ParseException {
        this.setRootPaneCheckingEnabled(false);
        javax.swing.plaf.InternalFrameUI ui
                = this.getUI();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) ui).setNorthPane(null);
        initComponents();
        loadDataTableHoaDon();
    }
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txtCCCD = new javax.swing.JTextField();
        txtKhachHang = new javax.swing.JTextField();
        txtThuNgan = new javax.swing.JTextField();
        txtNgayDen = new javax.swing.JTextField();
        txtNgayDi = new javax.swing.JTextField();
        txtMaPhong = new javax.swing.JTextField();
        txtMaHoaDon = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableDichVu = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtTienMat = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtTienPhong = new javax.swing.JTextField();
        txtKhuyenMaiTien = new javax.swing.JTextField();
        txtKhuyenMaiPhanTram = new javax.swing.JTextField();
        txtTongCong = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtThueVAT = new javax.swing.JTextField();
        txtThueVATPhanTram = new javax.swing.JTextField();
        txtTienThoi = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        txtCMNDTK = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableHoaDon = new javax.swing.JTable();
        btnTimKiem = new javax.swing.JButton();
        btnTatCa = new javax.swing.JButton();
        btnInHoaDon = new javax.swing.JButton();
        btnThanhToan = new javax.swing.JButton();

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14));  
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("KHÁCH SẠN H&M");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CHI TIẾT HÓA ĐƠN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(0, 153, 153))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14));  
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Địa chỉ: 12 Nguyễn Văn Bảo, phường 4");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14));  
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Quận Gò Vấp, Thành phố Hồ Chí Minh");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14));  
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("SDT: 08214581251");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14));  
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("KHÁCH SẠN H&M");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14));  
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("HOÁ ĐƠN THANH TOÁN");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        jLabel27.setText("CCCD/CMND:");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        jLabel28.setText("Khách hàng:");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 14));  
        jLabel29.setText("Mã phòng:");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        jLabel30.setText("Mã hóa đơn:");

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        jLabel31.setText("Thu ngân:");

        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 14));  
        jLabel32.setText("Ngày đến:");

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        jLabel33.setText("Ngày đi:");

        txtCCCD.setEditable(false);
        txtCCCD.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        txtCCCD.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        txtKhachHang.setEditable(false);
        txtKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        txtKhachHang.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        txtThuNgan.setEditable(false);
        txtThuNgan.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        txtThuNgan.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        txtNgayDen.setEditable(false);
        txtNgayDen.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        txtNgayDen.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        txtNgayDi.setEditable(false);
        txtNgayDi.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        txtNgayDi.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        txtMaPhong.setEditable(false);
        txtMaPhong.setFont(new java.awt.Font("Segoe UI", 0, 14));
        txtMaPhong.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        txtMaHoaDon.setEditable(false);
        txtMaHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 14));
        txtMaHoaDon.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txtMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel30)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMaHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
                            .addComponent(txtNgayDi, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNgayDen, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtKhachHang, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtCCCD)
                            .addComponent(txtThuNgan, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(0, 0, 0)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30)
                    .addComponent(txtMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(txtThuNgan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(txtNgayDen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(txtNgayDi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 390, 310));

        tableDichVu.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        tableDichVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Dịch vụ", "Giá", "Thành tiền"
            }
        ));
        tableDichVu.setRowHeight(22);
        tableDichVu.setShowGrid(false);
        jScrollPane2.setViewportView(tableDichVu);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        jLabel13.setText("Tiền phòng:");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14));  
        jLabel15.setText("Khuyến mãi:");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); 
        jLabel17.setText("Tổng cộng: ");

        jLabel19.setText("===============================================");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        jLabel20.setText("Tiền mặt:");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        jLabel22.setText("Tiền thối lại: ");

        txtTienMat.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        txtTienMat.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTienMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTienMatActionPerformed(evt);
            }
        });
        txtTienMat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienMatKeyReleased(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 14));  
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Hẹn gặp lại !");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Cảm ơn quý khách !");

        txtTienPhong.setEditable(false);
        txtTienPhong.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        txtTienPhong.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTienPhong.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtTienPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTienPhongActionPerformed(evt);
            }
        });

        txtKhuyenMaiTien.setEditable(false);
        txtKhuyenMaiTien.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        txtKhuyenMaiTien.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtKhuyenMaiTien.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        txtKhuyenMaiPhanTram.setEditable(false);
        txtKhuyenMaiPhanTram.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        txtKhuyenMaiPhanTram.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        txtTongCong.setEditable(false);
        txtTongCong.setFont(new java.awt.Font("Segoe UI", 1, 18));  
        txtTongCong.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTongCong.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14));  
        jLabel16.setText("Thuế VAT:");

        txtThueVAT.setEditable(false);
        txtThueVAT.setFont(new java.awt.Font("Segoe UI", 0, 14));  
        txtThueVAT.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtThueVAT.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        txtThueVATPhanTram.setEditable(false);
        txtThueVATPhanTram.setFont(new java.awt.Font("Segoe UI", 0, 14));  
        txtThueVATPhanTram.setText("8%");
        txtThueVATPhanTram.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        txtTienThoi.setEditable(false);
        txtTienThoi.setFont(new java.awt.Font("Segoe UI", 1, 18)); 
        txtTienThoi.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTienThoi.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(jLabel22)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtKhuyenMaiPhanTram, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel17)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtThueVATPhanTram, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtTongCong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                        .addComponent(txtThueVAT, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtKhuyenMaiTien, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtTienPhong, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtTienThoi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                        .addComponent(txtTienMat, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTienPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtKhuyenMaiTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtKhuyenMaiPhanTram, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel15))
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtThueVAT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(txtThueVATPhanTram, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtTongCong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtTienMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtTienThoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 337, 380, 420));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DANH SÁCH HÓA ĐƠN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(0, 153, 153))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14));  
        jLabel21.setText("Tìm kiếm theo  CCCD/CMND: ");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 83, -1, -1));

        txtCMNDTK.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        txtCMNDTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCMNDTKActionPerformed(evt);
            }
        });
        jPanel2.add(txtCMNDTK, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 129, -1));

        tableHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 14));  
        tableHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã hóa đơn", "Khách hàng", "CCCD/CMND", "Mã phòng", "Ngày đến"
            }
        ));
        tableHoaDon.setShowGrid(true);
        tableHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableHoaDonMouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tableHoaDon);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 740, 480));

        btnTimKiem.setBackground(new java.awt.Color(0, 102, 102));
        btnTimKiem.setFont(new java.awt.Font("Segoe UI", 1, 14));  
        btnTimKiem.setForeground(new java.awt.Color(255, 255, 255));
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-search-25.png"))); 
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));
        btnTimKiem.setName("btnTimKiem");
        btnTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnTimKiemMouseReleased(evt);
            }
        });
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });
        jPanel2.add(btnTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 110, 40));

        btnTatCa.setBackground(new java.awt.Color(0, 102, 102));
        btnTatCa.setFont(new java.awt.Font("Segoe UI", 1, 14));  
        btnTatCa.setForeground(new java.awt.Color(255, 255, 255));
        btnTatCa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-select-all-25.png"))); 
        btnTatCa.setText("Tất cả");
        btnTatCa.setToolTipText("");
        btnTatCa.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));
        btnTatCa.setName("btnXemTatCa");  
        btnTatCa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnTatCaMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnTatCaMouseReleased(evt);
            }
        });
        jPanel2.add(btnTatCa, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, 110, 40));

        btnInHoaDon.setBackground(new java.awt.Color(0, 102, 102));
        btnInHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 14));  
        btnInHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        btnInHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-print-25.png"))); 
        btnInHoaDon.setMnemonic('I');
        btnInHoaDon.setText("In hoá đơn");
        btnInHoaDon.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));
        btnInHoaDon.setName("btnInHoaDon");  
        btnInHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnInHoaDonMouseReleased(evt);
            }
        });
        btnInHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInHoaDonActionPerformed(evt);
            }
        });
        jPanel2.add(btnInHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 660, 120, 34));

        btnThanhToan.setBackground(new java.awt.Color(0, 102, 102));
        btnThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 14));  
        btnThanhToan.setForeground(new java.awt.Color(255, 255, 255));
        btnThanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-receive-cash-25.png")));  
        btnThanhToan.setText("Thanh toán");
        btnThanhToan.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));
        btnThanhToan.setName("btnThanhToan"); 
        btnThanhToan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnThanhToanMouseReleased(evt);
            }
        });
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });
        jPanel2.add(btnThanhToan, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 660, 120, 34));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 802, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 771, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jPanel1.getAccessibleContext().setAccessibleName("Chi tiết hóa đơn");
    } 

    private void txtTienMatActionPerformed(java.awt.event.ActionEvent evt) { 
        // TODO add your handling code here:
    } 

    private void txtCMNDTKActionPerformed(java.awt.event.ActionEvent evt) { 
        // TODO add your handling code here:
    } 

    private void btnInHoaDonMouseReleased(java.awt.event.MouseEvent evt) { 
        // TODO add your handling code here:
    } 

    private void btnInHoaDonActionPerformed(java.awt.event.ActionEvent evt) { 
        PrinterJob job = PrinterJob.getPrinterJob(); 
        boolean ok = job.printDialog();  
        if (ok) {
            try {
                job.print(); 
            } catch (PrinterException ex) {
                JOptionPane.showMessageDialog(this, "Lỗi khi in hóa đơn: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    } 

    private void btnTimKiemMouseReleased(java.awt.event.MouseEvent evt) { 

        Object[][] data = new Object[dsHoaDon.size()][5];        
        int cnt = 0; 
        for( int i = 0; i < dsHoaDon.size(); i++ ) {
            if( txtCMNDTK.getText().trim().equals( dsHoaDon.get(i).getBookRooms().get(0).getCustomer().getCCCD() ) ) {
                BookRoom br = dsHoaDon.get(i).getBookRooms().get(0);
                data[cnt][0] = dsHoaDon.get(i).getOrderID();
                data[cnt][1] = br.getCustomer().getCustomerName();
                data[cnt][2] = br.getCustomer().getCCCD();
                data[cnt][3] = br.getRoom().getRoomID();
                
                System.out.println(br.getCheckInTime() +" :haha2");
                data[cnt][4] = chuyenDoiNgay(br.getCheckInTime(), br.getCheckInDate()).toString();
                cnt++; 
            }
        }
        tableHoaDon.setModel(new javax.swing.table.DefaultTableModel(   
                data,
                new String[]{
                    "Mã hóa đơn", "Khách hàng", "CCCD/CMND", "Mã phòng", "Ngày đến"
                }
        ));
        
        if(cnt > 0) {
            loadChiTietHoaDon(0);
        }
            
    } 

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) { 
        // TODO add your handling code here:
    } 
    
    Order o = null;
    private void loadChiTietHoaDon( int row ) {
        String idHoaDon = tableHoaDon.getValueAt(row, 0)+""; 
        for( Order o1 : dsHoaDon ){
            if( o1.getOrderID().equals(idHoaDon) ) {
                o = o1; 
                break;
            }
        }
        if(o==null) {
            System.out.println("hoÃ¡ Ä‘Æ¡n bá»‹ null"); 
            return; 
        }
        
        BookRoom br = o.getBookRooms().get(0); 
        txtKhachHang.setText(br.getEmployee().getEmployeeName());
        txtCCCD.setText(br.getCustomer().getCCCD());
        txtMaPhong.setText(br.getRoom().getRoomID());
        txtMaHoaDon.setText(o.getOrderID());
        txtThuNgan.setText(br.getCustomer().getCustomerName());
        txtNgayDen.setText( tableHoaDon.getValueAt(row, 4)+"" );
        
        
        
       
        ArrayList<ServiceDetail> ds = new ServiceDetailDAO().getListServiceDetailByOrderID(o.getOrderID()); 
        Object[][] data = new Object[ds.size()+1][3]; 
        double sum = 0;
        for(int i = 0 ; i < ds.size(); i++) {
            data[i][0] = ds.get(i).getService().getServiceName() + "(" + ds.get(i).getQuantity()+")"; 
            data[i][1] = df.format( ds.get(i).getService().getPrice() ); 
            data[i][2] = df.format( ds.get(i).getService().getPrice()* ds.get(i).getQuantity() ); 
            sum +=(double)ds.get(i).getService().getPrice()* ds.get(i).getQuantity(); 
        }
        data[ds.size()][0] = "Tổng"; 
        data[ds.size()][2] =df.format( sum); 
        
        
        tableDichVu.setModel(new javax.swing.table.DefaultTableModel(
            data,
            new String [] {
                "Dịch vụ", "Giá", "Thành tiền"
            }
        ));
        
   }
    
    private void tableHoaDonMouseReleased(java.awt.event.MouseEvent evt) { 
        int row = tableHoaDon.getSelectedRow();
        txtNgayDi.setText("");
        txtTienPhong.setText("");
        txtKhuyenMaiTien.setText("");
        txtKhuyenMaiPhanTram.setText("");
        txtTongCong.setText("");
        txtTienMat.setText("");
        txtTienThoi.setText("");
        txtThueVAT.setText("");
        loadChiTietHoaDon(row);
        
    } 

    private void btnTatCaMouseReleased(java.awt.event.MouseEvent evt) { 
        // TODO add your handling code here:

    } 

    private void txtTienPhongActionPerformed(java.awt.event.ActionEvent evt) { 
        // TODO add your handling code here:
    } 

    private void btnTatCaMousePressed(java.awt.event.MouseEvent evt) { 
        try {
            loadDataTableHoaDon();
        } catch (ParseException ex) {
            Logger.getLogger(GD_ThanhToan.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    double tongTien = 0; 
    private void btnThanhToanMouseReleased(java.awt.event.MouseEvent evt) {
        
        if(o==null){
            JOptionPane.showMessageDialog(this, "ChÆ°a chá»�n hoÃ¡ Ä‘Æ¡n cáº§n thanh toÃ¡n");
            return; 
        }
        LocalTime currentTime = LocalTime.now();
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String checkOutTime = currentTime.format(formatter);
        String checkOutDate = currentDate.format(formatter2);
        o.setCheckOutTime(checkOutTime);
        o.setCheckOutDate(checkOutDate);
        o.setStatus("Đã thanh toán");
        
        new OrderDAO().update(o);
        Room r = o.getBookRooms().get(0).getRoom(); 
        r.setRoomStatusType(new RoomStatusType("LTTP005", "Dá»�n dáº¹p"));
        new RoomDAO().updateRoom(r);
        
        try {
            txtTienPhong.setText( df.format(o.getTongTienPhong()) );
            double vat=0, km=0; 
            if( o.getBookRooms().get(0).getCustomer().getCustomerType().getCustomerTypeID().equals("LKH002") ) {
                txtKhuyenMaiPhanTram.setText("5%"); 
                txtKhuyenMaiTien.setText( "-"+df.format(km=o.getTongTien()*0.05) );
            }
            
            txtThueVAT.setText( df.format( vat=o.getTongTien()*0.08 ) );
            txtTongCong.setText( df.format(tongTien =  o.getTongTien()+vat-km) );
            
        } catch (ParseException ex) {
            Logger.getLogger(GD_ThanhToan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GD_ThanhToan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GD_ThanhToan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        txtNgayDi.setText(checkOutDate+" "+checkOutTime);
        
        try {
            loadDataTableHoaDon();
        } catch (ParseException ex) {
            Logger.getLogger(GD_ThanhToan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    } 
    private void txtTienMatKeyReleased(java.awt.event.KeyEvent evt) {
        double tienMat = Double.parseDouble(txtTienMat.getText());
        txtTienThoi.setText(df.format(tienMat - tongTien)); 
 
    }


     
    private javax.swing.JButton btnInHoaDon;
    private javax.swing.JButton btnTatCa;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tableDichVu;
    private javax.swing.JTable tableHoaDon;
    private javax.swing.JTextField txtCCCD;
    private javax.swing.JTextField txtCMNDTK;
    private javax.swing.JTextField txtKhachHang;
    private javax.swing.JTextField txtKhuyenMaiPhanTram;
    private javax.swing.JTextField txtKhuyenMaiTien;
    private javax.swing.JTextField txtMaHoaDon;
    private javax.swing.JTextField txtMaPhong;
    private javax.swing.JTextField txtNgayDen;
    private javax.swing.JTextField txtNgayDi;
    private javax.swing.JTextField txtThuNgan;
    private javax.swing.JTextField txtThueVAT;
    private javax.swing.JTextField txtThueVATPhanTram;
    private javax.swing.JTextField txtTienMat;
    private javax.swing.JTextField txtTienPhong;
    private javax.swing.JTextField txtTienThoi;
    private javax.swing.JTextField txtTongCong; 
}
