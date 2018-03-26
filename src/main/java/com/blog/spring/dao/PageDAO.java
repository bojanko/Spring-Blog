package com.blog.spring.dao;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blog.spring.models.Page;

@Repository
@Transactional
public class PageDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	protected Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}

	public Page getPageByName(String name){
		Query query= sessionFactory.getCurrentSession().createQuery("from Page where page_name=:name");
		query.setParameter("name", name);
		return (Page) query.uniqueResult();
	}
	
	public void addPage(Page p){
		getCurrentSession().save(p);
	}
	
	public void updatePage(Page p){
		getCurrentSession().update(p);
	}
	
	public void deletePage(Page p){
		getCurrentSession().delete(p);
	}
}
