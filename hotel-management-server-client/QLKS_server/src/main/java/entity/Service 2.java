package entity;

import java.util.Objects;

public class Service {
    private String serviceID;
    private String serviceName;
    private double price;
    private int inventory;

    public Service() {
    }

    public Service(String serviceID, String serviceName, double price, int inventory) {
        this.serviceID = serviceID;
        this.serviceName = serviceName;
        this.price = price;
        this.inventory = inventory;
    }

    public String getServiceID() {
        return serviceID;
    }

    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    @Override
    public String toString() {
        return "Service{" + "serviceID=" + serviceID + ", serviceName=" + serviceName + ", price=" + price + ", inventory=" + inventory + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.serviceID);
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
        final Service other = (Service) obj;
        return Objects.equals(this.serviceID, other.serviceID);
    }
    
}
