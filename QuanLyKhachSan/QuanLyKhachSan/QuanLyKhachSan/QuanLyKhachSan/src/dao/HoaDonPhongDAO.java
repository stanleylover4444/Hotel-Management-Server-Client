/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.lang.model.util.Types;
import model.ChiTietHoaDonPhong;
import model.HoaDonDichVu;
import model.HoaDonPhong;

/**
 *
 * @author DELL
 */
public class HoaDonPhongDAO implements DAOInterface<HoaDonPhong>{

    public static HoaDonPhongDAO getInstance() {
        return new HoaDonPhongDAO();
    }

    @Override
    public int insert(HoaDonPhong t) {
    int ketQua = 0;
    try {
        Connection con = JDBCUtil.getConnection();
        String sql = "INSERT INTO HoaDonPhong (maKH , tenKH ,cmtKH,gioiTinhKH,sdtKH,diaChi,ngaySinhKH,soNguoi,tenNV, maPhieuThuePhong ,maPhong,hinhThucThue,donGiaPhong,checkIn,loaiPhong,dukienCheckOut,duaTruoc,phuThu,tienDichVu, tongTienKHTra, tienTheoGio, tongTienPhong, maHoaDonPhong, thoiGianTao, nguoiTao, ghiChu, thoiGianRa, thoiGianSudung) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pst = con.prepareStatement(sql);

         pst.setString(1, t.getMaKH());
            pst.setString(2, t.getTenKH());
            pst.setString(3, t.getCmtKH());
            pst.setBoolean(4, t.isGioiTinhKH());
            pst.setString(5, t.getSdtKH());
            pst.setString(6, t.getDiaChi());
            pst.setString(7, t.getNgaySinhKH());
            pst.setInt(8, t.getSoNguoi());

            pst.setString(9, t.getTenNV());
            pst.setString(10, t.getMaPhieuThuePhong());
            pst.setString(11, t.getMaPhong());
            pst.setBoolean(12, t.isHinhThucThue());
            pst.setDouble(13, t.getDonGiaPhong());
            pst.setTimestamp(14, t.getCheckIn());
            pst.setString(15, t.getLoaiPhong());
            pst.setString(16, t.getDuKienCheckOut());
        
            
              pst.setDouble(17, t.getDuaTruoc());
            pst.setDouble(18, t.getPhuThu());
        
        
        
        pst.setDouble(19, t.getTienDichVu());
        pst.setDouble(20, t.getTongTienKHTra());
        pst.setDouble(21, t.getTienTheoGio());
        pst.setDouble(22, t.getTongTienPhong());
        pst.setString(23, t.getMaHoaDonPhong());
        pst.setTimestamp(24, t.getThoiGianTao());
        pst.setString(25, t.getNguoiTao());
        pst.setString(26, t.getGhiChu());
        pst.setTimestamp(27, t.getCheckOut());
        pst.setString(28, t.getThoiGianSuDung());
        

        ketQua = pst.executeUpdate();
        JDBCUtil.closeConnection(con);
    } catch (Exception e) {
        e.printStackTrace();
        // Xử lý lỗi, ví dụ: thông báo cho người dùng hoặc ghi log
    }
    return ketQua;
}
    
    public Map<LocalDate, Double> thongKeDoanhSoTheoThangPhong(LocalDate from, LocalDate to) {
    Map<LocalDate, Double> maps = new HashMap<>();
    String sql = "SELECT YEAR(hpd.thoiGianTao) AS year, MONTH(hpd.thoiGianTao) AS month, SUM(hpd.tongTienPhong) AS sales " +
                 "FROM hoadonphong hpd " +
                 "WHERE hpd.thoiGianTao BETWEEN ? AND ? " +
                 "GROUP BY YEAR(hpd.thoiGianTao), MONTH(hpd.thoiGianTao)";

    try (Connection con = JDBCUtil.getConnection();
         PreparedStatement pst = con.prepareStatement(sql)) {

        // Thiết lập giá trị cho các tham số truy vấn
        Timestamp fromTimestamp = Timestamp.valueOf(from.atStartOfDay());
        Timestamp toTimestamp = Timestamp.valueOf(to.atTime(LocalTime.MAX));
        pst.setTimestamp(1, fromTimestamp);
        pst.setTimestamp(2, toTimestamp);

        // In ra truy vấn và tham số để kiểm tra
        System.out.println("Executing query: " + sql);
        System.out.println("From: " + fromTimestamp + ", To: " + toTimestamp);

        try (ResultSet rs = pst.executeQuery()) {
            // Kiểm tra nếu ResultSet có dữ liệu
            if (!rs.isBeforeFirst()) {
                System.out.println("No data found for the given date range.");
            }

            while (rs.next()) {
                int year = rs.getInt("year");
                int month = rs.getInt("month");
                double sales = rs.getDouble("sales");

                // Tạo YearMonth từ year và month
                YearMonth yearMonth = YearMonth.of(year, month);
                // Thêm vào map với key là ngày đầu tiên của tháng
                maps.put(yearMonth.atDay(1), sales);

                System.out.println("Year: " + year + ", Month: " + month + ", Sales: " + sales);
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
        return maps;
    
}


    public Map<LocalDate, Double> thongKeSoLuongTheoThangPhong(LocalDate from, LocalDate to) {
    Map<LocalDate, Double> maps = new HashMap<>();
    String sql = "SELECT YEAR(hdp.thoiGianTao) AS year, MONTH(hdp.thoiGianTao) AS month, COUNT(hdp.maHoaDonPhong) AS SoLuong " +
                 "FROM hoadonphong hdp " +
                 "WHERE hdp.thoiGianTao BETWEEN ? AND ? " +
                 "GROUP BY YEAR(hdp.thoiGianTao), MONTH(hdp.thoiGianTao)";

    try (Connection con = JDBCUtil.getConnection();
         PreparedStatement pst = con.prepareStatement(sql)) {

        // Thiết lập giá trị cho các tham số truy vấn
        Timestamp fromTimestamp = Timestamp.valueOf(from.atStartOfDay());
        Timestamp toTimestamp = Timestamp.valueOf(to.atTime(LocalTime.MAX));
        pst.setTimestamp(1, fromTimestamp);
        pst.setTimestamp(2, toTimestamp);

        // In ra truy vấn và tham số để kiểm tra
        System.out.println("Executing query: " + sql);
        System.out.println("From: " + fromTimestamp + ", To: " + toTimestamp);

        try (ResultSet rs = pst.executeQuery()) {
            // Kiểm tra nếu ResultSet có dữ liệu
            if (!rs.isBeforeFirst()) {
                System.out.println("No data found for the given date range.");
            }

            while (rs.next()) {
                int year = rs.getInt("year");
                int month = rs.getInt("month");
                double quantity = rs.getDouble("SoLuong");

                // Tạo YearMonth từ year và month
                YearMonth yearMonth = YearMonth.of(year, month);
                // Thêm vào map với key là ngày đầu tiên của tháng
                maps.put(yearMonth.atDay(1), quantity);

                System.out.println("Year: " + year + ", Month: " + month + ", SoLuong: " + quantity);
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return maps;
}
    @Override
    public int update(HoaDonPhong t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(HoaDonPhong t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override

    public ArrayList<HoaDonPhong> selectAll() {
       ArrayList<HoaDonPhong> list = new ArrayList<>();
    try {
        Connection con = JDBCUtil.getConnection();
        String sql = "SELECT * FROM HoaDonPhong";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            HoaDonPhong hoaDonPhong = new HoaDonPhong();
            
             hoaDonPhong.setMaKH(rs.getString("maKH"));
            hoaDonPhong.setTenKH(rs.getString("tenKH"));
             hoaDonPhong.setCmtKH(rs.getString("cmtKH"));
             
              hoaDonPhong.setNgaySinhKH(rs.getString("ngaySinhKH"));
             hoaDonPhong.setSoNguoi(rs.getInt("soNguoi"));
             hoaDonPhong.setDuKienCheckOut(rs.getString("dukienCheckOut"));
            
              hoaDonPhong.setGioiTinhKH(rs.getBoolean("gioiTinhKH"));
                hoaDonPhong.setDiaChi(rs.getString("diaChi"));
                hoaDonPhong.setSdtKH(rs.getString("sdtKH"));
                
                hoaDonPhong.setMaPhong(rs.getString("maPhong"));
                hoaDonPhong.setCheckIn(rs.getTimestamp("checkIn"));
                hoaDonPhong.setLoaiPhong(rs.getString("loaiPhong"));
            
                 
                hoaDonPhong.setMaPhieuThuePhong(rs.getString("maPhieuThuePhong"));
                hoaDonPhong.setCheckOut(rs.getTimestamp("thoiGianRa"));
                hoaDonPhong.setHinhThucThue(rs.getBoolean("hinhThucThue"));
                
                
                
                
                hoaDonPhong.setMaHoaDonPhong(rs.getString("maHoaDonPhong"));
                 hoaDonPhong.setThoiGianSuDung(rs.getString("thoiGianSudung"));
                hoaDonPhong.setTenNV(rs.getString("tenNV"));
                hoaDonPhong.setNguoiTao(rs.getString("nguoiTao"));
                hoaDonPhong.setDonGiaPhong(rs.getDouble("donGiaPhong"));
                
                
            hoaDonPhong.setPhuThu(rs.getDouble("phuThu"));
            hoaDonPhong.setDuaTruoc(rs.getDouble("duaTruoc"));
                hoaDonPhong.setTienDichVu(rs.getDouble("tienDichVu"));
                hoaDonPhong.setTienTheoGio(rs.getDouble("tienTheoGio"));
                
            hoaDonPhong.setGhiChu(rs.getString("ghiChu"));
           
            
            hoaDonPhong.setTongTienPhong(rs.getDouble("tongTienPhong"));
            hoaDonPhong.setTongTienKHTra(rs.getDouble("tongTienKHTra"));
            
            //HoaDonPhong list = new HoaDonPhong(maKH,tenKH,cmtKH,ngaySinhKH,soNguoi,dukienCheckOut,gioiTinhKH,diaChi,sdtKH,maPhong,checkIn,loaiPhong,maPhieuThuePhong,thoiGianRa,hinhThucThue);
            
            
            list.add(hoaDonPhong);
        }
        JDBCUtil.closeConnection(con);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list;
    }
    
    public ArrayList<HoaDonPhong> selectAll1() {
       ArrayList<HoaDonPhong> list = new ArrayList<>();
    try {
        Connection con = JDBCUtil.getConnection();
        String sql = "SELECT * FROM HoaDonPhong";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            String maKH = rs.getString("maKH");
            String tenKH = rs.getString("tenKH");
            String cmtKH = rs.getString("cmtKH");
            boolean gioiTinhKH = rs.getBoolean("gioiTinhKH");
            String sdtKH = rs.getString("sdtKH");
            String diaChi = rs.getString("diaChi");
            String ngaySinhKH = rs.getString("ngaySinhKH");
            int soNguoi = rs.getInt("soNguoi");
            String tenNV = rs.getString("tenNV");
            String maPhieuThuePhong = rs.getString("maPhieuThuePhong");
            String maPhong = rs.getString("maPhong");
            boolean hinhThucThue = rs.getBoolean("hinhThucThue");
            double donGiaPhong = rs.getDouble("donGiaPhong");
            Timestamp checkIn = rs.getTimestamp("checkIn");

            String loaiPhong = rs.getString("loaiPhong");
            String duKienCheckOut = rs.getString("duKienCheckOut");

            double duaTruoc = rs.getDouble("duaTruoc");
            double phuThu = rs.getDouble("phuThu");

            double tienDichVu = rs.getDouble("tienDichVu");

            double tongTienKHTra = rs.getDouble("tongTienKHTra");

            double tienTheoGio = rs.getDouble("tienTheoGio");

            double tongTienPhong = rs.getDouble("tongTienPhong");

            String maHoaDonPhong = rs.getString("maHoaDonPhong");
            Timestamp thoiGianTao = rs.getTimestamp("thoiGianTao");
            String nguoiTao = rs.getString("nguoiTao");
           

            Timestamp checkOut = rs.getTimestamp("thoiGianRa");
            String ghiChu = rs.getString("ghiChu");
            Timestamp thoiGianSudung = rs.getTimestamp("thoiGianSudung");
            
            
            HoaDonPhong ctp = new HoaDonPhong(maKH, tenKH, cmtKH, gioiTinhKH, sdtKH, diaChi, ngaySinhKH, soNguoi, tenNV, maPhieuThuePhong, maPhong, hinhThucThue, donGiaPhong, checkIn,  loaiPhong, duKienCheckOut, duaTruoc, phuThu,tienDichVu,tongTienKHTra,tienTheoGio,tongTienPhong,maHoaDonPhong,thoiGianTao,nguoiTao,checkOut,thoiGianSudung,ghiChu);
               
            
            list.add(ctp);
                                                       
        }
        JDBCUtil.closeConnection(con);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list;
    }

    @Override
public HoaDonPhong selectById(String maHoaDonPhong) {
    HoaDonPhong hoaDonPhong = null;
    try {
        Connection con = JDBCUtil.getConnection();
        String sql = "SELECT * FROM HoaDonPhong WHERE maHoaDonPhong = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, maHoaDonPhong);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            String maKH = rs.getString("maKH");
            String tenKH = rs.getString("tenKH");
            String cmtKH = rs.getString("cmtKH");
            boolean gioiTinhKH = rs.getBoolean("gioiTinhKH");
            String sdtKH = rs.getString("sdtKH");
            String diaChi = rs.getString("diaChi");
            String ngaySinhKH = rs.getString("ngaySinhKH");
            int soNguoi = rs.getInt("soNguoi");
            String tenNV = rs.getString("tenNV");
            String maPhieuThuePhong = rs.getString("maPhieuThuePhong");
            String maPhong = rs.getString("maPhong");
            boolean hinhThucThue = rs.getBoolean("hinhThucThue");
            double donGiaPhong = rs.getDouble("donGiaPhong");
            Timestamp checkIn = rs.getTimestamp("checkIn");
            String loaiPhong = rs.getString("loaiPhong");
            String duKienCheckOut = rs.getString("duKienCheckOut");
            double duaTruoc = rs.getDouble("duaTruoc");
            double phuThu = rs.getDouble("phuThu");
            double tienDichVu = rs.getDouble("tienDichVu");
            double tongTienKHTra = rs.getDouble("tongTienKHTra");
            double tienTheoGio = rs.getDouble("tienTheoGio");
            double tongTienPhong = rs.getDouble("tongTienPhong");
            Timestamp thoiGianTao = rs.getTimestamp("thoiGianTao");
            String nguoiTao = rs.getString("nguoiTao");
            Timestamp checkOut = rs.getTimestamp("thoiGianRa");
            String ghiChu = rs.getString("ghiChu");
            Timestamp thoiGianSudung = rs.getTimestamp("thoiGianSudung");
            
            hoaDonPhong = new HoaDonPhong(maKH, tenKH, cmtKH, gioiTinhKH, sdtKH, diaChi, ngaySinhKH, soNguoi, tenNV, maPhieuThuePhong, maPhong, hinhThucThue, donGiaPhong, checkIn,  loaiPhong, duKienCheckOut, duaTruoc, phuThu,tienDichVu,tongTienKHTra,tienTheoGio,tongTienPhong,maHoaDonPhong,thoiGianTao,nguoiTao,checkOut,thoiGianSudung,ghiChu);
        }
        JDBCUtil.closeConnection(con);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return hoaDonPhong;
}
    
    
  
}
 
