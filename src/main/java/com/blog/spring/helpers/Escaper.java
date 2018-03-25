package com.blog.spring.helpers;

public class Escaper {	
	public static String escaper(String str){
		return str.replaceAll("\\<.*?\\>", "")
				.replace("\r\n", "<br />").replace("\n", "<br />").replace("\r", "<br />");
	}
}
