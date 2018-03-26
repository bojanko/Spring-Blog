<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@taglib prefix="temps" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<temps:page_admin_template>
	<jsp:attribute name="title"><c:out value="Update ${post.getTitle()} page" /></jsp:attribute>
	<jsp:attribute name="page"><c:out value="admin" /></jsp:attribute>
	
	<jsp:attribute name="content">
		<form:form method="post" modelAttribute="post">
			<c:if test="${success}">
				<div class="alert alert-success">Post successfully updated!</div>
			</c:if>
			<!-- CSRF TOKEN  -->
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<!--  -->
			<h3>Post title</h3>
			<form:errors class="alert alert-danger" element="div" path="title" />
			<form:input class="form-control" type="text" name="title" path="title"></form:input>
			<h3>Post text</h3>
			<form:errors class="alert alert-danger" element="div" path="text" />
			<form:textarea class="form-control" rows="8" name="text" path="text"></form:textarea>
			<br />
			<form:button class="btn btn-dark btn-lg btn-block">Update post</form:button>
		</form:form>
	</jsp:attribute>
	
	<jsp:attribute name="sidebar">
		Update text of ${post.getTitle()} post.
	</jsp:attribute>
</temps:page_admin_template>