<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
	<ul class="navbar-nav">
	  <li class="nav-item">
	    <a class="nav-link" href="${pageContext.servletContext.contextPath}/admin/moderate">
		Moderate comments</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" href="${pageContext.servletContext.contextPath}/admin/requests">
	    Admin requests</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" href="${pageContext.servletContext.contextPath}/admin/posts">
	    Posts</a>
	  </li>
	  
	  <li class="nav-item dropdown">
	    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	      Pages
	    </a>
	    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
	    <security:authorize access="hasRole('ROLE_ADMIN')">
	    
	    	<a class="dropdown-item" href="${pageContext.servletContext.contextPath}/admin/page/home">
	    	Home</a>
			<a class="dropdown-item" href="${pageContext.servletContext.contextPath}/admin/page/about">
			About</a>
	    	<a class="dropdown-item" href="${pageContext.servletContext.contextPath}/admin/page/contact">
	    	Contact</a>
	    </security:authorize>
	    </div>
	  </li>

	  <li class="nav-item dropdown">
	    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	      Menu
	    </a>
	    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
	    <security:authorize access="hasRole('ROLE_ADMIN')">
	    
	    	<a class="dropdown-item" href="${pageContext.servletContext.contextPath}/profile">My Profile</a>
			<a class="dropdown-item" href="${pageContext.servletContext.contextPath}/">Back to blog</a>
	    	<br />
		    <form name="f" method="post" action="${pageContext.servletContext.contextPath}/logout">
		      	<!-- CSRF TOKEN  -->
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		      	<button class="btn btn-dark btn-lg btn-block">Log Out</button>
		    </form>
	    </security:authorize>
	    </div>
	  </li>
	</ul>
</nav>