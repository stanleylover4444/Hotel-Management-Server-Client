package dao;

import entity.EmployeeType;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;

public class EmployeeTypeDAO {
    public List<entity.EmployeeType> getAllList() throws ClassNotFoundException 
    {
        List<entity.EmployeeType> list = new ArrayList<>();
        try {
            connection.DatabaseConnection.getInstance();
            Connection con = connection.DatabaseConnection.opConnection();
            String sql = "SELECT * FROM TypeEmployee";
            java.sql.Statement statement = con.createStatement();
            java.sql.ResultSet rs = statement.executeQuery(sql);
            while(rs.next())
            {
                String empTypeID = rs.getString("employeeTypeID");
                String empTypeName = rs.getString("employeeTypeName");
                entity.EmployeeType empType = new EmployeeType(empTypeID, empTypeName);
                list.add(empType);
            }
        } catch (SQLException e) {
        }
        return list;
    }
    
    public entity.EmployeeType findEmpTypeID(String id) 
    {
         
            
         try(
            Connection con = connection.DatabaseConnection.opConnection();
            java.sql.PreparedStatement pts = con.prepareStatement("SELECT * FROM TypeEmployee WHERE employeeTypeID = ? "))
         {
             pts.setString(1, id);   
                try(java.sql.ResultSet rs = pts.executeQuery())
                {
                    if(rs.next())
                    {
                        EmployeeType empType = new EmployeeType(rs.getString("employeeTypeID"),rs.getString("employeeTypeName"));
                        return empType;
                    }
                }
         } catch(Exception e)
         {
             e.printStackTrace();
         }
       return null;
    }
    
    public EmployeeType findEmpByName(String name) throws SQLException, ClassNotFoundException
    {
        try(
                Connection con = connection.DatabaseConnection.opConnection();
                java.sql.PreparedStatement pstmt = con.prepareStatement("SELECT * FROM TypeEmployee WHERE employeeTypeName = ?");
                )
        {
            pstmt.setString(1, name);
            try(java.sql.ResultSet rs = pstmt.executeQuery())
            {
                if(rs.next())
                {
                    String idT = rs.getString("employeeTypeID");
                    String nameT = rs.getString("employeeTypeName");
                    EmployeeType eT = new EmployeeType(idT, nameT);
                    return eT;
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
