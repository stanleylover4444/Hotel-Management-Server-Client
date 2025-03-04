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
import java.util.ArrayList;
import model.ChiTietHoaDonDichVu;
import model.ChiTietHoaDonPhong;
import static org.apache.commons.math3.stat.inference.TestUtils.t;

/**
 *
 * @author ASUS
 */
public class ChiTietHoaDonPhongDAO implements DAOInterface<ChiTietHoaDonPhong> {

   public static ChiTietHoaDonPhongDAO getInstance() {
        return new ChiTietHoaDonPhongDAO();
    }

    @Override
    public int insert(ChiTietHoaDonPhong t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO ChiTietHoaDonPhong ( maKH , tenKH ,cmtKH,gioiTinhKH,sdtKH,diaChi,ngaySinhKH,soNguoi,tenNV, maPhieuThuePhong ,maPhong,hinhThucThue,donGiaPhong,checkIn,loaiPhong,dukienCheckOut,duaTruoc,phuThu,trangThaiPhieu) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
            
           pst.setBoolean(19, false); // Set 'Chưa Thanh Toán'

            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
            
          
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int update(ChiTietHoaDonPhong t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    public int delete(String maPhieuThuePhong) {
 int ketQua = 0;
     
         
        try (Connection con = JDBCUtil.getConnection()) {
            String sql = "DELETE FROM ChiTietHoaDonPhong WHERE maPhieuThuePhong=?";
            try (PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setString(1, maPhieuThuePhong);
                ketQua = pst.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua   ;
    }
 public int updateTrangThaiPhieu(String maPhieuThuePhong, String trangThaiPhieu) {
        int ketQua = 0;
        try {
           Connection con = JDBCUtil.getConnection();
        String sql = "UPDATE ChiTietHoaDonPhong SET trangThaiPhieu=? WHERE maPhieuThuePhong=?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, trangThaiPhieu);
        pst.setString(2, maPhieuThuePhong);
        ketQua = pst.executeUpdate();
        // Gọi lại phương thức loadDataToTablePhong để làm mới lại dữ liệu trên bảng
       
        JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
    public ArrayList<ChiTietHoaDonPhong> selectAll(String t) {
        ArrayList<ChiTietHoaDonPhong> ketQua = new ArrayList<ChiTietHoaDonPhong>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM ChiTietHoaDonPhong WHERE maHoaDonPhong=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String maHoaDon = rs.getString("maHoaDon");

                String maKH = rs.getString("maKH");
                String tenKH = rs.getString("tenKH");
                String cmtKH = rs.getString("cmtKH");
                boolean gioiTinhKH = rs.getBoolean("gioiTinhKH");
                String sdtKH = rs.getString("sdtKH");
                String diaChi = rs.getString("diaChi");
                String ngaySinhKH = rs.getString("ngaySinhKH");
                int soNguoi = rs.getInt("soNguoi");
                String tenNV = rs.getString("tenNV");
                String maHoaDonPhong = rs.getString("maPhieuThuePhong");
                String maPhong = rs.getString("maPhong");
                boolean hinhThucThue = rs.getBoolean("hinhThucThue");
                double donGiaPhong = rs.getDouble("donGiaPhong");
                Timestamp checkIn = rs.getTimestamp("checkIn");

                String loaiPhong = rs.getString("loaiPhong");
                String duKienCheckOut = rs.getString("dukienCheckOut");
                
                
//                String maDichvu = rs.getString("maDichVu");
//                int soLuong = rs.getInt("soLuong");
//                double donGia = rs.getDouble("donGia");
//                double tongtienDV = rs.getDouble("tongtienDV");

                double duaTruoc = rs.getDouble("duaTruoc");
                double phuThu = rs.getDouble("phuThu");

                
                 boolean trangThaiPhieu = rs.getBoolean("trangThaiPhieu");
                
                ChiTietHoaDonPhong ctp = new ChiTietHoaDonPhong(maKH, tenKH, cmtKH, gioiTinhKH, sdtKH, diaChi, ngaySinhKH, soNguoi, tenNV, maHoaDonPhong, maPhong, hinhThucThue, donGiaPhong, checkIn, loaiPhong, duKienCheckOut, duaTruoc, phuThu, trangThaiPhieu);
                ketQua.add(ctp);
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {

            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ChiTietHoaDonPhong selectById(String t) {
        ChiTietHoaDonPhong ketQua = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM ChiTietHoaDonPhong WHERE maHoaDon=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String maHoaDon = rs.getString("maHoaDon");

                String maKH = rs.getString("maKH");
                String tenKH = rs.getString("tenKH");
                String cmtKH = rs.getString("cmtKH");
                boolean gioiTinhKH = rs.getBoolean("gioiTinhKH");
                String sdtKH = rs.getString("sdtKH");
                String diaChi = rs.getString("diaChi");
                String ngaySinhKH = rs.getString("ngaySinhKH");
                int soNguoi = rs.getInt("soNguoi");
                String tenNV = rs.getString("tenNV");
                String maHoaDonPhong = rs.getString("maPhieuThuePhong");
                String maPhong = rs.getString("maPhong");
                boolean hinhThucThue = rs.getBoolean("hinhThucThue");
                double donGiaPhong = rs.getDouble("donGiaPhong");
                Timestamp checkIn = rs.getTimestamp("checkIn");

                String loaiPhong = rs.getString("loaiPhong");
                String  duKienCheckOut = rs.getString("duKienCheckOut");



                double duaTruoc = rs.getDouble("duaTruoc");
                double phuThu = rs.getDouble("phuThu");
                
                  boolean trangThaiPhieu = rs.getBoolean("trangThaiPhieu");

                ketQua = new ChiTietHoaDonPhong(maKH, tenKH, cmtKH, gioiTinhKH, sdtKH, diaChi, ngaySinhKH, soNguoi, tenNV, maHoaDonPhong, maPhong, hinhThucThue, donGiaPhong, checkIn, loaiPhong, duKienCheckOut, duaTruoc, phuThu,trangThaiPhieu);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }
    
      
  

    
    
  


    @Override
    public ArrayList<ChiTietHoaDonPhong> selectAll() {
        ArrayList<ChiTietHoaDonPhong> ketQua = new ArrayList<ChiTietHoaDonPhong>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM ChiTietHoaDonPhong";
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
                String maHoaDonPhong = rs.getString("maPhieuThuePhong");
                String maPhong = rs.getString("maPhong");
                boolean hinhThucThue = rs.getBoolean("hinhThucThue");
                double donGiaPhong = rs.getDouble("donGiaPhong");
                Timestamp checkIn = rs.getTimestamp("checkIn");

                String loaiPhong = rs.getString("loaiPhong");
                String duKienCheckOut = rs.getString("duKienCheckOut");



                double duaTruoc = rs.getDouble("duaTruoc");
                double phuThu = rs.getDouble("phuThu");

                
                boolean trangThaiPhieu = rs.getBoolean("trangThaiPhieu");
                
                ChiTietHoaDonPhong ctp = new ChiTietHoaDonPhong(maKH, tenKH, cmtKH, gioiTinhKH, sdtKH, diaChi, ngaySinhKH, soNguoi, tenNV, maHoaDonPhong, maPhong, hinhThucThue, donGiaPhong, checkIn, loaiPhong, duKienCheckOut, duaTruoc, phuThu,trangThaiPhieu);
                ketQua.add(ctp);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }
    
    
    
    
    
   
    
    

    public String findByMaPhong(String maPhong) {
        String trangThai = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM ChiTietHoaDonPhong WHERE maPhong = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, maPhong);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                trangThai = rs.getString("tinhTrangPhong");
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return trangThai;
    }

    public int updateMaPhong(String maPhong, ChiTietHoaDonPhong chiTietPhong) {
        int rowsAffected = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE ChiTietHoaDonPhong SET maPhong = ? WHERE maPhong = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, chiTietPhong.getMaPhong());
            pst.setString(2, maPhong);

            rowsAffected = pst.executeUpdate();

            JDBCUtil.closeConnection(con);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return rowsAffected;
    }



    @Override
    public int delete(ChiTietHoaDonPhong t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
    

 
}
