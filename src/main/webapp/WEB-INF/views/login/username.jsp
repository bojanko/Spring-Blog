<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@taglib prefix="temps" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<temps:page_template>
	<jsp:attribute name="title">Enter your username</jsp:attribute>
	<jsp:attribute name="page">register</jsp:attribute>
	
	<jsp:attribute name="content">
		<form name='f' action="${flowExecutionUrl}" method="post">
			<!-- CSRF TOKEN  -->
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<!--  -->
			
			<c:if test="${ param.error }">
				<div class="alert alert-danger">Username already used!</div>
			</c:if>
			
			<h3>Your username</h3>
			<input class="form-control" type="text" name='username' value=''/>
			<br />
					
			<div class="container mt-4">
			  <div class="row">
			    <div class="col-lg-6">
					<button class="btn btn-dark btn-lg btn-block"
						name="_eventId_cancel" value="cancel">Cancel</button>
			    </div>
			    <div class="col-lg-6">
					<button class="btn btn-dark btn-lg btn-block"
						name="_eventId_check" value="check">Check</button>
			    </div>
			  </div>
			</div>

		</form>
	</jsp:attribute>
	
	<jsp:attribute name="sidebar">
		<p>Enter your desired username.</p>
	</jsp:attribute>
</temps:page_template>