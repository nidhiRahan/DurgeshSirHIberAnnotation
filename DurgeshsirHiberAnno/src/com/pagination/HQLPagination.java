package com.pagination;
import com.tut.Student;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HQLPagination {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session s=factory.openSession();
		
		 //pagination means kaha se or kitne tk row chahte ho 
		 
		 Query query=s.createQuery("from Student");
		 //implementing pegination using hibernate
		 query.setFirstResult(2);
		 query.setMaxResults(5);
		 List<Student> list =query.list();
		 for(Student st:list) {
			 System.out.println(st.getName()+" "+st.getId()+" "+st.getCity());
		 }
		s.close();
		 factory.close();
	}

}
