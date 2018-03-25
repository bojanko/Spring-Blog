<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@taglib prefix="temps" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="/WEB-INF/tld/escaper" prefix="esc"%>

<temps:page_template>
	
	<jsp:attribute name="content">
		<p>${esc:escaper(txt)}</p>
	</jsp:attribute>
	
	<jsp:attribute name="sidebar">
		<jsp:include page="/posts_widget" />
	</jsp:attribute>
</temps:page_template>