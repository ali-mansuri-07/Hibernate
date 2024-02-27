package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbDemo {
	public static void main(String[] args) {
		System.out.println("Project started!");
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();

		Student student1 = new Student();
		student1.setId(111);
		student1.setName("Ali Hussain");
		student1.setCity("Delhi");

		Certificate certificate1 = new Certificate();
		certificate1.setCourse_id(1);
		certificate1.setCourse("Android");
		certificate1.setDuration("2 Months");

		student1.setCertificate(certificate1);

		Student student2 = new Student();
		student2.setId(112);
		student2.setName("Aditya Dabi");
		student2.setCity("Mumbai");

		Certificate certificate2 = new Certificate();
		certificate2.setCourse_id(2);
		certificate2.setCourse("Spring boot");
		certificate2.setDuration("2 Months");

		student2.setCertificate(certificate2);

		Session session = factory.openSession();
		Transaction transaction = (Transaction) session.beginTransaction();

		session.save(student1);
		session.save(student2);

		transaction.commit();
		session.close();
		factory.close();
	}
}
