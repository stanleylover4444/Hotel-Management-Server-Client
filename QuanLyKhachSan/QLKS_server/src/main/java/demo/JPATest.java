package demo;


import dao3.AccountDAO;
import dao3.EmployeeDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPATest {

	public static void main(String[] args) {
		EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("aaa");
		EntityManager entityManager = entityFactory.createEntityManager();

		AccountDAO a = new AccountDAO(entityFactory.createEntityManager());
		EmployeeDAO e = new EmployeeDAO(entityFactory.createEntityManager());
		System.out.println(a.getAccountById("NV001"));
		System.out.println(e.findEmpID("NV001"));
		
	}

}
