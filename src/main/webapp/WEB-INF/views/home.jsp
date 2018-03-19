<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@taglib prefix="temps" tagdir="/WEB-INF/tags" %>

<temps:page_template>
	<jsp:attribute name="title"><c:out value="${title}" /></jsp:attribute>
	<jsp:attribute name="page"><c:out value="${page}" /></jsp:attribute>
	
	<jsp:attribute name="content">
		example content
	</jsp:attribute>
	
	<jsp:attribute name="sidebar">
		example sidebar
	</jsp:attribute>
</temps:page_template>