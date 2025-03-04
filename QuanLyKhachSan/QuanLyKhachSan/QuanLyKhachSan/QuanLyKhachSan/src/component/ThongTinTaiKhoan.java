/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package component;

import model.TaiKhoan;

/**
 *
 * @author ASUS
 */
public class ThongTinTaiKhoan {
    public static TaiKhoan taiKhoan;
    public static void setTaiKhoan(TaiKhoan tk){
        taiKhoan = tk;
    }
    public static TaiKhoan getTaiKhoan(){
        return taiKhoan;
    }
}
