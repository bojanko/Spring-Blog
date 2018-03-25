<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@taglib prefix="temps" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<temps:page_template>
	<jsp:attribute name="title">Profile page</jsp:attribute>
	<jsp:attribute name="page">profile</jsp:attribute>
	
	<jsp:attribute name="content">
		<form:form name='f' action="${flowExecutionUrl}" method="post" modelAttribute="user">
			<!-- CSRF TOKEN  -->
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<!--  -->
			
			<c:if test="${success}">
				<div class="alert alert-success">Password changed successfully!</div>
			</c:if>
			
			<h3>Your new password</h3>
			<form:errors class="alert alert-danger" element="div"/>
			<form:errors class="alert alert-danger" element="div" path="password" />
			<form:input class="form-control" type="text" name="password" path="password"></form:input>
			<br />
			<h3>Confirm password</h3>
			<form:errors class="alert alert-danger" element="div" path="password_confirm" />
			<form:input class="form-control" type="text" name="password_confirm"
			path="password_confirm"></form:input>
			<br />
			<button class="btn btn-dark btn-lg btn-block"
						name="_eventId_register" value="register">Change password</button>
			
		</form:form>
	</jsp:attribute>
	
	<jsp:attribute name="sidebar">
		<h2>Granted roles</h2>
	    <!-- LIST OF ROLES -->
	    <c:forEach var="r" items="${ role }">
	       <h3><c:out value="${ r.getAuthority() == 'ROLE_USER' ? 'USER' : 'ADMIN' }"/></h3>
	    </c:forEach>
	    
    	<br />
	    <form name="f" method="post" action="${pageContext.servletContext.contextPath}/profile/admin_rights">
	      	<!-- CSRF TOKEN  -->
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	      	<button class="btn btn-dark btn-lg btn-block">Request admin rights</button>
	    </form>
	</jsp:attribute>
</temps:page_template>