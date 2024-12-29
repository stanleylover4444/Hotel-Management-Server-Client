package entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Service")
public class Service implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "serviceID")
    private String serviceID;

    @Column(name = "serviceName")
    private String serviceName;

    @Column(name = "price")
    private double price;

    @Column(name = "inventory")
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
        return "Service{" +
                "serviceID='" + serviceID + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", price=" + price +
                ", inventory=" + inventory +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceID);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Service other = (Service) obj;
        return Objects.equals(serviceID, other.serviceID);
    }
}