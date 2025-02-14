package dao;

import entities.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utilities.SessionFactoryProvider;

import java.util.List;

public class Create {
    public static void main(String[] args) {
        try {
            // Get Hibernate SessionFactory
            SessionFactory sessionFactory = SessionFactoryProvider.provideSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction t = session.beginTransaction();

            // Insert a new Employee record
            Employee emp = new Employee(101, "John");
            session.save(emp);

            // Commit transaction
            t.commit();
            System.out.println("Employee inserted successfully!");

            // Fetch all records from Employee table
            List<Employee> employees = session.createQuery("FROM Employee", Employee.class).list();

            // Print fetched records
            System.out.println("Employee Records:");
            for (Employee e : employees) {
                System.out.println("ID: " + e.getEmpId() + ", Name: " + e.getEmpName());
            }

            // Close session and factory
            session.close();
            sessionFactory.close();
        } catch (Exception e) {
            e.printStackTrace(); // Print full error details
        }
    }
}
