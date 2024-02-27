package com.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.*;

import com.hibernate.Student;



public class HQLExample {
	public static void main(String[] args) {
		System.out.println("Project started!");
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory factory = configuration.buildSessionFactory();
        
        Session session = factory.openSession();
        
//        String query = "from Student where city='Pune'";
        String query = "from Student as s where s.city=:x";
        Query q = session.createQuery(query);
        q.setParameter("x", "Mumbai");
        //single resule - unique
//        q.uniqueResult();
        //multiple result
        List<Student> list =  q.list();
        
        for(Student student : list) {
        	System.out.println(student.getName());
        }
        
        Transaction tx = session.beginTransaction();
        //delete query
//        Query query2 = session.createQuery("delete from Student s where s.city =: c");
//        query2.setParameter("c", "Pune");
//        int r = query2.executeUpdate();
//        System.out.println("Deleted:");
//        System.out.println(r);
        
        //update query
//        Query query3 = session.createQuery("update Student set city =:c where name=:n");
//        query3.setParameter("n", "John");
//        query3.setParameter("c", "Banglore");
//        int r = query3.executeUpdate();
//        System.out.println("Updated...");
//        System.out.println(r);
        
        //join Query
        Query query4 = session.createQuery("select q.question, q.questionId, a.answer"
        		+ " from Question as q INNER JOIN q.answers as a");
        List<Object[]> list2 = query4.getResultList();
        for(Object[] arr : list2) {
        	System.out.println(Arrays.toString(arr));
        }
        
        tx.commit();
        session.close();
        factory.close();
        
        
        System.out.println("Done...");
	}
}
