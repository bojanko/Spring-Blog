package com.blog.spring.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blog.spring.models.Comment;

@Repository
@Transactional
public class CommentDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	protected Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public Comment getCommentById(int id){
		return (Comment) getCurrentSession().get(Comment.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Comment> getAllComments(){
		Query query = getCurrentSession().createQuery("from Comment c order by c.id desc");
		return ((List<Comment>) ((List<?>) query.list()));
	}
	
	public void addComment(Comment p){
		getCurrentSession().save(p);
	}
	
	public void updateComment(Comment p){
		getCurrentSession().update(p);
	}
	
	public void deleteComment(Comment p){
		getCurrentSession().delete(p);
	}
}
