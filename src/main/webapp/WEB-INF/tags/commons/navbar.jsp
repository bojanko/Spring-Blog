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
	      <a class="dropdown-item" href="#">Action</a>
	      <a class="dropdown-item" href="#">Another action</a>
	      <a class="dropdown-item" href="#">Something else here</a>
	    </div>
	  </li>
	</ul>
</nav>