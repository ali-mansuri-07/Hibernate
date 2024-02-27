package com.cascade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.map.Answer;
import com.map.Question;

public class CascadeExample {
	public static void main(String[] args) {
		System.out.println("Project started!");
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Question q1 = new Question();
		q1.setQuestionId(545);
		q1.setQuestion("What is array");
		
		Answer a1 = new Answer(2347, "Array is a Data structure");
		Answer a2 = new Answer(8978, "Array is a collection of same type elements");
		Answer a3 = new Answer(7878, "Array is linear");
		
		List<Answer> list = new ArrayList<Answer>();
		list.add(a1);
		list.add(a2);
		list.add(a3);
		
		q1.setAnswers(list);
		
		session.save(q1);
		
		tx.commit();
		session.close();
		factory.close();

		System.out.println("Done...");
	}
}
