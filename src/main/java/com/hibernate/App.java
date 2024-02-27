package com.hibernate;

import java.io.FileInputStream;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) throws Exception{
		System.out.println("Project started!");
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		System.out.println(factory);

		// creating student
		Student student = new Student();
		student.setId(102);
		student.setName("Aditya");
		student.setCity("Bhopal");
		
		//creating object of address
		Address address = new Address();
		address.setStreet("street1");
		address.setCity("Indore");
		address.setOpen(true);
		address.setAddedDate(new Date());
		address.setX(234.452);
		//Reading image
		FileInputStream fileInputStream = new FileInputStream("src/main/java/image1.png");
		byte[] data = new byte[fileInputStream.available()];
		fileInputStream.read(data);
//		address.setImage(data);
		//get session
		Session session = factory.openSession();
		//begin transaction
		Transaction tx = session.beginTransaction();
		//save student
		session.save(student);
		session.save(address);
		//commit transaction
		tx.commit();
		//close session
		session.close();
		System.out.println("Done...");
	}
}
