package info.inesolv.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import info.inetsolv.entity.Employee;
import info.inetsolv.util.HiberUtil;

public class AppInsert {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HiberUtil.createSessionFactory();
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();

		Employee employee = new Employee();
		employee.setEmployeeNumber(3);
		employee.setEmployeeName("Abhi");
		employee.setEmployeeSalary(50000d);

		session.save(employee);
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
}