package dao;

import connection.DatabaseConnection;
import entity.Customer;
import entity.CustomerType;
import entity.EmployeeType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    CustomerTypeDAO ctd =new CustomerTypeDAO();
    private ArrayList<Customer> list;
    public Customer getCustomerByCCCD(String cccd) {
        try (Connection conn = DatabaseConnection.opConnection();
                PreparedStatement pstmt = conn.prepareStatement("select * from Customer where cccd = ?")) {
            pstmt.setString(1, cccd);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {  
                    CustomerType ct=ctd.findCusTypeID(rs.getString("CustomerTypeID"));
                    Customer c = new Customer(rs.getString("customerID"), rs.getString("customerName"),rs.getString("CCCD"), rs.getString("phone"), rs.getString("email"), rs.getInt("point"),ct,rs.getString("gender"));


                    return c;
                }
            } catch (Exception e) {
                System.err.println("getAccountById(): get data fail");
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.err.println("getAccountById(): connect db fail");
            e.printStackTrace();
        }

        return null;
    }
    public ArrayList<Customer> getalltbKhachHang() {
        list = new ArrayList<Customer>();
        try {
            DatabaseConnection.getInstance();
            Connection con = DatabaseConnection.opConnection();
            String sql = "select * from Customer";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String maNV = rs.getString("CustomerID");
                String tenKH = rs.getString("CustomerName");
                String cccd = rs.getString("cccd");
                String soDienThoai = rs.getString("phone");
                String email = rs.getString("email");
                int diemTichLuy = rs.getInt("point");
                String gioiTinh = rs.getString("gender");
                CustomerType ct=ctd.findCusTypeID(rs.getString("CustomerTypeID"));
                Customer kh = new Customer(maNV, tenKH,cccd,soDienThoai,email,diemTichLuy,ct,gioiTinh);
                list.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean update(Customer c)
    {
        try(
                Connection con = connection.DatabaseConnection.opConnection();
                java.sql.PreparedStatement pts = con.prepareStatement("UPDATE Customer SET customerName = ?, customerTypeID = ?, CCCD = ?, Phone = ?, Email = ?,  Gender = ?, Point = ? WHERE customerID = ? ");
            )
        {
            pts.setString(8, c.getCustomerID());
            pts.setString(1, c.getCustomerName());
            pts.setString(2, c.getCustomerType().getCustomerTypeID());
            pts.setString(3, c.getCCCD());
            pts.setString(4, c.getPhone());
            pts.setString(5, c.getEmail());
            pts.setString(6, c.getGender());
            pts.setInt(7, c.getPoints());
            return pts.executeUpdate() > 0;
        }
        catch(Exception e)
        {
            System.err.println("update(): connectDB fail!");
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean delete(Customer c) {
        try(
            Connection conn = connection.DatabaseConnection.opConnection();  
                java.sql.PreparedStatement pts = conn.prepareStatement("DELETE FROM Customer WHERE customerID=?");)
            {         
                pts.setString(1, c.getCustomerID());
                return pts.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("delete(): connect db fail");
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean add(Customer customer) {
        try (Connection conn = DatabaseConnection.opConnection();
                PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Customer VALUES(?,?,?,?,?,?,?,?)")) {
            pstmt.setString(1, customer.getCustomerID());
            pstmt.setString(2, customer.getCustomerName());
            pstmt.setString(3, customer.getCCCD());
            pstmt.setString(4, customer.getPhone());
            pstmt.setString(5, customer.getEmail());
            pstmt.setInt(6, customer.getPoints());
            pstmt.setString(7, customer.getCustomerType().getCustomerTypeID());
            pstmt.setString(8, customer.getGender());
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("connect db fail");
            e.printStackTrace();
        }
        return false;
    }
    public Customer getCustomerID(String id) {
        try (Connection conn = DatabaseConnection.opConnection();
                PreparedStatement pstmt = conn.prepareStatement("select * from Customer where customerid = ?")) {
            pstmt.setString(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {  
                    CustomerType ct=ctd.findCusTypeID(rs.getString("CustomerTypeID"));
                    
                    Customer c = new Customer(rs.getString("customerID"), rs.getString("customerName"),rs.getString("CCCD"), rs.getString("phone"), rs.getString("email"), rs.getInt("point"),ct,rs.getString("gender"));


                    return c;
                }
            } catch (Exception e) {
                System.err.println("getAccountById(): get data fail");
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.err.println("getAccountById(): connect db fail");
            e.printStackTrace();
        }

        return null;
    }
    
    public List<Customer> getAllEmpType(String idType) throws ClassNotFoundException, SQLException
    {
        List<Customer> list = new ArrayList<>();
        try(
                Connection con = connection.DatabaseConnection.opConnection();
                java.sql.PreparedStatement pstmt = con.prepareStatement("SELECT * FROM Customer WHERE customerTypeID = ?"))
        {
            pstmt.setString(1, idType);
            try(java.sql.ResultSet rs = pstmt.executeQuery())
            {
                while(rs.next())
                {
                    String empID = rs.getString("customerID");
                    String empName = rs.getString("customerName");
                    String empCCCD = rs.getString("CCCD");
                    String empPhone = rs.getString("Phone");
                    String empEmail = rs.getString("Email");
                    double empSalary = rs.getDouble("Point");
                    String empGender = rs.getString("Gender");
                    ctd = new CustomerTypeDAO();
                    CustomerType ct = ctd.findCusTypeID(rs.getString("customerTypeID"));
                    Customer c = new Customer(empID, empName,  empCCCD , empPhone, "", 0,ct,empGender);

                    list.add(c);

                }
                return list;                
            }
        }catch (Exception e){
                System.err.println("getAllEmpType():get data fail");
                e.printStackTrace();
        }
        return null;
        
    }
    
    public List<Customer> getListEmpGender(String gender)
    {
        List<Customer> list = new ArrayList<>();
        try(
                Connection con = connection.DatabaseConnection.opConnection();
                java.sql.PreparedStatement pstmt = con.prepareStatement("SELECT * FROM Customer WHERE gender = ?")
                ) 
        {
            pstmt.setString(1, gender);
            try(java.sql.ResultSet rs = pstmt.executeQuery())
            {
                while(rs.next())
                {
                    String empID = rs.getString("customerID");
                    String empName = rs.getString("customerName");
                    String empCCCD = rs.getString("CCCD");
                    String empPhone = rs.getString("Phone");
                    String empEmail = rs.getString("Email");
                    double empSalary = rs.getDouble("Point");
                    String empGender = rs.getString("Gender");
                    ctd = new CustomerTypeDAO();
                    CustomerType ct = ctd.findCusTypeID(rs.getString("customerTypeID"));
                    Customer c = new Customer(empID, empName,  empCCCD,  empPhone, "", 0,ct,empGender);

                    list.add(c);

                }
                return list;   
            }
            
        } catch (Exception e) {
        }
        return null;
    }
}
