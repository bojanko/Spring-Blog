<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@taglib prefix="temps" tagdir="/WEB-INF/tags" %>

<temps:page_admin_template>
	<jsp:attribute name="title">Manage posts</jsp:attribute>
	<jsp:attribute name="page">admin</jsp:attribute>

	<jsp:attribute name="content">
		<c:forEach var="post" items="${ posts }">
			<h2><c:out value="${ post.getTitle() }"></c:out></h2>
			
			<div class="container mt-4">
			  <div class="row">
			    <div class="col-lg-6">
					<a class="btn btn-dark btn-lg btn-block text-light"
					href="${pageContext.servletContext.contextPath}/admin/posts/delete/
					${ post.getId() }">Delete</a>
					<br />
			    </div>
			    <div class="col-lg-6">
					<a class="btn btn-dark btn-lg btn-block text-light"
					href="${pageContext.servletContext.contextPath}/admin/posts/edit/
					${ post.getId() }">Edit</a>
					<br />
			    </div>
			  </div>
			</div>
			
			<br />
		</c:forEach>
		
		<br /><br />
		
	<!-- PAGINATION  -->
		<nav aria-label="Page navigation example">
		  <ul class="pagination justify-content-center">
		  	<c:if test="${ paginator.getPrev() != 0 }">
		  		<li class="page-item">
		    		<a class="page-link" 
		    		href="${ pageContext.servletContext.contextPath }/admin/posts${ paginator.getPrevURL() }">
		    		Previous</a>
		    	</li>
		  	</c:if>
		  	<c:if test="${ paginator.getLink1() != 0 }">
		  		<li class="page-item${ paginator.getActiveLink() == 'l1' ? ' active' : '' }">
		    		<a class="page-link" 
		    		href="${ pageContext.servletContext.contextPath }/admin/posts${ paginator.getLink1URL() }">
		    		${ paginator.getLink1() }</a>
		    	</li>
		  	</c:if>
		  	<c:if test="${ paginator.getLink2() != 0 }">
		  		<li class="page-item${ paginator.getActiveLink() == 'l2' ? ' active' : '' }">
		    		<a class="page-link" 
		    		href="${ pageContext.servletContext.contextPath }/admin/posts${ paginator.getLink2URL() }">
		    		${ paginator.getLink2() }</a>
		    	</li>
		  	</c:if>
		  	<c:if test="${ paginator.getLink3() != 0 }">
		  		<li class="page-item">
		    		<a class="page-link" 
		    		href="${ pageContext.servletContext.contextPath }/admin/posts${ paginator.getLink3URL() }">
		    		${ paginator.getLink3() }</a>
		    	</li>
		  	</c:if>
		  	<c:if test="${ paginator.getNext() != 0 }">
		  		<li class="page-item">
		    		<a class="page-link" 
		    		href="${ pageContext.servletContext.contextPath }/admin/posts${ paginator.getNextURL() }">
		    		Next</a>
		    	</li>
		  	</c:if>
		  </ul>
		</nav>
	</jsp:attribute>
	
	<jsp:attribute name="sidebar">
		Select post for editing or delete post.
		<br /><br />
		<a class="btn btn-dark btn-lg btn-block text-light"
					href="${pageContext.servletContext.contextPath}/admin/posts/insert">
					Insert new post</a>
	</jsp:attribute>
</temps:page_admin_template>