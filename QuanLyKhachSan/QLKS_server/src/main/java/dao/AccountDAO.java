
package dao;

import connection.DatabaseConnection;
import dao.AccountDAO;
import entity.Account;
import entity.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccountDAO {
       public List<Account> getAllListAccount()
       {
           List<Account> list = new ArrayList<>();
           try(Connection con = connection.DatabaseConnection.opConnection();
                   PreparedStatement pstmt = con.prepareStatement("SELECT * FROM Account"))
           {
               try(ResultSet rs = pstmt.executeQuery())
               {
                   while(rs.next())
                   {
                       String user = rs.getString("userName");
                       String pass = rs.getString("password");
                       
                       Account acc = new Account(user, pass);
                       list.add(acc);
                   }
                   return list;
               }
           } catch (SQLException ex) {
               Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
           }
           return null;
       }
       public Account getAccountById(String id) {
        try (Connection conn = DatabaseConnection.opConnection();
                PreparedStatement pstmt = conn.prepareStatement("select * from Account where username = ?")) {
            pstmt.setString(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {  

                    Account acc = new Account(rs.getString("username"), rs.getString("password"));
                    return acc;
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
       public String findPass(String userName){
       String password = null;
       try (Connection con = DatabaseConnection.opConnection();
               PreparedStatement pts = con.prepareStatement("Select password from Account where userName = ?")){
           pts.setString(1, userName);
           ResultSet rs = pts.executeQuery();
           
           while(rs.next()){
               password = rs.getString("password");
           }
           return password;
       } catch (Exception e) {
           
       }
       return null;
   }
      
   public boolean insertAccount(Account acc)
    {
        try(
                Connection con = connection.DatabaseConnection.opConnection();
                java.sql.PreparedStatement pts = con.prepareStatement("INSERT INTO Account VALUES (?,?)");
            )
        {
            pts.setString(1, acc.getUserName());
            pts.setString(2, acc.getPassword());
            
            return pts.executeUpdate() > 0;
        }
        catch(Exception e)
        {
            System.err.println("add(): connectDB fail!");
            e.printStackTrace();
        }
        return false;
    }
   
   public boolean update(String pass,String id)
    {
        try(
                Connection con = connection.DatabaseConnection.opConnection();
                java.sql.PreparedStatement pts = con.prepareStatement("UPDATE Account SET password = ? WHERE userName = ? ");
            )
        {
            pts.setString(2, id);
            pts.setString(1, pass);
            
            return pts.executeUpdate() > 0;
        }
        catch(Exception e)
        {
            System.err.println("update(): connectDB fail!");
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean delete(Account acc) {
        try(
            Connection conn = connection.DatabaseConnection.opConnection();  
                java.sql.PreparedStatement pts = conn.prepareStatement("DELETE FROM Account WHERE userName=?");)
            {         
                pts.setString(1, acc.getUserName());
                return pts.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("delete(): connect db fail");
            e.printStackTrace();
        }
        return false;
    }
}
