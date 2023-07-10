<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div>
	<div style="min-height: 1150px" class="container">
		<div class="col-md-7" style="margin:0 auto; padding: 5vh;">
	    <h4 class="mb-3">회원가입</h4>
	    <form class="needs-validation" id="signUpForm">
	      <div class="row g-3">
	      
	        <div class="col-12">
	          <label for="userId" class="form-label">이메일</label>
	          <div class="input-group has-validation">
	            <span class="input-group-text">🔒</span>
	            <input type="text" class="form-control" id="userId" name="userId">
	          </div>
	        </div>
	        
	        <div class="col-sm-6">
	          <label for="userName" class="form-label">이름</label>
	          <input type="text" class="form-control" id="userName" name="userName" value="">
	          <label for="userPw" class="form-label">비밀번호</label>
	          <input type="password" class="form-control" id="userPw" name="userPw">
	        </div>
	        
	        <div class="col-12">
	          <label for="userIntro" class="form-label">한 줄 소개</label>
	          <input type="text" class="form-control" id="userIntro" name="userIntro">
	        </div>
	      </div>
	      
	      <hr class="my-4">
	      <button class="w-100 btn btn-primary btn-lg" type="button" onclick="signUpAction()" style="background-color: #8fbc8f; border-color: #8fbc8f;">회원가입</button>
	    </form>
	  </div>
  </div>
  <script type="text/javascript">
  
	// 회원가입
	function signUpAction() {
		
		if($('#userId').val() == "") {
			alert("이메일은 필수 입력입니다.");
			return false;
		} else if($('#userPw').val() == "") {
			alert("비밀번호는 필수 입력입니다.");
		} else if($('#userName').val() == "") {
			alert("이름은 필수 입력입니다.");
		}
		
		var params = $('#signUpForm').serialize();
		
   		$.ajax({
	    	type : "POST",
	        url : "/signUp/action",
	        data : params,
	        success : function(res){
	           	if(res.resultCode == "success") {
	           		alert(res.resultMessage);
	            	window.location.href = "/login";
	            	
	           	} else if(res.resultCode == "fail") {
	           		alert(res.resultMessage);
	           	}
	        },
	        error : function(XMLHttpRequest, textStatus, errorThrown){
	            alert("통신 실패.")
	        }
	    });
	}
	
  </script>
</div>