package com.blog.spring;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blog.spring.Page;

@Repository
public class PageDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	protected Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}

	public Page getPageByName(String name){
		return (Page) getCurrentSession().get(Page.class, name);
	}
	
	@Transactional
	public void addPage(Page p){
		getCurrentSession().save(p);
	}
	
	@Transactional
	public void updatePage(Page p){
		getCurrentSession().update(p);
	}
	
	public void deletePage(Page p){
		getCurrentSession().delete(p);
	}
}
