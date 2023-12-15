
// 테마 변경
function themeLight(){
	document.documentElement.setAttribute('data-bs-theme','light');
	const theme = "light";
	const text = "<svg class=\"bi my-1 theme-icon opacity-50\" width=\"1em\" height=\"1em\"><use href=\"#sun-fill\"></use></svg>";
	document.getElementById('bd-theme').innerHTML = text;
	setCookie("theme", theme, 7); // 7일 동안 쿠키 보관
}
// 테마 변경
function themeDark(){
	document.documentElement.setAttribute('data-bs-theme','dark');
	const theme = "dark";
	const text = "<svg class=\"bi my-1 theme-icon\" width=\"1em\" height=\"1em\"><use href=\"#moon-stars-fill\"></use></svg>";
	document.getElementById('bd-theme').innerHTML = text;
	setCookie("theme", theme, 7); // 7일 동안 쿠키 보관
}

// 쿠키 저장하기 
// setCookie => saveid함수에서 넘겨준 시간이 현재시간과 비교해서 쿠키를 생성하고 지워주는 역할
function setCookie(cookieName, value, exdays) {
	var exdate = new Date();
	exdate.setDate(exdate.getDate() + exdays);
	var cookieValue = escape(value)
			+ ((exdays == null) ? "" : "; expires=" + exdate.toGMTString());
	document.cookie = cookieName + "=" + cookieValue;
}

// 쿠키 삭제
function deleteCookie(cookieName) {
	var expireDate = new Date();
	expireDate.setDate(expireDate.getDate() - 1);
	document.cookie = cookieName + "= " + "; expires="
			+ expireDate.toGMTString();
}
 
// 쿠키 가져오기
function getCookie(cookieName) {
	cookieName = cookieName + '=';
	var cookieData = document.cookie;
	var start = cookieData.indexOf(cookieName);
	var cookieValue = '';
	if (start != -1) { // 쿠키가 존재하면
		start += cookieName.length;
		var end = cookieData.indexOf(';', start);
		if (end == -1) // 쿠키 값의 마지막 위치 인덱스 번호 설정 
			end = cookieData.length;
		cookieValue = cookieData.substring(start, end);
	}
	return unescape(cookieValue);
}

// 좋아요 기능
function boardLike(boardSeq) {
		if($('#loginUserId').val() == null || $('#loginUserId').val() == '') {
			toastr.error("로그인 후 이용해주세요.");
			return false;
		} 
		
		$.ajax({
	    	type : "POST",
	        url : "/like",
	        data : {
	        	boardSeq : boardSeq,
	        	likeYn : $('#likeYn').val()
	        },
	        success : function(res){
	        	if(res.resultCode == "success") {
	        		$('#likeYn').val(res.data);
	        		if(res.data == "Y") {
	        			$('#likeBtn').addClass("active");
	        			$('#likeBtn2').addClass("active");
	        		} else {
	        			$('#likeBtn').removeClass("active");
	        			$('#likeBtn2').removeClass("active");
	        		}
	        		toastr.success(res.resultMessage);	
	        	} else {
	        		toastr.error(res.resultMessage);
	        	}
	        },
	        error : function(XMLHttpRequest, textStatus, errorThrown){
	            toastr.error("관리자에게 문의 부탁드립니다.")
	        }
		});
	}