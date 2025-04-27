package entity;

import java.io.Serializable;

public class CustomerDTO implements Serializable {
    private String customerID;
    private String customerName;
    private String CCCD;
    private String phone;
    private String email;
    private int points;
    private String gender;

    public CustomerDTO() {
    }

    public CustomerDTO(String customerID, String customerName, String CCCD, String phone, String email, int points, String gender) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.CCCD = CCCD;
        this.phone = phone;
        this.email = email;
        this.points = points;
        this.gender = gender;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}