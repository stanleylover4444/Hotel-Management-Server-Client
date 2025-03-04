/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.JDBCUtil;
import javax.swing.JOptionPane;
import model.TaiKhoan;

public class TaiKhoanDAO implements DAOInterface<TaiKhoan> {

    public static TaiKhoanDAO getInstance() {
        return new TaiKhoanDAO();
    }

    @Override
    public int insert(TaiKhoan t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO TaiKhoan (tenNV, taiKhoan, matKhau, vaiTro, trangThai, SDT) VALUES (?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getTenNV());
            pst.setString(2, t.getTaiKhoan());
            pst.setString(3, t.getMatKhau());
            pst.setString(4, t.getVaiTro());
            pst.setInt(5, t.getTrangThai());
            pst.setString(6, t.getSDT());
            //Buoc 4 thuc thi cau lenh sql
            ketQua = pst.executeUpdate();
            //Buoc 5 Xu ly
            //Buoc 6 ngat ket noi den voi co so du lieu
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
   public int update(TaiKhoan t) {
    int ketQua = 0;
    try {
         Connection con = JDBCUtil.getConnection();
        String sql = "UPDATE taikhoan SET tenNV=?, vaiTro=?, trangThai=?, SDT=? WHERE taiKhoan=?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, t.getTenNV());
        pst.setString(2, t.getVaiTro());
        pst.setInt(3, t.getTrangThai());
        pst.setString(4, t.getSDT());
        pst.setString(5, t.getTaiKhoan());

        ketQua = pst.executeUpdate();
        JDBCUtil.closeConnection(con);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return ketQua;
}


    @Override
    public int delete(TaiKhoan t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM taikhoan WHERE taiKhoan=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getTaiKhoan());
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<TaiKhoan> selectAll() {
        ArrayList<TaiKhoan> ketQua = new ArrayList<TaiKhoan>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM TaiKhoan";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
               
   
                String tenNV = rs.getString("tenNV");
                String taiKhoan = rs.getString("taiKhoan");
                String matKhau = rs.getString("matKhau");
                String vaiTro = rs.getString("vaiTro");
                int trangThai = rs.getInt("trangThai");
                String SDT = rs.getString("SDT");

                TaiKhoan acc = new TaiKhoan(tenNV, taiKhoan, matKhau, vaiTro, trangThai,SDT);
                ketQua.add(acc);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public TaiKhoan selectById(String t) {
        TaiKhoan acc = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM taikhoan WHERE taiKhoan=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String tenNV = rs.getString("tenNV");
                String taiKhoan = rs.getString("taiKhoan");
                String matKhau = rs.getString("matKhau");
                String vaiTro = rs.getString("vaiTro");
                int trangThai = rs.getInt("trangThai");
                String SDT = rs.getString("SDT");
                acc = new TaiKhoan(tenNV, taiKhoan, matKhau, vaiTro, trangThai,SDT);
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception           
        }
        return acc;
    }
    
        public int updatePassword(String SDT, String matKhau) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE TaiKhoan SET matKhau=? WHERE SDT=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, matKhau);
            pst.setString(2, SDT);

            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }
}
