<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div>
	<div>
		<div class="col-md-7" style="margin:0 auto; padding: 5vh;">
	    <h4 class="mb-3">개인정보 수정</h4>
	    <form class="needs-validation" id="myInfoForm">
	   		<input type="hidden" id="status" name=status>
	      <div class="row g-3" style="align-items: center;">
	        <div class="col-12">
	          <label for="userId" class="form-label">이메일</label>
	          <div class="input-group has-validation">
	            <span class="input-group-text">🔒</span>
	            <input type="text" class="form-control" style="color: #21252991;" id="userId" name="userId" readonly="readonly">
	          </div>
	        </div>
	        
	        <div class="col-sm-6">
		      <label for="userServeId" class="form-label">닉네임(영문)</label>
	          <input type="text" class="form-control" id="userServeId" name="userServeId" value="">
	          <label for="userName" class="form-label" style="margin-top:10px;">이름</label>
	          <input type="text" class="form-control" id="userName" name="userName" value="">
	          <label for="userPw" class="form-label" style="margin-top:10px;">비밀번호</label>
	          <input type="password" class="form-control" id="userPw" name="userPw" value="" placeholder="* * * * * * * * * * * * * * * *">
	          <label for="userPw" class="form-label" style="margin-top:10px;">비밀번호 확인</label>
	          <input type="password" class="form-control" id="userPwCheck" value="" placeholder="* * * * * * * * * * * * * * * *">
	          
	        </div>
   	        <div class="col-sm-6">
  	        	<div style="width: 100%; padding-top: 55.11%; position: relative;">
					<div style="width: 100%; height: 100%; position: absolute; left: 0px; top: 0px;">
					<input id="userImgFile" type="file" style="display: none;" onchange="setThumbnail(event)"/>
						<div class="div-write5">
							<svg width="107" height="85" fill="none" viewBox="0 0 107 85"><path fill="#868E96" d="M105.155 0H1.845A1.844 1.844 0 0 0 0 1.845v81.172c0 1.02.826 1.845 1.845 1.845h103.31A1.844 1.844 0 0 0 107 83.017V1.845C107 .825 106.174 0 105.155 0zm-1.845 81.172H3.69V3.69h99.62v77.482z"></path><path fill="#868E96" d="M29.517 40.84c5.666 0 10.274-4.608 10.274-10.271 0-5.668-4.608-10.276-10.274-10.276-5.665 0-10.274 4.608-10.274 10.274 0 5.665 4.609 10.274 10.274 10.274zm0-16.857a6.593 6.593 0 0 1 6.584 6.584 6.593 6.593 0 0 1-6.584 6.584 6.591 6.591 0 0 1-6.584-6.582c0-3.629 2.954-6.586 6.584-6.586zM12.914 73.793a1.84 1.84 0 0 0 1.217-.46l30.095-26.495 19.005 19.004a1.843 1.843 0 0 0 2.609 0 1.843 1.843 0 0 0 0-2.609l-8.868-8.868 16.937-18.548 20.775 19.044a1.846 1.846 0 0 0 2.492-2.72L75.038 31.846a1.902 1.902 0 0 0-1.328-.483c-.489.022-.95.238-1.28.6L54.36 51.752l-8.75-8.75a1.847 1.847 0 0 0-2.523-.081l-31.394 27.64a1.845 1.845 0 0 0 1.22 3.231z"></path></svg>
							<input type="button" class="btn-write0" onclick="onClickUpload()" value="이미지 업로드"/>
						</div>
					</div>
				</div>
   	        </div>
   	        <input type="hidden" id="userImg" name="userImg"/>
	        
	        
	        <div class="col-12">
	          <label for="userIntro" class="form-label">한 줄 소개</label>
	          <input type="text" class="form-control" id="userIntro" name="userIntro">
	        </div>
	      </div>
	      
	      <hr class="my-4">
	      <button class="w-100 btn btn-primary btn-lg" type="button" onclick="signUpAction()" style="background-color: #8fbc8f; border-color: #8fbc8f;">수정</button>
	    </form>
	  </div>
  </div>
  <script type="text/javascript">
  $(document).ready(function(){
		
		$.ajax({
	    	type : "POST",
	        url : "/myInfo",
	        success : function(res){
	        	var myInfo = res.data;
	        	$('#userId').val(myInfo.userId);
	        	$('#userServeId').val(myInfo.userServeId);
	        	$('#userName').val(myInfo.userName);
	        	$('#userIntro').val(myInfo.userIntro);
	        	$('#status').val(myInfo.status);
	        	if(myInfo.userImg != "") {
	                var img = document.createElement("img");
	                img.className = 'thumbnail';
	                img.setAttribute("src", myInfo.userImg);
	                img.setAttribute("onclick", "onClickUpload()");
	                $(".div-write5").empty();
	                document.querySelector(".div-write5").appendChild(img);
	        	}
       			$('#userImg').val(myInfo.userImg);
	        },
	        error : function(XMLHttpRequest, textStatus, errorThrown){
	            toastr.error("관리자에게 문의 부탁드립니다.")
	        }
	    });
	});
  
	// 회원가입
	function signUpAction() {
		
		if($('#userId').val() == "") {
			toastr.warning("이메일은 필수 입력입니다.");
			return;
		} else if($('#userServeId').val() == "") {
			toastr.warning("닉네임은 필수 입력입니다.");
			return;
		} else if($('#userName').val() == "") {
			toastr.warning("이름은 필수 입력입니다.");
			return;
		}
		
		// 비밀번호 확인
		if($('userPw').val() != undefined && ($('#userPwCheck').val() != $('#userPw').val())) {
			toastr.warning("비밀번호가 다릅니다. 다시 작성하세요.");
			$('#userPwCheck').focus();
			return; 
		}
		
		
		if($('#userId').val().length > 50) {
			toastr.warning("이메일은 50자 이내로 작성하여야 합니다.");
			return; 
		}
		
		if($('#userServeId').val().length > 15){
			toastr.warning("닉네임은 15자 이내로 작성하여야 합니다.");
			return; 
		}
		
		if($('#userName').val().length > 30){
			toastr.warning("이름은 30자 이내로 입력하여야 합니다.");
			return; 
		}
		
		if($('#userIntro').val().length > 100) {
			toastr.warning("자기소개는 100자 이내로 입력하여야 합니다.");
			return;
		}
		
// 		이메일 정규식
		let regexMail = new RegExp('[a-z0-9]+@[a-z]+\.[a-z]{2,3}');
		if(!regexMail.test($('#userId').val())) {
			toastr.warning("올바른 이메일 형식을 입력하세요.");
			return;
		}

// 		비밀번호 정규식
		let regexPassword = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&#.~_-])[A-Za-z\d@$!%*?&#.~_-]{8,20}$/;
		if($('userPw').val() != undefined && !regexPassword.test($('#userPw').val())) {
			toastr.warning("최소 8 자 및 최대 20 자 <br/>하나 이상의 대문자, 소문자, 숫자, 특수문자 필수 입력입니다.");
			return;
		}
		
		var params = $('#myInfoForm').serialize();
		
   		$.ajax({
	    	type : "POST",
	        url : "/myInfo/update",
	        data : params,
	        success : function(res){
	           	if(res.resultCode == "success") {
	           		alert("성공적으로 변경하였습니다. 다시 로그인해주세요.");
	        		location.href="/logout/action";
	           		
	           	} else if(res.resultCode == "fail") {
	           		toastr.error(res.resultMessage);
	           	}
	        },
	        error : function(XMLHttpRequest, textStatus, errorThrown){
	        	toastr.error("통신 실패.")
	        }
	    });
	}
	
	// 썸네일 이미지 업로드 버튼 이벤트
    function onClickUpload() {
        let myInput = document.getElementById("userImgFile");
        myInput.click();
    }
	
    function setThumbnail(event) {
        var reader = new FileReader();

        reader.onload = function(event) {
          var img = document.createElement("img");
          img.className = 'thumbnail';
          img.setAttribute("src", event.target.result);
          img.setAttribute("onclick", "onClickUpload()");
          $(".div-write5").empty();
          document.querySelector(".div-write5").appendChild(img);
        };

        reader.readAsDataURL(event.target.files[0]);

    	imageFile = event.target.files[0];
		
		var customPath = "user/";

		var formData = new FormData();
		formData.append("image", imageFile);
		formData.append("customPath", customPath);
		
    	let url = '/images/' + customPath;
        
        $.ajax({
       		type: 'POST',
       		enctype: 'multipart/form-data',
       		url: '/imgSave',
       		data: formData,
       		dataType: 'json',
       		processData: false,
       		contentType: false,
       		success: function(data) {
       			url += data.filename;
       			var userImg = url;
       			$('#userImg').val(userImg);
       		},
       		error: function(e) {
       			console.log(e);
       		}
       	});
      }
	
  </script>
</div>