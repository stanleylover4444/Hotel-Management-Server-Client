package dao3;

import entity.RoomStatusType;
import jakarta.persistence.EntityManager;
import java.util.List;

public class RoomStatusTypeDAO {
    private final EntityManager entityManager;

    public RoomStatusTypeDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<RoomStatusType> getAllRoomStatusTypes() {
        return entityManager.createQuery("SELECT rst FROM RoomStatusType rst", RoomStatusType.class)
                .getResultList();
    }

    public RoomStatusType finRoomStatusTypeById(String id) {
        return entityManager.find(RoomStatusType.class, id);
    }
}
