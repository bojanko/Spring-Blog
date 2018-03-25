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
	public Post getPostByIdWithComments(int id){
		Query query = getCurrentSession().createQuery("from Post p left join FETCH p.comments c WHERE"
				+ " p.id = :id");
		query.setParameter("id", id);
		return (Post) query.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Post> getAllPosts(){
		Query query = getCurrentSession().createQuery("from Post p order by p.id desc");
		return ((List<Post>) ((List<?>) query.list()));
	}
	
	@SuppressWarnings("unchecked")
	public List<Post> getPostsPerPage(int page){
		Query query = getCurrentSession().createQuery("from Post p order by p.id desc");
		List<Post> list = ((List<Post>) ((List<?>) query.list()));
		return list.subList((page - 1) * 5, 5 * page > list.size() ? list.size() : 5 * page );
	}	

	@SuppressWarnings("unchecked")
	public List<Post> getPostsPerPage(int page, int page_size){
		Query query = getCurrentSession().createQuery("from Post p order by p.id desc");
		List<Post> list = ((List<Post>) ((List<?>) query.list()));
		return list.subList((page - 1) * page_size,
				page_size * page > list.size() ? list.size() : page_size * page );
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
