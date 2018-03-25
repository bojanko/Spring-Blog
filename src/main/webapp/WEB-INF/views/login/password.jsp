<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@taglib prefix="temps" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<temps:page_template>
	<jsp:attribute name="title">Enter your password</jsp:attribute>
	<jsp:attribute name="page">register</jsp:attribute>
	
	<jsp:attribute name="content">
		<form:form name='f' action="${flowExecutionUrl}" method="post" modelAttribute="user">
			<!-- CSRF TOKEN  -->
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<!--  -->
			
			<h3>Your password</h3>
			<form:errors class="alert alert-danger" element="div"/>
			<form:errors class="alert alert-danger" element="div" path="password" />
			<form:input class="form-control" type="text" name="password" path="password"></form:input>
			<br />
			<h3>Confirm password</h3>
			<form:errors class="alert alert-danger" element="div" path="password_confirm" />
			<form:input class="form-control" type="text" name="password_confirm"
			path="password_confirm"></form:input>
			<br />
			
			<div class="container mt-4">
			  <div class="row">
			    <div class="col-lg-6">
					<button class="btn btn-dark btn-lg btn-block"
						name="_eventId_cancel" value="cancel">Cancel</button>
			    </div>
			    <div class="col-lg-6">
					<button class="btn btn-dark btn-lg btn-block"
						name="_eventId_register" value="register">Register</button>
			    </div>
			  </div>
			</div>
			
		</form:form>
	</jsp:attribute>
	
	<jsp:attribute name="sidebar">
		<p>Enter your desired password.</p>
	</jsp:attribute>
</temps:page_template>