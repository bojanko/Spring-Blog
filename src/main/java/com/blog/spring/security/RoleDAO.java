package com.blog.spring.security;

import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class RoleDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	protected Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public CustomRole getRoleByName(String name){
		Query query = getCurrentSession().createQuery("from CustomRole r where r.role = :name");
		query.setParameter("name", name);
		return (CustomRole) query.uniqueResult();
	}
	
	public void addRole(CustomRole r){
		getCurrentSession().save(r);
	}
}
