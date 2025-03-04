/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Timestamp;
import java.util.Objects;
import view.NhanVienLeTan;


public class ChiTietHoaDonDichVu {

    public ChiTietHoaDonDichVu(String maDichvu, int soLuong, double donGia) {
        this.maDichvu = maDichvu;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }
   private String maHoaDon;
   private String maHoaDonPhong;
    private String maDichvu;
    private int soLuong;
    private double donGia;
  

    public ChiTietHoaDonDichVu(String maHoaDonPhong,int soLuong, double donGia, String maDichvu) {
        this.maDichvu = maDichvu;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.maHoaDonPhong = maHoaDonPhong;
    }
    
    
public ChiTietHoaDonDichVu() {
    }


    public ChiTietHoaDonDichVu(String maHoaDon, String maDichvu, int soLuong, double donGia) {
        this.maHoaDon = maHoaDon;
        this.maDichvu = maDichvu;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public String getMaDichvu() {
        return maDichvu;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public void setMaDichvu(String maDichvu) {
        this.maDichvu = maDichvu;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.maHoaDon);
        hash = 53 * hash + Objects.hashCode(this.maHoaDonPhong);
        hash = 53 * hash + Objects.hashCode(this.maDichvu);
        hash = 53 * hash + this.soLuong;
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.donGia) ^ (Double.doubleToLongBits(this.donGia) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ChiTietHoaDonDichVu other = (ChiTietHoaDonDichVu) obj;
        if (this.soLuong != other.soLuong) {
            return false;
        }
        if (Double.doubleToLongBits(this.donGia) != Double.doubleToLongBits(other.donGia)) {
            return false;
        }
        if (!Objects.equals(this.maHoaDon, other.maHoaDon)) {
            return false;
        }
        if (!Objects.equals(this.maHoaDonPhong, other.maHoaDonPhong)) {
            return false;
        }
        return Objects.equals(this.maDichvu, other.maDichvu);
    }

    @Override
    public String toString() {
        return "ChiTietHoaDonDichVu{" + "maHoaDon=" + maHoaDon + ", maHoaDonPhong=" + maHoaDonPhong + ", maDichvu=" + maDichvu + ", soLuong=" + soLuong + ", donGia=" + donGia + '}';
    }

    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

   
    
    

}
