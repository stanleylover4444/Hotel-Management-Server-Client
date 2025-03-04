/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Objects;


public class HoaDonDichVu  {

    public HoaDonDichVu(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }
    
    
    private String maHoaDon;
    private Timestamp thoiGianTao;
    private String nguoiTao;
    private ArrayList<ChiTietHoaDonDichVu> CTHDDV;
    private double tongTien;
    
    
    
    public HoaDonDichVu() {
    }

    public HoaDonDichVu(String maHoaDon, Timestamp thoiGianTao, String nguoiTao, ArrayList<ChiTietHoaDonDichVu> CTHDDV, double tongTien) {
        this.maHoaDon = maHoaDon;
        this.thoiGianTao = thoiGianTao;
        this.nguoiTao = nguoiTao;
        this.CTHDDV = CTHDDV;
        this.tongTien = tongTien;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public Timestamp getThoiGianTao() {
        return thoiGianTao;
    }

    public String getNguoiTao() {
        return nguoiTao;
    }

    public ArrayList<ChiTietHoaDonDichVu> getCTHDDV() {
        return CTHDDV;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public void setThoiGianTao(Timestamp thoiGianTao) {
        this.thoiGianTao = thoiGianTao;
    }

    public void setNguoiTao(String nguoiTao) {
        this.nguoiTao = nguoiTao;
    }

    public void setCTHDDV(ArrayList<ChiTietHoaDonDichVu> CTHDDV) {
        this.CTHDDV = CTHDDV;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final HoaDonDichVu other = (HoaDonDichVu) obj;
        if (Double.doubleToLongBits(this.tongTien) != Double.doubleToLongBits(other.tongTien)) {
            return false;
        }
        if (!Objects.equals(this.maHoaDon, other.maHoaDon)) {
            return false;
        }
        if (!Objects.equals(this.nguoiTao, other.nguoiTao)) {
            return false;
        }
        if (!Objects.equals(this.thoiGianTao, other.thoiGianTao)) {
            return false;
        }
        return Objects.equals(this.CTHDDV, other.CTHDDV);
    }

    @Override
    public String toString() {
        return "HoaDonDichVu{" + "maHoaDon=" + maHoaDon + ", thoiGianTao=" + thoiGianTao + ", nguoiTao=" + nguoiTao + ", CTHDDV=" + CTHDDV + ", tongTien=" + tongTien + '}';
    }
    
}
