/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.KhachHangDAO;
import java.util.ArrayList;
import model.KhachHang;


public class SearchKhachHang {

    public static SearchKhachHang getInstance() {
        return new SearchKhachHang();
    }

    public ArrayList<KhachHang> searchTatCa(String text) {
        ArrayList<KhachHang> result = new ArrayList<>();
        ArrayList<KhachHang> armt = KhachHangDAO.getInstance().selectAll();
        for (var kh : armt) {
            if (kh.getMaKhachHang().toLowerCase().contains(text.toLowerCase())
                    || kh.getTenKhachHang().toLowerCase().contains(text.toLowerCase())
                    || kh.getSoDienThoai().toLowerCase().contains(text.toLowerCase())
                    || kh.getChungMinhThu().toLowerCase().contains(text.toLowerCase())
                    || kh.getDiaChi().toLowerCase().contains(text.toLowerCase())
            
                    
                    
                    )
            
            {
                result.add(kh);
            }
        }
        return result;
    }

    public ArrayList<KhachHang> searchTenKH(String text) {
        ArrayList<KhachHang> result = new ArrayList<>();
        ArrayList<KhachHang> armt = KhachHangDAO.getInstance().selectAll();
        for (var kh : armt) {
            if (kh.getTenKhachHang().toLowerCase().contains(text.toLowerCase())) {
                result.add(kh);
            }
        }
        return result;
    }

    public ArrayList<KhachHang> searchMaKH(String text) {
        ArrayList<KhachHang> result = new ArrayList<>();
        ArrayList<KhachHang> armt = KhachHangDAO.getInstance().selectAll();
        for (var ncc : armt) {
            if (ncc.getMaKhachHang().toLowerCase().contains(text.toLowerCase())) {
                result.add(ncc);
            }
        }
        return result;
    }

    public ArrayList<KhachHang> searchDiaChiKH(String text) {
        ArrayList<KhachHang> result = new ArrayList<>();
        ArrayList<KhachHang> armt = KhachHangDAO.getInstance().selectAll();
        for (var ncc : armt) {
            if (ncc.getDiaChi().toLowerCase().contains(text.toLowerCase())) {
                result.add(ncc);
            }
        }
        return result;
    }

    public ArrayList<KhachHang> searchSdtKH(String text) {
        ArrayList<KhachHang> result = new ArrayList<>();
        ArrayList<KhachHang> armt = KhachHangDAO.getInstance().selectAll();
        for (var kh : armt) {
            if (kh.getSoDienThoai().toLowerCase().contains(text.toLowerCase())) {
                result.add(kh);
            }
        }
        return result;
    }
    
    public ArrayList<KhachHang> searchCmtKH(String text) {
        ArrayList<KhachHang> result = new ArrayList<>();
        ArrayList<KhachHang> armt = KhachHangDAO.getInstance().selectAll();
        for (var kh : armt) {
            if (kh.getChungMinhThu().toLowerCase().contains(text.toLowerCase())) {
                result.add(kh);
            }
        }
        return result;
    }
}
