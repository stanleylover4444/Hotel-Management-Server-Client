package entity;

import java.util.Objects;

public class EmployeeType {
    private String employeeTypeID;
    private String employeeTypeName;

    public EmployeeType() {
    }

    public EmployeeType(String employeeTypeID, String employeeTypeName) {
        this.employeeTypeID = employeeTypeID;
        this.employeeTypeName = employeeTypeName;
    }

    public String getEmployeeTypeID() {
        return employeeTypeID;
    }

    public void setEmployeeTypeID(String employeeTypeID) {
        this.employeeTypeID = employeeTypeID;
    }

    public String getEmployeeTypeName() {
        return employeeTypeName;
    }

    public void setEmployeeTypeName(String employeeTypeName) {
        this.employeeTypeName = employeeTypeName;
    }

    @Override
    public String toString() {
        return "EmployeeType{" + "employeeTypeID=" + employeeTypeID + ", employeeTypeName=" + employeeTypeName + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.employeeTypeID);
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
        final EmployeeType other = (EmployeeType) obj;
        return Objects.equals(this.employeeTypeID, other.employeeTypeID);
    }
    
}
