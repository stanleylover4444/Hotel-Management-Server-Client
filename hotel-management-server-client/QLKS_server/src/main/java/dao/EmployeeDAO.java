package dao;

import entity.Employee;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private final EntityManager entityManager;
    private final EmployeeTypeDAO empTypeDAO;

    public EmployeeDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.empTypeDAO = new EmployeeTypeDAO(entityManager);
    }

    public List<Employee> getAllList() {
        return entityManager.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
    }

    public List<Employee> getListEmpQuit() {
        return entityManager.createQuery("SELECT e FROM Employee e WHERE e.attribute = 0", Employee.class).getResultList();
    }

    public List<Employee> getListEmpStay() {
        return entityManager.createQuery("SELECT e FROM Employee e WHERE e.attribute = 1", Employee.class).getResultList();
    }

    public List<Employee> getListEmpGender(String gender) {
        return entityManager.createQuery("SELECT e FROM Employee e WHERE e.gender = :gender", Employee.class)
                .setParameter("gender", gender)
                .getResultList();
    }

    public List<Employee> getAllEmpType(String idType) {
        return entityManager.createQuery("SELECT e FROM Employee e WHERE e.employeeType.employeeTypeID = :idType", Employee.class)
                .setParameter("idType", idType)
                .getResultList();
    }

    public Employee findEmpID(String id) {
        return entityManager.find(Employee.class, id);
    }

    public Employee findEmpCCCD(String cccd) {
        return entityManager.createQuery("SELECT e FROM Employee e WHERE e.CCCD = :cccd", Employee.class)
                .setParameter("cccd", cccd)
                .getSingleResult();
    }

    public boolean add(Employee emp) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(emp);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Employee emp) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(emp);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(Employee emp) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(emp);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
            return false;
        }
    }
}
