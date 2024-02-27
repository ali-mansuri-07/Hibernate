package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
	public static void main(String[] args) {
		System.out.println("Project started!");
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		
//		Student student = (Student) session.get(Student.class, 102);
//		System.out.println(student);
//		System.out.println(student.getName());
		
		
		Address ad = (Address) session.load(Address.class, 1);
		System.out.println(ad.getCity());
		System.out.println(ad);
		session.close();
		factory.close();
	}
}
