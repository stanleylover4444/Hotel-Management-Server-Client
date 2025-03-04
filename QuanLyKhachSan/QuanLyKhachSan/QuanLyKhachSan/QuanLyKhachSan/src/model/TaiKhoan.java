/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Objects;

public class TaiKhoan {

    private String tenNV;
    private String taiKhoan;
    private String matKhau;
    private String vaiTro;
    private int trangThai;
    private String SDT;

    public TaiKhoan() {
        super();
    }

    public TaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }
    
    

    public TaiKhoan(String tenNV, String taiKhoan, String matKhau, String vaiTro, int trangThai, String SDT) {
        super();
        this.tenNV = tenNV;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.vaiTro = vaiTro;
        this.trangThai = trangThai;
        this.SDT = SDT;
    }

    public TaiKhoan(String tenNV, String taiKhoan, String SDT, String vaiTro, int trangThai) {
       super();
       this.tenNV = tenNV;
        this.taiKhoan = taiKhoan;
      
        this.vaiTro = vaiTro;
        this.trangThai = trangThai;
        this.SDT = SDT;
       
    }

    public String getTenNV() {
        return tenNV;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public String getSDT() {
        return SDT;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

   

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.tenNV);
        hash = 47 * hash + Objects.hashCode(this.taiKhoan);
        hash = 47 * hash + Objects.hashCode(this.matKhau);
        hash = 47 * hash + Objects.hashCode(this.vaiTro);
        hash = 47 * hash + this.trangThai;
        hash = 47 * hash + Objects.hashCode(this.SDT);
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
        final TaiKhoan other = (TaiKhoan) obj;
        if (this.trangThai != other.trangThai) {
            return false;
        }
        if (!Objects.equals(this.tenNV, other.tenNV)) {
            return false;
        }
        if (!Objects.equals(this.taiKhoan, other.taiKhoan)) {
            return false;
        }
        if (!Objects.equals(this.matKhau, other.matKhau)) {
            return false;
        }
        if (!Objects.equals(this.vaiTro, other.vaiTro)) {
            return false;
        }
        return Objects.equals(this.SDT, other.SDT);
    }


    @Override
    public String toString() {
        return "TaiKhoan{" + "tenNV=" + tenNV + ", taiKhoan=" + taiKhoan + ", matKhau=" + matKhau + ", vaiTro=" + vaiTro + ", trangThai=" + trangThai + ", SDT=" + SDT + '}';
    }


}
