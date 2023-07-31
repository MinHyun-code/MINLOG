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
   	        <div class="col-sm-6">
  	        	<div style="width: 100%; padding-top: 55.11%; position: relative;">
					<div style="width: 100%; height: 100%; position: absolute; left: 0px; top: 0px;">
						<div class="div-write5">
							<svg width="107" height="85" fill="none" viewBox="0 0 107 85"><path fill="#868E96" d="M105.155 0H1.845A1.844 1.844 0 0 0 0 1.845v81.172c0 1.02.826 1.845 1.845 1.845h103.31A1.844 1.844 0 0 0 107 83.017V1.845C107 .825 106.174 0 105.155 0zm-1.845 81.172H3.69V3.69h99.62v77.482z"></path><path fill="#868E96" d="M29.517 40.84c5.666 0 10.274-4.608 10.274-10.271 0-5.668-4.608-10.276-10.274-10.276-5.665 0-10.274 4.608-10.274 10.274 0 5.665 4.609 10.274 10.274 10.274zm0-16.857a6.593 6.593 0 0 1 6.584 6.584 6.593 6.593 0 0 1-6.584 6.584 6.591 6.591 0 0 1-6.584-6.582c0-3.629 2.954-6.586 6.584-6.586zM12.914 73.793a1.84 1.84 0 0 0 1.217-.46l30.095-26.495 19.005 19.004a1.843 1.843 0 0 0 2.609 0 1.843 1.843 0 0 0 0-2.609l-8.868-8.868 16.937-18.548 20.775 19.044a1.846 1.846 0 0 0 2.492-2.72L75.038 31.846a1.902 1.902 0 0 0-1.328-.483c-.489.022-.95.238-1.28.6L54.36 51.752l-8.75-8.75a1.847 1.847 0 0 0-2.523-.081l-31.394 27.64a1.845 1.845 0 0 0 1.22 3.231z"></path></svg>
							<input type="button" class="btn-write0" onclick="onClickUpload()" value="이미지 업로드"/>
						</div>
					</div>
				</div>
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