package com.pagination;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernate.Student;

public class Pagination {
	public static void main(String[] args) {
		System.out.println("Project started!");
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		Query query = session.createQuery("from Student");
		
		//implementing pagination using hibernate
		query.setFirstResult(10);
		query.setMaxResults(15);
		
		List<Student> list =  query.list();
		
		for(Student s : list) {
			System.out.println(s.getName() + " " + s.getCity());
		}
		
		tx.commit();
		session.close();
		factory.close();

		System.out.println("Done...");
	}
}
