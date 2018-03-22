<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<div>
<h2>Latest posts</h2>
<br />
    <c:forEach var="post" items="${ posts }">
       <h3><a class="text-dark" href="${ pageContext.servletContext.contextPath }/post/${ post.getId() }">
       <c:out value="${ post.getTitle() }"/>
       </a></h3>

       <br />
    </c:forEach>
</div>