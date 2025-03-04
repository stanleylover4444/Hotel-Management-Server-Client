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
import java.util.Set;
import model.HoaDonDichVu;

/**
 *
 * @author DELL
 */
public class HoaDonDichVuDAO implements DAOInterface<HoaDonDichVu> {

    public static HoaDonDichVuDAO getInstance() {
        return new HoaDonDichVuDAO();
    }

    @Override
    public int insert(HoaDonDichVu t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO HoaDonDichVu (maHoaDon, thoiGianTao, nguoiTao, tongTien) VALUES (?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getMaHoaDon());
            pst.setTimestamp(2, t.getThoiGianTao());
            pst.setString(3, t.getNguoiTao());
            pst.setDouble(4, t.getTongTien());
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }
    
    
public Map<LocalDate, Double> thongKeDoanhSoTheoThang(LocalDate from, LocalDate to) {
    Map<LocalDate, Double> maps = new HashMap<>();
    String sql = "SELECT YEAR(hddv.thoiGianTao) AS year, MONTH(hddv.thoiGianTao) AS month, SUM(hddv.tongTien) AS sales " +
                 "FROM hoadondichvu hddv " +
                 "WHERE hddv.thoiGianTao BETWEEN ? AND ? " +
                 "GROUP BY YEAR(hddv.thoiGianTao), MONTH(hddv.thoiGianTao)";

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
public Map<LocalDate, Double> thongKeSoLuongTheoThang(LocalDate from, LocalDate to) {
    Map<LocalDate, Double> maps = new HashMap<>();
    String sql = "SELECT YEAR(hddv.thoiGianTao) AS year, MONTH(hddv.thoiGianTao) AS month, COUNT(hddv.maHoaDon) AS SoLuong " +
                 "FROM hoadondichvu hddv " +
                 "WHERE hddv.thoiGianTao BETWEEN ? AND ? " +
                 "GROUP BY YEAR(hddv.thoiGianTao), MONTH(hddv.thoiGianTao)";

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
    public int update(HoaDonDichVu t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE HoaDonDichVu SET maHoaDon=?, thoiGianTao=?, nguoiTao=?, tongTien = ? WHERE maHoaDon=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getMaHoaDon());
            pst.setTimestamp(2, t.getThoiGianTao());
            pst.setString(3, t.getNguoiTao());
            pst.setDouble(4, t.getTongTien());
            pst.setString(5, t.getMaHoaDon());
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int delete(HoaDonDichVu t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<HoaDonDichVu> selectAll() {
        ArrayList<HoaDonDichVu> ketQua = new ArrayList<HoaDonDichVu>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM HoaDonDichVu ORDER BY thoiGianTao DESC";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String maHoaDon = rs.getString("maHoaDon");
                Timestamp thoiGianTao = rs.getTimestamp("thoiGianTao");
                String nguoiTao = rs.getString("nguoiTao");
                double tongTien = rs.getDouble("tongTien");
                HoaDonDichVu p = new HoaDonDichVu(maHoaDon, thoiGianTao, nguoiTao, ChiTietHoaDonDichVuDAO.getInstance().selectAll(maHoaDon), tongTien);
                ketQua.add(p);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public HoaDonDichVu selectById(String t) {
        HoaDonDichVu ketQua = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM HoaDonDichVu WHERE maHoaDon=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String maHoaDon = rs.getString("maHoaDon");
                Timestamp thoiGianTao = rs.getTimestamp("thoiGianTao");
                String nguoiTao = rs.getString("nguoiTao");
                double tongTien = rs.getDouble("tongTien");
                ketQua = new HoaDonDichVu(maHoaDon, thoiGianTao, nguoiTao, ChiTietHoaDonDichVuDAO.getInstance().selectAll(maHoaDon), tongTien);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;

    }

}



