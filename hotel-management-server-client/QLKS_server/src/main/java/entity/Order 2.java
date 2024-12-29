package entity;

import dao.ServiceDetailDAO;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Order {
    private String orderID;
    private String checkOutDate; 
    private String checkOutTime;
    private List<BookRoom> bookRooms;
    private Employee employee;
    private String status;
    
    
    
    
    // tÃ­nh theo giá»�
    public double getTongTienPhong() throws ParseException {
        double sum = 0; 
        for( BookRoom br : bookRooms ) {
            sum += br.getRoom().getRoomType().getPrice(); 
        }
        return sum*thoiGianSuDung();
    }
    
    public Date chuyenDoiNgay(String timeString1, String dateString1) throws ParseException {
        timeString1 = timeString1.substring(0, 8);
        DateFormat dateFormat  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
        Date date1 = dateFormat.parse(dateString1 + " " + timeString1); 
        return date1; 
    }
    
  
    public double thoiGianSuDung() throws ParseException {
        String checkInTime = bookRooms.get(0).getBookTime();
        String checkInDate = bookRooms.get(0).getCheckInDate(); 
        
        Date vao = chuyenDoiNgay(checkInTime, checkInDate);
        Date ra = chuyenDoiNgay(checkOutTime, checkOutDate);
        
        double timeDiff = ra.getTime() - vao.getTime(); 
        double hourDiff = timeDiff/3600000;  
        return hourDiff;
    }
    
    public double getTongTienDichVu() throws SQLException, ClassNotFoundException {
        double sum = 0; 
        for( ServiceDetail sv : new ServiceDetailDAO().getListServiceDetailByOrderID(orderID) ) {
            sum += sv.getQuantity()*sv.getService().getPrice(); 
        }
        
        return sum;
    }
    
    // chÆ°a tÃ­nh km vÃ  thuáº¿ vat
    public double getTongTien() throws SQLException, ClassNotFoundException, ParseException {
        return getTongTienDichVu() + getTongTienPhong(); 
    }

    public Order() {
    }

    public Order(String orderID, String checkOutDate, String checkOutTime, List<BookRoom> bookRooms, Employee employee, String status) {
        this.orderID = orderID;
        this.checkOutDate = checkOutDate;
        this.checkOutTime = checkOutTime;
        this.bookRooms = bookRooms;
        this.status = status;
        this.employee = employee;
    }
    
    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(String checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public List<BookRoom> getBookRooms() {
        return bookRooms;
    }

    public void setBookRooms(List<BookRoom> bookRooms) {
        this.bookRooms = bookRooms;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Order{" + "orderID=" + orderID + ", checkOutDate=" + checkOutDate + ", checkOutTime=" + checkOutTime + ", bookRooms=" + bookRooms + ", status=" + status + ", employee=" + employee + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.orderID);
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
        final Order other = (Order) obj;
        return Objects.equals(this.orderID, other.orderID);
    }

    
    
}
