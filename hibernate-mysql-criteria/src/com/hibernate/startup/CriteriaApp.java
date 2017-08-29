package com.hibernate.startup;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class CriteriaApp {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Criteria criteria = session.createCriteria(Student.class);
		criteria.add(Restrictions.gt("age", 3));
		criteria.addOrder(Order.desc("school"));

		List students = criteria.list();
		Iterator it = students.iterator();
		while (it.hasNext()) {
			System.out.println(it.next().toString());
		}

		session.getTransaction().commit();
		session.close();
	}
}
