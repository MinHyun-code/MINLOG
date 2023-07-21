<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!-- jstl -->
<header>
	<div id="header">
      <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start" style="padding: 0 50px;">
        <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
        	<img src="${pageContext.request.contextPath}/img/logo.png" alt="" style="width: 180px; height: 60px; padding-right: 10px;">
        </a>

        <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
        </ul>
        
        
		<sec:authorize access="isAnonymous()">			
			<button type="button" class="btn btn-outline-secondary me-2" onclick="location.href='/login'">새 글 작성</button>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
			<button type="button" class="btn btn-outline-secondary me-2" onclick="location.href='/write'">새 글 작성</button>
        </sec:authorize>
        
        
		<button class="btn btn-bd-primary py-2 d-flex align-items-center md-100" id="bd-theme" type="button" aria-expanded="false" data-bs-toggle="dropdown"aria-label="Toggle theme (light)" >
		  <svg class="bi my-1 theme-icon opacity-50" width="1em" height="1em"><use href="#sun-fill"></use></svg>
		</button>
		<ul class="dropdown-menu dropdown-menu-end shadow" aria-labelledby="bd-theme-text">
		  <li>
		    <button type="button" onclick="themeLight()" class="dropdown-item d-flex align-items-center" data-bs-theme-value="light" aria-pressed="true">
		      <svg class="bi me-2 opacity-50 theme-icon" width="1em" height="1em"><use href="#sun-fill"></use></svg>
		      Light
		    </button>
		  </li>
		  <li>
		    <button type="button" onclick="themeDark()" class="dropdown-item d-flex align-items-center" data-bs-theme-value="dark" aria-pressed="false">
		      <svg class="bi me-2 opacity-50 theme-icon" width="1em" height="1em"><use href="#moon-stars-fill"></use></svg>
		      Dark
		    </button>
		  </li>
		</ul>
		
        <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" role="search">
          <input type="search" class="form-control form-control-dark" aria-label="Search">
        </form>
		
		<button type="button" class="btn btn-outline-secondary me-2" onclick="menuDisplay()">⚙️</button>

		<div id="menuDiv" style="display: none; position: absolute; right:1vw; width: 7vw; top: 7.5vh; border-radius: 20px; z-index: 100;">
			<ul style="margin: 0 auto; padding-left: 0px;">
				<sec:authorize access="isAnonymous()">
				          <li style="list-style: none;"><button type="button" class="btn me-2" style="width: 100%;" onclick="forwardLogin()">로그인</button></li>
				          <li style="list-style: none;"><button type="button" class="btn me-2" style="width: 100%;" onclick="forwardSignUp()">회원가입</button></li>
		        </sec:authorize>
		        <sec:authorize access="isAuthenticated()">
<%-- 		            <sec:authentication var="loginName" property="principal.name"/> --%>
<%-- 		            <sec:authentication var="companyName" property="principal.companyName"/> --%>
		            
		            <li style="list-style: none;"><button type="button" class="btn me-2" style="width: 100%;" onclick="forwardLogOut()">로그아웃</button></li>
		        </sec:authorize>
			</ul>
		</div>
      </div>
    </div>
    <script type="text/javascript">
		$(document).ready(function(){
			const currentUrl = window.location.href;
			if(currentUrl == 'http://localhost:8080/') {
				$('#header').addClass('bg-body-tertiary');
			} else {
				$('#header').removeClass('bg-body-tertiary');
			}
// 			var key = getCookie("theme");	 
// 			if(key == "light") {
// 				themeLight();
// 			} else {
// 				themeDark();
// 			}
		});
		
		// 외부영역 클릭 시 팝업 닫기
		$(document).mouseup(function (e){
			var menuDiv = $('#menuDiv');
			if(menuDiv.has(e.target).length === 0){
				$('#menuDiv').hide();
			}
		});
		
    	function forwardLogin() {
    		location.href="/login";
    	}
    	
    	function forwardSignUp() {
    		location.href="/signUp"
    	}
    	
    	function forwardLogOut() {
    		if(confirm("로그아웃 하시겠습니까?")) {
        		location.href="/logout/action";
    		} else {
    			return false;
    		}
    	}
    	
    	function menuDisplay() {
    		if($('#menuDiv').css('display') == 'none') {
    			$('#menuDiv').show();
    		} else {
    			$('#menuDiv').hide();
    		}
    	}
    </script>
  </header>