package info.inesolv.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import info.inetsolv.entity.Employee;
import info.inetsolv.util.HiberUtil;

public class AppUpdate {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HiberUtil.createSessionFactory();
		Session session = sessionFactory.openSession();
		Employee employee = session.get(Employee.class, 3);
		Transaction transaction = session.getTransaction();
		transaction.begin();
		if (employee != null) {
			employee.setEmployeeSalary(employee.getEmployeeSalary() + 1000);
			session.saveOrUpdate(employee);
		} else {
			System.out.println("No record found");
		}
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
}
