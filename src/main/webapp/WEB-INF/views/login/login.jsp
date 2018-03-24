<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@taglib prefix="temps" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<temps:page_template>
	<jsp:attribute name="title">Login page</jsp:attribute>
	<jsp:attribute name="page">login</jsp:attribute>
	
	<jsp:attribute name="content">
		<form name='f' action="${pageContext.servletContext.contextPath}/perform_login" method="post">
			<!-- CSRF TOKEN  -->
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<!--  -->
			
			<c:if test="${ param.error }">
				<div class="alert alert-danger">Invalid login!</div>
			</c:if>
			
			<h3>Your username</h3>
			<input class="form-control" type="text" name='j_username' value=''/>
			<h3>Your password</h3>
			<input class="form-control" type="password" name='j_password'/>
			<br />
			<button class="btn btn-dark btn-lg btn-block">Log In</button>
		</form>
	</jsp:attribute>
	
	<jsp:attribute name="sidebar">
		<p>Log in with your credentials.</p>
	</jsp:attribute>
</temps:page_template>