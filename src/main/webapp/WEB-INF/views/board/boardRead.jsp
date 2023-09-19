<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>

<div  class="div-read0">
	
	<div class="container" style="padding: 0 4vw;">
		<div>
			<span class="title" id="title"></span>
		</div>
 		<div style="margin: 50px 0; float:left;">
			<span class="span-read0" id="userId"></span>
			<span id="regDate"></span>
		</div>
		<div style="margin: 50px 0; float:right; display: none;" id="readDiv">
			<input type="button" class="btn-read0" id="" value="통계"/>
			<input type="button" class="btn-read0" onclick="boardRevise()" value="수정"/>
			<input type="button" class="btn-read0" onclick="boardDel()" value="삭제"/>
		</div>
		<div class="contents" id="contents"></div>

	<form id="frm" method="post">
		<input type="hidden" id="boardSeq" name="boardSeq"/>
		<input type="hidden" name="status" value="R"/>
	</form>
	
	<div class="comment_div1" style="border-bottom: none; margin-top: 16rem;">
		<div class="comment_div2">
		<img class="card-img-custom3" id="regUserImg" alt="">
			<div style="padding-left: 1rem">
				<span id="regUserNm" class="comment_span3"></span>
				<span id=regUserIntro class="comment_span4"></span>
			</div>
		</div>
	</div>
				
	<hr style="margin: 80px 0;">
				
	<div>
		<p style="font-weight: bold; font-size: 1.125rem;"><span id="commentCnt"></span>개의 댓글</p>
		<textarea class="textarea-comment" placeholder="댓글을 작성하세요." id="commentTxt_0_1"></textarea>
		<button class="btn-write3" style="float: right; margin-top: 20px;" data-depth="1" onclick="commentWrite(0,1)">댓글 작성</button>
	</div>
	
	<div id="comment"></div>
	
	<input type="hidden" id="loginUserId" value="${loginUserId}" name="loginUserId"/>
	<input type="hidden" id="likeYn" name="likeYn"/>
	</div>
	
	<script type="text/javascript">
	
	$(document).ready(function(){
		
		$.ajax({
	    	type : "POST",
	        url : "/read/data",
	        data : {
	        	boardSeq : "${boardSeq}"
	        },
	        success : function(res){
	        	if(res.resultCode == "success"){
	        		
	        		var boardData = res.data;
	        		
	        		const viewer = toastui.Editor.factory({
	        		    el : document.querySelector("#contents"),
	        		    viewer : true,
	        		    initialValue : boardData.content
	        		});
	        		$('#title').html(boardData.title);
	        		$('#userId').html(boardData.userId);
	        		$('#boardSeq').val(boardData.boardSeq);
	        		if(boardData.userId == '${loginUserId}') {
	        			$('#readDiv').css('display', 'block');
	        		}
	        		$('#regDate').html(" · " + boardData.regDate);
	        		
	        		$('#regUserNm').html(boardData.userName);
	        		if(boardData.userImg != null){
	        			$('#regUserImg').attr("src", boardData.userImg);
	        		} else {
	        			$('#regUserImg').attr("src", "/images/common/default_user.png");
	        		}
	        		$('#regUserIntro').html(boardData.userIntro);
	        		
	        		// 댓글
	        		var comment = res.data2;
	        		
	        		$('#likeYn').val(res.data3);
	        		if(res.data3 == "Y") {
	        			$('#likeBtn').addClass("active");
	        		} else {
	        			$('#likeBtn').removeClass("active");
	        		}
	        		
	        		var totalCnt = 0;
	        		
	        		for(var i=0; i<comment.length; i++) {
	        			
						var commentCnt = comment[i].commentCnt-1;
						totalCnt += comment[i].commentCnt;
						
	        			$('#comment').append("<div class=\"comment_div1\" id=\"commentDiv_"+comment[i].groupNum+"\"> "
		        					 	+ "<div class=\"comment_div2\">"
			        						+ "<img alt=\"\" src=\"" + comment[i].userImg + "\" onerror=\"this.src='/images/common/default_user.png'\" class=\"card-img-custom2\">"
			        						+ "<div style=\"padding-left: 1rem\">"
				        						+ "<span class=\"comment_span\">" + comment[i].userId + "</span>"
				        						+ "<span class=\"comment_span2\">" + comment[i].regDate + "</span>"
			        						+ "</div>"	
				        				+ "</div>"
		        						+ "<p class=\"comment_p\">"
		        						+ comment[i].commentTxt
		        						+ "</p>"	
		        						+ "</div>"
						);
	        			// 대댓글이 있을 경우
	        			if(commentCnt > 0) {
							$('#commentDiv_'+comment[i].groupNum).append("<div class=\"comment_div3\">"
							        					+ "<svg width=\"12\" height=\"12\" fill=\"none\" viewBox=\"0 0 12 12\"><path fill=\"currentColor\" d=\"M5.5 2.5h1v3h3v1h-3v3h-1v-3h-3v-1h3v-3z\"></path><path fill=\"currentColor\" fill-rule=\"evenodd\" d=\"M1 0a1 1 0 0 0-1 1v10a1 1 0 0 0 1 1h10a1 1 0 0 0 1-1V1a1 1 0 0 0-1-1H1zm10 1H1v10h10V1z\" clip-rule=\"evenodd\"></path></svg>"
							        					+ "<span style=\"margin-left:0.5rem;\" onclick=\"reReplySearchBtn("+comment[i].groupNum+","+comment[i].depth+")\">"+commentCnt+"개의 답글</span>"	
													+ "</div>");
	        			} else {
							$('#commentDiv_'+comment[i].groupNum).append("<div class=\"comment_div3\">"
		        					+ "<svg width=\"12\" height=\"12\" fill=\"none\" viewBox=\"0 0 12 12\"><path fill=\"currentColor\" d=\"M5.5 2.5h1v3h3v1h-3v3h-1v-3h-3v-1h3v-3z\"></path><path fill=\"currentColor\" fill-rule=\"evenodd\" d=\"M1 0a1 1 0 0 0-1 1v10a1 1 0 0 0 1 1h10a1 1 0 0 0 1-1V1a1 1 0 0 0-1-1H1zm10 1H1v10h10V1z\" clip-rule=\"evenodd\"></path></svg>"
		        					+ "<span style=\"margin-left:0.5rem;\" onclick=\"reReplyWriteBtn("+comment[i].groupNum+","+comment[i].depth+")\">답글 달기</span>"	
								+ "</div>");
	        			}
	        		}

	        		// 댓글 총 개수 업데이트
	        		$('#commentCnt').html(totalCnt);
	        	}
	        	else {
	        	}
	        },
	        error : function(XMLHttpRequest, textStatus, errorThrown){
	            toastr.error("관리자에게 문의 부탁드립니다.")
	        }
	    });
		
	});
	
	function boardRevise() {
		$("#frm").attr("action","/write").submit();
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
		        		toastr.success("삭제되었습니다.");
		        		window.location.href = "/";
		        	}
		        	else {
		        		toastr.error("삭제 중 오류가 발생하였습니다.");
		        	}
		        },
		        error : function(XMLHttpRequest, textStatus, errorThrown){
		        	toastr.error("통신 실패.")
		        }
		    });
		}
	}

// 	댓글 등록
	function commentWrite(groupNum, depth) {
		
		if($('#loginUserId').val() == null || $('#loginUserId').val() == '') {
			toastr.error("로그인 후 이용해주세요.");
			return false;
		} 
		
		var params = {
				userId : $('#loginUserId').val(),
				boardSeq : $('#boardSeq').val(),
				groupNum : groupNum,
				depth : depth,
				commentTxt : $('#commentTxt_'+groupNum+'_'+depth).val()
		}

		$.ajax({
	    	type : "POST",
	        url : "/comment/write",
	        data : params,
	        success : function(res){
	        	if(res.resultCode == "success"){
	        		toastr.success("등록되었습니다.");
	        		location.reload();
	        	}
	        	else {
	        		toastr.error("등록 중 오류가 발생하였습니다.");
	        	}
	        },
	        error : function(XMLHttpRequest, textStatus, errorThrown){
	        	toastr.error("통신 실패.")
	        }
	    });
	}
	
	// 답글 보기
	function reReplySearchBtn(groupNum, depth) {
		
		if(document.getElementById("reReply_"+groupNum+"_"+depth)) {
			document.getElementById("reReply_"+groupNum+"_"+depth).remove();
		} else {
			
			// 대댓글 조회
			
			var params = {
					boardSeq : $('#boardSeq').val(),
					groupNum : groupNum,
					depth : depth+1
			}
			
			$.ajax({
		    	type : "POST",
		        url : "/read/commentRead",
		        data : params,
		        success : function(res){
		        	if(res.resultCode == "success"){
		        		
		        		console.log(res.data);
		        		
		        		var data = res.data;

		    			$('#commentDiv_'+groupNum).append("<div class=\"reReply_div\" id=\"reReply_"+groupNum+"_"+depth+"\">"
			    				+ "</div>");
		    			
		        		for(var i=0; i<data.length; i++) {
			    			$('#reReply_'+groupNum+"_"+depth).append(
			    				 		"<div class=\"comment_div2\">"
			    						+ "<img alt=\"\" src=\"" + data[i].userImg + "\" onerror=\"this.src='/images/common/default_user.png'\" class=\"card-img-custom2\">"
			    						+ "<div style=\"padding-left: 1rem\">"
			    							+ "<span class=\"comment_span\">" + data[i].userId + "</span>"
			    							+ "<span class=\"comment_span2\">" + data[i].regDate + "</span>"
			    						+ "</div>"	
			    						+ "</div>"
			    						+ "<p class=\"comment_p2\">"
			    						+ data[i].commentTxt
			    						+ "</p>"	
			    			);
			        	}
		        		
		        		$("#reReply_"+groupNum+"_"+depth).append("<div>"
										    						+ "<button class=\"reReply_btn\" onclick=\"reReplyWriteBtn2("+groupNum+","+(depth+1)+")\" id=\"btn_"+groupNum+"_"+depth+"\">답글 작성하기</button>"
											    				+ "</div>");
		        	}
		        	else {
		        		toastr.error("댓글 조회 중 오류가 발생하였습니다.");
		        	}
		        },
		        error : function(XMLHttpRequest, textStatus, errorThrown){
		        	toastr.error("통신 실패.")
		        }
		    });
		}
	}
	
	// 답글 작성
	function reReplyWriteBtn(groupNum, depth) {
		
		console.log(depth);
		
		if(document.getElementById("reReply_"+groupNum+"_"+depth)) {
			$('#btn_'+groupNum+'_'+(depth-1)).show();
			document.getElementById("reReply_"+groupNum+"_"+depth).remove();
		} else {
			
			$('#commentDiv_'+groupNum).append("<div class=\"reReply_div\" id=\"reReply_"+groupNum+"_"+(depth+1)+"\">"
						+ "<div>"
							+ "<textarea class=\"textarea-comment\" placeholder=\"댓글을 작성하세요.\" id=\"commentTxt_"+groupNum+"_"+(depth+1)+"\"></textarea>"
							+ "<div class=\"reReply_div2\">"
								+ "<button class=\"btn-write1\" style=\"height:2rem; font-size:1rem;\" onclick=\"reReplyWriteBtn("+groupNum+","+(depth+1)+")\">취소</button>"
								+ "<button class=\"btn-write2\" style=\"height:2rem; font-size:1rem;\" onclick=\"commentWrite("+groupNum+","+(depth+1)+")\">댓글 작성</button>"
							+ "</div>"
						+ "</div>"
					+ "</div>"
			);
		}
	}
	
	// 대댓글 작성
	function reReplyWriteBtn2(groupNum, depth) {
		
		if(document.getElementById("reReply_"+groupNum+"_"+depth)) {
			document.getElementById("reReply_"+groupNum+"_"+depth).remove();
		} else {
			$('#reReply_'+groupNum+"_"+(depth-1)).append("<div class=\"reReply_div\" id=\"reReply_"+groupNum+"_"+depth+"\">"
						+ "<div>"
							+ "<textarea class=\"textarea-comment\" placeholder=\"댓글을 작성하세요.\" id=\"commentTxt_"+groupNum+"_"+depth+"\"></textarea>"
							+ "<div class=\"reReply_div2\">"
								+ "<button class=\"btn-write1\" style=\"height:2rem; font-size:1rem;\" onclick=\"reReplyWriteBtn("+groupNum+","+depth+")\">취소</button>"
								+ "<button class=\"btn-write2\" style=\"height:2rem; font-size:1rem;\" onclick=\"commentWrite("+groupNum+","+depth+")\">댓글 작성</button>"
							+ "</div>"
						+ "</div>"
					+ "</div>"
			);

			$('#btn_'+groupNum+'_'+(depth-1)).hide();
		}
	}
	</script>
</div>