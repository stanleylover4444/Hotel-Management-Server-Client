package model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Objects;

public class Phong {

    private String maPhong;
    private String tinhtrangPhong;
    private String loaiPhong;
    public Phong() {

    }

    public Phong(String maPhong, String tinhtrangPhong) {
        this.maPhong = maPhong;
        this.tinhtrangPhong = tinhtrangPhong;
    }

    
    
    public Phong(String maPhong, String tinhtrangPhong, String loaiPhong) {
        this.maPhong = maPhong;
        this.tinhtrangPhong = tinhtrangPhong;
        this.loaiPhong = loaiPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public void setTinhtrangPhong(String tinhtrangPhong) {
        this.tinhtrangPhong = tinhtrangPhong;
    }

    public void setLoaiPhong(String loaiPhong) {
        this.loaiPhong = loaiPhong;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public String getTinhtrangPhong() {
        return tinhtrangPhong;
    }

    public String getLoaiPhong() {
        return loaiPhong;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.maPhong);
        hash = 19 * hash + Objects.hashCode(this.tinhtrangPhong);
        hash = 19 * hash + Objects.hashCode(this.loaiPhong);
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
        final Phong other = (Phong) obj;
        return true;
    }

    @Override
    public String toString() {
        return "Phong{" + "maPhong=" + maPhong + ", tinhtrangPhong=" + tinhtrangPhong + ", loaiPhong=" + loaiPhong + '}';
    }

    

   
    

  

    
    
    

}
