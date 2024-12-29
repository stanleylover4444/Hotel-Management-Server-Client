package entity;

import java.io.Serializable;
import java.util.ArrayList;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "OrderDetail")
public class OrderDetail implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderDetailID")
    private String orderDetailID;

    @ManyToOne
    @JoinColumn(name = "OrderID")
    private Order order;

	private ArrayList<ServiceDetail> seviceDetails;

//    @OneToMany(mappedBy = "orderDetail", cascade = CascadeType.ALL)
//    private List<ServiceDetail> serviceDetails;

    public OrderDetail() {
    }
    public OrderDetail(String OrderDetailID, Order order, ArrayList<ServiceDetail> seviceDetails) {
        this.orderDetailID = OrderDetailID;
        this.order = order;
        this.setSeviceDetails(seviceDetails);
    }

    public OrderDetail(String orderDetailID, Order order) {
        this.orderDetailID = orderDetailID;
        this.order = order;
//        this.serviceDetails = serviceDetails;
    }

    public String getOrderDetailID() {
        return orderDetailID;
    }

    public void setOrderDetailID(String orderDetailID) {
        this.orderDetailID = orderDetailID;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

//    public List<ServiceDetail> getServiceDetails() {
//        return serviceDetails;
//    }
//
//    public void setServiceDetails(List<ServiceDetail> serviceDetails) {
//        this.serviceDetails = serviceDetails;
//    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "order=" + order +
                ", serviceDetails="  +
                '}';
    }
	public ArrayList<ServiceDetail> getSeviceDetails() {
		return seviceDetails;
	}
	public void setSeviceDetails(ArrayList<ServiceDetail> seviceDetails) {
		this.seviceDetails = seviceDetails;
	}
}