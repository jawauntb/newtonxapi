package com.newtonxproject.daos;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.newtonxproject.beans.User;
import com.newtonxproject.daos.UserDao;
import com.newtonxproject.util.HibernateUtil;

public class UserDaoImpl implements UserDao {
private static Logger logger = Logger.getLogger(UserDaoImpl.class);
	 
	public int insert(User u) {
		logger.info("UserImpl insert method called.");

		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		int user_id = 0;

		try {
			tx = session.beginTransaction();
			session.save(u);
			user_id = u.getUser_id();
			tx.commit();
			logger.info("User object inserted successfully");

		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
				logger.error("User object was NOT inserted");
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return user_id;
	}

	
	public void delete(User u) {
		logger.info("UserImpl delete method called.");

		Session session = HibernateUtil.getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.delete(u);
			tx.commit();
			logger.info("User record deleted successfully");

		} catch (HibernateException e) {
			e.printStackTrace();
			logger.info("Delete method was NOT able to delete Insurance object");
		} finally {
			session.close();
		}

	}

	
	public User returnUser(int user_id) {
		logger.info("UserImpl returnTreatment method called.");
		User u = null;
		Session session = HibernateUtil.getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			u = (User) session.createCriteria(User.class).add(Restrictions.idEq(user_id)).uniqueResult();

		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
				logger.info("User object/record NOT found");
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		logger.info("User object returned successfully.");
		return u;
	}
	
}
