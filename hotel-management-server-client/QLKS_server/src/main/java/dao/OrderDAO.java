
package dao;

import connection.DatabaseConnection;
import entity.BookRoom;
import entity.Customer;
import entity.Employee;
import entity.Order;
import entity.Room;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;                                    
public class OrderDAO {
	private final EntityManager entityManager = Persistence.createEntityManagerFactory(null).createEntityManager();
    private final BookRoomDAO brDAO = new BookRoomDAO(entityManager);
    private final EmployeeDAO eDAO = new EmployeeDAO(entityManager);

    public ArrayList<Order> getAlLOrder() {

        ArrayList<Order> list = new ArrayList<>();
        try (Connection conn = DatabaseConnection.opConnection(); PreparedStatement pstmt = conn.prepareStatement("SELECT *  FROM [QLKS].[dbo].[Order]")) {
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String ma = rs.getString("orderID");
                    String checkOutDate = rs.getString("checkOutDate");
                    String checkOutTime = rs.getString("checkOutTime");

                    BookRoom bookRoom = brDAO.getBookRoomByID(rs.getString("bookroomid"));
                    Employee employee = eDAO.findEmpID(rs.getString("employeeid"));
                    ArrayList<BookRoom> brs = new ArrayList<>();
                    brs.add(bookRoom);
                    String status = rs.getString("status");
                    Order o = new Order(ma, checkOutDate, checkOutTime, brs, employee, status);
                    list.add(o);
                }

                return list;
            } catch (Exception e) {
                System.err.println("getAlLOrder(): get data fail");
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.err.println("getAlLOrder(): connect db fail");
            e.printStackTrace();
        }

        return null;
    }
    public ArrayList<Order> getOrderBeforeTime(int time) {
        ArrayList<Order> list = new ArrayList<>();
        try (Connection conn = DatabaseConnection.opConnection();
                PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM [dbo].[Order] o where [checkOutDate] >= DATEADD(WEEK, ?, GETDATE()) AND [checkOutDate] <= GETDATE() and o.status like N'Ä�Ã£ thanh toÃ¡n'")) {
            pstmt.setInt(1, time);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String ma = rs.getString("orderID");
                    String checkOutDate = rs.getString("checkOutDate");
                    String checkOutTime = rs.getString("checkOutTime");

                    BookRoom bookRoom = brDAO.getBookRoomByID(rs.getString("bookroomid"));
                    Employee employee = eDAO.findEmpID(rs.getString("employeeid"));
                    ArrayList<BookRoom> brs = new ArrayList<>();
                    brs.add(bookRoom);
                    String status = rs.getString("status");
                    Order o = new Order(ma, checkOutDate, checkOutTime, brs, employee, status);
                    list.add(o);
                }

                return list;
            } catch (Exception e) {
                System.err.println("getAlLOrder(): get data fail");
                e.printStackTrace();
            }
            
        } catch (Exception e) {
            System.err.println("getBookRoomByID(String id): connect db fail");
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<Order> getAlLOrderWithStatus() {

        ArrayList<Order> list = new ArrayList<>();
        try (Connection conn = DatabaseConnection.opConnection(); PreparedStatement pstmt = conn.prepareStatement("SELECT *  FROM [QLKS].[dbo].[Order] where status = N'ChÆ°a thanh toÃ¡n'")) {
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String ma = rs.getString("orderID");
                    String checkOutDate = rs.getString("checkOutDate");
                    String checkOutTime = rs.getString("checkOutTime");

                    BookRoom bookRoom = brDAO.getBookRoomByID(rs.getString("bookroomid"));
                    Employee employee = eDAO.findEmpID(rs.getString("employeeid"));
                    ArrayList<BookRoom> brs = new ArrayList<>();
                    brs.add(bookRoom);
                    String status = rs.getString("status");
                    Order o = new Order(ma, checkOutDate, checkOutTime, brs, employee, status);
                    list.add(o);
                }

                return list;
            } catch (Exception e) {
                System.err.println("getAlLOrder(): get data fail");
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.err.println("getAlLOrder(): connect db fail");
            e.printStackTrace();
        }

        return null;
    }

    public Order getOrderByID(String id) {
        for (Order o : getAlLOrder()) {
            if (id.equals(o.getOrderID())) {
                return o;
            }
        }
        return null;
    }

    public ArrayList<Order> getOrderByStatus(String status) {
        ArrayList<Order> ds = new ArrayList<Order>();
        for (Order o : getAlLOrder()) {
            if (o.getStatus().equals(status)) {
                ds.add(o);
            }
        }
        return ds;
    }

    public boolean add(Order order) {
        try (Connection conn = DatabaseConnection.opConnection(); PreparedStatement pstmt = conn.prepareStatement("INSERT INTO [QLKS].[dbo].[Order](orderid,employeeid,bookroomid,status)"
                + " VALUES(?,?,?,?)")) {
            Employee e = eDAO.findEmpID(order.getEmployee().getEmployeeID());

            BookRoom br = brDAO.getBookRoomByID(order.getBookRooms().get(0).getBookRoomID());

            pstmt.setString(1, order.getOrderID());
            pstmt.setString(2, e.getEmployeeID());
            pstmt.setString(3, br.getBookRoomID());
            pstmt.setString(4, order.getStatus());
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("add(Order order): connect db fail");
            e.printStackTrace();
        }
        return false;
    }

    public void update(Order o) {
        try {
            Connection conn = DatabaseConnection.opConnection();
            PreparedStatement stm = conn.prepareStatement("update [dbo].[Order]\n"
                    + "set \n"
                        + " checkOutTime = ?, \n"
                        + " checkOutDate = ?, \n"
                        + "	employeeID = ?, \n"
                        + "	bookRoomID = ?, \n"
                        + "	status = ?\n"
                    + "where [dbo].[Order].orderID = ?");
            
            stm.setString(1, o.getCheckOutTime());
            stm.setString(2, o.getCheckOutDate());
            stm.setString(3, o.getEmployee().getEmployeeID());
            stm.setString(4, o.getBookRooms().get(0).getBookRoomID());
            stm.setNString(5, o.getStatus());
            stm.setString(6, o.getOrderID());
            
            stm.executeUpdate(); 
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
