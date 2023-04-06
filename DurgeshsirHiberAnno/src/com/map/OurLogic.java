package com.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OurLogic {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
        Session session=factory.openSession();
		Transaction tex=session.beginTransaction();
		Question q1=new Question();
		q1.setQuestionId(100);
		q1.setQuestion("what is java");
		
		Answer a1=new Answer();
		a1.setAnswerId(111);
		a1.setAnswer("java is a language ");
		q1.setAnswer(a1);
		a1.setQuestion(q1);
		
		Question q2=new Question();
		q2.setQuestionId(101);
		q2.setQuestion("what is collection");
		
		Answer a2=new Answer();
		a2.setAnswerId(112);
		a2.setAnswer("java is a set of class and interface ");
		q2.setAnswer(a2);
		a2.setQuestion(q2);
		session.save(q1);
		session.save(q2);
		session.save(a1);
		session.save(a2);
		tex.commit();
		//fetching
		Question newQ=(Question)session.get(Question.class,100);
		System.out.println(newQ.getQuestion());
		System.out.println(newQ.getAnswer().getAnswer());
		session.close();
		factory.close();
	}

}
