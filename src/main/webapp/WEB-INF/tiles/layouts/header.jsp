<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>

<header class="p-2 text" style="background-color: darkseagreen;">
    <div class="container">
      <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
        <a href="/board" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
        	<img src="img/logo.png" alt="" style="width: 180px; height: 60px; padding-right: 10px;">
        </a>

        <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
          <li><a href="#" class="nav-link px-2 text-secondary">Home</a></li>
          <li><a href="#" class="nav-link px-2 text-white">Features</a></li>
          <li><a href="#" class="nav-link px-2 text-white">Pricing</a></li>
          <li><a href="#" class="nav-link px-2 text-white">FAQs</a></li>
          <li><a href="#" class="nav-link px-2 text-white">About</a></li>
        </ul>
        
		<button class="btn btn-bd-primary py-2 dropdown-toggle d-flex align-items-center" id="bd-theme" type="button" aria-expanded="false" data-bs-toggle="dropdown" aria-label="Toggle theme (light)">
		  <svg class="bi my-1 theme-icon-active" width="1em" height="1em"><use href="#sun-fill"></use></svg>
		  <span class="visually-hidden" id="bd-theme-text">Toggle theme</span>
		</button>
		<ul class="dropdown-menu dropdown-menu-end shadow" aria-labelledby="bd-theme-text">
		  <li>
		    <button type="button" onclick="themeLight()" class="dropdown-item d-flex align-items-center" data-bs-theme-value="light" aria-pressed="true">
		      <svg class="bi me-2 opacity-50 theme-icon" width="1em" height="1em"><use href="#sun-fill"></use></svg>
		      Light
		      <svg class="bi ms-auto d-none" width="1em" height="1em"><use href="#check2"></use></svg>
		    </button>
		  </li>
		  <li>
		    <button type="button" onclick="themeDark()" class="dropdown-item d-flex align-items-center" data-bs-theme-value="dark" aria-pressed="false">
		      <svg class="bi me-2 opacity-50 theme-icon" width="1em" height="1em"><use href="#moon-stars-fill"></use></svg>
		      Dark
		      <svg class="bi ms-auto d-none" width="1em" height="1em"><use href="#check2"></use></svg>
		    </button>
		  </li>
		</ul>

        <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" role="search">
          <input type="search" class="form-control form-control-dark" aria-label="Search">
        </form>

		<c:choose> 
			<c:when test="${loginUser == null}">
		        <div class="text-end">
		          <button type="button" class="btn btn-outline-light me-2" onclick="forwardLogin()">Login</button>
		          <button type="button" class="btn btn-outline-light me-2" onclick="forwardSignUp()">Sign-up</button>
		        </div>
			</c:when> 
			<c:otherwise> 
				<button type="button" class="btn btn-outline-light me-2" onclick="forwardLogOut()">LogOut</button>
			</c:otherwise>
		</c:choose>
      </div>
    </div>
    <script type="text/javascript">
    	function forwardLogin() {
    		location.href="/login";
    	}
    	
    	function forwardSignUp() {
    		location.href="/signUp"
    	}
    	
    	function forwardLogOut() {
    		location.href="/logout/action";
    	}
    </script>
  </header>