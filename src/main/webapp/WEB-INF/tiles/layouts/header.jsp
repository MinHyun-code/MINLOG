<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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

        <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" role="search">
          <input type="search" class="form-control form-control-dark" aria-label="Search">
        </form>

        <div class="text-end">
          <button type="button" class="btn btn-outline-light me-2" onclick="forwardLogin()">Login</button>
          <button type="button" class="btn btn-outline-light me-2" onclick="forwardSignUp()">Sign-up</button>
        </div>
      </div>
    </div>
    <script type="text/javascript">
    	function forwardLogin() {
    		location.href="/login";
    	}
    	
    	function forwardSignUp() {
    		location.href="/signUp"
    	}
    
    </script>
  </header>