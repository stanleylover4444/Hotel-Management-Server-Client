/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import listener.TraPhongListener;
import model.ChiTietHoaDonDichVu;
import model.ChiTietHoaDonPhong;
import model.DichVu;
import model.HoaDonDichVu;
import model.HoaDonPhong;

public class ThanhToanPhong extends javax.swing.JDialog {

    private String MaHoaDonPhong;
 
    SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    DecimalFormat formatter = new DecimalFormat("###,###,###");
    private QuanLiPhongForm parent;
    private ArrayList<ChiTietHoaDonDichVu> huhu;

    private TraPhongListener traPhongListener;

    public void setTraPhongListener(TraPhongListener traPhongListener) {
        this.traPhongListener = traPhongListener;
    }

    double phuThu = 0;
    double duaTruoc = 0;
    double tongtienDV = 0;

    private DefaultTableModel tblNhapHangmd1;

    public ThanhToanPhong(javax.swing.JInternalFrame parent, javax.swing.JFrame owner, boolean modal) {
        super(owner, modal);
        this.parent = (QuanLiPhongForm) parent;
        huhu = new ArrayList<>();
        initComponents(); // Di chuyển gọi này lên đầu
        dichvudachon(); // Gọi sau khi tblDichVuDaChon được khởi tạo
        loadDataToTableProduct1();
        calculateTotalTime();
        setLocationRelativeTo(null);

        MaHoaDonPhong = createId(HoaDonPhongDAO.getInstance().selectAll());
      
        txtHDP.setText(MaHoaDonPhong);

        txtcheckin.setEnabled(false);
        txtcheckout.setEnabled(false);
        txttongtimesd.setEnabled(false);
        txttongtiendichvu.setText(formatter.format(tinhTongTien()));
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

    private ThanhToanPhong(JFrame jFrame, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void calculateTotalTime() {
        try {
            String checkinText = txtcheckin.getText();
            String checkoutText = txtcheckout.getText();

            if (checkinText.isEmpty() || checkoutText.isEmpty()) {
                // Display or handle when one of the fields is empty
                return;
            }

            Date checkinTime = formatDate.parse(checkinText);
            Date checkoutTime = formatDate.parse(checkoutText);
            long totalTimeMillis = checkoutTime.getTime() - checkinTime.getTime();

            // Determine rental type: hourly or daily
            String kieuThue = cbxkieuthue.getSelectedItem().toString();
            String loaiPhong = txtloaiphong.getText();  // Assuming this gets the room type text

            long hours = totalTimeMillis / (1000 * 60 * 60);
            double tienTuThoiGian = 0;

            if (kieuThue.equals("Thuê theo giờ")) {
                switch (loaiPhong) {
                    case "Phòng đơn":
                        tienTuThoiGian = hours * 30000;  // Assume 30,000 per hour
                        break;
                    case "Phòng đơn VIP":
                        tienTuThoiGian = hours * 60000;  // Assume 60,000 per hour
                        break;
                    case "Phòng đôi":
                        tienTuThoiGian = hours * 120000; // Assume 120,000 per hour
                        break;
                    case "Phòng đôi VIP":
                        tienTuThoiGian = hours * 150000; // Assume 150,000 per hour
                        break;
                    default:
                        tienTuThoiGian = hours * 30000;  // Default case if no type matches
                        break;
                }
            } else if (kieuThue.equals("Thuê theo ngày")) {
                tienTuThoiGian = 0;  // Set to 0 for daily rentals
            }

            double dongiaPhong = Double.parseDouble(txtdongiaPhong.getText().replace(".", "").replace(",", "."));
            double phuthu = Double.parseDouble(txtphuthu.getText().replace(".", "").replace(",", "."));
            double tratruoc = Double.parseDouble(txtduatruoc.getText().replace(".", "").replace(",", "."));
            double tiendichvu = Double.parseDouble(txttongtiendichvu.getText().replace(".", "").replace(",", "."));
            double tongTienPhong = dongiaPhong + tienTuThoiGian;
            double tienkhachhangtra = tongTienPhong + tiendichvu + phuthu - tratruoc;

            long minutes = (totalTimeMillis % (1000 * 60 * 60)) / (1000 * 60);
            long seconds = ((totalTimeMillis % (1000 * 60 * 60)) % (1000 * 60)) / 1000;

            String formattedTongTienPhong = formatter.format(tongTienPhong);
            txttongtienphong.setText(formattedTongTienPhong);
            System.out.println(formattedTongTienPhong);

            String formattedTienTheoGio = formatter.format(tienTuThoiGian);
            txttientheogio.setText(formattedTienTheoGio);
            System.out.println(formattedTienTheoGio);

            String formattedtienkhachangtra = formatter.format(tienkhachhangtra);
            txttienkhachhangtra.setText(formattedtienkhachangtra);

            // Display or store total time
            String totalTime = String.format("%02d:%02d:%02d", hours, minutes, seconds);
            txttongtimesd.setText(totalTime);
            System.out.println(totalTime);

            // If you want to save to a file, you can do so here
            // Example: writeFile("txttongthoigiansudung.txt", totalTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void displayInfo() {
        
        ChiTietHoaDonPhong a = parent.getNhaCungCapSelect();
     
        txtmaphieuthue.setText(a.getMaPhieuThuePhong());
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

        txtPhong.setText(a.getMaPhong());
        txtloaiphong.setText(a.getLoaiPhong());

        double donGiaPhong = a.getDonGiaPhong();
        String formattedDonGiaPhong = formatter.format(donGiaPhong);
        txtdongiaPhong.setText(formattedDonGiaPhong);

        txtngaydukien.setText(a.getDuKienCheckOut());
        double phuThu = a.getPhuThu();
        String formattedPhuThu = formatter.format(phuThu);
        txtphuthu.setText(formattedPhuThu);

        double duaTruoc = a.getDuaTruoc();
        String formattedDuaTruoc = formatter.format(duaTruoc);
        txtduatruoc.setText(formattedDuaTruoc);

      

    }

    public void loadDataToTableProduct1() {
        try {
            // Gán giá trị cho biến huhu trong phương thức
            //  ChiTietHoaDonDichVuDAO.getInstance().selectAll1(this.parent.getNhaCungCapSelect().getMaPhieuThuePhong());
            huhu = ChiTietHoaDonDichVuDAO.getInstance().selectAll1(this.parent.getNhaCungCapSelect().getMaPhieuThuePhong());
            
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
            // Xử lý ngoại lệ nếu cần thiết
        }
    }

    public void setNguoiTao() {
        txtnhanvienthanhtoan.setText(ThongTinTaiKhoan.getTaiKhoan().getTenNV());
    }

    public void setThoiGianNhanPhong() {
        ThoiGianVao.setTimeVao(txtcheckout);
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnThanhToan = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
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
        txtPhong = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Trả Phòng");
        setPreferredSize(new java.awt.Dimension(1210, 740));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(1200, 750));
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 690));

        jPanel2.setBackground(new java.awt.Color(153, 0, 51));

        jLabel1.setFont(new java.awt.Font("SF Pro Display", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("THANH TOÁN PHÒNG");

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

        btnThanhToan.setBackground(new java.awt.Color(153, 0, 51));
        btnThanhToan.setForeground(new java.awt.Color(255, 255, 255));
        btnThanhToan.setText("Thanh Toán");
        btnThanhToan.setBorder(null);
        btnThanhToan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThanhToan.setPreferredSize(new java.awt.Dimension(103, 29));
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(51, 51, 51));
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Huỷ bỏ");
        btnCancel.setBorder(null);
        btnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancel.setPreferredSize(new java.awt.Dimension(103, 29));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

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

        txtPhong.setFont(txtPhong.getFont());
        txtPhong.setPreferredSize(new java.awt.Dimension(130, 25));

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
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txttongtienphong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel43)
                        .addGap(18, 18, 18)
                        .addComponent(txttienkhachhangtra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                            .addComponent(txtdongiaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtmaphieuthue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38)
                    .addComponent(txttongtimesd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdongiaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addGap(23, 23, 23)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel43)
                            .addComponent(txttienkhachhangtra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel36)
                        .addComponent(txttientheogio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(109, 109, 109))
        );

        jPanel4.getAccessibleContext().setAccessibleName("Đánh giá");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(466, 466, 466))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleName("Thanh toán phòng");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtcmtkhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcmtkhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcmtkhActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed

        try {

            String maKh = txtmaKH.getText().trim();
            String tenKh = txttenKH.getText().trim();
            String cmtKH = txtcmtkh.getText().trim();
            String sdtKh = txtSDT.getText().trim();
            String ngaySinhKH = txtDATEKH.getText().trim();
            String diachiKh = txtDCKH.getText().trim();
            int soNguoi = 0;

            soNguoi = Integer.parseInt(txtsonguoi.getText().trim());
            String tenNV = txtnhanvienchothue.getText().trim();
            String maPhieuThuePhong = txtmaphieuthue.getText().trim();
            String maPhong = txtPhong.getText().trim();
            boolean gioiTinhKH = (cbxgioitinh.getSelectedIndex() == 1);
            boolean hinhThucThue = (cbxkieuthue.getSelectedIndex() == 1);
            String donGiaPhongStr = txtdongiaPhong.getText().trim();
            double donGiaPhong;
            try {
                donGiaPhong = formatter.parse(donGiaPhongStr).doubleValue();
            } catch (ParseException e) {

                e.printStackTrace();

                donGiaPhong = 0;
            }

            Timestamp checkIN = null;
            checkIN = Timestamp.valueOf(txtcheckin.getText());
            String duKienCheckOut = txtngaydukien.getText().trim();
            String loaiPhong = txtloaiphong.getText().trim();
            duaTruoc = Double.parseDouble(txtduatruoc.getText().trim());
            String phuThuStr = txtphuthu.getText().trim();

            try {
                phuThu = formatter.parse(phuThuStr).doubleValue();
            } catch (ParseException e) {
                e.printStackTrace();
                phuThu = 0;
            }
            
            int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thanh toán không?", "Xác nhận thanh toán", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return; // Người dùng chọn "No", không tiếp tục thực hiện thanh toán
        }

            double tienDichVu = formatter.parse(txttongtiendichvu.getText().trim()).doubleValue();
            double tongTienKHTra = formatter.parse(txttienkhachhangtra.getText().trim()).doubleValue();
            double tienTheoGio = formatter.parse(txttientheogio.getText().trim()).doubleValue();
            double tongTienPhong = formatter.parse(txttongtienphong.getText().trim()).doubleValue();

            String maHoaDonPhong = txtHDP.getText().trim();
            Timestamp thoigianTao = Timestamp.valueOf(txtcheckout.getText().trim());
            String nguoiTao = txtnhanvienthanhtoan.getText().trim();

            Timestamp checkOut = Timestamp.valueOf(txtcheckout.getText().trim());
            String thoiGianSuDung = txttongtimesd.getText().trim();
            String ghiChu = txtnote.getText().trim();

            HoaDonPhong kh = new HoaDonPhong();

            kh.setMaKH(maKh);
            kh.setTenKH(tenKh);
            kh.setSdtKH(sdtKh);
            kh.setDiaChi(diachiKh);
            kh.setNgaySinhKH(ngaySinhKH);
            kh.setCmtKH(cmtKH);
            kh.setGioiTinhKH(gioiTinhKH);
            kh.setTenNV(tenNV);
            kh.setMaPhieuThuePhong(maPhieuThuePhong);
            kh.setMaPhong(maPhong);
            kh.setHinhThucThue(hinhThucThue);
            kh.setLoaiPhong(loaiPhong);
            kh.setDuKienCheckOut(duKienCheckOut);
            kh.setDonGiaPhong(donGiaPhong);
            kh.setSoNguoi(soNguoi);

            long now = System.currentTimeMillis();
            Timestamp sqlTimestamp = new Timestamp(now);
            kh.setCheckIn(checkIN);
            kh.setDuaTruoc(duaTruoc);
            kh.setPhuThu(phuThu);

            kh.setTienDichVu(tienDichVu);
            kh.setTongTienKHTra(tongTienKHTra);
            kh.setTienTheoGio(tienTheoGio);
            kh.setTongTienPhong(tongTienPhong);
            kh.setMaHoaDonPhong(maHoaDonPhong);
            kh.setThoiGianTao(thoigianTao);
            kh.setNguoiTao(nguoiTao);
            kh.setCheckOut(checkOut);
            kh.setThoiGianSuDung(thoiGianSuDung);
            kh.setGhiChu(ghiChu);

            HoaDonPhongDAO.getInstance().insert(kh);
            int updated = PhongDAO.getInstance().updateTrangThai(maPhong, "Đang Dọn");
              int updatedtrangthaiphieu = ChiTietHoaDonPhongDAO.getInstance().updateTrangThaiPhieu(maPhieuThuePhong, "1");
            String MaPhieuThue = txtmaphieuthue.getText();
         JOptionPane.showMessageDialog(this, "Xuất hàng thành công !");
                  int res = JOptionPane.showConfirmDialog(this, "Bạn có muốn xuất file pdf ?");
                    if (res == JOptionPane.YES_OPTION) {
                        InPDF writepdf = new InPDF();
               
                        writepdf.writeHoaDonPhong(MaHoaDonPhong , MaPhieuThue);
                    }
                
            
//          int deletedCount =  ChiTietHoaDonPhongDAO.getInstance().delete(maPhieuThuePhong );
//        System.out.println("Deleted " + deletedCount + " ChiTietHoaDonPhong records.");
        JOptionPane.showMessageDialog(this, "Thanh toán thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

        
        } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Lỗi trong quá trình thanh toán: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
    } finally {
        // Cập nhật lại giao diện và đóng form
        parent.loadDataToTablePhong(PhongDAO.getInstance().selectAll());
        parent.loadDateToTablePTP(ChiTietHoaDonPhongDAO.getInstance().selectAll());
        parent.setColorForPanels();
        this.dispose();
    }

    }//GEN-LAST:event_btnThanhToanActionPerformed


 
    @Override
    public void setVisible(boolean b) {
        if (!b) {
            xoaRong();
        }
        super.setVisible(b);
    }

    @Override
    public void dispose() {

        super.dispose();
    }

    private void xoaRong() {

//        txtmaKH.setText(createKH());
//        txttenKH.setText("");
//        txtcmtkh.setText("");
//        txtSDT.setText("");
//        txtDATEKH.setText("");
//        txtDCKH.setText("");
//        txtSoNguoi.setText("");
//        txtTenNhanVien.setText("");
//
//        txtMaPhieuThue.setText(createId());
//        txtPhong.setText("");
//        txtdongiaPhong.setText("");
//        txttimenhanphong.setText("");
//        txtloaiphong.setText("");
//
//        txttratroc.setText("");
//        txtphuthu.setText("");
//        maDichvu = null;
//        soLuong = 0;
//        donGiaDV = 0;
//        DefaultTableModel tblNhapHangmd = (DefaultTableModel) tblDichVuDaChon.getModel();
//        tblNhapHangmd.setRowCount(0);
    }


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

    private void txtHDPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHDPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHDPActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnThanhToan;
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

    private Object tinhTongTien() {
        double tt = 0;
        for (var i : huhu) {
            tt += i.getDonGia() * i.getSoLuong();
        }
        return tt;

    }

    private String createId(ArrayList<HoaDonPhong> selectAll) {
        int id = selectAll.size() + 1;
        String check = "";
        for (HoaDonPhong hoaDonDichVu : selectAll) {
            if (hoaDonDichVu.getMaHoaDonPhong().equals("HDTTP" + id)) {
                check = hoaDonDichVu.getMaHoaDonPhong();
            }
        }
        while (check.length() != 0) {
            String c = check;
            id++;
            for (int i = 0; i < selectAll.size(); i++) {
                if (selectAll.get(i).getMaHoaDonPhong().equals("HDTTP" + id)) {
                    check = selectAll.get(i).getMaHoaDonPhong();
                }
            }
            if (check.equals(c)) {
                check = "";
            }
        }
        return "HDTTP" + id;
    }
      private String createId1(ArrayList<ChiTietHoaDonPhong> selectAll) {
        int id = selectAll.size() + 1;
        String check = "";
        for (ChiTietHoaDonPhong hoaDonDichVu : selectAll) {
            if (hoaDonDichVu.getMaPhieuThuePhong().equals("MPT" + id)) {
                check = hoaDonDichVu.getMaPhieuThuePhong();
            }
        }
        while (check.length() != 0) {
            String c = check;
            id++;
            for (int i = 0; i < selectAll.size(); i++) {
                if (selectAll.get(i).getMaPhieuThuePhong().equals("MPT" + id)) {
                    check = selectAll.get(i).getMaPhieuThuePhong();
                }
            }
            if (check.equals(c)) {
                check = "";
            }
        }
        return "MPT" + id;
    }
    

}


