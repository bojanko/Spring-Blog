package com.blog.spring.profile;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blog.spring.security.CustomUser;

@Repository
@Transactional
public class AdminRequestDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	protected Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}

	public AdminRequest getAdminRequestByUser(CustomUser user){
		Query query= sessionFactory.getCurrentSession().createQuery("from AdminRequest where user=:user");
		query.setParameter("user", user);
		return (AdminRequest) query.uniqueResult();
	}
	
	public AdminRequest getAdminRequestById(int id){
		Query query= sessionFactory.getCurrentSession().createQuery("from AdminRequest where id=:id");
		query.setParameter("id", id);
		return (AdminRequest) query.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<AdminRequest> getAllAdminRequests(){
		Query query= sessionFactory.getCurrentSession().createQuery("from AdminRequest");
		return ((List<AdminRequest>) ((List<?>) query.list()));
	}
	
	public void addAdminRequest(AdminRequest a){
		getCurrentSession().save(a);
	}
	
	public void updateAdminRequest(AdminRequest a){
		getCurrentSession().update(a);
	}
	
	public void deleteAdminRequest(AdminRequest a){
		getCurrentSession().delete(a);
	}
	
	public void deleteAdminRequestById(int id){
		Query query= sessionFactory.getCurrentSession()
				.createQuery("delete from AdminRequest where id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
	}
}
