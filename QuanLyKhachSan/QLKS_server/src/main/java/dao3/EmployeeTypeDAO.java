package dao3;

import entity.EmployeeType;
import jakarta.persistence.EntityManager;
import java.util.List;

public class EmployeeTypeDAO {
    private final EntityManager entityManager;

    public EmployeeTypeDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<EmployeeType> getAllList() {
        return entityManager.createQuery("SELECT e FROM EmployeeType e", EmployeeType.class).getResultList();
    }

    public EmployeeType findEmpTypeID(String id) {
        return entityManager.find(EmployeeType.class, id);
    }

    public EmployeeType findEmpByName(String name) {
        return entityManager.createQuery("SELECT e FROM EmployeeType e WHERE e.employeeTypeName = :name", EmployeeType.class)
                .setParameter("name", name)
                .getSingleResult();
    }
}
