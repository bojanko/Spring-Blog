<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@taglib prefix="temps" tagdir="/WEB-INF/tags" %>

<temps:page_admin_template>
	<jsp:attribute name="title">Admin requests</jsp:attribute>
	<jsp:attribute name="page">admin</jsp:attribute>

	<jsp:attribute name="content">
		<c:forEach var="request" items="${ requests }">
			<c:if test="${ request.getApproved() == null }">
				<h2>Username: <c:out value="${ request.getUser().getUsername() }"></c:out></h2>
	
				<div class="container mt-4">
				  <div class="row">
				    <div class="col-lg-6">
						<a class="btn btn-dark btn-lg btn-block text-light"
						href="${pageContext.servletContext.contextPath}/admin/requests/block/
						${ request.getId() }">Block</a>
						<br />
				    </div>
				    <div class="col-lg-6">
						<a class="btn btn-dark btn-lg btn-block text-light"
						href="${pageContext.servletContext.contextPath}/admin/requests/allow/
						${ request.getId() }">Approve</a>
						<br />
				    </div>
				  </div>
				</div>
				
				<br />
			</c:if>
		</c:forEach>
	</jsp:attribute>
	
	<jsp:attribute name="sidebar">
		Grant admin privileges to other users.
	</jsp:attribute>
</temps:page_admin_template>