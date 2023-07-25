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
			<input type="button" class="btn-read0" onclick="boardUpdate()" value="수정"/>
			<input type="button" class="btn-read0" onclick="boardDel()" value="삭제"/>
		</div>
		<div class="contents" id="contents"></div>

	<form id="frm">
		<input type="hidden" id="boardSeq" name="boardSeq"/>
		<input type="hidden" name="status" value="R"/>
	</form>
	
	<div class="comment_div1" style="border-bottom: none; margin-top: 16rem;">
		<div class="comment_div2">
		<img class="card-img-custom3" alt="" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAIAAAACACAYAAADDPmHLAAAACXBIWXMAAAsTAAALEwEAmpwYAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAASbSURBVHgB7Z0tTytBFIYP914BDiQ4cIADB0EhwYFE8ifq7g/hJ2CRSCQ4kOCobF3ruHk3maS5aSnbdnfPOe/7JE0oCTvTnmc+dvbMsNbr9b5M0PLLBDUSgBwJQI4EIEcCkCMByJEA5EgAciQAORKAHAlAjgQgRwKQIwHIkQDkSAByJAA5EoAcCUCOBCBHApAjAciRAORIAHIkADkSgBwJQI4EIEcCkCMByJEA5EgAciQAOX+MhPX1dTs+Prbt7W3b3d21jY2N6ndgPB7bYDCw4XBor6+v9vHxUb1nIL0Ae3t7dn5+XgV9FhABYuC1v79f/Q4SPD8/28vLi2UmrQA/Cfx34O/wwjXu7u7S9gi/z87O/loyELTr62vb2tqyZcFQcXp6Wv2MXiEb6SaBCDwEWDVFqmykEgABOjo6sqbAtbNJkEaAi4uLRoNfQBmXl5eWhRQCIChlnG6Dk5OTVstrkvACYKLXxJg/D5RZ1hEiE14ABGIVs/26IPgZeoHQAiDwbYz7s4AA0XuB0AIsusizKsrycmRCC+Dhyz84OLDIhBUAra/rHgCgDpGHgbAC7OzsmBc81aUuYQXY3Nw0L3iqS13CCtDFrd8sPNWlLsoIIkcCkBNWAE8JGpGTRcIKgPw9L3iqS13CCvD5+Wle8FSXuoQVAJm8HlK0UAfUJSqhJ4Fvb2/WNcgcjkxoAfDld936oieKhhYAwX96erKuwJ6B6Oni4dcBIEAXvQAC//j4aNEJLwCC30UgUGaGzSIpVgLRC7Q5FKCsLFvG0iwFPzw8tBIUlIGyspDqWcD9/X2jEuDaKCMT6R4GIUBNzAlwzWzBByl3ByNYaK23t7dLP6vHfT6u9/7+bhlZ6/V6X5YYpI0jebRu/mD2wBfSHxCBngAv9ASQ4PDwsErhwvvJE0JGo1EV9H6/72KFsS1SCDAZyFngnh2vVUwSUV4WQUILULZnlR06aMGYqDW1QDN56khZho6+Ghh2DoBgXF1dTZ3koZWvcqWubECdtg0NZUQ+QiakAGjxOA9gHhABj4wXeWyMHgX5/j85Zwi9AXoeD4+n6xJOAASk7nbwkjyCGT0meXg/mcWDYOMsIJwShtaO3mWRHT/odaINCaHmAIsEHyCQOP6tHAHXFKVukSQIsxK4aPDbBnWMdG5ACAHwhUYIfgHzEwwjEXAvQFdHwCzLzc1NiC1jrgXA2I31/Ijbr1HnCEfKuRagq/N/VgXuJLzPB9wKgMBnOITJu8RuBUDXnwHvQ4FLAbDkGrnr/x8MBV7vClwKEHHWPw+vn8mdANlaf8FrL+BOgIytv+Dxs7kSAC0kY+sveOwFXAnQ5bGvbdH0A6m6uBLAw8GPTePtaFk3AmTv/gtYF/A0DLgRgKH1Fzx9VjcCIBuHBU89nRsBkKrFgqfNJm5SwpBGVc7fz/CvWKZRUsk9bS1PvzVMfI+OiiVHApAjAciRAORIAHIkADkSgBwJQI4EIEcCkCMByJEA5EgAciQAORKAHAlAjgQgRwKQIwHIkQDkSAByJAA5EoAcCUCOBCBHApAjAciRAORIAHIkADkSgBwJQI4EIOcfGjV2tEfztqEAAAAASUVORK5CYII=">
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
	        		$('#regUserIntro').html(boardData.userIntro);
	        		
	        		// 댓글
	        		var comment = res.data2;
	        		
	        		var totalCnt = 0;
	        		
	        		for(var i=0; i<comment.length; i++) {
	        			
						var commentCnt = comment[i].commentCnt-1;
						totalCnt += comment[i].commentCnt;
						
	        			$('#comment').append("<div class=\"comment_div1\" id=\"commentDiv_"+comment[i].groupNum+"\"> "
		        					 	+ "<div class=\"comment_div2\">"
			        						+ "<img alt=\"\" src=\"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAIAAAACACAYAAADDPmHLAAAACXBIWXMAAAsTAAALEwEAmpwYAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAASbSURBVHgB7Z0tTytBFIYP914BDiQ4cIADB0EhwYFE8ifq7g/hJ2CRSCQ4kOCobF3ruHk3maS5aSnbdnfPOe/7JE0oCTvTnmc+dvbMsNbr9b5M0PLLBDUSgBwJQI4EIEcCkCMByJEA5EgAciQAORKAHAlAjgQgRwKQIwHIkQDkSAByJAA5EoAcCUCOBCBHApAjAciRAORIAHIkADkSgBwJQI4EIEcCkCMByJEA5EgAciQAOX+MhPX1dTs+Prbt7W3b3d21jY2N6ndgPB7bYDCw4XBor6+v9vHxUb1nIL0Ae3t7dn5+XgV9FhABYuC1v79f/Q4SPD8/28vLi2UmrQA/Cfx34O/wwjXu7u7S9gi/z87O/loyELTr62vb2tqyZcFQcXp6Wv2MXiEb6SaBCDwEWDVFqmykEgABOjo6sqbAtbNJkEaAi4uLRoNfQBmXl5eWhRQCIChlnG6Dk5OTVstrkvACYKLXxJg/D5RZ1hEiE14ABGIVs/26IPgZeoHQAiDwbYz7s4AA0XuB0AIsusizKsrycmRCC+Dhyz84OLDIhBUAra/rHgCgDpGHgbAC7OzsmBc81aUuYQXY3Nw0L3iqS13CCtDFrd8sPNWlLsoIIkcCkBNWAE8JGpGTRcIKgPw9L3iqS13CCvD5+Wle8FSXuoQVAJm8HlK0UAfUJSqhJ4Fvb2/WNcgcjkxoAfDld936oieKhhYAwX96erKuwJ6B6Oni4dcBIEAXvQAC//j4aNEJLwCC30UgUGaGzSIpVgLRC7Q5FKCsLFvG0iwFPzw8tBIUlIGyspDqWcD9/X2jEuDaKCMT6R4GIUBNzAlwzWzBByl3ByNYaK23t7dLP6vHfT6u9/7+bhlZ6/V6X5YYpI0jebRu/mD2wBfSHxCBngAv9ASQ4PDwsErhwvvJE0JGo1EV9H6/72KFsS1SCDAZyFngnh2vVUwSUV4WQUILULZnlR06aMGYqDW1QDN56khZho6+Ghh2DoBgXF1dTZ3koZWvcqWubECdtg0NZUQ+QiakAGjxOA9gHhABj4wXeWyMHgX5/j85Zwi9AXoeD4+n6xJOAASk7nbwkjyCGT0meXg/mcWDYOMsIJwShtaO3mWRHT/odaINCaHmAIsEHyCQOP6tHAHXFKVukSQIsxK4aPDbBnWMdG5ACAHwhUYIfgHzEwwjEXAvQFdHwCzLzc1NiC1jrgXA2I31/Ijbr1HnCEfKuRagq/N/VgXuJLzPB9wKgMBnOITJu8RuBUDXnwHvQ4FLAbDkGrnr/x8MBV7vClwKEHHWPw+vn8mdANlaf8FrL+BOgIytv+Dxs7kSAC0kY+sveOwFXAnQ5bGvbdH0A6m6uBLAw8GPTePtaFk3AmTv/gtYF/A0DLgRgKH1Fzx9VjcCIBuHBU89nRsBkKrFgqfNJm5SwpBGVc7fz/CvWKZRUsk9bS1PvzVMfI+OiiVHApAjAciRAORIAHIkADkSgBwJQI4EIEcCkCMByJEA5EgAciQAORKAHAlAjgQgRwKQIwHIkQDkSAByJAA5EoAcCUCOBCBHApAjAciRAORIAHIkADkSgBwJQI4EIOcfGjV2tEfztqEAAAAASUVORK5CYII=\" class=\"card-img-custom2\">"
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
		        		alert("삭제 중 오류가 발생하였습니다.");
		        	}
		        },
		        error : function(XMLHttpRequest, textStatus, errorThrown){
		            alert("통신 실패.")
		        }
		    });
		}
	}

// 	댓글 등록
	function commentWrite(groupNum, depth) {
		
		if($('#loginUserId').val() == null || $('#loginUserId').val() == '') {
			alert("로그인 후 작성 가능합니다.");
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
	        		alert("등록되었습니다.");
	        		location.reload();
	        	}
	        	else {
	        		alert("등록 중 오류가 발생하였습니다.");
	        	}
	        },
	        error : function(XMLHttpRequest, textStatus, errorThrown){
	            alert("통신 실패.")
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
			    						+ "<img alt=\"\" src=\"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAIAAAACACAYAAADDPmHLAAAACXBIWXMAAAsTAAALEwEAmpwYAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAASbSURBVHgB7Z0tTytBFIYP914BDiQ4cIADB0EhwYFE8ifq7g/hJ2CRSCQ4kOCobF3ruHk3maS5aSnbdnfPOe/7JE0oCTvTnmc+dvbMsNbr9b5M0PLLBDUSgBwJQI4EIEcCkCMByJEA5EgAciQAORKAHAlAjgQgRwKQIwHIkQDkSAByJAA5EoAcCUCOBCBHApAjAciRAORIAHIkADkSgBwJQI4EIEcCkCMByJEA5EgAciQAOX+MhPX1dTs+Prbt7W3b3d21jY2N6ndgPB7bYDCw4XBor6+v9vHxUb1nIL0Ae3t7dn5+XgV9FhABYuC1v79f/Q4SPD8/28vLi2UmrQA/Cfx34O/wwjXu7u7S9gi/z87O/loyELTr62vb2tqyZcFQcXp6Wv2MXiEb6SaBCDwEWDVFqmykEgABOjo6sqbAtbNJkEaAi4uLRoNfQBmXl5eWhRQCIChlnG6Dk5OTVstrkvACYKLXxJg/D5RZ1hEiE14ABGIVs/26IPgZeoHQAiDwbYz7s4AA0XuB0AIsusizKsrycmRCC+Dhyz84OLDIhBUAra/rHgCgDpGHgbAC7OzsmBc81aUuYQXY3Nw0L3iqS13CCtDFrd8sPNWlLsoIIkcCkBNWAE8JGpGTRcIKgPw9L3iqS13CCvD5+Wle8FSXuoQVAJm8HlK0UAfUJSqhJ4Fvb2/WNcgcjkxoAfDld936oieKhhYAwX96erKuwJ6B6Oni4dcBIEAXvQAC//j4aNEJLwCC30UgUGaGzSIpVgLRC7Q5FKCsLFvG0iwFPzw8tBIUlIGyspDqWcD9/X2jEuDaKCMT6R4GIUBNzAlwzWzBByl3ByNYaK23t7dLP6vHfT6u9/7+bhlZ6/V6X5YYpI0jebRu/mD2wBfSHxCBngAv9ASQ4PDwsErhwvvJE0JGo1EV9H6/72KFsS1SCDAZyFngnh2vVUwSUV4WQUILULZnlR06aMGYqDW1QDN56khZho6+Ghh2DoBgXF1dTZ3koZWvcqWubECdtg0NZUQ+QiakAGjxOA9gHhABj4wXeWyMHgX5/j85Zwi9AXoeD4+n6xJOAASk7nbwkjyCGT0meXg/mcWDYOMsIJwShtaO3mWRHT/odaINCaHmAIsEHyCQOP6tHAHXFKVukSQIsxK4aPDbBnWMdG5ACAHwhUYIfgHzEwwjEXAvQFdHwCzLzc1NiC1jrgXA2I31/Ijbr1HnCEfKuRagq/N/VgXuJLzPB9wKgMBnOITJu8RuBUDXnwHvQ4FLAbDkGrnr/x8MBV7vClwKEHHWPw+vn8mdANlaf8FrL+BOgIytv+Dxs7kSAC0kY+sveOwFXAnQ5bGvbdH0A6m6uBLAw8GPTePtaFk3AmTv/gtYF/A0DLgRgKH1Fzx9VjcCIBuHBU89nRsBkKrFgqfNJm5SwpBGVc7fz/CvWKZRUsk9bS1PvzVMfI+OiiVHApAjAciRAORIAHIkADkSgBwJQI4EIEcCkCMByJEA5EgAciQAORKAHAlAjgQgRwKQIwHIkQDkSAByJAA5EoAcCUCOBCBHApAjAciRAORIAHIkADkSgBwJQI4EIOcfGjV2tEfztqEAAAAASUVORK5CYII=\" class=\"card-img-custom2\">"
			    						+ "<div style=\"padding-left: 1rem\">"
			    							+ "<span class=\"comment_span\">" + data[i].userId + "</span>"
			    							+ "<span class=\"comment_span2\">" + data[i].regDate + "</span>"
			    						+ "</div>"	
			    						+ "</div>"
			    						+ "<p class=\"comment_p\">"
			    						+ data[i].commentTxt
			    						+ "</p>"	
			    						+ "<div class=\"comment_div3\" style=\" padding-bottom: 2rem; border-bottom:1px solid #f1f3f5;\">"
			        					+ "<svg width=\"12\" height=\"12\" fill=\"none\" viewBox=\"0 0 12 12\"><path fill=\"currentColor\" d=\"M5.5 2.5h1v3h3v1h-3v3h-1v-3h-3v-1h3v-3z\"></path><path fill=\"currentColor\" fill-rule=\"evenodd\" d=\"M1 0a1 1 0 0 0-1 1v10a1 1 0 0 0 1 1h10a1 1 0 0 0 1-1V1a1 1 0 0 0-1-1H1zm10 1H1v10h10V1z\" clip-rule=\"evenodd\"></path></svg>"
			    						+ "<span style=\"margin-left:0.5rem;\" onclick=\"reReplySearchBtn("+groupNum+","+depth+")\">개의 답글</span>"	
			    						+ "</div>"
			    			);
			        	}
		        		
		        		$("#reReply_"+groupNum+"_"+depth).append("<div>"
										    						+ "<button class=\"reReply_btn\" onclick=\"reReplyWriteBtn2("+groupNum+","+(depth+1)+")\" id=\"btn_"+groupNum+"_"+depth+"\">답글 작성하기</button>"
											    				+ "</div>");
		        	}
		        	else {
		        		alert("댓글 조회 중 오류가 발생하였습니다.");
		        	}
		        },
		        error : function(XMLHttpRequest, textStatus, errorThrown){
		            alert("통신 실패.")
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