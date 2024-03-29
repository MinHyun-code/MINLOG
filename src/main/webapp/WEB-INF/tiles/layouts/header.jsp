<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!-- jstl -->
<header>
	<div id="header">
      <div class="d-flex flex-wrap align-items-center justify-content-lg-start header-div2">
        <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
        	<img src="${pageContext.request.contextPath}/img/logo.png" alt="" style="width: 180px; height: 60px; padding-right: 10px;">
        </a>

        <ul class="nav col-lg-auto me-lg-auto mb-2 mb-md-0">
        </ul>
		<form id="frmHeader" method="post">
       	</form>
        
        <sec:authorize access="isAuthenticated()">
			<button type="button" class="header-btn header-btn-media" onclick="writePageMove()">새 글 작성</button>
        </sec:authorize>

		<sec:authorize access="isAnonymous()">
	          <button type="button" class="header-btn" onclick="forwardLogin()">로그인</button>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
        <sec:authentication property="principal" var="user"/> 
        <div style="cursor: pointer;" onclick="menuDisplay()">
	        <div id="menuBtn" class="sc-fFeiMQ cniJzc">
	        	<img class="card-img-custom4" src="${user.userImg}" onerror="src='/img/default_user.png'"/><svg stroke="currentColor" fill="currentColor" stroke-width="0" viewBox="0 0 24 24" height="1em" width="1em" xmlns="http://www.w3.org/2000/svg"><path d="M7 10l5 5 5-5z"></path></svg>
	        </div>
        </div>
       	<div id="menuDiv" style="display: none; position: absolute; right:1vw; top: 65px; z-index: 100; background-color: white; box-shadow: rgba(0, 0, 0, 0.1) 0px 0px 8px;">
			<ul style="margin: 0 auto; padding-left: 0px;">
           		<li style="list-style: none;"><button type="button" class="btn me-2 boardWriteMedia" style="width: 100%; text-align: left;" onclick="writePageMove()">새 글 작성</button></li>
           		<li style="list-style: none;"><button type="button" class="btn me-2" style="width: 100%; text-align: left;">내 민로그</button></li>
           		<li style="list-style: none;"><button type="button" class="btn me-2" style="width: 100%; text-align: left;">읽기 목록</button></li>
           		<li style="list-style: none;"><button type="button" onclick="forwardSetting()" class="btn me-2" style="width: 100%; text-align: left;">설정</button></li>
           		<li style="list-style: none;"><button type="button" class="btn me-2" style="width: 100%; text-align: left;" onclick="forwardLogOut()">로그아웃</button></li>
			</ul>
		</div>
       	</sec:authorize>
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
		});
		
		// 외부영역 클릭 시 팝업 닫기
		$(document).mouseup(function (e){
			var menuBtn = $('#menuBtn');
			if(menuBtn.has(e.target).length === 0){
				$('#menuDiv').hide();
			}
		});
		
    	function forwardLogin() {
    		location.href="/login";
    	}
    	
    	function forwardLogOut() {
    		if(confirm("로그아웃 하시겠습니까?")) {
        		location.href="/logout/action";
    		} else {
    			return false;
    		}
    	}
    	// 게시글 작성 페이지 이동
        function writePageMove() {
        	$("#frmHeader").attr("action","/write").submit();
        }
    	
    	function menuDisplay() {
			$('#menuDiv').toggle();
    	}
    	
    	function forwardSetting() {
			window.location.href = "/setting";
    	}
    </script>
  </header>