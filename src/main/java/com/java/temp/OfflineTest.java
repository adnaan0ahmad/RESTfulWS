package com.java.temp;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.java.bean.RestAssuredClient;
import com.java.bean.User;
import com.java.dao.DAOImpl;

public class OfflineTest {

	public static void main(String[] args) {
		
		List<User> l = RestAssuredClient.getListOfUsers();
		/*System.out.println(l);
		Configuration c = new Configuration();
		SessionFactory sf = c.configure().buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		for (User u : l) {
			s.save(u);
		}
		t.commit();
		s.close();*/
		
	
		
		
		
		

		
		
	}

}
