package dao3;

import entity.Customer;
import entity.CustomerType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    private final EntityManager entityManager;

    public CustomerDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Customer getCustomerByCCCD(String cccd) {
        return entityManager.createQuery("SELECT c FROM Customer c WHERE c.CCCD = :cccd", Customer.class)
                .setParameter("cccd", cccd)
                .getSingleResult();
    }

    public List<Customer> getAllCustomers() {
        List<Customer> customers = entityManager.createQuery("SELECT c FROM Customer c", Customer.class).getResultList();
        return customers; // Convert to standard Java collection
    }

    public boolean update(Customer c) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(c);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.err.println("update(): fail to update customer");
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(Customer c) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(c);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.err.println("delete(): fail to delete customer");
            e.printStackTrace();
            return false;
        }
    }

    public boolean add(Customer customer) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(customer);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.err.println("add(): fail to add customer");
            e.printStackTrace();
            return false;
        }
    }

    public Customer getCustomerByID(String id) {
        return entityManager.find(Customer.class, id);
    }

    public List<Customer> getAllCustomersByType(String idType) {
        Query query = entityManager.createQuery("SELECT c FROM Customer c WHERE c.customerType.customerTypeID = :idType");
        query.setParameter("idType", idType);
        return query.getResultList();
    }

    public List<Customer> getAllCustomersByGender(String gender) {
        Query query = entityManager.createQuery("SELECT c FROM Customer c WHERE c.gender = :gender");
        query.setParameter("gender", gender);
        return query.getResultList();
    }
}
