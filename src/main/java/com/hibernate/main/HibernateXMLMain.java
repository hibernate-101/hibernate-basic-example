package com.hibernate.main;

import java.util.Date;

import org.hibernate.Session;

import com.hibernate.model.Employee;
import com.hibernate.util.HibernateUtil;

public class HibernateXMLMain {
	public static void main(String[] args) {
		Employee emp = new Employee();
		emp.setEmpName("Chris");
		emp.setEmpRole("SSE");
		emp.setInsertTime(new Date());

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		session.beginTransaction();

		session.save(emp);

		//session.getTransaction().commit();
		System.out.println("Employee ID=" + emp.getEmpId());

		HibernateUtil.getSessionFactory().close();
	}

}
