<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
	<ul class="navbar-nav">
	  ${page eq 'home' ? '<li class="nav-item active">' : '<li class="nav-item">'}
	    <a class="nav-link" href="${pageContext.servletContext.contextPath}/">Home</a>
	  </li>
	  ${page eq 'about' ? '<li class="nav-item active">' : '<li class="nav-item">'}
	    <a class="nav-link" href="${pageContext.servletContext.contextPath}/about">About</a>
	  </li>
	  ${page eq 'contact' ? '<li class="nav-item active">' : '<li class="nav-item">'}
	    <a class="nav-link" href="${pageContext.servletContext.contextPath}/contact">Contact</a>
	  </li>
	  <li class="nav-item dropdown">
	    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	      Menu
	    </a>
	    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
		    <security:authorize access="isAnonymous()">
		    	<a class="dropdown-item" href="${pageContext.servletContext.contextPath}/login">Log In</a>
		    	<a class="dropdown-item" href="${pageContext.servletContext.contextPath}/register">Register</a>
		    </security:authorize>
		    
		    <security:authorize access="hasRole('ROLE_USER')">
		    	<a class="dropdown-item" href="${pageContext.servletContext.contextPath}/profile">My Profile</a>
		    </security:authorize>
		    
		    <security:authorize access="hasRole('ROLE_ADMIN')">
		    	<a class="dropdown-item" href="${pageContext.servletContext.contextPath}/admin/moderate">
		    	Admin Menu</a>
		    </security:authorize>
		    
		    <security:authorize access="isAuthenticated()">
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