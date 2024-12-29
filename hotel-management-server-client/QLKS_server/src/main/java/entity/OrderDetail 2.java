package entity;

import java.util.ArrayList;
import java.util.List;

public class OrderDetail {
    private String OrderDetailID; 
    private Order order;
    private ArrayList<ServiceDetail> seviceDetails; 
    
    // 
    public OrderDetail() {
    }

    public OrderDetail(String OrderDetailID, Order order, ArrayList<ServiceDetail> seviceDetails) {
        this.OrderDetailID = OrderDetailID;
        this.order = order;
        this.seviceDetails = seviceDetails;
    }

    public String getOrderDetailID() {
        return OrderDetailID;
    }

    public void setOrderDetailID(String OrderDetailID) {
        this.OrderDetailID = OrderDetailID;
    }
     

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<ServiceDetail> getSeviceDetails() {
        return seviceDetails;
    }

    public void setSeviceDetails(ArrayList<ServiceDetail> seviceDetails) {
        this.seviceDetails = seviceDetails;
    }

    @Override
    public String toString() {
        return "OrderDetail{" + "order=" + order + ", seviceDetails=" + seviceDetails + '}';
    }
    
}
