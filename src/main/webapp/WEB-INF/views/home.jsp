<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@taglib prefix="temps" tagdir="/WEB-INF/tags" %>


<temps:page_template>
	<jsp:attribute name="title"><c:out value="${title}" /></jsp:attribute>
	<jsp:attribute name="page"><c:out value="${page}" /></jsp:attribute>
	
	<jsp:attribute name="content">
	<!-- LIST OF POSTS -->
    <c:forEach var="post" items="${ posts }">
       <h2><a class="text-dark" href="${ pageContext.servletContext.contextPath }/post/${ post.getId() }">
       <c:out value="${ post.getTitle() }"/>
       </a></h2>
       
       <p><c:out value="${ post.getText() }"/></p>
       
       <a href="${ pageContext.servletContext.contextPath }/post/${ post.getId() }"
       class="btn btn-dark btn-lg btn-block">Show post</a>
       
       <br /><br />
    </c:forEach>
    
    <br /><br />
	
	<!-- PAGINATION  -->
		<nav aria-label="Page navigation example">
		  <ul class="pagination justify-content-center">
		  	<c:if test="${ paginator.getPrev() != 0 }">
		  		<li class="page-item">
		    		<a class="page-link" 
		    		href="${ pageContext.servletContext.contextPath }${ paginator.getPrevURL() }">
		    		Previous</a>
		    	</li>
		  	</c:if>
		  	<c:if test="${ paginator.getLink1() != 0 }">
		  		<li class="page-item${ paginator.getActiveLink() == 'l1' ? ' active' : '' }">
		    		<a class="page-link" 
		    		href="${ pageContext.servletContext.contextPath }${ paginator.getLink1URL() }">
		    		${ paginator.getLink1() }</a>
		    	</li>
		  	</c:if>
		  	<c:if test="${ paginator.getLink2() != 0 }">
		  		<li class="page-item${ paginator.getActiveLink() == 'l2' ? ' active' : '' }">
		    		<a class="page-link" 
		    		href="${ pageContext.servletContext.contextPath }${ paginator.getLink2URL() }">
		    		${ paginator.getLink2() }</a>
		    	</li>
		  	</c:if>
		  	<c:if test="${ paginator.getLink3() != 0 }">
		  		<li class="page-item">
		    		<a class="page-link" 
		    		href="${ pageContext.servletContext.contextPath }${ paginator.getLink3URL() }">
		    		${ paginator.getLink3() }</a>
		    	</li>
		  	</c:if>
		  	<c:if test="${ paginator.getNext() != 0 }">
		  		<li class="page-item">
		    		<a class="page-link" 
		    		href="${ pageContext.servletContext.contextPath }${ paginator.getNextURL() }">
		    		Next</a>
		    	</li>
		  	</c:if>
		  </ul>
		</nav>
	</jsp:attribute>
	
	<jsp:attribute name="sidebar">
		<p><c:out value="${txt}"></c:out></p>
		example sidebar
	</jsp:attribute>
</temps:page_template>