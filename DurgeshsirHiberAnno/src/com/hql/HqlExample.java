package com.hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tut.Student;

public class HqlExample {
public static void main(String[] args) {
	Configuration cfg=new Configuration();
	cfg.configure("hibernate.cfg.xml");
	SessionFactory factory=cfg.buildSessionFactory();
	Session s=factory.openSession();
	//HQL
    //syntax
	//dynamically
	//String Query="from Student where city='Indore'";
	//aapko projection lena h to -
	//String Query="from Student where city=:x";
	//alias use kr skte ho
	String Query="from Student as s where s.city=:x and s.name=:n";
	Query q=s.createQuery(Query);
	q.setParameter("x","Indore");
	q.setParameter("n","john");
	//single-(Unique)2
	//multiple-list
	List<Student> list =q.list();
	for(Student student:list) {
		System.out.println(student.getName()+" : "+student.getId());
	}
	s.close();
	factory.close();
}
}
