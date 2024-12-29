package entity;

import java.util.Objects;

public class Employee {
    private String employeeID;
    private String employeeName;
    private EmployeeType employeeType;
    private String CCCD;
    private String phone;
    private String email;
    private double salary ;
    private String gender;

    public Employee() {
    }
    
    public Employee(String employeeID, String employeeName, String CCCD, String phone, String email, double salary, EmployeeType employeeType, String gender) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.employeeType = employeeType;
        this.CCCD = CCCD;
        this.phone = phone;
        this.email = email;
        this.salary = salary;
       
        this.gender = gender;
    }
    
   
    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Employee{" + "employeeID=" + employeeID + ", employeeName=" + employeeName + ", employeeType=" + employeeType + ", CCCD=" + CCCD + ", phone=" + phone + ", email=" + email + ", salary=" + salary + ", gender=" + gender + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.employeeID);
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
        final Employee other = (Employee) obj;
        return Objects.equals(this.employeeID, other.employeeID);
    }

    
}
