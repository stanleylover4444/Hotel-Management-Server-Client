package dao;


import connection.DatabaseConnection;
import dao.RoomDAO;
import dao.RoomStatusTypeDAO;
import dao.RoomTypeDAO;
import entity.Room;
import entity.RoomStatusType;
import entity.RoomType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RoomDAO {
    private final RoomTypeDAO roomTypeDAO = new RoomTypeDAO();
    private final RoomStatusTypeDAO roomStatusTypeDAO = new RoomStatusTypeDAO();
    
    
    public List<Room> getAllRooms() {
        List<Room> rooms = new ArrayList<>();

        try (Connection conn = DatabaseConnection.opConnection();
                PreparedStatement pstmt = conn.prepareStatement("select * from room")) {
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    RoomType roomType = roomTypeDAO.findRoomTypeById(rs.getString("roomtypeid"));
                    RoomStatusType romStatusType = roomStatusTypeDAO.finRoomStatusTypeById(rs.getString("roomstatustypeid"));

                    Room room = new Room(rs.getString("roomid"), rs.getString("roomName"), roomType, romStatusType,rs.getString("describe"));
                    rooms.add(room);
                }

                return rooms;
            } catch (Exception e) {
                System.err.println("get data fail");
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.err.println("getAllRooms(): connect db fail");
            e.printStackTrace();
        }

        return null;
    }
    
    public Room findRoomById(String id) {
        try (Connection conn = DatabaseConnection.opConnection();
                PreparedStatement pstmt = conn.prepareStatement("select * from Room where roomid = ?")) {
            pstmt.setString(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    RoomType roomType = roomTypeDAO.findRoomTypeById(rs.getString("roomtypeid"));
                    RoomStatusType romStatusType = roomStatusTypeDAO.finRoomStatusTypeById(rs.getString("roomstatustypeid"));
                    

                    Room room = new Room(rs.getString("roomid"), rs.getString("roomName"), roomType, romStatusType,rs.getString("describe"));


                    return room;
                }
            } catch (Exception e) {
                System.err.println("findRoomById(): get data fail");
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.err.println("findRoomById(): connect db fail");
            e.printStackTrace();
        }

        return null;
    }
    
    public List<Room> findRoomByIDLoaiPhong(String IDLoaiPhong) {
        List<Room> rooms = new ArrayList<>();

        try (Connection conn = DatabaseConnection.opConnection();
                PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM ROOM WHERE ROOMTYPEID = ? and roomstatustypeid = 'LTTP001' ")) {
            pstmt.setString(1, IDLoaiPhong);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    RoomType roomType = roomTypeDAO.findRoomTypeById(rs.getString("roomtypeid"));
                    RoomStatusType romStatusType = roomStatusTypeDAO.finRoomStatusTypeById(rs.getString("roomstatustypeid"));

                    Room room = new Room(rs.getString("roomid"), rs.getString("roomName"), roomType, romStatusType,rs.getString("describe"));
                    rooms.add(room);
                }

                return rooms;
            } catch (Exception e) {
                System.err.println("get data fail");
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.err.println("findRoomByIDLoaiPhong(): connect db fail");
            e.printStackTrace();
        }
        return null;
    }
    
    // sinh mã phòng tự động 
    public String to_string(int x) {
        if(x < 10) return ("00"+x); 
        else if(x < 100) return ("0"+x); 
        else return ""+x; 
    }
    
    public String getMaPhong() {
        List<Room> ds = getAllRooms(); 
        int cnt = 1; 
        for( Room r : ds ) {
            if(!r.getRoomID().equals("P" + to_string(cnt)))
                return "P" + to_string(cnt); 
            cnt++; 
        }
        return "P" + to_string(cnt); 
    }
    
    public boolean SaveRoom( Room Phong ) {
        try {
            Connection conn = DatabaseConnection.opConnection();
            String sql = "INSERT INTO Room (roomID, roomName, describe,roomTypeID, roomStatusTypeID) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, Phong.getRoomID());
            statement.setNString(2, Phong.getRoomName());
            statement.setNString(3, Phong.getDescribe());
            statement.setString(4, Phong.getRoomType().getRoomTypeID());
            statement.setString(5, Phong.getRoomStatusType().getRoomStatusTypeID());
               
            
            
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new room was inserted successfully!");
            }
            return true;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RoomDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RoomDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
 
    }
    
    public void updateRoom(Room Phong) {
        try { 
            Connection conn = DatabaseConnection.opConnection();
            String sql = "UPDATE Room set roomName = ?, describe=?, roomTypeID = ?, roomStatusTypeID = ? where roomID = ?"; 
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setNString(1, Phong.getRoomName());
            statement.setNString(2, Phong.getDescribe());
            statement.setString(3, Phong.getRoomType().getRoomTypeID());
            statement.setString(4, Phong.getRoomStatusType().getRoomStatusTypeID());
            statement.setString(5, Phong.getRoomID());
            int rowsUpdated = statement.executeUpdate(); 
            if (rowsUpdated > 0) {
                System.out.println("Cập nhật thông tin phòng thành công.");
            } else {
                System.out.println("Không tìm thấy phòng để cập nhật.");
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RoomDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RoomDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteRoom(String maPhong) {
        try {
            Connection conn = DatabaseConnection.opConnection(); 
            String sql = "DELETE FROM Room WHERE roomID = ?";
            PreparedStatement statement = conn.prepareStatement(sql); 
            statement.setString(1, maPhong);
            statement.executeUpdate(); 
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RoomDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RoomDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
