package entity;

import java.util.Objects;

public class CustomerType {
    private String customerTypeID;
    private String customerTypeName;

    public CustomerType() {
    }

    public CustomerType(String customerTypeID, String customerTypeName) {
        this.customerTypeID = customerTypeID;
        this.customerTypeName = customerTypeName;
    }

    public String getCustomerTypeID() {
        return customerTypeID;
    }

    public void setCustomerTypeID(String customerTypeID) {
        this.customerTypeID = customerTypeID;
    }

    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }

    @Override
    public String toString() {
        return "CustomerType{" + "customerTypeID=" + customerTypeID + ", customerTypeName=" + customerTypeName + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.customerTypeID);
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
        final CustomerType other = (CustomerType) obj;
        return Objects.equals(this.customerTypeID, other.customerTypeID);
    }
    
}
