package com.secondcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.Student;

public class SecondCache {
	public static void main(String[] args) {
		System.out.println("Project started!");
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();

		Session session1 = factory.openSession();
		Student student = session1.get(Student.class, 21);
		System.out.println(student);
		session1.close();

		Session session2 = factory.openSession();
		Student student2 = session2.get(Student.class, 21);
		System.out.println(student);
		session2.close();
	}
}
