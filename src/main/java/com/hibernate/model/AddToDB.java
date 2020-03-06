package com.hibernate.model;

import java.util.Date;

import javax.persistence.Embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
@Embeddable
public class AddToDB {

	public static void main(String[] args)

	{

		Student s1 = new Student();
		Student s2 = new Student();
		
		Address a=new Address();
		Address a1=new Address();
		Address a2=new Address();
		Address a3=new Address();
		
		Numbers n1=new Numbers();
		Numbers n2=new Numbers();
		//_________
		a.setStreet_name("Teachers Nagar,Chinniampalayam");
		a.setState("Tamilnadu");
		a.setPincode("641062");
		
		a2.setStreet_name("saravanampatti,cbe");
		a2.setState("tamilnadu");
		a2.setPincode("639202");
		
		//____________
		a1.setStreet_name("Cheran Managar,cbe");
		a1.setState("Hyderabad");
		a1.setPincode("641876");
		
		
		a3.setStreet_name("Robert Bosch");
		a3.setState("Tamilnadu");
		a3.setPincode("641543");
		
		//_____________________
		
		n1.setTelephone("232958");
		n1.setPersonal("9003636495");
		n1.setOffice("9444626495");
		
		n2.setTelephone("230145");
		n2.setPersonal("8056506364");
		n2.setOffice("9894598294");
		
		//________________________________
		
		
		
		s1.setHome_address(a);
		s1.setOffice_address(a2);

		s1.setFirstName("Ravina");
		s1.setLastName("Thangavel");
		s1.setEmail("t.ravinacbe@gmail.com");
		s1.setDate_today(new Date());
		s1.setDescription("Ravina is obsessive with coding & easily grasp anything");
		s1.getNumbers().add(n1);
		//__________________________
		s2.setHome_address(a1);
		s2.setOffice_address(a3);

		s2.setFirstName("vikram");
		s2.setLastName("markiv");
		s2.setEmail("vikrammarkiv192@gmail.com");
		s2.setDescription("vikram is a positive person & managing the time very well");
		s2.setDate_today(new Date());
		s2.getNumbers().add(n2);
		

		// create session factory to open hibernate configuration file by
		// configuration() and returns object
		//only one session factory per one project
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(s1);//we surely save the object in session then only values of object will be saved otherwise it will be null
    	session.save(s2);
		session.getTransaction().commit();
		session.close();// close the session here bcoz i again open

		// just pull up the values of s1 object here by passing model entity class &
		// primary key field value
		session = sessionFactory.openSession();
		session.beginTransaction();
		s1 = (Student) session.get(Student.class,2);
		System.out.println(s1.getId());
		System.out.println(s1.getFirstName());

	}
}