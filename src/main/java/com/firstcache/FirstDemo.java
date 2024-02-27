package com.firstcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.Student;

public class FirstDemo {
	public static void main(String[] args) {
		System.out.println("Project started!");
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Student student = session.get(Student.class, 21);
		System.out.println(student);
		
		System.out.println("Something working....");
		
		Student student1 = session.get(Student.class, 21);
		System.out.println(student1);
		
		System.out.println(session.contains(student1));
		
		tx.commit();
		session.close();
//		System.out.println(session.contains(student1));
		factory.close();

		System.out.println("Done...");
	}
}
