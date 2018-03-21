package com.blog.spring.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blog.spring.models.Post;

@Repository
@Transactional
public class PostDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	protected Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}

	public Post getPostById(int id){
		return (Post) getCurrentSession().get(Post.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Post> getAllPosts(){
		Query query = getCurrentSession().createQuery("from Post");
		return ((List<Post>) ((List<?>) query.list()));
	}
	
	public void addPost(Post p){
		getCurrentSession().save(p);
	}
	
	public void updatePost(Post p){
		getCurrentSession().update(p);
	}
	
	public void deletePost(Post p){
		getCurrentSession().delete(p);
	}
}
