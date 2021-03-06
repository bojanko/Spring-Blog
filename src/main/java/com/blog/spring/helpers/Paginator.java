package com.blog.spring.helpers;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Paginator<T> {
	private int page_count;
	private int page;
	private int per_page;
	private List<T> data;
	
	private int prev;
	
	public int getPrev(){
		return prev;
	}
	
	public String getPrevURL(){
		return prev == 0 ? "#" : ( prev == 1 ? "/" : "/page/" + prev );
	}
	
	private int link1;
	
	public int getLink1(){
		return link1;
	}
	
	public String getLink1URL(){
		return link1 == 1 ? "/" : "/page/" + link1;
	}
	
	private int link2;
	
	public int getLink2(){
		return link2;
	}
	
	public String getLink2URL(){
		return "/page/" + link2;
	}
	
	private int link3;
	
	public int getLink3(){
		return link3;
	}
	
	public String getLink3URL(){
		return "/page/" + link3;
	}
	
	private int next;
	
	public int getNext(){
		return next;
	}
	
	public String getNextURL(){
		return next == 0 ? "#" : "/page/" + next;
	}
	
	private String active_link;
	
	public String getActiveLink(){
		return active_link;
	}
	
	
	private void paginate(){
		if(page == 1){
			prev = 0;
			link1 = page;
			link2 = page_count > page ? page + 1 : 0;
			link3 = page_count > page + 1 ? page + 2 : 0;
			next = page_count > page ? page + 1 : 0;
			
			active_link = "l1";
		}
		else if(page > 1 && page < page_count){
			prev = page - 1;
			link1 = page - 1;
			link2 = page;
			link3 = page + 1;
			next = page + 1;
			
			active_link = "l2";
		}
		else{
			prev = page - 1;
			link1 = page - 1;
			link2 = page;
			link3 = 0;
			next = 0;
			
			active_link = "l2";
		}
	}
	
	public Paginator(){
	}
	
	public void setData(List<T> d, int p){
		per_page = 5;
		page = p;
		data = d;
		page_count = (int) Math.ceil( (double) data.size() / per_page );
		paginate();
	}
	
	public void setData(List<T> d, int c, int p){
		per_page = c;
		page = p;
		data = d;
		page_count = (int) Math.ceil( (double) data.size() / per_page );
		paginate();
	}
}
