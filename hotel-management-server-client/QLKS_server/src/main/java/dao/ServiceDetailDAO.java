package dao;

import connection.DatabaseConnection;
import entity.*;
import java.util.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServiceDetailDAO {
    private final OrderDAO oDAO=new OrderDAO();
    private final ServiceDAO sDAO=new ServiceDAO();

    public ArrayList<ServiceDetail> getAlLServiceDetail() {
        try {
            ArrayList<ServiceDetail> ds = new ArrayList<ServiceDetail>();
            Connection conn = DatabaseConnection.opConnection();
            PreparedStatement stm = conn.prepareStatement("select * from ServiceDetail");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                String id = rs.getString("ServiceDetailID");
                Service sv = new ServiceDAO().getServiceByID(rs.getString("ServiceID"));
                int quantity = rs.getInt("quantity"); 
                Order o=oDAO.getOrderByID(rs.getString("orderID"));
                ds.add(new ServiceDetail(id, sv, o, quantity));
            }

            return ds;

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServiceDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public ServiceDetail getServiceDetailByID(String id) {
        for (ServiceDetail sv : getAlLServiceDetail()) {
            if (sv.getServiceDetailID().equals(id)) {
                return sv;
            }
        }
        return null;
    }

    public ArrayList<ServiceDetail> getListServiceDetailByOrderID(String OrderID) {
        try {
            Connection conn = DatabaseConnection.opConnection();
            ArrayList<ServiceDetail> ds = new ArrayList<ServiceDetail>();
            PreparedStatement stm = conn.prepareStatement("select * from ServiceDetail where orderID = ?");
            stm.setString(1, OrderID);
            ResultSet rs = stm.executeQuery(); 
            while(rs.next()) {
                String id = rs.getString("ServiceDetailID"); 
                Service service = new ServiceDAO().getServiceByID( rs.getString("ServiceID")); 
                Order o=oDAO.getOrderByID(rs.getString("orderID"));
                int quantity = rs.getInt("quantity"); 
                ds.add( new ServiceDetail(id, service, o, quantity));
            }
            
            
            return ds; 
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServiceDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null; 
    }

    public boolean add(ServiceDetail sd) {
        try (Connection conn = DatabaseConnection.opConnection();
                PreparedStatement pstmt = conn.prepareStatement("INSERT INTO ServiceDetail(ServiceDetailid,ServiceID,orderID,quantity)"
            + " VALUES(?,?,?,?)")) {
            Order o=oDAO.getOrderByID(sd.getOrder().getOrderID());
            Service s=sDAO.getServiceByID(sd.getService().getServiceID());
            
            pstmt.setString(1, sd.getServiceDetailID());
            pstmt.setString(2, s.getServiceID());
            pstmt.setString(3, o.getOrderID());
            pstmt.setInt(4, sd.getQuantity());
        return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("add(ServiceDetail sd): connect db fail");
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(ServiceDetail sd) {
        try (Connection conn = DatabaseConnection.opConnection();
                PreparedStatement pstmt = conn.prepareStatement("UPDATE ServiceDetail  SET quantity=? where ServiceDetailID = ?")) {
            pstmt.setInt(1, sd.getQuantity());
            pstmt.setString(2, sd.getServiceDetailID());
            
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("connect db fail");
            e.printStackTrace();
        }
        return false;
    }
    
}
