package info.inesolv.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import info.inetsolv.entity.Employee;
import info.inetsolv.util.HiberUtil;

public class AppDelete {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HiberUtil.createSessionFactory();
		Session session = sessionFactory.openSession();
		Employee employee = session.get(Employee.class, 2);
		session.getTransaction().begin();
		if (employee != null) {
			session.delete(employee);
		} else {
			System.out.println("No record found");
		}
		session.getTransaction().commit();
		sessionFactory.close();
	}
}