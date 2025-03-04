
package model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Objects;

public class HoaDonPhong  {
   
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
    
    private double tienDichVu;
    private double tongTienKHTra;
    private double tienTheoGio;
    private double tongTienPhong;
  
    private String maHoaDonPhong; // Thay đổi tên biến từ "HoaDonPhong" thành "maHoaDonPhong"
    private Timestamp thoiGianTao;
    private String nguoiTao; // Thay đổi tên biến từ "nhanvienThucHienThanhToan" thành "nguoiTao"
    
    private Timestamp checkOut;
    private String thoiGianSuDung;
    private String ghiChu;

    public HoaDonPhong() {
    }

    public HoaDonPhong(String maKH, String tenKH, String cmtKH, boolean gioiTinhKH, String sdtKH, String diaChi, String ngaySinhKH, int soNguoi, String tenNV, String maPhieuThuePhong, String maPhong, boolean hinhThucThue, double donGiaPhong, Timestamp checkIn, String loaiPhong, String duKienCheckOut, double duaTruoc, double phuThu, double tienDichVu, double tongTienKHTra, double tienTheoGio, double tongTienPhong, String maHoaDonPhong, Timestamp thoiGianTao, String nguoiTao, Timestamp checkOut, String thoiGianSuDung, String ghiChu) {
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
        this.tienDichVu = tienDichVu;
        this.tongTienKHTra = tongTienKHTra;
        this.tienTheoGio = tienTheoGio;
        this.tongTienPhong = tongTienPhong;
        this.maHoaDonPhong = maHoaDonPhong;
        this.thoiGianTao = thoiGianTao;
        this.nguoiTao = nguoiTao;
        this.checkOut = checkOut;
        this.thoiGianSuDung = thoiGianSuDung;
        this.ghiChu = ghiChu;
    }

    public HoaDonPhong(String maKH, String tenKH, String cmtKH, boolean gioiTinhKH, String sdtKH, String diaChi, String ngaySinhKH, int soNguoi, String tenNV, String maPhieuThuePhong, String maPhong, boolean hinhThucThue, double donGiaPhong, Timestamp checkIn, String loaiPhong, String duKienCheckOut, double duaTruoc, double phuThu, double tienDichVu, double tongTienKHTra, double tienTheoGio, double tongTienPhong, String maHoaDonPhong, Timestamp thoiGianTao, String nguoiTao, Timestamp checkOut, Timestamp thoiGianSudung, String ghiChu) {
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
        this.tienDichVu = tienDichVu;
        this.tongTienKHTra = tongTienKHTra;
        this.tienTheoGio = tienTheoGio;
        this.tongTienPhong = tongTienPhong;
        this.maHoaDonPhong = maHoaDonPhong;
        this.thoiGianTao = thoiGianTao;
        this.nguoiTao = nguoiTao;
        this.checkOut = checkOut;
        this.thoiGianSuDung = thoiGianSuDung;
        this.ghiChu = ghiChu;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getCmtKH() {
        return cmtKH;
    }

    public void setCmtKH(String cmtKH) {
        this.cmtKH = cmtKH;
    }

    public boolean isGioiTinhKH() {
        return gioiTinhKH;
    }

    public void setGioiTinhKH(boolean gioiTinhKH) {
        this.gioiTinhKH = gioiTinhKH;
    }

    public String getSdtKH() {
        return sdtKH;
    }

    public void setSdtKH(String sdtKH) {
        this.sdtKH = sdtKH;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getNgaySinhKH() {
        return ngaySinhKH;
    }

    public void setNgaySinhKH(String ngaySinhKH) {
        this.ngaySinhKH = ngaySinhKH;
    }

    public int getSoNguoi() {
        return soNguoi;
    }

    public void setSoNguoi(int soNguoi) {
        this.soNguoi = soNguoi;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getMaPhieuThuePhong() {
        return maPhieuThuePhong;
    }

    public void setMaPhieuThuePhong(String maPhieuThuePhong) {
        this.maPhieuThuePhong = maPhieuThuePhong;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public boolean isHinhThucThue() {
        return hinhThucThue;
    }

    public void setHinhThucThue(boolean hinhThucThue) {
        this.hinhThucThue = hinhThucThue;
    }

    public double getDonGiaPhong() {
        return donGiaPhong;
    }

    public void setDonGiaPhong(double donGiaPhong) {
        this.donGiaPhong = donGiaPhong;
    }

    public Timestamp getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Timestamp checkIn) {
        this.checkIn = checkIn;
    }

    public String getLoaiPhong() {
        return loaiPhong;
    }

    public void setLoaiPhong(String loaiPhong) {
        this.loaiPhong = loaiPhong;
    }

    public String getDuKienCheckOut() {
        return duKienCheckOut;
    }

    public void setDuKienCheckOut(String duKienCheckOut) {
        this.duKienCheckOut = duKienCheckOut;
    }

    public double getDuaTruoc() {
        return duaTruoc;
    }

    public void setDuaTruoc(double duaTruoc) {
        this.duaTruoc = duaTruoc;
    }

    public double getPhuThu() {
        return phuThu;
    }

    public void setPhuThu(double phuThu) {
        this.phuThu = phuThu;
    }

    public double getTienDichVu() {
        return tienDichVu;
    }

    public void setTienDichVu(double tienDichVu) {
        this.tienDichVu = tienDichVu;
    }

    public double getTongTienKHTra() {
        return tongTienKHTra;
    }

    public void setTongTienKHTra(double tongTienKHTra) {
        this.tongTienKHTra = tongTienKHTra;
    }

    public double getTienTheoGio() {
        return tienTheoGio;
    }

    public void setTienTheoGio(double tienTheoGio) {
        this.tienTheoGio = tienTheoGio;
    }

    public double getTongTienPhong() {
        return tongTienPhong;
    }

    public void setTongTienPhong(double tongTienPhong) {
        this.tongTienPhong = tongTienPhong;
    }

    public String getMaHoaDonPhong() {
        return maHoaDonPhong;
    }

    public void setMaHoaDonPhong(String maHoaDonPhong) {
        this.maHoaDonPhong = maHoaDonPhong;
    }

    public Timestamp getThoiGianTao() {
        return thoiGianTao;
    }

    public void setThoiGianTao(Timestamp thoiGianTao) {
        this.thoiGianTao = thoiGianTao;
    }

    public String getNguoiTao() {
        return nguoiTao;
    }

    public void setNguoiTao(String nguoiTao) {
        this.nguoiTao = nguoiTao;
    }

    public Timestamp getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Timestamp checkOut) {
        this.checkOut = checkOut;
    }

    public String getThoiGianSuDung() {
        return thoiGianSuDung;
    }

    public void setThoiGianSuDung(String thoiGianSuDung) {
        this.thoiGianSuDung = thoiGianSuDung;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.maKH);
        hash = 37 * hash + Objects.hashCode(this.tenKH);
        hash = 37 * hash + Objects.hashCode(this.cmtKH);
        hash = 37 * hash + (this.gioiTinhKH ? 1 : 0);
        hash = 37 * hash + Objects.hashCode(this.sdtKH);
        hash = 37 * hash + Objects.hashCode(this.diaChi);
        hash = 37 * hash + Objects.hashCode(this.ngaySinhKH);
        hash = 37 * hash + this.soNguoi;
        hash = 37 * hash + Objects.hashCode(this.tenNV);
        hash = 37 * hash + Objects.hashCode(this.maPhieuThuePhong);
        hash = 37 * hash + Objects.hashCode(this.maPhong);
        hash = 37 * hash + (this.hinhThucThue ? 1 : 0);
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.donGiaPhong) ^ (Double.doubleToLongBits(this.donGiaPhong) >>> 32));
        hash = 37 * hash + Objects.hashCode(this.checkIn);
        hash = 37 * hash + Objects.hashCode(this.loaiPhong);
        hash = 37 * hash + Objects.hashCode(this.duKienCheckOut);
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.duaTruoc) ^ (Double.doubleToLongBits(this.duaTruoc) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.phuThu) ^ (Double.doubleToLongBits(this.phuThu) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.tienDichVu) ^ (Double.doubleToLongBits(this.tienDichVu) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.tongTienKHTra) ^ (Double.doubleToLongBits(this.tongTienKHTra) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.tienTheoGio) ^ (Double.doubleToLongBits(this.tienTheoGio) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.tongTienPhong) ^ (Double.doubleToLongBits(this.tongTienPhong) >>> 32));
        hash = 37 * hash + Objects.hashCode(this.maHoaDonPhong);
        hash = 37 * hash + Objects.hashCode(this.thoiGianTao);
        hash = 37 * hash + Objects.hashCode(this.nguoiTao);
        hash = 37 * hash + Objects.hashCode(this.checkOut);
        hash = 37 * hash + Objects.hashCode(this.thoiGianSuDung);
        hash = 37 * hash + Objects.hashCode(this.ghiChu);
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
        final HoaDonPhong other = (HoaDonPhong) obj;
        return true;
    }

    @Override
    public String toString() {
        return "HoaDonPhong{" + "maKH=" + maKH + ", tenKH=" + tenKH + ", cmtKH=" + cmtKH + ", gioiTinhKH=" + gioiTinhKH + ", sdtKH=" + sdtKH + ", diaChi=" + diaChi + ", ngaySinhKH=" + ngaySinhKH + ", soNguoi=" + soNguoi + ", tenNV=" + tenNV + ", maPhieuThuePhong=" + maPhieuThuePhong + ", maPhong=" + maPhong + ", hinhThucThue=" + hinhThucThue + ", donGiaPhong=" + donGiaPhong + ", checkIn=" + checkIn + ", loaiPhong=" + loaiPhong + ", duKienCheckOut=" + duKienCheckOut + ", duaTruoc=" + duaTruoc + ", phuThu=" + phuThu + ", tienDichVu=" + tienDichVu + ", tongTienKHTra=" + tongTienKHTra + ", tienTheoGio=" + tienTheoGio + ", tongTienPhong=" + tongTienPhong + ", maHoaDonPhong=" + maHoaDonPhong + ", thoiGianTao=" + thoiGianTao + ", nguoiTao=" + nguoiTao + ", checkOut=" + checkOut + ", thoiGianSuDung=" + thoiGianSuDung + ", ghiChu=" + ghiChu + '}';
    }

    
}
    

   

