<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@taglib prefix="temps" tagdir="/WEB-INF/tags" %>


<temps:page_template>
	<jsp:attribute name="title"><c:out value="${ post.getTitle() }" /></jsp:attribute>
	<jsp:attribute name="page">post</jsp:attribute>
	
	<jsp:attribute name="content">
	<!-- SHOW POST -->
       <p><c:out value="${ post.getText() }"/></p>
	</jsp:attribute>
	
	<jsp:attribute name="sidebar">
		<jsp:include page="/posts_widget" />
	</jsp:attribute>
</temps:page_template>