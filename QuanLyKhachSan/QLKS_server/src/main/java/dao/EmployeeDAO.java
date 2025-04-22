package dao;

import entity.Employee;
import entity.EmployeeType;
import java.util.ArrayList;
import java.util.List;

import dao.EmployeeTypeDAO;

import java.sql.Connection;
import java.sql.SQLException;

public class EmployeeDAO {
    EmployeeTypeDAO empTypeDAO = new EmployeeTypeDAO();
    
    public List<entity.Employee> getAllList()
    {
        List<Employee> listEm = new ArrayList<>();
        try (
            Connection con = connection.DatabaseConnection.opConnection();
            java.sql.PreparedStatement pstmt = con.prepareStatement("SELECT * FROM Employee")){
            try(java.sql.ResultSet rs = pstmt.executeQuery()){
                while(rs.next())
                {
                    String empID = rs.getString("employeeID");
                    String empName = rs.getString("employeeName");
                    String empCCCD = rs.getString("CCCD");
                    String empPhone = rs.getString("Phone");
                    String empEmail = rs.getString("Email");
                    double empSalary = rs.getDouble("Salary");
                    String empGender = rs.getString("Gender");
                    empTypeDAO = new EmployeeTypeDAO();
                    EmployeeType et = empTypeDAO.findEmpTypeID(rs.getString("employeeTypeID"));

                    Employee emp = new Employee(empID, empName,  empCCCD, empPhone, empEmail, empSalary,et,empGender);

                    listEm.add(emp);

                }
                return listEm;
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public List<Employee> getListEmpQuit() throws ClassNotFoundException
    {
        List<Employee> list = new ArrayList<Employee>();
        try {
            connection.DatabaseConnection.getInstance();
            Connection con = connection.DatabaseConnection.opConnection();
            String sql = "SELECT * FROM Employee WHERE Attribute = 0";   
            java.sql.Statement statement = con.createStatement();
            java.sql.ResultSet rs = statement.executeQuery(sql);
            while(rs.next())
            {
                String empID = rs.getString("emloyeeID");
                String empName = rs.getString("employeeName");
                String empCCCD = rs.getString("CCCD");
                String empPhone = rs.getString("Phone");
                String empEmail = rs.getString("Email");
                double empSalary = rs.getDouble("Salary");
                String empGender = rs.getString("Gender");
                EmployeeType empType = new EmployeeType(rs.getString("employeeTypeID"),rs.getString("employeeTypeName"));

                Employee emp = new Employee(empID, empName, empCCCD, empPhone, empEmail, empSalary,empType, empGender);
                
                list.add(emp);
             
            }
        } catch (SQLException e) {
        }
        return list;
    }
    
    
    public List<Employee> getListEmpStay() throws ClassNotFoundException
    {
        List<Employee> list = new ArrayList<Employee>();
        try {
            connection.DatabaseConnection.getInstance();
            Connection con = connection.DatabaseConnection.opConnection();
            String sql = "SELECT * FROM Employee WHERE Attribute = 1";   
            java.sql.Statement statement = con.createStatement();
            java.sql.ResultSet rs = statement.executeQuery(sql);
            while(rs.next())
            {
                String empID = rs.getString("emloyeeID");
                String empName = rs.getString("employeeName");
                String empCCCD = rs.getString("CCCD");
                String empPhone = rs.getString("Phone");
                String empEmail = rs.getString("Email");
                double empSalary = rs.getDouble("Salary");
                String empGender = rs.getString("Gender");
                EmployeeType empType = new EmployeeType(rs.getString("employeeTypeID"),rs.getString("employeeTypeName"));
                Employee emp = new Employee(empID, empName, empCCCD, empPhone, empEmail, empSalary, empType,empGender);
                
                list.add(emp);
             
            }
        } catch (SQLException e) {
        }
        return list;
    }
    
    
    public List<Employee> getListEmpGender(String gender)
    {
        List<Employee> list = new ArrayList<>();
        try(
                Connection con = connection.DatabaseConnection.opConnection();
                java.sql.PreparedStatement pstmt = con.prepareStatement("SELECT * FROM Employee WHERE gender = ?")
                ) 
        {
            pstmt.setString(1, gender);
            try(java.sql.ResultSet rs = pstmt.executeQuery())
            {
                while(rs.next())
                {
                    String empID = rs.getString("employeeID");
                    String empName = rs.getString("employeeName");
                    String empCCCD = rs.getString("CCCD");
                    String empPhone = rs.getString("Phone");
                    String empEmail = rs.getString("Email");
                    double empSalary = rs.getDouble("Salary");
                    String empGender = rs.getString("Gender");
                    empTypeDAO = new EmployeeTypeDAO();
                    EmployeeType et = empTypeDAO.findEmpTypeID(rs.getString("employeeTypeID"));

                    Employee emp = new Employee(empID, empName,  empCCCD, empPhone, empEmail, empSalary,et,empGender);

                    list.add(emp);

                }
                return list;   
            }
            
        } catch (Exception e) {
        }
        return null;
    }
    
    public List<Employee> getAllEmpType(String idType) throws ClassNotFoundException, SQLException
    {
        List<Employee> list = new ArrayList<>();
        try(
                Connection con = connection.DatabaseConnection.opConnection();
                java.sql.PreparedStatement pstmt = con.prepareStatement("SELECT * FROM Employee WHERE employeeTypeID = ?"))
        {
            pstmt.setString(1, idType);
            try(java.sql.ResultSet rs = pstmt.executeQuery())
            {
                while(rs.next())
                {
                    String empID = rs.getString("employeeID");
                    String empName = rs.getString("employeeName");
                    String empCCCD = rs.getString("CCCD");
                    String empPhone = rs.getString("Phone");
                    String empEmail = rs.getString("Email");
                    double empSalary = rs.getDouble("Salary");
                    String empGender = rs.getString("Gender");
                    empTypeDAO = new EmployeeTypeDAO();
                    EmployeeType et = empTypeDAO.findEmpTypeID(rs.getString("employeeTypeID"));

                    Employee emp = new Employee(empID, empName,  empCCCD, empPhone, empEmail, empSalary,et,empGender);

                    list.add(emp);

                }
                return list;                
            }
        }catch (Exception e){
                System.err.println("getAllEmpType():get data fail");
                e.printStackTrace();
        }
        return null;
        
    }
    
    public Employee findEmpID(String id)
    {
        try (
            Connection con = connection.DatabaseConnection.opConnection();
            java.sql.PreparedStatement pts = con.prepareStatement("SELECT * FROM Employee WHERE employeeID = ?"))
        {
            pts.setString(1, id);
                try(java.sql.ResultSet rs = pts.executeQuery())
                {
                    if(rs.next())
                    {
                        EmployeeType empType = empTypeDAO.findEmpTypeID(rs.getString("employeeTypeID"));
                        Employee emp = new Employee(
                                                       rs.getString("employeeID"),
                                                       rs.getString("employeeName"),
                                                       rs.getString("CCCD"),
                                                       rs.getString("Phone"),
                                                       rs.getString("Email"),
                                                       rs.getDouble("Salary"),
                                                       empType,
                                                       rs.getString("Gender")
                                                    );
                        return emp;
                    }
                }
        } catch (Exception e) {
        }
        return null;
    }
    
    public Employee findEmpCCCD(String cccd)
    {
        try (
            Connection con = connection.DatabaseConnection.opConnection();
            java.sql.PreparedStatement pts = con.prepareStatement("SELECT * FROM Employee WHERE CCCD = ?"))
        {
            pts.setString(1, cccd);
                try(java.sql.ResultSet rs = pts.executeQuery())
                {
                    if(rs.next())
                    {
                        empTypeDAO = new EmployeeTypeDAO();
                        EmployeeType empType = empTypeDAO.findEmpTypeID(rs.getString("employeeTypeID"));
                        Employee emp = new Employee(
                                                       rs.getString("employeeID"),
                                                       rs.getString("employeeName"),
                                                       rs.getString("CCCD"),
                                                       rs.getString("Phone"),
                                                       rs.getString("Email"),
                                                       rs.getDouble("Salary"),
                                                       empType,
                                                       rs.getString("Gender")
                                                    );
                        return emp;
                    }
                }
        } catch (Exception e) {
        }
        return null;
    }
    
    public boolean add(Employee emp)
    {
        try(
                Connection con = connection.DatabaseConnection.opConnection();
                java.sql.PreparedStatement pts = con.prepareStatement("INSERT INTO Employee VALUES (?,?,?,?,?,?,?,?)");
            )
        {
            pts.setString(1, emp.getEmployeeID());
            pts.setString(2, emp.getEmployeeName());
            pts.setString(3, emp.getCCCD());
            pts.setString(4, emp.getPhone());
            pts.setString(5, emp.getEmail());
            pts.setDouble(6, emp.getSalary());
            pts.setString(7, emp.getEmployeeType().getEmployeeTypeID());
            pts.setString(8, emp.getGender());
            return pts.executeUpdate() > 0;
        }
        catch(Exception e)
        {
            System.err.println("add(): connectDB fail!");
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean update(Employee emp)
    {
        try(
                Connection con = connection.DatabaseConnection.opConnection();
                java.sql.PreparedStatement pts = con.prepareStatement("UPDATE Employee SET employeeName = ?, employeeTypeID = ?, CCCD = ?, Phone = ?, Email = ?, Salary = ?, Gender = ? WHERE employeeID = ? ");
            )
        {
            pts.setString(8, emp.getEmployeeID());
            pts.setString(1, emp.getEmployeeName());
            pts.setString(2, emp.getEmployeeType().getEmployeeTypeID());
            pts.setString(3, emp.getCCCD());
            pts.setString(4, emp.getPhone());
            pts.setString(5, emp.getEmail());
            pts.setDouble(6, emp.getSalary());
            pts.setString(7, emp.getGender());
            return pts.executeUpdate() > 0;
        }
        catch(Exception e)
        {
            System.err.println("update(): connectDB fail!");
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean delete(Employee emp) {
        try(
            Connection conn = connection.DatabaseConnection.opConnection();  
                java.sql.PreparedStatement pts = conn.prepareStatement("DELETE FROM Employee WHERE employeeID=?");)
            {         
                pts.setString(1, emp.getEmployeeID());
                return pts.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("delete(): connect db fail");
            e.printStackTrace();
        }
        return false;
    }
    
}  
    
 