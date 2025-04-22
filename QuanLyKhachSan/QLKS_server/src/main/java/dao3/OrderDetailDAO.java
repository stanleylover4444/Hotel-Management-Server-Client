package dao3;

import com.sun.jdi.connect.spi.Connection;
import connection.DatabaseConnection;
import entity.Order;
import entity.OrderDetail;
import entity.ServiceDetail;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderDetailDAO {
    private ArrayList<OrderDetail> getAllOrderDetail() {
        try {
            ArrayList<OrderDetail> ds = new ArrayList<OrderDetail>();
            java.sql.Connection conn = DatabaseConnection.opConnection();
            PreparedStatement stm = conn.prepareStatement("select * from OrderDetail"); 
            ResultSet rs = stm.executeQuery(); 
            while(rs.next()) {
                String id = rs.getString("OrderDetailID"); 
                Order o = new OrderDAO().getOrderByID( rs.getString("OrderID") ); 
                ArrayList<ServiceDetail> seviceDetails = new ServiceDetailDAO().getListServiceDetailByOrderID(o.getOrderID()); 
                ds.add(new OrderDetail(id, o , seviceDetails));
            }
            return ds;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OrderDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(OrderDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null; 
    }
}
