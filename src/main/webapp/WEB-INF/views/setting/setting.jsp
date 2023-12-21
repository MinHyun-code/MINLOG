<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div>
	<div class="" style="margin:0 auto; width: 80%; min-height: 93vh;">
	    <div class="settingDiv1" style="padding-top: 20vh;">
		    <div class="settingDiv2">
	   			<span class="settingSpan1">개인 정보</span>
		   		<span class="settingSpan2">회원가입 시 작성한 개인 정보입니다.</span>
	   			<button class="settingBtn1" onclick="forwardMyInfo()">변경</button>
		   	</div>
		    <div class="settingDiv2">
	   			<span class="settingSpan1">소셜 정보</span>
		   		<span class="settingSpan2">포스트 및 블로그에 보여지는 프로필에 공개되는 소셜 정보입니다.</span>
	   			<button class="settingBtn1" onclick="">변경</button>
		   	</div>
		   	<div class="settingDiv2">
   				<span class="settingSpan1">이메일 주소</span>
		   		<span class="settingSpan2">시스템에서 발송하는 이메일을 수신하는 주소입니다.</span>
  				<button class="settingBtn1">변경</button>
		   	</div>
		   	<div class="settingDiv2">
   				<span class="settingSpan1">이메일 수신 설정</span>
	   			<div class="block-for-mobile">
	   					<ul class="sc-hKumaY ciQAsU">
	   						<li>
	   							<span>댓글 알림</span>
	   							<div class="sc-fSDTwv jUnpEn">
	   								<div class="circle" style="transform:translate(0rem);box-shadow:2px 0 4px rgba(0, 0, 0, 0.050980392156862744)"></div>
	   							</div>
	   						</li>
	   						<li>
	   							<span>벨로그 업데이트 소식</span>
	   							<div class="sc-fSDTwv jUnpEn">
	   								<div class="circle" style="transform:translate(0rem);box-shadow:2px 0 4px rgba(0, 0, 0, 0.050980392156862744)"></div>
	   							</div>
	   						</li>
	   					</ul>
		   		</div>
		   	</div>
		   	<div class="settingDiv2">
 				<span class="settingSpan1">회원 탈퇴</span>
   				<span class="settingSpan2">탈퇴 시 작성하신 포스트 및 댓글이 모두 삭제되며 복구되지 않습니다.</span>
 				<button class="settingBtn2" onclick="accountDel()">회원 탈퇴</button>
		   	</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	
  	// 개인정보 변경 페이지로 이동
	function forwardMyInfo() {
		window.location.href = "/myInfo";
	}
	
  	// 회원 탈퇴 이벤트
  	function accountDel() {
  	    if (!confirm("삭제하면 복구를 할 수 없습니다. 삭제 진행하시겠습니까?")) {
  	    	return;
  	    } else {
  	    	// 삭제 이벤트
  	    }
  	}
	
</script>