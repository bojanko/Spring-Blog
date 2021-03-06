<%@tag description="Page template" pageEncoding="UTF-8"%>
<%@attribute name="title"%>
<%@attribute name="page"%>
<%@attribute name="txt"%>
<%@attribute name="content" fragment="true" %>
<%@attribute name="sidebar" fragment="true" %>


<html>
<head>
	<title>${title}</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/stil.css" />
</head>
<body>

<%@include file='commons/navbar.jsp'%>

<div class="jumbotron">
    <h1 class="text-center">${ title }</h1> 
</div>

<div class="container mt-4">
  <div class="row">
    <div class="col-lg-7 offset-lg-1">
      <jsp:invoke fragment="content"/>
    </div>
    <div class="col-lg-3">
      <jsp:invoke fragment="sidebar"/>
    </div>
  </div>
</div>

<br /><br /><br />

<%@include file='commons/footer.html'%>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>