package entity;

import java.util.Objects;

public class ServiceDetail {
    private String ServiceDetailID;
    private Service service;
    private Order order;
    private int quantity;

    public ServiceDetail() {
    }

    public ServiceDetail(String ServiceDetailID, Service service, Order order, int quantity) {
        this.ServiceDetailID = ServiceDetailID;
        this.service = service;
        this.order = order;
        this.quantity = quantity;
    }

    public String getServiceDetailID() {
        return ServiceDetailID;
    }

    public void setServiceDetailID(String ServiceDetailID) {
        this.ServiceDetailID = ServiceDetailID;
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
        return "ServiceDetail{" + "ServiceDetailID=" + ServiceDetailID + ", service=" + service + ", order=" + order + ", quantity=" + quantity + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.ServiceDetailID);
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
        final ServiceDetail other = (ServiceDetail) obj;
        return Objects.equals(this.ServiceDetailID, other.ServiceDetailID);
    }

    
}
