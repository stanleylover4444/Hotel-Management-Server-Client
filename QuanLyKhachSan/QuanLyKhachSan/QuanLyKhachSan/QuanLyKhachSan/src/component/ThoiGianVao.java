/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package component;

import static component.ThongTinTaiKhoan.taiKhoan;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JTextField;


/**
 *
 * @author ASUS
 */
public class ThoiGianVao {
    public static void setTimeVao(JTextField textField) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = dateFormat.format(new Date());
        textField.setText(formattedDate);
    }
    
    public static ThoiGianVao getThoiGianVao() {
        return new ThoiGianVao();
    }

    public static void setTimeVao(JLabel labelThoiGianTao) {
       SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String formattedDate = dateFormat.format(new Date());
        labelThoiGianTao.setText(formattedDate);// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
