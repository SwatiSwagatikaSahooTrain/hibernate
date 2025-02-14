package dao;


import entities.Student;
import utilities.SessionFactoryProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.HashMap;
import java.util.List;

public class Main {
 public static void main(String[] args) {
     try {
         // Get Hibernate SessionFactory
         SessionFactory sessionFactory = SessionFactoryProvider.provideSessionFactory();
         Session session = sessionFactory.openSession();
         Transaction transaction = session.beginTransaction();

         // Insert a new Student record
         Student student = new Student("Alice", 8);
         session.save(student);
         
         // Commit transaction
         transaction.commit();
         System.out.println("Student inserted successfully!");

         // Fetch all records from Student table
         List<Student> students = session.createQuery("FROM Student", Student.class).list();
         
         // Store student data in HashMap
         HashMap<Integer, String> studentMap = new HashMap<>();
         for (Student s : students) {
             studentMap.put(s.getId(), s.getName());
         }
         
         // Print fetched records
         System.out.println("Student Records:");
         for (Integer id : studentMap.keySet()) {
             System.out.println("ID: " + id + ", Name: " + studentMap.get(id));
         }

         // Close session and factory
         session.close();
         sessionFactory.close();
     } catch (Exception e) {
         e.printStackTrace(); // Print full error details
     }
 }
}
