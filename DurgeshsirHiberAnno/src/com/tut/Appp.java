package com.tut;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class Appp {
public static void main( String[] args ) throws IOException
		    {
		        System.out.println( "Projected Started!" );
		        Configuration cfg=new Configuration();
		        cfg.configure("hibernate.cfg.xml");
		        SessionFactory factory=cfg.buildSessionFactory();
		        System.out.println(factory);
		       //creating student
		        Student st=new Student();
		        st.setId(101);
		        st.setName("NIDHI");
		        st.setCity("INDORE");
		        System.out.println(st);
		        
		        //creating object of Address class
		        Address ad=new Address();
		        ad.setStreet("street1");
		        ad.setCity("lucknow");
		        ad.setOpen(true);
		        ad.setAddedDate(new Date());
		        ad.setX(01223.4);
		        
		        
		        
		     Session session=factory.openSession();
		        
		        Transaction tx=session.beginTransaction();
		        session.save(st);
		        session.save(ad);
		        //for data physical changes commit use
		        tx.commit();
		        session.close();
		        System.out.println("Done...");
		    }
		}

