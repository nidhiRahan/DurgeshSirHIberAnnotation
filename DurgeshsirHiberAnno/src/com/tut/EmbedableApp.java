package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbedableApp {

	public static void main(String[] args) {
		System.out.println( "Projected Started!" );
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();
        Student st=new Student();
        st.setCity("Indore");
        st.setId(1001);
        st.setName("Manisha");
      
        Certificate ct=new Certificate();
        ct.setCourse("js");
        ct.setDuration("4 month");
        st.setCerti(ct);
        
        Student st1=new Student ();
        st1.setId(1002);
        st1.setCity("satna");
        st1.setName("Rashi");
        
        Certificate ct1=new Certificate();
        ct1.setCourse("c++");
        ct1.setDuration("1 month");
        st1.setCerti(ct1);
        Session session=factory.openSession();
        Transaction tx=session.beginTransaction();
        session.save(st);
        session.save(st1);
        tx.commit();
        factory.close();
        System.out.println("DOne...!");
	}

}
