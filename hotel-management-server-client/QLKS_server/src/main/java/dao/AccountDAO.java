package dao;

import entity.Account;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

public class AccountDAO {
    private final EntityManager entityManager;

    public AccountDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Account> getAllListAccount() {
        return entityManager.createQuery("SELECT a FROM Account a", Account.class).getResultList();
    }

    public Account getAccountById(String id) {
        return entityManager.find(Account.class, id);
    }

    public String findPass(String userName) {
        Account account = entityManager.find(Account.class, userName);
        System.out.println(account);
        return account != null ? account.getPassword() : null;
    }

    public boolean insertAccount(Account acc) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(acc);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(String pass, String id) {
        Account account = entityManager.find(Account.class, id);
        if (account != null) {
            EntityTransaction transaction = entityManager.getTransaction();
            try {
                transaction.begin();
                account.setPassword(pass);
                entityManager.merge(account);
                transaction.commit();
                return true;
            } catch (Exception e) {
                if (transaction.isActive()) {
                    transaction.rollback();
                }
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public boolean delete(Account acc) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Account account = entityManager.find(Account.class, acc.getUserName());
            if (account != null) {
                entityManager.remove(account);
            }
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }
}
