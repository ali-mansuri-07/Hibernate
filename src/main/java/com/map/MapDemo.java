package com.map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class MapDemo {
    public static void main(String[] args) {
        System.out.println("Project started!");
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory factory = configuration.buildSessionFactory();
/*       
        Question q1 = new Question();
        q1.setQuestionId(121);
        q1.setQuestion("What is Java");
        
        Answer ans1 = new Answer();
        ans1.setAnswerId(545);
        ans1.setAnswer("Java is programming language");
        ans1.setQuestion(q1);
        
        Answer ans2 = new Answer();
        ans2.setAnswerId(454);
        ans2.setAnswer("Java is platform independent language");
        ans2.setQuestion(q1);
        
        Answer ans3 = new Answer();
        ans3.setAnswerId(343);
        ans3.setAnswer("Java has different frameworks");
        ans3.setQuestion(q1);
        
        List<Answer> list = new ArrayList<Answer>();
        list.add(ans1);
        list.add(ans2);
        list.add(ans3);
        q1.setAnswers(list);
        // Save the Answer first
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
//        session.save(ans3);
  
        
        // Associate the Answer with the Question
//        q1.setAns(ans1);
//        session.save(q1);
        
        session.save(q1);
        session.save(ans1);
        session.save(ans2);
        session.save(ans3);
 */        
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Question newQuestion = (Question) session.get(Question.class, 121);
        System.out.println(newQuestion.getQuestion());
//        System.out.println(newQuestion.getAns().getAnswer());
        System.out.println(newQuestion.getQuestionId());
        System.out.println(newQuestion.getAnswers().size());
        
        //fetching
//        Question q = (Question) session.get(Question.class, 121);
//        System.out.println(q.getQuestion());
//        for(Answer a : q.getAnswers()) {
//        	System.out.println(a.getAnswer());
//        }
        
        tx.commit();
        session.close();
        
        factory.close();
        
        
        System.out.println("Done...");
    }
}

