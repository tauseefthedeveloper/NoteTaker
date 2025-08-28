package com.mappings;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOneMap {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();

		// creating object Qustions
		Questions qus = new Questions();
		qus.setId(101);
		qus.setQuestion("What is java?");

		// creating object Anwer
		Answers ans = new Answers();
		ans.setId(201);
		ans.setAnswer("Java is a programming language.");
		ans.setQues(qus);

//		qus.setAnswer(ans);

		// creating object Qustions
		Questions qus2 = new Questions();
		qus2.setId(102);
		qus2.setQuestion("What is Collection Framework?");

		// creating object Anwer
		Answers ans2 = new Answers();
		ans2.setId(202);
		ans2.setAnswer("Collection framework is set api for managing objects.");
		ans2.setQues(qus2);

//		qus2.setAnswer(ans2);

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(qus);
		session.save(ans);
		session.save(qus2);
		session.save(ans2);
		tx.commit();
		
		//fetching the data
		
		Questions newQues=(Questions)session.get(Questions.class, 101);
		System.out.println(newQues.getQuestion());
//		System.out.println(newQues.getAnswer().getAnswer());
		
		Answers ansQues=(Answers)session.get(Answers.class,201);
		System.out.println(ansQues.getAnswer());
		System.out.println(ansQues.getQues().getQuestion());
		factory.close();
		session.close();
	}
}
