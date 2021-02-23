package test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Students;

public class StudentOperation {

	
	public static void main(String[] args) {
		
		
		
		Configuration cfg=new Configuration().configure("cfg/hibernate.cfg.xml").addAnnotatedClass(Students.class);
		
		Session ses= null;
		SessionFactory factory=cfg.buildSessionFactory();
		Transaction tx=null;
		
		ses=factory.openSession();
		
		Query q=ses.createQuery("from Students");
		
		q.setFirstResult(0);
		
		q.setMaxResults(3);
		
		List<Students> list=q.list();
		
		for(Students s: list){
			System.out.println(s.getId()+" : "+s.getStudentName()+" : "+s.getMob()+" : "+s.getGender());
		}
		
		ses.close();
		
		factory.close();
	}
	
}
