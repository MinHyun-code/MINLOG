<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div>
	<div style="min-height: 90vh; padding: 50px 0" class="container">
	
		<div style="height: 6vh;">
			<input type="text" class="form-control form-control-dark" id="title" placeholder="제목을 입력하세요." style="float:left; width: 47vw;"/>
			
			<input type="button" class="btn btn-outline-secondary me-2" onclick="menuPopup();" value="메뉴선택" style="float:left; margin-left: 3vw; width: 6vw;"/>
			
			<input type="button" class="btn btn-outline-secondary me-2" onclick="boardAdd();" style="margin-left:1vw;" value="공개여부"/>
			
			<input type="button" class="btn btn-outline-secondary me-2" onclick="boardAdd();" value="저장" style="float:right;"/>
		</div>
		<div id="editor" style="background-color: white;"></div>
	</div>
	
	<script type="text/javascript">
	const editor = new toastui.Editor({
		el: document.querySelector('#editor'),
		previewStyle: 'vertical',
		// 표시할 초기 유형
		initialEditType: 'markdown',
		// 초기 값, 마크다운 문자열 설정
// 		initialValue '',
		width: '80vw',
		height: '80vh',
		hooks: {
	    	addImageBlobHook: (blob, callback) => {
	    		// blob : 사용자가 선택한 이미지 파일
	    		// callback : 파일이 업로드 된 후 에디터에 표시할 이미지 주소를 전달하기 위한 콜백함수
	    		console.log(blob);
	    		
	    		const formData = new FormData();
	        	formData.append('image', blob);

	        	let url = '/images/';
	        	
	   			$.ajax({
	           		type: 'POST',
	           		enctype: 'multipart/form-data',
// 	           		url: '/ajax/imageUpload',
	           		url: '/imgSave',
	           		data: formData,
	           		dataType: 'json',
	           		processData: false,
	           		contentType: false,
// 	           		timeout: 600000,
	           		success: function(data) {
	           			//console.log('ajax 이미지 업로드 성공');
	           			console.log(data);
	           			url += data.filename;
	           			
	           			// callback : 에디터(마크다운 편집기)에 표시할 텍스트, 뷰어에는 imageUrl 주소에 저장된 사진으로 나옴
	        			// 형식 : ![대체 텍스트](주소)
	           			callback(url, '사진 대체 텍스트 입력');
	           		},
	           		error: function(e) {
	           			console.log(e);
	           			//console.log('ajax 이미지 업로드 실패');
	           			//console.log(e.abort([statusText]));
	           			
	           			callback('image_load_fail', '사진 대체 텍스트 입력');
	           		}
	           	});
	    	}
		}
	});
	
// 	const viewer = toastui.Editor.factory({
// 	    el : document.querySelector("#contents"),
// 	    viewer : true,
// 	    initialValue : "<table><thead><tr><th><p>t</p></th><th><p><br></p></th><th><p><br></p></th><th><p><br></p></th><th><p><br></p></th><th><p><br></p></th></tr></thead><tbody><tr><td><p><br></p></td><td><p>t</p></td><td><p><br></p></td><td><p><br></p></td><td><p><br></p></td><td><p><br></p></td></tr><tr><td><p><br></p></td><td><p><br></p></td><td><p><br></p></td><td><p>t</p></td><td><p><br></p></td><td><p><br></p></td></tr><tr><td><p><br></p></td><td><p><br></p></td><td><p>t</p></td><td><p><br></p></td><td><p><br></p></td><td><p><br></p></td></tr><tr><td><p><br></p></td><td><p><br></p></td><td><p><br></p></td><td><p><br></p></td><td><p>t</p></td><td><p><br></p></td></tr><tr><td><p><br></p></td><td><p><br></p></td><td><p><br></p></td><td><p><br></p></td><td><p><br></p></td><td><p>t</p></td></tr></tbody></table>"
// 	});
	
	
	// 게시글 저장
	function boardAdd() {
		
		$.ajax({
	    	type : "POST",
	        url : "/write",
	        data : {
	        	title : $('#title').val(), 
	        	content : editor.getHTML(),
				regUserId : "${loginUserId}"
	        },
	        success : function(res){
	        	if(res.resultCode == "success"){
	           		alert("저장되었습니다.");
	            	window.location.href = "/";
	        	}
	        	else {
	        		alert("저장 도중 에러 발생하였습니다. 관리자에게 문의 부탁드립니다.");
	        		return false;
	        	}
	        },
	        error : function(XMLHttpRequest, textStatus, errorThrown){
	            alert("통신 실패.")
	        }
	    });
	}
	</script>
</div>

