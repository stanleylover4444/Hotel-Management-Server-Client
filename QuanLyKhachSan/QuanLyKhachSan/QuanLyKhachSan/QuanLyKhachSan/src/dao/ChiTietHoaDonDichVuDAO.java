/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.ChiTietHoaDonDichVu;

/**
 *
 * @author ASUS
 */
public class ChiTietHoaDonDichVuDAO implements DAOInterface<ChiTietHoaDonDichVu> {

    public static ChiTietHoaDonDichVuDAO getInstance() {
        return new ChiTietHoaDonDichVuDAO();
    }

    
    public int insertMany(String maHoaDonPhong, ArrayList<ChiTietHoaDonDichVu> ts) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO ChiTietHoaDonDichVu (maHoaDon, maDichVu, soLuong, donGia) VALUES (?,?,?,?)";
             PreparedStatement pst = con.prepareStatement(sql);
            for(ChiTietHoaDonDichVu t : ts) {
                 pst.setString(1, maHoaDonPhong);
                pst.setString(2, t.getMaDichvu());
                pst.setInt(3, t.getSoLuong());
                pst.setDouble(4, t.getDonGia());
                pst.addBatch();
            }
            
           
           pst.executeBatch();
            JDBCUtil.closeConnection(con);
           return 1;
           
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }
    
    
    
    
    
    

    @Override
    public int update(ChiTietHoaDonDichVu t) {
       
        return 0;
       
    }

    @Override
    public int delete(ChiTietHoaDonDichVu t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   public ArrayList<ChiTietHoaDonDichVu> selectAll(String maHoaDon) {
    ArrayList<ChiTietHoaDonDichVu> ketQua = new ArrayList<ChiTietHoaDonDichVu>();
    try {
        Connection con = JDBCUtil.getConnection();
        String sql = "SELECT dv.tenDichVu, cthddichvu.soLuong, cthddichvu.donGia " +
                     "FROM chitiethoadondichvu cthddichvu " +
                     "LEFT JOIN dichvu dv ON dv.maDichVu = cthddichvu.maDichVu " +
                     "WHERE cthddichvu.maHoaDon = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, maHoaDon);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            String tenDichVu = rs.getString("dv.tenDichVu");
            int soLuong = rs.getInt("cthddichvu.soLuong");
            double donGiaDV = rs.getDouble("cthddichvu.donGia");
            ChiTietHoaDonDichVu ctp = new ChiTietHoaDonDichVu(tenDichVu, soLuong, donGiaDV);
            ketQua.add(ctp);
        }
      // Đóng kết nối, câu lệnh và tập kết quả
    } catch (Exception e) {
        e.printStackTrace();
    }
    return ketQua;
}
public void updateByMaHoaDon(String maHoaDon, ArrayList<ChiTietHoaDonDichVu> danhSachCapNhat) {
    try {
        Connection con = JDBCUtil.getConnection();
        // Xóa các chi tiết hóa đơn cũ dựa trên mã hóa đơn
        String deleteSql = "DELETE FROM chitiethoadondichvu WHERE maHoaDon = ?";
        PreparedStatement deletePst = con.prepareStatement(deleteSql);
        deletePst.setString(1, maHoaDon);
        deletePst.executeUpdate();
        
        // Thêm các chi tiết hóa đơn mới
        String insertSql = "INSERT INTO chitiethoadondichvu (maHoaDon, maDichVu, soLuong, donGia) VALUES (?, ?, ?, ?)";
        PreparedStatement insertPst = con.prepareStatement(insertSql);
        for (ChiTietHoaDonDichVu ctp : danhSachCapNhat) {
            insertPst.setString(1, maHoaDon);
            insertPst.setString(2, ctp.getMaDichvu());
            insertPst.setInt(3, ctp.getSoLuong());
            insertPst.setDouble(4, ctp.getDonGia());
            insertPst.executeUpdate();
        }
        
        // Đóng kết nối và câu lệnh
        insertPst.close();
        deletePst.close();
        con.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}


    @Override
    public ArrayList<ChiTietHoaDonDichVu> selectAll() {
        ArrayList<ChiTietHoaDonDichVu> ketQua = new ArrayList<ChiTietHoaDonDichVu>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM ChiTietHoaDonDichVu";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String maHoaDon = rs.getString("maHoaDon");
                String maDichVu = rs.getString("maDichVu");
                int soLuong = rs.getInt("soLuong");
                double donGia = rs.getDouble("donGia");
                ChiTietHoaDonDichVu ctp = new ChiTietHoaDonDichVu(maHoaDon, maDichVu, soLuong, donGia);
                ketQua.add(ctp);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    
 
    
    
    @Override
    public ChiTietHoaDonDichVu selectById(String maHoaDon1) {
        ChiTietHoaDonDichVu ketQua = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM ChiTietHoaDonDichVu WHERE maHoaDon=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, maHoaDon1);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String maHoaDon = rs.getString("maHoaDon");
                String maDichVu = rs.getString("maDichVu");
                int soLuong = rs.getInt("soLuong");
                double donGia = rs.getDouble("donGia");
                ketQua = new ChiTietHoaDonDichVu(maHoaDon, maDichVu, soLuong, donGia);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }
    
    

    public ChiTietHoaDonDichVu selectById1(String maPhieuThue) {
        ChiTietHoaDonDichVu ketQua = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM ChiTietHoaDonDichVu WHERE maHoaDon=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, maPhieuThue);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String maHoaDon = rs.getString("maHoaDon");
                String maDichVu = rs.getString("maDichVu");
                int soLuong = rs.getInt("soLuong");
                double donGia = rs.getDouble("donGia");
                ketQua = new ChiTietHoaDonDichVu(maHoaDon, maDichVu, soLuong, donGia);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int insert(ChiTietHoaDonDichVu t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO ChiTietHoaDonDichVu (maHoaDon, maDichVu, soLuong, donGia) VALUES (?,?,?,?)";
             PreparedStatement pst = con.prepareStatement(sql);
             pst.setString(1, t.getMaHoaDon());
                pst.setString(2, t.getMaDichvu());
                pst.setInt(3, t.getSoLuong());
                pst.setDouble(4, t.getDonGia());
                pst.addBatch();
           
           return pst.executeUpdate();
           
           
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    
    
    public ArrayList<ChiTietHoaDonDichVu> selectAll1(String MaHoaDonPhong) {
    ArrayList<ChiTietHoaDonDichVu> ketQua = new ArrayList<ChiTietHoaDonDichVu>();
    try {
        Connection con = JDBCUtil.getConnection();
        String sql = "SELECT cthddichvu.maHoaDon, dv.tenDichVu, cthddichvu.soLuong, cthddichvu.donGia " +
                     "FROM quanlikhachsan.chitiethoadonphong cthdphong " +
                     "LEFT JOIN chitiethoadondichvu cthddichvu ON cthdphong.maPhieuThuePhong = cthddichvu.maHoaDon " +
                     "LEFT JOIN dichvu dv ON dv.maDichVu = cthddichvu.maDichVu " +
                     "WHERE cthddichvu.maHoaDon = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, MaHoaDonPhong);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            String maDichVu = rs.getString("dv.tenDichVu");
            int soLuong = rs.getInt("cthddichvu.soLuong");
            double donGiaDV = rs.getDouble("cthddichvu.donGia");
            ChiTietHoaDonDichVu ctp = new ChiTietHoaDonDichVu(maDichVu, soLuong, donGiaDV);
            ketQua.add(ctp);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return ketQua;
}
    

 
}
