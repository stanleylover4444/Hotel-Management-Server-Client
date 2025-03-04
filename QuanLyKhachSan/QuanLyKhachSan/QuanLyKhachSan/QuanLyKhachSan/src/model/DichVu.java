/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Objects;

public class DichVu {
    private String maDichVu;
    private String tenDichVu;
    private int soLuong;
    private double gia;
    
    

    public DichVu() {
        
    }

    public DichVu(String maDichVu, String tenDichVu, int soLuong, double gia) {
        this.maDichVu = maDichVu;
        this.tenDichVu = tenDichVu;
        this.soLuong = soLuong;
        this.gia = gia;
    }

    
    
   

    public String getMaDichVu() {
        return maDichVu;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public double getGia() {
        return gia;
    }

    public void setMaDichVu(String maDichVu) {
        this.maDichVu = maDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    @Override
    public String toString() {
        return "DichVu{" + "maDichVu=" + maDichVu + ", tenDichVu=" + tenDichVu + ", soLuong=" + soLuong + ", gia=" + gia + '}';
    }

    
    
   

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.maDichVu);
        hash = 37 * hash + Objects.hashCode(this.tenDichVu);
        hash = 37 * hash + this.soLuong;
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.gia) ^ (Double.doubleToLongBits(this.gia) >>> 32));
       
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
        final DichVu other = (DichVu) obj;
        if (this.soLuong != other.soLuong) {
            return false;
        }
        if (Double.doubleToLongBits(this.gia) != Double.doubleToLongBits(other.gia)) {
            return false;
        }
        if (!Objects.equals(this.maDichVu, other.maDichVu)) {
            return false;
        }
        return Objects.equals(this.tenDichVu, other.tenDichVu);
    }

    
}
