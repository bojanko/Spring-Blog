package com.blog.spring.security;

import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	protected Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public CustomUser getUserByUsername(String username){
		Query query = getCurrentSession().createQuery("from CustomUser u where u.username = :un");
		query.setParameter("un", username);
		return (CustomUser) query.uniqueResult();
	}
	
	public void addUser(CustomUser u){
		getCurrentSession().save(u);
	}
	
	public void updateUser(CustomUser u){
		getCurrentSession().update(u);
	}
	
	public void deleteUser(CustomUser u){
		getCurrentSession().delete(u);
	}
}
