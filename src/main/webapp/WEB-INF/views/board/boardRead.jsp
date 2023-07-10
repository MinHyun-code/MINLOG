<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div  class="div-read0">
	
	<div class="container" style="padding: 0 4vw;">
	
		<div>
			<span class="title" id="title"></span>
		</div>
 		<div style="margin: 50px 0; float:left;">
			<span class="span-read0" id="regUserId"></span>
		</div>
		<div style="margin: 50px 0; float:right;">
			<input type="button" class="btn-read0" id="" value="통계"/>
			<input type="button" class="btn-read0" id="" value="수정"/>
			<input type="button" class="btn-read0" onclick="boardDel()" value="삭제"/>
			<input type="hidden" id="boardSeq"/>
		</div>
		<div class="contents" id="contents"></div>
	</div>
	
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
	        	}
	        	else {
	        	}
	        },
	        error : function(XMLHttpRequest, textStatus, errorThrown){
	            alert("통신 실패.")
	        }
	    });
		
	});
	
	function boardDel() {
		
		console.log($('#boardSeq').val());
		
		$.ajax({
	    	type : "POST",
	        url : "/delete",
	        data : {
	        	boardSeq : $('#boardSeq').val()
	        },
	        success : function(res){
	        	if(res.resultCode == "success"){
	        		
	        	}
	        	else {
	        	}
	        },
	        error : function(XMLHttpRequest, textStatus, errorThrown){
	            alert("통신 실패.")
	        }
	    });
		
	}

	</script>
</div>