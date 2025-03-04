/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Timestamp;
import java.util.Objects;

/**
 *
 * @author ASUS
 */
public class  ChiTietHoaDonPhong {

    private String maKH;
    private String tenKH;
    private String cmtKH;
    private boolean gioiTinhKH;
    private String sdtKH;
    private String diaChi;
    private String ngaySinhKH;
    private int soNguoi;

    private String tenNV;
    private String maPhieuThuePhong;
    private String maPhong;
    private boolean hinhThucThue;
    private double donGiaPhong;
    private Timestamp checkIn;
    private String loaiPhong;
    private String duKienCheckOut;

    private double duaTruoc;
    private double phuThu;
    
     private boolean trangThaiPhieu;


    public ChiTietHoaDonPhong(String maKH, String tenKH, String cmtKH, boolean gioiTinhKH, String sdtKH, String diaChi, String ngaySinhKH, int soNguoi, String tenNV, String maPhieuThuePhong, String maPhong, boolean hinhThucThue, double donGiaPhong, Timestamp checkIn, String loaiPhong, String duKienCheckOut , double duaTruoc, double phuThu ,  boolean trangThaiPhieu) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.cmtKH = cmtKH;
        this.gioiTinhKH = gioiTinhKH;
        this.sdtKH = sdtKH;
        this.diaChi = diaChi;
        this.ngaySinhKH = ngaySinhKH;
        this.soNguoi = soNguoi;
        this.tenNV = tenNV;
        this.maPhieuThuePhong = maPhieuThuePhong;
        this.maPhong = maPhong;
        this.hinhThucThue = hinhThucThue;
        this.donGiaPhong = donGiaPhong;
        this.checkIn = checkIn;
        this.loaiPhong = loaiPhong;
       this.duKienCheckOut = duKienCheckOut;

        this.duaTruoc = duaTruoc;
        this.phuThu = phuThu;
        
         this.trangThaiPhieu = trangThaiPhieu;
    }

  
    public ChiTietHoaDonPhong() {
        
    }

    

    public String getMaKH() {
        return maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public String getCmtKH() {
        return cmtKH;
    }

    public boolean isGioiTinhKH() {
        return gioiTinhKH;
    }

    public String getSdtKH() {
        return sdtKH;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getNgaySinhKH() {
        return ngaySinhKH;
    }

    public int getSoNguoi() {
        return soNguoi;
    }

    public String getTenNV() {
        return tenNV;
    }

    public String getMaPhieuThuePhong() {
        return maPhieuThuePhong;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public boolean isHinhThucThue() {
        return hinhThucThue;
    }

    public double getDonGiaPhong() {
        return donGiaPhong;
    }

    public Timestamp getCheckIn() {
        return checkIn;
    }

    public String getLoaiPhong() {
        return loaiPhong;
    }

    public String getDuKienCheckOut() {
        return duKienCheckOut;
    }

   
    public double getDuaTruoc() {
        return duaTruoc;
    }

    public double getPhuThu() {
        return phuThu;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public void setCmtKH(String cmtKH) {
        this.cmtKH = cmtKH;
    }

    public void setGioiTinhKH(boolean gioiTinhKH) {
        this.gioiTinhKH = gioiTinhKH;
    }

    public void setSdtKH(String sdtKH) {
        this.sdtKH = sdtKH;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setNgaySinhKH(String ngaySinhKH) {
        this.ngaySinhKH = ngaySinhKH;
    }

    public void setSoNguoi(int soNguoi) {
        this.soNguoi = soNguoi;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public void setMaPhieuThuePhong(String maPhieuThuePhong) {
        this.maPhieuThuePhong = maPhieuThuePhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public void setHinhThucThue(boolean hinhThucThue) {
        this.hinhThucThue = hinhThucThue;
    }

    public void setDonGiaPhong(double donGiaPhong) {
        this.donGiaPhong = donGiaPhong;
    }

    public void setCheckIn(Timestamp checkIn) {
        this.checkIn = checkIn;
    }

    public void setLoaiPhong(String loaiPhong) {
        this.loaiPhong = loaiPhong;
    }

    public void setDuKienCheckOut(String duKienCheckOut) {
        this.duKienCheckOut = duKienCheckOut;
    }

   

    public void setDuaTruoc(double duaTruoc) {
        this.duaTruoc = duaTruoc;
    }

    public void setPhuThu(double phuThu) {
        this.phuThu = phuThu;
    }

    public boolean isTrangThaiPhieu() {
        return trangThaiPhieu;
    }

    public void setTrangThaiPhieu(boolean trangThaiPhieu) {
        this.trangThaiPhieu = trangThaiPhieu;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.maKH);
        hash = 97 * hash + Objects.hashCode(this.tenKH);
        hash = 97 * hash + Objects.hashCode(this.cmtKH);
        hash = 97 * hash + (this.gioiTinhKH ? 1 : 0);
        hash = 97 * hash + Objects.hashCode(this.sdtKH);
        hash = 97 * hash + Objects.hashCode(this.diaChi);
        hash = 97 * hash + Objects.hashCode(this.ngaySinhKH);
        hash = 97 * hash + this.soNguoi;
        hash = 97 * hash + Objects.hashCode(this.tenNV);
        hash = 97 * hash + Objects.hashCode(this.maPhieuThuePhong);
        hash = 97 * hash + Objects.hashCode(this.maPhong);
        hash = 97 * hash + (this.hinhThucThue ? 1 : 0);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.donGiaPhong) ^ (Double.doubleToLongBits(this.donGiaPhong) >>> 32));
        hash = 97 * hash + Objects.hashCode(this.checkIn);
        hash = 97 * hash + Objects.hashCode(this.loaiPhong);
        hash = 97 * hash + Objects.hashCode(this.duKienCheckOut);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.duaTruoc) ^ (Double.doubleToLongBits(this.duaTruoc) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.phuThu) ^ (Double.doubleToLongBits(this.phuThu) >>> 32));
        hash = 97 * hash + (this.trangThaiPhieu ? 1 : 0);
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
        final ChiTietHoaDonPhong other = (ChiTietHoaDonPhong) obj;
        return true;
    }

    @Override
    public String toString() {
        return "ChiTietHoaDonPhong{" + "maKH=" + maKH + ", tenKH=" + tenKH + ", cmtKH=" + cmtKH + ", gioiTinhKH=" + gioiTinhKH + ", sdtKH=" + sdtKH + ", diaChi=" + diaChi + ", ngaySinhKH=" + ngaySinhKH + ", soNguoi=" + soNguoi + ", tenNV=" + tenNV + ", maPhieuThuePhong=" + maPhieuThuePhong + ", maPhong=" + maPhong + ", hinhThucThue=" + hinhThucThue + ", donGiaPhong=" + donGiaPhong + ", checkIn=" + checkIn + ", loaiPhong=" + loaiPhong + ", duKienCheckOut=" + duKienCheckOut + ", duaTruoc=" + duaTruoc + ", phuThu=" + phuThu + ", trangThaiPhieu=" + trangThaiPhieu + '}';
    }

    



   

    

   

    

      

 
   

  
   

}
