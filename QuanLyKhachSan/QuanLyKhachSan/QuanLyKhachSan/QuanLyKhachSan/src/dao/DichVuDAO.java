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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.DichVu;

public class DichVuDAO implements DAOInterface<DichVu> {

    public static DichVuDAO getInstance() {
        return new DichVuDAO();
    }

    @Override
    public int insert(DichVu t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO DichVu (maDichVu, tenDichVu, soLuong, gia) VALUES (?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getMaDichVu());
            pst.setString(2, t.getTenDichVu());
            pst.setInt(3, t.getSoLuong());
             pst.setDouble(4, t.getGia());
          
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
  public int update(DichVu t) {
    int ketqua = 0;
    try {
        Connection con = JDBCUtil.getConnection();
        String sql = "UPDATE DichVu SET tenDichVu = ?, soLuong = ?, gia = ? WHERE maDichVu = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        
        pst.setString(1, t.getTenDichVu());
        pst.setInt(2, t.getSoLuong());
        pst.setDouble(3, t.getGia());
        pst.setString(4, t.getMaDichVu());
        
        ketqua = pst.executeUpdate();
        JDBCUtil.closeConnection(con);
    } catch (SQLException ex) {
        Logger.getLogger(DichVuDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return ketqua;
}


    @Override
    public int delete(DichVu t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM DichVu WHERE maDichVu=? ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getMaDichVu());
            ketQua = pst.executeUpdate();

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<DichVu> selectAll() {
        ArrayList<DichVu> ketQua = new ArrayList<DichVu>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT maDichVu,tenDichVu,soLuong,gia FROM DichVu";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String maDichVu = rs.getString("maDichVu");
                String tenDichVu = rs.getString("tenDichVu");
                int soLuong = rs.getInt("soLuong");
                double gia = rs.getDouble("gia");
               ;
                DichVu mt = new DichVu(maDichVu, tenDichVu, soLuong, gia);
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
    public DichVu selectById(String t) {
        DichVu ketQua = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT maDichVu,tenDichVu,soLuong,gia FROM DichVu WHERE maDichVu = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String maDichVu = rs.getString("maDichVu");
                String tenDichVu = rs.getString("tenDichVu");
                int soLuong = rs.getInt("soLuong");
                double gia = rs.getDouble("gia");
               
                ketQua = new DichVu(maDichVu, tenDichVu, soLuong, gia);
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    public int updateSoLuong(String maDichVu, int soluong) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            //String sql = "INSERT INTO DichVu (maMay, tenMay, soLuong, tenCpu, ram, cardManHinh, gia, dungLuongPin, dungLuongPin, dungLuongPin, loaiMay, rom) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            String sql = "UPDATE DichVu SET soLuong=? WHERE maDichVu=? ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, soluong);
            pst.setString(2, maDichVu);
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
    
//    public int deleteTrangThai(String maDichVu){
//        int ketQua = 0;
//        try {
//            Connection con = JDBCUtil.getConnection();
//            //String sql = "INSERT INTO DichVu (maMay, tenMay, soLuong, tenCpu, ram, cardManHinh, gia, dungLuongPin, dungLuongPin, dungLuongPin, loaiMay, rom) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
//            String sql = "UPDATE MayTinh SET trangThai=0 WHERE maDichVu=? ";
//            PreparedStatement pst = con.prepareStatement(sql);
//            pst.setString(1, maDichVu);
//            ketQua = pst.executeUpdate();
//            JDBCUtil.closeConnection(con);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return ketQua;
//    }

    public ArrayList<DichVu> selectAllE() {
        ArrayList<DichVu> ketQua = new ArrayList<DichVu>();
        ArrayList<DichVu> ketQuaTonKho = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT maDichVu,tenDichVu,soLuong,gia FROM DichVu";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String maDichVu = rs.getString("maDichVu");
                String tenDichVu = rs.getString("tenDichVu");
                int soLuong = rs.getInt("soLuong");
                double gia = rs.getDouble("gia");
               
                DichVu mt = new DichVu(maDichVu, tenDichVu, soLuong, gia);
                ketQua.add(mt);
            }
            for (DichVu mayTinh : ketQua) {
                if (mayTinh.getSoLuong() > 0) {
                    ketQuaTonKho.add(mayTinh);
                }
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQuaTonKho;
    }
           public ArrayList<DichVu> selectAllExist() {
        ArrayList<DichVu> ketQua = new ArrayList<DichVu>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT maDichVu,tenDichVu,soLuong,gia FROM dichvu ";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
              String maDichVu = rs.getString("maDichVu");
                String tenDichVu = rs.getString("tenDichVu");
               int soLuong = rs.getInt("soLuong");
               double gia = rs.getDouble("gia");
            
               DichVu mt = new DichVu(maDichVu, tenDichVu, soLuong, gia);
               ketQua.add(mt);
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }
        
   public int getSl() {
        int soluong = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM DichVu ";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                soluong++;
           }
           JDBCUtil.closeConnection(con);
       } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
       }
        return soluong;
  
   }

    
}

