package entity;

import java.util.Objects;

public class Customer {
    private String customerID;
    private String customerName;
    private CustomerType customerType;
    private String CCCD;
    private String gender;
    private String phone;
    private String email;
    private int points;

    public Customer() {
    }

    public Customer(String customerID, String customerName,String CCCD, String phone, String email, int points, CustomerType customerType,  String gender) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerType = customerType;
        this.CCCD = CCCD;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.points = points;
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

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    @Override
    public String toString() {
        return "Customer{" + "customerID=" + customerID + ", customerName=" + customerName + ", customerType=" + customerType + ", CCCD=" + CCCD + ", gender=" + gender + ", phone=" + phone + ", email=" + email + ", points=" + points + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.customerID);
        hash = 23 * hash + Objects.hashCode(this.CCCD);
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
        final Customer other = (Customer) obj;
        if (!Objects.equals(this.customerID, other.customerID)) {
            return false;
        }
        return Objects.equals(this.CCCD, other.CCCD);
    }
    
}
