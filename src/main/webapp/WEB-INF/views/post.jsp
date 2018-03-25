<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@taglib prefix="temps" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<temps:page_template>
	<jsp:attribute name="title"><c:out value="${ post.getTitle() }" /></jsp:attribute>
	<jsp:attribute name="page">post</jsp:attribute>
	
	<jsp:attribute name="content">
	<!-- SHOW MESSAGE -->
	<c:if test="${success}">
		<div id="success" class="alert alert-success">
			Comment sent for moderation!
		</div>
	</c:if>
	
	<!-- SHOW POST -->
       <p><c:out value="${ post.getText() }"/></p>
       <br /><br />
       
    <!-- LIST OF COMMENTS -->
    <c:forEach var="comm" items="${ comments }">
       <c:if test="${comm.allowed}">
	       <h2><c:out value="${ comm.getName() }"/></h2>
	       <p><c:out value="${ comm.getText() }"/></p>
	
	       <br /><br />
       </c:if>
    </c:forEach>
    
       <security:authorize access="isAnonymous()">
       		<h2>Log in to comment</h2><br />
       </security:authorize>
       
       <security:authorize access="isAuthenticated()">
      		 <h2>Leave your comment</h2><br />
       
			<form:form method="post" modelAttribute="comment">
				<!-- CSRF TOKEN  -->
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				<!--  -->
				<h3>Your name</h3>
				<form:errors class="alert alert-danger" element="div" path="name" />
				<form:input class="form-control" type="text" name="name" path="name"></form:input>
				<h3>Your E-mail</h3>
				<form:errors class="alert alert-danger" element="div" path="email" />
				<form:input class="form-control" type="text" name="email" path="email"></form:input>
				<h3>Your message</h3>
				<form:errors class="alert alert-danger" element="div" path="text" />
				<form:textarea class="form-control" rows="8" name="text" path="text"></form:textarea>
				<br />
				<form:button class="btn btn-dark btn-lg btn-block">Send comment</form:button>
			</form:form>
       </security:authorize>
	</jsp:attribute>
	
	<jsp:attribute name="sidebar">
		<jsp:include page="/posts_widget" />
	</jsp:attribute>
</temps:page_template>