/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.sun.jdi.connect.spi.Connection;
import database.JDBCUtil;
import java.sql.Date;
import java.util.ArrayList;
import model.KhachHang;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import model.Phong;

public class KhachHangDAO implements DAOInterface<KhachHang> {

    public static KhachHangDAO getInstance() {
        return new KhachHangDAO();
    }

    private boolean gioiTinh;

    @Override
    public int insert(KhachHang t) {
        int ketQua = 0;
        try {
            java.sql.Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO KhachHang (maKhachHang, tenKhachHang, soDienThoai, chungMinhThu, ngaySinh ,diaChi,gioiTinh ) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, t.getMaKhachHang());
            pst.setString(2, t.getTenKhachHang());
            pst.setString(3, t.getSoDienThoai());
            pst.setString(4, t.getChungMinhThu());
            pst.setString(5, t.getNgaySinh());
            pst.setString(6, t.getDiaChi());
            pst.setBoolean(7, t.isGioiTinh());

            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "Không thêm được khách hàng " + t.getMaKhachHang(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int update(KhachHang t) {
        int ketQua = 0;
        try {
            java.sql.Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE KhachHang SET tenKhachHang=?, soDienThoai=?, chungMinhThu=?, ngaySinh=? , diaChi=?, gioiTinh=? WHERE maKhachHang=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getTenKhachHang());
            pst.setString(2, t.getSoDienThoai());
            pst.setString(3, t.getChungMinhThu());
             pst.setString(4, t.getNgaySinh());
            pst.setString(5, t.getDiaChi());
            pst.setBoolean(6, t.isGioiTinh());
            pst.setString(7, t.getMaKhachHang());
            ketQua = pst.executeUpdate();
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;

    }

    @Override
    public ArrayList<KhachHang> selectAll() {
        ArrayList<KhachHang> ketQua = new ArrayList<KhachHang>();
        try {
            java.sql.Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM KhachHang";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String maKhachHang = rs.getString("maKhachHang");
                String tenKhachHang = rs.getString("tenKhachHang");
                String soDienThoai = rs.getString("soDienThoai");
                String chungMinhThu = rs.getString("chungMinhThu");
                String ngaySinh = rs.getString("ngaySinh");
                String diaChi = rs.getString("diaChi");
                boolean gioiTinh = rs.getBoolean("gioiTinh");
                KhachHang ncc = new KhachHang(maKhachHang, tenKhachHang, soDienThoai, chungMinhThu, ngaySinh, diaChi, gioiTinh);
                ketQua.add(ncc);
            }

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public KhachHang selectById(String t) {
        KhachHang ketQua = null;
        try {
            java.sql.Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM khachhang WHERE maKhachHang=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String maKhachHang = rs.getString("maKhachHang");
                String tenKhachHang = rs.getString("tenKhachHang");
                String soDienThoai = rs.getString("soDienThoai");
                String chungMinhThu = rs.getString("chungMinhThu");
                String ngaySinh = rs.getString("ngaySinh");
                String diaChi = rs.getString("diaChi");
                boolean gioiTinh = rs.getBoolean("gioiTinh");
                ketQua = new KhachHang(maKhachHang, tenKhachHang, soDienThoai, chungMinhThu, ngaySinh, diaChi, gioiTinh);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int delete(KhachHang t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
