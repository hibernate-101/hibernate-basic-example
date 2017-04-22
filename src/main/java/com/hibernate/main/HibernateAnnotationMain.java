package com.hibernate.main;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.model.EmployeeAnnotation;
import com.hibernate.util.HibernateUtil;

public class HibernateAnnotationMain {
	public static void main(String[] args) {
		EmployeeAnnotation emp = new EmployeeAnnotation();
		emp.setEmpName("John");
		emp.setEmpRole("SE");
		emp.setInsertTime(new Date());

		SessionFactory sessionFactory = HibernateUtil
				.getSessionAnnotationFactory();
		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();// without tg]his you cannot call save

		session.save(emp);// save is not valid without active transaction

		session.getTransaction().commit();// otherwise commit you wont able to see data in ur db
		System.out.println("Employee ID=" + emp.getEmpId());

		sessionFactory.close();
	}

}
