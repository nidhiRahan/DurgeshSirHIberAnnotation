package com.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Hql2Example {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session s=factory.openSession();
        Transaction tx=s.beginTransaction();
        
        //delete query
//       Query q= s.createQuery("delete from Student s where s.city=:c");
//       q.setParameter("c","satna");
//     int r=  q.executeUpdate();
//      System.out.println("deleted:"); 
//      System.out.println(r);
        
        //update query
//       Query q= s.createQuery("update Student set city=:c where name=:n");
//        q.setParameter("c", "Dilhi");
//        q.setParameter("n", "Rina");
//        int r=q.executeUpdate();
//        System.out.println(r+"objects update");
        
        //how to execute join query
       Query q1= s.createQuery("select q.question,q.questionId,a.answer from Question as q Inner Join q.answer as a");
       List<Object []> list1=  q1.list();
       for(Object[] arr:list1) {
    	   System.out.println(Arrays.toString(arr));
       }
      tx.commit();
       s.close();
       factory.close();
	}
	

}
