/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Objects;

/**
 *
 * @author ASUS
 */
public class DichVuPTP {
     private String maHoaDonPhong;
    private String maDichvu;
    private int soLuong;
    private double donGiaDV;

    public DichVuPTP(String maHoaDonPhong, String maDichvu, int soLuong, double donGiaDV) {
        this.maHoaDonPhong = maHoaDonPhong;
        this.maDichvu = maDichvu;
        this.soLuong = soLuong;
        this.donGiaDV = donGiaDV;
    }

    public String getMaHoaDonPhong() {
        return maHoaDonPhong;
    }

    public String getMaDichvu() {
        return maDichvu;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public double getDonGiaDV() {
        return donGiaDV;
    }

    public void setMaHoaDonPhong(String maHoaDonPhong) {
        this.maHoaDonPhong = maHoaDonPhong;
    }

    public void setMaDichvu(String maDichvu) {
        this.maDichvu = maDichvu;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setDonGiaDV(double donGiaDV) {
        this.donGiaDV = donGiaDV;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.maHoaDonPhong);
        hash = 43 * hash + Objects.hashCode(this.maDichvu);
        hash = 43 * hash + this.soLuong;
        hash = 43 * hash + (int) (Double.doubleToLongBits(this.donGiaDV) ^ (Double.doubleToLongBits(this.donGiaDV) >>> 32));
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
        final DichVuPTP other = (DichVuPTP) obj;
        return true;
    }

    @Override
    public String toString() {
        return "DichVuPTP{" + "maHoaDonPhong=" + maHoaDonPhong + ", maDichvu=" + maDichvu + ", soLuong=" + soLuong + ", donGia=" + donGiaDV + '}';
    }
    
}


