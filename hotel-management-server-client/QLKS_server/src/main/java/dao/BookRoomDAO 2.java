package dao;

import connection.DatabaseConnection;
import entity.BookRoom;
import entity.Customer;
import entity.Employee;
import entity.Room;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

public class BookRoomDAO {
    private final EmployeeDAO eDAO=new EmployeeDAO();
    private final EmployeeTypeDAO etDAO=new EmployeeTypeDAO();
    private CustomerDAO customerDAO = new CustomerDAO();
    private RoomDAO roomDAO = new RoomDAO();
    private EmployeeDAO employeeDAO=new EmployeeDAO();
    public ArrayList<BookRoom> getAlLBookRooms() {
        ArrayList<BookRoom> bookRooms = new ArrayList<>();
        try (Connection conn = DatabaseConnection.opConnection();
                PreparedStatement pstmt = conn.prepareStatement("Select * from bookroom")) {
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String maDDP = rs.getString("bookroomID");
                    String ngayDat = rs.getString("bookdate");
                    String gioDat = rs.getString("booktime");
                    String ngayNhan = rs.getString("checkindate");
                    String gioNhan = rs.getString("checkintime");

                    Customer customer = customerDAO.getCustomerID(rs.getString("customerid"));
                    Room room = roomDAO.findRoomById(rs.getString("roomid"));
                    Employee employee = employeeDAO.findEmpID(rs.getString("employeeid"));
                    String status = rs.getString("status");
                    BookRoom bookRoom = new BookRoom(maDDP, ngayDat, gioDat, ngayNhan, gioNhan,  customer, employee,room,status);
                    bookRooms.add(bookRoom);
                }

                return bookRooms;
            } catch (Exception e) {
                System.err.println("getAlLBookRooms():get data fail");
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.err.println("getAlLBookRooms():connect db fail");
            e.printStackTrace();
        }

        return null;
    }
    public ArrayList<BookRoom> getAlLBookRoomsWithStatus() {
        ArrayList<BookRoom> bookRooms = new ArrayList<>();
        try (Connection conn = DatabaseConnection.opConnection();
                PreparedStatement pstmt = conn.prepareStatement("Select * from bookroom where status= N'Chưa mở phòng'")) {
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String maDDP = rs.getString("bookroomID");
                    String ngayDat = rs.getString("bookdate");
                    String gioDat = rs.getString("booktime");
                    String ngayNhan = rs.getString("checkindate");
                    String gioNhan = rs.getString("checkintime");

                    Customer customer = customerDAO.getCustomerID(rs.getString("customerid"));
                    Room room = roomDAO.findRoomById(rs.getString("roomid"));
                    Employee employee = employeeDAO.findEmpID(rs.getString("employeeid"));
                    String status = rs.getString("status");
                    BookRoom bookRoom = new BookRoom(maDDP, ngayDat, gioDat, ngayNhan, gioNhan,  customer, employee,room,status);
                    bookRooms.add(bookRoom);
                }

                return bookRooms;
            } catch (Exception e) {
                System.err.println("getAlLBookRooms():get data fail");
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.err.println("getAlLBookRooms():connect db fail");
            e.printStackTrace();
        }

        return null;
    }
    
    public BookRoom getBookRoomByID(String id) {
        try (Connection conn = DatabaseConnection.opConnection();
                PreparedStatement pstmt = conn.prepareStatement("select * from BookRoom where BookRoomid = ? ")) {
            pstmt.setString(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {  
                    String maDDP = rs.getString("bookroomID");
                    String ngayDat = rs.getString("bookdate");
                    String gioDat = rs.getString("booktime");
                    String ngayNhan = rs.getString("checkindate");
                    String gioNhan = rs.getString("checkintime");

                    Customer customer = customerDAO.getCustomerID(rs.getString("customerId"));
                    Room room = roomDAO.findRoomById(rs.getString("roomid"));
                    Employee employee = employeeDAO.findEmpID(rs.getString("employeeid"));
                    String status = rs.getString("status");
                    BookRoom bookRoom = new BookRoom(maDDP, ngayDat, gioDat, ngayNhan, gioNhan,  customer, employee,room,status);
                    
                    return bookRoom;
                }
            } catch (Exception e) {
                System.err.println("getBookRoomByID(String id): get data fail");
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.err.println("getBookRoomByID(String id): connect db fail");
            e.printStackTrace();
        }

        return null;
    }

    public boolean add(BookRoom bookRoom) {
        try (Connection conn = DatabaseConnection.opConnection();
                PreparedStatement pstmt = conn.prepareStatement("INSERT INTO bookroom(bookroomid,bookdate,booktime,checkindate,checkintime,customerid,employeeid,roomid,status)"
            + " VALUES(?,?,?,?,?,?,?,?,?)")) {
            Customer c=customerDAO.getCustomerByCCCD(bookRoom.getCustomer().getCCCD());
            Employee e=eDAO.findEmpID(bookRoom.getEmployee().getEmployeeID());
            
            
            java.sql.Date bookDate= java.sql.Date.valueOf(bookRoom.getBookDate());
            java.sql.Date checkInDate =  java.sql.Date.valueOf(bookRoom.getCheckInDate());
            
            java.sql.Time bookTime=Time.valueOf(bookRoom.getBookTime());
            java.sql.Time checkInTime=Time.valueOf(bookRoom.getCheckInTime());
            
            
            pstmt.setString(1, bookRoom.getBookRoomID());
            pstmt.setDate(2, bookDate);
            pstmt.setTime(3, bookTime);
            pstmt.setDate(4,checkInDate );
            pstmt.setTime(5, checkInTime);
            pstmt.setString(6, c.getCustomerID());
            pstmt.setString(7, e.getEmployeeID());
            pstmt.setString(8, bookRoom.getRoom().getRoomID());
            pstmt.setString(9, bookRoom.getStatus());
        return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("add(BookRoom bookRoom): connect db fail");
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteBookRoom(String maDonDat) {
        try (Connection conn = DatabaseConnection.opConnection();
                PreparedStatement pstmt = conn.prepareStatement("DELETE FROM bookroom WHERE bookroomid = ?")) {
            pstmt.setString(1, maDonDat);
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean updateBookRoom(BookRoom bookRoom) {
        try (Connection conn = DatabaseConnection.opConnection();
                PreparedStatement pstmt = conn.prepareStatement("UPDATE BookRoom  SET status=? where BookRoomid = ?")) {
            pstmt.setString(1, bookRoom.getStatus());
            pstmt.setString(2, bookRoom.getBookRoomID());
            
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("connect db fail");
            e.printStackTrace();
        }
        return false;
    }

}
