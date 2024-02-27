package com.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.Certificate;
import com.hibernate.Student;

public class StateDemo {
	public static void main(String[] args) {
		System.out.println("Project started!");
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory factory = configuration.buildSessionFactory();
        
        Student student = new Student();
        student.setId(1002);
        student.setName("Sanchay");
        student.setCity("Mumbai");
        
        Certificate certificate1 = new Certificate();
		certificate1.setCourse_id(1);
		certificate1.setCourse("Java");
		certificate1.setDuration("1 Months");
		
		student.setCertificate(certificate1);
        //student : Transient state
		
		
        
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        
        session.save(student);
        //student : Persistent state --> session, database
        
//        student.setName("John");
        
        
        tx.commit();
        session.close();
        //student : Detached state
//        student.setName("Sandy");
//        System.out.println(student);
        factory.close();
        
        
        System.out.println("Done...");
	}
}
