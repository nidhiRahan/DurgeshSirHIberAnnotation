package com.sqlquery;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query.*;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SQLExample {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session s=factory.openSession();
        // sql Query
		String q="select * from student";
		 SQLQuery nq = s.createSQLQuery(q);// it will return a native query object
		//s.createQuery(q);//it is use for hql fire 
		List<Object[]> list =nq.list();
		for(Object[] student:list) {
			System.out.println(student[0]+" : "+student[4]);
			//System.out.println(Arrays.toString(student));
		}
		s.close();
		factory.close();
	}
}

