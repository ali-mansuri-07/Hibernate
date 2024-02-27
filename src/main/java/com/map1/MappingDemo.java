package com.map1;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDemo {
	public static void main(String[] args) {
		System.out.println("Project started!");
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory factory = configuration.buildSessionFactory();
        
        Employee e1 = new Employee();
        e1.setEid(1);
        e1.setName("Ali");
        
        Employee e2 = new Employee();
        e2.setEid(2);
        e2.setName("Aditya");
        
        Project p1 = new Project();
        p1.setPid(11);
        p1.setName("LMS");
        
        Project p2 = new Project();
        p2.setPid(21);
        p2.setName("EMS");
        
        
        List<Employee> list1 = new ArrayList<Employee>();
        list1.add(e1);
        list1.add(e2);
        
        List<Project> list2 = new ArrayList<Project>();
        list2.add(p2);
        list2.add(p1);
        
        e1.setProjects(list2);
        p2.setEmployees(list1);
        		
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        
        session.save(e1);
        session.save(e2);
        session.save(p1);
        session.save(p2);
        
        tx.commit();
        session.close();
        
        factory.close();
        
        
        System.out.println("Done...");
	}
}
