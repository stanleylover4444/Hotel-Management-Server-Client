/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.TabSettings;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;
import dao.ChiTietHoaDonDichVuDAO;
import dao.TaiKhoanDAO;
import com.itextpdf.text.Image;
import dao.DichVuDAO;
import dao.HoaDonDichVuDAO;
import dao.HoaDonPhongDAO;
import dao.KhachHangDAO;

import java.awt.Desktop;
import java.awt.FileDialog;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.ChiTietHoaDonDichVu;
import model.HoaDonPhong;
import model.DichVu;

import model.HoaDonDichVu;

public class InPDF {

    DecimalFormat formatter = new DecimalFormat("###,###,###");
    SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Document document = new Document();
    FileOutputStream file;
    JFrame jf = new JFrame();
    FileDialog fd = new FileDialog(jf, "Xuất pdf", FileDialog.SAVE);
    Font fontData;
    Font fontTitle;
    Font fontHeader;

    public InPDF() {
        try {
            fontData = new Font(BaseFont.createFont("lib/Roboto/Roboto-Regular.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 11, Font.NORMAL);
            fontTitle = new Font(BaseFont.createFont("lib/Roboto/Roboto-Regular.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 25, Font.NORMAL);
            fontHeader = new Font(BaseFont.createFont("lib/Roboto/Roboto-Regular.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 11, Font.NORMAL);
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(InPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void chooseURL(String url) {
        try {
            document.close();
            document = new Document();
            file = new FileOutputStream(url);
            PdfWriter writer = PdfWriter.getInstance(document, file);
            document.open();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Khong tim thay duong dan file " + url);
        } catch (DocumentException ex) {
            JOptionPane.showMessageDialog(null, "Khong goi duoc document !");
        }
    }

    public void setTitle(String title) {
        try {
            Paragraph pdfTitle = new Paragraph(new Phrase(title, fontTitle));
            pdfTitle.setAlignment(Element.ALIGN_CENTER);
            document.add(pdfTitle);
            document.add(Chunk.NEWLINE);
        } catch (DocumentException ex) {
            ex.printStackTrace();
        }
    }

    private String getFile(String name) {
        fd.pack();
        fd.setSize(800, 600);
        fd.validate();
        Rectangle rect = jf.getContentPane().getBounds();
        double width = fd.getBounds().getWidth();
        double height = fd.getBounds().getHeight();
        double x = rect.getCenterX() - (width / 2);
        double y = rect.getCenterY() - (height / 2);
        Point leftCorner = new Point();
        leftCorner.setLocation(x, y);
        fd.setLocation(leftCorner);
        fd.setFile(name + ".pdf");
        fd.setVisible(true);
        String url = fd.getDirectory() + fd.getFile();
        if (url.equals("null")) {
            return null;
        }
        return url;
    }

    /**
     *
     * @param MaHoaDonPhong
     */
    public void writeHoaDonPhong(String MaHoaDonPhong, String MaPhieuThue)  {
        String url = "";
        try {
            fd.setTitle("In phiếu nhập");
            fd.setLocationRelativeTo(null);
            url = getFile(MaHoaDonPhong);
            if (url == null) {
                return;
            }
            file = new FileOutputStream(url);
            document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, file);
//            url = getFile(MaHoaDonPhong);
            document.open();
            

            setTitle("THÔNG TIN HÓA ĐƠN PHÒNG");

            HoaDonPhong pn = HoaDonPhongDAO.getInstance().selectById(MaHoaDonPhong);
            Chunk glue = new Chunk(new VerticalPositionMark());// Khoang trong giua hang
            Paragraph para1 = new Paragraph();
            para1.setFont(fontData);
            para1.add("Mã hóa đơn phòng: " + pn.getMaHoaDonPhong());

            para1.add("\nThời gian tạo: " + formatDate.format(pn.getThoiGianTao()));
            para1.setIndentationLeft(40);
            Paragraph para2 = new Paragraph();
            para2.setPaddingTop(30);
            para2.setFont(fontData);
            para2.add(String.valueOf("Người tạo: " + pn.getNguoiTao()));
            para2.add(String.valueOf("\nTên khách hàng: " + pn.getTenKH()));
            para2.add(String.valueOf("\nPhòng đã thuê: " + pn.getMaPhong()));

            para2.add(String.valueOf("\nThời gian vào: " + formatDate.format(pn.getCheckIn())));
            para2.add(String.valueOf("\nThời gian ra: " + formatDate.format(pn.getCheckOut())));
//                  para2.add(String.valueOf("\nTổng thời gian sử dụng : " + pn.getThoiGianSuDung()));

            para2.setIndentationLeft(40);
            document.add(para1);
            document.add(para2);
            document.add(Chunk.NEWLINE);//add hang trong de tao khoang cach

            //Tao table cho cac chi tiet cua hoa don
            PdfPTable pdfTable = new PdfPTable(3);
            pdfTable.setWidths(new float[]{5f, 5f, 5f});
            PdfPCell cell;

            //Set headers cho table chi tiet
            pdfTable.addCell(new PdfPCell(new Phrase("Tên dịch vụ", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Số lượng", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Đơn giá", fontHeader)));

            for (int i = 0; i < 3; i++) {
                cell = new PdfPCell(new Phrase(""));
                pdfTable.addCell(cell);
            }

            //Truyen thong tin tung chi tiet vao table
            for (ChiTietHoaDonDichVu ctpn : ChiTietHoaDonDichVuDAO.getInstance().selectAll(MaPhieuThue)) {

                pdfTable.addCell(new PdfPCell(new Phrase(ctpn.getMaDichvu(), fontData)));
                // pdfTable.addCell(new PdfPCell(new Phrase(mt.getTenMay(), fontData)));
                pdfTable.addCell(new PdfPCell(new Phrase(String.valueOf(ctpn.getSoLuong()), fontData)));

                pdfTable.addCell(new PdfPCell(new Phrase(formatter.format(ctpn.getDonGia()) + "đ", fontData)));

            }

            document.add(pdfTable);
            document.add(Chunk.NEWLINE);

            Paragraph phuThu = new Paragraph(new Phrase("Tiền phụ thu: " + formatter.format(pn.getPhuThu()) + "đ", fontData));
            Paragraph duaTruoc = new Paragraph(new Phrase("Tiền đưa trước: " + formatter.format(pn.getDuaTruoc()) + "đ", fontData));
            Paragraph tienDichVu = new Paragraph(new Phrase("Tiền dịch vụ: " + formatter.format(pn.getTienDichVu()) + "đ", fontData));
            Paragraph tongTienPhong = new Paragraph(new Phrase("Tiền phòng: " + formatter.format(pn.getTongTienPhong()) + "đ", fontData));
            Paragraph paraTongThanhToan = new Paragraph(new Phrase("Tổng thanh toán: " + formatter.format(pn.getTongTienKHTra()) + "đ", fontData));

            phuThu.setIndentationLeft(40);
            duaTruoc.setIndentationLeft(40);
            tienDichVu.setIndentationLeft(40);
            tongTienPhong.setIndentationLeft(40);
            paraTongThanhToan.setIndentationLeft(40);

            document.add(phuThu);
            document.add(duaTruoc);
            document.add(tienDichVu);
            document.add(tongTienPhong);

            document.add(paraTongThanhToan);
            document.close();
            JOptionPane.showMessageDialog(null, "Ghi file thành công " + url);
            openFile(url);
        } catch (DocumentException | FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi khi ghi file " + url);
        }
    }

    private void openFile(String file) {
        try {
            File path = new File(file);
            Desktop.getDesktop().open(path);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void writePhieuXuat(String MaHoaDon) throws BadElementException, IOException {
        String url = "";
        try {
            fd.setTitle("In hóa đơn bán lẻ");
            fd.setLocationRelativeTo(null);
            url = getFile(MaHoaDon);
            if (url == null) {
                return;
            }
            file = new FileOutputStream(url);
            document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, file);
            document.open();

            Image image = Image.getInstance("C:\\Users\\ASUS\\Videos\\QuanLyKhachSan\\QuanLyKhachSan\\QuanLyKhachSan\\src\\icon\\hehe.png"); // Thay đổi đường dẫn đến tệp ảnh của bạn
            image.scaleToFit(200, 200); // Thay đổi kích thước hình ảnh theo nhu cầu

            com.itextpdf.text.Rectangle pageSize = document.getPageSize();
            // Lấy kích thước của ảnh
            float imageWidth = image.getScaledWidth();
            float imageHeight = image.getScaledHeight();
            // Tính toán vị trí để căn giữa ảnh
            float xPosition = (pageSize.getWidth() - imageWidth) / 2;
            float yPosition = (pageSize.getHeight() - imageHeight) / 1 / 2;
            // Đặt vị trí cho ảnh
            image.setAbsolutePosition(xPosition, yPosition);

            document.add(image);

            setTitle("THÔNG TIN HÓA ĐƠN BÁN LẺ");

            HoaDonDichVu pn = HoaDonDichVuDAO.getInstance().selectById(MaHoaDon);

            Paragraph para1 = new Paragraph(new Phrase("Mã hóa đơn: " + MaHoaDon, fontData));
            Paragraph para2 = new Paragraph(new Phrase("Thời gian tạo: " + formatDate.format(pn.getThoiGianTao()), fontData));
            Paragraph para3 = new Paragraph(new Phrase("Người tạo: " + TaiKhoanDAO.getInstance().selectById(pn.getNguoiTao()).getTenNV(), fontData));
            para1.setIndentationLeft(40);
            para2.setIndentationLeft(40);
            para3.setIndentationLeft(40);
            document.add(para1);
            document.add(para2);
            document.add(para3);
            document.add(Chunk.NEWLINE);//add hang trong de tao khoang cach

            PdfPTable pdfTable = new PdfPTable(4);
            pdfTable.setWidths(new float[]{30f, 15f, 5f, 15f});

// Set headers cho table chi tiết
//pdfTable.addCell(new PdfPCell(new Phrase("Mã dịch vụ", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Tên dịch vụ", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Đơn giá", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Số lượng", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Tổng tiền", fontHeader)));

// Thêm dữ liệu cho từng chi tiết hóa đơn vào bảng PDF
            for (ChiTietHoaDonDichVu ctpn : ChiTietHoaDonDichVuDAO.getInstance().selectAll(MaHoaDon)) {

                pdfTable.addCell(new PdfPCell(new Phrase(ctpn.getMaDichvu(), fontData)));
                pdfTable.addCell(new PdfPCell(new Phrase(formatter.format(ctpn.getDonGia()) + "đ", fontData)));
                pdfTable.addCell(new PdfPCell(new Phrase(String.valueOf(ctpn.getSoLuong()), fontData)));
                // Tính tổng tiền cho từng dịch vụ và thêm vào cell cuối cùng
                double tongTien = ctpn.getDonGia() * ctpn.getSoLuong();
                pdfTable.addCell(new PdfPCell(new Phrase(formatter.format(tongTien) + "đ", fontData)));
            }

            document.add(pdfTable);
            document.add(Chunk.NEWLINE);
            Paragraph paraTongThanhToan = new Paragraph(new Phrase("Tổng thanh toán: " + formatter.format(pn.getTongTien()) + "đ", fontData));
            paraTongThanhToan.setIndentationLeft(300);
            document.add(paraTongThanhToan);
            document.close();
            JOptionPane.showMessageDialog(null, "Ghi file thành công: " + url);
            openFile(url);

        } catch (DocumentException | FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi khi ghi file " + url);
        }

    }

}

//    public void writeHoaDonPhong() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }

