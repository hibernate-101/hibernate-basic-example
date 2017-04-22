package com.hibernate.main;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.model.EmployeeAnnotation;
import com.hibernate.util.HibernateUtil;

public class HibernateJavaConfigMain {
	public static void main(String[] args) {
		EmployeeAnnotation emp = new EmployeeAnnotation();
		emp.setEmpName("Lara");
		emp.setEmpRole("Manager");
		emp.setInsertTime(new Date());

		SessionFactory sessionFactory = HibernateUtil
				.getSessionJavaConfigFactory();
		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();

		session.save(emp);

		session.getTransaction().commit();
		System.out.println("Employee ID=" + emp.getEmpId());

		// terminate session factory, otherwise program won't end
		sessionFactory.close();
	}

}
