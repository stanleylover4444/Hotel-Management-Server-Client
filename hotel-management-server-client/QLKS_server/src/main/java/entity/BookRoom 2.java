package entity;

import java.util.Date;
import java.util.Objects;

public class BookRoom {
    private String bookRoomID;
    private String bookDate;
    private String bookTime;
    private String checkInDate;
    private String checkInTime;
    private Customer customer;
    private Employee employee;
    private Room room;
    private String status;

    public BookRoom() {
    }

    public BookRoom(String bookRoomID, String bookDate, String bookTime, String checkInDate, String checkInTime, Customer customer, Employee employee, Room room, String status) {
        this.bookRoomID = bookRoomID;
        this.bookDate = bookDate;
        this.bookTime = bookTime;
        this.checkInDate = checkInDate;
        this.checkInTime = checkInTime;
        this.customer = customer;
        this.employee = employee;
        this.room = room;
        this.status = status;
    }

    public String getBookRoomID() {
        return bookRoomID;
    }

    public void setBookRoomID(String bookRoomID) {
        this.bookRoomID = bookRoomID;
    }

    public String getBookDate() {
        return bookDate;
    }

    public void setBookDate(String bookDate) {
        this.bookDate = bookDate;
    }

    public String getBookTime() {
        return bookTime;
    }

    public void setBookTime(String bookTime) {
        this.bookTime = bookTime;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(String checkInTime) {
        this.checkInTime = checkInTime;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BookRoom{" + "bookRoomID=" + bookRoomID + ", bookDate=" + bookDate + ", bookTime=" + bookTime + ", checkInDate=" + checkInDate + ", checkInTime=" + checkInTime + ", customer=" + customer + ", employee=" + employee + ", room=" + room + ", status=" + status + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.bookRoomID);
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
        final BookRoom other = (BookRoom) obj;
        return Objects.equals(this.bookRoomID, other.bookRoomID);
    }

    
    
}
