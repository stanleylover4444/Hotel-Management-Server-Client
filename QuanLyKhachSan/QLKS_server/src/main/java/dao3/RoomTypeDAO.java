package dao3;

import connection.DatabaseConnection;
import entity.RoomType;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class RoomTypeDAO {
    private final EntityManager entityManager;
    
    public RoomTypeDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<RoomType> getAllRoomTypes() {
        return entityManager.createQuery("SELECT rt FROM RoomType rt", RoomType.class)
                .getResultList();
    }

    public RoomType findRoomTypeById(String id) {
        return entityManager.find(RoomType.class, id);
    }
}
