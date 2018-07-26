package info.inesolv.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import info.inetsolv.entity.Employee;
import info.inetsolv.util.HiberUtil;

public class AppRetrieve {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HiberUtil.createSessionFactory();
		Session session = sessionFactory.openSession();
		Employee employee = session.get(Employee.class, 1);
		if(employee!=null)
			System.out.println("Employee Name: " + employee.getEmployeeName());
		else
			System.out.println("No record available for given employee");
		session.close();
		sessionFactory.close();
	}
}