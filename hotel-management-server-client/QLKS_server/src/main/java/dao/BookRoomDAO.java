package dao;

import connection.DatabaseConnection;
import entity.BookRoom;
import entity.Customer;
import entity.Employee;
import entity.Room;
import jakarta.persistence.EntityManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookRoomDAO {
    private final EntityManager entityManager;
    private final CustomerDAO customerDAO;
    private final RoomDAO roomDAO;
    private final EmployeeDAO employeeDAO;

    public BookRoomDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.customerDAO = new CustomerDAO(entityManager);
        this.roomDAO = new RoomDAO(entityManager);
        this.employeeDAO = new EmployeeDAO(entityManager);
    }

    public List<BookRoom> getAllBookRooms() {
        return entityManager.createQuery("SELECT b FROM BookRoom b", BookRoom.class)
                .getResultList();
    }

    public List<BookRoom> getAllBookRoomsWithStatus() {
        return entityManager.createQuery("SELECT b FROM BookRoom b WHERE b.status = 'Chưa mở phòng'", BookRoom.class)
                .getResultList();
    }

    public BookRoom getBookRoomByID(String id) {
        return entityManager.find(BookRoom.class, id);
    }

    public boolean add(BookRoom bookRoom) {
        try {
            entityManager.getTransaction().begin();
            Customer customer = customerDAO.getCustomerByCCCD(bookRoom.getCustomer().getCCCD());
            Employee employee = employeeDAO.findEmpID(bookRoom.getEmployee().getEmployeeID());
            Room room = roomDAO.findRoomById(bookRoom.getRoom().getRoomID());
            
            bookRoom.setCustomer(customer);
            bookRoom.setEmployee(employee);
            bookRoom.setRoom(room);
            
            entityManager.persist(bookRoom);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return false;
        }
    }

    public boolean deleteBookRoom(String maDonDat) {
        try {
            entityManager.getTransaction().begin();
            BookRoom bookRoom = entityManager.find(BookRoom.class, maDonDat);
            entityManager.remove(bookRoom);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return false;
        }
    }
    
    public boolean updateBookRoom(BookRoom bookRoom) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(bookRoom);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return false;
        }
    }
}
