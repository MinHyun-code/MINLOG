<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>

<div  class="div-read0">
	
	<div class="container" style="padding: 0 4vw;">
	
		<div>
			<span class="title" id="title"></span>
		</div>
 		<div style="margin: 50px 0; float:left;">
			<span class="span-read0" id="regUserId"></span>
		</div>
		<div style="margin: 50px 0; float:right; display: none;" id="readDiv">
			<input type="button" class="btn-read0" id="" value="통계"/>
			<input type="button" class="btn-read0" onclick="boardUpdate()" value="수정"/>
			<input type="button" class="btn-read0" onclick="boardDel()" value="삭제"/>
		</div>
		<div class="contents" id="contents"></div>
	</div>

	<form id="frm">
		<input type="hidden" id="boardSeq" name="boardSeq"/>
		<input type="hidden" name="status" value="R"/>
	</form>
	
	<form id="frm2">
		<input type="hidden" id="commentTxt" name="commentTxt"/>
		<input type="hidden" id="postNum" name="postNum"/>
		<input type="hidden" id="commentDepth" name="commentDepth"/>
		<input type="hidden" id="commentOrder" name="commentOrder"/>
		<input type="hidden" id="groupNum" name="groupNum"/>
		<input type="hidden" id="loginUserId" name="loginUserId"/>
	</form>
	
	<hr style="margin: 80px 0;">
				
	<div style="margin: 0 10%;">
		<p style="font-weight: bold; font-size: 1.125rem;">17개의 댓글</p>
		<textarea class="textarea-comment" placeholder="댓글을 작성하세요."></textarea>
		<button class="btn-write3" style="float: right; margin-top: 20px;">댓글 작성</button>
	</div>
	
	<c:if test="${commentList != null}">
		1
	</c:if>
	
	<script type="text/javascript">
	
	$(document).ready(function(){
		
		$.ajax({
	    	type : "POST",
	        url : "/read",
	        data : {
	        	boardSeq : "${boardSeq}"
	        },
	        success : function(res){
	        	if(res.resultCode == "success"){
	        		
	        		const viewer = toastui.Editor.factory({
	        		    el : document.querySelector("#contents"),
	        		    viewer : true,
	        		    initialValue : res.data.content
	        		});
	        		
	        		$('#title').html(res.data.title);
	        		$('#regUserId').html(res.data.regUserId);
	        		$('#boardSeq').val(res.data.boardSeq);
	        		if(res.data.regUserId == '${loginUserId}') {
	        			$('#readDiv').css('display', 'block');
	        		}
	        	}
	        	else {
	        	}
	        },
	        error : function(XMLHttpRequest, textStatus, errorThrown){
	            alert("통신 실패.")
	        }
	    });
		
	});
	
	function boardUpdate() {
		const form = $('#frm');
		var formData = form.serialize();
		form.attr("action", "/write");
		form.submit();
	}
	
	function boardDel() {
		
		if(confirm("삭제하시겠습니까 ?")) {
			$.ajax({
		    	type : "POST",
		        url : "/board/delete",
		        data : {
		        	boardSeq : $('#boardSeq').val()
		        },
		        success : function(res){
		        	if(res.resultCode == "success"){
		        		alert("삭제되었습니다.");
		        		window.location.href = "/";
		        	}
		        	else {
		        	}
		        },
		        error : function(XMLHttpRequest, textStatus, errorThrown){
		            alert("통신 실패.")
		        }
		    });
		}
	}

	</script>
</div>