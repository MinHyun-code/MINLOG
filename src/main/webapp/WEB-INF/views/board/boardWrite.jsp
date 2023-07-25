<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div>
	<div style="min-height: 90vh; padding: 50px 0" class="container">
	
		<div style="height: 6vh;">
			<input type="text" class="form-control form-control-dark" id="title" placeholder="제목을 입력하세요." style="float:left; width: 47vw;"/>
			<input type="button" class="btn btn-outline-secondary me-2" onclick="openModal();" value="출간하기" style="float:right;"/>
		</div>
		<div id="editor" style="background-color: white;"></div>
	</div>
	
<!-- 	모달 -->
	
	<div class="writeModal">
		<div class="div-write0">
			<div class="div-write1">
				<div class="div-write2">
					<span class="span-write0">포스트 미리보기</span>
					<div style="width: 100%; padding-top: 55.11%; position: relative;">
						<div style="width: 100%; height: 100%; position: absolute; left: 0px; top: 0px;">
							<div class="div-write5">
								<svg width="107" height="85" fill="none" viewBox="0 0 107 85"><path fill="#868E96" d="M105.155 0H1.845A1.844 1.844 0 0 0 0 1.845v81.172c0 1.02.826 1.845 1.845 1.845h103.31A1.844 1.844 0 0 0 107 83.017V1.845C107 .825 106.174 0 105.155 0zm-1.845 81.172H3.69V3.69h99.62v77.482z"></path><path fill="#868E96" d="M29.517 40.84c5.666 0 10.274-4.608 10.274-10.271 0-5.668-4.608-10.276-10.274-10.276-5.665 0-10.274 4.608-10.274 10.274 0 5.665 4.609 10.274 10.274 10.274zm0-16.857a6.593 6.593 0 0 1 6.584 6.584 6.593 6.593 0 0 1-6.584 6.584 6.591 6.591 0 0 1-6.584-6.582c0-3.629 2.954-6.586 6.584-6.586zM12.914 73.793a1.84 1.84 0 0 0 1.217-.46l30.095-26.495 19.005 19.004a1.843 1.843 0 0 0 2.609 0 1.843 1.843 0 0 0 0-2.609l-8.868-8.868 16.937-18.548 20.775 19.044a1.846 1.846 0 0 0 2.492-2.72L75.038 31.846a1.902 1.902 0 0 0-1.328-.483c-.489.022-.95.238-1.28.6L54.36 51.752l-8.75-8.75a1.847 1.847 0 0 0-2.523-.081l-31.394 27.64a1.845 1.845 0 0 0 1.22 3.231z"></path></svg>
								<input type="button" class="btn-write0" onclick="onClickUpload()" value="썸네일 업로드"/>
							</div>
						</div>
					</div>
					<input id="thumbnail_img" type="file" style="visibility: hidden;" onchange="setThumbnail(event)"/>
					<div style="margin-top: 1.5rem">
						<span class="span-write0">제목</span>
						<textarea placeholder="당신의 포스트를 짧게 소개해보세요." class="textarea-write0" id="thumbnail_txt"></textarea>
					</div>
				</div>	 
				
				<div class="div-write3"></div>
				
				<div class="div-write2">
					<span class="span-write0">공개 설정</span>
					<div style="display: flex;">
					<button class="sc-jlRLRk fxPkFT" id="openYnY" onclick="openYn('Y')"><svg width="24" height="24" fill="none" viewBox="0 0 24 24"><path fill="currentColor" d="M12 0C5.373 0 0 5.373 0 12s5.373 12 12 12 12-5.373 12-12S18.627 0 12 0zm-1.243 22.212a10.209 10.209 0 0 1-6.03-2.939A10.218 10.218 0 0 1 1.714 12c0-2.473.868-4.813 2.458-6.673.041.492.142 1.019.116 1.395-.094 1.373-.23 2.232.574 3.39.313.451.39 1.098.542 1.62.149.51.744.779 1.155 1.094.828.635 1.62 1.373 2.5 1.932.579.369.941.552.771 1.26-.136.569-.174.92-.469 1.426-.09.155.34 1.15.482 1.292.433.433.862.83 1.333 1.219.732.604-.07 1.389-.42 2.257zm8.516-2.939a10.213 10.213 0 0 1-5.34 2.832c.285-.705.793-1.331 1.264-1.694.409-.316.922-.924 1.136-1.405.213-.48.496-.898.783-1.34.407-.628-1.005-1.577-1.463-1.776-1.03-.447-1.805-1.05-2.72-1.694-.653-.46-1.977.24-2.713-.082-1.009-.44-1.84-1.206-2.716-1.866-.905-.68-.861-1.475-.861-2.48.708.026 1.716-.196 2.187.373.148.18.659.984 1 .698.28-.233-.207-1.168-.3-1.388-.29-.676.658-.94 1.142-1.398.632-.597 1.989-1.535 1.882-1.964-.108-.428-1.358-1.643-2.092-1.453-.11.028-1.078 1.044-1.266 1.203l.015-.994c.004-.21-.39-.424-.372-.56.046-.34.996-.96 1.232-1.232-.165-.103-.73-.588-.9-.517-.415.173-.882.291-1.296.464 0-.144-.017-.279-.038-.412a10.188 10.188 0 0 1 2.614-.758l.812.326.574.68.573.591.5.162.795-.75-.205-.535v-.481c1.572.228 3.057.814 4.357 1.719-.233.02-.488.055-.777.091-.119-.07-.272-.102-.401-.15.376.81.77 1.608 1.169 2.408.426.853 1.372 1.77 1.539 2.67.195 1.063.06 2.028.166 3.278.104 1.204 1.358 2.572 1.358 2.572s.579.197 1.06.128a10.222 10.222 0 0 1-2.698 4.734z"></path></svg><div class="description">전체 공개</div></button>
					<button class="sc-jlRLRk fxPkFT" id="openYnN" onclick="openYn('N')" style="margin-left: 1rem;"><svg width="24" height="24" fill="none" viewBox="0 0 24 24"><path fill="currentColor" d="M17.625 9H16.5V6.81c0-2.47-1.969-4.522-4.44-4.56a4.514 4.514 0 0 0-4.56 4.5V9H6.375A1.88 1.88 0 0 0 4.5 10.875v9a1.88 1.88 0 0 0 1.875 1.875h11.25a1.88 1.88 0 0 0 1.875-1.875v-9A1.88 1.88 0 0 0 17.625 9zm-4.969 5.85v3.225a.672.672 0 0 1-.623.675.657.657 0 0 1-.69-.656V14.85a1.5 1.5 0 0 1-.838-1.486 1.5 1.5 0 1 1 2.152 1.486zM15.187 9H8.814V6.75c0-.848.332-1.645.937-2.25A3.16 3.16 0 0 1 12 3.562a3.16 3.16 0 0 1 2.25.938 3.16 3.16 0 0 1 .938 2.25V9z"></path></svg><div class="description">비공개</div></button></div>


					<span class="span-write0" style="margin-top: 1.5rem;">메뉴 설정</span>
					<div>
						<button class="fxPkFT description" style="width: 100%;"><svg style="margin-right: 1rem;" width="24" height="24" viewBox="0 0 24 24" fill="none"><path fill-rule="evenodd" clip-rule="evenodd" d="M14 10H2V12H14V10ZM14 6H2V8H14V6ZM18 14V10H16V14H12V16H16V20H18V16H22V14H18ZM2 16H10V14H2V16Z" fill="currentColor"></path></svg>메뉴 설정</button>
					</div>
					<div class="div-write4">
						<input type="button" class="btn-write1" onclick="closeModal();" value="취소"/>
						<input type="button" class="btn-write2" style="margin-left: 0.875rem;" onclick="boardWrite();" value="출간하기"/>
					</div>
				</div>
			</div>
		</div>
		<input type="hidden" id="thumbnail_img_url"/>
		<input type="hidden" id="open_yn"/>
	</div>
	
	<script type="text/javascript">
// 	history.replaceState({}, null, location.pathname); 
	
	let initialValue = '';

	$(document).ready(function(){
		
		// 수정일 경우
		if("${status}" == "R"){
			$('#title').val('${boardDetail.title}');
			initialValue = '${boardDetail.content}';
			$('#thumbnail_img_url').val('${boardDetail.thumbnail}');
			$('#thumbnail_txt').val('${boardDetail.thumbnailTxt}');
			// 썸네일 이미지 있을 경우, 이미지 띄우기
			if($('#thumbnail_img_url').val() != '') {
				var img = document.createElement("img");
				img.className = 'thumbnail';
				img.setAttribute("src", '${boardDetail.thumbnail}');
				img.setAttribute("onclick", "onClickUpload()");
				$(".div-write5").empty();
		        document.querySelector(".div-write5").appendChild(img);
			}
			
			// 공개여부
			if('${boardDetail.openYn}' == 'Y') {
	    		$('#open_yn').val('Y');
	        	$('#openYnY').addClass('active');
	        	$('#openYnN').removeClass('active');
			} else {
	    		$('#open_yn').val('N');
	        	$('#openYnN').addClass('active');
	        	$('#openYnY').removeClass('active');
			}
			
			var content = '${boardDetail.content}';
			content = content.replaceAll('<br2>','\r\n');
			editor.setMarkdown(content);
		}
	});
	
	// toast-ui editor 셋팅
	const editor = new toastui.Editor({ 
		el: document.querySelector('#editor'),
		previewStyle: 'vertical',
		// 표시할 초기 유형
		initialEditType: 'markdown',
		// 초기 값, 마크다운 문자열 설정
// 		initialValue: '${boardDetail.content}',
		width: '80vw',
		height: '75vh',
		previewStyle: 'vertical',
		hooks: {
	    	addImageBlobHook: (blob, callback) => {
	    		// blob : 사용자가 선택한 이미지 파일
	    		// callback : 파일이 업로드 된 후 에디터에 표시할 이미지 주소를 전달하기 위한 콜백함수
	    		
	    		const formData = new FormData();
	        	formData.append('image', blob);

	        	let url = '/images/';
	        	
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
	           			
	           			// callback : 에디터(마크다운 편집기)에 표시할 텍스트, 뷰어에는 imageUrl 주소에 저장된 사진으로 나옴
	        			// 형식 : ![대체 텍스트](주소)
	           			callback(url, '사진 대체 텍스트 입력');
	           		},
	           		error: function(e) {
	           			callback('image_load_fail', '사진 대체 텍스트 입력');
	           		}
	           	});
	    	}
		}
	});
	
	// 게시글 출간 모달창 OPEN
	function openModal() {
		
		$('.writeModal').css('display', 'flex');
		

	}

	// 게시글 출간 모달창 CLOSE
	function closeModal() {
		$('.writeModal').css('display', 'none');
	}
	
	// 출간하기 버튼 이벤트
	function boardWrite() {
		
		if($('#open_yn').val() == '') {
			alert("공개 설정을 선택해주세요.");
			return false;
		}
		
		var param = {};
		if('${status}' == "R") {
       		param = {
       			boardSeq : '${boardDetail.boardSeq}',
	        	title : $('#title').val(), 
	        	content : editor.getMarkdown(),
	        	thumbnail : $('#thumbnail_img_url').val(),
	        	thumbnailTxt : $('#thumbnail_txt').val(),
	        	openYn : $('#open_yn').val(),
				status : '${status}'
			}
		} else {
       		param = {
    	        	title : $('#title').val(), 
    	        	content : editor.getMarkdown(),
    	        	thumbnail : $('#thumbnail_img_url').val(),
    	        	thumbnailTxt : $('#thumbnail_txt').val(),
    	        	openYn : $('#open_yn').val(),
    	        	userId : "${loginUserId}",
       		}
		}

		$.ajax({
	    	type : "POST",
	        url : "/write",
	        data : param,
	        success : function(res){
	        	if(res.resultCode == "success"){
	           		alert("저장되었습니다.");
	            	window.location.href = "/";
	        	}
	        	else {
	        		alert("출간 도중 에러 발생하였습니다. 관리자에게 문의 부탁드립니다.");
	        		return false;
	        	}
	        },
	        error : function(XMLHttpRequest, textStatus, errorThrown){
	            alert("통신 실패.")
	        }
	    });
	}
    
    // 썸네일 이미지 업로드 버튼 이벤트
    function onClickUpload() {
        let myInput = document.getElementById("thumbnail_img");
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

		const formData = new FormData();
		formData.append("image", imageFile);
        
        let url = '/images/';
        
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
       			thumbnail_img_url = url;
       			$('#thumbnail_img_url').val(thumbnail_img_url);
       		},
       		error: function(e) {
       			console.log(e);
       		}
       	});
      }
    
    // 공개 설정 버튼 이벤트
    function openYn(gubun) {
    	if(gubun == 'Y') {
    		$('#open_yn').val('Y');
        	$('#openYnY').addClass('active');
        	$('#openYnN').removeClass('active');
    	} else {
    		$('#open_yn').val('N');
        	$('#openYnN').addClass('active');
        	$('#openYnY').removeClass('active');
    	}
    }
	</script>
</div>

