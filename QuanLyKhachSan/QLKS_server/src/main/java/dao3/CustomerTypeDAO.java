package dao3;

import entity.CustomerType;
import jakarta.persistence.EntityManager;

public class CustomerTypeDAO {
    private final EntityManager entityManager;

    public CustomerTypeDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public CustomerType findCusTypeID(String id) {
        return entityManager.find(CustomerType.class, id);
    }

    public CustomerType findCusByName(String name) {
        return entityManager.createQuery("SELECT ct FROM CustomerType ct WHERE ct.customerTypeName = :name", CustomerType.class)
                .setParameter("name", name)
                .getSingleResult();
    }
}
