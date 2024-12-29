package dao;

import entity.Room;
import entity.RoomStatusType;
import entity.RoomType;
import jakarta.persistence.EntityManager;
import java.util.List;

public class RoomDAO {
    private final EntityManager entityManager;
    private final RoomTypeDAO roomTypeDAO;
    private final RoomStatusTypeDAO roomStatusTypeDAO;

    public RoomDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.roomTypeDAO = new RoomTypeDAO(entityManager);
        this.roomStatusTypeDAO = new RoomStatusTypeDAO(entityManager);
    }

    public List<Room> getAllRooms() {
        return entityManager.createQuery("SELECT r FROM Room r", Room.class)
                .getResultList();
    }

    public Room findRoomById(String id) {
        return entityManager.find(Room.class, id);
    }

    public List<Room> findRoomByIDLoaiPhong(String IDLoaiPhong) {
        return entityManager.createQuery("SELECT r FROM Room r WHERE r.roomType.roomTypeID = :roomTypeID AND r.roomStatusType.roomStatusTypeID = 'LTTP001'", Room.class)
                .setParameter("roomTypeID", IDLoaiPhong)
                .getResultList();
    }

    public String getMaPhong() {
        List<Room> rooms = getAllRooms();
        int cnt = 1;
        for (Room r : rooms) {
            if (!r.getRoomID().equals("P" + to_string(cnt)))
                return "P" + to_string(cnt);
            cnt++;
        }
        return "P" + to_string(cnt);
    }

    public boolean saveRoom(Room room) {
        try {
        	System.out.println("123" + room);
            entityManager.getTransaction().begin();
            entityManager.persist(room);
            entityManager.getTransaction().commit();
            System.out.println("A new room was inserted successfully!");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return false;
        }
    }

    public void updateRoom(Room room) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(room);
            entityManager.getTransaction().commit();
            System.out.println("Cập nhật thông tin phòng thành công.");
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void deleteRoom(String maPhong) {
        try {
            entityManager.getTransaction().begin();
            Room room = entityManager.find(Room.class, maPhong);
            entityManager.remove(room);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    // Helper method for generating room ID
    private String to_string(int x) {
        if (x < 10) return ("00" + x);
        else if (x < 100) return ("0" + x);
        else return "" + x;
    }
}
