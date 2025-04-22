package entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ServiceDetail")
public class ServiceDetail implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ServiceDetailID")
    private String serviceDetailID;
    
//    @ManyToOne
//    @JoinColumn(name = "OrderDetailID")
//    private OrderDetail orderDetail;

    @ManyToOne
    @JoinColumn(name = "ServiceID")
    private Service service;

    @ManyToOne
    @JoinColumn(name = "orderID")
    private Order order;

    @Column(name = "quantity")
    private int quantity;

    public ServiceDetail() {
    }

    public ServiceDetail(String serviceDetailID, Service service, Order order, int quantity) {
        this.serviceDetailID = serviceDetailID;
        this.service = service;
        this.order = order;
        this.quantity = quantity;
    }

    public String getServiceDetailID() {
        return serviceDetailID;
    }

    public void setServiceDetailID(String serviceDetailID) {
        this.serviceDetailID = serviceDetailID;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ServiceDetail{" +
                "serviceDetailID='" + serviceDetailID + '\'' +
                ", service=" + service +
                ", order=" + order +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceDetailID);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ServiceDetail other = (ServiceDetail) obj;
        return Objects.equals(serviceDetailID, other.serviceDetailID);
    }
}