package dao;

import connection.DatabaseConnection;
import entity.CustomerType;
import entity.EmployeeType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerTypeDAO {
    public entity.CustomerType findCusTypeID(String id) 
    {
         
            
         try(
            Connection con = connection.DatabaseConnection.opConnection();
            java.sql.PreparedStatement pts = con.prepareStatement("SELECT * FROM CustomerType WHERE customerTypeID = ? "))
         {
             pts.setString(1, id);   
                try(java.sql.ResultSet rs = pts.executeQuery())
                {
                    if(rs.next())
                    {
                        CustomerType cType = new CustomerType(rs.getString("customerTypeID"),rs.getString("customerTypeName"));
                        return cType;
                    }
                }
         } catch(Exception e)
         {
             e.printStackTrace();
         }
       return null;
    }
    public CustomerType findCusByName(String name) throws SQLException, ClassNotFoundException
    {
        try(
                Connection con = connection.DatabaseConnection.opConnection();
                java.sql.PreparedStatement pstmt = con.prepareStatement("SELECT * FROM CustomerType WHERE customerTypeName = ?");
                )
        {
            pstmt.setString(1, name);
            try(java.sql.ResultSet rs = pstmt.executeQuery())
            {
                if(rs.next())
                {
                    String idT = rs.getString("customerTypeID");
                    String nameT = rs.getString("customerTypeName");
                    CustomerType cT = new CustomerType(idT, nameT);
                    return cT;
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
