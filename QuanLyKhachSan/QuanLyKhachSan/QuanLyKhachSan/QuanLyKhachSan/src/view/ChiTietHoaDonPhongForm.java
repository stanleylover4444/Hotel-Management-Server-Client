/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import com.itextpdf.text.BadElementException;
import component.ThoiGianVao;
import component.ThongTinTaiKhoan;
import controller.InPDF;
import dao.ChiTietHoaDonDichVuDAO;
import dao.ChiTietHoaDonPhongDAO;
import dao.TaiKhoanDAO;

import dao.DichVuDAO;
import dao.HoaDonPhongDAO;
import dao.PhongDAO;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import listener.TraPhongListener;
import model.ChiTietHoaDonDichVu;

import model.DichVu;
import model.HoaDonDichVu;
import model.HoaDonPhong;

public class ChiTietHoaDonPhongForm extends javax.swing.JDialog {

    private String MaHoaDonPhong;
     private String MaPhieuThue ;
    SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    DecimalFormat formatter = new DecimalFormat("###,###,###");
    private HoaDonPhongForm parent;
    private ArrayList<ChiTietHoaDonDichVu> huhu;

    private TraPhongListener traPhongListener;

    public void setTraPhongListener(TraPhongListener traPhongListener) {
        this.traPhongListener = traPhongListener;
    }

    double phuThu = 0;
    double duaTruoc = 0;
    double tongtienDV = 0;

    private DefaultTableModel tblNhapHangmd1;

    public ChiTietHoaDonPhongForm(javax.swing.JInternalFrame parent, javax.swing.JFrame owner, boolean modal) {
        
        super(owner, modal);
        this.parent = (HoaDonPhongForm) parent;
        huhu = new ArrayList<>();
        initComponents(); // Di chuyển gọi này lên đầu
        dichvudachon(); // Gọi sau khi tblDichVuDaChon được khởi tạo
        loadDataToTableProduct1();
        
        
     
        txtcheckin.setEnabled(false);
        txtcheckout.setEnabled(false);
        txttongtimesd.setEnabled(false);
        txtnote.setEditable(false);
        tblDichVuDaChon.setEnabled(false);
        txtmaKH.setEnabled(false);
        txttenKH.setEnabled(false);
        txtcmtkh.setEnabled(false);
        cbxgioitinh.setEnabled(false);
        txtSDT.setEnabled(false);
        txtDCKH.setEnabled(false);
        txtsonguoi.setEnabled(false);
        txtDATEKH.setEnabled(false);
        txtPhong.setEnabled(false);
        txtcheckin.setEnabled(false);
        txtcheckout.setEnabled(false);
        txtnhanvienchothue.setEnabled(false);
        txtnhanvienthanhtoan.setEnabled(false);
        txtdongiaPhong.setEnabled(false);
        txtloaiphong.setEnabled(false);
        txtphuthu.setEnabled(false);
        txttongtiendichvu.setEnabled(false);
        txttongtienphong.setEnabled(false);
        txttienkhachhangtra.setEnabled(false);
        txtduatruoc.setEnabled(false);
        txttongtimesd.setEnabled(false);
        cbxkieuthue.setEnabled(false);
        txtmaphieuthue.setEnabled(false);
        txtngaydukien.setEnabled(false);
        txttientheogio.setEnabled(false);
        txtHDP.setEnabled(false);
        tblDichVuDaChon.setModel(tblNhapHangmd1);

        setLocationRelativeTo(null);

    
        displayInfo();

    }

    public final void dichvudachon() {
        tblNhapHangmd1 = new DefaultTableModel();
        String[] headerTbl = new String[]{"Tên dịch vụ", "Số lượng", "Đơn giá"};
        tblNhapHangmd1.setColumnIdentifiers(headerTbl);
        tblDichVuDaChon.setModel(tblNhapHangmd1);
        tblDichVuDaChon.getColumnModel().getColumn(0).setPreferredWidth(200);
        tblDichVuDaChon.getColumnModel().getColumn(1).setPreferredWidth(40);
        tblDichVuDaChon.getColumnModel().getColumn(2).setPreferredWidth(40);
        //tblDichVuDaChon.getColumnModel().getColumn(3).setPreferredWidth(20);

    }

    
public void loadDataToTableProduct1() {
    try {
        String maPhieuThue = this.parent.getDuLieuSelect().getMaPhieuThuePhong();
        System.out.println("Ma phieu thue phong: " + maPhieuThue);

        huhu = ChiTietHoaDonDichVuDAO.getInstance().selectAll(maPhieuThue);
        tblNhapHangmd1.setRowCount(0);
        int length = huhu.size();
       
        System.out.println("Độ dài của danh sách CTHDP: " + length);
        if (huhu.size() > 0) {
            System.out.println("Dữ liệu CTHDP có sẵn.");
            System.out.println(huhu);
        } else {
            System.out.println("Dữ liệu CTHDP không có sẵn hoặc danh sách rỗng.");
        }
           for (var i : huhu) {
                tblNhapHangmd1.addRow(new Object[]{
                    i.getMaDichvu(),
                    i.getSoLuong(),
                    formatter.format(i.getDonGia())
                });
            }
    } catch (Exception e) {
          e.printStackTrace();
    }


}

    

    private void displayInfo() {
        HoaDonPhong a = parent.getDuLieuSelect();

        txtmaKH.setText(a.getMaKH());
        txttenKH.setText(a.getTenKH());
        txtcmtkh.setText(a.getCmtKH());
        txtcheckin.setText(formatDate.format(a.getCheckIn()));
        cbxgioitinh.setSelectedIndex(a.isGioiTinhKH() ? 1 : 0);
        cbxkieuthue.setSelectedIndex(a.isHinhThucThue() ? 1 : 0);
        txtSDT.setText(a.getSdtKH());
        txtDCKH.setText(a.getDiaChi());
        txtDATEKH.setText(a.getNgaySinhKH());
        txtsonguoi.setText(Integer.toString(a.getSoNguoi()));
        txtnhanvienchothue.setText(a.getTenNV());

       txtcheckout.setText(formatDate.format(a.getCheckOut()));
        txttongtimesd.setText(a.getThoiGianSuDung());
        txtnhanvienthanhtoan.setText(a.getNguoiTao());
        txtHDP.setText(a.getMaHoaDonPhong());
        txtPhong.setText(a.getMaPhong());
        txtloaiphong.setText(a.getLoaiPhong());

        double donGiaPhong = a.getDonGiaPhong();
        String formattedDonGiaPhong = formatter.format(donGiaPhong);
        txtdongiaPhong.setText(formattedDonGiaPhong);

        
        double tienDichDV = a.getTienDichVu();
        String formattedtienDichDV = formatter.format(tienDichDV);
        txttongtiendichvu.setText(formattedtienDichDV);
        
        
        double tongTienPhong = a.getTongTienPhong();
        String formattedtongTienPhong = formatter.format(tongTienPhong);
        txttongtienphong.setText(formattedtongTienPhong);
        
        double tienPhongTheoGio = a.getTienTheoGio();
        String formattedtienPhongTheoGio = formatter.format(tienPhongTheoGio);
        txttientheogio.setText(formattedtienPhongTheoGio);
        
        double tongTienKHTra = a.getTongTienKHTra();
        String formattedtongTienKHTra = formatter.format(tongTienKHTra);
        txttienkhachhangtra.setText(formattedtongTienKHTra);
        
        
        
        txtnote.setText(a.getGhiChu());
        txtngaydukien.setText(a.getDuKienCheckOut());
        double phuThu = a.getPhuThu();
        String formattedPhuThu = formatter.format(phuThu);
        txtphuthu.setText(formattedPhuThu);

        double duaTruoc = a.getDuaTruoc();
        String formattedDuaTruoc = formatter.format(duaTruoc);
        txtduatruoc.setText(formattedDuaTruoc);

        txtmaphieuthue.setText(a.getMaPhieuThuePhong());


    }

//   public void loadDataToTableProduct1() {
//    try {
//        String maPhieuThue = this.parent.getDuLieuSelect().getMaPhieuThuePhong();
//        System.out.println("Ma phieu thue phong: " + maPhieuThue);
//
//        huhu = ChiTietHoaDonDichVuDAO.getInstance().selectAll(maPhieuThue);
//        tblNhapHangmd1.setRowCount(0);
//        int length = huhu.size();
//       
//        System.out.println("Độ dài của danh sách CTHDP: " + length);
//        if (huhu.size() > 0) {
//            System.out.println("Dữ liệu CTHDP có sẵn.");
//            System.out.println(huhu);
//        } else {
//            System.out.println("Dữ liệu CTHDP không có sẵn hoặc danh sách rỗng.");
//        }
//        for (ChiTietHoaDonDichVu chiTiet : huhu) {
//            String maDichVu = chiTiet.getMaDichvu();
//            String tenDichVu = DichVuDAO.getInstance().selectById(maDichVu).getTenDichVu();
//            int soLuong = chiTiet.getSoLuong();
//            double donGia = chiTiet.getDonGia();
//            tblNhapHangmd1.addRow(new Object[]{
//               
//                tenDichVu,
//                soLuong,
//                formatter.format(donGia)
//            });
//        }
//    } catch (Exception e) {
//        // Xử lý ngoại lệ nếu cần thiết
//    }
//
//
//}


  


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txttenKH = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtcmtkh = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtDATEKH = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtmaKH = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtsonguoi = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtngaydukien = new javax.swing.JTextField();
        cbxgioitinh = new javax.swing.JComboBox<>();
        txtSDT = new javax.swing.JTextField();
        txtDCKH = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        txtPhong = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cbxkieuthue = new javax.swing.JComboBox<>();
        jLabel36 = new javax.swing.JLabel();
        txtdongiaPhong = new javax.swing.JTextField();

        ;
        jLabel11 = new javax.swing.JLabel();
        txtloaiphong = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        txtcheckout = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        txttongtiendichvu = new javax.swing.JTextField();

        ;
        txttienkhachhangtra = new javax.swing.JTextField();

        ;
        txtphuthu = new javax.swing.JTextField();

        ;
        txttongtienphong = new javax.swing.JTextField();

        ;
        txtcheckin = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtduatruoc = new javax.swing.JTextField();

        ;
        txttongtimesd = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtmaphieuthue = new javax.swing.JTextField();
        txttientheogio = new javax.swing.JTextField();

        ;
        jLabel41 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDichVuDaChon = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        txtnote = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        txtnhanvienchothue = new javax.swing.JTextField();
        txtnhanvienthanhtoan = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        txtHDP = new javax.swing.JTextField();

        ;
        jLabel14 = new javax.swing.JLabel();
        btnpdf = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Chi Tiết Hóa Đơn Phòng");
        setPreferredSize(new java.awt.Dimension(1210, 740));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(1200, 750));
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 690));

        jPanel2.setBackground(new java.awt.Color(153, 0, 51));

        jLabel1.setFont(new java.awt.Font("SF Pro Display", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CHI TIẾT HÓA ĐƠN PHÒNG");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(423, 423, 423))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin khách hàng"));
        jPanel8.setPreferredSize(new java.awt.Dimension(462, 350));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Tên khách hàng:");

        txttenKH.setPreferredSize(new java.awt.Dimension(200, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("CCCD/CMND :");

        txtcmtkh.setPreferredSize(new java.awt.Dimension(200, 30));
        txtcmtkh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcmtkhActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtDATEKH.setPreferredSize(new java.awt.Dimension(200, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Ngày sinh :");

        txtmaKH.setPreferredSize(new java.awt.Dimension(200, 30));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setText("Mã khách hàng :");

        txtsonguoi.setPreferredSize(new java.awt.Dimension(200, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Số người :");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Ngày dự kiến :");

        txtngaydukien.setPreferredSize(new java.awt.Dimension(200, 30));

        cbxgioitinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
        cbxgioitinh.setPreferredSize(new java.awt.Dimension(200, 30));

        txtSDT.setPreferredSize(new java.awt.Dimension(200, 30));

        txtDCKH.setPreferredSize(new java.awt.Dimension(200, 30));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText("Địa chỉ :");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("Giới tính :");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setText("Số điện thoại :");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(0, 0, 0)
                        .addComponent(txtmaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5))
                            .addComponent(jLabel6))
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txttenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcmtkh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(txtngaydukien, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addComponent(jLabel19))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtsonguoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDATEKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(32, 32, 32)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDCKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxgioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 204, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtmaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDATEKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txttenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtsonguoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcmtkh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtngaydukien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(cbxgioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDCKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 15, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin hóa đơn"));

        txtPhong.setEditable(false);
        txtPhong.setBackground(new java.awt.Color(204, 204, 204));
        txtPhong.setPreferredSize(new java.awt.Dimension(130, 25));
        txtPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhongActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Mã phòng:");

        cbxkieuthue.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thuê theo giờ", "Thuê theo ngày" }));
        cbxkieuthue.setPreferredSize(new java.awt.Dimension(130, 25));
        cbxkieuthue.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxkieuthueItemStateChanged(evt);
            }
        });
        cbxkieuthue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxkieuthueActionPerformed(evt);
            }
        });
        cbxkieuthue.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cbxkieuthuePropertyChange(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel36.setText("Tiền phòng theo giờ :");

        txtdongiaPhong.setPreferredSize(new java.awt.Dimension(130, 25));
        txtdongiaPhong.setRequestFocusEnabled(false);
        txtdongiaPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdongiaPhongActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Đơn giá  :");

        txtloaiphong.setPreferredSize(new java.awt.Dimension(130, 25));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Mã phiếu thuê :");

        jLabel37.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel37.setText("Thời gian vào :");

        jLabel38.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel38.setText("Tổng thời gian thuê :");

        txtcheckout.setPreferredSize(new java.awt.Dimension(130, 25));

        jLabel39.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel39.setText("Hình thức thuê :");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setText("Tổng tiền phòng :");

        jLabel40.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel40.setText("Phụ thu :");

        jLabel43.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel43.setText("Tổng tiền khách hàng phải trả :");

        txttongtiendichvu.setPreferredSize(new java.awt.Dimension(100, 25));
        txttongtiendichvu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttongtiendichvuActionPerformed(evt);
            }
        });

        txttienkhachhangtra.setPreferredSize(new java.awt.Dimension(100, 25));
        txttienkhachhangtra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttienkhachhangtraActionPerformed(evt);
            }
        });

        txtphuthu.setPreferredSize(new java.awt.Dimension(100, 25));
        txtphuthu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtphuthuActionPerformed(evt);
            }
        });

        txttongtienphong.setPreferredSize(new java.awt.Dimension(100, 25));
        txttongtienphong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttongtienphongActionPerformed(evt);
            }
        });

        txtcheckin.setFont(txtcheckin.getFont());
        txtcheckin.setPreferredSize(new java.awt.Dimension(130, 25));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setText("Đưa trước :");

        txtduatruoc.setPreferredSize(new java.awt.Dimension(100, 25));
        txtduatruoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtduatruocActionPerformed(evt);
            }
        });

        txttongtimesd.setPreferredSize(new java.awt.Dimension(130, 25));
        txttongtimesd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttongtimesdActionPerformed(evt);
            }
        });

        jLabel47.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel47.setText("Thời gian ra : ");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Loại phòng :");

        txtmaphieuthue.setPreferredSize(new java.awt.Dimension(130, 25));

        txttientheogio.setPreferredSize(new java.awt.Dimension(100, 25));
        txttientheogio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttientheogioActionPerformed(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel41.setText("Tiền dịch vụ :");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Dịch vụ đã khách hàng sử dụng"));

        tblDichVuDaChon.setFont(tblDichVuDaChon.getFont().deriveFont((float)15));
        tblDichVuDaChon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên dịch vụ", "Số lượn", "Đơn giá"
            }
        ));
        jScrollPane1.setViewportView(tblDichVuDaChon);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Ghi chú "));

        txtnote.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N
        txtnote.setPreferredSize(new java.awt.Dimension(200, 30));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtnote, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtnote, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel45.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel45.setText("Nhân viên  cho thuê :");

        txtnhanvienchothue.setPreferredSize(new java.awt.Dimension(130, 25));

        txtnhanvienthanhtoan.setPreferredSize(new java.awt.Dimension(130, 25));

        jLabel46.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel46.setText("Nhân viên  thanh toán:");

        txtHDP.setPreferredSize(new java.awt.Dimension(130, 25));
        txtHDP.setRequestFocusEnabled(false);
        txtHDP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHDPActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Mã hóa đơn Phòng  :");

        btnpdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_pdf_25px.png"))); // NOI18N
        btnpdf.setText("Xuất PDF");
        btnpdf.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnpdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpdfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel37)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtloaiphong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcheckin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcheckout, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtmaphieuthue, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(cbxkieuthue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(672, 672, 672))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel43)
                        .addGap(18, 18, 18)
                        .addComponent(txttienkhachhangtra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnpdf))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addComponent(jLabel24)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtduatruoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(210, 210, 210))
                                            .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txttientheogio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtphuthu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addGap(299, 299, 299)
                                                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txttongtiendichvu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(37, 37, 37)
                                        .addComponent(jLabel23)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txttongtienphong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel38)
                                            .addComponent(jLabel46)
                                            .addComponent(jLabel45))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtnhanvienchothue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txttongtimesd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtnhanvienthanhtoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(36, 36, 36)
                                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel11)
                                                    .addComponent(jLabel14))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtHDP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtdongiaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtmaphieuthue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38)
                    .addComponent(txttongtimesd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdongiaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtcheckin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel37)
                        .addComponent(jLabel47)
                        .addComponent(txtcheckout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtnhanvienthanhtoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtHDP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel46, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtloaiphong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39)
                    .addComponent(cbxkieuthue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnhanvienchothue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel40)
                            .addComponent(txtphuthu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel41)
                                .addComponent(txttongtiendichvu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel23)
                                .addComponent(txttongtienphong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(txtduatruoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel43)
                            .addComponent(txttienkhachhangtra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnpdf)))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel36)
                        .addComponent(txttientheogio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(102, 102, 102))
        );

        jPanel4.getAccessibleContext().setAccessibleName("Đánh giá");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 1189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 671, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getAccessibleContext().setAccessibleName("Thanh toán phòng");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtcmtkhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcmtkhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcmtkhActionPerformed


 
  

   
    


    private void txttientheogioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttientheogioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttientheogioActionPerformed

    private void txtduatruocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtduatruocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtduatruocActionPerformed

    private void txttongtienphongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttongtienphongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttongtienphongActionPerformed

    private void txtphuthuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtphuthuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtphuthuActionPerformed

    private void txttienkhachhangtraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttienkhachhangtraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttienkhachhangtraActionPerformed

    private void txttongtiendichvuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttongtiendichvuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttongtiendichvuActionPerformed

    private void txtdongiaPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdongiaPhongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdongiaPhongActionPerformed

    private void cbxkieuthuePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cbxkieuthuePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxkieuthuePropertyChange

    private void cbxkieuthueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxkieuthueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxkieuthueActionPerformed

    private void cbxkieuthueItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxkieuthueItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxkieuthueItemStateChanged

    private void txttongtimesdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttongtimesdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttongtimesdActionPerformed

    private void txtPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhongActionPerformed

    private void txtHDPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHDPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHDPActionPerformed

    private void btnpdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpdfActionPerformed
         
          // TODO add your handling code here:
        InPDF writepdf = new InPDF();
        String MaHoaDonPhong = txtHDP.getText();
         String MaPhieuThue = txtmaphieuthue.getText();
      writepdf.writeHoaDonPhong(MaHoaDonPhong ,MaPhieuThue); 
         
         
         
    }//GEN-LAST:event_btnpdfActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnpdf;
    private javax.swing.JComboBox<String> cbxgioitinh;
    private javax.swing.JComboBox<String> cbxkieuthue;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDichVuDaChon;
    private javax.swing.JTextField txtDATEKH;
    private javax.swing.JTextField txtDCKH;
    private javax.swing.JTextField txtHDP;
    private javax.swing.JTextField txtPhong;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtcheckin;
    private javax.swing.JTextField txtcheckout;
    private javax.swing.JTextField txtcmtkh;
    private javax.swing.JTextField txtdongiaPhong;
    private javax.swing.JTextField txtduatruoc;
    private javax.swing.JTextField txtloaiphong;
    private javax.swing.JTextField txtmaKH;
    private javax.swing.JTextField txtmaphieuthue;
    private javax.swing.JTextField txtngaydukien;
    private javax.swing.JTextField txtnhanvienchothue;
    private javax.swing.JTextField txtnhanvienthanhtoan;
    private javax.swing.JTextField txtnote;
    private javax.swing.JTextField txtphuthu;
    private javax.swing.JTextField txtsonguoi;
    private javax.swing.JTextField txttenKH;
    private javax.swing.JTextField txttienkhachhangtra;
    private javax.swing.JTextField txttientheogio;
    private javax.swing.JTextField txttongtiendichvu;
    private javax.swing.JTextField txttongtienphong;
    private javax.swing.JTextField txttongtimesd;
    // End of variables declaration//GEN-END:variables

 

   
}
