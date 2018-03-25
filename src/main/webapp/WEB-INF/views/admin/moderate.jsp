<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@taglib prefix="temps" tagdir="/WEB-INF/tags" %>

<temps:page_admin_template>
	<jsp:attribute name="title">Moderate comments</jsp:attribute>
	<jsp:attribute name="page">admin</jsp:attribute>

	<jsp:attribute name="content">
		<c:forEach var="comment" items="${ comments }">
			<c:if test="${ comment.getAllowed() == null }">
				<h2><c:out value="${ comment.getName() }"></c:out></h2>
				<h3>Email: <c:out value="${ comment.getEmail() }"></c:out></h3>
				<p><c:out value="${ comment.getText() }"></c:out></p>
				
				<div class="container mt-4">
				  <div class="row">
				    <div class="col-lg-6">
						<a class="btn btn-dark btn-lg btn-block text-light"
						href="${pageContext.servletContext.contextPath}/admin/moderate/block/
						${ comment.getId() }">Block</a>
						<br />
				    </div>
				    <div class="col-lg-6">
						<a class="btn btn-dark btn-lg btn-block text-light"
						href="${pageContext.servletContext.contextPath}/admin/moderate/allow/
						${ comment.getId() }">Approve</a>
						<br />
				    </div>
				  </div>
				</div>
				
				<br />
			</c:if>
		</c:forEach>
	</jsp:attribute>
	
	<jsp:attribute name="sidebar">
		Moderate comments entered by users.
	</jsp:attribute>
</temps:page_admin_template>