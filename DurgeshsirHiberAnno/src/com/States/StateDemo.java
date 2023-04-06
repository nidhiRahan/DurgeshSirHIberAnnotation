package com.States;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tut.Certificate;
import com.tut.Student;

public class StateDemo {

	public static void main(String[] args) {
		//Practical of hibernate object States
		//Transient
		//persistent
		//Detached
		//Removed
		System.out.println("Example:");
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		//Student object
		Student stu=new Student();
		stu.setId(1222);
		stu.setCity("Indore");
		stu.setName("Peter");
		stu.setCerti(new Certificate("java hibernate Course","2 month"));
		//student:Transient-not in session and database
		
		Session session=factory.openSession();
		Transaction tex=session.beginTransaction();
		session.save(stu);//persistent State-session,database
		
		stu.setName("John");
		tex.commit();
		session.close();
		//detached state

		stu.setName("sachin");	
		System.out.println("sachin");
	factory.close();
	}

}
