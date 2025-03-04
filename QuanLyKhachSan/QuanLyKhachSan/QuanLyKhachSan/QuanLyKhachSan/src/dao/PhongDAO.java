/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.DichVu;
import model.Phong;
import view.QuanLiPhongForm;

/**
 *
 * @author ASUS
 */
public class PhongDAO implements DAOInterface<Phong>{
    
      public static PhongDAO getInstance() {
        return new PhongDAO();
    }

    @Override
    public int insert(Phong t) {
          int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO Phong (maMaPhong, tinhTrangPhong) VALUES (?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getMaPhong());
            pst.setString(2, t.getTinhtrangPhong());
             pst.setString(3, t.getLoaiPhong());
          
          
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
    public int update(Phong t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(Phong t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Phong> selectAll() {
         ArrayList<Phong> ketQua = new ArrayList<Phong>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT maPhong,tinhTrangPhong,loaiPhong FROM Phong";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String maPhong = rs.getString("maPhong");
            
                 String tinhTrangPhong = rs.getString("tinhTrangPhong");
                 
                   String loaiPhong = rs.getString("loaiPhong");
               
             
               
                Phong mt = new Phong(maPhong, tinhTrangPhong,loaiPhong);
                ketQua.add(mt);
            }
            JDBCUtil.closeConnection(con);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public Phong selectById(String t) {
         Phong ketQua = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT maPhong,loaiPhong,tinhTrangPhong FROM Phong WHERE maPhong = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
               String maPhong = rs.getString("maPhong");
                String loaiPhong = rs.getString("loaiPhong");
                 String tinhTrangPhong = rs.getString("tinhTrangPhong");
         
               
                ketQua = new Phong(maPhong, tinhTrangPhong,loaiPhong);
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }
       public int updateTrangThai(String maPhong, String trangThaiPhong) {
        int ketQua = 0;
        try {
           Connection con = JDBCUtil.getConnection();
        String sql = "UPDATE Phong SET tinhTrangPhong=? WHERE maPhong=?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, trangThaiPhong);
        pst.setString(2, maPhong);
        ketQua = pst.executeUpdate();
        // Gọi lại phương thức loadDataToTablePhong để làm mới lại dữ liệu trên bảng
       
        JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    public String getTinhtrangPhong(String maPhong) {
 String trangThai = null;
    try {
        Connection con = JDBCUtil.getConnection();
        String sql = "SELECT tinhTrangPhong FROM Phong WHERE maPhong = ?";
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

    public String getTrangThaiPhong(String maPhong) {
        String trangThai = null;
Connection con = null;
try {
    con = JDBCUtil.getConnection();
    String sql = "SELECT tinhTrangPhong FROM Phong WHERE maPhong = ?";
    PreparedStatement pst = con.prepareStatement(sql);
    pst.setString(1, maPhong);
    ResultSet rs = pst.executeQuery();
    if (rs.next()) {
        trangThai = rs.getString("tinhTrangPhong");
    }
} catch (Exception ex) {
    ex.printStackTrace();
} finally {
    JDBCUtil.closeConnection(con);
}
return trangThai;
    }

   
      
     
}
