package com.sqlquery;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.hibernate.Student;

public class SQLExample {
	public static void main(String[] args) {
		System.out.println("Project started!");
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		//sql query
		String q = "select * from Student";
		NativeQuery<Object[]> nQuery = session.createNativeQuery(q);
		
		List<Object[]> list = nQuery.list();
		for(Object[] s : list) {
			System.out.println(Arrays.toString(s));
		}
		
		tx.commit();
		session.close();
		factory.close();

		System.out.println("Done...");
	}
}
